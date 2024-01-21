package buildSrc.main.java.base.gradle

object Dependencies {
	object Plugins{
		const val androidPlugin = "com.android.tools.build:gradle:${Versions.Android.androidPlugin}"
		const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin.kotlin}"
		const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.Dagger.hiltPluginVersion}"
	}

	object Android {
		const val appCompat = "androidx.appcompat:appcompat:${Versions.Android.appcompat}"
		const val fragment = "androidx.fragment:fragment-ktx:1.5.7"
		const val material = "com.google.android.material:material:${Versions.Android.material}"
		const val activity = "androidx.activity:activity-ktx:1.7.2"
		const val recyclerView = "androidx.recyclerview:recyclerview:1.3.1"
		const val viewPager2 = "androidx.viewpager2:viewpager2:1.0.0"
		const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.Android.constraintLayout}"
		const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
		const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.Android.navigation}"
		const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.Android.navigation}"
		const val biometric = "androidx.biometric:biometric:1.1.0"
	}

	object Kotlin {
		const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.Kotlin.kotlin}"
		const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.Kotlin.kotlin}"
		const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.kotlinCoroutines}"
		const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.kotlinCoroutines}"
	}

	object Ktx {
		private const val archLifecycle = "androidx.lifecycle:lifecycle"
		const val coreKtx = "androidx.core:core-ktx:${Versions.Ktx.coreKtx}"
		const val viewModel = "$archLifecycle-viewmodel-ktx:${Versions.Ktx.lifeCycleKtx}"
		const val liveData = "$archLifecycle-livedata-ktx:${Versions.Ktx.lifeCycleKtx}"
		const val savedState = "$archLifecycle-viewmodel-savedstate:${Versions.Ktx.lifeCycleKtx}"
		const val process = "$archLifecycle-process:${Versions.Ktx.lifeCycleKtx}"
	}

	object WebServices {
		private const val okHttpBase = "com.squareup.okhttp3"
		const val okHttpBom = "$okHttpBase:okhttp-bom:${Versions.WebServices.okHttp}"
		const val okHttp = "$okHttpBase:okhttp"
		const val okHttpLogging = "$okHttpBase:logging-interceptor"
		const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.WebServices.retrofit}"
		const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.WebServices.retrofit}"
		const val gson = "com.google.code.gson:gson:${Versions.WebServices.gson}"
	}

	object Adjust {
		const val adjust = "com.adjust.sdk:adjust-android:${Versions.Adjust.adjust}"
		const val adjustOaid = "com.adjust.sdk:adjust-android-oaid:4.33.5"
		const val installReferrer = "com.android.installreferrer:installreferrer:2.2"
		const val xiaomiReferrer = "com.adjust.sdk:adjust-android-xiaomi-referrer:4.33.5"
		const val xiaomiInstallReferrer = "com.miui.referrer:homereferrer:1.0.0.6"
		const val samsungReferrer = "com.adjust.sdk:adjust-android-samsung-referrer:4.33.5"
		const val samsungInstallReferrer = "store.galaxy.samsung.installreferrer:samsung_galaxystore_install_referrer:3.0.1"
	}

	object PlayService {
		const val playServices = "com.google.gms:google-services:${Versions.PlayServices.playServices}"
		const val playReview = "com.google.android.play:review-ktx:${Versions.PlayServices.playReview}"
		const val playMap = "com.google.android.gms:play-services-maps:${Versions.PlayServices.playMap}"
		const val playLocation = "com.google.android.gms:play-services-location:${Versions.PlayServices.playLocation}"
		const val playAdsIdentifier = "com.google.android.gms:play-services-ads-identifier:${Versions.PlayServices.playAdsIdentifier}"
		const val playServicesAppSet = "com.google.android.gms:play-services-appset:${Versions.PlayServices.playServicesAppSet}"
		const val playAuth = "com.google.android.gms:play-services-auth:${Versions.PlayServices.gmsAuth}"
		const val playAuthPhone = "com.google.android.gms:play-services-auth-api-phone:${Versions.PlayServices.gmsAuthPhone}"
		const val barcodeScanning = "com.google.mlkit:barcode-scanning:${Versions.PlayServices.barcodeScanning}"
	}

	object Dagger {
		const val hilt = "com.google.dagger:hilt-android:${Versions.Dagger.hiltVersion}"
		const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.Dagger.hiltVersion}"
	}

	object Navigation {
		const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.Navigation.navigationFragment}"
		const val navigationUi = "androidx.navigation:navigation-ui:${Versions.Navigation.navigationUi}"
	}

	object Firebase {
		private const val fireBase = "com.google.firebase:firebase"
		const val crashlyticsGradlePlugin = "$fireBase-crashlytics-gradle:${Versions.PlayServices.crashlyticsGradlePlugin}"
		const val bom = "$fireBase-bom:${Versions.PlayServices.firebaseBom}"
		const val messaging = "$fireBase-messaging-ktx"
		const val crashlytics = "$fireBase-crashlytics-ktx"
		const val analytics = "$fireBase-analytics-ktx"
		const val database = "$fireBase-database-ktx"
		const val firestore = "$fireBase-firestore-ktx"
	}

	object Test {
		const val junit = "org.junit.jupiter:junit-jupiter:5.9.1"
		const val extJunit = "androidx.test.ext:junit:1.1.5"
		const val espresso = "androidx.test.espresso:espresso-core:3.5.1"
		const val mockk = "io.mockk:mockk:1.4.1"
		const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"
		const val junit4 = "junit:junit:${Versions.Test.junit4}"
		const val coreArchTesting = "androidx.arch.core:core-testing:${Versions.Test.archTesting}"
	}

	object DebugTools {
		const val timber = "com.jakewharton.timber:timber:${Versions.DebugTools.timber}"
		const val chucker = "com.github.chuckerteam.chucker:library:${Versions.DebugTools.chucker}"
	}

	object Image {
		const val glide = "com.github.bumptech.glide:glide:${Versions.ThirdPartLibrary.glide}"
	}
	object Coil {
		const val coil = "io.coil-kt:coil:${Versions.ThirdPartLibrary.coil}"
		const val gif = "io.coil-kt:coil-gif:${Versions.ThirdPartLibrary.coil}"
		const val svg = "io.coil-kt:coil-svg:${Versions.ThirdPartLibrary.coil}"
	}
}
