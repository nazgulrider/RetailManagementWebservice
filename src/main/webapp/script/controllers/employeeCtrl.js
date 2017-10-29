(function(){
var app = angular.module("DonutApp");
app.controller("EmployeeCtrl",EmployeeCtrl);

function EmployeeCtrl(EmployeeSvc){
    
    var self=this;
    EmployeeSvc.getEmployees()
            .then(function(data){
                self.employees = data;
    });
    
    this.selectEmployee=function(index){
        this.selectedContact=this.employees[index];
    };
    
};
})();

