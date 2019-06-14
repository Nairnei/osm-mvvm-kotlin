package com.nanx.osm_kotlin_mvvm.model


import com.google.gson.annotations.SerializedName

data class Details(
    @SerializedName("addresstags")
    val addresstags: Addresstags?,
    @SerializedName("admin_level")
    val adminLevel: String?,
    @SerializedName("calculated_importance")
    val calculatedImportance: Double?,
    @SerializedName("calculated_postcode")
    val calculatedPostcode: String?,
    @SerializedName("calculated_wikipedia")
    val calculatedWikipedia: String?,
    @SerializedName("category")
    val category: String?,
    @SerializedName("centroid")
    val centroid: Centroid?,
    @SerializedName("country_code")
    val countryCode: String?,
    @SerializedName("extratags")
    val extratags: Extratags?,
    @SerializedName("geometry")
    val geometry: Geometry?,
    @SerializedName("housenumber")
    val housenumber: Any?,
    @SerializedName("importance")
    val importance: Double?,
    @SerializedName("indexed_date")
    val indexedDate: String?,
    @SerializedName("isarea")
    val isarea: Boolean?,
    @SerializedName("localname")
    val localname: String?,
    @SerializedName("names")
    val names: Names?,
    @SerializedName("osm_id")
    val osmId: Int?,
    @SerializedName("osm_type")
    val osmType: String?,
    @SerializedName("parent_place_id")
    val parentPlaceId: Int?,
    @SerializedName("place_id")
    val placeId: Int?,
    @SerializedName("rank_address")
    val rankAddress: Int?,
    @SerializedName("rank_search")
    val rankSearch: Int?,
    @SerializedName("type")
    val type: String?
) {
    data class Geometry(
        @SerializedName("coordinates")
        val coordinates: List<Double?>?,
        @SerializedName("type")
        val type: String?
    )

    data class Addresstags(
        @SerializedName("postcode")
        val postcode: String?
    )

    data class Centroid(
        @SerializedName("coordinates")
        val coordinates: List<Double?>?,
        @SerializedName("type")
        val type: String?
    )

    data class Names(
        @SerializedName("name")
        val name: String?,
        @SerializedName("name:be")
        val nameBe: String?,
        @SerializedName("name:de")
        val nameDe: String?,
        @SerializedName("name:es")
        val nameEs: String?,
        @SerializedName("name:he")
        val nameHe: String?,
        @SerializedName("name:ko")
        val nameKo: String?,
        @SerializedName("name:la")
        val nameLa: String?,
        @SerializedName("name:ru")
        val nameRu: String?,
        @SerializedName("name:uk")
        val nameUk: String?,
        @SerializedName("name:zh")
        val nameZh: String?
    )

    data class Extratags(
        @SerializedName("wikidata")
        val wikidata: String?,
        @SerializedName("wikipedia")
        val wikipedia: String?
    )
}