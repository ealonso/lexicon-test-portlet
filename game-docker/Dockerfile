FROM cgoncas/slim-liferay-portal-image:20170905072647
MAINTAINER Ruben Pulido <ruben.pulido@liferay.com>

COPY *.?ar $LIFERAY_HOME/osgi/modules/
COPY portal-ext.properties /usr/local/liferay-ce-portal-7.0-ga4/portal-ext.properties

COPY hypersonic/* /usr/local/liferay-ce-portal-7.0-ga4/data/hypersonic/

USER root