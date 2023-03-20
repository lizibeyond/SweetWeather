package com.example.sweetweather.ui.SweetSearch;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sweetweather.R;
import com.example.sweetweather.model.Citys;
import com.example.sweetweather.ui.SweetWeather.SweetWeatherActivity;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {
    private Fragment fragment;
    private List<Citys.Place> places;

    public PlaceAdapter(Fragment fragment, List<Citys.Place> places) {
        this.fragment = fragment;
        this.places = places;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_search_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(places.get(position).getName());
        holder.content.setText(places.get(position).getFormattedAddress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取点击的坐标点同时传给天气界面
                String lat = places.get(position).getLocation().getLat();
                String lng = places.get(position).getLocation().getLng();
                SweetWeatherActivity.startWeather(v.getContext(),lat,lng);
            }
        });
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView content;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.search_title);
            content = itemView.findViewById(R.id.search_content);
        }
    }

}
