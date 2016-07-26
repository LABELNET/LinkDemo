package yuan.demo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import yuan.demo.databinding.ActivityUpdateIfoBinding;

public class UpdateIfoActivity extends AppCompatActivity {

    ActivityUpdateIfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_update_ifo);
        initView();


    }

    private void initView() {
      //焦点监听
      binding.etUpdateIfo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
          @Override
          public void onFocusChange(View view, boolean b) {
              if(b){
                  setClearIconIsShow(getEditText().isEmpty());
              }else{
                  setClearIconIsShow(false);
              }
          }
      });
    }


    /**
     *　获取输入框信息
     */
    private String getEditText(){
       return binding.etUpdateIfo.getText().toString();
    }

    /**
     * 设置图标是否显示
     * @param isShow　是否显示
     */
    private void setClearIconIsShow(boolean isShow){
        if(isShow){
            binding.ivUpdateIfoClear.setVisibility(View.VISIBLE);
        }else{
            binding.ivUpdateIfoClear.setVisibility(View.GONE);
        }
    }


}
