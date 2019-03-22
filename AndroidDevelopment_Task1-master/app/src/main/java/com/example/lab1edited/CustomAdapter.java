package com.example.lab1edited;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<RowElement> rowElements;

    CustomAdapter (Context context, List<RowElement> rowElements) {
        this.rowElements = rowElements;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        RowElement element = rowElements.get(i);
        //viewHolder.imageView.setImageResource(element.getImage());
        viewHolder.numberView.setText(element.getNumber());
        String backColor = ((i + 1) % 2 == 0) ? "#CCCCCC" : "#FFFFFF";
        viewHolder.itemView.setBackgroundColor(Color.parseColor(backColor));
    }

    @Override
    public int getItemCount() {
        return rowElements.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //final ImageView imageView;
        final TextView numberView;

        ViewHolder(View view) {
            super(view);
            //imageView = (ImageView) view.findViewById(R.id.image);
            numberView = (TextView) view.findViewById(R.id.number);
        }
    }
}
