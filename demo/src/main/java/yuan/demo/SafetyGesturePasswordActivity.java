package yuan.demo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import yuan.demo.databinding.ActivitySafetyGesturePasswordBinding;

/**
 * 手势密码
 */
public class SafetyGesturePasswordActivity extends AppCompatActivity {

    ActivitySafetyGesturePasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_safety_gesture_password);
        initView();
    }

    private void initView() {
        binding.gestureOpen.setState(true);
    }
}
