angular.module('testApp')
    .controller('dmViewIterationCtrl', ['$scope', '$routeParams', 'ViewService', 
        function ($scope, $routeParams, ViewService) {

							$scope.iterations = {};
							$scope.itrDets = {};
							var newIteration = {};
							
							var releaseId = parseInt($routeParams.id);

							var promise = ViewService.GetIterations();
							promise
									.then(function(response) {
										
										for (var int = 0; int < response.data.length; int++) {

											if (id == response.data[int].iterationId) {
												console.log("success");
												$scope.relDets = response.data[int];
												$scope.iterations.iterationId = response.data[int].releaseId;
												$scope.iterations.iterationTitle = response.data[int].iterationTitle;
												$scope.iterations.iterationDescription = response.data[int].iterationDescription;
												$scope.iterations.iterationStartDate = new Date(
														response.data[int].iterationStartDate);
												$scope.iterations.iterationPlannedDate = new Date(
														response.data[int].iterationPlanneDdate);
												$scope.iterations.actualiterationDate = new Date(
														response.data[int].actualiterationDate);
												$scope.iterations.iterationType = response.data[int].iterationType;
												$scope.iterations.iterationTo = response.data[int].iterationTo;
												$scope.iterations.items = response.data[int].items;
												$scope.iterations.iterationStatus = response.data[int].iterationStatus;
												$scope.iterations.manager = response.data[int].manager;
												$scope.iterations.iterationVersion = response.data[int].iterationVersion;

												break;
											}
											break;
										}
									},function (error) {
						                $scope.status = 'Unable to load iteration data: ' + error.message;
						            });
							
							
							 $scope.updateRelease = function () { 
									$scope.relDets.releaseId = $scope.releaseDetails.releaseId;
									$scope.relDets.releaseTitle = $scope.releaseDetails.releaseTitle;
									$scope.relDets.releaseDescription = $scope.releaseDetails.releaseDescription;
									$scope.relDets.releaseStartDate = new Date(
											$scope.releaseDetails.releaseStartDate);
									$scope.relDets.releasePlanneDdate = new Date(
											$scope.releaseDetails.releasePlannedDate);
									$scope.relDets.actualReleaseDate = new Date(
											$scope.releaseDetails.actualReleaseDate);
									$scope.relDets.releaseType = $scope.releaseDetails.releaseType;
									$scope.relDets.releaseTo = $scope.releaseDetails.releaseTo;
									$scope.relDets.items = $scope.releaseDetails.items;
									$scope.relDets.releaseStatus = $scope.releaseDetails.releaseStatus;
									$scope.relDets.manager = $scope.releaseDetails.manager;
									$scope.relDets.releaseVersion = $scope.releaseDetails.releaseVersion;
									
									newRelease = $scope.relDets;
									
									console.log(newRelease);
									
					              EditReleaseService.UpdateRelease(newRelease)
					                .then(function (response) {
					                	$location.path('#/dmViewRelease');
					                    $scope.status = 'Updated Release! Refreshing release list.';
					                }, function (error) {
					                    $scope.status = 'Unable to update release: ' + error.message;
					                });
					          };
 
    /*function getDetails() {
        dataFactory.GetDetails()
            .then(function (response) {
                $scope.releaseDetails = response.data;
            }, function (error) {
                $scope.status = 'Unable to load release data: ' + error.message;
            });
    }*/

/*    $scope.updateCustomer = function (id) {
        var cust;
        for (var i = 0; i < $scope.customers.length; i++) {
            var currCust = $scope.customers[i];
            if (currCust.ID === id) {
                cust = currCust;
                break;
            }
        }

         dataFactory.updateCustomer(cust)
          .then(function (response) {
              $scope.status = 'Updated Customer! Refreshing customer list.';
          }, function (error) {
              $scope.status = 'Unable to update customer: ' + error.message;
          });
    };

    $scope.insertCustomer = function () {
        //Fake customer data
        var cust = {
            ID: 10,
            FirstName: 'JoJo',
            LastName: 'Pikidily'
        };
        dataFactory.insertCustomer(cust)
            .then(function (response) {
                $scope.status = 'Inserted Customer! Refreshing customer list.';
                $scope.customers.push(cust);
            }, function(error) {
                $scope.status = 'Unable to insert customer: ' + error.message;
            });
    };

    $scope.deleteCustomer = function (id) {
        dataFactory.deleteCustomer(id)
        .then(function (response) {
            $scope.status = 'Deleted Customer! Refreshing customer list.';
            for (var i = 0; i < $scope.customers.length; i++) {
                var cust = $scope.customers[i];
                if (cust.ID === id) {
                    $scope.customers.splice(i, 1);
                    break;
                }
            }
            $scope.orders = null;
        }, function (error) {
            $scope.status = 'Unable to delete customer: ' + error.message;
        });
    };

    $scope.getCustomerOrders = function (id) {
        dataFactory.getOrders(id)
        .then(function (response) {
            $scope.status = 'Retrieved orders!';
            $scope.orders = response.data;
        }, function (error) {
            $scope.status = 'Error retrieving customers! ' + error.message;
        });
    };*/
    
}]);



