

object Version {
   const val ktx = "1.8.0"

    ///compose
    const val activityCompose = "1.5.1"
    const val bom = "2023.05.01"
    const val composeVersion = "1.4.3"
    const val material3 = "1.1.0"

    ///lifecycle
    const val runtimeKtx = "2.3.1"
    const val runtimeCompose = "2.6.0-beta01"

    ///view model
    const val lifecycleVersion = "2.6.1"
    const val archVersion = "2.2.0"

    ///nav component
    const val nav = "2.5.3"

    ///test
    const val junit = "4.13.2"
    const val extJunit = "1.1.5"
    const val espresso = "3.5.1"

    //dagger-hilt
    const val hiltAndroid = "2.44"

    //coil
    const val coil = "2.4.0"
}

object Deps {
    const val core = "androidx.core:core-ktx:${Version.ktx}"
}

object Compose {
    const val activityCompose = "androidx.activity:activity-compose:${Version.activityCompose}"
    const val bom = "androidx.compose:compose-bom:${Version.bom}"
    const val ui = "androidx.compose.ui:ui:${Version.composeVersion}"
    const val graphics = "androidx.compose.ui:ui-graphics:${Version.composeVersion}"
    const val preview = "androidx.compose.ui:ui-tooling-preview"
    const val material3 = "androidx.compose.material3:material3:${Version.material3}"
    const val tooling = "androidx.compose.ui:ui-tooling"
    const val manifest = "androidx.compose.ui:ui-test-manifest"
    const val coil = "io.coil-kt:coil-compose:${Version.coil}"
}

object Lifecycle {
    const val compose = "androidx.lifecycle:lifecycle-runtime-compose:${Version.runtimeCompose}"
    const val liveData = "androidx.compose.runtime:runtime-livedata:1.4.2"
}

object ViewModel {
    const val lifeCycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$${Version.lifecycleVersion}"
    const val composeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.lifecycleVersion}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$${Version.lifecycleVersion}"
    const val composeLiveData = "androidx.lifecycle:lifecycle-runtime-compose:${Version.lifecycleVersion}"
}


object Nav {
    const val navGraph = "androidx.navigation:navigation-compose:${Version.nav}"
}

object TestImpl {
    const val junit = "junit:junit:${Version.junit}"
}

object AndroidTest {
    const val extJunit = "androidx.test.ext:junit:${Version.extJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
}

object AndroidTestCompose {
    const val junit4 = "androidx.compose.ui:ui-test-junit4"
}

object DaggerHilt {
    const val androidHilt = "com.google.dagger:hilt-android:${Version.hiltAndroid}"
    const val compiler = "com.google.dagger:hilt-compiler:${Version.hiltAndroid}"
}