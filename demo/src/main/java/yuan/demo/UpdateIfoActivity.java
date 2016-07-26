package yuan.demo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

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

          binding.etUpdateIfo.addTextChangedListener(new TextWatcher() {
              @Override
              public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
              @Override
              public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                  setClearIconIsShow(charSequence.length()>0);
              }
              @Override
              public void afterTextChanged(Editable editable) {
                  //TODO 可以进行判断输入的文字长度
                   setClearIconIsShow(editable.toString().length()>0);
              }
          });

        //焦点监听
        binding.etUpdateIfo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    setClearIconIsShow(getEditText().length()>0);
                }else{
                    setClearIconIsShow(false);
                }
            }
        });

      binding.ivUpdateIfoClear.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              clearEditText();
          }
      });

    }


    /**
     * 清除输入框信息
     */
    private void clearEditText() {
        binding.etUpdateIfo.setText("");
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_save:
                saveData();
                break;
        }
        return true;
    }

    /**
     * 保存数据
     */
    private void saveData() {
        Toast.makeText(this,"保存",Toast.LENGTH_LONG).show();
    }

}
