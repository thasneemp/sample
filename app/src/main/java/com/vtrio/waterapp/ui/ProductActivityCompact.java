package com.vtrio.waterapp.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.vtrio.waterapp.R;
import com.vtrio.waterapp.adapters.RecyclerViewAdapter;
import com.vtrio.waterapp.data.ProductItems;
import com.vtrio.waterapp.databinding.ActivityProductBinding;
import com.vtrio.waterapp.utils.HelveticaNeueFontHelper;

import java.util.ArrayList;

public class ProductActivityCompact extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<ProductItems> productItemsArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityProductBinding activityProductBinding = DataBindingUtil.setContentView(this, R.layout.activity_product);

        setSupportActionBar(activityProductBinding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        HelveticaNeueFontHelper.applyHelveticaneuelightFont(this, activityProductBinding.toolbarTextView);
        activityProductBinding.setToolBarTitle(getResources().getString(R.string.select_product));
        activityProductBinding.toolbarTextView.setTextSize(getResources().getDimension(R.dimen.dim_72_pt));
        HelveticaNeueFontHelper.applyHelveticaneuemedFont(this, activityProductBinding.productContentLayout.totalLabelTextView);
        activityProductBinding.productContentLayout.totalLabelTextView.setTextSize(getResources().getDimension(R.dimen.dim_72_pt));
        activityProductBinding.productContentLayout.setTotalAmountLabel(getResources().getString(R.string.Total));
        activityProductBinding.productContentLayout.totalTextView.setTextSize((getResources().getDimension(R.dimen.dim_72_pt)));
        HelveticaNeueFontHelper.applyHelveticaneuemedFont(this, activityProductBinding.productContentLayout.totalTextView);
        activityProductBinding.productContentLayout.addcartButton.setTypeface(HelveticaNeueFontHelper.getHelveticaneuelightTypeface(this));
        activityProductBinding.productContentLayout.addcartButton.setTextSize(getResources().getDimension(R.dimen.dim_40_pt));
        activityProductBinding.productContentLayout.setAddcartLabel(getResources().getString(R.string.ADD_CART));
        activityProductBinding.productContentLayout.checkoutButton.setTypeface(HelveticaNeueFontHelper.getHelveticaneuelightTypeface(this));
        activityProductBinding.productContentLayout.checkoutButton.setTextSize(getResources().getDimension(R.dimen.dim_40_pt));
        activityProductBinding.productContentLayout.setCheckOutLabel(getResources().getString(R.string.CHECKOUT));
        activityProductBinding.productContentLayout.productRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        activityProductBinding.productContentLayout.productRecyclerView.setAdapter(new RecyclerViewAdapter(getProductItems()));

    }

    private ArrayList<ProductItems> getProductItems() {
        for (int i = 0; i < 10; i++) {

            ProductItems productItems = new ProductItems("WaterCan", "50", R.drawable.watercan, "description here", 0);
            productItemsArrayList.add(productItems);
        }
        return productItemsArrayList;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.checkoutButton:
                Intent checkOutIntent = new Intent(this, CheckOutActivity.class);
                startActivity(checkOutIntent);
                break;
        }

    }
}
