package com.example.cartapplication.UI.Database;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import com.example.cartapplication.UI.Application.MyApplication;
import com.example.cartapplication.UI.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private ProductDao productDao;


    ProductRepository(Context context) {
    }

    public ProductRepository(MyApplication myApplication) {
        ProductDatabase db;
        db = ProductDatabase.getDatabase(myApplication);
        productDao = db.productDao();
    }

    final Productentity productentity = new Productentity();

    public void insertTask(final Product product) {

        productentity.setBookId(product.getId());
        productentity.setName(product.getName());
        productentity.setImage(productentity.getImage());
        productentity.setPrice(product.getPrice());
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                productDao.insertProduct(productentity);
                return null;
            }
        }.execute();
    }

    public void updateTask(Product product) {

        productentity.setBookId(product.getId());
        productentity.setPrice(product.getPrice());
        productentity.setImage(product.getImage());
        productentity.setName(product.getName());

    }
    public  List<Productentity> getAll(){
       final List<Productentity>  allProducts;
        new AsyncTask<Void, Void, List<Productentity>>() {

            @Override
            protected List<Productentity> doInBackground(Void... voids) {
               return  productDao.getAll();
            }
        }.execute();
        allProducts = productDao.getAll();
        return  allProducts;
   }

}


