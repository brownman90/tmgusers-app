'use strict';

var tmgControllers = angular.module('tmgControllers', []);

tmgControllers.controller('MainCtrl', [ '$scope', '$routeParams', 'Users',
		'CRUDUser', function($scope, $routeParams, Users, CRUDUser) {
			$scope.loading = true;
			$scope.formUser = 'resources/partials/formUser.html';
			$scope.userSearch = {
				name : ''
			};
			$scope.users = Users.query();

			$scope.loading = false;

			$scope.showForm = function(id, $index) {
				if (id) {
					$scope.userForm = CRUDUser.get({
						id : id
					});
					$scope.selected = $index;
				} else {
					$scope.userForm = {
						id : undefined,
						name : '',
						dateOfBirthMills : ''
					};
				}
			};

			$scope.confirmUser = function() {

				if ($scope.userForm.dateOfBirthMills) {
					var date = new Date($scope.userForm.dateOfBirthMills);
					$scope.userForm.dateOfBirthMills = date.getTime();
				}
				if (!$scope.userForm.id) {
					CRUDUser.save($scope.userForm, function(data) {
						$scope.userForm.name = '';
						$scope.userForm.dateOfBirthMills = '';
						$scope.users.list.push(data);
					});
				} else {
					CRUDUser.update($scope.userForm, function(data) {
						$scope.userForm.name = '';
						$scope.userForm.dateOfBirthMills = '';
						$scope.users.list[$scope.selected] = data;
					});
				}
				$('#formUser').modal('hide');
			};

			$scope.removeUser = function(id, index) {
				if (id) {
					CRUDUser.remove({
						id : id
					}, function(s) {
						// directive message;
					});
					$scope.users.list.splice(index, 1);
				}
			};
		} ]);