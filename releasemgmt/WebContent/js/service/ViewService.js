angular.module('testApp')
    .service('ViewService', function ($http,$q) {

    	   this.GetProjects = function(emp){
    		   var deferred = $q.defer();
    		   $http.get('http://localhost:8080/releasemanagement/project/getProjects/' + emp)
    		   .then(function(data) { 
			     	   deferred.resolve(data);
           }); 
              return deferred.promise;
            };
      
            
           this.GetReleases = function (projectId) {
        	   var deferred = $q.defer();
            	 console.log("in allRel()");
     		   $http.get('http://localhost:8080/releasemanagement/project/projectReleaseList/' + projectId )
    		   .then(function(data) { 
    			   console.log(data);
			     	   deferred.resolve(data);
           }); 
     		   console.log(deferred.promise);
              return deferred.promise;
            };
            
            
            this.GetIterations = function (releaseId) {
            	console.log("in service");
            	 var deferred = $q.defer();
      		   $http.get('http://localhost:8080/releasemanagement/project/getReleaseIterations/' + releaseId )
     		   .then(function(data) { 
 			     	   deferred.resolve(data);
            }); 
               return deferred.promise;
             };
            
 });


