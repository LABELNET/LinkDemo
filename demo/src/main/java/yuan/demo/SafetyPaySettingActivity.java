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

import yuan.demo.databinding.ActivitySafetyPaySettingBinding;

/**
 * 支付设置页面
 */
public class SafetyPaySettingActivity extends AppCompatActivity {

    ActivitySafetyPaySettingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_safety_pay_setting);
        initView();
    }

    private void initView() {
       binding.safetyPaySetting.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               showDialog();
           }
       });

       binding.settingPayForward.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //TODO 参数　：　转账手续费
               Intent intent=new Intent(SafetyPaySettingActivity.this,SafetyPayForwardActivity.class);
               startActivity(intent);
           }
       });

    }


    private void showDialog(){
        //TODO 封装下　可以设置密码操作
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

            }
        }).setView(view);
        builder.create().show();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
