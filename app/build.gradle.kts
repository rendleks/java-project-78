plugins {
    application
    checkstyle
    jacoco
    id("org.sonarqube") version "7.3.0.8198"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application { mainClass.set("hexlet.code.Validator") }

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.assertj:assertj-core:3.27.7")
}

checkstyle {
    toolVersion = "10.12.0"
}

tasks.test {
    useJUnitPlatform()
}