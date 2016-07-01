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
				}).when('/dmView', {
					templateUrl : 'dmView.html',
					controller : 'dmViewCtrl'
				}).when('/dmViewRelease/:id', {
					templateUrl : 'dmViewRelease.html',
					controller : 'dmViewReleaseCtrl'
				}).when('/dmViewEditRelease/:id', {
					templateUrl : 'dmViewEditRelease.html',
					controller : 'dmViewEditReleaseCtrl'
				}).when('/dmViewIteraion/:id', {
					templateUrl : 'dmViewIterations.html',
					controller : 'dmViewIterationCtrl'
				}).otherwise({
					redirectTo : 'invalid.html'
				});

			} ]);
}());