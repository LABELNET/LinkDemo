package yuan.demo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import yuan.demo.databinding.ActivitySafetyBinding;

/**
 * 账户与安全界面
 */
public class SafetyActivity extends AppCompatActivity {

    ActivitySafetyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_safety);
        initData();
    }


    private void initData() {
        //电话号码与锁屏手势状态
    }


}
