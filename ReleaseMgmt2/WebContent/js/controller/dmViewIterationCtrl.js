(function() {
	'use strict';
	angular.module('testApp').controller('dmViewIterationCtrl',
			function($scope, $routeParams, $location) {

				$scope.header = 'header';
				alert("in dmviewitr");
				$scope.iterations = [ {
					rid : 1,
					id : 1,
					title : 'RELEASE',
					des : 'bla bla',
					startDate : '02/11/1993',
					endDate : '30/11/1993',
					items : [ {
						id : '1',
						des : 'login view',
						status : 'completed',
						title : 'login view',
					}, {
						id : '2',
						des : 'login view',
						status : 'completed',
						title : 'login view',
					}, {
						id : '3',
						des : 'login view',
						status : 'completed',
						title : 'login view',
					} ],

					status : 'Released',
					type : 'Dev'
				}, {
					rid : 1,
					id : 2,
					title : 'RELEASE',
					des : 'bla bla',
					startDate : '02/11/1993',
					endDate : '30/11/1993',
					items : [ {
						id : '1',
						des : 'login view',
						status : 'completed',
						title : 'login view',
					}, {
						id : '2',
						des : 'login view',
						status : 'completed',
						title : 'login view',
					}, {
						id : '3',
						des : 'login view',
						status : 'completed',
						title : 'login view',
					} ],

					status : 'Released',
					type : 'Dev'
				} ];
				var id = parseInt($routeParams.id, 10);

				console.log(id);

				/*
				 * for (var int = 0; int < scope.releases.length; int++) { //
				 * alert(scope.releases[int].pid);
				 * 
				 * if (id == scope.releases[int].pid) { console.log("success");
				 * break; } break; }
				 */

			});
})();