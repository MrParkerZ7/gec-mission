var addApp = angular.module('addApp', []);

addApp.controller('AddController', ['AddService', function (AddService) {
    var vm = this;
    vm.onAddProduct = function (name, price, quantity) {
        if (name != undefined && price != undefined) {
            if (quantity == undefined)
                quantity = 0;
            console.log('Data Added : ' + name + ' ' + price + ' ' + quantity);
            AddService.saveProduct(name, price, quantity);
        } else
            throw "Product Undefined Found!!";
    };
}]);

addApp.service('AddService', ['$http', '$q', function ($http, $q) {
    this.saveProduct = function (name, price, quantity) {
        var deferred = $q.defer();
        $http({
            method: "POST",
            url: "/product",
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