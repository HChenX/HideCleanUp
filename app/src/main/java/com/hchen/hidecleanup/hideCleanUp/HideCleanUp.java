package com.hchen.hidecleanup.hideCleanUp;

import android.view.View;

import com.hchen.hidecleanup.hook.Hook;

public class HideCleanUp extends Hook {

    @Override
    public void init() {
        hookAllMethods("com.miui.home.recents.views.RecentsContainer",
                "onFinishInflate",
                new HookAction() {
                    @Override
                    protected void after(MethodHookParam param) throws Throwable {
                        View mView = (View) getObjectField(param.thisObject, "mClearAnimView");
                        mView.setVisibility(View.GONE);
                    }
                }
        );
    }
}
