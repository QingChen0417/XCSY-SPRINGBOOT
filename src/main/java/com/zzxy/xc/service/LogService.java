package com.zzxy.xc.service;

import com.zzxy.common.entity.Pagination;
import com.zzxy.xc.entity.Log;

public interface LogService {

	Pagination findLogService(String username, Integer pageSize, Integer curPage);

    int doDeleteLog(Integer[] ids);

    void insertLog(Log log);
}
