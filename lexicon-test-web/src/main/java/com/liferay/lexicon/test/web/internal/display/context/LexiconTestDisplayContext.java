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

package com.liferay.lexicon.test.web.internal.display.context;

import com.liferay.lexicon.test.web.internal.model.Element;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class LexiconTestDisplayContext {

	public LexiconTestDisplayContext(
		LiferayPortletRequest portletRequest,
		LiferayPortletResponse portletResponse) {

		_request = PortalUtil.getHttpServletRequest(portletRequest);

		_portletRequest = portletRequest;
		_portletResponse = portletResponse;
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

		portletURL.setParameter("mvcPath", "/edit_element.jsp");
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

		_searchContainer.setTotal(_getTotal());
		_searchContainer.setResults(
			ListUtil.subList(
				_getResults(), _searchContainer.getStart(),
				_searchContainer.getEnd()));

		return _searchContainer;
	}

	private List<Element> _getResults() {
		List<Element> elements = new ArrayList<>();

		for (int i = 0; i < _names.length; i++) {
			String name = _names[i];

			String url =
				_request.getContextPath() + "/images/" + _urls[i] + "_xl.png";

			elements.add(new Element(name, url));
		}

		return elements;
	}

	private int _getTotal() {
		return _names.length;
	}

	private String _displayStyle;
	private String[] _names = new String[] {
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
	private String[] _urls = new String[] {
		"batman", "captainamerica", "flash", "greenlantern", "ironman", "robin",
		"spiderman", "superman", "wolverine", "wonderwoman"
	};

}