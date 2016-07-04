angular.module('testApp')
    .controller('dmViewReleaseCtrl', ['$scope', '$rootScope', '$routeParams','$location', 'ViewService', 
        function ($scope,  $rootScope, $routeParams,$location, ViewService) {

							$scope.releases = {};		
							
							 $scope.allReleases = function () {
								 
								 $rootScope.projectId = $routeParams.id;
								 
								 ViewService.GetReleases($rootScope.projectId)
					                .then(function(response) {
					                	
					                	console.log(response.data);
					                	
					                	$scope.releases = response.data;
					               					                	
					                	console.log($scope.releases);
					                }, function (error) {
					                	console.log(error.status);
					                });
					          };
    
}]);