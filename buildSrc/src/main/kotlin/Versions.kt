package buildSrc.main.java.base.gradle

object Versions {
	object Sdk {
		internal const val min = 21
		internal const val target = 34
		internal const val compile = 34
	}

	object Config {
		internal const val code = 1
		internal const val major = 1
		internal const val minor = 0
		internal const val patch = 0
	}

	object Android {
		internal const val androidPlugin = "7.4.2"
		internal const val appcompat = "1.6.1"
		internal const val material = "1.9.0"
		internal const val constraintLayout = "2.1.4"
		internal const val navigation = "2.4.0"
		internal const val camera = "1.2.3"
	}

	object Kotlin {
		internal const val kotlin = "1.8.22"
		internal const val kotlinCoroutines = "1.7.3"
	}

	object Ktx {
		internal const val coreKtx = "1.10.1"
		internal const val lifeCycleKtx = "2.6.1"
	}

	object PlayServices {
		internal const val playServices = "4.3.15"
		internal const val playMap = "18.1.0"
		internal const val playLocation = "21.0.1"
		internal const val gmsAuth = "20.7.0"
		internal const val gmsAuthPhone = "18.0.1"
		internal const val firebaseBom = "32.3.1"
		internal const val barcodeScanning = "17.2.0"
		internal const val crashlyticsGradlePlugin = "2.9.9"
		internal const val playReview = "2.0.1"
		internal const val playAdsIdentifier = "18.0.1"
		internal const val playServicesAppSet = "16.0.2"
	}

	object WebServices {
		internal const val okHttp = "4.11.0"
		internal const val gson = "2.10.1"
		internal const val retrofit = "2.9.0"
	}

	object Dagger {
		internal const val hiltPluginVersion = "2.44"
		internal const val hiltVersion = "2.44"
	}
	object Navigation {
		internal const val navigationFragment = "2.5.3"
		internal const val navigationUi = "2.5.3"
	}

	object ThirdPartLibrary {
		internal const val coil = "2.4.0"
		internal const val glide = "4.14.2"
	}

	object Test {
		internal const val junit4 = "4.12"
		internal const val archTesting = "2.2.0"
	}

	object Adjust {
		internal const val adjust = "4.33.5"
	}

	object DebugTools {
		internal const val timber = "5.0.1"
		internal const val chucker = "4.0.0"
	}
}
