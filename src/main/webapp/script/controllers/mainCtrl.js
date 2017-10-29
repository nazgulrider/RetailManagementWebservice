(function(){

var app = angular.module("DonutApp");
app.controller("mainCtrl",["$scope","loginService",'$cookies',function($scope,ls,$cookies){
   
    $scope.authorized = ls.authorized;
    $scope.$watch(function(){
        return ls.authorized;
    },function(newVal,oldVal){
        if(newVal!==oldVal){
            $scope.authorized=newVal;
        }
    });
    
}]);
})();

