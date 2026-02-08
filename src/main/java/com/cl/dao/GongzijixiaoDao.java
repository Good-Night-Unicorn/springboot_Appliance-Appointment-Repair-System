package com.cl.dao;

import com.cl.entity.GongzijixiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GongzijixiaoView;


/**
 * 工资绩效
 * 
 * @author 
 * @email 
 * @date 2024-11-27 15:33:56
 */
public interface GongzijixiaoDao extends BaseMapper<GongzijixiaoEntity> {
	
	List<GongzijixiaoView> selectListView(@Param("ew") Wrapper<GongzijixiaoEntity> wrapper);

	List<GongzijixiaoView> selectListView(Pagination page,@Param("ew") Wrapper<GongzijixiaoEntity> wrapper);
	
	GongzijixiaoView selectView(@Param("ew") Wrapper<GongzijixiaoEntity> wrapper);


    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GongzijixiaoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GongzijixiaoEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GongzijixiaoEntity> wrapper);



}
