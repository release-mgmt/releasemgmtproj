angular.module('testApp')
    .service('AddService',function ($http,$q) {
    	
    	   
/*    	   this.UpdateRelease = function (id, rel) {
               return $http.put('http://172.27.233.6:8080/SpringRestTemplateAsMediator/project/updateRelease/' + id ,  rel)
           };*/

    	   this.AddRelease = function(id, rel){
    		   var deferred = $q.defer();
    	    	  
    		   $http.post('http://localhost:8080/releasemanagement/project//insertRelease/' + id ,  rel)
    		   .then(function(data) { 
			     	   deferred.resolve(data);
           }); 
              return deferred.promise;
            };
      

            this.UpdateIterationDetails = function () {
            	 var deferred = $q.defer();
           	  
            	$http.put('http://localhost:8080/releasemanagement/project/authenticateUser')
    		   .then(function(data) { 
			     	   deferred.resolve(data);
           }); 
              return deferred.promise;
            };
            
 });

