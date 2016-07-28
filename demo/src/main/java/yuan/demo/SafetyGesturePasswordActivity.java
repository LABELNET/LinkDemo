package yuan.demo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import yuan.demo.databinding.ActivitySafetyGesturePasswordBinding;
import yuan.demo.weiget.SwitchView;

/**
 * 手势密码
 */
public class SafetyGesturePasswordActivity extends AppCompatActivity {

    ActivitySafetyGesturePasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_safety_gesture_password);
        initView();
    }

    private void initView() {
        binding.gestureOpen.setState(true);
        binding.gestureOpen.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
            @Override
            public void toggleToOn() {
                //TODO 有手势密码-参数key　打开锁屏绘制
                binding.gestureOpen.setState(true);
            }

            @Override
            public void toggleToOff() {
                binding.gestureOpen.setState(false);
            }
        });

        //TODO 没有手势密码　隐藏修改手势密码
        binding.gestureUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 修改手势密码-参数key 验证手势密码

            }
        });
    }
}
