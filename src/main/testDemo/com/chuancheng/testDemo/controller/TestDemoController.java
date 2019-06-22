package com.chuancheng.testDemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.p3.core.util.oConvertUtils;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chuancheng.testDemo.entity.BaseEntity;
import com.chuancheng.testDemo.service.TestDemoService;
import com.jeecg.demo.entity.JeecgDemoEntity;

@Controller
@RequestMapping("/testDemoController")
public class TestDemoController {

	@Autowired
	private TestDemoService testDemoService;
	
	@Autowired
	private SystemService systemService;
//	@Autowired
	//private TestDemoDao testDemoDao;
	/*@Autowired
	private JeecgDemoServiceI jeecgDemoService;
	@Autowired
	private JeecgMinidaoDao jeecgMinidaoDao;*/
	
	
	@RequestMapping(params = "testPage")
	public ModelAndView testPage(HttpServletRequest request) {
		return new ModelAndView("com/chuancheng/testDemo/testDemo");
	}
	
	@RequestMapping(params = "datagrid")
	public void datagrid(BaseEntity baseEntity, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BaseEntity.class, dataGrid);
		if (oConvertUtils.isNotEmpty(dataGrid.getSqlbuilder())) {
			if (dataGrid.getSqlbuilder().indexOf("≤") > 0) {
				dataGrid.setSqlbuilder(dataGrid.getSqlbuilder().replace("≤",
						"<="));
			}
		}
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				baseEntity, request.getParameterMap());
		cq.add();
		this.testDemoService.getDataGridReturn(cq, true);
	    TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * jeecg_demo新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BaseEntity baseEntity, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(baseEntity.getId())) {
			baseEntity = testDemoService.getEntity(BaseEntity.class, baseEntity.getId());
			req.setAttribute("testDemoPage", baseEntity);
		}
		return new ModelAndView("com/chuancheng/testDemo/testDemo-add");
	}
	
	
	/**
	 * 添加jeecg_demo
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BaseEntity baseEntity, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			testDemoService.save(baseEntity);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * jeecg_demo编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BaseEntity baseEntity, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(baseEntity.getId())) {
			baseEntity = testDemoService.getEntity(BaseEntity.class, baseEntity.getId());
			req.setAttribute("testDemoPage", baseEntity);
		}
		return new ModelAndView("com/chuancheng/testDemo/testDemo-update");
	}
	
	/**
	 * 更新jeecg_demo
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BaseEntity baseEntity, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		BaseEntity t = testDemoService.get(BaseEntity.class, baseEntity.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(baseEntity, t);
			testDemoService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
}
