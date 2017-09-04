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
portletDisplay.setURLBack(lexiconTestDisplayContext.getRedirect());

renderResponse.setTitle(LanguageUtil.get(request, "add-new-super-hero"));

Element element = lexiconTestDisplayContext.getElement();

long elementId = BeanParamUtil.getLong(element, request, "elementId");
%>

<portlet:actionURL name="updateElement" var="updateElementURL" />

<portlet:actionURL name="/lexicon_test/edit_element" var="editElementURL">
	<portlet:param name="mvcRenderCommandName" value="/lexicon_test/edit_element" />
</portlet:actionURL>

<aui:form action="<%= editElementURL %>" cssClass="container-fluid-1280" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= lexiconTestDisplayContext.getRedirect() %>" />
	<aui:input name="elementId" type="hidden" value="<%= elementId %>" />

	<aui:model-context bean="<%= element %>" model="<%= Element.class %>" />

	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>
			<aui:input name="name" />

			<aui:input name="url" />
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:button-row>
		<aui:button cssClass="btn-lg" type="submit" />

		<aui:button cssClass="btn-lg" href="<%= lexiconTestDisplayContext.getRedirect() %>" type="cancel" />
	</aui:button-row>
</aui:form>