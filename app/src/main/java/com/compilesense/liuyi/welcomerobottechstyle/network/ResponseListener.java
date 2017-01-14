package com.compilesense.liuyi.welcomerobottechstyle.network;

/**
 * Created by shenjingyuan002 on 16/9/5.
 */
public interface ResponseListener {
    void success(String response);
    void failed();
}
