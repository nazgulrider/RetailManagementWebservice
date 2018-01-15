(function () {
    var app = angular.module("DonutApp");
    app.service("employeeFormService", ["$http", "$window", function ($http, $window) {

            var self = this;
            var employeeModel = {
                addresses: [],
                firstName: "",
                hourlyPay: "",
                jobTitle: "",
                lastName: "",
                phoneNumbers: []
            };
            var addressModel = {
                streetAddress: "",
                city: "",
                state: "",
                zipcode: ""
            };
            var phoneModel = {
                phoneNumber: ""
            };

            this.setFirstName = (fName) => employeeModel.firstName = fName;
            this.setLastName = (lName) => employeeModel.lastName = lName;
            this.setTitle = (jobTitle) => employeeModel.jobTitle = jobTitle;
            this.setPay = (hourlyPay) => employeeModel.hourlyPay = hourlyPay;


            this.setStreet = (street) => addressModel.streetAddress = street;
            this.setCity = (city) => addressModel.city = city;
            this.setState = (state) => addressModel.state = state;
            this.setZip = (zip) => addressModel.zipcode = zip;

            this.setPhone = (phone) => phoneModel.phoneNumber = phone;


            self.addEmployee = function () {
                employeeModel.addresses[0] = addressModel;
                employeeModel.phoneNumbers[0] = phoneModel;

                var data = angular.toJson(employeeModel);
                console.log(data);
                var config = {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                };

                $http.post('http://localhost:8082/DonutManagement/v1/employees', data, config);
                $window.location.href = "index.html";

            };

        }]);
})();