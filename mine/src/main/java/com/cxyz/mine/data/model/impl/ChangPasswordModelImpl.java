package com.cxyz.mine.data.model.impl;

import android.accounts.NetworkErrorException;
import android.util.Log;
import android.widget.EditText;

import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.mine.R;
import com.cxyz.mine.data.model.IChangPasswordModel;
import com.cxyz.mine.ui.activity.ChangPasswordActivity;

public class ChangPasswordModelImpl extends IChangPasswordModel {
    private EditText oldPasswordEdit;
    private ChangPasswordActivity changPasswordActivity;
    @Override
    public void loadData(OnGetModel onGetModel) {

        try {
            RequestParams params = new RequestParams();
            params.put("password","1234566");
            CommonOkHttpClient.get("http://rest.apizza.net/mock/230ac06df6f24f16acec6dcbbc686092/lixing/password",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            onGetModel.getModel(true);
                        }

                        @Override
                        public void onFailure(Object error) {
                            onGetModel.getModel(false);
                        }
                    }));
        } catch (NetworkErrorException e) {
            e.printStackTrace();
        }
    }
}
