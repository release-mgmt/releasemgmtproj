angular.module('testApp').controller(
		'LoginCtrl',
		[
				'$scope',
				'$rootScope',
				'$location',
				'LoginService',
				function($scope, $rootScope, $location, LoginService) {
					
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
							
									if (response.status == 200) {
										
										$rootScope.role = response.data.empRole;

										$rootScope.eId = response.data.empId;
										
										switch ($rootScope.role) {
										
										case 'PM':
											$location.path('/pmView');
											break;

										case 'DM':
											$location.path('/dmView');
											break;

/*										case 'user':
											$location.path('/userView');
											break;*/
										}
										
									} else {
										$scope.error = response.message;
									}
								},function (error) {
					                $scope.status = 'Server is down please try after some time ' + error.message;
					            });
					};
				} ]);