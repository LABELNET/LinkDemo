package yuan.demo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import yuan.demo.databinding.ActivityPrivacyBinding;
import yuan.demo.weiget.SwitchView;

public class PrivacyActivity extends AppCompatActivity{

    ActivityPrivacyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_privacy);
        initView();
    }

    private void initView() {
        binding.privacyAddSwitch.setState(true);
        binding.privacySearchSwitch.setState(true);
        binding.privacyAutoSwitch.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
            @Override
            public void toggleToOn() {

            }

            @Override
            public void toggleToOff() {

            }
        });
    }
}
