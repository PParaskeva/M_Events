package com.example.panagiotis.m_events;

/**
 * Created by Panagiotis on 21/12/2016.
 */

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.multidex.MultiDex;
import android.util.Base64;
import android.util.Log;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.flurry.android.FlurryAgent;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import io.realm.Realm;

public class MyApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);

    }

    // Updated your class body:
    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize the SDK before executing any other operations,
        FacebookSdk.sdkInitialize(getApplicationContext());
        FlurryAgent.init(getApplicationContext(),"QSKPD6C7CFC32RJX2SZP");
        AppEventsLogger.activateApp(this);


        Realm.init(this);
        //printHash();
    }

    public void printHash(){
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.example.panagiotis.m_events",
                    PackageManager.GET_SIGNATURES);
            for(Signature signature: info.signatures){
                MessageDigest md= MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                System.out.println("*************************************************");
                Log.d("KeyHash", Base64.encodeToString(md.digest(),Base64.DEFAULT));
                System.out.println("*************************************************");

            }

        }catch (PackageManager.NameNotFoundException e){

        } catch (NoSuchAlgorithmException e){

        }
    }
}