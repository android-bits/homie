plugins {
    id(BuildPlugins.javaLibrary)
    id(BuildPlugins.kotlinLibrary)
    id(BuildPlugins.kapt)
}

//apply {
//    apply(from = "../jacoco.gradle")
//}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(Libraries.kotlinStandardLibrary)
    implementation(Libraries.coroutines)

    implementation(Libraries.dagger)
    kapt(Libraries.daggerCompiler)

    testImplementation(TestLibraries.mockitoKotlin)
    testImplementation(TestLibraries.mockito)
    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.coroutineTest)
}