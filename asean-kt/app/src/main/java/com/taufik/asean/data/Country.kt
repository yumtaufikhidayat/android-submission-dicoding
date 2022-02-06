package com.taufik.asean.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
    var countryName: String = "",
    var countryInternationalName: String = "",
    var countryFlag: String = "",
    var countryDescription: String = "",
    var countryHeadGovernment: String = "",
    var countryCapital: String = "",
    var countryIndependenceDay: String = "",
    var countryLanguage: String = "",
    var countryCurrency: String = "",
    var countryLandArea: String = ""
): Parcelable