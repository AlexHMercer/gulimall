package com.alex.gulimail.product.dao;

import com.alex.gulimail.product.entity.CommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价
 * 
 * @author AlexMercer
 * @email h745164733@foxmail.com
 * @date 2024-06-16 16:31:17
 */
@Mapper
public interface CommentDao extends BaseMapper<CommentEntity> {
	
}
