package com.haohao.kotlintest.help;

public interface Infos {
    // These strange keys' values are kept for compatibility and must not be modified!
    interface Keys {
        String SPLASH_AD_NAME = "splash_ad_name";
        String SPLASH_AD_INFO = "splash_ad_info";

        String DOWNLOAD_UPDATE = "IsFuckDownloadUpdate";
        String EVALUATE_FILENAME_UPDATE = "evaluate_filename_update";

        String LAST_VERSION_CODE = "VERSION_CODE";
        String FIRST_EVALUATE = "firstEvaluate";
        String USED_FREE_DOWNLOAD_COUNT = "download_num_with_no_integral";
        String SAVED_USERNAME = "userName";
        String SAVED_PASSWORD = "userPwd";
        String SERIALIZED_USER = "serialized_user";
        String SERIALIZE_USER_AT = "serialize_user_at";
        String ALARM_BELL_FILE_LOCATION = "belladdress";

        String SHOW_MARKET_SCORE = "show_market_score";

        String SYSTEM_LANGUAGE ="system_language";

        String CATEGORY = "system_category";

        String NIGHTTYPE = "night_type";

        String FIRST_MAIN = "first_main";

        String DEVICE_ID = "device_id";
    }

    interface DefaultValue {
        String SPLASH_AD_NAME = "";
        String SPLASH_AD_INFO = "";
        String SYSTEM_LANGUAGE ="default";//zh  en
        String CATEGORY = "voa_special";

        boolean DOWNLOAD_UPDATE = false;
        boolean EVALUATE_FILENAME_UPDATE = false;

        int LAST_VERSION_CODE = 0;
        boolean FIRST_EVALUATE = true;
        int USED_FREE_DOWNLOAD_COUNT = 0;
        String SAVED_USERNAME = "";
        String SAVED_PASSWORD = "";
        String SERIALIZED_USER = "";
        long SERIALIZE_USER_AT = 0;
        String ALARM_BELL_FILE_LOCATION = "";

        boolean SHOW_MARKET_SCORE = true;

        boolean NIGHTTYPE = false;

        boolean FIRST_MAIN = false;

        String DEVICE_ID = "";
    }
}
