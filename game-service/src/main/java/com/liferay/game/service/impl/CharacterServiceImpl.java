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

package com.liferay.game.service.impl;

import com.liferay.game.model.Character;
import com.liferay.game.service.base.CharacterServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

/**
 * The implementation of the character remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.game.service.CharacterService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CharacterServiceBaseImpl
 * @see com.liferay.game.service.CharacterServiceUtil
 */
public class CharacterServiceImpl extends CharacterServiceBaseImpl {

	@Override
	public Character addCharacter(
			long userId, long groupId, String name, String url,
			ServiceContext serviceContext)
		throws PortalException {

		return characterLocalService.addCharacter(
			userId, groupId, name, url, serviceContext);
	}

	@Override
	public Character deleteCharacter(long characterId) throws PortalException {
		return characterLocalService.deleteCharacter(characterId);
	}

	@Override
	public void deleteCharacters(long groupId) throws PortalException {
		characterLocalService.deleteCharacters(groupId);
	}

	@Override
	public Character getCharacter(long characterId) throws PortalException {
		return characterLocalService.getCharacter(characterId);
	}

	@Override
	public List<Character> getCharacters(long groupId, int start, int end) {
		return characterLocalService.getCharacters(groupId, start, end);
	}

	@Override
	public Character updateCharacter(long characterId, String name, String url)
		throws PortalException {

		return characterLocalService.updateCharacter(characterId, name, url);
	}

}