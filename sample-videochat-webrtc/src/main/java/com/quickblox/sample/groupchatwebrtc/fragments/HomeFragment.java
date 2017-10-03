package com.quickblox.sample.groupchatwebrtc.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quickblox.sample.groupchatwebrtc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseToolBarFragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    int getFragmentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  super.onCreateView(inflater, container, savedInstanceState);
        toolbar.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
        return view;
    }

}
