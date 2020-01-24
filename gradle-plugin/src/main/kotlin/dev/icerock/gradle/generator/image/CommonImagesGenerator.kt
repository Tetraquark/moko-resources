/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.gradle.generator.image

import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.KModifier
import org.gradle.api.file.FileTree
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

class CommonImagesGenerator(
    sourceSet: KotlinSourceSet,
    inputFileTree: FileTree
) : ImagesGenerator(
    sourceSet = sourceSet,
    inputFileTree = inputFileTree
) {
    override fun getClassModifiers(): Array<KModifier> = emptyArray()

    override fun getPropertyModifiers(): Array<KModifier> = emptyArray()

    override fun getPropertyInitializer(key: String): CodeBlock? = null
}
