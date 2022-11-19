package com.zzxy.common.util;

import com.zzxy.common.web.ServiceException;

public class Assert {

    public static void isEmpty(boolean expreeion, String message){
        if (expreeion){
            throw new ServiceException(message);
        }
    }
}
