package yuan.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 修改登陆密码界面
 *
 */
public class SafetyPasswordActivity extends AppCompatActivity {


    private EditText etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_password);
        etPass= (EditText) findViewById(R.id.et_pass_new);
        //TODO 加载本地密码显示
        final TextView tvPassTip= (TextView) findViewById(R.id.tv_pass_tip);

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
                savePassData();
                break;
        }
        return true;
    }

    //TODO 保存密码信息
    private void savePassData() {

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
