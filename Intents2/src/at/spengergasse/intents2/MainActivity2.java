package at.spengergasse.intents2;

import android.os.Bundle;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends Activity implements OnClickListener {
	private Button an1;
	private TextView an2, fr1;
	private EditText et1;
	private String faI = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity2);
		
		an1 = (Button) findViewById(R.id.fire);
		an1.setOnClickListener(this);
		
		an2 = (TextView) findViewById(R.id.fnrI);
		et1 = (EditText) findViewById(R.id.antI);
		fr1 = (TextView) findViewById(R.id.frageI);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onRestart() {
		Intent intent = getIntent();
		if (intent != null) {
			String d1 = intent.getStringExtra("fnrI");
			String d2 = intent.getStringExtra("frageI");
			faI = intent.getStringExtra("faI");
			
			an2.setText(d1);
			fr1.setText(d2);
		}
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Intent intent = getIntent();
		if (intent != null) {
			String d1 = intent.getStringExtra("fnrI");
			String d2 = intent.getStringExtra("frageI");
			faI = intent.getStringExtra("faI");
			
			an2.setText(d1);
			fr1.setText(d2);
		}
		super.onResume();
	}

	@Override
	protected void onStart() {
		Intent intent = getIntent();
		if (intent != null) {
			String d1 = intent.getStringExtra("fnrI");
			String d2 = intent.getStringExtra("frageI");
			faI = intent.getStringExtra("faI");
			
			an2.setText(d1);
			fr1.setText(d2);
		}
		super.onStart();
	}

	@Override
	public void onClick(View v) {
		if(v.equals(an1)) {
			Intent i = new Intent(MainActivity2.this, MainActivity.class);
			i.putExtra("antI", et1.getText().toString());
			i.putExtra("fnrI", an2.getText().toString());
			i.putExtra("frageI", fr1.getText().toString());
			i.putExtra("faI", faI);

			try {  
				this.startActivityForResult(i, Intent.FLAG_ACTIVITY_CLEAR_TOP);
			} catch (ActivityNotFoundException ex) {
				ex.printStackTrace();
			}
		}
	}

}
