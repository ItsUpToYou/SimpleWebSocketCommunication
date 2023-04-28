plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.glassfish.tyrus:tyrus-core:1.1")
    implementation("org.glassfish.tyrus:tyrus-client:1.1")
    implementation("org.glassfish.tyrus:tyrus-server:1.1")
    implementation("org.glassfish.tyrus:tyrus-container-grizzly:1.1")

}

tasks.test {
    useJUnitPlatform()
}