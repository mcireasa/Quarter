package com.mcireasa.quizzapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mcireasa.quizzapp.Model.Event;

import java.util.Collections;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private List<Event> eventList;

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView text;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.tv_eventrow);
            parentLayout = itemView.findViewById(R.id.parent_layout_eventnewsfeed);
        }
    }

    public RecycleViewAdapter(List<Event> data) {
        this.eventList = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.eventrow_listitem, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Event current = eventList.get(position);
        holder.text.setText(current.textView);
        holder.image.setImageResource(current.imageId);
    }

    @Override
    public int getItemCount() {

        return eventList.size();
    }

}

