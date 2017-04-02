// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.services' is found in services.js
// 'starter.controllers' is found in controllers.js
var fitnessChef = angular.module('fitnesschef', ['ionic', 'ngCordova', 'firebase']);

fitnessChef.constant('ApiEndpoint', {
  url: 'http://ion-api.dev/'
});

fitnessChef.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
    // for form inputs)
    if (window.cordova && window.cordova.plugins && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
      cordova.plugins.Keyboard.disableScroll(true);
    }
    if (window.StatusBar) {
      // org.apache.cordova.statusbar required
      StatusBar.styleDefault();
    }
  });
});

var requestToken = "";
var accessToken = "";
var clientId = "785757971784-q3atlmlfao7skdvvp40us5ojk7iuk0bc.apps.googleusercontent.com";
var clientSecret = "AIzaSyCXJNuYLzvuyRDHgh7zbzPsv071SI555So";