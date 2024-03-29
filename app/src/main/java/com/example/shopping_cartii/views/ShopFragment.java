package com.example.shopping_cartii.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shopping_cartii.R;
import com.example.shopping_cartii.adapters.ShopListAdapter;
import com.example.shopping_cartii.models.Product;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShopFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShopFragment<shopListAdapter> extends Fragment implements ShopListAdapter ShopInterface{

    FragmentShopBinding fragmentShopBinding;
    private shopListAdapter shopListAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String inflater;
    private String getRoot;

    public ShopFragment () {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShopFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShopFragment newInstance ( String inflater, String param2 ) {
        ShopFragment fragment = new ShopFragment ();
        Bundle args = new Bundle ();
        args.putString ( ARG_PARAM1, inflater );
        args.putString ( ARG_PARAM2, fragment.getRoot );
        fragment.setArguments ( args );
        return fragment;
    }




    @Override
    public View onCreateView ( LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState ) {
        // Inflate the layout for this fragment
        fragmentShopBinding = FragmentShopBinding.inflater(inflater,container,false);
        return fragmentShopBinding.getRoot();
    }

    @Override
    public  void onViewCreated( @NonNull View view, @Nullable Bundle saveInstanceState ){
        super.onViewCreated ( view, saveInstanceState );

        shopListAdapter = new shopListAdapter ();
        fragmentShopBinding.shopRecyclerView.setAdapter(shopListAdapter);
    }
}