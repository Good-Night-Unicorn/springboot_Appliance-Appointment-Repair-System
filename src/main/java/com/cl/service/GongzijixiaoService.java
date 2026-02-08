package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.GongzijixiaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GongzijixiaoView;


/**
 * 工资绩效
 *
 * @author 
 * @email 
 * @date 2024-11-27 15:33:56
 */
public interface GongzijixiaoService extends IService<GongzijixiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GongzijixiaoView> selectListView(Wrapper<GongzijixiaoEntity> wrapper);
   	
   	GongzijixiaoView selectView(@Param("ew") Wrapper<GongzijixiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GongzijixiaoEntity> wrapper);
   	
   
    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<GongzijixiaoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<GongzijixiaoEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<GongzijixiaoEntity> wrapper);



}

