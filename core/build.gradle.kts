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
            isDebuggable = true
            isTestCoverageEnabled = false
        }

        getByName("release") {
            isMinifyEnabled = true
            isUseProguard = true
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

    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }
}

dependencies {
    api(Libraries.kotlinStandardLibrary)
    api(Libraries.ktxCore)

    api(Libraries.timber)
    api(Libraries.coroutines)
}
