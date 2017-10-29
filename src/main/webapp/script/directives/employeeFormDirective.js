(function(){
angular.module("DonutApp").directive("employeeFormDirective",[function(){
    return{
        restrict:"EA",
        templateUrl:"employeeFormSection.html",
        controller:"employeeFormCtrl"
    };
}]);
})();

