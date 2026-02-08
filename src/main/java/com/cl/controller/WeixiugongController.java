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

import com.cl.entity.WeixiugongEntity;
import com.cl.entity.view.WeixiugongView;

import com.cl.service.WeixiugongService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 维修工
 * 后端接口
 * @author 
 * @email 
 * @date 2024-11-27 15:33:55
 */
@RestController
@RequestMapping("/weixiugong")
public class WeixiugongController {
    @Autowired
    private WeixiugongService weixiugongService;



	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		WeixiugongEntity u = weixiugongService.selectOne(new EntityWrapper<WeixiugongEntity>().eq("gonghao", username));
        if(u==null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"weixiugong",  "维修工" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody WeixiugongEntity weixiugong){
    	//ValidatorUtils.validateEntity(weixiugong);
                            WeixiugongEntity u = weixiugongService.selectOne(new EntityWrapper<WeixiugongEntity>().eq("gonghao", weixiugong.getGonghao()));
                                                                        		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		weixiugong.setId(uId);
        weixiugongService.insert(weixiugong);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        return R.ok().put("data", weixiugongService.selectView(new EntityWrapper<WeixiugongEntity>().eq("id", id)));
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	WeixiugongEntity u = weixiugongService.selectOne(new EntityWrapper<WeixiugongEntity>().eq("gonghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        weixiugongService.updateById(u);
        return R.ok("密码已重置为：123456");
    }




    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeixiugongEntity weixiugong,
                                                                                                        HttpServletRequest request){
                                    EntityWrapper<WeixiugongEntity> ew = new EntityWrapper<WeixiugongEntity>();
                                                                                                                                                            
        
        
        PageUtils page = weixiugongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiugong), params), params));
        return R.ok().put("data", page);
    }
    
    
    
    
    
    
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WeixiugongEntity weixiugong, 
		HttpServletRequest request){
        EntityWrapper<WeixiugongEntity> ew = new EntityWrapper<WeixiugongEntity>();

		PageUtils page = weixiugongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiugong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeixiugongEntity weixiugong){
       	EntityWrapper<WeixiugongEntity> ew = new EntityWrapper<WeixiugongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weixiugong, "weixiugong")); 
        return R.ok().put("data", weixiugongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeixiugongEntity weixiugong){
        EntityWrapper< WeixiugongEntity> ew = new EntityWrapper< WeixiugongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weixiugong, "weixiugong")); 
		WeixiugongView weixiugongView =  weixiugongService.selectView(ew);
		return R.ok("查询维修工成功").put("data", weixiugongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeixiugongEntity weixiugong = weixiugongService.selectById(id);
		weixiugong = weixiugongService.selectView(new EntityWrapper<WeixiugongEntity>().eq("id", id));
        return R.ok().put("data", weixiugong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeixiugongEntity weixiugong = weixiugongService.selectById(id);
		weixiugong = weixiugongService.selectView(new EntityWrapper<WeixiugongEntity>().eq("id", id));
        return R.ok().put("data", weixiugong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WeixiugongEntity weixiugong, HttpServletRequest request){
        if(weixiugongService.selectCount(new EntityWrapper<WeixiugongEntity>().eq("gonghao", weixiugong.getGonghao()))>0) {
            return R.error("工号已存在");
        }
    	weixiugong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiugong);
        WeixiugongEntity u = weixiugongService.selectOne(new EntityWrapper<WeixiugongEntity>().eq("gonghao", weixiugong.getGonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		weixiugong.setId(new Date().getTime());
        weixiugongService.insert(weixiugong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WeixiugongEntity weixiugong, HttpServletRequest request){
        if(weixiugongService.selectCount(new EntityWrapper<WeixiugongEntity>().eq("gonghao", weixiugong.getGonghao()))>0) {
            return R.error("工号已存在");
        }
    	weixiugong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiugong);
        WeixiugongEntity u = weixiugongService.selectOne(new EntityWrapper<WeixiugongEntity>().eq("gonghao", weixiugong.getGonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		weixiugong.setId(new Date().getTime());
        weixiugongService.insert(weixiugong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WeixiugongEntity weixiugong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiugong);
        weixiugongService.updateById(weixiugong);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        weixiugongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	




    @RequestMapping("/importExcel")
    public R importExcel(@RequestParam("file") MultipartFile file){
        try {
            //获取输入流
            InputStream inputStream = file.getInputStream();
            //创建读取工作簿
            Workbook workbook = WorkbookFactory.create(inputStream);
            //获取工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获取总行
            int rows=sheet.getPhysicalNumberOfRows();
            if(rows>1){
                //获取单元格
                for (int i = 1; i < rows; i++) {
                    Row row = sheet.getRow(i);
                    WeixiugongEntity weixiugongEntity =new WeixiugongEntity();
                    weixiugongEntity.setId(new Date().getTime());
                    String gonghao = CommonUtil.getCellValue(row.getCell(0));
                    weixiugongEntity.setGonghao(gonghao);
                    String mima = CommonUtil.getCellValue(row.getCell(1));
                    weixiugongEntity.setMima(mima);
                    String weixiuren = CommonUtil.getCellValue(row.getCell(2));
                    weixiugongEntity.setWeixiuren(weixiuren);
                    String xingbie = CommonUtil.getCellValue(row.getCell(3));
                    weixiugongEntity.setXingbie(xingbie);
                    String touxiang = CommonUtil.getCellValue(row.getCell(4));
                    weixiugongEntity.setTouxiang(touxiang);
                    String nianling = CommonUtil.getCellValue(row.getCell(5));
                    weixiugongEntity.setNianling(Integer.parseInt(nianling));
                     
                    //想数据库中添加新对象
                    weixiugongService.insert(weixiugongEntity);//方法
                }
            }
            inputStream.close();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok("导入成功");
    }





}
