(function() {
	'use strict';
	angular.module('testApp').controller('dmViewReleaseCtrl',
			function($scope, $routeParams, $location) {

		 $scope.header = 'header';
		alert("in dmviewrel");
		$scope.releases = [

		          		{	
		          			     			
		          			id : 1,
		          			title : 'RELEASE',
		          			des : 'bla bla'
		          		},

		          		{
		          			id : 2,
		          			title : 'LEAVE',
		          			des : 'kuch bhi'
		          		} ];
		var id = parseInt($routeParams.id, 10);

		console.log(id);

/*		for (var int = 0; int < scope.releases.length; int++) {
			
		//	alert(scope.releases[int].pid);
			
			if (id == scope.releases[int].pid) {
				console.log("success");
				break;
			}
			break;
		}*/

	});
})();