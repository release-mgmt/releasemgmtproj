(function(){angular.module('testApp')
    .service('UpdateService', function ($http,$q) {
    	
    	   var deferred = $q.defer();
    	   
/*    	   this.UpdateRelease = function (id, rel) {
               return $http.put('http://172.27.233.6:8080/SpringRestTemplateAsMediator/project/updateRelease/' + id ,  rel)
           };*/

    	   this.UpdateReleaseDetails = function(id, rel){
    		   $http.get('http://172.27.233.6:8080/SpringRestTemplateAsMediator/project/updateRelease/' + id ,  rel)
    		   .then(function(data) { 
			     	   deferred.resolve(data);
           }); 
              return deferred.promise;
            };
      

            this.UpdateIterationDetails = function () {
     		   $http.get('http://172.27.233.6:8080/SpringHibernateProject/project/authenticateUser')
    		   .then(function(data) { 
			     	   deferred.resolve(data);
           }); 
              return deferred.promise;
            };
            
 });


})();