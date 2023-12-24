package com.hchen.hidecleanup;

import com.hchen.hidecleanup.hideCleanUp.HideCleanUp;
import com.hchen.hidecleanup.hook.Hook;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class HookMain implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(LoadPackageParam lpparam) {
        if ("com.miui.home".equals(lpparam.packageName)) {
            initHook(new HideCleanUp(), lpparam);
        }
    }

    public static void initHook(Hook hook, LoadPackageParam param) {
        hook.runHook(param);
    }

}
