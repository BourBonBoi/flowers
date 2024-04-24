package com.example.flowers2;
import android.graphics.Bitmap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class Flower {

    private int productId;
    private String name;
    private String category;
    private String instructions;
    private double price;
    private String photo;
    private Bitmap bitmap;

    private String description;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public String toString() {
        return name;
    }
}
interface FlowersAPI {
    @GET("feeds/flowers.json")
    Call<List<Flower>> getData();

    @GET("feeds/flower/{id}.json") // Предполагается что у вас есть эндпоинт для получения описания по ID
    Call<Flower> getFlower(@Path("id") int id);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://services.hanselandpetal.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}