package com.jetbrains.kmm.shared

import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.log.LogLevel
import io.realm.objects

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}


fun initialize(databaseFile: String? = null) {
    val realmConfig = RealmConfiguration.Builder()
        .schema(ingredients::class)
        .path(databaseFile)
        .log(LogLevel.ALL)
        .build()
    val realm = Realm.open(realmConfig)

    val results = realm.objects<ingredients>().query()
    println("Realm ingredients returned $results")
    results.forEach {
        println("Realm object -> ${it.name}")
    }
}

class ingredients : RealmObject {
    var name: String = ""
    @PrimaryKey
    var id: Int = 0
    var amount: Float? = null
    var unit: Int? = null
    var notes: String? = null
}