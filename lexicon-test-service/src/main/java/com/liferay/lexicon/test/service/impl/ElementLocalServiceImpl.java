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

package com.liferay.lexicon.test.service.impl;

import com.liferay.lexicon.test.model.Element;
import com.liferay.lexicon.test.service.base.ElementLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the element local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.lexicon.test.service.ElementLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElementLocalServiceBaseImpl
 * @see com.liferay.lexicon.test.service.ElementLocalServiceUtil
 */
public class ElementLocalServiceImpl extends ElementLocalServiceBaseImpl {

	@Override
	public Element addElement(
			long userId, long groupId, String name, String url,
			ServiceContext serviceContext)
		throws PortalException {

		User user = userLocalService.getUserById(userId);
		Date now = new Date();

		long elementId = counterLocalService.increment();

		Element element = elementPersistence.create(elementId);

		element.setUuid(serviceContext.getUuid());
		element.setGroupId(groupId);
		element.setCompanyId(user.getCompanyId());
		element.setUserId(user.getUserId());
		element.setUserName(user.getFullName());
		element.setCreateDate(now);
		element.setModifiedDate(now);
		element.setName(name);
		element.setUrl(url);

		elementPersistence.update(element);

		return element;
	}

	@Override
	public Element deleteElement(long elementId) throws PortalException {
		Element element = elementPersistence.findByPrimaryKey(elementId);

		elementPersistence.remove(element);

		return element;
	}

	@Override
	public void deleteElements(long groupId) throws PortalException {
		for (Element element : elementPersistence.findByGroupId(groupId)) {
			elementLocalService.deleteElement(element);
		}
	}

	@Override
	public Element getElement(long elementId) throws PortalException {
		return elementPersistence.findByPrimaryKey(elementId);
	}

	@Override
	public List<Element> getElements(long groupId, int start, int end) {
		return elementPersistence.findByGroupId(groupId, start, end);
	}

	@Override
	public Element updateElement(long elementId, String name, String url)
		throws PortalException {

		Element element = elementPersistence.findByPrimaryKey(elementId);

		element.setModifiedDate(new Date());
		element.setName(name);
		element.setUrl(url);

		elementPersistence.update(element);

		return element;
	}

}