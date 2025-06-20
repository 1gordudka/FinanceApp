pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Finance App"
include(":app")
include(":common:navigation")
include(":common:ui")
include(":features:income:presentation")
include(":features:income:data")
include(":features:income:domain")
include(":features:outcome:presentation")
include(":features:outcome:data")
include(":features:outcome:domain")
include(":features:brief:presentation")
include(":features:brief:data")
include(":features:brief:domain")
include(":features:articles:presentation")
include(":features:articles:data")
include(":features:articles:domain")
include(":features:settings:presentation")
include(":features:settings:data")
include(":features:settings:domain")
include(":common:domain")
include(":common:network")
