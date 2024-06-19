package com.alex.gulimail.coupon.dao;

import com.alex.gulimail.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author AlexMercer
 * @email h745164733@foxmail.com
 * @date 2024-06-19 13:08:04
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
