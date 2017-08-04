package com.liyuaninc.liyuan.download;

/**
 * Created by Administrator on 2017/8/4.
 */

public interface DownloadListener {
    void onProgress(int progress);
    void onSuccess();
    void onFailed();
    void onPaused();
    void onCanceled();
}
