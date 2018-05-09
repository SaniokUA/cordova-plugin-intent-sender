package com.rex.plugin;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.tapapp.rex.MainActivity;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class IntentSender extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("intentSender")) {


            for (int i = 0; i < data.length(); i++) {
                Intent sendIntent = new Intent();
                JSONObject jsonobject = data.getJSONObject(i);

                if (jsonobject.has("putExtra")) {
                    if (jsonobject.has("putExtraValue")) {
                        sendIntent.putExtra(jsonobject.getString("putExtra"), jsonobject.getString("putExtraValue"));
                    } else {
                        sendIntent.putExtra(jsonobject.getString("putExtra"), "");
                    }
                }
                if (jsonobject.has("setAction")) {
                    sendIntent.setAction(jsonobject.getString("setAction"));
                }
                if (jsonobject.has("setType")) {
                    sendIntent.setType(jsonobject.getString("setType"));
                }
                if (jsonobject.has("setFlags")) {
                    int flag;
                    String flagData = jsonobject.getString("setFlags");
                    switch (flagData) {
                        case "FLAG_ACTIVITY_NEW_TASK":
                            flag = Intent.FLAG_ACTIVITY_NEW_TASK;
                            break;
                        case "FLAG_ACTIVITY_SINGLE_TOP":
                            flag = Intent.FLAG_ACTIVITY_SINGLE_TOP;
                            break;
                        case "FLAG_ACTIVITY_NO_HISTORY":
                            flag = Intent.FLAG_ACTIVITY_NO_HISTORY;
                            break;
                        case "FLAG_ACTIVITY_MULTIPLE_TASK":
                            flag = Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
                            break;
                        case "FLAG_ACTIVITY_CLEAR_TOP":
                            flag = Intent.FLAG_ACTIVITY_CLEAR_TOP;
                            break;
                        default:
                            flag = Intent.FLAG_ACTIVITY_NEW_TASK;
                            break;
                    }
                    sendIntent.addFlags(flag);
                }else {
                    sendIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                }
                cordova.getActivity().startActivity(sendIntent);
            }


            return true;
        } else

        {

            return false;
        }
    }


}