(function(){angular.module('testApp')
    .service('UpdateService', function ($http,$q) {
    	
    	   
/*    	   this.UpdateRelease = function (id, rel) {
               return $http.put('http://172.27.233.6:8080/SpringRestTemplateAsMediator/project/updateRelease/' + id ,  rel)
           };*/

    	   this.UpdateReleaseDetails = function(id, rel){
    		   var deferred = $q.defer();
    	    	  
    		   $http.put('http://localhost:8080/releasemanagement/project/updateRelease/' + id ,  rel)
    		   .then(function(data) { 
			     	   deferred.resolve(data);
           }); 
              return deferred.promise;
            };
      

            this.UpdateIterationDetails = function (id,itr) {
            	 var deferred = $q.defer();
           	  
            	$http.put('http://localhost:8080/releasemanagement/project/updateIteration/' + id , itr)
    		   .then(function(data) { 
			     	   deferred.resolve(data);
           }); 
              return deferred.promise;
            };
            
 });


})();