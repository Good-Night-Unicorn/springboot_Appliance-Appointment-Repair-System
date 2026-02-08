package com.cl.entity.view;

import com.cl.entity.WeixiugongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 维修工
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-11-27 15:33:55
 */
@TableName("weixiugong")
public class WeixiugongView  extends WeixiugongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WeixiugongView(){
	}
 
 	public WeixiugongView(WeixiugongEntity weixiugongEntity){
 	try {
			BeanUtils.copyProperties(this, weixiugongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}



}
