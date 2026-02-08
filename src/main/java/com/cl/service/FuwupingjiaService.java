package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FuwupingjiaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FuwupingjiaView;


/**
 * 服务评价
 *
 * @author 
 * @email 
 * @date 2024-11-27 15:33:56
 */
public interface FuwupingjiaService extends IService<FuwupingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FuwupingjiaView> selectListView(Wrapper<FuwupingjiaEntity> wrapper);
   	
   	FuwupingjiaView selectView(@Param("ew") Wrapper<FuwupingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FuwupingjiaEntity> wrapper);
   	
   
    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<FuwupingjiaEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<FuwupingjiaEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<FuwupingjiaEntity> wrapper);



}

