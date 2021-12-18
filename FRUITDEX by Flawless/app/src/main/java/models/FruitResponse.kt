package models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FruitResponse(
    @SerializedName("results")
    val fruits : List<Fruit>

) : Parcelable {
    constructor() : this(mutableListOf())
}