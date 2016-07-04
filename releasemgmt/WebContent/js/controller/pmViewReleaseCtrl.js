angular
		.module('testApp')
		.controller(
				'pmViewReleaseCtrl',
				[
						'$scope',
						'$rootScope',
						'$routeParams',
						'$location',
						'ViewService',
						function($scope, $rootScope, $routeParams, $location,
								ViewService) {

							$scope.releases = {};

							$rootScope.projectId = parseInt($routeParams.id);
												
							
							var promise = ViewService.GetReleases($rootScope.projectId);
							promise
									.then(
											function(response) {
												console.log("in promise.then success");
														$scope.releases = response.data;
														
/*														$scope.releaseDetails.releaseId = response.data[int].releaseId;
														$scope.releaseDetails.releaseTitle = response.data[int].releaseTitle;
														$scope.releaseDetails.releaseDescription = response.data[int].releaseDescription;
														$scope.releaseDetails.releaseStartDate = new Date(
																response.data[int].releaseStartDate);
														$scope.releaseDetails.releasePlannedDate = new Date(
																response.data[int].releasePlanneDdate);
														$scope.releaseDetails.actualReleaseDate = new Date(
																response.data[int].actualReleaseDate);
														$scope.releaseDetails.releaseType = response.data[int].releaseType;
														$scope.releaseDetails.releaseTo = response.data[int].releaseTo;
														$scope.releaseDetails.releaseStatus = response.data[int].releaseStatus;
														$scope.releaseDetails.releaseVersion = response.data[int].releaseVersion;*/
											},
											function(error) {
												$scope.status = 'Unable to load release data: '
														+ error.message;
											});
						} ]);



/*(function() {
	'use strict';
	angular.module('testApp').controller('dmViewReleaseCtrl',
			function($scope, $routeParams, $location) {

		 $scope.header = 'header';
		alert("in dmviewrel");
		$scope.releases = [

		          		{	
		          			     			
		          			id : 1,
		          			title : 'RELEASE',
		          			des : 'bla bla'
		          		},

		          		{
		          			id : 2,
		          			title : 'LEAVE',
		          			des : 'kuch bhi'
		          		} ];
		var id = parseInt($routeParams.id, 10);

		console.log(id);

		for (var int = 0; int < scope.releases.length; int++) {
			
		//	alert(scope.releases[int].pid);
			
			if (id == scope.releases[int].pid) {
				console.log("success");
				break;
			}
			break;
		}

	});
})();*/