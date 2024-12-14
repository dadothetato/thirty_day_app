package com.example.thirtydaysapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PushUp(
    @StringRes val typeRes: Int,
    @DrawableRes val imageRes: Int
)