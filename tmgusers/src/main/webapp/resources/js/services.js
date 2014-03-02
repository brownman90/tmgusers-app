'use strict';

var tmgServices = angular.module('tmgServices', [ 'ngResource' ]);

tmgServices.factory('Users', [ '$resource', function($resource) {
	return $resource('api/user/list', {}, {
		query : {
			method : 'GET',
			isArray : false
		}
	});
} ]);

tmgServices.factory('CRUDUser', function($resource) {
	return $resource('api/user', {
		id : '@id'
	}, {
		'update' : {
			method : 'PUT'
		}
	});
});
