package com.nanx.osm_kotlin_mvvm.model


import com.google.gson.annotations.SerializedName
data class Search(
    @SerializedName("features")
    val features: List<Feature?>?,
    @SerializedName("licence")
    val licence: String?,
    @SerializedName("type")
    val type: String?
) {
    data class Feature(
        @SerializedName("bbox")
        val bbox: List<Double?>?,
        @SerializedName("geometry")
        val geometry: Geometry?,
        @SerializedName("properties")
        val properties: Properties?,
        @SerializedName("type")
        val type: String?
    ) {
        data class Geometry(
            @SerializedName("coordinates")
            val coordinates: List<Double?>?,
            @SerializedName("type")
            val type: String?
        )

        data class Properties(
            @SerializedName("category")
            val category: String?,
            @SerializedName("display_name")
            val displayName: String?,
            @SerializedName("importance")
            val importance: Double?,
            @SerializedName("osm_id")
            val osmId: String?,
            @SerializedName("osm_type")
            val osmType: String?,
            @SerializedName("place_id")
            val placeId: String?,
            @SerializedName("place_rank")
            val placeRank: String?,
            @SerializedName("type")
            val type: String?
        )
    }
}