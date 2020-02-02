package com.cxyz.mine.data.model.impl;

import com.cxyz.mine.R;
import com.cxyz.mine.data.model.IMallInformationInModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MallInformationModelImpl extends IMallInformationInModel {

    @Override
    public void loadGetModel(OnGetModel ongetModel) {
        ongetModel.getModel(getListShop(),getListAd());
    }

    private List<Map<String, Object>> getListAd() {
        int[] ivAd = new int[]{R.mipmap.mine_mall_ad_img01,
                R.mipmap.mine_mall_ad_img02,
                R.mipmap.mine_mall_ad_img03,
                R.mipmap.mine_mall_ad_img04,
                R.mipmap.mine_mall_ad_img05};
        String[] tvAdContents = new String[]{"潮流好看，价格实惠，全国包邮，多买多赠",
                "时尚女衣，设计精美采用最新制造...","美丽的冬季需要美丽保暖的帽子...",
                "艺术的设计，送给最爱的人...","时尚商务男装，彰显成功的你..."
        };
        String[] tvAdContent = new String[]{"潮流好看，价格实惠......",
                "时尚女衣，设计精美......","美丽保暖的帽子...",
                "艺术的设计...","时尚彰显成功的你..."
        };
        String[] tvAdTitle = new String[]{"￥233.00","￥243.00","￥253.00","￥263.00","￥369.00"
        };
        List<Map<String,Object>> listitemAd = new ArrayList<Map<String,Object>>();
        for(int i = 0;i<ivAd.length;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("image",ivAd[i]);
            map.put("name",tvAdContent[i]);
            map.put("context",tvAdContents[i]);
            map.put("form",tvAdTitle[i]);
            listitemAd.add(map);
        }
        return listitemAd;
    }

    private List<Map<String, Object>> getListShop() {
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
