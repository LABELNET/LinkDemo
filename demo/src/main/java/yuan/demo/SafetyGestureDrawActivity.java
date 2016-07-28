package yuan.demo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.eftimoff.patternview.PatternView;
import com.eftimoff.patternview.cells.Cell;

import java.util.ArrayList;
import java.util.List;

import yuan.demo.databinding.ActivitySafeGestureDrawBinding;

public class SafetyGestureDrawActivity extends AppCompatActivity {

//    private int type=SettingConstant.SAFETY_GESTURE_DRAW;

    ActivitySafeGestureDrawBinding binding;
    List<Cell> cells=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_safe_gesture_draw);
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
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) binding.gestureDrawMsg.getLayoutParams();
        params.setMargins(0,60,0,0);
        binding.gestureDrawMsg.setLayoutParams(params);
        binding.gestureDrawMsg.setText(R.string.gesture_validate_desc);
        binding.gestureDrawPatternViewMini.setVisibility(View.GONE);
        binding.gestureDrawValidate.setVisibility(View.VISIBLE);
        binding.gestureDrawValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 验证本地密码
                showDialog();
            }
        });
        binding.gestureDrawPatternView.setOnPatternDetectedListener(new PatternView.OnPatternDetectedListener() {
            @Override
            public void onPatternDetected() {
                //TODO 验证图案　－> 进入绘制手势密码
                initDrawView();
            }
        });
    }

    //验证本地密码
    private void showDialog() {
        initDrawView();
    }

    /**
     * 初始化绘制界面
     */
    private void initDrawView() {
        binding.gestureDrawPatternView.clearPattern();
        binding.gestureDrawMsg.setText(R.string.gesture_draw_desc);
        binding.gestureDrawPatternViewMini.setVisibility(View.VISIBLE);
        binding.gestureDrawValidate.setVisibility(View.GONE);
        binding.gestureDrawPatternView.setOnPatternDetectedListener(new PatternView.OnPatternDetectedListener() {
            @Override
            public void onPatternDetected() {
                cells.clear();
                cells.addAll(binding.gestureDrawPatternView.getPattern());
                //进行第一次绘制
                initNextDrawView();
            }
        });
    }

    /**
     * 绘制第二次图案
     */
    private void initNextDrawView(){
        binding.gestureDrawMsg.setText(R.string.gesture_draw_desc_next);
        binding.gestureDrawPatternViewMini.setPattern(PatternView.DisplayMode.Animate,cells);
        binding.gestureDrawPatternView.clearPattern();
        binding.gestureDrawPatternView.setOnPatternDetectedListener(new PatternView.OnPatternDetectedListener() {
            @Override
            public void onPatternDetected() {

                if(cells.equals(binding.gestureDrawPatternView.getPattern())){
                    Toast.makeText(SafetyGestureDrawActivity.this,"二次输入正确",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SafetyGestureDrawActivity.this,"二次输入失败",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
