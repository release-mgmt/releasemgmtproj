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
					templateUrl : 'pmViewRelease.html',
					controller : 'pmViewReleaseCtrl'
				})

				.when('/pmViewIterationDetails/:id', {
					templateUrl : 'pmViewRelease.html',
					controller : 'pmViewReleaseCtrl'
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

				.otherwise({
					redirectTo : 'invalid.html'
				});

			} ]);
}());