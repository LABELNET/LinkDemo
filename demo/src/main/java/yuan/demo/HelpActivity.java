package yuan.demo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HelpActivity extends AppCompatActivity {

    private ListView helpList;
    String [] itemStrs;
    List<Item> items=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        helpList= (ListView) findViewById(R.id.help_list);
        itemStrs=getResources().getStringArray(R.array.help_content);
        initView();
    }

    private void initView() {

        for (String itemStr : itemStrs){
            Item item=new Item();
            item.setTitle(itemStr);
            items.add(item);
        }
        HelpListAdapter adapter=new HelpListAdapter(items);
        adapter.setContext(this);
        helpList.setAdapter(adapter);
    }



    //适配器
    private static class HelpListAdapter extends BaseAdapter {

        private List<Item> items=new ArrayList<>();
        private Context context;

        public void setContext(Context context) {
            this.context = context;
        }

        public HelpListAdapter(List<Item> items) {
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView tvItemText;
            if(view==null){
                view= LayoutInflater.from(context).inflate(R.layout.item_help_activity,viewGroup,false);
                tvItemText= (TextView) view.findViewById(R.id.tv_name);
                view.setTag(tvItemText);
            }else{
                tvItemText= (TextView) view.getTag();
            }
            tvItemText.setText(items.get(i).getTitle());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //TODO 跳转
                }
            });
            return view;
        }
    }


    private static class Item{
        private String title,url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
