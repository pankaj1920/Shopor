plugins {
    id(CorePlugins.application)
    id(CorePlugins.jetbrains)
    id(CorePlugins.kotlin_kapt)

}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = ConfigData.appId
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = ConfigData.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    api(CoreLibs.core)
    api(CoreLibs.appcompat)
    api(CoreLibs.material)
    api(CoreLibs.constraintlayout)
    api(CoreLibs.multidex)
    implementation(BaseCoreLibs.legacy)
    api(TestLibs.junit)
    api(TestLibs.jUnitTest)
    api(TestLibs.espresso)

    api(Library.indicator)
    implementation(Library.mPAndroidChart)
    // Including BaseApp
    api(project(path = Secrets.BaseApp))


}