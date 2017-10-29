(function(){
angular.module("DonutApp").directive("navbarDirective",[function(){
    return{
        restrict:"EA",
        templateUrl:"navbar.html",
        controller:"loginCtrl"
    };
}]);
})();

