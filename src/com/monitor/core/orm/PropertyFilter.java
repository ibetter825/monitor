package com.monitor.core.orm;

import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import com.google.common.collect.Sets;
import com.monitor.core.utils.ReflectionUtils;

/**
 * 与具体ORM实现无关的属性过滤条件封装类. <br>
 * PropertyFilter主要记录页面中简单的搜索过滤条件,比Hibernate的Criterion要简单.
 * 
 * @author vashon
 */
public class PropertyFilter {
	/** 多个属性间OR关系的分隔符. */
	public static final String OR_SEPARATOR = "_OR_";

	/** 属性比较类型. */
	public enum MatchType {
		EQ, LIKE, LT, GT, LE, GE, IN, ILIKE, NEQ, ISNULL, ISNOTNULL, ;
	}

	/** 属性比较类型. */
	public enum OrderType {
		ASC, DESC;
	}

	/** 属性数据类型. */
	public enum PropertyType {
		S(String.class), I(Integer.class), L(Long.class), N(Double.class), D(Date.class), B(Boolean.class);

		private Class<?> clazz;

		PropertyType(Class<?> clazz) {
			this.clazz = clazz;
		}

		public Class<?> getValue() {
			return clazz;
		}
	}

	private String[] propertyNames = null;
	private Class<?> propertyType = null;
	private Object propertyValue = null;
	private MatchType matchType = null;
	/**
	 * 只适用于in条件的数组
	 */
	private Object[] propertyArray = null;

	public PropertyFilter(final String[] propertyNames, final MatchType matchType, final Object propertyValue) {
		this.propertyNames = propertyNames;
		this.matchType = matchType;
		this.propertyValue = propertyValue;
	}

	public PropertyFilter(final String propertyName, final MatchType matchType, final Object propertyValue) {
		this.propertyNames = new String[] { propertyName };
		this.matchType = matchType;
		this.propertyValue = propertyValue;
	}

	public PropertyFilter(final String propertyName, final MatchType matchType, final Object[] propertyArray) {
		this.propertyNames = new String[] { propertyName };
		this.matchType = matchType;
		this.propertyArray = propertyArray;

	}

	public PropertyFilter() {
	}

	/**
	 * @param filterName
	 *            比较属性字符串,含待比较的比较类型、属性值类型及属性列表. eg. LIKES_NAME_OR_LOGIN_NAME
	 * @param value
	 *            待比较的值.
	 */
	public PropertyFilter(final String filterName, final String value) {

		String matchTypeStr = StringUtils.substringBefore(filterName, "_");
		String matchTypeCode = StringUtils.substring(matchTypeStr, 0, matchTypeStr.length() - 1);
		String propertyTypeCode = StringUtils.substring(matchTypeStr, matchTypeStr.length() - 1, matchTypeStr.length());
		try {
			matchType = Enum.valueOf(MatchType.class, matchTypeCode);
		} catch (RuntimeException e) {
			throw new IllegalArgumentException("filter名称" + filterName + "没有按规则编写,无法得到属性比较类型.", e);
		}

		try {
			propertyType = Enum.valueOf(PropertyType.class, propertyTypeCode).getValue();
		} catch (RuntimeException e) {
			throw new IllegalArgumentException("filter名称" + filterName + "没有按规则编写,无法得到属性值类型.", e);
		}

		String propertyNameStr = StringUtils.substringAfter(filterName, "_");
		propertyNames = propertyNameStr.replaceAll(":", ".").split(PropertyFilter.OR_SEPARATOR);

		Assert.isTrue(propertyNames.length > 0, "filter名称" + filterName + "没有按规则编写,无法得到属性名称.");
		// 按entity property中的类型将字符串转化为实际类型.
		this.propertyValue = ReflectionUtils.convertStringToObject(value, propertyType);
	}

	/**
	 * 是否比较多个属性.
	 */
	public boolean isMultiProperty() {
		return (propertyNames.length > 1);
	}

	/**
	 * 获取比较属性名称列表.
	 */
	public String[] getPropertyNames() {
		return propertyNames;
	}

	/**
	 * 获取唯一的比较属性名称.
	 */
	public String getPropertyName() {
		if (propertyNames.length > 1) {
			throw new IllegalArgumentException("There are not only one property");
		}
		return propertyNames[0];
	}

	/**
	 * 获取唯一的比较属性名称.
	 */
	public Set<String> getPropertyRefName() {
		Set<String> result = Sets.newLinkedHashSet();
		for (String refName : propertyNames) {
			if (refName.indexOf(".") != -1) {
				result.add(refName.substring(0, refName.lastIndexOf(".")));
			}
		}
		return result;
	}

	/**
	 * 获取比较值.
	 */
	public Object getPropertyValue() {
		return propertyValue;
	}

	/**
	 * 获取比较值的类型.
	 */
	public Class<?> getPropertyType() {
		return propertyType;
	}

	/**
	 * 获取比较方式类型.
	 */
	public MatchType getMatchType() {
		return matchType;
	}

	public Object[] getPropertyArray() {
		return propertyArray;
	}
}
