plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.vanniktech.maven.publish") version "0.31.0"
}

android {
    namespace = "io.github.itsivag"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
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

    buildFeatures {
        compose = true
    }

    mavenPublishing {
        coordinates(
            groupId = "io.github.itsivag", artifactId = "neopop-compose", version = "0.0.1"
        )

        pom {
            name.set("NeoPop Compose")
            description.set("An UI library based on Cred's Neopop UI Framework. Made With Compose, Made for Compose.")
            inceptionYear.set("2025")
            url.set("https://github.com/itsivag/neopop-compose")

            licenses {
                license {
                    name.set("Apache License 2.0")
                    url.set("https://github.com/itsivag/neopop-compose/blob/main/LICENSE")
                }
            }

            developers {
                developer {
                    id.set("itsivag")
                    name.set("Siva G")
                    email.set("sivacbrf2@gmail.com")
                }
            }

            scm {
                url.set("https://github.com/itsivag/neopop-compose")
            }
        }
    }
}


dependencies {

    implementation("androidx.core:core-ktx:1.16.0")
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    val composeBom = platform("androidx.compose:compose-bom:2025.02.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)
    implementation("androidx.compose.material3:material3")
    // Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

}
