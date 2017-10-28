(function(){
angular.module("DonutApp").directive("loginDirective",[function(){
    return{
        restrict:"EA",
        templateUrl:"login.html",
        controller:"loginCtrl"
    };
}]);
})();

