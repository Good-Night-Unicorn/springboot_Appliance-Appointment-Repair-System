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


import com.cl.dao.WeixiugongDao;
import com.cl.entity.WeixiugongEntity;
import com.cl.service.WeixiugongService;
import com.cl.entity.view.WeixiugongView;

@Service("weixiugongService")
public class WeixiugongServiceImpl extends ServiceImpl<WeixiugongDao, WeixiugongEntity> implements WeixiugongService {

    	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeixiugongEntity> page = this.selectPage(
                new Query<WeixiugongEntity>(params).getPage(),
                new EntityWrapper<WeixiugongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeixiugongEntity> wrapper) {
		  Page<WeixiugongView> page =new Query<WeixiugongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<WeixiugongView> selectListView(Wrapper<WeixiugongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeixiugongView selectView(Wrapper<WeixiugongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
	


}
