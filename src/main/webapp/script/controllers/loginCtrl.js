(function () {
    var app = angular.module("DonutApp");
    app.controller("loginCtrl", ["$scope", "loginService", function ($scope, ls) {
            $scope.user = {
                "username": "",
                "password": ""
            };

            $scope.login = () => {

                ls.setUsername($scope.user.username);
                ls.setPassword($scope.user.password);
                ls.validateUser();
            };

            $scope.signOut = () => {
                ls.logout();
            };

        }]);
})();
