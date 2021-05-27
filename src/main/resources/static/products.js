angular.module('products', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

     $scope.fillTable = function () {
         $http.get(contextPath + '/products')
             .then(function (response) {
                 console.log(response);
                 $scope.ProductsList = response.data;
             });
     };

    $scope.submitCreateNewProduct = function () {
        $http.post(contextPath + '/products', $scope.newProduct)
            .then(function (response) {
                $scope.newProduct = null;
                $scope.fillTable();
            });
    };

    $scope.deleteProductById = function (id) {
         $http({
             url: contextPath + '/products/del',
             method: 'GET',
             params: {
             id: id
             }
         }).then($scope.fillTable);
    };

    $scope.fillTable();
});