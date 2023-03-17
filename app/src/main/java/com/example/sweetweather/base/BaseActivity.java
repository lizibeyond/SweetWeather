package com.example.sweetweather.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lizi
 * PS:base主界面,用于统一管理所有的activity,所有的activity界面都继承自该类
 */
public class BaseActivity extends AppCompatActivity {
    private List<Activity> activities;

    public void addActivity(Activity activity){
        activities.add(activity);
    }

    @Override
    protected void onStart() {
        super.onStart();
        activities = new ArrayList<>();
    }
}
