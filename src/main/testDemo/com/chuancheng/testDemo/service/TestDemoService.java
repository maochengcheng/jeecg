package com.chuancheng.testDemo.service;

import java.io.Serializable;

import org.jeecgframework.core.common.service.CommonService;

import com.chuancheng.testDemo.entity.BaseEntity;
import com.jeecg.demo.entity.JeecgDemoEntity;

public interface TestDemoService extends CommonService{
	public Serializable save(BaseEntity baseEntity) throws Exception;
	public void saveOrUpdate(BaseEntity baseEntity) throws Exception;
}
