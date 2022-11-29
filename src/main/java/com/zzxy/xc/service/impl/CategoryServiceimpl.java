package com.zzxy.xc.service.impl;

import com.zzxy.common.entity.Cnode;
import com.zzxy.common.util.Assert;
import com.zzxy.xc.dao.CategoryDao;
import com.zzxy.xc.entity.Category;
import com.zzxy.xc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceimpl implements CategoryService {

    @Autowired
    private CategoryDao dao;

    public List<Map<String, Object>> findObjects() {
        List<Map<String,Object>> list = dao.findObjects();
        Assert.isEmpty(list == null || list.size() == 0, "分类数据不存在");
        return list;
    }
    public List<Cnode> findZtreeCategoryCnodes() {
        List<Cnode> list = dao.findZtreeCategoryCnodeId();
        Assert.isEmpty(list == null || list.size() == 0, "分类不存在!");
        return list;
    }
    public Integer insertCategory(Category category) {
        Assert.isEmpty(category==null||category.getName()==null, "分类不存在！");
        Integer n = dao.insertCategory(category);
        Assert.isEmpty(n==0, "分类添加不存在！");
        return n;
    }
    public Integer updateCategory(Category category) {
        Assert.isEmpty(category==null||category.getName()==null, "请填写数据！");
        Integer r = dao.updateCategory(category);
        Assert.isEmpty(r==0, "分类修改失败或者数据不存在！");
        return r;
    }
    public Integer doDeleteCategoryById(Integer menuId) {
        //1，查看当前分类id的子分类数量
        Integer n = dao.getCountChildByCategoryId(menuId);
        //2：如果子分类数量大于0则直接抛出异常
        Assert.isEmpty(n > 0, "有子分类不允许删除！");
        //3：之后根据该id删除分类
        Integer t =dao.deleteCategoryById(menuId);
        Assert.isEmpty(t==0, "分类可能已被删除！");
        return t;
    }
}
