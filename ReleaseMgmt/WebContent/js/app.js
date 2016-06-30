(function() {
  'use strict';
 
  angular
    .module('testApp', ['ngRoute'])
    .config(['$routeProvider', function(rp) {
      rp
        .when('/', {
         templateUrl: 'login.html',
          controller: 'LoginCtrl'
        })
        
        .when('/pmView', {
          templateUrl: 'pmView.html',
          controller: 'pmViewCtrl'
        }) 
        .when('/dmView', {
            templateUrl: 'dmView.html',
            controller: 'dmViewCtrl'
          })
          .when('/dmViewRelease/:id', {
              templateUrl: 'dmViewRelease.html',
              controller: 'dmViewReleaseCtrl'
            })
        .otherwise({
          redirectTo: 'invalid.html'
        });
     
    }]);
}());