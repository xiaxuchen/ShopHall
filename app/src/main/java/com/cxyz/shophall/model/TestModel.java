package com.cxyz.shophall.model;

import com.cxyz.mvp.imodel.IBaseModel;

public abstract class TestModel extends IBaseModel {

    public abstract void verifyUser(String username,VerifyListener listener);

    public interface VerifyListener{
        /**
         *
         * @param data 数据，可以是其他类型的，看需求
         */
        void success(String data);

        /**
         *
         * @param error 错误信息
         */
        void fail(String error);
    }
}
