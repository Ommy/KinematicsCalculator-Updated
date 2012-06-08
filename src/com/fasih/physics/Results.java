package com.fasih.physics;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

import com.fasih.physicsv2.R;


public class Results extends Activity {
	@Override
	
	public void onCreate (Bundle savedInstanceState)
	{
		super.onCreate (savedInstanceState);
		setContentView(R.layout.results);
		double v1=0;
		double vf=0,a=0,t=0,d=0;
		Button back = (Button)findViewById(R.id.back);
		TextView ans = (TextView)findViewById(R.id.answer);
        DecimalFormat decFor = new DecimalFormat("0.00");
		
		Bundle b = getIntent().getExtras();//the bundle is retrieved from the intent
		int id = b.getInt("ID");//retreive the ID to know which function to call
		
		if(id==14){
		Context context = getApplicationContext();
		CharSequence text = "ID:"+id;
		int duration = Toast.LENGTH_SHORT;	

		Toast toast = Toast.makeText(context, text, duration);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();}
		int nullCounter=0;
		try{
		if (b.getString("vf").trim().equals(""))
			nullCounter++;
		else//checks each possibility that could have been included in the bundle
		vf = Double.parseDouble(b.getString("vf"));//if the value exists, extract it and convert it to an integer
		}catch(NullPointerException e){}
		try{
		if (b.getString("t").trim().equals(""))
			nullCounter++;
		else
		t = Double.parseDouble(b.getString("t"));
		}catch(NullPointerException e){}
		try{
		if (b.getString("d").trim().equals(""))
			nullCounter++;
		else
		d = Double.parseDouble(b.getString("d"));
		}catch(NullPointerException e){}
		try{
		if (b.getString("a").trim().equals(""))
			nullCounter++;
		else
		a = Double.parseDouble(b.getString("a"));
		}catch(NullPointerException e){}
		try{		
		if (b.getString("v1").trim().equals(""))
			nullCounter++;
		else
		v1 = Double.parseDouble(b.getString("v1"));
		}catch(NullPointerException e){}
		if(nullCounter >2)
		{
			Context context = getApplicationContext();
			CharSequence text = "Please input values into all the fields!";
			int duration = Toast.LENGTH_LONG;

			Toast toast = Toast.makeText(context, text, duration);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
			Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);
			Results.this.startActivity(i);
		}
		
