(function() {
  'use strict';
angular.module('testApp').controller('dmViewReleaseCtrl',['$scope','$routeParams','$location', dmViewReleaseCtrl]);
		
	function dmViewReleaseCtrl(scope,routeParams,location) {
  
	var id = parseInt(routeParams.id,10);
	
	console.log(id);
	
	
}
}());