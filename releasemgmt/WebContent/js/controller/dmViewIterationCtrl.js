angular.module('testApp')
    .controller('dmViewIterationCtrl', ['$scope', '$routeParams', 'ViewService', 
        function ($scope, $routeParams, ViewService) {

							$scope.iterations = {};
							
							var releaseId = parseInt($routeParams.id);

							var promise = ViewService.GetIterations(releaseId);
							promise
									.then(function(response) {
										
												$scope.iterations = response.data;
												
									},function (error) {
						                $scope.status = 'Unable to load iteration data: ' + error.message;
						            });
    
}]);