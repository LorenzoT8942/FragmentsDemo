package it.claudiopezzino.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FTA_Fragment2 extends Fragment implements View.OnClickListener{

    private Fragment2Listener activityCallback;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fta_2, container, false);
        Button btn_1 = view.findViewById(R.id.btn_1);
        Button btn_2 = view.findViewById(R.id.btn_2);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        return view;
    }

    @Override
     public void onAttach(@NonNull Context context){
        super.onAttach(context);

        try {
            activityCallback = (Fragment2Listener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement Fragment2Listener interface");
        }
     }

     @Override
     public void onDetach(){
        super.onDetach();
        activityCallback = null;
     }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_1){
            activityCallback.onFragment2Button1Click();
        }

        if (view.getId() == R.id.btn_2){
            activityCallback.onFragment2Button2Click();
        }
    }

    public interface Fragment2Listener {

        //method to be called when button 1 of fragment 2 is clicked
        void onFragment2Button1Click();

        //method to be called when button 2 of fragment 2 is clicked
        void onFragment2Button2Click();
    }
}