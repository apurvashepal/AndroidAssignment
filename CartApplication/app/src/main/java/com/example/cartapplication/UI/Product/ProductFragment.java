package com.example.cartapplication.UI.Product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cartapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ProductFragment extends Fragment implements IValueEntered {
    View mView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.activity_recyler_cart, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView mproductList = mView.findViewById(R.id.recyclerView);
        ProductAdapter productAdapter = new ProductAdapter(getActivity(), getProductList());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(),2);
        productAdapter.setValueEnteredListner(this);
        mproductList.setLayoutManager(gridLayoutManager);
        mproductList.setAdapter(productAdapter);

        productAdapter.notifyDataSetChanged();
    }





    private List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();
        Product product;

        product = new Product();
        product.setImage(R.drawable.star);
        product.setName("Star");
        product.setPrice(200);
        productList.add(product);

        product = new Product();
        product.setImage(R.drawable.star);
        product.setName("Star");
        product.setPrice(200);
        productList.add(product);

        return productList;
    }
    public void onTitleClicked(String name,int price) {


    }
}
