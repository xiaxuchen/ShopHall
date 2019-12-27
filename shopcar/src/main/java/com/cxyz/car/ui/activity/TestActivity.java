package com.cxyz.car.ui.activity;

<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;
=======
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
>>>>>>> origin/feature-lmk
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cxyz.car.R;
<<<<<<< HEAD
import com.cxyz.car.ui.activity.mainfragment.MainActivity;
import com.cxyz.car.ui.activity.mainfragment.MainFragment;
=======
>>>>>>> origin/feature-lmk


public class TestActivity extends AppCompatActivity {
    private Button btn1_afragment;
    private MainFragment mainFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        /**
         * 点击按钮加载一个fragment
         */
        btn1_afragment=findViewById(R.id.btn1_afragment);
        btn1_afragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
//                startActivity(new Intent(TestActivity.this, MainActivity.class));
                mainFragment=new MainFragment();
                getFragmentManager().beginTransaction().add(R.id.fl_fragment,mainFragment).commitAllowingStateLoss();
=======
                mainFragment=new MainFragment();
                getFragmentManager().beginTransaction().add(R.id.fl_fragment,mainFragment);
>>>>>>> origin/feature-lmk
            }
        });
    }
}
