package yuan.demo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import yuan.demo.databinding.ActivitySafetyBinding;

/**
 * 账户与安全界面
 */
public class SafetyActivity extends AppCompatActivity implements View.OnClickListener{

    ActivitySafetyBinding binding;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_safety);
        initData();
        initView();
    }

    private void initView() {
        binding.safetyPhone.setOnClickListener(this);
        binding.safetyLoginPassword.setOnClickListener(this);
        binding.safetyPaySetting.setOnClickListener(this);
        binding.safetyLockGesture.setOnClickListener(this);
        binding.safetySecretBackup.setOnClickListener(this);
    }


    private void initData() {
        //电话号码与锁屏手势状态
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.safety_phone:
                //修改手机号
                intent=new Intent(SafetyActivity.this,SafetyPhoneActivity.class);
                startActivity(intent);
                break;
            case R.id.safety_login_password:
                showDialog();
                break;
            case R.id.safety_pay_setting:
                intent=new Intent(SafetyActivity.this,SafetyPaySettingActivity.class);
                startActivity(intent);
                break;
            case R.id.safety_lock_gesture:
                intent=new Intent(SafetyActivity.this,SafetyGesturePasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.safety_secret_backup:
                intent=new Intent(SafetyActivity.this,SafetyPrivateKeyBackup.class);
                startActivity(intent);
                break;
        }
    }

    private void showDialog(){
        final View view = getLayoutInflater().inflate(R.layout.dialog_alert_edit_pass, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setNegativeButton(R.string.safety_phone_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton(R.string.safety_phone_sure, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                final EditText etPass= (EditText) view.findViewById(R.id.et_dialog_pass);
                //TODO 与本地密码进行匹配，成功后进行跳转
                if(etPass.getText().toString().equals("")){
                    intent=new Intent(SafetyActivity.this,SafetyPasswordActivity.class);
                    startActivity(intent);
                }else{
                    //不正确
                    Toast.makeText(SafetyActivity.this,"登陆密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        }).setView(view);
        builder.create().show();
    }


    @Override
    public void onBackPressed() {
        finish();
    }
}
