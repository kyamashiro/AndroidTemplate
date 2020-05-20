package com.example.mvvmtemplate.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(val userId: Int, val userName: String) : Parcelable