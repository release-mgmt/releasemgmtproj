angular.module('testApp')
    .controller('pmViewEditIterationCtrl', ['$scope', '$rootScope', '$routeParams','$location', '$window', 'ViewService', 'DetailsService', 'UpdateService',
        function ($scope, $rootScope, $routeParams, $location, $window, ViewService, DetailsService, UpdateService) {

							$scope.iterationDetails = {};
							$scope.iterationDets = {};
							var updatedIteration = {};
							
							var iterationId = parseInt($routeParams.id);
							var projectId = $rootScope.projectId;
							



							$scope.iterationTypes = [ 'Dev', 'QA', 'planning','release', 'Regression' ];
							$scope.iterationStatus = [ 'planned', 'working', 'completed'];
							
						$scope.getDetails=function(){DetailsService.GetIterationDetails(iterationId,projectId)
									.then(function(response) {

												$scope.iterationDets = response.data;
												$scope.iterationDetails.iterationId = response.data.iterationId;
												$scope.iterationDetails.iterationTitle = response.data.iterationTitle;
												$scope.iterationDetails.iterationDescription = response.data.iterationDescription;
												$scope.iterationDetails.iterationStartDate = new Date(
														response.data.iterationStartDate);
												$scope.iterationDetails.iterationEndDate = new Date(
														response.data.iterationEndDate);
												$scope.iterationDetails.iterationType = response.data.iterationType;
												$scope.iterationDetails.iterationStatus = response.data.iterationStatus;
												$scope.iterationDetails.iterationItems = response.data.iterationItems;

												
									},function (error) {
						                $scope.status = 'Unable to load release data: ' + error.message;
						            });
						};
							
							
							 $scope.updateIteration = function () { 
									$scope.iterationDets.iterationId = $scope.iterationDetails.iterationId;
									$scope.iterationDets.iterationTitle = $scope.iterationDetails.iterationTitle;
									$scope.iterationDets.iterationDescription = $scope.iterationDetails.iterationDescription;
									$scope.iterationDets.iterationStartDate = new Date(
											$scope.iterationDetails.iterationStartDate);
									$scope.iterationDets.iterationPlanneDdate = new Date(
											$scope.iterationDetails.iterationPlannedDate);
									$scope.iterationDets.actualiterationDate = new Date(
											$scope.iterationDetails.actualiterationDate);
									$scope.iterationDets.iterationType = $scope.iterationDetails.iterationType;
									$scope.iterationDets.iterationTo = $scope.iterationDetails.iterationTo;
									$scope.iterationDets.iterationStatus = $scope.iterationDetails.iterationStatus;
									$scope.iterationDets.iterationVersion = $scope.iterationDetails.iterationVersion;
									
									updatedIteration = $scope.iterationDets;
									
									console.log(updatedIteration);
									
					              UpdateService.UpdateIterationDetails(iterationId, updatedIteration)
					                .then(function (response) {
					                	alert("Updated successfully");
					                	$location.path('/pmView');
					                    $scope.status = 'Updated Release! Refreshing release list.';
					                }, function (error) {
					                	console.log(error.status);
					                    $scope.status = 'Unable to update release: ' + error.message;
					                });
					          };
					          
					          $scope.goBack = function(){
					        	  console.log("in goBack()");
					        	  window.history.back();
					          }
}]);