		switch(id)//switch statement that deals with the IDs that were called with the intent
		{//each ID refers to a different function, and there are 20 cases for 20 different IDs
		case 1://v1 chosen, vF,a,t
			v1 =  vf -(d/t);
			v1 = round(v1,2);
			ans.setText("Initial Velocity is: "+v1+" m/s");
			/*back-button*/back.setOnClickListener(new View.OnClickListener(){public void onClick(View v){Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);Results.this.startActivity(i);}});
			break;
		case 2://v1 chosen, vF,d,t
			v1 = vf - a*t;
			v1 = round(v1,2);
			ans.setText ("Initial Velocity is: "+v1+" m/s");
			/*back-button*/back.setOnClickListener(new View.OnClickListener(){public void onClick(View v){Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);Results.this.startActivity(i);}});
			break;
		case 3://v1 chosen dAt
			v1 = (d- 0.5*(a*(t*t)))/t;
			v1 = round(v1,2);
			ans.setText ("Initial Velocity is: "+v1+" m/s");
			/*back-button*/back.setOnClickListener(new View.OnClickListener(){public void onClick(View v){Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);Results.this.startActivity(i);}});
			break;
		case 4://v1 chosen vfAd
			if ((Math.pow(vf,2)-2*a*d) < 0)
				ans.setText("Initial velocity doesn't exist with these values. Check your numbers and try again");
			else{
			v1 = Math.sqrt(Math.pow(vf,2)-2*a*d);
			v1 = round(v1,2);
			ans.setText ("Initial Velocity is: "+v1+" m/s");}
			/*back-button*/back.setOnClickListener(new View.OnClickListener(){public void onClick(View v){Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);Results.this.startActivity(i);}});
			break;
		case 5://vF chosen tVId
			vf = (2*d)/t - v1;
			vf = round(vf,2);
			ans.setText("Final Velocity is: "+vf+" m/s");
			/*back-button*/back.setOnClickListener(new View.OnClickListener(){public void onClick(View v){Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);Results.this.startActivity(i);}});
			break;
		case 6://vF chosen viAt
			vf = v1 + a*t;
			vf = round(vf,2);
			ans.setText("Final Velocity is: "+vf+" m/s");
			/*back-button*/back.setOnClickListener(new View.OnClickListener(){public void onClick(View v){Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);Results.this.startActivity(i);}});
			break;
		case 7://vF chosen dAt
			vf = (d+0.5*a*Math.pow(t,2))/t;
			vf = round(vf,2);
			ans.setText("Final Velocity is: "+vf+" m/s");
			/*back-button*/back.setOnClickListener(new View.OnClickListener(){public void onClick(View v){Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);Results.this.startActivity(i);}});
			break;
		case 8://vF chosen viAd
			if ((Math.pow(v1,2)+2*a*d) < 0)
				ans.setText("Final velocity doesn't exist with these values. Check your numbers and try again");
			else{
			vf = Math.sqrt(Math.pow(v1,2)+2*a*d);
			vf = round(vf,2);
			ans.setText("Final Velocity is: "+vf+" m/s");}
			/*back-button*/back.setOnClickListener(new View.OnClickListener(){public void onClick(View v){Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);Results.this.startActivity(i);}});
			break;
		case 9://time chosen viVFd
			t = (2*d)/(v1+vf);
			t = round(t,2);
			ans.setText("The time is: "+t+" s");
			/*back-button*/back.setOnClickListener(new View.OnClickListener(){public void onClick(View v){Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);Results.this.startActivity(i);}});
			break;
		case 10://time chosen viVFa
			t = (vf-v1)/a;
			t = round(t,2);
			ans.setText("The time is: "+t+" s");
			/*back-button*/back.setOnClickListener(new View.OnClickListener(){public void onClick(View v){Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);Results.this.startActivity(i);}});
			break;
		case 11://time chosen viAd
			t= ((-1*v1)+(Math.sqrt(Math.pow(v1,2)-4*(0.5*a)*(-1*d))))/a;
			t = round(t,2);
			ans.setText("The time is: "+t+" s");
			/*back-button*/back.setOnClickListener(new View.OnClickListener(){public void onClick(View v){Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);Results.this.startActivity(i);}});
			break;
		case 12://time chosen vfAd
			t = ((-1*vf)+(Math.sqrt(Math.pow(vf,2)-4*(-0.5*a)*(-1*d))))/(-a);
			t = round(t,2);
			ans.setText("The time is: "+t+" s");
			/*back-button*/back.setOnClickListener(new View.OnClickListener(){public void onClick(View v){Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);Results.this.startActivity(i);}});
			break;
		case 13://dist chosen viVFt
			d = 0.5*(vf+v1)*t;
			d = round(d,2);
			ans.setText("The distance is: "+d+" m");
			/*back-button*/back.setOnClickListener(new View.OnClickListener(){public void onClick(View v){Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);Results.this.startActivity(i);}});
			break;
		case 14://dist chosen viVFa
			d = v1*t + 0.5*a*Math.pow(t,2);
			d = round(d,2);
			ans.setText("The distance is: "+d+" m");
			/*back-button*/back.setOnClickListener(new View.OnClickListener(){public void onClick(View v){Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);Results.this.startActivity(i);}});
			break;
		case 15://dist chosen viAt
			d = vf*t - 0.5*a*Math.pow(t,2);
			d = round(d,2);
			ans.setText("The distance is: "+d+" m");
			/*back-button*/back.setOnClickListener(new View.OnClickListener(){public void onClick(View v){Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);Results.this.startActivity(i);}});
			break;
		case 16://dist chosen vfAt
			d = (Math.pow(vf,2)-Math.pow(v1,2))/(2*a);
			d = round(d,2);
			ans.setText("The distance is: "+d+" m");
			/*back-button*/back.setOnClickListener(new View.OnClickListener(){public void onClick(View v){Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);Results.this.startActivity(i);}});
			break;
		case 17://acc chosen viVfd -- v1 vf t
			a = (vf-v1)/t;
			a = round(a,2);
			ans.setText("The acceleration is: "+a+" m/s� ");
			/*back-button*/back.setOnClickListener(new View.OnClickListener(){public void onClick(View v){Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);Results.this.startActivity(i);}});
			break;
		case 18://acc chosen vfTd -- d v1 t
			a = 2*(d-v1*t)/(Math.pow(t,2));
			a = round(a,2);
			ans.setText("The acceleration is: "+a+" m/s� ");
			/*back-button*/back.setOnClickListener(new View.OnClickListener(){public void onClick(View v){Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);Results.this.startActivity(i);}});
			break;
		case 19://acc chosen viTd -- d vf t
			a = -2*(d-vf*t)/(Math.pow(t,2));
			a = round(a,2);
			ans.setText("The acceleration is: "+a+" m/s� ");
			/*back-button*/back.setOnClickListener(new View.OnClickListener(){public void onClick(View v){Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);Results.this.startActivity(i);}});
			break;
		case 20://acc chosen viVFt -- v1 vf d
			a = (Math.pow(vf,2)-Math.pow(v1,2))/(2*d);
			a = round(a,2);
			ans.setText("The acceleration is: "+a+" m/s� ");
			/*back-button*/back.setOnClickListener(new View.OnClickListener(){public void onClick(View v){Intent i = new Intent(Results.this,PhysicsCalculator_v2Activity.class);Results.this.startActivity(i);}});
			break;
		}
	}
	/*public static double quad(double a, double b, double c)
	{
		double ansP,ansM;
		ansP = (-1*b)+Math.sqrt(b*b-4*a*c);
		ansM = (-1*b)-Math.sqrt(b*b-4*a*c);
		ansP /= 2*a;
		ansM /= 2*a;
		if (ansP >=0 && ansM <=0)
			return ansP;
		else if (ansM >= 0 && ansP<=0)
			return ansM;
		else
			return 0;
	}*/
		public static double round(double pNumber, int pPlaces)
		{
		//Store an exponent, i.e. 10 time the number of places we want to have in the final answer
		double lExponent = Math.pow(10, pPlaces);

		//Shift the input numbmer's decimal point from the exponent
		pNumber *= lExponent;

		//Add 0.5 if it's positive, subtract 0.5 if it's negative. This is the "rounding" of the number
		pNumber += 0.5*Math.signum(pNumber);

		//Cast to int to remove the decimal places, then cast back to double and shift the decimal place back
		return ((double)((int)pNumber))/lExponent;
		}
	

}
