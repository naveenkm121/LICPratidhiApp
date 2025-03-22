package com.licapps.bmmis.data.localdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.licapps.bmmis.data.model.prospectives.Prospective

@Dao
interface PlanDao {
    @Query("SELECT * FROM prospectives")
    fun getProspectivesList() : LiveData<List<Prospective>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllProspectives(prospectives: List<Prospective>)

    @Query("DELETE FROM prospectives")
    suspend fun deleteAllProspectives()




}