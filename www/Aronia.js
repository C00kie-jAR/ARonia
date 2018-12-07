var exec = require('cordova/exec');

function Aronia(){

}

Aronia.prototype.openArActivity = function (arg0, success, error) {
    exec(success, error, 'Aronia', 'openArActivity', [arg0]);
};

module.exports =  new Aronia();

