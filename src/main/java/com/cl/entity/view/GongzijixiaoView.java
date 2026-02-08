package com.cl.entity.view;

import com.cl.entity.GongzijixiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 工资绩效
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-11-27 15:33:56
 */
@TableName("gongzijixiao")
public class GongzijixiaoView  extends GongzijixiaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GongzijixiaoView(){
	}
 
 	public GongzijixiaoView(GongzijixiaoEntity gongzijixiaoEntity){
 	try {
			BeanUtils.copyProperties(this, gongzijixiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}



}
