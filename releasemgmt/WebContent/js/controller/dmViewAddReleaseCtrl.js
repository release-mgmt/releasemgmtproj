angular.module('testApp')
    .controller('dmViewAddReleaseCtrl', ['$scope', '$rootScope', '$routeParams', '$location','AddService', 
        function ($scope, $rootScope, $routeParams, $location, AddService) {

							console.log("in ctrl of add rel");

							$scope.newRelease = {};

							var id = parseInt($routeParams.id);
							
							var projectId = $rootScope.projectId;
							
							$scope.releaseTypes = ['minor','major','build','milestone','final'];
							
							$scope.releaseStage = ['QA Test','production','Dev Test'];
							
							$scope.releaseStats = ['planned','released','delayed','suspended','resumed'];

							/*var promise = EditReleaseService.GetDetails();
							promise
									.then(function(response) {
										console
												.log("in proise then in ctrl"
														+ JSON
																.stringify(response.data));

										
										console.log(id);

										for (var int = 0; int < response.data.length; int++) {

											if (id == response.data[int].releaseId) {
												console.log("success");
												 $scope.relDets = response.data[int];
												$scope.releaseDetails.releaseId = response.data[int].releaseId;
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
												$scope.releaseDetails.items = response.data[int].items;
												$scope.releaseDetails.releaseStatus = response.data[int].releaseStatus;
												$scope.releaseDetails.manager = response.data[int].manager;
												$scope.releaseDetails.releaseVersion = response.data[int].releaseVersion;

												break;
											}
											break;
										}
									},function (error) {
						                $scope.status = 'Unable to load release data: ' + error.message;
						            });*/
							
							
							 $scope.addRelease = function () { 
								 console.log("in addRel()");
									/*$scope.relDets.releaseId = $scope.releaseDetails.releaseId;*/
									$scope.newRelease.releaseTitle = $scope.releaseTitle;
									$scope.newRelease.releaseDescription = $scope.releaseDescription;
									$scope.newRelease.releaseStartDate = new Date(
											$scope.releaseStartDate);
									$scope.newRelease.releasePlanneDdate = new Date(
											$scope.releasePlannedDate);
									$scope.newRelease.actualReleaseDate = new Date(
											$scope.actualReleaseDate);
									$scope.newRelease.releaseType = $scope.releaseType;
									$scope.newRelease.releaseTo = $scope.releaseTo;
									$scope.newRelease.releaseStatus = $scope.releaseStatus;
									
									console.log($scope.newRelease);
									
					              AddService.AddRelease(projectId, $scope.newRelease)
					                .then(function (response) {
					                	alert("Release added successfully");
					                	$location.path('#/dmView');
					                    $scope.status = 'Added Release! Refreshing release list.';
					                }, function (error) {
					                    $scope.status = 'Unable to add release: ' + error.message;
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