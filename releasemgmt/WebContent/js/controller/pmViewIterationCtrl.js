angular.module('testApp')
    .controller('pmViewIterationCtrl', ['$scope', '$rootScope', '$routeParams', 'ViewService', 
        function ($scope, $rootScope, $routeParams, ViewService) {

							$scope.iterations = {};
							
							$rootScope.releaseId = parseInt($routeParams.id);

							var promise = ViewService.GetIterations($rootScope.releaseId);
							promise
									.then(function(response) {
										
												$scope.iterations = response.data;
												
									},function (error) {
						                $scope.status = 'Unable to load iteration data: ' + error.message;
						            });
    
}]);