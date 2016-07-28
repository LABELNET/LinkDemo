package yuan.demo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import yuan.demo.databinding.ActivityGeneralBinding;

public class GeneralActivity extends AppCompatActivity {

    ActivityGeneralBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_general);

        initView();
    }

    private void initView() {

        binding.generalMsgNotify.setState(true);
        binding.generalMoreLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 多语言跳转
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
