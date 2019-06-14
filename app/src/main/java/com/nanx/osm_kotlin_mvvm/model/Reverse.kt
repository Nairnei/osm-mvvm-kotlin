package com.nanx.osm_kotlin_mvvm.model


import com.google.gson.annotations.SerializedName

data class Reverse(
    @SerializedName("address")
    val address: Address?,
    @SerializedName("addresstype")
    val addresstype: String?,
    @SerializedName("boundingbox")
    val boundingbox: List<String?>?,
    @SerializedName("category")
    val category: String?,
    @SerializedName("display_name")
    val displayName: String?,
    @SerializedName("importance")
    val importance: String?,
    @SerializedName("lat")
    val lat: String?,
    @SerializedName("licence")
    val licence: String?,
    @SerializedName("lon")
    val lon: String?,
    @SerializedName("name")
    val name: String?,
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
) {
    data class Address(
        @SerializedName("country")
        val country: String?,
        @SerializedName("country_code")
        val countryCode: String?,
        @SerializedName("postcode")
        val postcode: String?,
        @SerializedName("road")
        val road: String?,
        @SerializedName("state")
        val state: String?,
        @SerializedName("state_district")
        val stateDistrict: String?,
        @SerializedName("village")
        val village: String?
    )
}