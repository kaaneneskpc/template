package buildSrc.main.java.base.gradle

object Config {
    const val namespace = "com.example.baseapplication"
    const val applicationId = "com.example.baseapplication"
    const val minSdk = 24
    const val targetSdk = 33
    const val compileSdk = 33
    const val versionCode = 1
    private const val major = "1"
    private const val minor = "0"
    private const val patch = "0"
    const val versionName = "$major.$minor.$patch"

    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}