angular.module('testApp').controller(
		'pmViewCtrl',
		[
				'$scope',
				'$rootScope',
				'$routeParams',
				'$location',
				'ViewService',
				function($scope, $rootScope, $routeParams, $location,
						ViewService) {

					$scope.projects = {};

					var emp = $rootScope.eId;

					$scope.allProjects = function() {

						ViewService.GetProjects(emp).then(function(response) {
							$scope.projects = response.data;
						}, function(error) {
							console.log(error.status);
						});
					};

				} ]);