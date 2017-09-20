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

package com.liferay.game.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Character. This utility wraps
 * {@link com.liferay.game.service.impl.CharacterLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CharacterLocalService
 * @see com.liferay.game.service.base.CharacterLocalServiceBaseImpl
 * @see com.liferay.game.service.impl.CharacterLocalServiceImpl
 * @generated
 */
@ProviderType
public class CharacterLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.game.service.impl.CharacterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the character to the database. Also notifies the appropriate model listeners.
	*
	* @param character the character
	* @return the character that was added
	*/
	public static com.liferay.game.model.Character addCharacter(
		com.liferay.game.model.Character character) {
		return getService().addCharacter(character);
	}

	public static com.liferay.game.model.Character addCharacter(long userId,
		long groupId, java.lang.String name, java.lang.String url,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addCharacter(userId, groupId, name, url, serviceContext);
	}

	/**
	* Creates a new character with the primary key. Does not add the character to the database.
	*
	* @param characterId the primary key for the new character
	* @return the new character
	*/
	public static com.liferay.game.model.Character createCharacter(
		long characterId) {
		return getService().createCharacter(characterId);
	}

	/**
	* Deletes the character from the database. Also notifies the appropriate model listeners.
	*
	* @param character the character
	* @return the character that was removed
	*/
	public static com.liferay.game.model.Character deleteCharacter(
		com.liferay.game.model.Character character) {
		return getService().deleteCharacter(character);
	}

	/**
	* Deletes the character with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param characterId the primary key of the character
	* @return the character that was removed
	* @throws PortalException if a character with the primary key could not be found
	*/
	public static com.liferay.game.model.Character deleteCharacter(
		long characterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCharacter(characterId);
	}

	public static void deleteCharacters(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().deleteCharacters(groupId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.game.model.impl.CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.game.model.impl.CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.game.model.Character fetchCharacter(
		long characterId) {
		return getService().fetchCharacter(characterId);
	}

	/**
	* Returns the character matching the UUID and group.
	*
	* @param uuid the character's UUID
	* @param groupId the primary key of the group
	* @return the matching character, or <code>null</code> if a matching character could not be found
	*/
	public static com.liferay.game.model.Character fetchCharacterByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchCharacterByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the character with the primary key.
	*
	* @param characterId the primary key of the character
	* @return the character
	* @throws PortalException if a character with the primary key could not be found
	*/
	public static com.liferay.game.model.Character getCharacter(
		long characterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCharacter(characterId);
	}

	/**
	* Returns the character matching the UUID and group.
	*
	* @param uuid the character's UUID
	* @param groupId the primary key of the group
	* @return the matching character
	* @throws PortalException if a matching character could not be found
	*/
	public static com.liferay.game.model.Character getCharacterByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCharacterByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the characters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.game.model.impl.CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of characters
	* @param end the upper bound of the range of characters (not inclusive)
	* @return the range of characters
	*/
	public static java.util.List<com.liferay.game.model.Character> getCharacters(
		int start, int end) {
		return getService().getCharacters(start, end);
	}

	public static java.util.List<com.liferay.game.model.Character> getCharacters(
		long groupId, int start, int end) {
		return getService().getCharacters(groupId, start, end);
	}

	/**
	* Returns all the characters matching the UUID and company.
	*
	* @param uuid the UUID of the characters
	* @param companyId the primary key of the company
	* @return the matching characters, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.game.model.Character> getCharactersByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getCharactersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of characters matching the UUID and company.
	*
	* @param uuid the UUID of the characters
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of characters
	* @param end the upper bound of the range of characters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching characters, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.game.model.Character> getCharactersByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.game.model.Character> orderByComparator) {
		return getService()
				   .getCharactersByUuidAndCompanyId(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of characters.
	*
	* @return the number of characters
	*/
	public static int getCharactersCount() {
		return getService().getCharactersCount();
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
	* Updates the character in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param character the character
	* @return the character that was updated
	*/
	public static com.liferay.game.model.Character updateCharacter(
		com.liferay.game.model.Character character) {
		return getService().updateCharacter(character);
	}

	public static com.liferay.game.model.Character updateCharacter(
		long characterId, java.lang.String name, java.lang.String url)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().updateCharacter(characterId, name, url);
	}

	public static CharacterLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CharacterLocalService, CharacterLocalService> _serviceTracker =
		ServiceTrackerFactory.open(CharacterLocalService.class);
}