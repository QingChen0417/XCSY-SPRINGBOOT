package com.zzxy.xc.dao;

import com.zzxy.xc.entity.Goods;
import com.zzxy.xc.vo.GoodsCateVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsDao {

    /**
     * 加载商品信息
     * @param name
     * @return
     */
    List<Goods> findGoods(String name);

    /**
     * 修改商品状态
     * @param id
     * @param state
     * @return
     */
    @Update("update xc_goods set state=#{state} where id=#{id}")
    Integer updateValid(@Param("id")Integer id, @Param("state")Integer state);

    /**
     * 添加商品
     * @param goods
     * @return
     */
    Integer saveGoods(Goods goods);

    /**
     * 根据商品id查找商品类别信息
     * @param id
     * @return
     */
     GoodsCateVo findGoodsCateVo(Integer id);

     @Update("update xc_goods set cateid=#{cateid}, name=#{name}, subtitle=#{subtitle}," +
             "imgUrl=#{imgUrl}, price=#{price}, stock=#{stock},state=#{state},modifiedTime=now(),modifiedUser=#{modifiedUser} where id = #{id}")
    Integer updateGoods(Goods goods);

    /**
     * 根据商品id查找商品名
     * @param id
     * @return
     */
     @Select("select * from xc_goods where id=#{id}")
     Goods finGoodsById(Integer id);
}
