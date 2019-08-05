package com.example.androidtraining.Application.UI.RecyclerView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtraining.Application.UI.Activity.Item;
import com.example.androidtraining.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.androidtraining.Application.UI.Fragment.LoginFragment.TAG;

public class ItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int HEADER_VIEW = 1001;
    private static final int CARD_VIEW = 1002;

    private Context mContext;
    private List<Item> itemsList;
    private IValueEntered valueEnteredListner;

    public ItemsAdapter(Context context, List<Item> itemsList) {
        mContext = context;
        this.itemsList = itemsList;

        if (this.itemsList == null) {
            this.itemsList = new ArrayList<>();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == CARD_VIEW) {
            view = LayoutInflater.from(mContext).inflate(R.layout.card_layout, parent, false);
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.card_layout, parent, false);
        }

        return new ItemsViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADER_VIEW;
        } else {
            return CARD_VIEW;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        final Item item = itemsList.get(position);

        if(holder instanceof ItemsViewHolder) {
            final ItemsViewHolder itemHolder = (ItemsViewHolder) holder;
            itemHolder.itemTitle.setText(item.getName());
            itemHolder.itemTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String Text = itemHolder.data.getText().toString();
                    if (valueEnteredListner != null) {
                        valueEnteredListner.onTitleClicked(Text);
                    }
                }
            });
            itemHolder.itemInformation.setText(item.getInformation());
            itemHolder.itemImage.setImageResource(item.getImage());

        }

        if (holder instanceof HeaderViewHolder) {
            // TODO :: bind header Item fields
        }
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemTitle;
        TextView itemInformation;

        EditText data;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.c_icon);
            itemTitle = itemView.findViewById(R.id.c_name);
            itemInformation = itemView.findViewById(R.id.c_information);
            data = itemView.findViewById(R.id.c_data);

        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public void setValueEnteredListner(IValueEntered valueEnteredListner) {
        this.valueEnteredListner = valueEnteredListner;
    }
}
