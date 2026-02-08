package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.YuyueweixiuDao;
import com.cl.entity.YuyueweixiuEntity;
import com.cl.service.YuyueweixiuService;
import com.cl.entity.view.YuyueweixiuView;

@Service("yuyueweixiuService")
public class YuyueweixiuServiceImpl extends ServiceImpl<YuyueweixiuDao, YuyueweixiuEntity> implements YuyueweixiuService {

    	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuyueweixiuEntity> page = this.selectPage(
                new Query<YuyueweixiuEntity>(params).getPage(),
                new EntityWrapper<YuyueweixiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuyueweixiuEntity> wrapper) {
		  Page<YuyueweixiuView> page =new Query<YuyueweixiuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YuyueweixiuView> selectListView(Wrapper<YuyueweixiuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuyueweixiuView selectView(Wrapper<YuyueweixiuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
	

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<YuyueweixiuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<YuyueweixiuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<YuyueweixiuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
