package com.quickblox.sample.groupchatwebrtc.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.quickblox.sample.groupchatwebrtc.R;
import com.quickblox.sample.groupchatwebrtc.view.CanvasView;


public class ScreenShareFragment extends BaseToolBarFragment {

    public static final String TAG = ScreenShareFragment.class.getSimpleName();
    private OnSharingEvents onSharingEvents;

    @Override
    int getFragmentLayout() {
        return R.layout.fragment_pager;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        final CanvasView canvasView = (CanvasView) view.findViewById(R.id.canvasView);

        FloatingActionButton fabRubber = (FloatingActionButton) view.findViewById(R.id.fabRubber);
        fabRubber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                while (canvasView.canUndo()) {
                    canvasView.undo();
                }
            }
        });

        FloatingActionButton fabUndo = (FloatingActionButton) view.findViewById(R.id.fabUndo);
        fabUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (canvasView.canUndo())
                    canvasView.undo();
            }
        });

        FloatingActionButton fabRedu = (FloatingActionButton) view.findViewById(R.id.fabRedu);
        fabRedu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (canvasView.canRedo())
                    canvasView.redo();
            }
        });

        toolbar.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.screen_share_fragment, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.stop_screen_share:
                Log.d(TAG, "stop_screen_share");
                if (onSharingEvents != null) {
                    onSharingEvents.onStopPreview();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onSharingEvents = (OnSharingEvents) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onSharingEvents = null;
    }

    public interface OnSharingEvents {
        void onStopPreview();
    }

    public static ScreenShareFragment newIntstance() {
        return new ScreenShareFragment();
    }

}
