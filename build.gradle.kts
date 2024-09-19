plugins {
    id("java")
}

group = "itzkiller"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("net.minestom:minestom-snapshots:d0754f2a15")
}

tasks.test {
    useJUnitPlatform()
}