plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kapt)
}

// apply {
//    apply(from = "../jacoco.gradle")
// }

android {
    compileSdk = AndroidSdk.compileSdkVersion
    buildToolsVersion = AndroidSdk.buildVersionTool

    defaultConfig {
        minSdk = AndroidSdk.minSdkVersion
        targetSdk = AndroidSdk.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments["clearPackageData"] = "true"
    }

    testOptions {
        animationsDisabled = true
        execution = "ANDROIDX_TEST_ORCHESTRATOR"
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
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

    sourceSets {
        map { it.java.srcDir("src/${it.name}/kotlin") }
    }
}

dependencies {
    implementation(Libraries.ktxCore)

    implementation(Libraries.roomKtx)
    kapt(Libraries.roomCompiler)
    api(Libraries.roomRuntime)

    implementation(Libraries.dagger)
    kapt(Libraries.daggerCompiler)
}