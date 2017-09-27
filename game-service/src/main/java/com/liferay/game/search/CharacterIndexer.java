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

package com.liferay.game.search;

import com.liferay.game.model.Character;
import com.liferay.game.service.CharacterLocalService;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Cristina González
 */
@Component(immediate = true, service = {Indexer.class, CharacterIndexer.class})
public class CharacterIndexer extends BaseIndexer<Character> {

	public static final String CLASS_NAME = Character.class.getName();

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
			SearchContext searchContext)
		throws Exception {

		addSearchTerm(searchQuery, searchContext, Field.STATUS, false);
	}

	@Override
	protected void doDelete(Character character) throws Exception {
		deleteDocument(character.getCompanyId(), character.getCharacterId());
	}

	@Override
	protected Document doGetDocument(Character character) throws Exception {
		Document document = getBaseModelDocument(CLASS_NAME, character);

		document.addText(Field.NAME, character.getName());
		document.addText(Field.TITLE, character.getName());
		document.addText(Field.STATUS, character.getStatus());

		return document;
	}

	@Override
	protected Summary doGetSummary(
			Document document, Locale locale, String snippet,
			PortletRequest portletRequest, PortletResponse portletResponse)
		throws Exception {

		Summary summary = createSummary(document, Field.TITLE, Field.NAME);

		return summary;
	}

	@Override
	protected void doReindex(Character character) throws Exception {
		Document document = getDocument(character);

		_indexWriterHelper.updateDocument(
			getSearchEngineId(), character.getCompanyId(), document,
			isCommitImmediately());
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Character character = _characterLocalService.getCharacter(classPK);

		doReindex(character);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		reindexCharacters(companyId);
	}

	protected Hits doSearch(SearchContext searchContext)
		throws SearchException {

		try {
			this.reindexCharacters(searchContext.getCompanyId());
		}
		catch (PortalException pe) {
			pe.printStackTrace();
		}

		return super.doSearch(searchContext);
	}

	protected void reindexCharacters(final long companyId)
		throws PortalException {

		final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			_characterLocalService.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Character>() {

				@Override
				public void performAction(Character character) {
					try {
						Document document = getDocument(character);

						if (document != null) {
							indexableActionableDynamicQuery.addDocuments(
								document);
						}
					}
					catch (PortalException pe) {
						if (_log.isWarnEnabled()) {
							_log.warn(
								"Unable to index character " +
									character.getCharacterId(),
								pe);
						}
					}
				}

			});

		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());

		indexableActionableDynamicQuery.performActions();
	}

	@Reference(unbind = "-")
	protected void setCharacterLocalService(
		CharacterLocalService characterLocalService) {

		_characterLocalService = characterLocalService;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CharacterIndexer.class);

	private CharacterLocalService _characterLocalService;

	@Reference
	private IndexWriterHelper _indexWriterHelper;

}