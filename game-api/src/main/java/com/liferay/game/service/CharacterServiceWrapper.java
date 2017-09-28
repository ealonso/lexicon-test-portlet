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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CharacterService}.
 *
 * @author Brian Wing Shun Chan
 * @see CharacterService
 * @generated
 */
@ProviderType
public class CharacterServiceWrapper implements CharacterService,
	ServiceWrapper<CharacterService> {
	public CharacterServiceWrapper(CharacterService characterService) {
		_characterService = characterService;
	}

	@Override
	public com.liferay.game.model.Character addCharacter(long userId,
		long groupId, java.lang.String name, java.lang.String url,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _characterService.addCharacter(userId, groupId, name, url,
			serviceContext);
	}

	@Override
	public com.liferay.game.model.Character deleteCharacter(long characterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _characterService.deleteCharacter(characterId);
	}

	@Override
	public void deleteCharacters(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		_characterService.deleteCharacters(groupId);
	}

	@Override
	public com.liferay.game.model.Character getCharacter(long characterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _characterService.getCharacter(characterId);
	}

	@Override
	public java.util.List<com.liferay.game.model.Character> getCharacters(
		long groupId, int start, int end) {
		return _characterService.getCharacters(groupId, start, end);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _characterService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.game.model.Character updateCharacter(long characterId,
		java.lang.String name, java.lang.String url)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _characterService.updateCharacter(characterId, name, url);
	}

	@Override
	public CharacterService getWrappedService() {
		return _characterService;
	}

	@Override
	public void setWrappedService(CharacterService characterService) {
		_characterService = characterService;
	}

	private CharacterService _characterService;
}