package cordova-plugin-mathcalculator;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class MathCalculator extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("add")) {
           this.add(args,callbackContext);
           return true;
        }
        return false;
    }

    private void add(JSONArray args,CallbackContext callback) {
        if(args !=null)
        {
            try {
                int p1 = Integer.paseInt(args.getJSONObject(0).getString("params1"));
                int p2 = Integer.paseInt(args.getJSONObject(0).getString("params2"));

                callback.success("" + (p1+p2));
            } catch (Exception ex) {
                callback.error("something want wrong" + ex);
            }
        }else
        {
         callback.error("Please don't pass null value");
        }
    }
}
