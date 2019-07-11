package com.chuancheng.web.controller;

import java.util.Date;
import java.util.List;

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
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chuancheng.testDemo.entity.BaseEntity;
import com.chuancheng.web.entity.AjaxCcJson;
import com.chuancheng.web.entity.CcAboutEntity;
import com.chuancheng.web.entity.CcCaseEntity;
import com.chuancheng.web.entity.CcContactEntity;
import com.chuancheng.web.entity.CcNewsEntity;
import com.chuancheng.web.service.WebCc3Service;


@Controller
@RequestMapping("/webCc3Controller")
public class WebCc3Controller {

	@Autowired
	private WebCc3Service webCc3Service;
	
	@Autowired
	private SystemService systemService;
	/**
	 * 留言板跳转
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "contactPage")
	public ModelAndView contactPage(HttpServletRequest request) {
		return new ModelAndView("com/chuancheng/web/contactList");
	}
	/**
	 * 新闻跳转
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "newsPage")
	public ModelAndView newsPage(HttpServletRequest request) {
		return new ModelAndView("com/chuancheng/web/newsList");
	}
	/**
	 * 新闻跳转
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "casePage")
	public ModelAndView casePage(HttpServletRequest request) {
		return new ModelAndView("com/chuancheng/web/caseList");
	}
	/**
	 * 新闻跳转
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "aboutPage")
	public ModelAndView aboutPage(HttpServletRequest request) {
		return new ModelAndView("com/chuancheng/web/aboutList");
	}
	
	@RequestMapping(params = "contactdatagrid")
	public void contactdatagrid(CcContactEntity entity, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CcContactEntity.class, dataGrid);
		if (oConvertUtils.isNotEmpty(dataGrid.getSqlbuilder())) {
			if (dataGrid.getSqlbuilder().indexOf("≤") > 0) {
				dataGrid.setSqlbuilder(dataGrid.getSqlbuilder().replace("≤",
						"<="));
			}
		}
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				entity, request.getParameterMap());
		cq.add();
		webCc3Service.getDataGridReturn(cq, true);
	    TagUtil.datagrid(response, dataGrid);
	}
	
	@RequestMapping(params = "newsdatagrid")
	@ResponseBody
	public void newsdatagrid(CcNewsEntity entity, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CcNewsEntity.class, dataGrid);
		if (oConvertUtils.isNotEmpty(dataGrid.getSqlbuilder())) {
			if (dataGrid.getSqlbuilder().indexOf("≤") > 0) {
				dataGrid.setSqlbuilder(dataGrid.getSqlbuilder().replace("≤",
						"<="));
			}
		}
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				entity, request.getParameterMap());
		cq.add();
		webCc3Service.getDataGridReturn(cq, true);
	    TagUtil.datagrid(response, dataGrid);
	}
	
	@RequestMapping(params = "casedatagrid")
	@ResponseBody
	public void casedatagrid(CcCaseEntity entity, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CcCaseEntity.class, dataGrid);
		if (oConvertUtils.isNotEmpty(dataGrid.getSqlbuilder())) {
			if (dataGrid.getSqlbuilder().indexOf("≤") > 0) {
				dataGrid.setSqlbuilder(dataGrid.getSqlbuilder().replace("≤",
						"<="));
			}
		}
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				entity, request.getParameterMap());
		cq.add();
		webCc3Service.getDataGridReturn(cq, true);
	    TagUtil.datagrid(response, dataGrid);
	}
	
	@RequestMapping(params = "aboutdatagrid")
	@ResponseBody
	public void aboutdatagrid(CcAboutEntity entity, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CcAboutEntity.class, dataGrid);
		if (oConvertUtils.isNotEmpty(dataGrid.getSqlbuilder())) {
			if (dataGrid.getSqlbuilder().indexOf("≤") > 0) {
				dataGrid.setSqlbuilder(dataGrid.getSqlbuilder().replace("≤",
						"<="));
			}
		}
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				entity, request.getParameterMap());
		cq.add();
		webCc3Service.getDataGridReturn(cq, true);
	    TagUtil.datagrid(response, dataGrid);
	}
	/**
	 * 新闻查询
	 * @param entity
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @return
	 */
	@RequestMapping(params = "web_newsdatagrid")
	@ResponseBody
	public DataGrid web_newsdatagrid(CcNewsEntity entity, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(CcNewsEntity.class, dataGrid);
		if (oConvertUtils.isNotEmpty(dataGrid.getSqlbuilder())) {
			if (dataGrid.getSqlbuilder().indexOf("≤") > 0) {
				dataGrid.setSqlbuilder(dataGrid.getSqlbuilder().replace("≤",
						"<="));
			}
		}
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				entity, request.getParameterMap());
		cq.add();
		webCc3Service.getDataGridReturn(cq, true);
	    return dataGrid;
	}
	/**
	 * 留言板新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "contact_goAdd")
	public ModelAndView contact_goAdd(CcContactEntity entity, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(entity.getId())) {
			entity = webCc3Service.getEntity(BaseEntity.class, entity.getId());
			req.setAttribute("contactPage", entity);
		}
		return new ModelAndView("com/chuancheng/web/contact_add");
	}
	/**
	 * 新闻新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "news_goAdd")
	public ModelAndView news_goAdd(CcNewsEntity entity, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(entity.getId())) {
			entity = webCc3Service.getEntity(BaseEntity.class, entity.getId());
			req.setAttribute("contactPage", entity);
		}
		return new ModelAndView("com/chuancheng/web/news_add");
	}
	/**
	 * 新闻新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "case_goAdd")
	public ModelAndView case_goAdd(CcCaseEntity entity, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(entity.getId())) {
			entity = webCc3Service.getEntity(BaseEntity.class, entity.getId());
			req.setAttribute("casePage", entity);
		}
		return new ModelAndView("com/chuancheng/web/case_add");
	}
	/**
	 * 新闻新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "about_goAdd")
	public ModelAndView about_goAdd(CcAboutEntity entity, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(entity.getId())) {
			entity = webCc3Service.getEntity(BaseEntity.class, entity.getId());
			req.setAttribute("aboutPage", entity);
		}
		return new ModelAndView("com/chuancheng/web/about_add");
	}
	/**
	 * 添加jeecg_demo
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "contact_doAdd")
	@ResponseBody
	public AjaxCcJson contact_doAdd(CcContactEntity entity, HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Cache-Control", "public,max-age=3600");
		String message = null;
		AjaxCcJson j = new AjaxCcJson();
		message = "添加成功";
		try{
			entity.setStatus("已入库");
			webCc3Service.save(entity);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			j.setStatus("1");
		}catch(Exception e){
			e.printStackTrace();
			message = "添加失败";
			j.setStatus("0");
			throw new BusinessException(e.getMessage());
		}
		j.setUrl("index.html");
		j.setMsg(message);
		return j;
	}
	/**
	 * 添加jeecg_demo
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "news_doAdd")
	@ResponseBody
	public AjaxCcJson news_doAdd(CcNewsEntity entity, HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Cache-Control", "public,max-age=3600");
		String message = null;
		AjaxCcJson j = new AjaxCcJson();
		entity.setCreateTime(new Date());
		message = "添加成功";
		try{
			entity.setStatus("已入库");
			webCc3Service.save(entity);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			j.setStatus("1");
		}catch(Exception e){
			e.printStackTrace();
			message = "添加失败";
			j.setStatus("0");
			throw new BusinessException(e.getMessage());
		}
		j.setUrl("index.html");
		j.setMsg(message);
		return j;
	}
	/**
	 * 添加jeecg_demo
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "case_doAdd")
	@ResponseBody
	public AjaxCcJson case_doAdd(CcCaseEntity entity, HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Cache-Control", "public,max-age=3600");
		String message = null;
		AjaxCcJson j = new AjaxCcJson();
		entity.setCreateTime(new Date());
		message = "添加成功";
		try{
			entity.setStatus("1");
			webCc3Service.save(entity);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			j.setStatus("1");
		}catch(Exception e){
			e.printStackTrace();
			message = "添加失败";
			j.setStatus("0");
			throw new BusinessException(e.getMessage());
		}
		j.setUrl("index.html");
		j.setMsg(message);
		return j;
	}
	/**
	 * 添加jeecg_demo
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "about_doAdd")
	@ResponseBody
	public AjaxCcJson about_doAdd(CcAboutEntity entity, HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Cache-Control", "public,max-age=3600");
		String message = null;
		AjaxCcJson j = new AjaxCcJson();
		entity.setCreateTime(new Date());
		message = "添加成功";
		try{
			entity.setStatus("1");
			webCc3Service.save(entity);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			j.setStatus("1");
		}catch(Exception e){
			e.printStackTrace();
			message = "添加失败";
			j.setStatus("0");
			throw new BusinessException(e.getMessage());
		}
		j.setUrl("index.html");
		j.setMsg(message);
		return j;
	}
	/**
	 * 留言板编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "contact_goUpdate")
	public ModelAndView contact_goUpdate(CcContactEntity entity, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(entity.getId())) {
			entity = webCc3Service.getEntity(CcContactEntity.class, entity.getId());
			req.setAttribute("contactPage", entity);
		}
		return new ModelAndView("com/chuancheng/web/contact_update");
	}
	/**
	 * 留言板编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "news_goUpdate")
	public ModelAndView news_goUpdate(CcNewsEntity entity, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(entity.getId())) {
			entity = webCc3Service.getEntity(CcNewsEntity.class, entity.getId());
			req.setAttribute("newsPage", entity);
		}
		return new ModelAndView("com/chuancheng/web/news_update");
	}
	/**
	 * 更新jeecg_demo
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "contact_doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CcContactEntity entity, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		CcContactEntity t = webCc3Service.get(CcContactEntity.class, entity.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(entity, t);
			webCc3Service.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 批量删除jeecg_demo
	 * 
	 * @return
	 */
	 @RequestMapping(params = "putStock_doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "删除成功";
		try{
			for(String id:ids.split(",")){
				CcContactEntity entity = systemService.getEntity(CcContactEntity.class, 
				id
				);
				webCc3Service.delete(entity);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	 /**
		 * 批量预出库
		 * 
		 * @return
		 */
		 @RequestMapping(params = "putStock_doBatchUpdate")
		@ResponseBody
		public AjaxJson doBatchUpdate(String ids,HttpServletRequest request){
			String message = null;
			AjaxJson j = new AjaxJson();
			message = "删除成功";
			try{
				for(String id:ids.split(",")){
					CcContactEntity entity = systemService.getEntity(CcContactEntity.class, id);
					System.out.println(entity);
					//stockBillService.delete(stockBill);
					systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
				}
			}catch(Exception e){
				e.printStackTrace();
				message = "删除失败";
				throw new BusinessException(e.getMessage());
			}
			j.setMsg(message);
			return j;
		}
	 /**
		 * JeecgDemo 打印预览跳转
		 * @param jeecgDemo
		 * @param req
		 * @return
		 */
		@RequestMapping(params = "print")
		public ModelAndView print(CcContactEntity entity, HttpServletRequest req) {
			// 获取部门信息
			List<TSDepart> departList = systemService.getList(TSDepart.class);
			req.setAttribute("departList", departList);

			if (StringUtil.isNotEmpty(entity.getId())) {
				entity = webCc3Service.getEntity(CcContactEntity.class, entity.getId());
				req.setAttribute("contact", entity);
				
			}
			return new ModelAndView("com/jeecg/demo/jeecgDemo-print");
		}
}
