package yuan.demo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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


    }


}
