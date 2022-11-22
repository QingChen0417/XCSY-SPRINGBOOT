package com.zzxy.xc.service.impl;

import com.zzxy.common.util.Assert;
import com.zzxy.xc.dao.MenuDao;
import com.zzxy.xc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MenuServiceimpl implements MenuService {

    @Autowired
    private MenuDao dao;

    public List<Map<String, Object>> findObjects() {
        List<Map<String,Object>> list = dao.findObjects();
        Assert.isEmpty(list == null || list.size() == 0, "菜单不存在");
        return list;
    }
}
