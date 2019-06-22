package com.chuancheng.testDemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @Title: Entity
 * @Description: 基础类别表
 * @author WMQ
 * @date 2018-05-24 10:58:00
 * @version V1.0
 */

@Entity
@Table(name = "cc_base", schema = "")
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private java.lang.String id; // 主键
	private java.lang.String jNo; // 编号
	private java.lang.String jName; // 用户名
	private java.util.Date jSaveDate; // 存储时间
	private java.util.Date jUpdateDate; // 修改时间
	private java.lang.String jAgriTypeName; // 农业名称
	private Integer jTypeId; // 分类级别
	private java.lang.Long jParentId;// 父类id

	/**
	 * 方法: 取得java.lang.String
	 * @return: java.lang.String id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "id", nullable = false, length = 20)
	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	@Column(name = "j_no", nullable = false, length = 50)
	public java.lang.String getjNo() {
		return jNo;
	}

	public void setjNo(java.lang.String jNo) {
		this.jNo = jNo;
	}

	@Column(name = "j_name", nullable = false, length = 255)
	public java.lang.String getjName() {
		return jName;
	}

	public void setjName(java.lang.String jName) {
		this.jName = jName;
	}

	@Column(name ="j_saveDate",nullable=true)
	public java.util.Date getjSaveDate() {
		return jSaveDate;
	}

	public void setjSaveDate(java.util.Date jSaveDate) {
		this.jSaveDate = jSaveDate;
	}

	@Column(name ="j_updateDate",nullable=true)
	public java.util.Date getjUpdateDate() {
		return jUpdateDate;
	}

	public void setjUpdateDate(java.util.Date jUpdateDate) {
		this.jUpdateDate = jUpdateDate;
	}

	@Column(name = "j_agriTypeName", nullable = false, length = 255)
	public java.lang.String getjAgriTypeName() {
		return jAgriTypeName;
	}

	public void setjAgriTypeName(java.lang.String jAgriTypeName) {
		this.jAgriTypeName = jAgriTypeName;
	}

	@Column(name = "j_typeId", nullable = false, length = 5)
	public Integer getjTypeId() {
		return jTypeId;
	}

	public void setjTypeId(Integer jTypeId) {
		this.jTypeId = jTypeId;
	}
    
	@Column(name = "j_parentId", nullable = false, length = 20)
	public java.lang.Long getjParentId() {
		return jParentId;
	}

	public void setjParentId(java.lang.Long jParentId) {
		this.jParentId = jParentId;
	}
	
	


}
