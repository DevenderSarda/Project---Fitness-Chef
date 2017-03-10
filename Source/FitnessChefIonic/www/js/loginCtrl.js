fitnessChef.controller('loginCtrl', function($scope, $rootScope, $state, AuthService) {
    
	ionic.Platform.ready(function(){

  	});

  	$scope.login = function() {
  		
  		$state.go("home");

  		
  	}
	
});