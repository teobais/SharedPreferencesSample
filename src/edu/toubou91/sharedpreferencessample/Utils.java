package edu.toubou91.sharedpreferencessample;

import android.content.Context;
import android.content.SharedPreferences;

public class Utils {

	public static final String TAG = "Utils";
	public static final String PREFS = "prefs";
	private static Utils instance = null;
	private SharedPreferences prefs;
	
	private Utils(Context context)
	{
		this.prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
	}
	
	public static Utils getInstance(Context context)
	{
		if(instance == null)
			instance = new Utils(context);
		return instance;
	}
	
	
	/**
	 * Saves a key/value pair in preferences.
	 * @param key
	 * @param value
	 */
	public void saveString(String key, String value)
	{
		this.prefs.edit().putString(key, value).commit();
	}
	
    /**
     * Gets the string value by its key.
     * @param key
     * @return the string value of the key or null otherwise
     */
	public String getString(String key)
    {
    	return this.prefs.getString(key,null);
    }
    
    // Removes all entries from the shared preferences file. 
    public boolean clearAllEntries()
    {
    	return this.prefs.edit().clear().commit();
    }
}
