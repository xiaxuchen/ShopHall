package com.cxyz.message.ui.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.cxyz.message.R;
import com.cxyz.message.utils.Constants;
import com.cxyz.message.utils.PhotoUtils;


/**
 * Created by lzw on 14-9-21.
 */
public class ImageBrowserActivity extends Activity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.chat_image_brower_layout);
        imageView = (ImageView) findViewById(R.id.imageView);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent intent = getIntent();
        String path = intent.getStringExtra(Constants.IMAGE_LOCAL_PATH);
        String url = intent.getStringExtra(Constants.IMAGE_URL);
        PhotoUtils.displayImageCacheElseNetwork(imageView, path, url);
        findViewById(R.id.lly_image_browser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
