package core.api;

import android.os.Bundle;

public interface IView {
    int layoutID();
    void initView();
    void initData();
    void startActivity(Class<?> activity);
    void startActivity(Class<?> activity, Bundle data, String paramName);
}
