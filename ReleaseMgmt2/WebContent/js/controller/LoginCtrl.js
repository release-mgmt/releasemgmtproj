angular.module('testApp').controller(
		'LoginCtrl',
		[
				'$scope',
				'$rootScope',
				'$location',
				'LoginService',
				function($scope, $rootScope, $location, LoginService) {
					alert("in login");
					$scope.login = function() {
						alert("in login func");
						LoginService.Login($scope.username, $scope.password,
								function(response) {
									if (response.success) {
										console.log(response);
										console.log(response.data);

										var role = response.data;

										switch (role) {
										
										case 'pm':
											console.log("in switch pm");
											$location.path('/pmView');
											break;

										case 'dm':
											console.log("in switch dm");
											$location.path('/dmView');
											break;

										case 'user':
											console.log("in switch user");
											$location.path('/userView');
											break;
										}
										
									} else {
										console.log(response.message);
										$scope.error = response.message;
									}
								});
					};
				} ]);