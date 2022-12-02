package com.zzxy.xc.controller.aspect;

import com.zzxy.common.annotation.RequirdLog;
import com.zzxy.common.util.IPUtils;
import com.zzxy.common.util.ShiroUtil;
import com.zzxy.xc.entity.Log;
import com.zzxy.xc.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

//切面类
@Aspect
@Component
@Slf4j
public class LogAspcet {
    @Autowired
    private LogService logService;

    @Pointcut("bean(UserServiceImpl)")
    public void logPointCut() {}
    @Pointcut("@annotation(com.zzxy.common.annotation.RequirdLog)")
    public void saveLog() {}


    @Around("saveLog()")//经过分析，保存日志用细粒度的切入点
    public Object saveLog(ProceedingJoinPoint jp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object result = jp.proceed();//调用目标方法, 或者跳入下一个切入点
        long end = System.currentTimeMillis();
        insertLog(end - begin, jp);
        return result;
    }

    /**
     * 保存日志
     * @param time
     * @param jp
     * @throws NoSuchMethodException
     * @throws Exception
     */
    private void insertLog(long time, ProceedingJoinPoint jp) throws NoSuchMethodException, Exception {
        //获取方法的签名:包含了方法的签名信息
        //MethodSignature是signature的儿子，是向下造型，需要强转
        //jdk获取方法签名是接口的，CGlTB获取方法签名是实现类的
        //原因：jdk动态代理是实现接口的，CGLTB是继承实现类的
        MethodSignature ms = (MethodSignature) jp.getSignature();
        //获取目标方法，这种方法jdk动态代理获取的是接口的方法，不能用
        //Method method = ms.getMethod();//获取目标方法
        Object obj = jp.getTarget();//获取目标对象
        Class<?> clz = obj.getClass();//获取类对象
        //反射获取指定方法，第一个参数为方法名，第二个参数为参数类型
        Method method = clz.getDeclaredMethod(ms.getName(), ms.getParameterTypes());
        String name = method.getName();//获取方法名
        //获取类型，jdk动态代理获取的是接口方法的类型
        //String type = ms.getDeclaringTypeName();//获取类型
        String type = clz.getName();
        String methodName = type+"."+name;
        Object[] args = jp.getArgs();//获取参数的方法
        String argsStr = Arrays.toString(args);
        String ip = IPUtils.getIpAddr();
        //获取指定类型的注解
        RequirdLog logStr = method.getAnnotation(RequirdLog.class);
        String operation = logStr.value();
        Log log =new Log();
        log.setIp(ip);
        log.setCreatedTime(new Date());//设置创建日期
        log.setMethod(methodName);//设置方法全名
        log.setOperation(operation);//设置操作
        log.setTime(time);//设置方法执行度
        log.setUsername(ShiroUtil.getUsername());
        log.setParams(argsStr);
        logService.insertLog(log);
    }
}
