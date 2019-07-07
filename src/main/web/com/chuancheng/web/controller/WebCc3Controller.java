package com.chuancheng.web.controller;

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
import com.chuancheng.web.entity.CcContactEntity;
import com.chuancheng.web.service.WebCc3Service;


@Controller
@RequestMapping("/webCc3Controller")
public class WebCc3Controller {

	@Autowired
	private WebCc3Service webCc3Service;
	
	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params = "contactPage")
	public ModelAndView testPage(HttpServletRequest request) {
		return new ModelAndView("com/chuancheng/web/contactList");
	}
	
	@RequestMapping(params = "datagrid")
	public void datagrid(CcContactEntity entity, HttpServletRequest request,
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
	
	/**
	 * jeecg_demo新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "contact_goAdd")
	public ModelAndView putStockAdd(CcContactEntity entity, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(entity.getId())) {
			entity = webCc3Service.getEntity(BaseEntity.class, entity.getId());
			req.setAttribute("contactPage", entity);
		}
		return new ModelAndView("com/chuancheng/web/contact_add");
	}
	
	
	/**
	 * 添加jeecg_demo
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "contact_doAdd")
	@ResponseBody
	public AjaxJson doAdd(CcContactEntity entity, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			entity.setStatus("已入库");
			webCc3Service.save(entity);
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
	@RequestMapping(params = "contact_goUpdate")
	public ModelAndView putStockUpdate(CcContactEntity entity, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(entity.getId())) {
			entity = webCc3Service.getEntity(CcContactEntity.class, entity.getId());
			req.setAttribute("contactPage", entity);
		}
		return new ModelAndView("com/chuancheng/web/contact_update");
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
