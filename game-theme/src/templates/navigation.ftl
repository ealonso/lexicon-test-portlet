<div aria-expanded="false" class="${nav_collapse} collapse" id="navigationCollapse">
	<#if has_navigation && is_setup_complete>
		<div class="${nav_css_class} ${nav_css_right} site-navigation" id="navigation" role="navigation">
			<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences("portletSetupPortletDecoratorId", "barebone") />
		</div>

		<div class="${nav_css_class} ${nav_css_right} site-navigation" id="navigationSignIn" role="navigation">
			<#if !is_signed_in>
				<li role="presentation">
					<a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">
						${sign_in_text}
					</a>
				</li>
			</#if>
		</div>
	</#if>
</div>