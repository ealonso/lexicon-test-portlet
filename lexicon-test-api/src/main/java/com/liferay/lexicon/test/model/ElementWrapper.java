/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.lexicon.test.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Element}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Element
 * @generated
 */
@ProviderType
public class ElementWrapper implements Element, ModelWrapper<Element> {
	public ElementWrapper(Element element) {
		_element = element;
	}

	@Override
	public Class<?> getModelClass() {
		return Element.class;
	}

	@Override
	public String getModelClassName() {
		return Element.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("elementId", getElementId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("url", getUrl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long elementId = (Long)attributes.get("elementId");

		if (elementId != null) {
			setElementId(elementId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new ElementWrapper((Element)_element.clone());
	}

	@Override
	public int compareTo(Element element) {
		return _element.compareTo(element);
	}

	/**
	* Returns the company ID of this element.
	*
	* @return the company ID of this element
	*/
	@Override
	public long getCompanyId() {
		return _element.getCompanyId();
	}

	/**
	* Returns the create date of this element.
	*
	* @return the create date of this element
	*/
	@Override
	public Date getCreateDate() {
		return _element.getCreateDate();
	}

	/**
	* Returns the element ID of this element.
	*
	* @return the element ID of this element
	*/
	@Override
	public long getElementId() {
		return _element.getElementId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _element.getExpandoBridge();
	}

	/**
	* Returns the group ID of this element.
	*
	* @return the group ID of this element
	*/
	@Override
	public long getGroupId() {
		return _element.getGroupId();
	}

	/**
	* Returns the modified date of this element.
	*
	* @return the modified date of this element
	*/
	@Override
	public Date getModifiedDate() {
		return _element.getModifiedDate();
	}

	/**
	* Returns the name of this element.
	*
	* @return the name of this element
	*/
	@Override
	public java.lang.String getName() {
		return _element.getName();
	}

	/**
	* Returns the primary key of this element.
	*
	* @return the primary key of this element
	*/
	@Override
	public long getPrimaryKey() {
		return _element.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _element.getPrimaryKeyObj();
	}

	/**
	* Returns the url of this element.
	*
	* @return the url of this element
	*/
	@Override
	public java.lang.String getUrl() {
		return _element.getUrl();
	}

	/**
	* Returns the user ID of this element.
	*
	* @return the user ID of this element
	*/
	@Override
	public long getUserId() {
		return _element.getUserId();
	}

	/**
	* Returns the user name of this element.
	*
	* @return the user name of this element
	*/
	@Override
	public java.lang.String getUserName() {
		return _element.getUserName();
	}

	/**
	* Returns the user uuid of this element.
	*
	* @return the user uuid of this element
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _element.getUserUuid();
	}

	/**
	* Returns the uuid of this element.
	*
	* @return the uuid of this element
	*/
	@Override
	public java.lang.String getUuid() {
		return _element.getUuid();
	}

	@Override
	public int hashCode() {
		return _element.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _element.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _element.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _element.isNew();
	}

	@Override
	public void persist() {
		_element.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_element.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this element.
	*
	* @param companyId the company ID of this element
	*/
	@Override
	public void setCompanyId(long companyId) {
		_element.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this element.
	*
	* @param createDate the create date of this element
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_element.setCreateDate(createDate);
	}

	/**
	* Sets the element ID of this element.
	*
	* @param elementId the element ID of this element
	*/
	@Override
	public void setElementId(long elementId) {
		_element.setElementId(elementId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_element.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_element.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_element.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this element.
	*
	* @param groupId the group ID of this element
	*/
	@Override
	public void setGroupId(long groupId) {
		_element.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this element.
	*
	* @param modifiedDate the modified date of this element
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_element.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this element.
	*
	* @param name the name of this element
	*/
	@Override
	public void setName(java.lang.String name) {
		_element.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_element.setNew(n);
	}

	/**
	* Sets the primary key of this element.
	*
	* @param primaryKey the primary key of this element
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_element.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_element.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the url of this element.
	*
	* @param url the url of this element
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_element.setUrl(url);
	}

	/**
	* Sets the user ID of this element.
	*
	* @param userId the user ID of this element
	*/
	@Override
	public void setUserId(long userId) {
		_element.setUserId(userId);
	}

	/**
	* Sets the user name of this element.
	*
	* @param userName the user name of this element
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_element.setUserName(userName);
	}

	/**
	* Sets the user uuid of this element.
	*
	* @param userUuid the user uuid of this element
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_element.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this element.
	*
	* @param uuid the uuid of this element
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_element.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Element> toCacheModel() {
		return _element.toCacheModel();
	}

	@Override
	public Element toEscapedModel() {
		return new ElementWrapper(_element.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _element.toString();
	}

	@Override
	public Element toUnescapedModel() {
		return new ElementWrapper(_element.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _element.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ElementWrapper)) {
			return false;
		}

		ElementWrapper elementWrapper = (ElementWrapper)obj;

		if (Objects.equals(_element, elementWrapper._element)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _element.getStagedModelType();
	}

	@Override
	public Element getWrappedModel() {
		return _element;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _element.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _element.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_element.resetOriginalValues();
	}

	private final Element _element;
}