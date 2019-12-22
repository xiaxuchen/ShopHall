package com.cxyz.shophall.model;

import com.cxyz.mvp.imodel.IBaseModel;

import io.reactivex.Observable;

public abstract class TestModel extends IBaseModel {

    public abstract Observable<String> verifyUser(String username);

}
