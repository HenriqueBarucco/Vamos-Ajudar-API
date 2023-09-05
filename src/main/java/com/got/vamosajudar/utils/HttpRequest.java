package com.got.vamosajudar.utils;

import com.got.vamosajudar.exceptions.exceptions.RequestException;
import okhttp3.*;

public class HttpRequest {
    public static Response get(String url, String params) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();

            Request request = new Request.Builder()
                    .url(url + "?" + params)
                    .get()
                    .build();

            return  client.newCall(request).execute();
        } catch (Exception e) {
            throw new RequestException("Erro ao realizar request GET em: " + url);
        }
    }
}
