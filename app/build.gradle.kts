plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")

}

android {
    namespace = "com.licapps.bmmis"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.licapps.bmmis"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            /* // Enables code shrinking, obfuscation, and optimization for only
             // your project's release build type.
             minifyEnabled true// Enables resource shrinking, which is performed by the
             // Android Gradle plugin.
             shrinkResources true// Includes the default ProGuard rules files that are packaged with
             // the Android Gradle plugin. To learn more, go to the section about
             // R8 configuration files.
             proguardFiles getDefaultProguardFile(
                     'proguard-android.txt'),
                     'proguard-rules.pro'*/
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
   /* dataBinding {
        android.buildFeatures.dataBinding = true
    }*/
}

dependencies {

    implementation("androidx.annotation:annotation:1.6.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.3.0")



    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("com.google.firebase:firebase-messaging:23.4.1")

    // navigation
    val nav_version = "2.7.6"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    // retrofit
    val retrofit_version = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation( "com.squareup.retrofit2:converter-gson:$retrofit_version")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

    // hilt
    implementation ("com.google.dagger:hilt-android:2.48")
    kapt ("com.google.dagger:hilt-compiler:2.48")

    //gson
    implementation("com.google.code.gson:gson:2.10.1")
    //Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")
    //  Palette
    implementation ("androidx.palette:palette-ktx:1.0.0")

    // Timber (Logging)
    implementation("com.jakewharton.timber:timber:5.0.1")

    // Lottie (Animations)
    implementation("com.airbnb.android:lottie:6.6.4")

    // Shimmer (UI loading effect)
    implementation("com.facebook.shimmer:shimmer:0.5.0")

    // Room
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    kapt("androidx.room:room-compiler:$room_version")

    // Kotlin Coroutines
    val coroutines_android_version = "1.7.3"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_android_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_android_version")


    //Paging3
    var paging_version = "3.1.1"
    implementation ("androidx.paging:paging-runtime:$paging_version")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}