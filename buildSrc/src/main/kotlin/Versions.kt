/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

object Versions {
    object Android {
        const val compileSdk = 28
        const val targetSdk = 28
        const val minSdk = 16
    }

    const val kotlin = "1.3.61"

    private const val mokoResources = "0.6.2"

    object Plugins {
        const val android = "3.5.2"

        const val kotlin = Versions.kotlin
        const val mokoResources = Versions.mokoResources
    }

    object Libs {
        object Android {
            const val appCompat = "1.1.0"
        }

        object MultiPlatform {
            const val mokoResources = Versions.mokoResources
        }

        object Jvm {
            const val apacheCommonsText = "1.3"
            const val kotlinPoet = "1.3.0"
        }
    }
}