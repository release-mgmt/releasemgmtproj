(function(){angular.module('testApp')
    .service('DetailsService', function ($http,$q) {
    	
    	   this.GetReleaseDetails = function(releaseId,projectId){
    		   console.log("in service get relese details");
    		   var deferred = $q.defer();
    		   $http.get('http://172.27.233.6:8080/SpringRestTemplateAsMediator/project/getReleaseInfo/' + projectId + '/' + releaseId)
    		   .then(function(data) { 
    			   console.log("in service after then");
    			   console.log("in service"+data);
			     	   deferred.resolve(data);
           }); 
              return deferred.promise;
            };
      

            this.GetIterationDetails = function () {
            	var deferred = $q.defer();
     		   $http.get('http://172.27.233.6:8080/SpringHibernateProject/project/authenticateUser')
    		   .then(function(data) { 
			     	   deferred.resolve(data);
           }); 
              return deferred.promise;
            };
            
 });


})();