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
 * Provides the remote service utility for Character. This utility wraps
 * {@link com.liferay.game.service.impl.CharacterServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CharacterService
 * @see com.liferay.game.service.base.CharacterServiceBaseImpl
 * @see com.liferay.game.service.impl.CharacterServiceImpl
 * @generated
 */
@ProviderType
public class CharacterServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.game.service.impl.CharacterServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.game.model.Character addCharacter(long userId,
		long groupId, java.lang.String name, java.lang.String url,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addCharacter(userId, groupId, name, url, serviceContext);
	}

	public static com.liferay.game.model.Character deleteCharacter(
		long characterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCharacter(characterId);
	}

	public static void deleteCharacters(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().deleteCharacters(groupId);
	}

	public static com.liferay.game.model.Character getCharacter(
		long characterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCharacter(characterId);
	}

	public static java.util.List<com.liferay.game.model.Character> getCharacters(
		long groupId, int start, int end) {
		return getService().getCharacters(groupId, start, end);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.game.model.Character updateCharacter(
		long characterId, java.lang.String name, java.lang.String url)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().updateCharacter(characterId, name, url);
	}

	public static CharacterService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CharacterService, CharacterService> _serviceTracker =
		ServiceTrackerFactory.open(CharacterService.class);
}