angular.module('testApp')
    .controller('dmViewAddReleaseCtrl', ['$scope', '$rootScope', '$routeParams', '$location','AddService', 
        function ($scope, $rootScope, $routeParams, $location, AddService) {

							console.log("in ctrl of add rel");

							$scope.newRelease = {};

							var id = parseInt($routeParams.id);
							
							var projectId = $rootScope.projectId;
							
							$scope.releaseTypes = ['minor','major','build','milestone','final'];
							
							$scope.releaseStage = ['QA Test','production','Dev Test'];
							
							$scope.releaseStats = ['planned','released','delayed','suspended','resumed'];							
							
							 $scope.addRelease = function () { 
									$scope.newRelease.releaseTitle = $scope.releaseTitle;
									$scope.newRelease.releaseDescription = $scope.releaseDescription;
									$scope.newRelease.releaseStartDate = new Date(
											$scope.releaseStartDate);
									$scope.newRelease.releasePlanneDdate = new Date(
											$scope.releasePlannedDate);
									$scope.newRelease.actualReleaseDate = new Date(
											$scope.actualReleaseDate);
									$scope.newRelease.releaseType = $scope.releaseType;
									$scope.newRelease.releaseTo = $scope.releaseTo;
									$scope.newRelease.releaseStatus = $scope.releaseStatus;
									
									console.log($scope.newRelease);
									
					              AddService.AddRelease(projectId, $scope.newRelease)
					                .then(function (response) {
					                	alert("Release added successfully");
					                	$location.path('/dmView');
					                    $scope.status = 'Added Release! Refreshing release list.';
					                }, function (error) {
					                    $scope.status = 'Unable to add release: ' + error.message;
					                });
					          };
 
 }]);