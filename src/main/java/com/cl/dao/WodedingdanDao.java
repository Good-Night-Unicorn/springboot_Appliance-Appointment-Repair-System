package com.cl.dao;

import com.cl.entity.WodedingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WodedingdanView;


/**
 * 我的订单
 * 
 * @author 
 * @email 
 * @date 2024-11-27 15:33:56
 */
public interface WodedingdanDao extends BaseMapper<WodedingdanEntity> {
	
	List<WodedingdanView> selectListView(@Param("ew") Wrapper<WodedingdanEntity> wrapper);

	List<WodedingdanView> selectListView(Pagination page,@Param("ew") Wrapper<WodedingdanEntity> wrapper);
	
	WodedingdanView selectView(@Param("ew") Wrapper<WodedingdanEntity> wrapper);


}
