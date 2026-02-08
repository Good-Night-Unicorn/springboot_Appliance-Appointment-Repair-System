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


import com.cl.dao.ShebeiweixiuDao;
import com.cl.entity.ShebeiweixiuEntity;
import com.cl.service.ShebeiweixiuService;
import com.cl.entity.view.ShebeiweixiuView;

@Service("shebeiweixiuService")
public class ShebeiweixiuServiceImpl extends ServiceImpl<ShebeiweixiuDao, ShebeiweixiuEntity> implements ShebeiweixiuService {

    	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShebeiweixiuEntity> page = this.selectPage(
                new Query<ShebeiweixiuEntity>(params).getPage(),
                new EntityWrapper<ShebeiweixiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShebeiweixiuEntity> wrapper) {
		  Page<ShebeiweixiuView> page =new Query<ShebeiweixiuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShebeiweixiuView> selectListView(Wrapper<ShebeiweixiuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShebeiweixiuView selectView(Wrapper<ShebeiweixiuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
	


}
