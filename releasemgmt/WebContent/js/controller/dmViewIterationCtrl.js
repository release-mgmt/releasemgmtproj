angular.module('testApp')
    .controller('dmViewIterationCtrl', ['$scope', '$routeParams', 'ViewService', 
        function ($scope, $routeParams, ViewService) {

							$scope.iterations = {};
							
							var releaseId = parseInt($routeParams.id);

							var promise = ViewService.GetIterations(releaseId);
							promise
									.then(function(response) {
										console.log("in retn of ctrl");
												$scope.iterations = response.data;
												console.log($scope.iterations);
												if($scope.iterations.iterationId==null ){
													console.log("in if")
													alert("No data found");
												window.history.back();
												
												}
									},function (error) {
						                $scope.status = 'Unable to load iteration data: ' + error.message;
						            });
    
}]);