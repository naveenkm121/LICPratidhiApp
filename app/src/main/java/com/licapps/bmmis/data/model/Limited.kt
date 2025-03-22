package com.licapps.bmmis.data.model

import androidx.room.ColumnInfo
import java.io.Serializable

class Limited(      @ColumnInfo(defaultValue = "false")
                    val isPTfixed: Boolean ,
                    @ColumnInfo(defaultValue = "false")
                    val isPPTfixed: Boolean ,
                    @ColumnInfo(defaultValue = "false")
                    val ptEQppt: Boolean ,
                    val pt: List<Int> ,
                    val ppt: List<Int> ,
                    val mode: List<Int>,
): Serializable
