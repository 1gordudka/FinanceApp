plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    kotlin("kapt")
}

android {
    namespace = "com.finance.income.presentation"
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

    buildFeatures{
        compose = true
    }
}

dependencies {

    //Modules
    implementation(project(Modules.commonUi))
    implementation(project(Modules.commonNavigation))

    api(project(Modules.featuresIncomeData))
    api(project(Modules.featuresIncomeDomain))

    implementation(project(Modules.commonDomain))

    implementation(project(Modules.commonNetwork))

    // Compose
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.material3)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.tooling.preview)
    implementation(libs.compose.navigation)

    // Lifecycle
    implementation(libs.compose.activity)

    // Dagger
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    //Network
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.converter.gson)
}