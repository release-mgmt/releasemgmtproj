angular
		.module('testApp')
		.controller(
				'pmViewCtrl',
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

														break;
													}
													break;
												}
											},
											function(error) {
												$scope.status = 'Unable to load project data: '
														+ error.message;
											});
						} ]);

/*
 * (function() { 'use strict';
 * angular.module('testApp').controller('dmViewCtrl', function($scope) {
 * $scope.header = 'header'; alert("in dmviewctrl"); $scope.projects = [
 *  { id:1,title:'RELEASE',des:'bla bla'},
 *  { id:2,title:'LEAVE',des:'kuch bhi'} ];
 * 
 * }); })();
 */