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

import com.cl.entity.GongzijixiaoEntity;
import com.cl.entity.view.GongzijixiaoView;

import com.cl.service.GongzijixiaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 工资绩效
 * 后端接口
 * @author 
 * @email 
 * @date 2024-11-27 15:33:56
 */
@RestController
@RequestMapping("/gongzijixiao")
public class GongzijixiaoController {
    @Autowired
    private GongzijixiaoService gongzijixiaoService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GongzijixiaoEntity gongzijixiao,
                                                                                                        HttpServletRequest request){
                    String tableName = request.getSession().getAttribute("tableName").toString();
                                            if(tableName.equals("weixiugong")) {
                    gongzijixiao.setGonghao((String)request.getSession().getAttribute("username"));
                                    }
                                                                                                                                                                                                            EntityWrapper<GongzijixiaoEntity> ew = new EntityWrapper<GongzijixiaoEntity>();
                                                                                                                                                            
        
        
        PageUtils page = gongzijixiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzijixiao), params), params));
        return R.ok().put("data", page);
    }
    
    
    
    
    
    
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GongzijixiaoEntity gongzijixiao, 
		HttpServletRequest request){
        EntityWrapper<GongzijixiaoEntity> ew = new EntityWrapper<GongzijixiaoEntity>();

		PageUtils page = gongzijixiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzijixiao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GongzijixiaoEntity gongzijixiao){
       	EntityWrapper<GongzijixiaoEntity> ew = new EntityWrapper<GongzijixiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongzijixiao, "gongzijixiao")); 
        return R.ok().put("data", gongzijixiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GongzijixiaoEntity gongzijixiao){
        EntityWrapper< GongzijixiaoEntity> ew = new EntityWrapper< GongzijixiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongzijixiao, "gongzijixiao")); 
		GongzijixiaoView gongzijixiaoView =  gongzijixiaoService.selectView(ew);
		return R.ok("查询工资绩效成功").put("data", gongzijixiaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GongzijixiaoEntity gongzijixiao = gongzijixiaoService.selectById(id);
		gongzijixiao = gongzijixiaoService.selectView(new EntityWrapper<GongzijixiaoEntity>().eq("id", id));
        return R.ok().put("data", gongzijixiao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GongzijixiaoEntity gongzijixiao = gongzijixiaoService.selectById(id);
		gongzijixiao = gongzijixiaoService.selectView(new EntityWrapper<GongzijixiaoEntity>().eq("id", id));
        return R.ok().put("data", gongzijixiao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GongzijixiaoEntity gongzijixiao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(gongzijixiao);
        gongzijixiaoService.insert(gongzijixiao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GongzijixiaoEntity gongzijixiao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(gongzijixiao);
        gongzijixiaoService.insert(gongzijixiao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GongzijixiaoEntity gongzijixiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongzijixiao);
        gongzijixiaoService.updateById(gongzijixiao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gongzijixiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	





    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<GongzijixiaoEntity> ew = new EntityWrapper<GongzijixiaoEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("weixiugong")) {
            ew.eq("gonghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = gongzijixiaoService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<GongzijixiaoEntity> ew = new EntityWrapper<GongzijixiaoEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("weixiugong")) {
            ew.eq("gonghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = gongzijixiaoService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<GongzijixiaoEntity> ew = new EntityWrapper<GongzijixiaoEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("weixiugong")) {
            ew.eq("gonghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = gongzijixiaoService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<GongzijixiaoEntity> ew = new EntityWrapper<GongzijixiaoEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("weixiugong")) {
            ew.eq("gonghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = gongzijixiaoService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<GongzijixiaoEntity> ew = new EntityWrapper<GongzijixiaoEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("weixiugong")) {
            ew.eq("gonghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = gongzijixiaoService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,GongzijixiaoEntity gongzijixiao, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("weixiugong")) {
            gongzijixiao.setGonghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<GongzijixiaoEntity> ew = new EntityWrapper<GongzijixiaoEntity>();
        int count = gongzijixiaoService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzijixiao), params), params));
        return R.ok().put("data", count);
    }



}
