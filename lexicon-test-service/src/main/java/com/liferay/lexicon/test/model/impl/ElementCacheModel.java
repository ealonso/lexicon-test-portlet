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

package com.liferay.lexicon.test.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.lexicon.test.model.Element;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Element in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Element
 * @generated
 */
@ProviderType
public class ElementCacheModel implements CacheModel<Element>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ElementCacheModel)) {
			return false;
		}

		ElementCacheModel elementCacheModel = (ElementCacheModel)obj;

		if (elementId == elementCacheModel.elementId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, elementId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", elementId=");
		sb.append(elementId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", url=");
		sb.append(url);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Element toEntityModel() {
		ElementImpl elementImpl = new ElementImpl();

		if (uuid == null) {
			elementImpl.setUuid(StringPool.BLANK);
		}
		else {
			elementImpl.setUuid(uuid);
		}

		elementImpl.setElementId(elementId);
		elementImpl.setGroupId(groupId);
		elementImpl.setCompanyId(companyId);
		elementImpl.setUserId(userId);

		if (userName == null) {
			elementImpl.setUserName(StringPool.BLANK);
		}
		else {
			elementImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			elementImpl.setCreateDate(null);
		}
		else {
			elementImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			elementImpl.setModifiedDate(null);
		}
		else {
			elementImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			elementImpl.setName(StringPool.BLANK);
		}
		else {
			elementImpl.setName(name);
		}

		if (url == null) {
			elementImpl.setUrl(StringPool.BLANK);
		}
		else {
			elementImpl.setUrl(url);
		}

		elementImpl.resetOriginalValues();

		return elementImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		elementId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		url = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(elementId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(url);
		}
	}

	public String uuid;
	public long elementId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String url;
}