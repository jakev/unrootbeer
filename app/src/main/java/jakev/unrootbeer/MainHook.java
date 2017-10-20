/*  UnRootBeer Xposed Module
 * Copyright 2017 Jake Valletta (@jake_valletta)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jakev.unrootbeer;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class MainHook implements IXposedHookLoadPackage {

    private static final String TAG = "UnRootBeer";
    private static final String ROOTBEER_CLASS_NAME = "com.scottyab.rootbeer.RootBeer";

    private String currentPackageName = "";

    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {

        currentPackageName = lpparam.packageName;

        findAndHookMethod(Application.class, "attach", Context.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {

                Context context = (Context) param.args[0];
                ClassLoader cl = context.getClassLoader();

                if (hasRootBeer(cl)) {
                    hookRootBeer(cl);
                }
            }
        });
    }

    /* Perform Hooks */
    private void hookRootBeer(ClassLoader classLoader) {

        Log.d(TAG, "Hooking rootbeer libraries for: " + currentPackageName);

        /* isRooted() */
        findAndHookMethod(ROOTBEER_CLASS_NAME, classLoader,
                "isRooted", new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        return false;
                    }
                });

        /* isRootedWithoutBusyBoxCheck() */
        try {
            /* This check may or may not exist. Just catch and move on. */
            findAndHookMethod(ROOTBEER_CLASS_NAME, classLoader,
                    "isRootedWithoutBusyBoxCheck", new XC_MethodReplacement() {
                        @Override
                        protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                            return false;
                        }
                    });
        } catch (NoSuchMethodError e) { }

        /* detectTestKeys() */
        findAndHookMethod(ROOTBEER_CLASS_NAME, classLoader,
                "detectTestKeys", new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        return false;
                    }
                });

        /* detectRootManagementApps() */
        findAndHookMethod(ROOTBEER_CLASS_NAME, classLoader,
                "detectRootManagementApps", new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        return false;
                    }
                });

        /* detectRootManagementApps(String[]) */
        findAndHookMethod(ROOTBEER_CLASS_NAME, classLoader,
                "detectRootManagementApps", String[].class, new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        return false;
                    }
                });

        /* detectPotentiallyDangerousApps() */
        findAndHookMethod(ROOTBEER_CLASS_NAME, classLoader,
                "detectPotentiallyDangerousApps", new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        return false;
                    }
                });

        /* detectPotentiallyDangerousApps(String[]) */
        findAndHookMethod(ROOTBEER_CLASS_NAME, classLoader,
                "detectPotentiallyDangerousApps", String[].class, new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        return false;
                    }
                });

        /* detectRootCloakingApps() */
        findAndHookMethod(ROOTBEER_CLASS_NAME, classLoader,
                "detectRootCloakingApps", new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        return false;
                    }
                });

        /* detectRootCloakingApps(String[]) */
        findAndHookMethod(ROOTBEER_CLASS_NAME, classLoader,
                "detectRootCloakingApps", String[].class, new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        return false;
                    }
                });

        /* checkForSuBinary() */
        findAndHookMethod(ROOTBEER_CLASS_NAME, classLoader,
                "checkForSuBinary", new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        return false;
                    }
                });

        /* checkForBusyBoxBinary() */
        findAndHookMethod(ROOTBEER_CLASS_NAME, classLoader,
                "checkForBusyBoxBinary", new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        return false;
                    }
                });

        /* checkForBinary(String) */
        findAndHookMethod(ROOTBEER_CLASS_NAME, classLoader,
                "checkForBinary", String.class, new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        return false;
                    }
                });

        /* checkForRootNative() */
        findAndHookMethod(ROOTBEER_CLASS_NAME, classLoader,
                "checkForRootNative", new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        return false;
                    }
                });

        /* checkSuExists() */
        findAndHookMethod(ROOTBEER_CLASS_NAME, classLoader,
                "checkSuExists", new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        return false;
                    }
                });

        /* checkForDangerousProps() */
        findAndHookMethod(ROOTBEER_CLASS_NAME, classLoader,
                "checkForDangerousProps", new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        return false;
                    }
                });

        /* checkForRWPaths() */
        findAndHookMethod(ROOTBEER_CLASS_NAME, classLoader,
                "checkForRWPaths", new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        return false;
                    }
                });
    }

    /* Helpers */
    // Check for RootBeer Main class
    private boolean hasRootBeer(ClassLoader classLoader) {

        try {
            classLoader.loadClass(ROOTBEER_CLASS_NAME);
        } catch(ClassNotFoundException e) {
            return false;
        }
        return true;
    }

}
