package com.example.client.data.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cookbook_table")
public class CookBook {

    /*
    todo skoða many to many rel við recipe
     */
    @PrimaryKey(autoGenerate = true)
    private int id;
    private long userOwnerId;
}
