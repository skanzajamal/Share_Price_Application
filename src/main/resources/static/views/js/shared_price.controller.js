sharedPriceApp.controller('SharedPriceCtrl', ['$scope', '$filter', 'SharedPriceService', function ($scope, $filter, SharedPriceService) {

    $scope.apiList = [];
    $scope.List = [];
    var priceData = {};

    $scope.sharedPriceList = [
        "SPY",
        "CMCSA",
        "KMI",
        "INTC",
        "MU",
        "GDX",
        "GE",
        "BAC",
        "EEM",
        "XLF",
        "AAPL",
        "MSFT",
        "SIRI",
        "HPQ",
        "CX",
        "EFA",
        "CZR",
        "QQQ",
        "F",
        "AMD",
        "SNAP",
        "FB",
        "WFC",
        "AIG",
        "T",
        "C",
        "VALE",
        "MS",
        "AKS",
        "JPM",
        "ORCL",
        "NKE",
        "VWO",
        "PG",
        "FXI",
        "IWM",
        "GSM",
        "HK",
        "BBD",
        "PFE",
        "JD",
        "NOK",
        "TWTR",
        "AMLP",
        "AVGO",
        "AMAT",
        "WFT",
        "UVXY",
        "DWDP",
        "VXX",
        "VEA",
        "ZNGA",
        "XOM",
        "QCOM",
        "TVIX",
        "VIPS",
        "GLD",
        "CSCO",
        "AXP",
        "BMY",
        "V",
        "USO",
        "GRPN",
        "WP",
        "OIH",
        "GERN"
    ];

    $scope.getPriceList = function () {
        SharedPriceService.getSharedPriceList().then(function (result) {

            $scope.List = result.data;
            $scope.priceGridOptions.data = result.data;
        });
    };

    $scope.priceGridOptions = {
        paginationPageSizes: [20, 50, 100, 150],
        paginationPageSize: 20,
        enableFiltering: true,
        enableColumnMenus: false,
        onRegisterApi: function (gridApi) {
            $scope.gridApi = gridApi;
        },
        columnDefs: [
            {name: 'symbol', displayName: 'Symbol', headerCellClass: $scope.highlightFilteredHeader},
            {name: 'name', displayName: 'Name', headerCellClass: $scope.highlightFilteredHeader},
            {name: 'price', displayName: 'Price', headerCellClass: $scope.highlightFilteredHeader},
            {name: 'exchange', displayName: 'Exchange', headerCellClass: $scope.highlightFilteredHeader},
            {name: 'exchangeShortName', displayName: 'Exchange Short Name', headerCellClass: $scope.highlightFilteredHeader},
            {name: 'type', displayName: 'Type', headerCellClass: $scope.highlightFilteredHeader},
            {
                name: 'action',
                displayName: 'Action',
                cellTemplate: '<button class="btn btn-danger" ng-click="grid.appScope.delete(row.entity)"><i class="glyphicon glyphicon-trash"></i></button>',
                width: 120
            }
        ]
    };

    $scope.delete = function (row) {
        SharedPriceService.delete(row.id).then(function () {
            $scope.getPriceList();
        });
    };

    $scope.saveRecord = function () {
        SharedPriceService.getApi().then(function (result) {
            $scope.apiList = result.data;

            for(var i=0; i< result.data.length; i++){

                if(result.data[i].symbol === $scope.symbol){
                    priceData = result.data[i];
                    SharedPriceService.savePrice(priceData).then(function () {
                        SharedPriceService.getSharedPriceList().then(function (result) {
                            $scope.List = result.data;
                            $scope.priceGridOptions.data = result.data;
                        });
                    })
                }
            }
        });
    };

}]);