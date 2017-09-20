function() {
	var env = karate.env; // get system property 'karate.env'
	karate.log('karate.env system property was:', env);

	if (!env) {
		env = 'local';
	}

	karate.log('karate.env is:', env);

	var config = {
		env: env
	};

	if (env == 'local') {
		host = 'http://localhost:8080';
	}
	else {
		host = karate.properties['test.url'];
	}

	config.engineURL = host;
	config.characterServiceURL = host + '/' + testProjectId;

	return config;
}