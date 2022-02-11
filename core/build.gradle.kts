plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kapt)
}

android {
    compileSdkVersion(AndroidSdk.compileSdkVersion)
    buildToolsVersion(AndroidSdk.buildVersionTool)

    defaultConfig {
        compileSdkVersion(AndroidSdk.compileSdkVersion)
        buildToolsVersion(AndroidSdk.buildVersionTool)

        defaultConfig {
            minSdkVersion(AndroidSdk.minSdkVersion)
            targetSdkVersion(AndroidSdk.targetSdkVersion)

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    testOptions {
        animationsDisabled = true
        unitTests.apply {
            isReturnDefaultValues = true
            isIncludeAndroidResources = true
        }
    }

    buildTypes {
        getByName("debug") {
            isTestCoverageEnabled = false
        }

        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }
}

dependencies {
    api(Libraries.ktxCore)

    api(Libraries.timber)
    api(Libraries.coroutines)
}
