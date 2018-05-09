module.exports = {
    intentSender: function (data, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "IntentSender", "intentSender", [data]);
    }
};