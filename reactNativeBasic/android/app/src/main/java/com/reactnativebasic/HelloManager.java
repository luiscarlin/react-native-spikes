package com.reactnativebasic;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class HelloManager extends ReactContextBaseJavaModule {
    public HelloManager(ReactApplicationContext reactContext) {
        super(reactContext);
    }


    // registers the native module with the react navite bridge
    @Override
    public String getName() {
        return "HelloManager";
    }

    // this method will be exposed in react native to be used in JS
    // it takes a callback
    @ReactMethod
    public void greetUser(String name, Promise promise) {
        System.out.println("User name: " + name);

        String greeting = "Welcome " + name;
        promise.resolve(greeting);
    }
}
