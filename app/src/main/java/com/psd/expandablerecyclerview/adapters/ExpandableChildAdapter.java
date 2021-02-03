package com.psd.expandablerecyclerview.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.psd.expandablerecyclerview.R;
import com.psd.expandablerecyclerview.models.ExpandableChildListModel;

import java.util.ArrayList;

public class ExpandableChildAdapter extends RecyclerView.Adapter<ExpandableChildAdapter.MyViewHolder> {

    ArrayList<ExpandableChildListModel> arrayList;
    Context context;


    public ExpandableChildAdapter(ArrayList<ExpandableChildListModel> arrayList, Context context) {
        this.context = context;
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_expandable_child_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ExpandableChildListModel model = arrayList.get(position);
        Log.d("ExpandableChil_", String.valueOf(arrayList.size()));
        holder.customerProductmodelno.setText(arrayList.get(position).getSku());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout myPrditemClicked;
        TextView customerProductNo, customerProductName, customerProductnameMobno, customerProductmodelno, customerProductDealerAddress;
        LinearLayout parent_LL;
        ImageView customerProductImage;
        RecyclerView MyProductFilterAdapter_value;
        LinearLayout LL_MyProductFilterAdapter_value;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            parent_LL = itemView.findViewById(R.id.parent_LL);
            myPrditemClicked = itemView.findViewById(R.id.myPrditemClicked);
            customerProductImage = itemView.findViewById(R.id.customerProductImage);
            customerProductNo = itemView.findViewById(R.id.customerProductNo);
            customerProductName = itemView.findViewById(R.id.customerProductName);
            customerProductmodelno = itemView.findViewById(R.id.customerProductmodelno);
            customerProductDealerAddress = itemView.findViewById(R.id.customerProductDealerAddress);
            MyProductFilterAdapter_value = itemView.findViewById(R.id.MyProductFilterAdapter_value);
            LL_MyProductFilterAdapter_value = itemView.findViewById(R.id.LL_MyProductFilterAdapter_value);

        }
    }
}
