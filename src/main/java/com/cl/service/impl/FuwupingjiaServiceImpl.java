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


import com.cl.dao.FuwupingjiaDao;
import com.cl.entity.FuwupingjiaEntity;
import com.cl.service.FuwupingjiaService;
import com.cl.entity.view.FuwupingjiaView;

@Service("fuwupingjiaService")
public class FuwupingjiaServiceImpl extends ServiceImpl<FuwupingjiaDao, FuwupingjiaEntity> implements FuwupingjiaService {

    	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FuwupingjiaEntity> page = this.selectPage(
                new Query<FuwupingjiaEntity>(params).getPage(),
                new EntityWrapper<FuwupingjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FuwupingjiaEntity> wrapper) {
		  Page<FuwupingjiaView> page =new Query<FuwupingjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<FuwupingjiaView> selectListView(Wrapper<FuwupingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FuwupingjiaView selectView(Wrapper<FuwupingjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
	

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<FuwupingjiaEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<FuwupingjiaEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<FuwupingjiaEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
