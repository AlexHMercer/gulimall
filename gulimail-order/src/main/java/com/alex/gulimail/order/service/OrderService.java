package com.alex.gulimail.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.alex.common.utils.PageUtils;
import com.alex.gulimail.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author AlexMercer
 * @email h745164733@foxmail.com
 * @date 2024-06-19 13:35:47
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

