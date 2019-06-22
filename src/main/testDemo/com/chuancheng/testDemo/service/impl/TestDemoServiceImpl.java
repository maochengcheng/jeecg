package com.chuancheng.testDemo.service.impl;

import java.io.Serializable;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chuancheng.testDemo.entity.BaseEntity;
import com.chuancheng.testDemo.service.TestDemoService;
import com.jeecg.demo.entity.JeecgDemoEntity;

@Service("testDemoService")
@Transactional
public class TestDemoServiceImpl  extends CommonServiceImpl implements TestDemoService {

	@Override
	public Serializable save(BaseEntity baseEntity) throws Exception {
		Serializable t = super.save(baseEntity);
 		//执行新增操作增强业务
 		this.doAddBus(baseEntity);
 		return t;
	}
	
	@Override
	public void saveOrUpdate(BaseEntity baseEntity) throws Exception {
		super.saveOrUpdate(baseEntity);
 		//执行更新操作增强业务
 		this.doUpdateBus(baseEntity);
	}
	
	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(BaseEntity baseEntity) throws Exception{
 	
	}


	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(BaseEntity baseEntity) throws Exception{
 	}
             
}
