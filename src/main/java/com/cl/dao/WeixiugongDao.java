package com.cl.dao;

import com.cl.entity.WeixiugongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WeixiugongView;


/**
 * 维修工
 * 
 * @author 
 * @email 
 * @date 2024-11-27 15:33:55
 */
public interface WeixiugongDao extends BaseMapper<WeixiugongEntity> {
	
	List<WeixiugongView> selectListView(@Param("ew") Wrapper<WeixiugongEntity> wrapper);

	List<WeixiugongView> selectListView(Pagination page,@Param("ew") Wrapper<WeixiugongEntity> wrapper);
	
	WeixiugongView selectView(@Param("ew") Wrapper<WeixiugongEntity> wrapper);


}
