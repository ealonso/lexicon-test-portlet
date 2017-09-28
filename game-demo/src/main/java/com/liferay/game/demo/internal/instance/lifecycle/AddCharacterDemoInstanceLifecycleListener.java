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

package com.liferay.game.demo.internal.instance.lifecycle;

import com.liferay.game.search.CharacterIndexer;
import com.liferay.game.service.CharacterLocalService;
import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.util.PropsValues;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 */
@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class AddCharacterDemoInstanceLifecycleListener
	extends BasePortalInstanceLifecycleListener {

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		Group defaultGroup = _groupLocalService.getGroup(
			company.getCompanyId(),
			PropsValues.VIRTUAL_HOSTS_DEFAULT_SITE_NAME);

		if (_characterLocalService.getCharactersCount() > 0) {
			return;
		}

		long defaultUserId = _userLocalService.getDefaultUserId(
			company.getCompanyId());

		ServiceContext serviceContext = new ServiceContext();

		String topic = GetterUtil.getString(System.getenv("DEMO_TOPIC"), "got");

		if (!_TOPICS.containsKey(topic)) {
			return;
		}

		Map<String, String> resources = _TOPICS.get(topic);

		for (Map.Entry<String, String> entry : resources.entrySet()) {
			String url = _IMAGE_RELATIVE_URL + topic + "/" + entry.getValue();

			_characterLocalService.addCharacter(
				defaultUserId, defaultGroup.getGroupId(), entry.getKey(), url,
				serviceContext);
		}
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(
		ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	private static final String[] _GOT = {
		"Daenerys Targaryen", "daenerystargaryen.png", "Jon Snow",
		"jonsnow.png", "Tyrion Lannister", "tyrionlannister.png",
		"Ramsay Bolton", "ramsaybolton.png", "Hodor", "hodor.png",
		"Oberyn Martell", "oberynmartell.png"
	};

	private static final String[] _HEROES = {
		"Batman", "batman_xl.png", "Captain America", "captainamerica_xl.png",
		"Flash", "flash_xl.png", "Green Lantern", "greenlantern_xl.png",
		"IronMan", "ironman_xl.png", "Robin", "robin_xl.png", "SpiderMan",
		"spiderman_xl.png", "Superman", "superman_xl.png", "Wolverine",
		"wolverine_xl.png", "WonderWoman", "wonderwoman_xl.png"
	};

	private static final String _IMAGE_RELATIVE_URL = "/o/game-web/images/";

	private static final Map<String, Map<String, String>> _TOPICS;

	static {
		Map<String, Map<String, String>> topics = new HashMap<>();

		topics.put("got", MapUtil.fromArray(_GOT));
		topics.put("heroes", MapUtil.fromArray(_HEROES));

		_TOPICS = Collections.unmodifiableMap(topics);
	}

	@Reference
	private CharacterIndexer _characterIndexer;

	@Reference
	private CharacterLocalService _characterLocalService;

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private Portal _portal;

	@Reference
	private UserLocalService _userLocalService;

}