package com.example.sweetweather.ui.SweetSearch;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sweetweather.R;
import com.example.sweetweather.model.Citys;
import com.example.sweetweather.error.SweetError;
import com.example.sweetweather.network.SweetNetWork;
import com.example.sweetweather.request.SweetHttpListener;


public class SweetSearchFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.search_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        new SweetSearchViewModel().getCity().observe(getViewLifecycleOwner(), new Observer<Citys>() {
            @Override
            public void onChanged(Citys citys) {
                if (citys.getPlaces() != null) {
                    recyclerView.setAdapter(new PlaceAdapter(SweetSearchFragment.this,citys.getPlaces()));
                }
            }
        });
        EditText et = view.findViewById(R.id.search_et);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            //内容改变时调用
            @Override
            public void afterTextChanged(Editable s) {
                SweetNetWork.getCityData(s.toString(), new SweetHttpListener<Citys>() {
                    @Override
                    public void onSucceed(Citys entity) {
                        SweetSearchViewModel.setCity(entity);
                    }

                    @Override
                    public void onFeild(SweetError error) {

                    }
                });
            }
        });
    }
}
