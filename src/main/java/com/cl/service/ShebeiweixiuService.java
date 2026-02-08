package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShebeiweixiuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShebeiweixiuView;


/**
 * 设备维修
 *
 * @author 
 * @email 
 * @date 2024-11-27 15:33:56
 */
public interface ShebeiweixiuService extends IService<ShebeiweixiuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShebeiweixiuView> selectListView(Wrapper<ShebeiweixiuEntity> wrapper);
   	
   	ShebeiweixiuView selectView(@Param("ew") Wrapper<ShebeiweixiuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShebeiweixiuEntity> wrapper);
   	
   
}

