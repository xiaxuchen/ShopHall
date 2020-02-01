package com.cxyz.mine.presenter.view;

import java.util.List;
import java.util.Map;

import com.cxyz.mine.data.model.MallInformationInModel;
import com.cxyz.mine.data.model.impl.MallInformationModelImpl;
import com.cxyz.mine.presenter.IMallInformationView;

public class MallInfromatonPresenter {

    IMallInformationView view;
    MallInformationModelImpl model = new MallInformationModelImpl();
    public MallInfromatonPresenter(IMallInformationView view){
        this.view = view;
    }
    /*
    *   执行业务逻辑
    * */
    public void fetch(){
        if(view!=null && model!=null){
            model.loadGetModel(new MallInformationInModel.OnGetModel() {
                @Override
                public void getModel(List<Map<String, Object>> list) {
                    view.showInformationView(list);
                }
            });
        }
    }
}
