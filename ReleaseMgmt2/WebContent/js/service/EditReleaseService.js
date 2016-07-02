(function() { 
	
	
	angular.module('testApp')
    .service('EditReleaseService', ['$http', function ($http) {

        var urlBase = 'http://172.27.233.6:8080/SpringHibernateProject/release/releaseList';

        this.GetDetails = function () {
        	alert("in service");
            return $http.get(urlBase);
        };
/*
        this.getCustomer = function (id) {
            return $http.get(urlBase + '/' + id);
        };

        this.insertCustomer = function (cust) {
            return $http.post(urlBase, cust);
        };

        this.updateCustomer = function (cust) {
            return $http.put(urlBase + '/' + cust.ID, cust)
        };

        this.deleteCustomer = function (id) {
            return $http.delete(urlBase + '/' + id);
        };

        this.getOrders = function (id) {
            return $http.get(urlBase + '/' + id + '/orders');
        };*/
    }])})
    ();
	
	
	
	/*
	 * }
	 * 
	 * 'use strict';
	 * 
	 * angular .module('testApp') .factory( 'EditReleaseService', [ '$http',
	 * '$q', function($http, $q) {
	 * 
	 * return {
	 * 
	 * GetDetails : function() { alert("in get detils fun") return $http .get(
	 * 'http://172.27.233.6:8080/SpringHibernateProject/release/releaseList')
	 * 
	 * .then( function(response) { console .log(JSON .stringify(response.data));
	 * return (response); }, function(errResponse) { console .error('Error while
	 * fetching users'); return $q .reject(errResponse); });
	 *  }
	 * 
	 * 
	 * angular .module('testApp') .service( 'EditReleaseService',
	 * function($http, $q) {
	 * 
	 * 
	 * 
	 * var releaseDetails =[ { pid : 1, id : 1, title : 'RELEASE', des : 'bla
	 * bla', startDate : new Date(2013, 09, 22), plannedDate : new Date(2014,
	 * 09, 22), releaseDate : new Date(2013, 12, 22), type : 'Milestone', stage :
	 * 'QA Test', items : [ { id : '1', des : 'login view', status :
	 * 'completed', title : 'login view', }, { id : '2', des : 'login view',
	 * status : 'completed', title : 'login view', }, { id : '3', des : 'login
	 * view', status : 'completed', title : 'login view', } ],
	 * 
	 * status : 'Released', manager : 'Deepu', version : '2.3.1' }];
	 * 
	 * 
	 * var GetDetails = function() { return $http .get(
	 * "http://172.27.233.6:8080/SpringHibernateProject/release/releaseList")
	 * .then( function(response) { return response.data; },
	 * function(errResponse) { console .error('Error while fetching users');
	 * return $q.reject(errResponse); }); };
	 * 
	 * 
	 * $http.get("http://172.27.233.6:8080/SpringHibernateProject/release/releaseList").success(function(response) {
	 * var releaseDetails = response.data; alert(releaseDetails); });
	 * 
	 * 
	 * 
	 * this.releaseDetails = function() { return
	 * $http.get('http://172.27.233.6:8080/SpringHibernateProject/release/releaseList'); }
	 * 
	 * var service = {}; alert("in edit rel serv before timeout");
	 * 
	 * var Save = function() {
	 * 
	 * alert("in save");
	 * 
	 * releaseDetails.forEach(function(rd) {
	 * 
	 * console.log(rd.id); console.log(releaseDetails.id); if (rd.id ==
	 * releaseDetails.id) {
	 * 
	 * rd = releaseDetails; console.log(rd); } }); };
	 * 
	 * var GetDetails = function() { alert("in GetDetails");
	 * alert(releaseDetails); return releaseDetails; };
	 * 
	 * return { Save : Save, GetDetails : GetDetails };
	 * 
	 * return service; })
	 *  };
	 *  } ]) }
	 */
