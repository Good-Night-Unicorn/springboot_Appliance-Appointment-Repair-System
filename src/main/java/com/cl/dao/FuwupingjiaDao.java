package com.cl.dao;

import com.cl.entity.FuwupingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FuwupingjiaView;


/**
 * 服务评价
 * 
 * @author 
 * @email 
 * @date 2024-11-27 15:33:56
 */
public interface FuwupingjiaDao extends BaseMapper<FuwupingjiaEntity> {
	
	List<FuwupingjiaView> selectListView(@Param("ew") Wrapper<FuwupingjiaEntity> wrapper);

	List<FuwupingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<FuwupingjiaEntity> wrapper);
	
	FuwupingjiaView selectView(@Param("ew") Wrapper<FuwupingjiaEntity> wrapper);


    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<FuwupingjiaEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<FuwupingjiaEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<FuwupingjiaEntity> wrapper);



}
