package com.chuancheng.stock.controller;

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

import com.chuancheng.stock.entity.StockBillEntity;
import com.chuancheng.stock.service.StockBillService;
import com.chuancheng.testDemo.entity.BaseEntity;
import com.jeecg.demo.entity.JeecgDemoEntity;

@Controller
@RequestMapping("/stockBillController")
public class StockBillController {

	@Autowired
	private StockBillService stockBillService;
	
	@Autowired
	private SystemService systemService;
//	@Autowired
	//private TestDemoDao testDemoDao;
	/*@Autowired
	private JeecgDemoServiceI jeecgDemoService;
	@Autowired
	private JeecgMinidaoDao jeecgMinidaoDao;*/
	
	
	@RequestMapping(params = "putStockPage")
	public ModelAndView testPage(HttpServletRequest request) {
		return new ModelAndView("com/chuancheng/stock/putStockList");
	}
	
	@RequestMapping(params = "datagrid")
	public void datagrid(StockBillEntity stockBillEntity, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(StockBillEntity.class, dataGrid);
		if (oConvertUtils.isNotEmpty(dataGrid.getSqlbuilder())) {
			if (dataGrid.getSqlbuilder().indexOf("≤") > 0) {
				dataGrid.setSqlbuilder(dataGrid.getSqlbuilder().replace("≤",
						"<="));
			}
		}
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				stockBillEntity, request.getParameterMap());
		cq.add();
		stockBillService.getDataGridReturn(cq, true);
	    TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * jeecg_demo新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "putStock_goAdd")
	public ModelAndView putStockAdd(StockBillEntity stockBillEntity, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(stockBillEntity.getId())) {
			stockBillEntity = stockBillService.getEntity(BaseEntity.class, stockBillEntity.getId());
			req.setAttribute("putStockPage", stockBillEntity);
		}
		return new ModelAndView("com/chuancheng/stock/putStock_add");
	}
	
	
	/**
	 * 添加jeecg_demo
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "puStock_doAdd")
	@ResponseBody
	public AjaxJson doAdd(StockBillEntity stockBillEntity, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			stockBillEntity.setStatus("已入库");
			stockBillService.save(stockBillEntity);
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
	@RequestMapping(params = "putStock_goUpdate")
	public ModelAndView putStockUpdate(StockBillEntity stockBillEntity, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(stockBillEntity.getId())) {
			stockBillEntity = stockBillService.getEntity(StockBillEntity.class, stockBillEntity.getId());
			req.setAttribute("stockBillPage", stockBillEntity);
		}
		return new ModelAndView("com/chuancheng/stock/putStock_update");
	}
	
	/**
	 * 更新jeecg_demo
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "putStock_doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(StockBillEntity stockBillEntity, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		StockBillEntity t = stockBillService.get(StockBillEntity.class, stockBillEntity.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(stockBillEntity, t);
			stockBillService.saveOrUpdate(t);
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
				StockBillEntity stockBill = systemService.getEntity(StockBillEntity.class, 
				id
				);
				stockBillService.delete(stockBill);
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
					StockBillEntity stockBill = systemService.getEntity(StockBillEntity.class, id);
					System.out.println(stockBill);
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
		public ModelAndView print(StockBillEntity stockBill, HttpServletRequest req) {
			// 获取部门信息
			List<TSDepart> departList = systemService.getList(TSDepart.class);
			req.setAttribute("departList", departList);

			if (StringUtil.isNotEmpty(stockBill.getId())) {
				stockBill = stockBillService.getEntity(StockBillEntity.class, stockBill.getId());
				req.setAttribute("stockBill", stockBill);
				
			}
			return new ModelAndView("com/jeecg/demo/jeecgDemo-print");
		}
}
