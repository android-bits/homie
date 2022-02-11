plugins {
    id(BuildPlugins.javaLibrary)
    id(BuildPlugins.kotlinLibrary)
    id(BuildPlugins.kapt)
}

//apply {
//    apply(from = "../jacoco.gradle")
//}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(Libraries.coroutines)

    testImplementation(TestLibraries.mockitoKotlin)
    testImplementation(TestLibraries.mockito)
    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.coroutineTest)
}