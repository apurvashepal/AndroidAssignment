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
    public static final String PTAG="Product";
    View mView;

    List<Product> productList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.activity_recycler_view, container, false);
        RecyclerView mproductList = mView.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        mproductList.setLayoutManager(gridLayoutManager);
        ProductAdapter productAdapter = new ProductAdapter(getActivity(), getProductList());
       // productAdapter.setValueEnteredListner(this);
        mproductList.setAdapter(productAdapter);

        productAdapter.notifyDataSetChanged();
        return mView;
    }

    private List<Product> getProductList() {
         productList = new ArrayList<>();
        Product product;

        product = new Product();
        product.setImage(R.raw.powerofyoursubconciousmind);
        product.setName("Power of your subconscious mind");
        int i=200;
        product.setPrice(i);
        productList.add(product);

        product = new Product();
        product.setImage(R.raw.everyonehasastory);
        product.setName("Everyone has a story");
        product.setPrice(150);
        productList.add(product);

        product = new Product();
        product.setImage(R.raw.harrypotter);
        product.setName("Harry potter");
        product.setPrice(1500);
        productList.add(product);

        product = new Product();
        product.setImage(R.raw.lifeiswhatyoumake);
        product.setName("Life is What You Make");
        product.setPrice(150);
        productList.add(product);

        product = new Product();
        product.setImage(R.raw.makingindiaawsome);
        product.setName("Making India Awesome");
        product.setPrice(150);
        productList.add(product);

        product = new Product();
        product.setImage(R.raw.stevejobs);
        product.setName("Steve Jobs");
        product.setPrice(150);
        productList.add(product);

        product = new Product();
        product.setImage(R.raw.thealchemist);
        product.setName("The Alchemist");
        product.setPrice(150);
        productList.add(product);

        product = new Product();
        product.setImage(R.raw.thegreatindiannovel);
        product.setName("The Great Indian Novel");
        product.setPrice(150);
        productList.add(product);

        product = new Product();
        product.setImage(R.raw.wingsoffire);
        product.setName("Wings of Fire");
        product.setPrice(150);
        productList.add(product);

        product = new Product();
        product.setImage(R.raw.wiseandotherwise);
        product.setName("Wise and Otherwise");
        product.setPrice(150);
        productList.add(product);

        return productList;
    }
    public void onTitleClicked(String name,int price) {


    }
}
