package com.cxyz.car.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.car.R;
import com.cxyz.car.data.model.IPreviewModel;
import com.cxyz.car.presenter.PreviewPresenter;
import com.cxyz.car.presenter.view.IPreviewView;
import com.cxyz.car.ui.adapter.PreviewChooseAdapter;
import com.cxyz.car.ui.fragment.ShopcarFragment;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
@Route(path="/shopcar/PreviewActivity",group = "shopcar")
public class PreviewActivity extends BaseActivity<PreviewPresenter> implements IPreviewView {
    private TextView tv_add;
    private TextView tv_descres;
    private EditText et_count;
    private int count = 1;

    private RecyclerView rv_choose;//颜色分类

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter.fecth();
    }

    @Override
    protected Object getContentView() {
        return R.layout.shopcar_activity_preview;
    }

    @Override
    public void initView() {
        tv_add = findViewById(R.id.tv_preview_add);
        tv_descres = findViewById(R.id.tv_preview_descres);
        et_count = findViewById(R.id.et_preview_count);
        rv_choose = findViewById(R.id.rv_preview_choose);
    }
    @Override
    public void initData() {
        rv_choose.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @Override
    public void setEvent() {
        tv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (true) {
                    count++;
                    et_count.setText(count + "");
                }
            }
        });
        tv_descres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count >= 1) {
                    count--;
                    et_count.setText(count + "");
                }
            }
        });
    }

    @Override
    protected PreviewPresenter createIPresenter() {
        return new PreviewPresenter();
    }

    @Override
    public void showOption(String[] options) {
        rv_choose.setAdapter(new PreviewChooseAdapter(this, options));
    }
}
