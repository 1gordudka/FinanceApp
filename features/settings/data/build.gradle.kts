plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    kotlin("kapt")
}

android {
    namespace = "com.finance.settings.data"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    // Modules
    implementation(project(Modules.featuresSettingsDomain))
    implementation(project(Modules.commonDatabase))

    // DataStore
    implementation(libs.datastore.preferences)
    
    // Security & Encryption
    implementation(libs.security.crypto)
    
    // WorkManager
    implementation(libs.work.manager)
    
    // Dagger
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
}