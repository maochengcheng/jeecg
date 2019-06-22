package com.chuancheng.stock.service;

import java.io.Serializable;

import org.jeecgframework.core.common.service.CommonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chuancheng.stock.entity.StockBillEntity;
import com.jeecg.demo.entity.JeecgDemoEntity;


public interface StockBillService  extends CommonService{
	public Serializable save(StockBillEntity stockBillEntity) throws Exception;
	public void saveOrUpdate(StockBillEntity stockBillEntity) throws Exception;
	public void delete(StockBillEntity entity) throws Exception;
             
}
