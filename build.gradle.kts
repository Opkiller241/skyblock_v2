plugins {
    id("java")
    id("com.gradleup.shadow") version "8.3.0"
}

group = "itzkiller"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.minestom:minestom-snapshots:d0754f2a15")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(22)) // Minestom has a minimum Java version of 21
    }
}

tasks {
    jar{
        manifest{
            attributes["Main-Class"] = "itzkiller.Main"
        }
    }

    build{
        dependsOn(shadowJar)
    }
    shadowJar {
        mergeServiceFiles()
        archiveClassifier.set("")
    }
}