package com.example.mvp.coolweather.util;


import android.text.TextUtils;

import com.example.mvp.coolweather.db.City;
import com.example.mvp.coolweather.db.Country;
import com.example.mvp.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray jaaa = new JSONArray(response);
                for (int i = 0; i < jaaa.length(); i++) {
                    JSONObject jooo = jaaa.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(jooo.getString("name"));
                    province.setProvinceCode(jooo.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public static boolean handleCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray jaaa = new JSONArray(response);
                for (int i = 0; i < jaaa.length(); i++) {
                    JSONObject jooo = jaaa.getJSONObject(i);
                    City city = new City();
                    city.setCityName(jooo.getString("name"));
                    city.setCityCode(jooo.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public static boolean handleCountryResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray jaaa = new JSONArray(response);
                for (int i = 0; i < jaaa.length(); i++) {
                    JSONObject jooo = jaaa.getJSONObject(i);
                    Country country = new Country();
                    country.setCountryName(jooo.getString("name"));
                    country.setWeatherId(jooo.getString("weather_id"));
                    country.setCityId(cityId);
                    country.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
}
