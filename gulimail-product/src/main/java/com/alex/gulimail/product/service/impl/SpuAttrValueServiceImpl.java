package com.alex.gulimail.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alex.common.utils.PageUtils;
import com.alex.common.utils.Query;

import com.alex.gulimail.product.dao.SpuAttrValueDao;
import com.alex.gulimail.product.entity.SpuAttrValueEntity;
import com.alex.gulimail.product.service.SpuAttrValueService;


@Service("spuAttrValueService")
public class SpuAttrValueServiceImpl extends ServiceImpl<SpuAttrValueDao, SpuAttrValueEntity> implements SpuAttrValueService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuAttrValueEntity> page = this.page(
                new Query<SpuAttrValueEntity>().getPage(params),
                new QueryWrapper<SpuAttrValueEntity>()
        );

        return new PageUtils(page);
    }

}