pluginManagement {
    plugins {
        kotlin("jvm") version "2.0.0"
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "scaler_1"
include("_01_intermediate_dsa")
include("_02_advanced_dsa")
include("_03_maths")
include("_04_oops")
include("_05_hashing")
include("_06_language_advance_concepts")
include("_07_sorting")
include("_08_searching")
include("_09_backtracking")
include("_10_two_pointers")
include("_11_linked_lists")
include("_12_stacks")
include("_13_queues")
include("_14_trees")
include("_15_heaps")
include("_17_greedy")
include("_18_dynamic_programming")
include("_19_graphs")
include("_20_leetcode")
include("_21_databases_and_sql")
