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


import com.cl.dao.GongzijixiaoDao;
import com.cl.entity.GongzijixiaoEntity;
import com.cl.service.GongzijixiaoService;
import com.cl.entity.view.GongzijixiaoView;

@Service("gongzijixiaoService")
public class GongzijixiaoServiceImpl extends ServiceImpl<GongzijixiaoDao, GongzijixiaoEntity> implements GongzijixiaoService {

    	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GongzijixiaoEntity> page = this.selectPage(
                new Query<GongzijixiaoEntity>(params).getPage(),
                new EntityWrapper<GongzijixiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GongzijixiaoEntity> wrapper) {
		  Page<GongzijixiaoView> page =new Query<GongzijixiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<GongzijixiaoView> selectListView(Wrapper<GongzijixiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GongzijixiaoView selectView(Wrapper<GongzijixiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
	

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<GongzijixiaoEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<GongzijixiaoEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<GongzijixiaoEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
