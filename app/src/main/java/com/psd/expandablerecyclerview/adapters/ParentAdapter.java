package com.psd.expandablerecyclerview.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.psd.expandablerecyclerview.R;
import com.psd.expandablerecyclerview.models.ExpandableChildListModel;
import com.psd.expandablerecyclerview.models.ParentListModel;

import java.util.ArrayList;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.MyViewHolder> {

    ArrayList<ParentListModel> arrayList;
    ArrayList<ExpandableChildListModel> childList = new ArrayList<>();
    Context context;
    boolean isExpandable;


    public ParentAdapter(ArrayList<ParentListModel> arrayList, Context context) {
        this.context = context;
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_parent_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentAdapter.MyViewHolder holder, int position) {


        holder.customerProductNo.setText(arrayList.get(position).getProductNumber());

        isExpandable = arrayList.get(position).isExpandable();

        if (isExpandable) {
            childList = arrayList.get(position).getChildList();
            holder.rv_child.setVisibility(View.VISIBLE);
            Log.d("isExpandable__", String.valueOf(childList.size()));
            ExpandableChildAdapter adapter = new ExpandableChildAdapter(childList, context);
            holder.rv_child.setAdapter(adapter);
        } else {
            holder.rv_child.setVisibility(View.GONE);
        }

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView customerProductNo;

        LinearLayout parent_LL;
        RecyclerView rv_child;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            parent_LL = itemView.findViewById(R.id.parent_LL);
            customerProductNo = itemView.findViewById(R.id.customerProductNo);
            rv_child = itemView.findViewById(R.id.rv_child);

            parent_LL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("isExpandab__", String.valueOf(isExpandable));
                    ParentListModel model = arrayList.get(getAdapterPosition());
                    model.setExpandable(!model.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
