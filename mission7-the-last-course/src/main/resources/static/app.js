var app = angular.module('myApp', []);

app.controller('myController', ['MyService', function (MyService) {
    this.sortBy = 'name';
    this.sortReverse = false;
    this.products = MyService.data;
}]);

app.service('MyService', ['$http', '$q', '$log', function ($http, $q, $log) {
    this.data = [{
            name: 'Pencil',
            price: 7.50,
            quantity: 140
        },
        {
            name: 'Cola',
            price: 15.75,
            quantity: 50
        },
        {
            name: 'Book',
            price: 69.50,
            quantity: 1200
        },
        {
            name: 'Montor',
            price: 2500,
            quantity: 17
        },
        {
            name: 'Land Cable',
            price: 150,
            quantity: 94
        },
        {
            name: 'Mouse',
            price: 450.75,
            quantity: 45
        },
        {
            name: 'Iphone Cable',
            price: 290,
            quantity: 60
        },
        {
            name: 'Table',
            price: 590,
            quantity: 4
        },
        {
            name: 'Pen',
            price: 12.75,
            quantity: 2440
        },
        {
            name: 'Keybord',
            price: 790,
            quantity: 12
        },
        {
            name: 'Paper',
            price: 0.50,
            quantity: 1200
        },
    ];

}]);