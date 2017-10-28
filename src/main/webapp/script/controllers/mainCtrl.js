(function(){

angular.module("DonutApp").controller("mainCtrl",["$scope","loginService",function($scope,ls){
 
    $scope.authorized=ls.authorized;
    $scope.$watch(function(){
        return ls.authorized;
    },function(newVal,oldVal){
        if(newVal!==oldVal){
            $scope.authorized=newVal;
        }
    });
    
}]);
})();

