plugins {
    java
    `maven-publish`
    id("fabric-loom") version "1.9-SNAPSHOT"
}

version = project.extra["mod_version"] as String
group = project.extra["maven_group"] as String

base {
    archivesName.set(project.extra["archives_base_name"] as String)
}

repositories {
    // Cloth Config для конфигурации мода
    maven {
        name = "Shedaniel"
        url = uri("https://maven.shedaniel.me/")
    }
    // Mod Menu
    maven {
        name = "TerraformersMC"
        url = uri("https://maven.terraformersmc.com/releases/")
    }
}

dependencies {
    // Minecraft
    minecraft("com.mojang:minecraft:${project.extra["minecraft_version"]}")
    mappings("net.fabricmc:yarn:${project.extra["yarn_mappings"]}:v2")
    
    // Fabric
    modImplementation("net.fabricmc:fabric-loader:${project.extra["loader_version"]}")
    modImplementation("net.fabricmc.fabric-api:fabric-api:${project.extra["fabric_version"]}")
    
    // Cloth Config (для настроек мода)
    modApi("me.shedaniel.cloth:cloth-config-fabric:${project.extra["cloth_config_version"]}") {
        exclude(group = "net.fabricmc.fabric-api")
    }
    
    // Mod Menu (опционально, для интеграции настроек)
    modImplementation("com.terraformersmc:modmenu:${project.extra["mod_menu_version"]}")
}

processResources {
    inputs.property("version", project.version)
    
    filesMatching("fabric.mod.json") {
        expand(
            "version" to project.version,
            "minecraft_version" to project.extra["minecraft_version"],
            "loader_version" to project.extra["loader_version"]
        )
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(21)
}

java {
    // Minecraft 1.21.1 требует Java 21
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
    
    withSourcesJar()
}

tasks.jar {
    from("LICENSE") {
        rename { "${it}_${project.base.archivesName.get()}" }
    }
}

// Публикация (опционально)
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
    
    repositories {
        // Добавьте ваш maven репозиторий здесь
    }
}
