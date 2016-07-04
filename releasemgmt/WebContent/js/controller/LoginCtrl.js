angular.module('testApp').controller(
		'LoginCtrl',
		[
				'$scope',
				'$rootScope',
				'$location',
				'$route',
				'LoginService',
				function($scope, $rootScope, $location,$route, LoginService) {
					
					$scope.user={"userName":'',"password":''};
					
					$scope.login = function() {
						console.log("in login()");
						console.log($scope.username);
						$scope.user.userName = $scope.username;
						$scope.user.password = $scope.password;
						console.log($scope.user.userName);
					var promise = LoginService.AuthenticateUser($scope.user);
					promise.then(
								function(response) {
							
									console.log("returned from service");
									console.log(response);
									console.log(response.data.empRole);
									
									if (response.data.empRole != null) {
										
										$rootScope.role = response.data.empRole;

										$rootScope.eId = response.data.empId;
										
										switch ($rootScope.role) {
										
										case 'PM':
											$location.path('/pmView');
											break;

										case 'DM':
											$location.path('/dmView');
											break;
										}
										
									} else {
										alert("Please enter valid username or password");
										$route.reload();

										$scope.error = response.message;
									}
								},function (error) {
								
					                $scope.status = 'Server is down please try after some time ' + error.message;
					            });
					};
				} ]);