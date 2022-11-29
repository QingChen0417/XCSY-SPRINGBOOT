package com.zzxy.xc.service;

import com.zzxy.common.entity.Cnode;
import com.zzxy.common.entity.Node;
import com.zzxy.xc.entity.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    /**
     * 查看所有分类数据
     * @return
     */
    List<Map<String,Object>> findObjects();

    /**
     * 树形结构参数查看
     * @return
     */
    List<Cnode> findZtreeCategoryCnodes();

    /**
     * 添加分类
     * @param category
     * @return
     */
    Integer insertCategory(Category category);

    /**
     * 修改分类数据
     * @param category
     * @return
     */
    Integer updateCategory(Category category);

    /**
     * 根据id删除分类数据
     * @param menuId
     * @return
     */
    Integer doDeleteCategoryById(Integer menuId);
}
