/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    `kotlin-dsl`
    `maven-publish`
}

repositories {
    mavenLocal()

    jcenter()
    google()
}

dependencies {
    implementation(Deps.Libs.Jvm.kotlinPoet)
    compileOnly(Deps.Plugins.kotlin)
    compileOnly(Deps.Plugins.android)
    implementation(Deps.Libs.Jvm.apacheCommonsText)
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

publishing {
    repositories.maven("https://api.bintray.com/maven/icerockdev/plugins/moko-resources-generator/;publish=1") {
        name = "bintray"

        credentials {
            username = System.getProperty("BINTRAY_USER")
            password = System.getProperty("BINTRAY_KEY")
        }
    }

    publications {
        register("plugin", MavenPublication::class) {
            groupId = "dev.icerock.moko"
            artifactId = "resources-generator"
            version = Versions.Libs.MultiPlatform.mokoResources

            from(components["java"])
        }
    }
}
