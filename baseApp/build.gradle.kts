
plugins {
    id(BaseCorePlugins.library)
    id(BaseCorePlugins.jetbrains)

}

android {

    compileSdk = 31
    defaultConfig {
        minSdk = BaseConfigData.minSdkVersion
        targetSdk = BaseConfigData.targetSdkVersion
        testInstrumentationRunner = BaseConfigData.testInstrumentationRunner
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
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    api(BaseCoreLibs.core)
    api(BaseCoreLibs.appcompat)
    api(BaseCoreLibs.material)
    api(BaseCoreLibs.constraintlayout)
    api(BaseCoreLibs.legacy)
    api(BaseCoreLibs.multidex)
    api(BaseTestLibs.junit)
    api(BaseTestLibs.jUnitTest)
    api(BaseTestLibs.espresso)

    api(BaseMvvmLibs.coroutines)
    api(BaseMvvmLibs.livedata)
    api(BaseMvvmLibs.viewmodel)

    api(BaseMvvmLibs.navigation_fragment)
    api(BaseMvvmLibs.navigation_ui)

    api(BaseMvvmLibs.datastore)

    api(BaseRetrofit.gson)
    api(BaseRetrofit.logging_interceptor)
    api(BaseRetrofit.retrofit)
    api(BaseRetrofit.converter_gson)


    api(BaseUtilLibs.glide)
    api(BaseUtilLibs.image_compressor)
    api(BaseUtilLibs.lottie)
    api(BaseDynamicSize.sdp)
    api(BaseDynamicSize.ssp)


}