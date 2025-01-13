plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

java {
    // Set the Java version for source compatibility
    sourceCompatibility = JavaVersion.VERSION_17
    // Apply a specific Java toolchain to ease working on different environments.
    toolchain {
        languageVersion = JavaLanguageVersion.of(17) // Java 17 を指定
    }
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // Example dependency (you can remove if not used)
    implementation("com.google.guava:guava:32.1.2-jre")
}

application {
    // Define the main class for the application.
    mainClass.set("jp.ac.uryukyu.ie.e245737.Main")
}

tasks.jar {
    // Set the manifest attributes for the JAR file
    manifest {
        attributes(
            "Main-Class" to "jp.ac.uryukyu.ie.e245737.Main" // 完全修飾クラス名を指定
        )
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
