package yuan.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SafetyPayForwardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_pay_forward);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
