package com.fasih.physics;

import com.fasih.physicsv2.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class PhysicsCalculator_v2Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button v1I = (Button)findViewById(R.id.v1BTN);
        Button v2I = (Button)findViewById(R.id.v2BTN);
        Button dI = (Button)findViewById(R.id.dBTN);
        Button aI = (Button)findViewById(R.id.aBTN);
        Button tI = (Button)findViewById(R.id.tBTN);
        Button first = (Button)findViewById(R.id.first);
        final Uri uriUrl = Uri.parse("http://www.sciencemadesimple.com/metric_conversion_chart.html");
        final Bundle b = new Bundle();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("This application uses values of the metric system. Press \"Yes\" if you understand. Press \"No\" " +
        		"if you would like to know the conversions ")
               .setCancelable(false)
               .setPositiveButton("Yes, I understand", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                   }
               })
               .setNegativeButton("No, please take me to the website", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);  
                	   startActivity(launchBrowser);
                   }
               });
        final AlertDialog alert = builder.create();
        final Intent i = new Intent(PhysicsCalculator_v2Activity.this,Phase_2.class);
        first.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				alert.show();
			}
		});
        v1I.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				b.putInt("choice", 0);
				i.putExtras(b);
				PhysicsCalculator_v2Activity.this.startActivity(i);
								
			}
		});
        v2I.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				b.putInt("choice", 1);
				i.putExtras(b);
				PhysicsCalculator_v2Activity.this.startActivity(i);				
			}
		});
        dI.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				b.putInt("choice", 2);
				i.putExtras(b);
				PhysicsCalculator_v2Activity.this.startActivity(i);				
			}
		});
        aI.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				b.putInt("choice", 3);
				i.putExtras(b);
				PhysicsCalculator_v2Activity.this.startActivity(i);				
			}
		});
        tI.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				b.putInt("choice", 4);
				i.putExtras(b);
				PhysicsCalculator_v2Activity.this.startActivity(i);				
			}
		});
    }
}