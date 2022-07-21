// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(CorePlugins.application) version (Versions.application) apply false
    id(CorePlugins.android_library) version (Versions.android_library) apply false
    id(CorePlugins.jetbrains) version (Versions.jetbrains) apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}