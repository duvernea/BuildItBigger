#Build it bigger: A joke telling app
## Project 4 of the Udacity Android Developer Nanodegree

This app tells jokes. While the Android app itself is fairly simple, it implements many complex concepts, including:
* Free and paid versions. 
* A Java library providing jokes and a Google Cloud Endpoints server to supply these jokes, and 
* An Android library containing an activity for displaying jokes 
* Google Admob banner and interstitial ads in the free variant
* Unit tests for testing basic funtions
* Configuring gradle task to start server, run tests, shutdown server

Gradle is used heavily to accomplish these tasks.

Getting Started
-------------
This app can either be run using a local development server or one that's been deployed on the web. This sample Google github project and instructions [here] (https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints) are useful in explaining how to deploy this live to Google App Engine.

Installation
------------
1. Clone the GitHub repository
2. Add "local.properties" file into the BuiltItBigger base directory.  Add this line with the path to your Android sdk location:

 ```sdk.dir = "PUT_MY_PATH_TO_SDK_HERE"```

3. This project uses the Gradle build system. To build the backend and start the local development server , use the "gradlew appengineRun" at the command line or open project in Android Studio and build.
4. To verify the local development server is running successfully, navigate to [http://localhost:8080](http://localhost:8080) in a browser.
5. To build the app, use the "gradlew build" at command line or open project in Android Studio and build.

Pre-requisites
--------------
##### App
* Android SDK 11 or Higher
* Build Tools version 23.0.1
* Android Support AppCompat 23.0.1
* Android Support Annotations 23.1.1
* Android Support Multidex 1.0.0
* Findbugs jsr305:2.0.1
* Google Play Services Ads 8.4.0
* Backend, Joke Display Activity Library

###### Testing
* Android Testing Suport 0.4.1
* Android Testing Support Espresso 2.2.1

##### Backend
* Google App Engine SDK 1.9.30
* Google App Engine Endpoints 1.9.30
* Google App Engine Endpoints Deps 1.9.30
* Javax Servlet API 2.5

#####Joke Display Activity Library
* JUnit 4.12
* Android Support AppCompat 23.0.1
* Android Support Design 23.0.1
* Android Support CardView 23.0.1

License
-------
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.

