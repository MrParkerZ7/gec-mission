var app = angular.module("myApp", []);

app.controller("myController", function ($scope) {
    $scope.check = true;

    $scope.limit = 7;
    $scope.start = 0;
    $scope.sortBy = 'name';
    $scope.sortReverse = false;
    $scope.sortData = function(column){
        $scope.sortReverse = ($scope.sortBy == column)? !$scope.sortReverse : false;
        $scope.sortBy = column;
    };
    $scope.sortGetClass = function(column) {
        if($scope.sortBy == column) {
            return $scope.sortReverse ? 'arrow-up' : 'arrow-down';
        }
        return '';
    };
    $scope.users = [
        {name: "Park", gender: "MALE", grade: "A",duration: new Date() , saraly: 4500 , score: 45.334443},
        {name: "Bill", gender: "Female", grade: "b",duration: new Date() , saraly: 87000 , score: 9857.123244},
        {name: "Logan", gender: "Male", grade: "C",duration: new Date() , saraly: 65000 , score: 5034.2},
        {name: "Max", gender: "feMALE", grade: "a",duration: new Date() , saraly: 32000 , score: 3754},
        {name: "Eye", gender: "FeMale", grade: "B",duration: new Date() , saraly: 70000 , score: 6500.4555},
        {name: "Alex", gender: "Male", grade: "c",duration: new Date() , saraly: 82000 , score: 8000.45},
        {name: "Zuul", gender: "Male", grade: "a",duration: new Date() , saraly: 77000 , score: 8000.2345},
    ];


});