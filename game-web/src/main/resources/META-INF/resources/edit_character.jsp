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

<%
portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(gameDisplayContext.getRedirect());

renderResponse.setTitle(LanguageUtil.get(request, "add-new-character"));

Character character = gameDisplayContext.getCharacter();

long characterId = BeanParamUtil.getLong(character, request, "characterId");
%>

<portlet:actionURL name="updateCharacter" var="updateCharacterURL" />

<portlet:actionURL name="/game/edit_character" var="editCharacterURL">
	<portlet:param name="mvcRenderCommandName" value="/game/edit_character" />
</portlet:actionURL>

<aui:form action="<%= editCharacterURL %>" cssClass="container-fluid-1280" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= gameDisplayContext.getRedirect() %>" />
	<aui:input name="characterId" type="hidden" value="<%= characterId %>" />

	<aui:model-context bean="<%= character %>" model="<%= Character.class %>" />

	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>
			<aui:input name="name" />

			<aui:input name="url" />
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:button-row>
		<aui:button cssClass="btn-lg" type="submit" />

		<aui:button cssClass="btn-lg" href="<%= gameDisplayContext.getRedirect() %>" type="cancel" />
	</aui:button-row>
</aui:form>