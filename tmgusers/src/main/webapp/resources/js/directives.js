var directive = angular.module('tmgDirectives', []);

directive.directive('loading', function() {
	return {
		restrict : 'E',
		replace : true,
		templateUrl : 'resources/partials/loading.html',
		link : function(scope, element, attr) {
			scope.$watch('loading', function(val) {
				if (val)
					$(element).show();
				else
					$(element).hide();
			});
		}
	};
});

directive.directive('dateformat', function() {
	return {
		restrict : 'A',
		require : 'ngModel',
		link : function(scope, element, attrs, ngModelController) {
			ngModelController.$parsers.push(function(data) {
				return data;
			});

			ngModelController.$formatters.push(function(data) {
				// convert data from model format to view format
				return millstoDate(data);
			});
		}
	};
});

function millstoDate(data) {
	if (data) {
		var d = new Date(data);
		var date = d.getDate() < 10 ? '0' + d.getDate() : d.getDate();
		var month = d.getMonth() + 1;
		month = month < 10 ? '0' + month : month;
		var year = d.getFullYear();
		return month + '/' + date + '/' + year;
	}

}