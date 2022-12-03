package com.zzxy.xc.controller;

import com.zzxy.common.entity.JsonResult;
import com.zzxy.common.entity.Pagination;
import com.zzxy.xc.entity.Goods;
import com.zzxy.xc.service.GoodsService;
import com.zzxy.xc.vo.GoodsCateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService service;

    /**
     * 加载页面和分页数据
     * @param name
     * @param curPage
     * @param pageSize
     * @return
     */
    @RequestMapping("findGoods")
    public JsonResult findGoods(String name,
                                @RequestParam(defaultValue = "1") Integer curPage,
                                @RequestParam(defaultValue = "0") Integer pageSize){
        Pagination pagina = service.findGoods(name, curPage, pageSize);
        return new JsonResult(pagina);
    }

    /**
     * 根据id修改商品状态
     * @param id
     * @param state
     * @return
     */
    @RequestMapping("updateValid")
    public JsonResult updateValid(Integer id, Integer state){
        service.updateValid(id,state);
        return new JsonResult("删除成功");
    }
    @RequestMapping("updateValids")
    public JsonResult updateValids(Integer id, Integer state){
        service.updateValid(id,state);
        return new JsonResult("已恢复");
    }

    /**
     * 添加商品
     * @param goods
     * @return
     */
    @RequestMapping("saveGoods")
    public JsonResult saveGoods(Goods goods){
        service.saveGoods(goods);
        System.out.println(goods);
        return new JsonResult("添加成功");
    }

    /**
     * 根据id查找类别
     * @param id
     * @return
     */
    @RequestMapping("findGoodsCateVo")
    public JsonResult findGoodsCateVo(Integer id) {
        GoodsCateVo goodsCateVo = service.findGoodsCateVo(id);
        return new JsonResult(goodsCateVo);
    }
    @RequestMapping("udpateGoods")
    public JsonResult updateGoods(Goods goods){
        service.updateGoods(goods);
        System.out.println(goods);
        return new JsonResult("修改成功");    }

    /**
     * 加载近期删除的商品信息和分页信息
     * @param name
     * @param curPage
     * @param pageSize
     * @return
     */
    @RequestMapping("deleteGoods")
    public JsonResult deleteGoods(String name,
                                  @RequestParam(defaultValue = "1") Integer curPage,
                                  @RequestParam(defaultValue = "0") Integer pageSize){
        Pagination pagina = service.deleteGoods(name, curPage, pageSize);
        return new JsonResult(pagina);
    }
}
