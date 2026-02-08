package com.cl.dao;

import com.cl.entity.ShebeiweixiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShebeiweixiuView;


/**
 * 设备维修
 * 
 * @author 
 * @email 
 * @date 2024-11-27 15:33:56
 */
public interface ShebeiweixiuDao extends BaseMapper<ShebeiweixiuEntity> {
	
	List<ShebeiweixiuView> selectListView(@Param("ew") Wrapper<ShebeiweixiuEntity> wrapper);

	List<ShebeiweixiuView> selectListView(Pagination page,@Param("ew") Wrapper<ShebeiweixiuEntity> wrapper);
	
	ShebeiweixiuView selectView(@Param("ew") Wrapper<ShebeiweixiuEntity> wrapper);


}
