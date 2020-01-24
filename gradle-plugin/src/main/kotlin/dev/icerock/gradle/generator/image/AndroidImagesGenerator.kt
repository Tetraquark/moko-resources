/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.gradle.generator.image

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.KModifier
import org.gradle.api.file.FileTree
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import java.io.File

class AndroidImagesGenerator(
    sourceSet: KotlinSourceSet,
    inputFileTree: FileTree,
    private val androidRClassPackage: String
) : ImagesGenerator(
    sourceSet = sourceSet,
    inputFileTree = inputFileTree
) {
    override fun getClassModifiers(): Array<KModifier> = arrayOf(KModifier.ACTUAL)

    override fun getPropertyModifiers(): Array<KModifier> = arrayOf(KModifier.ACTUAL)

    override fun getPropertyInitializer(key: String): CodeBlock? {
        return CodeBlock.of("ImageResource(R.drawable.%L)", key)
    }

    override fun getImports(): List<ClassName> = listOf(
        ClassName(androidRClassPackage, "R")
    )

    override fun generateResources(
        resourcesGenerationDir: File,
        keyFileMap: Map<String, List<File>>
    ) {
        keyFileMap.flatMap { (key, files) ->
            files.map { key to it }
        }.forEach { (key, file) ->
            val scale = file.nameWithoutExtension.substringAfter("@").substringBefore("x")
            val drawableDirName = "drawable-" + when (scale) {
                "0.75" -> "ldpi"
                "1" -> "mdpi"
                "1.5" -> "hdpi"
                "2" -> "xhdpi"
                "3" -> "xxhdpi"
                "4" -> "xxxhdpi"
                else -> {
                    println("ignore $file - unknown scale ($scale)")
                    return@forEach
                }
            }

            val drawableDir = File(resourcesGenerationDir, drawableDirName)
            file.copyTo(File(drawableDir, "$key.${file.extension}"))
        }
    }
}
