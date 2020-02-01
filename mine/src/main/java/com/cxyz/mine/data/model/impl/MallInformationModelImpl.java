package com.cxyz.mine.data.model.impl;

import com.cxyz.mine.R;
import com.cxyz.mine.data.model.MallInformationInModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MallInformationModelImpl implements MallInformationInModel {

    @Override
    public void loadGetModel(OnGetModel ongetModel) {
        ongetModel.getModel(getData());
    }

    private List<Map<String, Object>> getData() {
        int[] ivShopImg = new int[]{R.mipmap.mine_shopinformation_img01,
                R.mipmap.mine_shopinformation_img02,
                R.mipmap.mine_shopinformation_img03,
                R.mipmap.mine_shopinformation_img04,
                R.mipmap.mine_shopinformation_img05,
                R.mipmap.mine_shopinformation_img06,
                R.mipmap.mine_shopinformation_img07,
                R.mipmap.mine_shopinformation_img08,
                R.mipmap.mine_shopinformation_img010,
                R.mipmap.mine_shopinformation_img11,
                R.mipmap.mine_shopinformation_img12,
                R.mipmap.mine_shopinformation_img13,};
        String[] tvShopName = new String[]{"坚强百货","恒通百货",
                "都是批发市场","捷达百货批发",
                "嘟嘟美食铺子","利达蛋糕店","百利商行",
                "恒达美食批发","便利商行",
                "百兴实业","丽丽美食城","东东百货"};
        List<Map<String,Object>> listItemShop = new ArrayList<Map<String,Object>>();
        for(int i = 0; i<ivShopImg.length;i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("images",ivShopImg[i]);
            map.put("shopName",tvShopName[i]);
            listItemShop.add(map);
        }
        return listItemShop;
    }
}
