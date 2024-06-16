package com.alex.gulimail.product;

import com.alex.gulimail.product.entity.BrandEntity;
import com.alex.gulimail.product.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GulimailProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
//        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setId(4L);
//        brandEntity.setName("HUAWEI");

//        brandEntity.setName("华为");
//        brandService.save(brandEntity);
//        System.out.println("保存成功");

//        brandService.updateById(brandEntity);
//        System.out.println("修改成功");
        List<BrandEntity> idList = brandService.list(new QueryWrapper<BrandEntity>().eq("id", 1L));
        idList.forEach((item)->{
            System.out.println(item);
        });
    }

}
