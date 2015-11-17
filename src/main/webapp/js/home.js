/**
 * Created by yorlov on 11/16/2015.
 */
var app = angular.module("homeApp", []);

app.controller("homeCtrl", function($scope, $http){
    $scope.menuLink = 'quests-menu.html';
});