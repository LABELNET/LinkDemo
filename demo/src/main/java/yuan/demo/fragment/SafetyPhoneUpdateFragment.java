package yuan.demo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import yuan.demo.R;
import yuan.demo.SafetyPhoneActivity;

/**
 * Created by yuan on 16-7-27.
 * 修改手机号页面
 */
public class SafetyPhoneUpdateFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_safety_phone_update,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Button btnSafetyValidate= (Button) view.findViewById(R.id.btn_safety_validate);
        final EditText etSafetyText= (EditText) view.findViewById(R.id.et_safety_phone_num);
        btnSafetyValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SafetyPhoneActivity safePhoneActivity= (SafetyPhoneActivity) getActivity();
                safePhoneActivity.setPhoneNumber(etSafetyText.getText().toString());
                safePhoneActivity.switchContent(SafetyPhoneUpdateFragment.this,SafetyPhoneValidateFragment.getInstance());
            }
        });

    }

    public static Fragment getInstance(){
        return new SafetyPhoneUpdateFragment();
    }

}
