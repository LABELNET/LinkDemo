package yuan.demo.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yuan.demo.R;
import yuan.demo.databinding.FragmentSafetyPhoneBindBinding;

/**
 * Created by yuan on 16-7-27.
 * 绑定手机号显示页面
 */
public class SafetyPhoneBindFragment extends Fragment{

    FragmentSafetyPhoneBindBinding bindBinding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bindBinding= DataBindingUtil.bind(inflater.inflate(R.layout.fragment_safety_phone_bind,container,false));
        return bindBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    public static Fragment getInstance(){
        return new SafetyPhoneBindFragment();
    }

}
