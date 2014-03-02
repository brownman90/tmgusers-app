'use strict';

var tmgApp = angular.module('tmgApp', [
  'ngResource',
  'ngRoute',
  'tmgServices',
  'tmgControllers',
  'tmgDirectives'
]);
tmgApp.config(function ($routeProvider) {
    $routeProvider
      .when('/', {
    	templateUrl: 'resources/partials/main.html',
        controller: 'MainCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });


