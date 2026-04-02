package io.orazzu.android_course.data.caching

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) = db.execSQL(
        """
        alter table app_details 
        add column isInWishlist integer not null default 0
        """,
    )
}
