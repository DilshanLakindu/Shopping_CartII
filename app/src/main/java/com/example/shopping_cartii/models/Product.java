package com.example.shopping_cartii.models;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class Product {
    private String id;
    private String name;
    private double price;
    private boolean isAvailable;
    private String imageUrl;

      Product ( String id, String name, double price, boolean isAvailable, String imageUrl ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
        this.imageUrl = imageUrl;
    }

    public String getId () {
        return id;
    }

    public void setId ( String id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public double getPrice () {
        return price;
    }

    public void setPrice ( double price ) {
        this.price = price;
    }

    public boolean isAvailable () {
        return isAvailable;
    }

    public void setAvailable ( boolean available ) {
        isAvailable = available;
    }

    public String getImageUrl () {
        return imageUrl;
    }

    public void setImageUrl ( String imageUrl ) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString () {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Product product = (Product) o;
        return Double.compare ( product.getPrice (), getPrice () ) == 0 &&
                isAvailable () == product.isAvailable () &&
                getId ().equals ( product.getId () ) &&
                getName ().equals ( product.getName () ) &&
                getImageUrl ().equals ( product.getImageUrl () );
    }

    @Override
    public int hashCode () {
        return Objects.hash ( getId (), getName (), getPrice (), isAvailable (), getImageUrl () );
    }

    public static DiffUtil.ItemCallback<Product> itemCallback= new DiffUtil.ItemCallback<Product> () {
        @Override
        public boolean areItemsTheSame ( @NonNull Product oldItem, @NonNull Product newItem ) {
            return oldItem.getId ().equals (newItem.getId ());
        }



        @Override
        public boolean areContentsTheSame ( @NonNull Product oldItem, @NonNull Product newItem ) {
            return oldItem.equals (newItem );
        }
    };
}
