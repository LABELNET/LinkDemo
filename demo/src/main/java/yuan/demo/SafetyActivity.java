package yuan.demo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import yuan.demo.databinding.ActivitySafetyBinding;

/**
 * 账户与安全界面
 */
public class SafetyActivity extends AppCompatActivity implements View.OnClickListener{

    ActivitySafetyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_safety);
        initData();
        initView();
    }

    private void initView() {

    }


    private void initData() {
        //电话号码与锁屏手势状态
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.safety_phone:
                //修改手机号
                break;
            case R.id.safety_login_password:
                break;
            case R.id.safety_pay_setting:
                break;
            case R.id.safety_lock_gesture:
                break;
            case R.id.safety_secret_backup:
                break;
        }
    }






}
