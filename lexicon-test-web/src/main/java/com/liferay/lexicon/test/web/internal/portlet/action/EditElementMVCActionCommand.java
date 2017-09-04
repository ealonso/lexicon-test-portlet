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

package com.liferay.lexicon.test.web.internal.portlet.action;

import com.liferay.lexicon.test.service.ElementLocalService;
import com.liferay.lexicon.test.web.internal.constant.LexiconTestPortletKeys;
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

import java.util.NoSuchElementException;

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
		"javax.portlet.name=" + LexiconTestPortletKeys.LEXICON_TEST,
		"mvc.command.name=/lexicon_test/edit_element"
	},
	service = MVCActionCommand.class
)
public class EditElementMVCActionCommand extends BaseMVCActionCommand {

	protected void deleteElements(ActionRequest actionRequest)
		throws Exception {

		long[] deleteElementIds = null;

		long elementId = ParamUtil.getLong(actionRequest, "elementId");

		if (elementId > 0) {
			deleteElementIds = new long[] {elementId};
		}
		else {
			deleteElementIds = ParamUtil.getLongValues(actionRequest, "rowIds");
		}

		for (long deleteElementId : deleteElementIds) {
			_elementLocalService.deleteElement(deleteElementId);
		}
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updateElement(actionRequest);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteElements(actionRequest);
			}
		}
		catch (Exception e) {
			if (e instanceof PrincipalException) {
				SessionErrors.add(actionRequest, e.getClass());

				actionResponse.setRenderParameter("mvcPath", "/error.jsp");
			}
			else if (e instanceof NoSuchElementException) {
				SessionErrors.add(actionRequest, e.getClass());
			}
			else {
				throw e;
			}
		}
	}

	protected void updateElement(ActionRequest actionRequest) throws Exception {
		long elementId = ParamUtil.getLong(actionRequest, "elementId");

		String name = ParamUtil.getString(actionRequest, "name");
		String url = ParamUtil.getString(actionRequest, "url");

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			actionRequest);

		if (elementId <= 0) {
			_elementLocalService.addElement(
				themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), name,
				url, serviceContext);
		}
		else {
			_elementLocalService.updateElement(elementId, name, url);
		}
	}

	@Reference(unbind = "-")
	private ElementLocalService _elementLocalService;

}