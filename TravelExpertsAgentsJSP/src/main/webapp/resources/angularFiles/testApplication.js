/**
 * Testing out AngularJS with the Controller
 */


angular
	.module('myApp', ['ngResource'])
	.service('customerService', function ($log, $resource){
		return{
			getAll: function() {
				var customerResource = $resource('customers',{}, {
					query: {method: 'GET', params: {}, isArray: true}
				});
				return customerResource.query();
			}
		}	
	})
	.controller('customerController', function ($scope, $log, customerService) {
		
		$scope.angularCustomers = customerService.getAll();
		console.log($scope.angularCustomers);
	});

angular.module('testApplication', []).controller("MainController", function() {
	this.num1 = 0;
	this.num2 = 0;
		
});