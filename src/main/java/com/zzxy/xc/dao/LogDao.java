package com.zzxy.xc.dao;

import com.zzxy.xc.entity.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//日志数据层
@Mapper
public interface LogDao {
	
	List<Log> findLogObject(String username);

    int doDeleteByIds(Integer[] ids);

    int insertLog(Log log);
}
