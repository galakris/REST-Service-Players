angular.module('app', []).controller('PlayerController', function($http) {
    var vm = this;
    function refreshData() {
        $http({
            method : 'GET',
            url : 'api/players'
        }).then(function success(response) {
            vm.players = response.data;
            console.log(vm.players);
        }, function error(response) {
            console.log('API error ' + response.status);
        });
    }

    vm.addPlayer = function(player) {
        $http({
            method : 'POST',
            url : 'api/players',
            data : player
        }).then(function success(response) {
            refreshData();
            vm.player = {};
        }, function error(response) {
            console.log('Data not saved ' + player);
        });
    }

    vm.appName = 'Zawodnicy';
    refreshData();
});