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

package com.liferay.game.web.internal.portlet.action;

import com.liferay.game.exception.NoSuchCharacterException;
import com.liferay.game.service.CharacterLocalService;
import com.liferay.game.web.internal.constant.GamePortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GamePortletKeys.GAME,
		"mvc.command.name=/game/edit_character"
	},
	service = MVCActionCommand.class
)
public class EditCharacterMVCActionCommand extends BaseMVCActionCommand {

	protected void deleteCharacters(ActionRequest actionRequest)
		throws Exception {

		long[] deleteCharacterIds = null;

		long characterId = ParamUtil.getLong(actionRequest, "characterId");

		if (characterId > 0) {
			deleteCharacterIds = new long[] {characterId};
		}
		else {
			deleteCharacterIds = ParamUtil.getLongValues(
				actionRequest, "rowIds");
		}

		for (long deleteCharacterId : deleteCharacterIds) {
			_characterLocalService.deleteCharacter(deleteCharacterId);
		}
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updateCharacter(actionRequest);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteCharacters(actionRequest);
			}
		}
		catch (Exception e) {
			if (e instanceof PrincipalException) {
				SessionErrors.add(actionRequest, e.getClass());

				actionResponse.setRenderParameter("mvcPath", "/error.jsp");
			}
			else if (e instanceof NoSuchCharacterException) {
				SessionErrors.add(actionRequest, e.getClass());
			}
			else {
				throw e;
			}
		}
	}

	protected void updateCharacter(ActionRequest actionRequest)
		throws Exception {

		long characterId = ParamUtil.getLong(actionRequest, "characterId");

		String name = ParamUtil.getString(actionRequest, "name");
		String url = ParamUtil.getString(actionRequest, "url");

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			actionRequest);

		if (characterId <= 0) {
			_characterLocalService.addCharacter(
				themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), name,
				url, serviceContext);
		}
		else {
			_characterLocalService.updateCharacter(characterId, name, url);
		}
	}

	@Reference(unbind = "-")
	private CharacterLocalService _characterLocalService;

}