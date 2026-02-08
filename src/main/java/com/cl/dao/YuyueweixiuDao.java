package com.cl.dao;

import com.cl.entity.YuyueweixiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuyueweixiuView;


/**
 * 预约维修
 * 
 * @author 
 * @email 
 * @date 2024-11-27 15:33:56
 */
public interface YuyueweixiuDao extends BaseMapper<YuyueweixiuEntity> {
	
	List<YuyueweixiuView> selectListView(@Param("ew") Wrapper<YuyueweixiuEntity> wrapper);

	List<YuyueweixiuView> selectListView(Pagination page,@Param("ew") Wrapper<YuyueweixiuEntity> wrapper);
	
	YuyueweixiuView selectView(@Param("ew") Wrapper<YuyueweixiuEntity> wrapper);


    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YuyueweixiuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YuyueweixiuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YuyueweixiuEntity> wrapper);



}
