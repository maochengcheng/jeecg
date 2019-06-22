package com.chuancheng.stock.service.impl;

import java.io.Serializable;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chuancheng.stock.entity.StockBillEntity;
import com.chuancheng.stock.service.StockBillService;
import com.jeecg.demo.entity.JeecgDemoEntity;

@Service("stockBillService")
@Transactional
public class StockBillServiceImpl  extends CommonServiceImpl  implements StockBillService{

	@Override
	public Serializable save(StockBillEntity stockBillEntity) throws Exception {
		Serializable t = super.save(stockBillEntity);
 		//执行新增操作增强业务
 		this.doAddBus(stockBillEntity);
 		return t;
	}
	
	@Override
	public void saveOrUpdate(StockBillEntity stockBillEntity) throws Exception {
		super.saveOrUpdate(stockBillEntity);
 		//执行更新操作增强业务
 		this.doUpdateBus(stockBillEntity);
	}
	
 	public void delete(StockBillEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(StockBillEntity stockBillEntity) throws Exception{
 	
	}


	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(StockBillEntity stockBillEntity) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(StockBillEntity t) throws Exception{
 	}    
}
