plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "com.mohab.weatherutils"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        targetSdk = 34

        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
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

            buildConfigField("String", "VERSION_NAME", "\"1.0.9\"")
        }
    }

    configurations.all {
        resolutionStrategy {
            force("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.10")
        }
    }

    publishing {
        singleVariant("release")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures.buildConfig = true
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = "com.mohab"
                artifactId = "weatherutils"
                version = "1.0.9"
                from(components["release"])
            }
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}