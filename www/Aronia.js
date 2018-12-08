var exec = require('cordova/exec');

function Aronia(){

}

Aronia.prototype.openArActivity = function (arg0, success, error) {
    console.log('Hello cordova');
    exec(success, error, 'Aronia', 'openArActivity', [arg0]);
};

module.exports =  new Aronia();

