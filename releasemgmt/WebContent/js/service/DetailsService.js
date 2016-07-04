(function(){angular.module('testApp')
    .service('DetailsService', function ($http,$q) {
    	
    	   this.GetReleaseDetails = function(releaseId,projectId){
    		   console.log("in service get relese details");
    		   var deferred = $q.defer();
    		   $http.get('http://localhost:8080/releasemanagement/project/getReleaseInfo/' + projectId + '/' + releaseId)
    		   .then(function(data) { 
    			   console.log("in service after then");
    			   console.log("in service"+data);
			     	   deferred.resolve(data);
           }); 
              return deferred.promise;
            };
      

            this.GetIterationDetails = function (iterationId) {
            	var deferred = $q.defer();
     		   $http.get('http://localhost:8080/releasemanagement/project//getIterationDetails/' + iterationId)
    		   .then(function(data) { 
			     	   deferred.resolve(data);
           }); 
              return deferred.promise;
            };
            
 });


})();