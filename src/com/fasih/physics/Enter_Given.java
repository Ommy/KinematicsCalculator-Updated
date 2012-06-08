package com.fasih.physics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.fasih.physicsv2.R;

public class Enter_Given extends Activity {
	/**Given IDs for use in switch statement**/
	public static final int V_INITIAL = 0;
	public static final int V_FINAL = 1;
	public static final int D_IND = 2;
	public static final int A_IND = 3;
	public static final int T_IND = 4;

	/**Equation ID constants**/
	//public static final int 
	/*public static final int FinalVelocityAccelerationTime = 5;
	public static final int FinalVelocityDistanceTime =6;
	public static final int DistanceAccelerationTime = 7;
	public static final int FinalVelocityAccelerationDistance = 8;
	public static final int InitialVelocityTimeDistance = 9;
	public static final int InitialVelocityAccelerationTime = 10;
	public static final int InitialVelocityAccelerationDistance = 12;
	public static final int InitialVelocityFinalVelocityDistance = 13;
	public static final int FinalVelocityTimeDistance = 14;
	public static final int InitialVelocityFinalVelocityTime = 17;
	public static final int InitialVelocityFinalVelocityAcceleration = 18;*/
	

	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_givens);
        Bundle b = getIntent().getExtras();
        final String givens = b.getString("required");
        final String labels[]= new String[3];
        String temp[] = new String[3];
        final int EQN_ID = b.getInt("EQN_ID");
        Button go = (Button)findViewById(R.id.calc);
        TextView g1 = (TextView)findViewById(R.id.g1_label);
        TextView g2 = (TextView)findViewById(R.id.g2_label);
        TextView g3 = (TextView)findViewById(R.id.g3_label);
        String[] EQN_names = getResources().getStringArray(R.array.EQN_Names);
        //Need array of edittexts, look up resources later... no wi-fi here :'(
        final EditText giv[] = new EditText[3];
        giv[0] = (EditText)findViewById(R.id.g1_input);
        giv[1] = (EditText)findViewById(R.id.g2_input);
        giv[2] = (EditText)findViewById(R.id.g3_input);
        int ID = b.getInt("ID");
        int u=0;
        switch (ID){        
        case V_INITIAL:
        	temp = getResources().getStringArray(R.array.v1_array);
        	break;
        case V_FINAL:
        	temp = getResources().getStringArray(R.array.v2_array);
        	break;
        case D_IND:
        	temp = getResources().getStringArray(R.array.d_array);
        	break;
        case A_IND:
        	temp = getResources().getStringArray(R.array.a_array);
        	break;
        case T_IND:
        	temp = getResources().getStringArray(R.array.t_array);
        	break;
        }
        for (int i = 0; i<temp.length;i++)
    		if (givens.indexOf(temp[i])>-1)
    		{
    			labels[u] = temp[i];
    			u++;
    		}
        g1.setText(labels[0]);
        g2.setText(labels[1]);
        g3.setText(labels[2]);
        final int nextID = ID;
        go.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//add the edit texts, then change the for loop so it adds ints not strings... derp
				Intent i = new Intent(Enter_Given.this,Results.class);
		        Bundle a = new Bundle();
		        a.putInt("ID", EQN_ID);
		        for (int y = 0; y<labels.length;y++)
		        {
		        	if (labels[y].equals(("Initial Velocity")))
		        			a.putString("v1", labels[y]);
		        	else if (labels[y].equals(("Final Velocity")))
	        			a.putString("vf", labels[y]);
		        	else if (labels[y].equals(("Acceleration")))
	        			a.putString("a", labels[y]);
		        	else if (labels[y].equals(("Distance")))
	        			a.putString("d", labels[y]);
		        }
		        int z=0;
		        for (int c = 0; c<giv.length;c++)
		        {
		        	if (labels[c].equals("Initial Velocity"))
		        			a.putString("v1",giv[c].getText().toString());
		        	else if (labels[c].equals("Final Velocity"))
		        		a.putString("vf",giv[c].getText().toString());
		        	else if (labels[c].equals("Distance"))
		        		a.putString("d",giv[c].getText().toString());
		        	else if (labels[c].equals("Acceleration"))
		        		a.putString("a",giv[c].getText().toString());
		        	else if (labels[c].equals("Time"))
		        		a.putString("t",giv[c].getText().toString());
		        }
		        i.putExtras(a);
		        Enter_Given.this.startActivity(i);
			}
		});   
	}	
}