package com.example.cartapplication.UI.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cartapplication.R;
import com.example.cartapplication.UI.Adapter.ShopAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartFragment extends Fragment {
    public static final String PTAG = "Shoppingcart";
    private List<Product> productList;
    private List<Cart> cartlist= new ArrayList<>();
    Map<Product, Integer> mapProduct = new HashMap<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mShoppingView = inflater.inflate(R.layout.activity_recycler_view, container, false);
       initView(mShoppingView);
        return mShoppingView;
    }

    private void initView(View mShoppingView) {

        //check if list is null then return
         productFound(productList);

        // getCartItems(productsList) -> Map<Products, Integer>
         createHashmap(productList);
        // getCartItems() -> List<CartItems> -> Map loop

         cartlist = getCartItems();
        //Recycleriew CartItems ShoppingAdapter

        RecyclerView mShopcartList = mShoppingView.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mShopcartList.setLayoutManager(linearLayoutManager);

        ShopAdapter shopAdapter = new ShopAdapter(getActivity(), cartlist );

        mShopcartList.setAdapter(shopAdapter);

        shopAdapter.notifyDataSetChanged();

    }

    private void productFound(List<Product> productList) {
        if(productList == null)
            productList= new ArrayList<>();
        else
            this.productList= productList;
    }

    private List<Cart> getCartItems(){
        for(Map.Entry<Product,Integer> productIntegerMap : mapProduct.entrySet()){
            Cart cart = new Cart();
            cart.setProduct(productIntegerMap.getKey());
            cart.setQuantity(productIntegerMap.getValue());
            cartlist.add(cart);
        }
        return cartlist;
}


    private void createHashmap(List<Product> product) {
        for (Product presentProd : productList) {
            if (mapProduct.containsKey(presentProd)) {
                mapProduct.put(presentProd, mapProduct.get(presentProd) + 1);
            } else
                mapProduct.put(presentProd, 1);
        }
    }
/*
    private boolean itemPresent(Product prod) {

        for (Map.Entry<Product, Integer> presentProd : mapProduct.entrySet()) {
            if (presentProd.getKey().getName().equals(prod.getName())) {
                return true;
            }
        }
        return false;
    }
    private int getQuantity(Product product) {
        for(Product prod:cartList) {
            if (itemPresent(product)) {

                mapProduct.put(prod, mapProduct.get(product) + 1);
            } else
                mapProduct.put(prod, 1);
        }

        return mapProduct.get(product);
    }*/

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}