package com.krp.adswithmeson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme3
import androidx.compose.material3.Surface3
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.krp.adswithmeson.ui.theme.MesonAppTheme
import com.meson.sdk.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            MesonSdk.setLogLevel(BaseMesonInit.LogLevel.DEBUG)

        // Set your configuration with your application context and APP ID.
        val mesonSdkConfiguration =
            MesonSdkConfiguration.Builder(this, "your_meson_app_id").build()

        // Init SDK
        MesonSdk.initialize(mesonSdkConfiguration, object : MesonSdkInitializationListener {
            override fun onComplete(error: Error?) {
                if (error == null) {
                    // Initialization successful
                    val interstitialAd =
                        MesonInterstitial(this@MainActivity, "your_interstitial_ad_unit_id")
                    interstitialAd.load()

                    if (MesonSdk.isSDKInitialized()) {
                        interstitialAd.setAdListener(object : MesonInterstitialAdListener() {
                            override fun onAdLoadSucceeded(ad: MesonInterstitial) {
                                interstitialAd.show()
                            }

                            // Implement other ad listener methods as needed
                        })
                    }
                } else {
                    // Initialization failed, check the error message
                }
            }
        })

        setContent {
            MesonAppTheme {
                // A surface container using the 'background' color from the theme
                Surface3(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme3.colorScheme.background
                ) {
                    Greeting("Hello Meson")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MesonAppTheme {
        Greeting("Hello Meson")
    }
}
