angular.module('testApp')
    .controller('pmViewAddIterationCtrl', ['$scope', '$rootScope', '$routeParams', '$location','AddService', 
        function ($scope, $rootScope, $routeParams, $location, AddService) {

							console.log("in ctrl of add rel");

							$scope.newIteration = {};
							
							var projectId = $rootScope.projectId;
							

							$scope.iterationTypes = [ 'Dev', 'QA', 'planning','release', 'Regression' ];
							$scope.iterationStatus = [ 'planned', 'working', 'completed'];

							
							var releaseId = $rootScope.releaseId;
							
							 $scope.addIteration = function () { 
								 console.log("in add ioteratn");
									$scope.newIteration.iterationTitle = $scope.iterationTitle;
									$scope.newIteration.iterationDescription = $scope.iterationDescription;
									$scope.newIteration.iterationStartDate = new Date(
											$scope.iterationStartDate);
									$scope.newIteration.iterationPlanneDdate = new Date(
											$scope.iterationPlannedDate);
									$scope.newIteration.actualiterationDate = new Date(
											$scope.actualiterationDate);
									$scope.newIteration.iterationType = $scope.iterationType;
									$scope.newIteration.iterationTo = $scope.iterationTo;
									$scope.newIteration.iterationStatus = $scope.iterationStatus;
									
									console.log($scope.newIteration);
									
					              AddService.AddIteration(releaseId, $scope.newIteration)
					                .then(function (response) {
					                	alert("iteration added successfully");
					                	$location.path('#/pmView');
					                    $scope.status = 'Added iteration! Refreshing iteration list.';
					                }, function (error) {
					                    $scope.status = 'Unable to add iteration: ' + error.message;
					                });
					          };
 
 }]);