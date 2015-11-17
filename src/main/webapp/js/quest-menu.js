/**
 * Created by yorlov on 11/16/2015.
 */
var app = angular.module("questMenuApp", []);

app.controller("questMenuCtrl", function($scope, $http){
    $scope.pageLink = 'quests.html';
    $scope.firstButton = 'New';
    var isNew = false;
    $scope.getNewQuestPage = function(){
        if(isNew){
            $scope.pageLink = 'quests.html';
            $scope.firstButton = 'New';
        }else{
            $scope.pageLink = 'quest-new.html';
            $scope.firstButton = 'All';
        }
        isNew = !isNew;
    }
});