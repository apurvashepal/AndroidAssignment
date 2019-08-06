package com.example.cartapplication.UI.Product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cartapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mContext;
    private List<Product> productList;
    private IValueEntered valueEnteredListner;
    public ProductAdapter(Context context, List<Product> productList) {
        mContext = context;
        this.productList = productList;

        if (this.productList == null) {
            this.productList = new ArrayList<>();
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.grid_view_layout, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Product product= productList.get(position);
        if (holder instanceof ProductViewHolder){
            final ProductViewHolder productHolder=(ProductViewHolder)holder;
            productHolder.prodImage.setImageResource(product.getImage());
            productHolder.prodName.setText(product.getName());
            productHolder.prodPrice.setText(product.getPrice());
            productHolder.prodImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


public class ProductViewHolder extends RecyclerView.ViewHolder {
    ImageView prodImage;
    TextView prodName;
    TextView prodPrice;


    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        prodImage= itemView.findViewById(R.id.c_icon);
        prodName = itemView.findViewById(R.id.c_name);
        prodPrice = itemView.findViewById(R.id.c_price);

    }
}

    public void setValueEnteredListner(IValueEntered valueEnteredListner) {
       // this.valueEnteredListner = valueEnteredListner;
    }
}
