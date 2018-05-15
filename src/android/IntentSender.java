package com.rex.plugin;

import android.content.Intent;
import com.tapapp.rex.WorksService;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


public class IntentSender extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("intentSender")) {

            ArrayList<String> list = new ArrayList<String>();
            if (data != null) {
                int len = data.length();
                for (int i = 0; i < len; i++) {
                    list.add(data.get(i).toString());
                }
            }

            if(list.get(0).equals("startService")) {
                Intent sendIntent = new Intent(cordova.getActivity(), WorksService.class);
                cordova.getActivity().startService(sendIntent);
            }else{
                Intent sendIntent = new Intent(cordova.getActivity(), WorksService.class);
                cordova.getActivity().stopService(sendIntent);
            }
            return true;
        } else

        {

            return false;
        }
    }

}