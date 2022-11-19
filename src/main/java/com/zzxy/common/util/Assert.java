package com.zzxy.common.util;

import com.zzxy.common.web.ServiceException;

//工具类，检测条件是否符合规则
public class Assert {
    public static void isEmpty(boolean express,String message) {
        if (express) {
            throw new ServiceException(message);
        }
    }
}
