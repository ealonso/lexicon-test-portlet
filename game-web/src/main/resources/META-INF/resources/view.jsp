<%--
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
--%>

<%@ include file="/init.jsp" %>

<liferay-portlet:renderURL varImpl="mainURL" />

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav cssClass="navbar-nav">
		<aui:nav-item href="<%= mainURL.toString() %>" label="characters" selected="<%= true %>" />
	</aui:nav>

	<aui:nav-bar-search>
		<liferay-ui:input-search markupView="lexicon" />
	</aui:nav-bar-search>
</aui:nav-bar>

<liferay-frontend:management-bar
	includeCheckBox="<%= true %>"
	searchContainerId="characters"
>
	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-navigation
			navigationKeys='<%= new String[] {"all"} %>'
			portletURL="<%= PortletURLUtil.clone(mainURL, liferayPortletResponse) %>"
		/>

		<liferay-frontend:management-bar-sort
			orderByCol="<%= gameDisplayContext.getOrderByCol() %>"
			orderByType="<%= gameDisplayContext.getOrderByType() %>"
			orderColumns='<%= new String[] {"name"} %>'
			portletURL="<%= PortletURLUtil.clone(mainURL, liferayPortletResponse) %>"
		/>
	</liferay-frontend:management-bar-filters>

	<liferay-frontend:management-bar-action-buttons>
		<liferay-frontend:management-bar-button href="javascript:;" icon="trash" id="deleteCharacters" label="delete" />
	</liferay-frontend:management-bar-action-buttons>

	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews='<%= new String[] {"icon", "list"} %>'
			portletURL="<%= mainURL %>"
			selectedDisplayStyle="<%= gameDisplayContext.getDisplayStyle() %>"
		/>
	</liferay-frontend:management-bar-buttons>
</liferay-frontend:management-bar>

<div class="container-fluid-1280">
	<portlet:actionURL name="/game/edit_character" var="deleteCharactersURL">
		<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
	</portlet:actionURL>

	<aui:form action="<%= deleteCharactersURL %>" name="fm">
		<liferay-ui:search-container
			id="characters"
			searchContainer="<%= gameDisplayContext.getSearchContainer() %>"
		>
			<liferay-ui:search-container-row
				className="com.liferay.game.model.Character"
				keyProperty="characterId"
				modelVar="character"
			>
				<c:choose>
					<c:when test='<%= Objects.equals(gameDisplayContext.getDisplayStyle(), "list") %>'>
						<liferay-ui:search-container-column-text
							cssClass="table-cell-content"
							name="name"
						/>

						<liferay-ui:search-container-column-jsp
							path="/character_action.jsp"
						/>
					</c:when>
					<c:when test='<%= Objects.equals(gameDisplayContext.getDisplayStyle(), "icon") %>'>

						<%
						row.setCssClass("entry-card lfr-asset-item");
						%>

						<liferay-ui:search-container-column-text>
							<liferay-frontend:vertical-card
								actionJsp="/character_action.jsp"
								actionJspServletContext="<%= application %>"
								imageUrl="<%= character.getUrl() %>"
								resultRow="<%= row %>"
								rowChecker="<%= searchContainer.getRowChecker() %>"
								title="<%= character.getName() %>"
							>
								<c:if test="<%= Objects.equals(character.getStatus(), CharacterStatus.DEAD.toString()) %>">
									<liferay-frontend:vertical-card-sticker-bottom>
										<div class="sticker sticker-bottom sticker-danger">
											<%= character.getStatus() %>
										</div>
									</liferay-frontend:vertical-card-sticker-bottom>
								</c:if>
							</liferay-frontend:vertical-card>
						</liferay-ui:search-container-column-text>
					</c:when>
				</c:choose>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator displayStyle="<%= gameDisplayContext.getDisplayStyle() %>" markupView="lexicon" />
		</liferay-ui:search-container>
	</aui:form>
</div>

<liferay-frontend:add-menu>
	<liferay-frontend:add-menu-item
		title='<%= LanguageUtil.get(request, "add-new-character") %>'
		url="<%= gameDisplayContext.getEditURL().toString() %>"
	/>
</liferay-frontend:add-menu>

<aui:script sandbox="<%= true %>">
	$('#<portlet:namespace />deleteCharacters').on(
		'click',
		function() {
			if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this" />')) {
				submitForm($(document.<portlet:namespace />fm));
			}
		}
	);
</aui:script>