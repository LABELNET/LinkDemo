package yuan.demo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import yuan.demo.databinding.ActivitySettingBinding;

/**
 * 个人设置页面
 */
public class SettingActivity extends AppCompatActivity {

    ActivitySettingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_setting);

        initView();

    }

    private void initView() {


        //二维码
        binding.ivUserRqcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 添加 ID值　参数
                Intent intent=new Intent(SettingActivity.this,RqcodeActivity.class);
                startActivity(intent);
            }
        });

        //用户信息
        binding.settingUserIfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 添加用户对象　参数
                Intent intent=new Intent(SettingActivity.this,UserIfoActivity.class);
                startActivity(intent);
            }
        });

        //账户与安全
        binding.settingUserSafety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 手机号　参数
                Intent intent=new Intent(SettingActivity.this,SafetyActivity.class);
                startActivity(intent);
            }
        });

        //隐私
        binding.settingSecret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingActivity.this,PrivacyActivity.class);
                startActivity(intent);
            }
        });

        //通用
        binding.settingGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingActivity.this,GeneralActivity.class);
                startActivity(intent);
            }
        });


        //帮助
        binding.settingHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingActivity.this,HelpActivity.class);
                startActivity(intent);
            }
        });

        //关于
        binding.settingAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingActivity.this,AboutActivity.class);
                startActivity(intent);
            }
        });


    }

}
