package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YuyueweixiuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuyueweixiuView;


/**
 * 预约维修
 *
 * @author 
 * @email 
 * @date 2024-11-27 15:33:56
 */
public interface YuyueweixiuService extends IService<YuyueweixiuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuyueweixiuView> selectListView(Wrapper<YuyueweixiuEntity> wrapper);
   	
   	YuyueweixiuView selectView(@Param("ew") Wrapper<YuyueweixiuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuyueweixiuEntity> wrapper);
   	
   
    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<YuyueweixiuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<YuyueweixiuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<YuyueweixiuEntity> wrapper);



}

