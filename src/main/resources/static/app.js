    var sharedPriceApp = angular.module('sharedPriceApp', ['ngRoute', 'ui.grid','ui.grid.pagination']);

    sharedPriceApp.config(['$routeProvider', '$locationProvider', function ($routeProvider,$locationProvider) {
        $locationProvider.hashPrefix('');
        $routeProvider
            .when("/list", {
                templateUrl: "views/html/sharedPrice.html",
                controller: "SharedPriceCtrl"
            })
            .when("/", {
                templateUrl: "views/html/main.html",
                controller: "SharedPriceCtrl"
            })

        if(window.history && window.history.pushState) {

            $locationProvider.html5Mode({
                enabled: true,
                requireBase: false
            });
        }
    }]);

