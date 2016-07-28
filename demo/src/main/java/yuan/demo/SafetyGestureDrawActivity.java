package yuan.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SafetyGestureDrawActivity extends AppCompatActivity {

//    private int type=SettingConstant.SAFETY_GESTURE_DRAW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe_gesture_draw);
        int type=getIntent().getIntExtra(SettingConstant.SAFETY_GESTURE_KEY,SettingConstant.SAFETY_GESTURE_DRAW);
        initView(type);
    }

    private void initView(int type) {
        switch (type){
            case SettingConstant.SAFETY_GESTURE_DRAW:
                initDrawView();
                break;
            case SettingConstant.SAFETY_GESTURE_VALIDATE:
                initValiDateView();
                break;
            default:
                initDrawView();
                break;
        }
    }

    /**
     * 初始化验证界面
     */
    private void initValiDateView() {

    }

    /**
     * 初始化绘制界面
     */
    private void initDrawView() {


    }


}
