(function() {
  'use strict';
angular.module('testApp').controller('dmViewCtrl', function($scope) {
    $scope.header = 'header';
    alert("in dmviewctrl");
	$scope.projects = [              

{	id:1,title:'RELEASE',des:'bla bla'},

{	id:2,title:'LEAVE',des:'kuch bhi'}
];
	
});
})();