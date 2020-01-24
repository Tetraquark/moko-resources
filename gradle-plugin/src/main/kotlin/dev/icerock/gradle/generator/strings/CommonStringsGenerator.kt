/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.gradle.generator.strings

import com.squareup.kotlinpoet.CodeBlock
import org.gradle.api.file.FileTree
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

class CommonStringsGenerator(
    sourceSet: KotlinSourceSet,
    stringsFileTree: FileTree
) : StringsGenerator(
    sourceSet = sourceSet,
    stringsFileTree = stringsFileTree
) {
    override fun getPropertyInitializer(key: String): CodeBlock? = null
}
