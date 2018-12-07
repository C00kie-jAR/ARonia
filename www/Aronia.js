var exec = require('cordova/exec');

function Aronia(){

}

Aronia.prototype.coolMethod = function (arg0, success, error) {
    exec(success, error, 'Aronia', 'coolMethod', [arg0]);
};

module.exports =  new Aronia();

