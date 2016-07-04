angular.module('testApp')
    .controller('dmViewIterationDetailsCtrl', ['$scope', '$rootScope', '$routeParams','$location', '$window', 'ViewService', 'DetailsService',
                     function ($scope, $rootScope, $routeParams, $location, $window, ViewService, DetailsService) {

							$scope.iterationDetails = {};
							
							var iterationId = parseInt($routeParams.id);
							var projectId = $rootScope.projectId;
							
						$scope.getIterationDetails=function(){
							DetailsService.GetIterationDetails(iterationId)
									.then(function(response) {


												$scope.iterationDetails.iterationId = response.data.iterationId;
												$scope.iterationDetails.iterationTitle = response.data.iterationTitle;
												$scope.iterationDetails.iterationDescription = response.data.iterationDescription;
												$scope.iterationDetails.iterationStartDate = new Date(
														response.data.iterationStartDate);
												$scope.iterationDetails.iterationEndDate = new Date(
														response.data.iterationEndDate);
												$scope.iterationDetails.iterationStatus = response.data.iterationStatus;
												$scope.iterationDetails.iterationType = response.data.iterationType;
												
									},function (error) {
						                $scope.status = 'Unable to load release data: ' + error.message;
						            });
						};
    
}]);