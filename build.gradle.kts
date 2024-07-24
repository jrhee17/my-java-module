plugins {
    id("java")
    id("application")
}

group = "com.github.jrhee17"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.slf4j:slf4j-api:2.0.13")
    implementation("org.slf4j:slf4j-simple:2.0.13")

    implementation(platform("io.netty:netty-bom:4.1.112.Final"))
    implementation("io.netty:netty-common")
    implementation("io.netty:netty-transport")
    implementation("io.netty:netty-handler")
    implementation("io.netty:netty-resolver-dns")
    implementation("io.netty:netty-codec-http2")
    implementation("io.netty:netty-handler-proxy")

    implementation("org.reactivestreams:reactive-streams:1.0.4")
    implementation("com.fasterxml.jackson.core:jackson-core:2.17.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")
    implementation("io.micrometer:micrometer-core:1.13.2")

    implementation(files("armeria-shaded-1.30.0-SNAPSHOT.jar"))
}

application {
    mainModule = "my.java.module.main"
    mainClass = "com.github.jrhee17.Main"
}

tasks.test {
    useJUnitPlatform()
}