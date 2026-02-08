package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.ShebeiweixiuEntity;
import com.cl.entity.view.ShebeiweixiuView;

import com.cl.service.ShebeiweixiuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 设备维修
 * 后端接口
 * @author 
 * @email 
 * @date 2024-11-27 15:33:56
 */
@RestController
@RequestMapping("/shebeiweixiu")
public class ShebeiweixiuController {
    @Autowired
    private ShebeiweixiuService shebeiweixiuService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShebeiweixiuEntity shebeiweixiu,
                                                                                                                                                                                                                            HttpServletRequest request){
                    String tableName = request.getSession().getAttribute("tableName").toString();
                                                                                                                                                                                                                                                                            if(tableName.equals("yonghu")) {
                    shebeiweixiu.setYonghu((String)request.getSession().getAttribute("username"));
                                    }
                                                                                                            if(tableName.equals("weixiugong")) {
                    shebeiweixiu.setGonghao((String)request.getSession().getAttribute("username"));
                                    }
                                                                                                                                                    EntityWrapper<ShebeiweixiuEntity> ew = new EntityWrapper<ShebeiweixiuEntity>();
                                                                                                                                                                                                                                                                                                                                                        
        
        
        PageUtils page = shebeiweixiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeiweixiu), params), params));
        return R.ok().put("data", page);
    }
    
    
    
    
    
    
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShebeiweixiuEntity shebeiweixiu, 
		HttpServletRequest request){
        EntityWrapper<ShebeiweixiuEntity> ew = new EntityWrapper<ShebeiweixiuEntity>();

		PageUtils page = shebeiweixiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeiweixiu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShebeiweixiuEntity shebeiweixiu){
       	EntityWrapper<ShebeiweixiuEntity> ew = new EntityWrapper<ShebeiweixiuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shebeiweixiu, "shebeiweixiu")); 
        return R.ok().put("data", shebeiweixiuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShebeiweixiuEntity shebeiweixiu){
        EntityWrapper< ShebeiweixiuEntity> ew = new EntityWrapper< ShebeiweixiuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shebeiweixiu, "shebeiweixiu")); 
		ShebeiweixiuView shebeiweixiuView =  shebeiweixiuService.selectView(ew);
		return R.ok("查询设备维修成功").put("data", shebeiweixiuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShebeiweixiuEntity shebeiweixiu = shebeiweixiuService.selectById(id);
		shebeiweixiu = shebeiweixiuService.selectView(new EntityWrapper<ShebeiweixiuEntity>().eq("id", id));
        return R.ok().put("data", shebeiweixiu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShebeiweixiuEntity shebeiweixiu = shebeiweixiuService.selectById(id);
		shebeiweixiu = shebeiweixiuService.selectView(new EntityWrapper<ShebeiweixiuEntity>().eq("id", id));
        return R.ok().put("data", shebeiweixiu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShebeiweixiuEntity shebeiweixiu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shebeiweixiu);
        shebeiweixiuService.insert(shebeiweixiu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShebeiweixiuEntity shebeiweixiu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shebeiweixiu);
        shebeiweixiuService.insert(shebeiweixiu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShebeiweixiuEntity shebeiweixiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeiweixiu);
        shebeiweixiuService.updateById(shebeiweixiu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shebeiweixiuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
