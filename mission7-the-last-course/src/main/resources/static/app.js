var app = angular.module('myApp', ['ngRoute']);

app.config(function ($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true); // Use to clean # on route url
    $routeProvider.when('/list', {
        templateUrl: '/list-product',
        controller: 'ListController as ctl'
    }).when('/add', {
        templateUrl: '/add-product',
        controller: 'AddController as ctl'
    }).when('/details/:id', {
        templateUrl: '/details-product',
        controller: 'DetailsController as ctl'
    }).otherwise({
        redirectTo: '/list'
    });
});

app.controller('DetailsController', ['MyService', '$routeParams', function (MyService, $routeParams) {
    var vm = this;
    MyService.getProduct($routeParams.id).promise.then(function (response) {
        vm.product = response.data;
    });

}]);

app.controller('ListController', ['$q', '$http', 'MyService', function ($q, $http, MyService) {
    var vm = this;
    vm.sortBy = 'id';
    vm.sortReverse = false;
    vm.onGetData = function () {
        MyService.getProducts().promise.then(function (response) {
            vm.products = response.data;
        });
    };
    vm.onGetData();
}]);

app.controller('AddController', ['MyService', function (MyService) {
    var vm = this;
    vm.onAddProduct = function (name, price, quantity) {
        if (name != undefined && price != undefined) {
            if (quantity == undefined)
                quantity = 0;
            MyService.saveProduct(name, price, quantity);
            console.log('Data Added : ' + name + ' ' + price + ' ' + quantity);
            console.log('Going to list page');
            window.location = '/';
        } else
            throw 'Product Undefined Found!!';
    };
}]);

app.service('MyService', ['$http', '$q', function ($http, $q) {
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
    this.getProduct = function (id) {
        var deferred = $q.defer();
        $http({
            method: 'GET',
            url: '/product/' + id
        }).then(function resolve(response) {
            return deferred.resolve(response);
        }, function reject(response) {
            return deferred.reject(response);
        });
        return deferred;
    };
    this.getProducts = function () {
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