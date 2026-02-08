package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 我的订单
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-11-27 15:33:56
 */
@TableName("wodedingdan")
public class WodedingdanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public WodedingdanEntity() {
		
	}
	
	public WodedingdanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 设备名称
	 */
					
	private String shebeimingcheng;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 设备类型
	 */
					
	private String shebeileixing;
	
	/**
	 * 设备型号
	 */
					
	private String shebeixinghao;
	
	/**
	 * 设备位置
	 */
					
	private String shebeiweizhi;
	
	/**
	 * 故障信息
	 */
					
	private String guzhangxinxi;
	
	/**
	 * 功能
	 */
					
	private String gongneng;
	
	/**
	 * 设备详情
	 */
					
	private String shebeixiangqing;
	
	/**
	 * 用户
	 */
					
	private String yonghu;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 工号
	 */
					
	private String gonghao;
	
	/**
	 * 维修人
	 */
					
	private String weixiuren;
	
	/**
	 * 问题详情
	 */
					
	private String wentixiangqing;
	
	/**
	 * 更换零件
	 */
					
	private String genghuanlingjian;
	
	/**
	 * 维修金额
	 */
					
	private Integer weixiujine;
	

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：设备名称
	 */
	public void setShebeimingcheng(String shebeimingcheng) {
		this.shebeimingcheng = shebeimingcheng;
	}
	/**
	 * 获取：设备名称
	 */
	public String getShebeimingcheng() {
		return shebeimingcheng;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：设备类型
	 */
	public void setShebeileixing(String shebeileixing) {
		this.shebeileixing = shebeileixing;
	}
	/**
	 * 获取：设备类型
	 */
	public String getShebeileixing() {
		return shebeileixing;
	}
	/**
	 * 设置：设备型号
	 */
	public void setShebeixinghao(String shebeixinghao) {
		this.shebeixinghao = shebeixinghao;
	}
	/**
	 * 获取：设备型号
	 */
	public String getShebeixinghao() {
		return shebeixinghao;
	}
	/**
	 * 设置：设备位置
	 */
	public void setShebeiweizhi(String shebeiweizhi) {
		this.shebeiweizhi = shebeiweizhi;
	}
	/**
	 * 获取：设备位置
	 */
	public String getShebeiweizhi() {
		return shebeiweizhi;
	}
	/**
	 * 设置：故障信息
	 */
	public void setGuzhangxinxi(String guzhangxinxi) {
		this.guzhangxinxi = guzhangxinxi;
	}
	/**
	 * 获取：故障信息
	 */
	public String getGuzhangxinxi() {
		return guzhangxinxi;
	}
	/**
	 * 设置：功能
	 */
	public void setGongneng(String gongneng) {
		this.gongneng = gongneng;
	}
	/**
	 * 获取：功能
	 */
	public String getGongneng() {
		return gongneng;
	}
	/**
	 * 设置：设备详情
	 */
	public void setShebeixiangqing(String shebeixiangqing) {
		this.shebeixiangqing = shebeixiangqing;
	}
	/**
	 * 获取：设备详情
	 */
	public String getShebeixiangqing() {
		return shebeixiangqing;
	}
	/**
	 * 设置：用户
	 */
	public void setYonghu(String yonghu) {
		this.yonghu = yonghu;
	}
	/**
	 * 获取：用户
	 */
	public String getYonghu() {
		return yonghu;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：工号
	 */
	public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
	}
	/**
	 * 获取：工号
	 */
	public String getGonghao() {
		return gonghao;
	}
	/**
	 * 设置：维修人
	 */
	public void setWeixiuren(String weixiuren) {
		this.weixiuren = weixiuren;
	}
	/**
	 * 获取：维修人
	 */
	public String getWeixiuren() {
		return weixiuren;
	}
	/**
	 * 设置：问题详情
	 */
	public void setWentixiangqing(String wentixiangqing) {
		this.wentixiangqing = wentixiangqing;
	}
	/**
	 * 获取：问题详情
	 */
	public String getWentixiangqing() {
		return wentixiangqing;
	}
	/**
	 * 设置：更换零件
	 */
	public void setGenghuanlingjian(String genghuanlingjian) {
		this.genghuanlingjian = genghuanlingjian;
	}
	/**
	 * 获取：更换零件
	 */
	public String getGenghuanlingjian() {
		return genghuanlingjian;
	}
	/**
	 * 设置：维修金额
	 */
	public void setWeixiujine(Integer weixiujine) {
		this.weixiujine = weixiujine;
	}
	/**
	 * 获取：维修金额
	 */
	public Integer getWeixiujine() {
		return weixiujine;
	}

}
