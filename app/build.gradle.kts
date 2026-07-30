plugins {
    application
    checkstyle
    jacoco
    id("org.sonarqube") version "7.3.1.8318"
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

sonar {
  properties {
    property("sonar.projectKey", "rendleks_java-project-78")
    property("sonar.organization", "rendleks")
  }
}


checkstyle {
    toolVersion = "10.12.0"
}

tasks.test {
    useJUnitPlatform()
}
