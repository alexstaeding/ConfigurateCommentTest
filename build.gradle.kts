import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.4.32"
  application
}

repositories {
  mavenCentral()
  maven("https://repo.spongepowered.org/repository/maven-public/")
}

dependencies {
  implementation(kotlin("stdlib"))
  val configurateVersion = "4.0.0"
  implementation("org.spongepowered:configurate-hocon:$configurateVersion")
  implementation("org.spongepowered:configurate-extra-kotlin:$configurateVersion")
}

application {
  mainClass.set("org.example.ObjectMappingTestKt")
}

tasks {
  tasks {
    withType<KotlinCompile> {
      kotlinOptions.jvmTarget = "1.8"
    }
    withType<JavaCompile> {
      options.encoding = "UTF-8"
      sourceCompatibility = "1.8"
      targetCompatibility = "1.8"
    }
  }
}
