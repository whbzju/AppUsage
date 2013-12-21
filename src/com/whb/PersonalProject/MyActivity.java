package com.whb.PersonalProject;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MyActivity extends Activity {

    String TAG = "AppUsage";
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        testInstalledAppList();

    }

    public void testInstalledAppList()
    {
        final PackageManager pm = getPackageManager();
//get a list of installed apps.
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        for (ApplicationInfo packageInfo : packages) {
            Log.d(TAG, "Installed package :" + packageInfo.packageName);
            Log.d(TAG, "Launch Activity :" + pm.getLaunchIntentForPackage(packageInfo.packageName));

            if (packageInfo.packageName.equalsIgnoreCase("com.amazon.kindle"))
            {
                Log.d(TAG, "Lauch ca");
                //Intent myIntent = new Intent(pm.getLaunchIntentForPackage(packageInfo.packageName));
                startActivity(pm.getLaunchIntentForPackage(packageInfo.packageName));
            }
        }

    }
}
