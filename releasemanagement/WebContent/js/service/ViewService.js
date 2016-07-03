angular.module('testApp')
    .service('ViewService', function ($http,$q) {

    	   this.GetProjects = function(emp){
    		   var deferred = $q.defer();
    		   $http.get('http://172.27.233.6:8080/SpringRestTemplateAsMediator/project/getProjects/' + emp)
    		   .then(function(data) { 
			     	   deferred.resolve(data);
           }); 
              return deferred.promise;
            };
      
            
           this.GetReleases = function (projectId) {
        	   var deferred = $q.defer();
            	 console.log("in allRel()");
     		   $http.get('http://172.27.233.6:8080/SpringRestTemplateAsMediator/project/projectReleaseList/' + projectId )
    		   .then(function(data) { 
    			   console.log(data);
			     	   deferred.resolve(data);
           }); 
     		   console.log(deferred.promise);
              return deferred.promise;
            };
            
            
            this.GetIterations = function () {
            	 var deferred = $q.defer();
      		   $http.get('http://172.27.233.6:8080/SpringHibernateProject/project/authenticateUser')
     		   .then(function(data) { 
 			     	   deferred.resolve(data);
            }); 
               return deferred.promise;
             };
            
 });


