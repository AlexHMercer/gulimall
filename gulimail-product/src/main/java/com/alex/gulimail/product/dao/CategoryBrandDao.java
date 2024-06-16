package com.alex.gulimail.product.dao;

import com.alex.gulimail.product.entity.CategoryBrandEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌分类关联
 * 
 * @author AlexMercer
 * @email h745164733@foxmail.com
 * @date 2024-06-16 16:31:17
 */
@Mapper
public interface CategoryBrandDao extends BaseMapper<CategoryBrandEntity> {
	
}
