angular.module('testApp').controller(
		'dmViewCtrl',
		[
				'$scope',
				'$rootScope',
				'$routeParams',
				'$location',
				'ViewService',
				function($scope, $rootScope, $routeParams, $location,
						ViewService) {

					
					$scope.projects = {};

					var emp = $rootScope.eId;

					console.log(emp);

				//	allProjects();
					
					$scope.allProjects = function() {

						console.log("in all proj");
						ViewService.GetProjects(emp).then(function(response) {							
							$scope.projects = response.data;
						}, function(error) {
							console.log(error.status);
						});
					};

				} ]);



/*
 * (function() { 'use strict'; angular.module('testApp').controller(
 * 'dmViewEditReleaseCtrl', [ '$scope', '$rootScope', '$location',
 * '$routeParams', 'EditReleaseService', function($scope, $rootScope, $location,
 * $routeParams, EditReleaseService) {
 * 
 * alert("in dm view edit rel");
 * 
 * 
 * $scope.releaseDetails = EditReleaseService.GetDetails();
 * 
 * alert($scope.releaseDetails);
 * 
 * 
 * $scope.releaseDetails = [];
 * 
 * 
 * $scope.releaseDetails = { pid : 1, id : 1, title : 'RELEASE', des : 'bla
 * bla', startDate : new Date(2013, 09, 22), plannedDate : new Date(2014, 09,
 * 22), releaseDate : new Date(2013, 12, 22), type : 'Milestone', stage : 'QA
 * Test', items : [ { id : '1', des : 'login view', status : 'completed', title :
 * 'login view', }, { id : '2', des : 'login view', status : 'completed', title :
 * 'login view', }, { id : '3', des : 'login view', status : 'completed', title :
 * 'login view', } ],
 * 
 * status : 'Released', manager : 'Deepu', version : '2.3.1' };
 * 
 * 
 * $scope.save = function() { alert("in save func");
 * EditReleaseService.Save(function(response) {
 * 
 * if (response.success) { console.log(response); console.log(response.data);
 * $location.path('#/');
 *  } else { alert("in else"); console.log(response.message); $scope.error =
 * response.message; } }); };
 * 
 * 
 * $scope.getDetails = function(){ EditReleaseService.GetDetails(); .then(
 * function(d) { console.log(d); $scope.releaseDetails = d; },
 * function(errResponse){ console.error('Error while fetching Currencies'); } ); };
 * 
 * 
 * $scope.getDetails = function() { alert("in releaseDetails func");
 * 
 * alert("in ctrl "+EditReleaseService .GetDetails());
 * 
 * 
 * $scope.releaseDetails = EditReleaseService .GetDetails(function(response) {
 * alert("inside ctrl function"); alert(response.success); if (response.success) {
 * alert("in response.success") console.log(JSON .stringify(response.data));
 * $location.path('#/'); } else { alert("in else");
 * console.log(response.message); $scope.error = response.message; } }
 *  ); };
 * 
 * 
 * $scope.getDetails = function() { alert("in ctrl get dets");
 * EditReleaseService.GetDetails() .then(function (response) { alert(JSON
 * .stringify(response.data)); $scope.releaseDetails = response.data;
 * alert($scope.releaseDetails); }, function (error) { $scope.status = 'Unable
 * to load release data: ' + error.message; }); }
 * 
 * var id = parseInt($routeParams.id, 10);
 * 
 * console.log(id);
 *  } ]); })();
 */



/*angular
		.module('testApp')
		.controller(
				'dmViewCtrl',
				[
						'$scope',
						'$routeParams',
						'$location',
						'ViewService',
						function($scope, $routeParams, $location,
								ViewService) {

							$scope.projects = {};

							var projectId = parseInt($routeParams.id);

							var promise = ViewService.GetProjects();
							promise
									.then(
											function(response) {

												for (var int = 0; int < response.data.length; int++) {

													if (projectId == response.data[int].projectId) {
														$scope.projects = response.data[int];
														
														$scope.releaseDetails.releaseId = response.data[int].releaseId;
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
														$scope.releaseDetails.releaseVersion = response.data[int].releaseVersion;

														break;
													}
													break;
												}
											},
											function(error) {
												$scope.status = 'Unable to load project data: '
														+ error.message;
											});
						} ]);*/

/*
 * (function() { 'use strict';
 * angular.module('testApp').controller('dmViewCtrl', function($scope) {
 * $scope.header = 'header'; alert("in dmviewctrl"); $scope.projects = [
 *  { id:1,title:'RELEASE',des:'bla bla'},
 *  { id:2,title:'LEAVE',des:'kuch bhi'} ];
 * 
 * }); })();
 */



/*(function() {
  'use strict';
angular.module('testApp').controller('dmViewCtrl', function($scope) {
    $scope.header = 'header';
    alert("in dmviewctrl");
	$scope.projects = [              

{	id:1,title:'RELEASE',des:'bla bla'},

{	id:2,title:'LEAVE',des:'kuch bhi'}
];
	
});
})();*/