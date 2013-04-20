package my.json;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class data extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		String val = this.getIntent().getStringExtra("name");
		String val1 = this.getIntent().getStringExtra("vicinity");
		TextView t = (TextView) findViewById(R.id.text1);
		TextView t1 = (TextView) findViewById(R.id.text2);
		t.setText(val);
		t1.setText(val1);
	}
	
	

}
