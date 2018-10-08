
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

// RNChromecastLibraryModule is where our implementation begins

public class RNChromecastLibraryModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNChromecastLibraryModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  // Specifies how we'll call this library
  @Override
  public String getName() {
    return "RNChromecastLibrary";
  }

  @ReactMethod  // indicates that this method can be used in React Native
  public void startScan() {
    final CastConfiguration options = getCastConfig();

    // allows tasks to run in the main thread
    UiThreadUtil.runOnUiThread(new Runnable() {
      VideoCastManager.initialize(getCurrentActivity(), options);

      mCastManager = VideoCastManager.getInstance();
      mCastConsumer = new VideoCastConsumerImpl() {};
      mCastManager.addVideoCastConsumer(mCastConsumer);
      Log.d(REACT_CLASS, "start scan Chromecast ");
    });
  }

  // Will not be exposed to react native project
  public CastConfiguration getCastConfig() {
    CastConfiguration options = new CastConfiguration.Builder(CastMediaControlIntent.DEFAULT_MEDIA_RECEIVER_APPLICATION_ID).enableAutoReconnect().enableNotification();
    return options;
  }

  @Override
  public void onCastAvailabilityChanged(boolean castPresent) {
    // WritableMap creates a data structure that can be read by the React Native project
    WritableMap deviceAvailableParams = Arguments.createMap();
    deviceAvailableParams.putBoolean("device_available", castPresent);
    emitMessageToRN(getReactApplicationContext(), "GoogleCast:DeviceAvailable", deviceAvailableParams);
  }

  // Sends data to React Native in a broadcast. There are 2 ways to send data (without running into race condition). emitters and promises.
  // Javascript and native sides work in async threads to gain a boost in performance. And native side is slower than Javascript, so, if you send data from one side to the other, you’ll run into a race condition.
  private void emitMessageToRN(ReactContext reactContext, String eventName, @Nullable WritableMap params) {
    reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, params);
  }
}