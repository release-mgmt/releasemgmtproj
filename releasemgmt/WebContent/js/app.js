(function() {
	'use strict';

	angular.module('testApp', [ 'ngRoute' ]).config(
			[ '$routeProvider', function(rp) {
				rp.when('/', {
					templateUrl : 'login.html',
					controller : 'LoginCtrl'
				})

				.when('/pmView', {
					templateUrl : 'pmView.html',
					controller : 'pmViewCtrl'
				})
				
				.when('/pmViewRelease/:id', {
					templateUrl : 'pmViewRelease.html',
					controller : 'pmViewReleaseCtrl'
				})
				
				.when('/pmViewReleaseDetails/:id', {
					templateUrl : 'pmViewReleaseDetails.html',
					controller : 'pmViewReleaseDetailsCtrl'
				})
				
				.when('/pmViewIteration/:id', {
					templateUrl : 'pmViewIteration.html',
					controller : 'pmViewIterationCtrl'
				})

				.when('/pmViewIterationDetails/:id', {
					templateUrl : 'pmViewIterationDetails.html',
					controller : 'pmViewIterationDetailsCtrl'
				})
				.when('/pmViewEditIteration/:id', {
					templateUrl : 'pmViewEditIteration.html',
					controller : 'pmViewEditIterationCtrl'
				})
				
				.when('/pmViewAddIteration', {
					templateUrl : 'pmViewAddIteration.html',
					controller : 'pmViewAddIterationCtrl'
				})

				.when('/dmView', {
					templateUrl : 'dmView.html',
					controller : 'dmViewCtrl'
				})

				.when('/dmViewRelease/:id', {
					templateUrl : 'dmViewRelease.html',
					controller : 'dmViewReleaseCtrl'
				})

				.when('/dmViewEditRelease/:id', {
					templateUrl : 'dmViewEditRelease.html',
					controller : 'dmViewEditReleaseCtrl'
				})

				.when('/dmViewAddRelease', {
					templateUrl : 'dmViewAddRelease.html',
					controller : 'dmViewAddReleaseCtrl'
				})

				.when('/dmViewIteration/:id', {
					templateUrl : 'dmViewIteration.html',
					controller : 'dmViewIterationCtrl'
				})
				
				.when('/dmViewIterationDetails/:id', {
					templateUrl : 'dmViewIterationDetails.html',
					controller : 'dmViewIterationDetailsCtrl'
				})

			/*	.when('/searchRelease', {
					templateUrl : 'searchRelease.html',
					controller : 'searchReleaseCtrl'
				})
				*/
				.otherwise({
					redirectTo : 'invalid.html'
				});

			} ]);
}());