
# react-native-chromecast-library

## Getting started

`$ npm install react-native-chromecast-library --save`

### Mostly automatic installation

`$ react-native link react-native-chromecast-library`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-chromecast-library` and add `RNChromecastLibrary.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNChromecastLibrary.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNChromecastLibraryPackage;` to the imports at the top of the file
  - Add `new RNChromecastLibraryPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-chromecast-library'
  	project(':react-native-chromecast-library').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-chromecast-library/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-chromecast-library')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNChromecastLibrary.sln` in `node_modules/react-native-chromecast-library/windows/RNChromecastLibrary.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Chromecast.Library.RNChromecastLibrary;` to the usings at the top of the file
  - Add `new RNChromecastLibraryPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNChromecastLibrary from 'react-native-chromecast-library';

// TODO: What to do with the module?
RNChromecastLibrary;
```
  