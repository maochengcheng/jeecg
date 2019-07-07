package com.chuancheng.web.service.impl;

import java.io.Serializable;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chuancheng.web.entity.CcContactEntity;
import com.chuancheng.web.service.WebCc3Service;


@Service("webCc3Service")
@Transactional
public class WebCc3ServiceImpl  extends CommonServiceImpl  implements WebCc3Service{

	@Override
	public Serializable save(CcContactEntity entity) throws Exception {
		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
	}
	
	@Override
	public void saveOrUpdate(CcContactEntity entity) throws Exception {
		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
	}
	
 	public void delete(CcContactEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(CcContactEntity entity) throws Exception{
 	
	}


	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(CcContactEntity entity) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(CcContactEntity t) throws Exception{
 	}    
}
