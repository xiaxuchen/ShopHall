package com.cxyz.car.ui.activity;

import android.accounts.NetworkErrorException;
import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.car.R;
import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.utils.GsonUtil;
import com.cxyz.widget.HeaderBar;
import com.google.gson.reflect.TypeToken;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import org.json.JSONException;

@Route(path="/shopcar/ForgotActivity",group = "shopcar")
public class ForgotActivity extends BaseActivity {
    private EditText etForgotPhone;//电话号码
    private TextView tvStoreGetVerifyCode;//发送验证码按钮
    private QMUIRoundButton qmuiRoundButton;//确认修改按钮
    private TextView etForgotNewPassword;//新密码
    private HeaderBar hbForgot;//顶部导航栏
    @Override
    protected Object getContentView() {
        return R.layout.shopcar_activity_forgot;
    }

    @SuppressLint("WrongViewCast")
    @Override
    public void initView() {
        etForgotPhone=findViewById(R.id.etForgotPhone);
        tvStoreGetVerifyCode=findViewById(R.id.tvStoreGetVerifyCode);
        qmuiRoundButton=findViewById(R.id.qmuibtnSure);
        etForgotNewPassword=findViewById(R.id.etForgotNewPassword);
        hbForgot=findViewById(R.id.hbForgot);
    }

    @Override
    public void initData() {
        tvStoreGetVerifyCode.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        tvStoreGetVerifyCode.getPaint().setAntiAlias(true);
    }

    @Override
    public void setEvent() {
        tvStoreGetVerifyCode.setOnClickListener(new View.OnClickListener() {//点击发送验证码
            @Override
            public void onClick(View view) {
                RequestParams params=new RequestParams();
                params.put("phone","155xxxxxx6778");
                try {
                    CommonOkHttpClient.post("http://rest.apizza.net/mock/230ac06df6f24f16acec6dcbbc686092/user/password/modify",params,
                            new DisposeDataHandler(new DisposeDataListener() {
                                @Override
                                public void onSuccess(Object responseObj) {
                                    String json=responseObj.toString();
                                    try {
                                        CheckResult checkResult= (CheckResult) GsonUtil.fromJson(json,new TypeToken<CheckResult>(){}.getType());
                                        if (checkResult.isSuccess()){
                                            Toast.makeText(ForgotActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
    
                                @Override
                                public void onFailure(Object error) {
    
                                }
                            }));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        qmuiRoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    RequestParams params=new RequestParams();
                    params.put("phone","155xxxxx9887");//用户手机号
                    params.put("verify","4478");//验证码
                    params.put("newPassword","*************");//新密码
                    try {
                        CommonOkHttpClient.post("http://rest.apizza.net/mock/230ac06df6f24f16acec6dcbbc686092/user/password/modify",params,
                                new DisposeDataHandler(new DisposeDataListener() {
                                    @Override
                                    public void onSuccess(Object responseObj) {
                                        String json=responseObj.toString();
                                        try {
                                            CheckResult checkResult= (CheckResult) GsonUtil.fromJson(json,new TypeToken<CheckResult>(){}.getType());
                                            if (checkResult.isSuccess()){
                                                Toast.makeText(ForgotActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    @Override
                                    public void onFailure(Object error) {

                                    }
                                }));
                    } catch (NetworkErrorException e) {
                        e.printStackTrace();
                    }
            }
        });
        hbForgot.setBackClickListener(new HeaderBar.OnBackClickListener() {
            @Override
            public void onBackClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }


}
