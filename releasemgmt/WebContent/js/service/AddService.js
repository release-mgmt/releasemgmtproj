angular.module('testApp')
    .service('AddService',function ($http,$q) {
    	
    	   
/*    	   this.UpdateRelease = function (id, rel) {
               return $http.put('http://172.27.233.6:8080/SpringRestTemplateAsMediator/project/updateRelease/' + id ,  rel)
           };*/

    	   this.AddRelease = function(id, rel){
    		   var deferred = $q.defer();
    	    	  
    		   $http.post('http://localhost:8080/releasemanagement/project/insertRelease/' + id ,  rel)
    		   .then(function(data) { 
			     	   deferred.resolve(data);
           }); 
              return deferred.promise;
            };
            
     	   this.AddIteration = function(id, itr){
    		   var deferred = $q.defer();
    	    	  
    		   $http.post('http://localhost:8080/releasemanagement/project/insertIterations/' + id ,  itr)
    		   .then(function(data) { 
			     	   deferred.resolve(data);
           }); 
              return deferred.promise;
            };
            
 });

