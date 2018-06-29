var listApp = angular.module('listApp', []);

listApp.controller('ListController', ['$q', '$http', 'ListService', function ($q, $http, ListService) {
    var vm = this;
    vm.sortBy = 'id';
    vm.sortReverse = false;
    vm.onGetData = function () {
        var deferred = ListService.getProduct();
        deferred.promise.then(function (response) {
            vm.products = response.data;
        });
    };
    vm.onGetData();
}]);

listApp.service('ListService', ['$http', '$q', '$log', function ($http, $q, $log) {
    this.getProduct = function () {
        var deferred = $q.defer();
        $http({
            method: "GET",
            url: "/product"
        }).then(function resolve(response) {
            return deferred.resolve(response);
        }, function reject(response) {
            return deferred.reject(response);
        });
        return deferred;
    };
}]);