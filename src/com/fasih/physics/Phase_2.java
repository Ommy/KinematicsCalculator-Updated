package com.fasih.physics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.fasih.physicsv2.R;

public class Phase_2 extends Activity {

	public static final int V_INITIAL = 0;
	public static final int V_FINAL = 1;
	public static final int D_IND = 2;
	public static final int A_IND = 3;
	public static final int T_IND = 4;
	
	/*I can go iterate through a string to find the position at which the equation is. the order with which I have the Results.java will be the same
	 * order I would do this one in. This way, i can send equation ID and make the work 10x easier*/
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phase_2);
        Bundle b = getIntent().getExtras();
        String required[] = new String[4];
        Button c1 = (Button)findViewById(R.id.ch1);
        Button c2 = (Button)findViewById(R.id.ch2);
        Button c3 = (Button)findViewById(R.id.ch3);
        Button c4 = (Button)findViewById(R.id.ch4);
        final String all_eqns[] = getResources().getStringArray(R.array.ALL_EQNS);
        final Bundle next = new Bundle();
        final Intent i = new Intent(Phase_2.this,Enter_Given.class);
        final int ID = b.getInt("choice");
        switch (ID)
        {
        case V_INITIAL:
        	required = getResources().getStringArray(R.array.v1);
        	break;
        case V_FINAL:
        	required = getResources().getStringArray(R.array.v2);
        	break;
        case D_IND:
        	required = getResources().getStringArray(R.array.d);
        	break;
        case A_IND:
        	required = getResources().getStringArray(R.array.a);
        	break;
        case T_IND:
        	required = getResources().getStringArray(R.array.t);
        	break;
        }
        c1.setText(required[0]);
        c2.setText(required[1]);
        c3.setText(required[2]);
        c4.setText(required[3]);
        int EQN_ID;
        final String inBundle[] =new String[4];
        for (int x = 0; x< required.length;x++)
        	inBundle[x] = required[x];
        	
        c1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				next.putInt("ID", ID);
				next.putInt("EQN_ID",checkEQN(inBundle[0],all_eqns,ID));
				next.putString("required", inBundle[0]);
				i.putExtras(next);
				Phase_2.this.startActivity(i);
			}
		});
        c2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				next.putInt("ID",ID);
				next.putString("required",inBundle[1]);
				next.putInt("EQN_ID",checkEQN(inBundle[1],all_eqns,ID));
				i.putExtras(next);
				Phase_2.this.startActivity(i);
				
			}
		});
        c3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				next.putInt("ID",ID);
				next.putString("required", inBundle[2]);
				next.putInt("EQN_ID",checkEQN(inBundle[2],all_eqns,ID));
				i.putExtras(next);
				Phase_2.this.startActivity(i);
				
			}
		});
        c4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				next.putInt("ID", ID);
				next.putString("required",inBundle[3]);
				next.putInt("EQN_ID",checkEQN(inBundle[3],all_eqns,ID));
				i.putExtras(next);
				Phase_2.this.startActivity(i);
			}
		});
}
    public int checkEQN(String a,String all[], int sl)
    {
    	int ID=0;
    	
    	for (int i = 0; i<all.length;i++)
    	{
    		if (all[i].equals(a))
    		{
    			ID = i+1;
    			if(sl == 2 && ID == 10)
    				ID = 16;
    			else if (sl==3 && ID == 13)
    				ID = 17;		
    			break;
    		}
    	}
    	return ID;
	}
}