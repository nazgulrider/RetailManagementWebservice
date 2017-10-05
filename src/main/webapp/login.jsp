<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="DonutApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees</title>
         

    </head>
    <body>

        <div class="container jumbotron " ng-controller="EmployeeCtrl as ctrl">   
            <h1>Employee List</h1>
            <ul class="list-group">
                <li class="list-group-item" ng-repeat="employee in ctrl.employees" ng-click="ctrl.selectEmployee($index)">
                    <span>{{employee.firstName + " " + employee.lastName + " is the best person ever!"}}</span>
                </li>
            </ul>           
        </div> 
    </body>
    
    <link rel="stylesheet" href="css/bootstrap.min.css">  
    <script src="js/bootstrap.min.js"></script>        
    <script src="js/angular.min.js"></script>
    <script src="script/app.js"></script>
    <script src="script/controllers/employee.controller.js"></script>
    <script src="script/services/employeedata.service.js"></script>
</html>
