package com.chuancheng.web.service;

import java.io.Serializable;

import org.jeecgframework.core.common.service.CommonService;

import com.chuancheng.web.entity.CcContactEntity;


public interface WebCc3Service  extends CommonService{
	public Serializable save(CcContactEntity entity) throws Exception;
	public void saveOrUpdate(CcContactEntity entity) throws Exception;
	public void delete(CcContactEntity entity) throws Exception;
             
}
