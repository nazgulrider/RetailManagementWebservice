(function(){
var app = angular.module("DonutApp");
app.controller("employeeFormCtrl",["$scope","employeeFormService",function($scope,efs){
     $scope.personModel={
        firstName:"",
        lastName:"",
        street:"",
        city:"",
        state:"",
        zip:"",
        phone:"",
        jobTitle:"",
        hourlyPay:""
	};

	$scope.submit=()=>{
		efs.setFirstName($scope.personModel.firstName);
		efs.setLastName($scope.personModel.lastName);
		efs.setStreet($scope.personModel.street);
		efs.setCity($scope.personModel.city);
		efs.setState($scope.personModel.state);
		efs.setZip($scope.personModel.zip);
		efs.setPhone($scope.personModel.phone);
                efs.setTitle($scope.personModel.jobTitle);
                efs.setPay($scope.personModel.hourlyPay);
                console.log($scope.personModel.firstName);
                
                efs.addEmployee();
              
	};


}]);
})();


