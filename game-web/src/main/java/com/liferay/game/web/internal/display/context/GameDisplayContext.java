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

package com.liferay.game.web.internal.display.context;

import com.liferay.game.model.Character;
import com.liferay.game.service.CharacterLocalServiceUtil;
import com.liferay.game.web.internal.constant.GameWebKeys;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class GameDisplayContext {

	public GameDisplayContext(
		LiferayPortletRequest portletRequest,
		LiferayPortletResponse portletResponse) {

		_request = PortalUtil.getHttpServletRequest(portletRequest);

		_portletRequest = portletRequest;
		_portletResponse = portletResponse;
	}

	public Character getCharacter() {
		Character character = (Character)_request.getAttribute(
			GameWebKeys.GAME_CHARACTER);

		return character;
	}

	public String getDisplayStyle() {
		if (_displayStyle != null) {
			return _displayStyle;
		}

		_displayStyle = ParamUtil.getString(_request, "displayStyle", "list");

		return _displayStyle;
	}

	public PortletURL getEditURL() throws PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay)_portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletURL portletURL = _portletResponse.createRenderURL();

		portletURL.setParameter("mvcRenderCommandName", "/game/edit_character");
		portletURL.setParameter("redirect", themeDisplay.getURLCurrent());

		return portletURL;
	}

	public String getOrderByCol() {
		if (Validator.isNotNull(_orderByCol)) {
			return _orderByCol;
		}

		_orderByCol = ParamUtil.getString(_request, "orderByCol", "title");

		return _orderByCol;
	}

	public String getOrderByType() {
		if (Validator.isNotNull(_orderByType)) {
			return _orderByType;
		}

		_orderByType = ParamUtil.getString(_request, "orderByType", "asc");

		return _orderByType;
	}

	public PortletURL getPortletURL() throws PortalException {
		PortletURL portletURL = _portletResponse.createRenderURL();

		return portletURL;
	}

	public String getRedirect() {
		if (_redirect != null) {
			return _redirect;
		}

		_redirect = ParamUtil.getString(_request, "redirect");

		return _redirect;
	}

	public SearchContainer getSearchContainer() throws Exception {
		if (_searchContainer != null) {
			return _searchContainer;
		}

		_searchContainer = new SearchContainer(
			_portletRequest, PortletURLUtil.clone(
				getPortletURL(), _portletResponse),
			null, LanguageUtil.get(_request, "no-super-hero-were-found"));

		_searchContainer.setRowChecker(
			new EmptyOnClickRowChecker(_portletResponse));

		_searchContainer.setEmptyResultsMessageCssClass(
			"taglib-empty-result-message-header-has-plus-btn");

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		_searchContainer.setTotal(_getTotal());
		_searchContainer.setResults(
			CharacterLocalServiceUtil.getCharacters(
				themeDisplay.getScopeGroupId(),
			_searchContainer.getStart(), _searchContainer.getEnd()));

		return _searchContainer;
	}

	private int _getTotal() {
		return _names.length;
	}

	private String _displayStyle;
	private String[] _names = {
		"Batman", "Captain America", "Flash", "Green Lantern", "IronMan",
		"Robin", "SpiderMan", "Superman", "Wolverine", "WonderWoman"
	};
	private String _orderByCol;
	private String _orderByType;
	private final LiferayPortletRequest _portletRequest;
	private final LiferayPortletResponse _portletResponse;
	private String _redirect;
	private final HttpServletRequest _request;
	private SearchContainer _searchContainer;
	private String[] _urls = {
		"batman", "captainamerica", "flash", "greenlantern", "ironman", "robin",
		"spiderman", "superman", "wolverine", "wonderwoman"
	};

}