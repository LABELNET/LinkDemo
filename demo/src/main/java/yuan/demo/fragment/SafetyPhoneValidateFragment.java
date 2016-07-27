package yuan.demo.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import yuan.demo.R;
import yuan.demo.SafetyPhoneActivity;
import yuan.demo.databinding.FragmentSafetyPhoneBindBinding;
import yuan.demo.databinding.FragmentSafetyPhoneVaildateBinding;

/**
 * Created by yuan on 16-7-27.
 * 验证手机号
 */
public class SafetyPhoneValidateFragment extends Fragment{

    FragmentSafetyPhoneVaildateBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.bind(inflater.inflate(R.layout.fragment_safety_phone_vaildate,container,false));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       final SafetyPhoneActivity safePhoneActivity= (SafetyPhoneActivity) getActivity();
       binding.setPhone(safePhoneActivity.getPhoneNumber());
       binding.btnSafetyNext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //TODO 判断验证码，并进行下一步
               if(isValidateTrue()){
                   safePhoneActivity.switchContent(SafetyPhoneValidateFragment.this,SafetyPhoneBindFragment.getInstance());
               }else{
                   Toast.makeText(getActivity(),"验证码不正确",Toast.LENGTH_SHORT).show();
               }
           }
       });
    }


    private boolean isValidateTrue(){
        //TODO 进行验证码判断
        return true;
    }

    public static Fragment getInstance(){
        return new SafetyPhoneValidateFragment();
    }

}
