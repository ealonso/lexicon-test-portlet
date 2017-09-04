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

package com.liferay.lexicon.test.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Element. This utility wraps
 * {@link com.liferay.lexicon.test.service.impl.ElementLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ElementLocalService
 * @see com.liferay.lexicon.test.service.base.ElementLocalServiceBaseImpl
 * @see com.liferay.lexicon.test.service.impl.ElementLocalServiceImpl
 * @generated
 */
@ProviderType
public class ElementLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.lexicon.test.service.impl.ElementLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the element to the database. Also notifies the appropriate model listeners.
	*
	* @param element the element
	* @return the element that was added
	*/
	public static com.liferay.lexicon.test.model.Element addElement(
		com.liferay.lexicon.test.model.Element element) {
		return getService().addElement(element);
	}

	public static com.liferay.lexicon.test.model.Element addElement(
		long userId, long groupId, java.lang.String name, java.lang.String url,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addElement(userId, groupId, name, url, serviceContext);
	}

	/**
	* Creates a new element with the primary key. Does not add the element to the database.
	*
	* @param elementId the primary key for the new element
	* @return the new element
	*/
	public static com.liferay.lexicon.test.model.Element createElement(
		long elementId) {
		return getService().createElement(elementId);
	}

	/**
	* Deletes the element from the database. Also notifies the appropriate model listeners.
	*
	* @param element the element
	* @return the element that was removed
	*/
	public static com.liferay.lexicon.test.model.Element deleteElement(
		com.liferay.lexicon.test.model.Element element) {
		return getService().deleteElement(element);
	}

	/**
	* Deletes the element with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param elementId the primary key of the element
	* @return the element that was removed
	* @throws PortalException if a element with the primary key could not be found
	*/
	public static com.liferay.lexicon.test.model.Element deleteElement(
		long elementId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteElement(elementId);
	}

	public static void deleteElements(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().deleteElements(groupId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.lexicon.test.model.impl.ElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.lexicon.test.model.impl.ElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.lexicon.test.model.Element fetchElement(
		long elementId) {
		return getService().fetchElement(elementId);
	}

	/**
	* Returns the element matching the UUID and group.
	*
	* @param uuid the element's UUID
	* @param groupId the primary key of the group
	* @return the matching element, or <code>null</code> if a matching element could not be found
	*/
	public static com.liferay.lexicon.test.model.Element fetchElementByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchElementByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the element with the primary key.
	*
	* @param elementId the primary key of the element
	* @return the element
	* @throws PortalException if a element with the primary key could not be found
	*/
	public static com.liferay.lexicon.test.model.Element getElement(
		long elementId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getElement(elementId);
	}

	/**
	* Returns the element matching the UUID and group.
	*
	* @param uuid the element's UUID
	* @param groupId the primary key of the group
	* @return the matching element
	* @throws PortalException if a matching element could not be found
	*/
	public static com.liferay.lexicon.test.model.Element getElementByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getElementByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the elements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.lexicon.test.model.impl.ElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of elements
	* @param end the upper bound of the range of elements (not inclusive)
	* @return the range of elements
	*/
	public static java.util.List<com.liferay.lexicon.test.model.Element> getElements(
		int start, int end) {
		return getService().getElements(start, end);
	}

	public static java.util.List<com.liferay.lexicon.test.model.Element> getElements(
		long groupId, int start, int end) {
		return getService().getElements(groupId, start, end);
	}

	/**
	* Returns all the elements matching the UUID and company.
	*
	* @param uuid the UUID of the elements
	* @param companyId the primary key of the company
	* @return the matching elements, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.lexicon.test.model.Element> getElementsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getElementsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of elements matching the UUID and company.
	*
	* @param uuid the UUID of the elements
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of elements
	* @param end the upper bound of the range of elements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching elements, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.lexicon.test.model.Element> getElementsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.lexicon.test.model.Element> orderByComparator) {
		return getService()
				   .getElementsByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of elements.
	*
	* @return the number of elements
	*/
	public static int getElementsCount() {
		return getService().getElementsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the element in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param element the element
	* @return the element that was updated
	*/
	public static com.liferay.lexicon.test.model.Element updateElement(
		com.liferay.lexicon.test.model.Element element) {
		return getService().updateElement(element);
	}

	public static com.liferay.lexicon.test.model.Element updateElement(
		long elementId, java.lang.String name, java.lang.String url)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().updateElement(elementId, name, url);
	}

	public static ElementLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ElementLocalService, ElementLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ElementLocalService.class);
}