plugins {
    java
    checkstyle
    jacoco
    id("org.sonarqube") version "7.5.0.8588"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"


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

jacoco {
    toolVersion = "0.8.14"
}

sonar {
  properties {
    property("sonar.projectKey", "rendleks_java-project-78")
    property("sonar.organization", "rendleks")

    val buildDir = project.layout.buildDirectory.get().asFile
    property("sonar.coverage.jacoco.xmlReportPaths", "$buildDir/reports/jacoco/test/jacocoTestReport.xml")
  }
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)

    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}

tasks.named("sonar") {
    dependsOn(tasks.jacocoTestReport)
}