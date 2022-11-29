package com.zzxy.xc.dao;

import com.zzxy.common.entity.Cnode;
import com.zzxy.xc.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CategoryDao {
    /**
     * 查看所有参数
     * @return
     */
    List<Map<String, Object>> findObjects();

    /**
     * 查找分类id，分类名和父分类id
     * @return
     */
    List<Cnode> findZtreeCategoryCnodeId();

    /**
     * 插入分类数据
     * @param category
     * @return
     */
    Integer insertCategory(Category category);

    /**
     * 修改数据
     * @param category
     * @return
     */
    Integer updateCategory(Category category);

    /**
     * 根据父分类id查找子分类数量
     * @param menuId
     * @return
     */
    Integer getCountChildByCategoryId(Integer menuId);

    /**
     * 根据分类id删除分类数据
     * @param menuId
     * @return
     */
    Integer deleteCategoryById(Integer menuId);
}
