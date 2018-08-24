package tools;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtils {
    public static SharedPreferences getPreference(Context context){
        return context.getSharedPreferences("com.handltohand",Context.MODE_PRIVATE);
    }

    public static void putBooleanValue(Context context, String key ,boolean value){
         SharedPreferences sharedPreferences = getPreference(context);
         SharedPreferences.Editor editor = sharedPreferences.edit();
         editor.putBoolean(key,value);
         editor.commit();
    }

    public static boolean getBooleanValue(Context context, String key ,boolean value){
       return  getPreference(context).getBoolean(key,value);
    }
}
