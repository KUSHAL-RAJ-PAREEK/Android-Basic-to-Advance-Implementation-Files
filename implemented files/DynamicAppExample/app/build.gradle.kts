import org.jetbrains.kotlin.ir.backend.js.compile

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    namespace = "com.krp.dynamicappexample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.krp.dynamicappexample"
        minSdk = 24

        //noinspection EditedTargetSdkVersion
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
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {
    implementation ("com.whatshername.android:jackson-android-networking:1.0.2")
    implementation ("androidx.work:work-runtime-ktx:2.8.1")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.10")
    implementation ("com.whatshername.android:android-networking:1.0.2")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}