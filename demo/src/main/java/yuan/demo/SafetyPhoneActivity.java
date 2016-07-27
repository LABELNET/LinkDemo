package yuan.demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import yuan.demo.fragment.SafetyPhoneBindFragment;

public class SafetyPhoneActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    Fragment mContent;

    private String phoneNumber;
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_phone);
        initView();
    }


    private void initView() {
        fragmentManager=getSupportFragmentManager();
        mContent= SafetyPhoneBindFragment.getInstance();
        fragmentManager
                .beginTransaction()
                .add(R.id.rl_safety_phone,mContent)
                .show(mContent)
                .commit();
    }

    public void switchContent(Fragment from, Fragment to) {
        if (mContent != to) {
            mContent = to;
            FragmentTransaction transaction = fragmentManager.beginTransaction().setCustomAnimations(
                    android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            if (!to.isAdded()) {    // 先判断是否被add过
                // 隐藏当前的fragment，add下一个到Activity中
                transaction.hide(from).add(R.id.rl_safety_phone, to).commit();
            } else {
                // 隐藏当前的fragment，显示下一个
                transaction.hide(from).show(to).commit();
            }
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }


}
