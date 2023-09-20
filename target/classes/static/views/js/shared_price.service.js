sharedPriceApp.service('SharedPriceService', ['$http', function ($http) {

    this.getSharedPriceList = function () {
        return $http.get("/stockPrices/listAll")
            .then(function (data) {
                return data;
            })
            .catch(function (e) {
                return e;
            });
    }

    this.getApi = function () {
        return $http.get("https://financialmodelingprep.com/api/v3/stock/list?apikey=0dbbd75a650040eaab859d3383bf3395")
            .then(function (data) {
                return data;
            })
            .catch(function (e) {
                return e;
            });
    }

    this.savePrice = function (priceData) {
        return $http({
            url: "/stockPrices/insert",
            method: "POST",
            data: priceData
        })
            .then(function (response) {
                console.log("response: ", response);
                return response;
            })
            .catch(function (error) {
                return error;
            });
    };

}]);

