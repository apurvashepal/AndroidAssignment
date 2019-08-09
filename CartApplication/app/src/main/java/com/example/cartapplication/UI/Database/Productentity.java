package com.example.cartapplication.UI.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ProductEntity")
public class Productentity {
    @PrimaryKey
    private int BookId;
    @ColumnInfo(name = "image")
    private int image;
    @ColumnInfo(name ="Name")
    private String Name;
    @ColumnInfo(name = "Price")
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }
}
