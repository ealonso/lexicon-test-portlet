function() {

	var config = {};

	var testUrl = karate.properties['test.url'];

	karate.log('test.url is:', testUrl);

	if (!testUrl) {
		testUrl = 'http://localhost:8080';
	}

	var apiJsonwsURL = testUrl + '/api/jsonws/';

	config.companyURL = apiJsonwsURL + 'company';
	config.groupURL = apiJsonwsURL + 'group';
	// config.siteURL = apiJsonwsURL + 'site';
	config.userURL = apiJsonwsURL + 'user';
	config.characterURL = apiJsonwsURL + 'game.character';

	return config;
}