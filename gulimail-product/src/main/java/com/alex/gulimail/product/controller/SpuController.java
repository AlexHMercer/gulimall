package com.alex.gulimail.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alex.gulimail.product.entity.SpuEntity;
import com.alex.gulimail.product.service.SpuService;
import com.alex.common.utils.PageUtils;
import com.alex.common.utils.R;



/**
 * spu信息
 *
 * @author AlexMercer
 * @email h745164733@foxmail.com
 * @date 2024-06-16 16:31:17
 */
@RestController
@RequestMapping("product/spu")
public class SpuController {
    @Autowired
    private SpuService spuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("product:spu:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = spuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("product:spu:info")
    public R info(@PathVariable("id") Long id){
		SpuEntity spu = spuService.getById(id);

        return R.ok().put("spu", spu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("product:spu:save")
    public R save(@RequestBody SpuEntity spu){
		spuService.save(spu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("product:spu:update")
    public R update(@RequestBody SpuEntity spu){
		spuService.updateById(spu);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("product:spu:delete")
    public R delete(@RequestBody Long[] ids){
		spuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
