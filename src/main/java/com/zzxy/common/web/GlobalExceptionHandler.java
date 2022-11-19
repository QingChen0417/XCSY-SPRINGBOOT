package com.zzxy.common.web;

import com.zzxy.common.entity.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局异常处理类
//@ControllerAdvice//全局异常注解
@RestControllerAdvice//相当于@ControllerAdvice + @ResponseBody
public class GlobalExceptionHandler {

	//统一处理运行时异常
	@ExceptionHandler(RuntimeException.class)
	//@ResponseBody//把返回值当作数据处理
	public JsonResult handlerRuntimeException(RuntimeException e) {
		e.printStackTrace();//控制台的打印
		e = new RuntimeException("服务器繁忙");
		return new JsonResult(e);
	}
	//统一处理运行时异常
	@ExceptionHandler(ServiceException.class)
	//@ResponseBody//把返回值当作数据处理
	public JsonResult handlerServiceException(ServiceException e) {
		return new JsonResult(e);
	}
}
