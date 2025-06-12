plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    kotlin("kapt")
}

android {
    namespace = Config.namespace
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }

    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    // Modules
    implementation(project(Modules.commonUi))
    implementation(project(Modules.commonNavigation))

    implementation(project(Modules.featuresIncomeData))
    implementation(project(Modules.featuresIncomePresentation))
    implementation(project(Modules.featuresIncomeDomain))

    implementation(project(Modules.featuresOutcomeData))
    implementation(project(Modules.featuresOutcomePresentation))
    implementation(project(Modules.featuresOutcomeDomain))

    implementation(project(Modules.featuresBreefData))
    implementation(project(Modules.featuresBreefPresentation))
    implementation(project(Modules.featuresBreefDomain))

    implementation(project(Modules.featuresArticlesData))
    implementation(project(Modules.featuresArticlesPresentation))
    implementation(project(Modules.featuresArticlesDomain))

    implementation(project(Modules.featuresSettingsData))
    implementation(project(Modules.featuresSettingsPresentation))
    implementation(project(Modules.featuresSettingsDomain))

    // Lifecycle
    implementation(libs.lifecycle.core)
    implementation(libs.lifecycle.runtime)
    implementation(libs.compose.activity)

    // Compose
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.material3)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.tooling.preview)
    implementation(libs.compose.navigation)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.android.junit)
    androidTestImplementation(libs.espresso)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.compose.junit)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.test.manifest)

    // Dagger
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
}

kapt{
    correctErrorTypes = true
}