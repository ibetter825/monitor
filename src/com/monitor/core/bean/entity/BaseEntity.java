package com.monitor.core.bean.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })//@ResponseBody 报错问题处理
public class BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 获取对象修改的hql
	 * @return
	 */
	public String createUpdateHql() {
		Class clz =	this.getClass();
		System.err.println(clz.getName() + "--------name");
		return null;
	}
}
