package com.cxyz.mine.presenter.view;

import com.cxyz.mvp.iview.IBaseView;

public interface IChangPasswordView extends IBaseView {
    void showView(boolean passwordFlag,boolean codeFlag);
}
