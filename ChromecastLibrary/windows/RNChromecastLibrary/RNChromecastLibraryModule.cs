using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Chromecast.Library.RNChromecastLibrary
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNChromecastLibraryModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNChromecastLibraryModule"/>.
        /// </summary>
        internal RNChromecastLibraryModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNChromecastLibrary";
            }
        }
    }
}
