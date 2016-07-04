angular.module('testApp')
    .controller('dmViewReleaseCtrl', ['$scope', '$rootScope', '$routeParams','$location', 'ViewService', 
        function ($scope,  $rootScope, $routeParams,$location, ViewService) {

							$scope.releases = {};		
							
							$rootScope.searchedRelease = {};
							
							$scope.releaseTypes = [ 'major', 'minor', 'build','milestone', 'final' ];
						
							$scope.releaseStatus = [ 'planned', 'released', 'delayed','suspended', 'resumed' ];
							
							 $scope.allReleases = function () {
								 
								 console.log("in allRel()");
								 
								 $rootScope.projectId = $routeParams.id;
								 
								 ViewService.GetReleases($rootScope.projectId)
					                .then(function(response) {
					                	
					                	console.log(response.data);
					                	
					                	$scope.releases = response.data;
					                	/*$location.path('/searchRelease');
					               		*/			                	
					                	console.log($scope.releases);
					                }, function (error) {
					                	console.log(error.status);
					                });
					          };
					          
					          
						         /* 
						          $scope.searchByTitle = function () {
																			 
										 SearchService.SearchReleaseByTitle($scope.searchTitle)
							                .then(function(response) {
							                	
							                	console.log(response.data);
							                	
							                	$rootScope.searchedRelease = response.data;
							                	$location.path('/searchRelease');
							                	
							                	console.log($scope.releases);
							                }, function (error) {
							                	console.log(error.status);
							                });
							          };
							          
							          $scope.searchByType = function () {
											 
											 SearchService.SearchReleaseByType($scope.searchType)
								                .then(function(response) {
								                	
								                	console.log(response.data);
								                	
								                	$rootScope.searchedRelease = response.data;
								                	$location.path('/searchRelease');
								                	
								                	console.log($scope.releases);
								                }, function (error) {
								                	console.log(error.status);
								                });
								          };
								          
								          
								          $scope.searchByStatus = function () {
												 
												 SearchService.SearchReleaseByStatus($scope.searchStatus)
									                .then(function(response) {
									                	
									                	console.log(response.data);
									                	
									                	$rootScope.searchedRelease = response.data;
									                	$location.path('/searchRelease');	
									                	
									                	console.log($scope.releases);
									                }, function (error) {
									                	console.log(error.status);
									                });
									          };
	*/				          
    
}]);