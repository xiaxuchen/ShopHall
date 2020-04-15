package com.cxyz.mine.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.utils.ToastUtil;
@Route(path = "/mine/AppVersionActivity",group = "mine")
public class AppVersionActivity extends AppCompatActivity {
    private Button btn;
    private SearchView sv;
    private ListView lv;
    private  String[] s = {"aaa","bbb","dddd"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppVersionActivity.this,SearchResultsActivity.class);
                startActivity(intent);
            }
        });
        setContentView(R.layout.mine_activity_app_version_layout);
       lv = findViewById(R.id.lv);
       ArrayAdapter<String> adapter = new ArrayAdapter<String>(AppVersionActivity.this,
               R.layout.mine_recycle_item_search, s);
       lv.setAdapter(adapter);
       lv.setTextFilterEnabled(true);
       sv = findViewById(R.id.sv);
       sv.setIconifiedByDefault(true);
       sv.setSubmitButtonEnabled(true);
       sv.setQueryHint("查找");
       sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String query) {
               ToastUtil.showShort("hhhh");
               return true;
           }

           @Override
           public boolean onQueryTextChange(String newText) {
               if(TextUtils.isEmpty(newText)){
                   lv.clearTextFilter();
               }else {
                   lv.setFilterText(newText);
               }
                   return true;
           }
       });
    }

}
