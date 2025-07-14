plugins {
    kotlin("jvm") version "2.1.20"
}

group = "org.jetbrains.lincheck.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.jetbrains.lincheck:lincheck:3.1")
}

sourceSets {
    test {
        kotlin.srcDir("src")
    }
}

tasks.test {
    useJUnitPlatform()
    jvmArgs("-XX:+EnableDynamicAgentLoading") // optional, to avoid warnings
}
