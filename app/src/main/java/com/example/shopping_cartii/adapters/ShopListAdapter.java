package com.example.shopping_cartii.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping_cartii.models.Product;

 public class ShopListAdapter extends ListAdapter<Product.ShopViewHolder.ShopListAdapter> {


    public ShopListAdapter () {
        super ( Product.itemCallback );
    }

    public ShopViewHolder onCreateViewHolder ( @NonNull ViewGroup parent, int viewType ) {
        return null;
    }

     @Override
     public void onBindViewHolder ( @NonNull RecyclerView.ViewHolder holder, int position ) {

     }

     class ShopViewHolder extends RecyclerView.ViewHolder{

         public ShopViewHolder ( @NonNull View itemView ) {
             super ( itemView );
         }
     }


    public interface ShopInterface{
        void addIteam(Product product);
        void onIteamClick(Product product);
    }




}
