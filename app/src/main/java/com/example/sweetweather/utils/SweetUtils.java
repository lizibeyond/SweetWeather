package com.example.sweetweather.utils;

import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;

import java.util.HashMap;

public class SweetUtils {

    public static boolean isNullOrEmpty(String string){
        return ("".equals(string) || string == null || string.isEmpty());
    }

    /**
     * 初始化x5内核
     */
    public static void initX5(){
        // 在调用TBS初始化、创建WebView之前进行如下配置
        HashMap map = new HashMap();
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, true);
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE, true);
        QbSdk.initTbsSettings(map);
    }
}
