package dof.aoc.util

import org.example.Main
import org.jetbrains.annotations.NotNull
import java.io.File
import java.util.*

class AoCReader {
    companion object {
        @JvmStatic @NotNull fun readFileAsStream(@NotNull filename: String) =
            Objects.requireNonNull(Main::class.java.classLoader.getResource(filename)).openStream()!!

        @JvmStatic @NotNull fun readFileByLines(@NotNull filename: String) =
            File(ClassLoader.getSystemResource(filename).file).readLines()

        @JvmStatic @NotNull fun checkReader(@NotNull checkInput: String) = checkInput.split("\n");

        @JvmStatic @NotNull fun readFileAsText(@NotNull filename: String) =
            File(ClassLoader.getSystemResource(filename).file).readText()
    }
}

