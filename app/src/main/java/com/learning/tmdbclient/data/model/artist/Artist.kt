package com.learning.tmdbclient.data.model.artist


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_artists")
               /*if we keep this in this way , room com.learning.tmdbclient.data base table name will be same as the com.learning.tmdbclient.data class name, Table name
                will be artist but actually providing the table name for com.learning.tmdbclient.data base table is the best practice
               */
data class Artist(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")             // we can also create out own choice name of table column using @ColumnInfo annotation
    val name: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String?
)