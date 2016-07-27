package yuan.demo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import yuan.demo.databinding.ActivityUserIfoBinding;

public class UserIfoActivity extends AppCompatActivity {

    ActivityUserIfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_user_ifo);
        initView();
    }

    private void initView() {

        binding.rlUserHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO　跳转图片预览与选择图片
            }
        });

        binding.rlUserNick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 昵称信息 参数
                Intent intent=new Intent(UserIfoActivity.this,UpdateIfoActivity.class);
                intent.putExtra(SettingConstant.UPDATE_IFO_ACTIVITY_KEY,SettingConstant.UPDATE_USER_NICK);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onBackPressed() {
        finish();
    }

}
