(function() {
	'use strict';
	angular.module('testApp').controller(
			'dmViewEditReleaseCtrl',
			[
					'$scope',
					'$rootScope',
					'$location',
					'$routeParams',
					'EditReleaseService',
					function($scope, $rootScope, $location, $routeParams,
							EditReleaseService) {

						alert("in dm view edit rel");

						/*
						 * $scope.releaseDetails =
						 * EditReleaseService.GetDetails();
						 * 
						 * alert($scope.releaseDetails);
						 */

						 $scope.releaseDetails = []; 

						/*
						 * $scope.releaseDetails = { pid : 1, id : 1, title :
						 * 'RELEASE', des : 'bla bla', startDate : new
						 * Date(2013, 09, 22), plannedDate : new Date(2014, 09,
						 * 22), releaseDate : new Date(2013, 12, 22), type :
						 * 'Milestone', stage : 'QA Test', items : [ { id : '1',
						 * des : 'login view', status : 'completed', title :
						 * 'login view', }, { id : '2', des : 'login view',
						 * status : 'completed', title : 'login view', }, { id :
						 * '3', des : 'login view', status : 'completed', title :
						 * 'login view', } ],
						 * 
						 * status : 'Released', manager : 'Deepu', version :
						 * '2.3.1' };
						 */

						$scope.save = function() {
							alert("in save func");
							EditReleaseService.Save(function(response) {

								if (response.success) {
									console.log(response);
									console.log(response.data);
									$location.path('#/');

								} else {
									alert("in else");
									console.log(response.message);
									$scope.error = response.message;
								}
							});
						};

						/*
						 * $scope.getDetails = function(){
						 * EditReleaseService.GetDetails(); .then( function(d) {
						 * console.log(d); $scope.releaseDetails = d; },
						 * function(errResponse){ console.error('Error while
						 * fetching Currencies'); } ); };
						 */

/*						$scope.getDetails = function() {
							alert("in releaseDetails func");
							
							 * alert("in ctrl "+EditReleaseService
							 * .GetDetails());
							 

							$scope.releaseDetails = EditReleaseService
									.GetDetails(function(response) {
										alert("inside ctrl function");
										alert(response.success);
										if (response.success) {
											alert("in response.success")
											console.log(JSON
													.stringify(response.data));
											$location.path('#/');
										} else {
											alert("in else");
											console.log(response.message);
											$scope.error = response.message;
										}
									}

									);
						};*/
						
						
						$scope.getDetails = function() {
							alert("in ctrl get dets");
							EditReleaseService.GetDetails()
					            .then(function (response) {
					            	alert(JSON
											.stringify(response.data));
					                $scope.releaseDetails = response.data;
					                alert($scope.releaseDetails);
					            }, function (error) {
					                $scope.status = 'Unable to load release data: ' + error.message;
					            });
					    }

						var id = parseInt($routeParams.id, 10);

						console.log(id);

					} ]);
})();
