/**
 * Created by First on 05.10.2015.
 */
var app = angular.module("userApp", []);

var cookiesValues;

app.controller("sessionCtrl", function($scope, $http){
    $scope.disableEditing = true;
    $scope.buttonText = "Edit";
    $scope.editorToggle = function(){
        $scope.disableEditing = !$scope.disableEditing;
        if($scope.buttonText == "Edit"){
            $scope.buttonText = "Save";
        }else{
            $http.get("/saveUser?id="+$scope.user.id +
                "&password=" + $scope.user.password +
                "&name=" + ($scope.user.name || "") +
                "&secondName=" + ($scope.user.secondName || "") +
                "&birthDate=" + ($scope.user.birthDate || ""))
                .success(function(response) {
                    updateCookie(response.userEntity);
                });
            $scope.buttonText = "Edit";
        }
    };
    if(document.cookie) {
        userLoginCtrl($scope, $http);
    }
    else{
        $http.get("/getNewUser").success(function(response){
            $scope.user = response.userEntity;
            updateCookie(response.userEntity);
        });
    }
});

var userLoginCtrl = function($scope, $http){
    var id = document.cookie.split("=")[1].replace(";", "");
    $http.get("/getUserById?id="+id)
        .success(function(response) {
            $scope.user = response.userEntity;
            updateCookie(response.userEntity);
        });

};

var updateCookie = function(user){
    document.cookie = "id=" + user.id + "; path=/; " +
        "expires=" + new Date(new Date().setMonth(new Date().getMonth() + 1)).toUTCString() + ";";
};
