package com.cxyz.mine.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cxyz.mine.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MallInformationFragment extends Fragment {

    private TextView tvNav;
    private Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_activity_mallinformation_layout,container,false);
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*商城店铺信息*/
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
        List<Map<String,Object>> listitemShop = new ArrayList<Map<String,Object>>();
        for(int i = 0; i<ivShopImg.length;i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("images",ivShopImg[i]);
            map.put("shopName",tvShopName[i]);
            listitemShop.add(map);
        }
        SimpleAdapter simpleAdapterShop = new SimpleAdapter(context,listitemShop,R.layout.mine_grid_item_shop,
                new String[]{"images","shopName"},new int[]{R.id.ivShopImg,R.id.tvShopName});
        GridView gridView = view.findViewById(R.id.gvMallInformation);
        gridView.setAdapter(simpleAdapterShop);

        /*广告部分的信息*/
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
        SimpleAdapter simpleAdapterAd = new SimpleAdapter(context,listitemAd,R.layout.mine_list_item_ad,
                new String[]{"name","image","form","context"},
                new int[]{R.id.tvAdContent,R.id.ivAd,R.id.tvAdTitle,R.id.tvAdContents});
        ListView listView = view.findViewById(R.id.lvMallAd);
        listView.setAdapter(simpleAdapterAd);

    }
}
