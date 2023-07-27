package com.erif.toastyledemo.helper;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.erif.toastyledemo.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> list = new ArrayList<>();
    private final Callback callback;

    public AdapterRecyclerView(Callback callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ListHolder(
                inflater.inflate(R.layout.item_list, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder getHolder, int position) {
        if (getHolder instanceof ListHolder holder) {
            holder.txtTitle.setText(list.get(position));
            holder.parent.setOnClickListener(view -> {
                if (callback != null) {
                    callback.onItemClick(list.get(position));
                }
            });
            if (position == 0) {
                holder.line.setVisibility(View.GONE);
            } else {
                holder.line.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    private static class ListHolder extends RecyclerView.ViewHolder {

        private final RelativeLayout parent;
        private final TextView txtTitle;
        private final View line;

        public ListHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.item_list_parent);
            txtTitle = itemView.findViewById(R.id.item_list_txtTitle);
            line = itemView.findViewById(R.id.item_list_line);
        }
    }

    public interface Callback {
        void onItemClick(String message);
    }

}
