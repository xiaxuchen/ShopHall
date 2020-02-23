package com.cxyz.car.presenter.view;

import com.cxyz.car.data.domain.PreviewItem;
import com.cxyz.mvp.iview.IBaseView;

public interface IPreviewView extends IBaseView {
    public abstract  void showOption(PreviewItem previewItem,String[] options);
}
