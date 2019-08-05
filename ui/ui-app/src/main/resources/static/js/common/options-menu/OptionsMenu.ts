import * as angular from "angular";
import {moduleName} from "../module-name";

angular.module(moduleName).directive('tbaOptionsMenu', ['$mdDialog','$timeout', 'PaginationDataService', 
    ($mdDialog, $timeout, PaginationDataService) =>{
        return {
            restrict: "E",
            scope: {
                sortOptions: "=",
                selectedOption: "&",
                openedMenu: "&",
                menuIcon: "@",
                menuKey: "@",
                tabs: '=',
                rowsPerPageOptions: "=",
                showViewType: '=',
                showPagination: '=',
                additionalOptions: '=?',
                selectedAdditionalOption: "&?"
            },
            templateUrl: 'js/common/options-menu/options-menu-template.html',
            link: function ($scope: any) {
                if ($scope.showViewType) {
                    $scope.viewType = {label: 'List View', icon: 'list', value: 'list', type: 'viewType'};
                }

                $scope.getPaginationId = function (tab: any) {
                    return PaginationDataService.paginationId($scope.menuKey, tab.title);
                };

                $scope.getCurrentPage = function (tab: any) {
                    return PaginationDataService.currentPage($scope.menuKey, tab.title);
                };

                function setViewTypeOption(toggle: any) {
                    $scope.viewType.value = PaginationDataService.viewType($scope.menuKey);

                    if (toggle === true) {
                        $scope.viewType.value = $scope.viewType.value === 'list' ? 'table' : 'list';
                    }
                    if ($scope.viewType.value === 'list') {
                        $scope.viewType.label = 'List View';
                        $scope.viewType.icon = 'list';
                    }
                    else {
                        $scope.viewType.label = 'Table View';
                        $scope.viewType.icon = 'grid_on';
                    }
                }

                if ($scope.showViewType) {
                    //toggle the view Type so its opposite the current view type
                    setViewTypeOption(true);
                }

                $scope.rowsPerPage = 5;
                $scope.paginationData = PaginationDataService.paginationData($scope.menuKey);
                var originatorEv;
                $scope.openMenu = function ($mdOpenMenu: any, ev: any) {

                    originatorEv = ev;
                    if (angular.isFunction($scope.openedMenu)) {
                        var openedMenuFn = $scope.openedMenu();
                        if (angular.isFunction(openedMenuFn)) {
                            openedMenuFn({sortOptions: $scope.sortOptions, additionalOptions: $scope.additionalOptions});
                        }
                    }
                    if ($scope.showPagination) {
                        var tabData = PaginationDataService.getActiveTabData($scope.menuKey);
                        $scope.currentPage = tabData.currentPage;
                        $scope.paginationId = tabData.paginationId;
                    }
                    $mdOpenMenu(ev);
                };

                /**
                 * Selected an additional option
                 * @param item
                 */
                $scope.selectAdditionalOption = function (item: any) {
                    if ($scope.selectedAdditionalOption) {
                        originatorEv = null;
                        $scope.selectedAdditionalOption()(item);
                    }
                };

                /**
                 * Selected a Sort Option
                 * @param item
                 */
                $scope.selectOption = function (item: any) {

                    var itemCopy = {};
                    angular.extend(itemCopy, item);
                    if (item.type === 'viewType') {
                        PaginationDataService.toggleViewType($scope.menuKey);
                        setViewTypeOption(true);
                    }

                    if ($scope.selectedOption) {
                        $scope.selectedOption()(itemCopy);
                    }

                    originatorEv = null;
                };

                $scope.$on('$destroy', function () {

                });

            }
        }
    }
  ]);
