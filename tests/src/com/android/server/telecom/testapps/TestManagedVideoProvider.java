/*
 * Copyright (C) 2014 The Android Open Source Project
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

package com.android.server.telecom.testapps;

import android.telecom.CameraCapabilities;
import android.telecom.Connection;
import android.telecom.RemoteConnection;
import android.telecom.VideoProfile;
import android.view.Surface;

public class TestManagedVideoProvider extends Connection.VideoProvider {

    private final RemoteConnection.VideoProvider.Listener mRemoteListener =
            new RemoteConnection.VideoProvider.Listener() {
        @Override
        public void onReceiveSessionModifyRequest(RemoteConnection.VideoProvider rvp,
                VideoProfile videoProfile) {
            super.onReceiveSessionModifyRequest(rvp, videoProfile);
        }

        @Override
        public void onReceiveSessionModifyResponse(RemoteConnection.VideoProvider rvp,
        int status,
        VideoProfile requestedProfile, VideoProfile responseProfile) {
            super.onReceiveSessionModifyResponse(rvp, status, requestedProfile,
                    responseProfile);
        }

        @Override
        public void onHandleCallSessionEvent(RemoteConnection.VideoProvider rvp, int event) {
            super.onHandleCallSessionEvent(rvp, event);
        }

        @Override
        public void onPeerDimensionsChanged(RemoteConnection.VideoProvider rvp, int width,
        int height) {
            super.onPeerDimensionsChanged(rvp, width, height);
        }

        @Override
        public void onCallDataUsageChanged(RemoteConnection.VideoProvider rvp, int dataUsage) {
            super.onCallDataUsageChanged(rvp, dataUsage);
        }

        @Override
        public void onCameraCapabilitiesChanged(RemoteConnection.VideoProvider rvp,
                CameraCapabilities cameraCapabilities) {
            super.onCameraCapabilitiesChanged(rvp, cameraCapabilities);
        }
    };

    private final RemoteConnection.VideoProvider mRemoteVideoProvider;

    public TestManagedVideoProvider(RemoteConnection.VideoProvider remoteVideoProvider) {
        mRemoteVideoProvider = remoteVideoProvider;
        mRemoteVideoProvider.addListener(mRemoteListener);
    }

    @Override
    public void onSetCamera(String cameraId) {
        mRemoteVideoProvider.setCamera(cameraId);
    }

    @Override
    public void onSetPreviewSurface(Surface surface) {
        mRemoteVideoProvider.setPreviewSurface(surface);
    }

    @Override
    public void onSetDisplaySurface(Surface surface) {
        mRemoteVideoProvider.setDisplaySurface(surface);
    }

    @Override
    public void onSetDeviceOrientation(int rotation) {
        mRemoteVideoProvider.setDeviceOrientation(rotation);
    }

    @Override
    public void onSetZoom(float value) {
        mRemoteVideoProvider.setZoom(value);
    }

    @Override
    public void onSendSessionModifyRequest(VideoProfile requestProfile) {
        mRemoteVideoProvider.sendSessionModifyRequest(requestProfile);
    }

    @Override
    public void onSendSessionModifyResponse(VideoProfile responseProfile) {
        mRemoteVideoProvider.sendSessionModifyResponse(responseProfile);
    }

    @Override
    public void onRequestCameraCapabilities() {
        mRemoteVideoProvider.requestCameraCapabilities();
    }

    @Override
    public void onRequestConnectionDataUsage() {
        mRemoteVideoProvider.requestCallDataUsage();
    }

    @Override
    public void onSetPauseImage(String uri) {
        mRemoteVideoProvider.setPauseImage(uri);
    }
}
