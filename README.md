#Build it bigger, a joke telling app
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
1. Weather information is acquired through openweathermap.org API. An account must be created on this site and an API Key must be requested.
2. A Google developer account is required along with the following actions:
  * A project must be created in your google developer [console] (https://console.developers.google.com)
  * Google Cloud Messaging API must be requested for this project
  * Configuration file "google-services.json" must be requested.  Follow instructions [here] (https://developers.google.com/cloud-messaging/android/client) to request file.

Installation
------------
1. Clone the GitHub repository
2. gradle.properties must exist in "Sunshine" and have this line of code, with your own API KEY in quotation marks

 ```MyOpenWeatherMapApiKey = "PUT_MY_API_KEY_HERE"```

3. Place "google-services.json" file in Sunshine/app directory.
4. Add "local.properties" file into the Sunshine base directory.  Add this line with the path to your Android sdk location:
 ```sdk.dir = "PUT_MY_PATH_TO_SDK_HERE"```

5. This project uses the Gradle build system.  To build this project, use the gradlew build" at command line or open project in Android Studio and build.  

Pre-requisites
--------------
* Android SDK 21 or Higher
* Build Tools version 23.0.2
* Android Support AppCompat 23.1.1
* Android Support Annotations 23.1.1
* Android Support GridLayout 23.1.1
* Android Support CardView 23.1.1
* Android Support Design 23.1.1
* Android Support RecyclerView 23.1.1
* Android Support Wearable 1.3.0
* Google Play Services GCM 8.3.0
* Google Play Services Wearable 8.3.0
* Muzei Muzei 2.0
* BumpTech Glide 3.5.2

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

