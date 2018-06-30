var app = angular.module('myApp', ['ngRoute']);

app.config(function ($routeProvider) {
    $routeProvider.when('/list', {
        templateUrl: '/list-product',
        controller: 'ListController as ctl'
    }).when('/add', {
        templateUrl: '/add-product',
        controller: 'AddController as ctl'
    }).otherwise({
        redirectTo: '/list'
    });
});

app.controller('ListController', ['$q', '$http', 'ListService', function ($q, $http, ListService) {
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
}]).service('ListService', ['$http', '$q', '$log', function ($http, $q, $log) {
    this.getProduct = function () {
        var deferred = $q.defer();
        $http({
            method: 'GET',
            url: '/product'
        }).then(function resolve(response) {
            return deferred.resolve(response);
        }, function reject(response) {
            return deferred.reject(response);
        });
        return deferred;
    };
}]);

app.controller('AddController', ['AddService', function (AddService) {
    var vm = this;
    vm.onAddProduct = function (name, price, quantity) {
        if (name != undefined && price != undefined) {
            if (quantity == undefined)
                quantity = 0;
            console.log('Data Added : ' + name + ' ' + price + ' ' + quantity);
            AddService.saveProduct(name, price, quantity);
        } else
            throw 'Product Undefined Found!!';
    };
}]).service('AddService', ['$http', '$q', function ($http, $q) {
    this.saveProduct = function (name, price, quantity) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            url: '/product',
            data: {
                name: name,
                price: price,
                quantity: quantity
            }
        }).then(function resolve(response) {
            return deferred.resolve(response);
        }, function reject(response) {
            return deferred.reject(response);
        });
        return deferred;
    };
}]);