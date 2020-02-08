package com.cxyz.mine.data.model.impl;

import com.cxyz.mine.data.model.IShippingAdressModel;
import com.cxyz.mine.ui.adapter.entity.Adress;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShippingAdressModelImpl extends IShippingAdressModel {

    @Override
    public void loadAdressData(OnloadAdressData onloadAdressData) {
        onloadAdressData.onAdressDate(getData());
    }

    private List<Adress> getData() {
        List<Adress> adressList = new ArrayList<Adress>();
        Adress lisan = new Adress("李三", "18879792833", "江西.萍乡", "安源区安源大道110");
        adressList.add(lisan);
        Adress lisans = new Adress("李三", "18879792833", "江西.萍乡", "安源区安源大道110");
        adressList.add(lisans);
        return adressList;
    }
}
