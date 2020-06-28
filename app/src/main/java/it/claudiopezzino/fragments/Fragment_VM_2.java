package it.claudiopezzino.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class Fragment_VM_2 extends Fragment implements View.OnClickListener {
    private MyViewModel vmodel;
    private TextView tv_message;
    private EditText et_message;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vm_2, container, false);
        tv_message =  view.findViewById(R.id.tv_message);
        et_message = view.findViewById(R.id.et_message);
        Button btn_SendToF1 =  view.findViewById(R.id.btn_F2SendToF1);
        Button btn_SendToActivity =  view.findViewById(R.id.btn_F2SendToActivity);

        btn_SendToActivity.setOnClickListener(this);
        btn_SendToF1.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {

        int viewId = view.getId();

        if (viewId == R.id.btn_F2SendToActivity){
            vmodel.setActivity_msg(et_message.getText().toString());
        }

        if (viewId == R.id.btn_F2SendToF1){
            vmodel.setFragment1_msg(et_message.getText().toString());
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vmodel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        vmodel.getFragment2_msg().observe(getViewLifecycleOwner(),           new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv_message.setText(s);
            }
        });
    }
}