/*(function() {
	'use strict';
	angular.module('testApp').controller(
			'dmViewEditReleaseCtrl',
			[
					'$scope',
					'$rootScope',
					'$location',
					'$routeParams',
					'EditReleaseService',
					function($scope, $rootScope, $location, $routeParams,
							EditReleaseService) {

						alert("in dm view edit rel");

						
						 * $scope.releaseDetails =
						 * EditReleaseService.GetDetails();
						 * 
						 * alert($scope.releaseDetails);
						 

						 $scope.releaseDetails = []; 

						
						 * $scope.releaseDetails = { pid : 1, id : 1, title :
						 * 'RELEASE', des : 'bla bla', startDate : new
						 * Date(2013, 09, 22), plannedDate : new Date(2014, 09,
						 * 22), releaseDate : new Date(2013, 12, 22), type :
						 * 'Milestone', stage : 'QA Test', items : [ { id : '1',
						 * des : 'login view', status : 'completed', title :
						 * 'login view', }, { id : '2', des : 'login view',
						 * status : 'completed', title : 'login view', }, { id :
						 * '3', des : 'login view', status : 'completed', title :
						 * 'login view', } ],
						 * 
						 * status : 'Released', manager : 'Deepu', version :
						 * '2.3.1' };
						 

						$scope.save = function() {
							alert("in save func");
							EditReleaseService.Save(function(response) {

								if (response.success) {
									console.log(response);
									console.log(response.data);
									$location.path('#/');

								} else {
									alert("in else");
									console.log(response.message);
									$scope.error = response.message;
								}
							});
						};

						
						 * $scope.getDetails = function(){
						 * EditReleaseService.GetDetails(); .then( function(d) {
						 * console.log(d); $scope.releaseDetails = d; },
						 * function(errResponse){ console.error('Error while
						 * fetching Currencies'); } ); };
						 

						$scope.getDetails = function() {
							alert("in releaseDetails func");
							
							 * alert("in ctrl "+EditReleaseService
							 * .GetDetails());
							 

							$scope.releaseDetails = EditReleaseService
									.GetDetails(function(response) {
										alert("inside ctrl function");
										alert(response.success);
										if (response.success) {
											alert("in response.success")
											console.log(JSON
													.stringify(response.data));
											$location.path('#/');
										} else {
											alert("in else");
											console.log(response.message);
											$scope.error = response.message;
										}
									}

									);
						};
						
						
						$scope.getDetails = function() {
							alert("in ctrl get dets");
							EditReleaseService.GetDetails()
					            .then(function (response) {
					            	alert(JSON
											.stringify(response.data));
					                $scope.releaseDetails = response.data;
					                alert($scope.releaseDetails);
					            }, function (error) {
					                $scope.status = 'Unable to load release data: ' + error.message;
					            });
					    }

						var id = parseInt($routeParams.id, 10);

						console.log(id);

					} ]);
})();
*/