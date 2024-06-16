package com.alex.gulimail.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 品牌
 * 
 * @author AlexMercer
 * @email h745164733@foxmail.com
 * @date 2024-06-16 16:31:17
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	private Long id;
	/**
	 * 品牌名
	 */
	private String name;
	/**
	 * 品牌logo
	 */
	private String logo;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	private Integer status;
	/**
	 * 检索首字母
	 */
	private String firstLetter;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 备注
	 */
	private String remark;

}
