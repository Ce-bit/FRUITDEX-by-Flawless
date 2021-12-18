package models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Fruit(
    @SerializedName("name")
    val name : String ?,

    @SerializedName("genus")
    val genus : String?,

    @SerializedName("family")
    val family : String?,

    @SerializedName("calories")
    val nutrition : String?

) : Parcelable{
    constructor() : this("", "", "", "")
}