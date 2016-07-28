package yuan.demo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Set;

import yuan.demo.databinding.ActivitySafetyGesturePasswordBinding;
import yuan.demo.weiget.SwitchView;

/**
 * 手势密码
 */
public class SafetyGesturePasswordActivity extends AppCompatActivity {

    ActivitySafetyGesturePasswordBinding binding;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_safety_gesture_password);
        intent=new Intent(this,SafetyGestureDrawActivity.class);
        initView();
    }

    private void initView() {
        binding.gestureOpen.setState(true);
        binding.gestureOpen.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
            @Override
            public void toggleToOn() {
                //TODO 没有手势密码-参数key　打开锁屏绘制
                binding.gestureOpen.setState(true);
                intent.putExtra(SettingConstant.SAFETY_GESTURE_KEY, SettingConstant.SAFETY_GESTURE_VALIDATE);
                startActivity(intent);
            }

            @Override
            public void toggleToOff() {
                binding.gestureOpen.setState(false);
            }
        });

        //TODO 有手势密码　隐藏修改手势密码
        binding.gestureUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 修改手势密码-参数key 验证手势密码
                intent.putExtra(SettingConstant.SAFETY_GESTURE_KEY,SettingConstant.SAFETY_GESTURE_DRAW);
                startActivity(intent);
            }
        });
    }
}
