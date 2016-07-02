angular
		.module('testApp')
		.service(
				'LoginService',
				[
						'$http',
						'$rootScope',
						'$timeout',
						function($http, $rootScope, $timeout) {
							var service = {};
							alert("in serv before timeout");
							service.Login = function(username, password,
									callback) {

								var role = 'dm';

								/* Dummy authentication for testing, uses $timeout to simulate api call
								 ----------------------------------------------*/
								$timeout(
										function() {
											alert("in serv after timeout");
											var response = {
												success : username == 'kp'
														&& password == '123',
												data : role
											};
											if (!response.success) {

												response.message = 'Username or password is incorrect';
											}
											callback(response);
										}, 1000);

								/* Use this for real authentication
								 ----------------------------------------------*/
								//$http.post('/api/authenticate', { username: username, password: password })
								//    .success(function (response) {
								//        callback(response);
								//    });
							};
							return service;
						} ])