package yuan.demo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import yuan.demo.databinding.ActivityRqcodeBinding;

/**
 * 二维码生成页面
 */
public class RqcodeActivity extends AppCompatActivity {

    ActivityRqcodeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_rqcode);
        initView();

    }

    private void initView() {

        binding.ivRqcodeClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
