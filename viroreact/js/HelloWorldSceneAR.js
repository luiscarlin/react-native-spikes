'use strict';

import React, { Component } from 'react';
import proj4 from 'proj4'

import {StyleSheet} from 'react-native';

import {
  ViroARScene,
  ViroText,
  ViroConstants,
} from 'react-viro';

export default class HelloWorldSceneAR extends Component {

  constructor() {
    super();

    // Set initial state here
    this.state = {
      text : "Initializing AR..."
    };

    // bind 'this' to functions
    this._onInitialized = this._onInitialized.bind(this);

    const coordinates = [40.0099233, -83.1565916]

    this.position = proj4('EPSG:3857').forward(coordinates)
    console.log(this.position)

    this.position.push(-1)

  }

  render() {
    return (
      <ViroARScene onTrackingUpdated={this._onInitialized} >


        <ViroText text={this.position.toString()} scale={[.5, .5, .5]} position={this.position} style={styles.helloWorldTextStyle} />
      </ViroARScene>
    );
  }

  _onInitialized(state, reason) {
    if (state == ViroConstants.TRACKING_NORMAL) {
      this.setState({
        text : "Luis!"
      });
    } else if (state == ViroConstants.TRACKING_NONE) {
      // Handle loss of tracking
    }
  }
}

var styles = StyleSheet.create({
  helloWorldTextStyle: {
    fontFamily: 'Arial',
    fontSize: 30,
    color: '#ffffff',
    textAlignVertical: 'center',
    textAlign: 'center',
  },
});

module.exports = HelloWorldSceneAR;
