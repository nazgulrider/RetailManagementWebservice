(function () {

    var app = angular.module("DonutApp");
    app.service("loginService", ['$cookies','$window', function ($cookies, $window) {
            function isAuth() {
                if ($cookies.get('auth') === "true") {
                    return true;
                } 
                return false;
            }
            ;
            this.authorized = isAuth();

            var user = {
                "username": "",
                "password": ""
            };


            this.setUsername = (uname) => user.username = uname;
            this.setPassword = (pword) => user.password = pword;


            var userList = [
                {
                    "username": "Star",
                    "password": "Trek"
                }, {
                    "username": "rat",
                    "password": "456"
                }, {
                    "username": "sam",
                    "password": "frodo"
                }

            ];

            this.validateUser = () => {
                var match=false;
                for (let i = 0; i < userList.length; i++) {
                    if (userList[i].username === user.username && userList[i].password === user.password) {
                        $cookies.put('auth', 'true');
                        this.authorized = $cookies.get('auth') === "true";
                        var match=true;
                        break;
                    } 
                }
                if(!match){
                    alert("Credentials dont match");
                }
                return this.authorized;
            };

            this.logout = () => {
                $cookies.put('auth', 'false');
                this.authorized = $cookies.get('auth') === "true";
                $window.location.href = "index.html";
            };

        }]);
})();