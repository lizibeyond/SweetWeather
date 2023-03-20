package com.example.sweetweather.ui.SweetSplsh;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.UiThread;

import com.example.sweetweather.R;
import com.example.sweetweather.base.BaseActivity;
import com.example.sweetweather.error.SweetError;
import com.example.sweetweather.network.SweetNetWork;
import com.example.sweetweather.request.SweetHttpListener;

public class SweetSplshActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweet_splsh);

        findViewById(R.id.btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SweetNetWork.getCityData("北京", new SweetHttpListener<Object>() {
            @Override
            public void onSucceed(Object entity) {
                String s = entity.toString();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(SweetSplshActivity.this, s, Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onFeild(SweetError error) {

            }
        });
    }
}
