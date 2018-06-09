package com.vtrio.waterapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.vtrio.waterapp.data.ProductItems;
import com.vtrio.waterapp.databinding.ProductItemBinding;
import com.vtrio.waterapp.listeners.QuantityHandler;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemRecyclerViewHolder> {

    private ArrayList<ProductItems> products;

    public RecyclerViewAdapter(ArrayList<ProductItems> productItems) {
        this.products = productItems;
    }

    @NonNull
    @Override
    public ItemRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        ProductItemBinding itemBinding = ProductItemBinding.inflate(inflater, parent, false);

        return new ItemRecyclerViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRecyclerViewHolder holder, int position) {
        holder.bind(products.get(position));

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    protected class ItemRecyclerViewHolder extends RecyclerView.ViewHolder {

        private ProductItemBinding itemBinding;

        public ItemRecyclerViewHolder(final ProductItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
            itemBinding.getRoot().setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ProductItems productItems = ItemRecyclerViewHolder.this.itemBinding.getProductItems();

                    productItems.setDescriptionVisibility(ItemRecyclerViewHolder.this.itemBinding.productDescriptionTextView.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                    return false;
                }
            });
            itemBinding.setHandler(new QuantityHandler() {
                @Override
                public void onQuantityIncrement() {
                    ProductItems productItems = ItemRecyclerViewHolder.this.itemBinding.getProductItems();
                    productItems.setProductItemQty(productItems.getProductItemQty() + 1);
                }

                @Override
                public void onQuantityDecrement() {
                    ProductItems productItems = ItemRecyclerViewHolder.this.itemBinding.getProductItems();
                    productItems.setProductItemQty(productItems.getProductItemQty() - 1);
                }
            });
        }

        public void bind(ProductItems productItems) {
            itemBinding.setProductItems(productItems);
            itemBinding.executePendingBindings();
        }
    }
}
