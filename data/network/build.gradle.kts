plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kapt)
}

//apply {
//    apply(from = "../jacoco.gradle")
//}

android {
    compileSdkVersion(AndroidSdk.compileSdkVersion)
    buildToolsVersion(AndroidSdk.buildVersionTool)

    defaultConfig {
        minSdkVersion(AndroidSdk.minSdkVersion)
        targetSdkVersion(AndroidSdk.targetSdkVersion)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArgument("clearPackageData", "true")
    }

    testOptions {
        animationsDisabled = true
        execution = "ANDROIDX_TEST_ORCHESTRATOR"
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
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

    sourceSets {
        map { it.java.srcDir("src/${it.name}/kotlin") }
    }
}

dependencies {

    implementation(Libraries.kotlinStandardLibrary)
    implementation(Libraries.ktxCore)

    implementation(Libraries.dagger)
    kapt(Libraries.daggerCompiler)

}
