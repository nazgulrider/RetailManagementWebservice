(function(){
angular.module("DonutApp").directive("employeeDirective",[function(){
    return{
        restrict:"EA",
        templateUrl:"employeeDetails.html",
        controller:"",
        link:function(){
            angular.element(document).ready(function(){
                $("th").addClass("text-center");
                $("h1").addClass("text-center");
                
            });
        }
    };
}]);
})();
