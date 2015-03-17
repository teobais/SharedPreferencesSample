package edu.toubou91.sharedpreferencessample;

import com.example.sharedpreferencesdemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	public static final String TAG = "MainActivity";
	private static final String PREF_NAME = "name";
	private TextView lblName;
	private EditText txtName;
	private Button btnSave;
	private Utils utils;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lblName = (TextView) findViewById(R.id.lblName);
		txtName = (EditText) findViewById(R.id.txtName);
		btnSave = (Button) findViewById(R.id.btnSave); //get the saved name from preferences
		
		//ka9e fora pou 9a tre3ei i efarmogi, 9a kanei elegxo upar3is apo9ikevmenou 
		//instance tis metavlitis ki an uparxei kati, 9a to emfanisei
		// me to koumpi na exei tin endei3i update
		//alliws save
		utils = Utils.getInstance(this);
		String savedName = utils.getString(PREF_NAME);
		if(savedName == null)
			btnSave.setText(R.string.save_your_name);
	    else{
	            btnSave.setText(R.string.update_your_name);
	            lblName.setText("Your name is : "+savedName);
	        }

	        btnSave.setOnClickListener(this);
	    }

	    @Override
	    public void onClick(View v) {
	        String name = txtName.getText().toString();
	        if(name.trim().equals("")) {
	            Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show();
	        }
	        else {
	            utils = Utils.getInstance(this);
	            utils.saveString(PREF_NAME, name);
	            Toast.makeText(this, "Your name is saved successfully", Toast.LENGTH_LONG).show();
	            lblName.setText("Your name is : "+name);
	        }
	    }
	    
	    public void clearAllEntries(View view)
	    {
	    	boolean ok = utils.clearAllEntries();
	    	if(ok == true) {
	    		lblName.setText("Cleared all entries.");
	    		Toast.makeText(this, "All records removed successfully", Toast.LENGTH_LONG).show();
	    	}
	    	else
	    		Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
	    }
	    
	    public void findName(View view)
	    {
	    	String name = utils.getString(PREF_NAME);
	    	if (name == null) {
	    		lblName.setText("No name found!");
	    	} else {
	    		lblName.setText("I found "+ name);
	    	}
	    }
}
