/**
 * Testing out AngularJS with the Controller
 * Here we are calling th AngularJs controller and grabbing a list of customers
 * from there we are searching via client side for the specific customer using the Searchby function
 * 
 */


angular
	.module('myApp', ['ngResource']) /*ngResource maps resource as a get request */
	.service('customerService', function ($log, $resource){
		return{
			getAll: function() {
				var customerResource = $resource('customers',{}, {
					query: {method: 'GET', params: {}, isArray: true}
				}); /* Looking for customers.. value as a GET request inside the angular Controller */
				return customerResource.query();
			}
		}	
	})
	.controller('customerController', function ($scope, $log, customerService) {
		/* scope is for the controller  */
		$scope.angularCustomers = customerService.getAll(); /* gets all the cusomters in the get request */
		console.log($scope.angularCustomers);
	});

angular.module('testApplication', []).controller("MainController", function() {
	this.num1 = 0;
	this.num2 = 0;
		
});