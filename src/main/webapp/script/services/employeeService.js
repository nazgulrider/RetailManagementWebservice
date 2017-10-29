(function(){
var app = angular.module("DonutApp");

app.service("EmployeeSvc", function($http){
    
    var self = this;
    
    self.getEmployees = function(){
        var promise1=$http.get('http://localhost:8082/DonutManagement/v1/employees');
        var promise2=promise1.then(function(response){
            return response.data;
        });
        return promise2;
    };
    self.deleteEmployee = function(){
        
    };
    
    
});
})();
