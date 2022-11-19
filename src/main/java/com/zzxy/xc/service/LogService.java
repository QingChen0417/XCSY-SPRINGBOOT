package com.zzxy.xc.service;

import com.zzxy.common.entity.Pagination;

public interface LogService {

	Pagination findLogService(String username, Integer pageSize, Integer curPage);

    int doDeleteLog(Integer[] ids);
}
