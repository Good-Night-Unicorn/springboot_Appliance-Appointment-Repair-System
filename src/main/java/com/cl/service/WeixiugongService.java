package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WeixiugongEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WeixiugongView;


/**
 * 维修工
 *
 * @author 
 * @email 
 * @date 2024-11-27 15:33:55
 */
public interface WeixiugongService extends IService<WeixiugongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeixiugongView> selectListView(Wrapper<WeixiugongEntity> wrapper);
   	
   	WeixiugongView selectView(@Param("ew") Wrapper<WeixiugongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeixiugongEntity> wrapper);
   	
   
}

