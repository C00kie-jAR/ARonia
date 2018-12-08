package org.aronia.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;


import android.content.Context;
import android.content.Intent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class Aronia extends CordovaPlugin {

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("openArActivity")) {
            String message = args.getString(0);
            Context context = cordova.getActivity().getApplicationContext();
            this.openArActivity(context);
            return true;
        }
        return false;
    }

    private void openArActivity(Context context) {
        Intent intent = new Intent(context, AroniaActivity.class);
        this.cordova.getActivity().startActivity(intent);
    }
}
