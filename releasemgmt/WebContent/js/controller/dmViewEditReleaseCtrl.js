angular.module('testApp')
    .controller('dmViewEditReleaseCtrl', ['$scope', '$rootScope', '$routeParams','$location', '$window', 'ViewService', 'DetailsService', 'UpdateService',
        function ($scope, $rootScope, $routeParams, $location, $window, ViewService, DetailsService, UpdateService) {

							$scope.releaseDetails = {};
							$scope.relDets = {};
							var updatedRelease = {};
							
							var releaseId = parseInt($routeParams.id);
							var projectId = $rootScope.projectId;
							

							$scope.releaseTypes = [ 'major', 'minor', 'build','milestone', 'final' ];
							$scope.releaseTo = [ 'QA Test', 'production', 'Dev Test' ];
							$scope.releaseStatus = [ 'planned', 'released', 'delayed','suspended', 'resumed' ];
							
						$scope.getDetails=function(){	DetailsService.GetReleaseDetails(releaseId,projectId)
									.then(function(response) {

												$scope.relDets = response.data;
												$scope.releaseDetails.releaseId = response.data.releaseId;
												$scope.releaseDetails.releaseTitle = response.data.releaseTitle;
												$scope.releaseDetails.releaseDescription = response.data.releaseDescription;
												$scope.releaseDetails.releaseStartDate = new Date(
														response.data.releaseStartDate);
												$scope.releaseDetails.releasePlannedDate = new Date(
														response.data.releasePlanneDdate);
												$scope.releaseDetails.actualReleaseDate = new Date(
														response.data.actualReleaseDate);
												$scope.releaseDetails.releaseType = response.data.releaseType;
												$scope.releaseDetails.releaseTo = response.data.releaseTo;
												$scope.releaseDetails.releaseStatus = response.data.releaseStatus;
												$scope.releaseDetails.releaseVersion = response.data.releaseVersion;

												
									},function (error) {
						                $scope.status = 'Unable to load release data: ' + error.message;
						            });
						};
							
							
							 $scope.updateRelease = function () { 
									$scope.relDets.releaseId = $scope.releaseDetails.releaseId;
									$scope.relDets.releaseTitle = $scope.releaseDetails.releaseTitle;
									$scope.relDets.releaseDescription = $scope.releaseDetails.releaseDescription;
									$scope.relDets.releaseStartDate = new Date(
											$scope.releaseDetails.releaseStartDate);
									$scope.relDets.releasePlanneDdate = new Date(
											$scope.releaseDetails.releasePlannedDate);
									$scope.relDets.actualReleaseDate = new Date(
											$scope.releaseDetails.actualReleaseDate);
									$scope.relDets.releaseType = $scope.releaseDetails.releaseType;
									$scope.relDets.releaseTo = $scope.releaseDetails.releaseTo;
									$scope.relDets.releaseStatus = $scope.releaseDetails.releaseStatus;
									$scope.relDets.releaseVersion = $scope.releaseDetails.releaseVersion;
									
									updatedRelease = $scope.relDets;
									
									console.log(updatedRelease);
									
					              UpdateService.UpdateReleaseDetails(releaseId, updatedRelease)
					                .then(function (response) {
					                	alert("Updated successfully");
					                	$location.path('/dmView');
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