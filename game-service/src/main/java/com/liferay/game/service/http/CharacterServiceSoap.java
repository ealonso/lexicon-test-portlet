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

package com.liferay.game.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.game.service.CharacterServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link CharacterServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.game.model.CharacterSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.game.model.Character}, that is translated to a
 * {@link com.liferay.game.model.CharacterSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CharacterServiceHttp
 * @see com.liferay.game.model.CharacterSoap
 * @see CharacterServiceUtil
 * @generated
 */
@ProviderType
public class CharacterServiceSoap {
	public static com.liferay.game.model.CharacterSoap addCharacter(
		long userId, long groupId, java.lang.String name, java.lang.String url,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.game.model.Character returnValue = CharacterServiceUtil.addCharacter(userId,
					groupId, name, url, serviceContext);

			return com.liferay.game.model.CharacterSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.game.model.CharacterSoap deleteCharacter(
		long characterId) throws RemoteException {
		try {
			com.liferay.game.model.Character returnValue = CharacterServiceUtil.deleteCharacter(characterId);

			return com.liferay.game.model.CharacterSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteCharacters(long groupId) throws RemoteException {
		try {
			CharacterServiceUtil.deleteCharacters(groupId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.game.model.CharacterSoap getCharacter(
		long characterId) throws RemoteException {
		try {
			com.liferay.game.model.Character returnValue = CharacterServiceUtil.getCharacter(characterId);

			return com.liferay.game.model.CharacterSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.game.model.CharacterSoap[] getCharacters(
		long groupId, int start, int end) throws RemoteException {
		try {
			java.util.List<com.liferay.game.model.Character> returnValue = CharacterServiceUtil.getCharacters(groupId,
					start, end);

			return com.liferay.game.model.CharacterSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.game.model.CharacterSoap updateCharacter(
		long characterId, java.lang.String name, java.lang.String url)
		throws RemoteException {
		try {
			com.liferay.game.model.Character returnValue = CharacterServiceUtil.updateCharacter(characterId,
					name, url);

			return com.liferay.game.model.CharacterSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CharacterServiceSoap.class);
}