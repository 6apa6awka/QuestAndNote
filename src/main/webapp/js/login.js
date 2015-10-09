/**
 * Created by First on 01.10.2015.
 */
var app = angular.module("loginApp", []);
app.controller("loginCtrl", function($scope, $http){
    $scope.loginEnter = function(){
        $http.get("/login?id="+$scope.login+"&password="+$scope.password)
            .success(function(response) {
                $scope.message = response.message;
                if(response.answerCode == "LOGGING_OK"){
                    document.cookie = $scope.login;
                    window.location = '/pages/home.html';
                }
            });

    }
});