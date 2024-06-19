package com.alex.gulimail.member.feign;

import com.alex.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/*
    Feign的远程调用：
    1. 引入相关依赖
    2. 在要调用远程服务的服务中建立一个接口
    3. 将接口标注@FeignClient注解，注解中标记要目标服务的服务名
    4. 将目标服务中的所需的方法签名贴过来，即方法注解+方法头
        注意：目标服务中的方法请求路径要写全（即若类上也有@RequestMapping注解，要把两个路径拼接）
    5. 开启远程调用功能，启动类上标注@EnableFeignClients(basePackages = "com.alex.gulimail.member.feign")
       basePackages代表这个包下都是远程调用接口
 */

@FeignClient("gulimail-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupons();
}
