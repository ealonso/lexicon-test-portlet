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

package com.liferay.game.model;

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
 * This class is a wrapper for {@link Character}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Character
 * @generated
 */
@ProviderType
public class CharacterWrapper implements Character, ModelWrapper<Character> {
	public CharacterWrapper(Character character) {
		_character = character;
	}

	@Override
	public Class<?> getModelClass() {
		return Character.class;
	}

	@Override
	public String getModelClassName() {
		return Character.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("characterId", getCharacterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("url", getUrl());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long characterId = (Long)attributes.get("characterId");

		if (characterId != null) {
			setCharacterId(characterId);
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

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new CharacterWrapper((Character)_character.clone());
	}

	@Override
	public int compareTo(Character character) {
		return _character.compareTo(character);
	}

	/**
	* Returns the character ID of this character.
	*
	* @return the character ID of this character
	*/
	@Override
	public long getCharacterId() {
		return _character.getCharacterId();
	}

	/**
	* Returns the company ID of this character.
	*
	* @return the company ID of this character
	*/
	@Override
	public long getCompanyId() {
		return _character.getCompanyId();
	}

	/**
	* Returns the create date of this character.
	*
	* @return the create date of this character
	*/
	@Override
	public Date getCreateDate() {
		return _character.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _character.getExpandoBridge();
	}

	/**
	* Returns the group ID of this character.
	*
	* @return the group ID of this character
	*/
	@Override
	public long getGroupId() {
		return _character.getGroupId();
	}

	/**
	* Returns the modified date of this character.
	*
	* @return the modified date of this character
	*/
	@Override
	public Date getModifiedDate() {
		return _character.getModifiedDate();
	}

	/**
	* Returns the name of this character.
	*
	* @return the name of this character
	*/
	@Override
	public java.lang.String getName() {
		return _character.getName();
	}

	/**
	* Returns the primary key of this character.
	*
	* @return the primary key of this character
	*/
	@Override
	public long getPrimaryKey() {
		return _character.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _character.getPrimaryKeyObj();
	}

	/**
	* Returns the status of this character.
	*
	* @return the status of this character
	*/
	@Override
	public java.lang.String getStatus() {
		return _character.getStatus();
	}

	/**
	* Returns the url of this character.
	*
	* @return the url of this character
	*/
	@Override
	public java.lang.String getUrl() {
		return _character.getUrl();
	}

	/**
	* Returns the user ID of this character.
	*
	* @return the user ID of this character
	*/
	@Override
	public long getUserId() {
		return _character.getUserId();
	}

	/**
	* Returns the user name of this character.
	*
	* @return the user name of this character
	*/
	@Override
	public java.lang.String getUserName() {
		return _character.getUserName();
	}

	/**
	* Returns the user uuid of this character.
	*
	* @return the user uuid of this character
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _character.getUserUuid();
	}

	/**
	* Returns the uuid of this character.
	*
	* @return the uuid of this character
	*/
	@Override
	public java.lang.String getUuid() {
		return _character.getUuid();
	}

	@Override
	public int hashCode() {
		return _character.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _character.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _character.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _character.isNew();
	}

	@Override
	public void persist() {
		_character.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_character.setCachedModel(cachedModel);
	}

	/**
	* Sets the character ID of this character.
	*
	* @param characterId the character ID of this character
	*/
	@Override
	public void setCharacterId(long characterId) {
		_character.setCharacterId(characterId);
	}

	/**
	* Sets the company ID of this character.
	*
	* @param companyId the company ID of this character
	*/
	@Override
	public void setCompanyId(long companyId) {
		_character.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this character.
	*
	* @param createDate the create date of this character
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_character.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_character.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_character.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_character.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this character.
	*
	* @param groupId the group ID of this character
	*/
	@Override
	public void setGroupId(long groupId) {
		_character.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this character.
	*
	* @param modifiedDate the modified date of this character
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_character.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this character.
	*
	* @param name the name of this character
	*/
	@Override
	public void setName(java.lang.String name) {
		_character.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_character.setNew(n);
	}

	/**
	* Sets the primary key of this character.
	*
	* @param primaryKey the primary key of this character
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_character.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_character.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this character.
	*
	* @param status the status of this character
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_character.setStatus(status);
	}

	/**
	* Sets the url of this character.
	*
	* @param url the url of this character
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_character.setUrl(url);
	}

	/**
	* Sets the user ID of this character.
	*
	* @param userId the user ID of this character
	*/
	@Override
	public void setUserId(long userId) {
		_character.setUserId(userId);
	}

	/**
	* Sets the user name of this character.
	*
	* @param userName the user name of this character
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_character.setUserName(userName);
	}

	/**
	* Sets the user uuid of this character.
	*
	* @param userUuid the user uuid of this character
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_character.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this character.
	*
	* @param uuid the uuid of this character
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_character.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Character> toCacheModel() {
		return _character.toCacheModel();
	}

	@Override
	public Character toEscapedModel() {
		return new CharacterWrapper(_character.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _character.toString();
	}

	@Override
	public Character toUnescapedModel() {
		return new CharacterWrapper(_character.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _character.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CharacterWrapper)) {
			return false;
		}

		CharacterWrapper characterWrapper = (CharacterWrapper)obj;

		if (Objects.equals(_character, characterWrapper._character)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _character.getStagedModelType();
	}

	@Override
	public Character getWrappedModel() {
		return _character;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _character.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _character.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_character.resetOriginalValues();
	}

	private final Character _character;
}