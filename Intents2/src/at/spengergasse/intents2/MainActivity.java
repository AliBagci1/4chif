package at.spengergasse.intents2;

import android.os.Bundle;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	private Button f1;
	private TextView f2, faI;
	private EditText fg1;
	private static int fn = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		f1 = (Button) findViewById(R.id.fire);
		f1.setOnClickListener(this);
		
		f2 = (TextView) findViewById(R.id.fnrI);
		fg1 = (EditText) findViewById(R.id.frageI);
		faI = (TextView) findViewById(R.id.faI);
		
//		Intent intent = getIntent();
//		if (null != intent) {
//			String d1 = intent.getStringExtra("antI");
//			
//			faI.setText(faI.getText()+"\r\n"+d1);
//		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onResume() {
		Intent intent = getIntent();
		if (intent != null) {
			String d1 = intent.getStringExtra("antI");
			String d2 = intent.getStringExtra("frageI");
			String d3 = intent.getStringExtra("fnrI");
			String d4 = intent.getStringExtra("faI");
			
			if(d4 == null) {
				d4 = "";
			}
			if(d3 == null) {
				d3 = "";
			}
			if(d2 == null) {
				d2 = "";
			}
			if(d1 == null) {
				d1 = "";
			}
			
			f2.setText(d3);
			fg1.setText(d2);
			faI.setText(d4+"\r\n"+d3+"\t"+d2+"\t"+d1);
		}
		super.onRestart();
	}
	
	@Override
	public void onClick(View v) {
		if(v.equals(f1)) {
			fn++;
			f2.setText(""+fn);
			Intent i = new Intent(MainActivity.this, MainActivity2.class);
			i.putExtra("fnrI", f2.getText().toString());
			i.putExtra("frageI", fg1.getText().toString());
			i.putExtra("faI", faI.getText().toString());
			
			try {  
				this.startActivityForResult(i, Intent.FLAG_ACTIVITY_CLEAR_TOP);
			} catch (ActivityNotFoundException ex) {
				ex.printStackTrace();
			}
		}
	}
}
