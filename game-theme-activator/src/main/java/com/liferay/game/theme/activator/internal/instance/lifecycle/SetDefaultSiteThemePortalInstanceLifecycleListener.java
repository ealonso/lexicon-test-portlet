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

package com.liferay.game.theme.activator.internal.instance.lifecycle;

import com.liferay.game.web.internal.constant.GamePortletKeys;
import com.liferay.login.web.constants.LoginPortletKeys;
import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.util.DefaultLayoutPrototypesUtil;
import com.liferay.portal.util.PortalInstances;
import com.liferay.portal.util.PropsValues;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 */
@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class SetDefaultSiteThemePortalInstanceLifecycleListener
	extends BasePortalInstanceLifecycleListener {

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		if (company.getCompanyId() != PortalInstances.getDefaultCompanyId()) {
			return;
		}

		Group defaultGroup = _groupLocalService.getGroup(
			company.getCompanyId(),
			PropsValues.VIRTUAL_HOSTS_DEFAULT_SITE_NAME);

		Layout homeLayout = _layoutLocalService.fetchLayoutByFriendlyURL(
			defaultGroup.getGroupId(), false, "/home");

		if (homeLayout != null) {
			_layoutLocalService.deleteLayout(homeLayout);
		}

		homeLayout = DefaultLayoutPrototypesUtil.addLayout(
			defaultGroup.getPublicLayoutSet(), "home", "/game", "1_column");

		DefaultLayoutPrototypesUtil.addPortletId(
			homeLayout, GamePortletKeys.GAME, "column-1");

		_layoutLocalService.updateLookAndFeel(
			homeLayout.getGroupId(), homeLayout.getPrivateLayout(),
			homeLayout.getLayoutId(), _THEME_ID, "01", null);
	}

	@Reference(unbind = "-")
	protected void setGroupLocalService(GroupLocalService groupLocalService) {
		_groupLocalService = groupLocalService;
	}

	@Reference(unbind = "-")
	protected void setLayoutLocalService(
		LayoutLocalService layoutLocalService) {

		_layoutLocalService = layoutLocalService;
	}

	@Reference(
		target = "(javax.portlet.name=" + LoginPortletKeys.LOGIN + ")",
		unbind = "-"
	)
	protected void setLoginPortlet(Portlet portlet) {
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(
		ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	@Reference(target = "(osgi.web.symbolicname=game-theme)", unbind = "-")
	protected void setServletContext(ServletContext servletContext) {
	}

	private static final String _THEME_ID = "game_WAR_gametheme";

	private GroupLocalService _groupLocalService;
	private LayoutLocalService _layoutLocalService;

}