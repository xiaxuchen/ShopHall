package com.cxyz.car.ui.activity;

import android.accounts.NetworkErrorException;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.GetItemText;
import com.cxyz.car.data.domain.TestGoods;
import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.utils.GsonUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.util.List;


public class TestApizActivity extends BaseActivity {
    private ImageView iv;
    private TextView tv;
    private CheckResult<List<TestGoods>> checkResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RequestParams params=new RequestParams();
        params.put("id","1");
        params.put("name","李民康");

        try {
            CommonOkHttpClient.get("http://rest.apizza.net/mock/60df82bc7ba12927750ab8c1b6537225/testmvp",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json = responseObj.toString();
                            Gson gson = new Gson();

                            checkResult=gson.fromJson(json,new TypeToken<CheckResult<List<TestGoods>>>(){}.getType());


                            tv.setText(checkResult.getData().get(0).getDesc());
                            Toast.makeText(TestApizActivity.this, checkResult.getData().get(0).getDesc(), Toast.LENGTH_SHORT).show();

                            Glide.with(iv.getContext()).load(checkResult.getData().get(0).getImageSrc()).into(iv);

                        }
                        @Override
                        public void onFailure(Object error) {

                        }
                    }));
        } catch (NetworkErrorException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object getContentView() {
        return R.layout.shopcar_activity_apizza;
    }

    @Override
    public void initView() {
        iv=findViewById(R.id.iv_testapi_image);
        tv=findViewById(R.id.tv_testapi_title);
    }

    @Override
    public void initData() {
    }

    @Override
    public void setEvent() {

    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }
}
