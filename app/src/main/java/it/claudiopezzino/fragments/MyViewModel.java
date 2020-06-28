package it.claudiopezzino.fragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<String> fragment1_msg;
    private MutableLiveData<String> fragment2_msg;
    private MutableLiveData<String> activity_msg;

    public MyViewModel () {
        fragment1_msg = new MutableLiveData<>();
        fragment2_msg = new MutableLiveData<>();
        activity_msg = new MutableLiveData<>();
    }

    public LiveData<String> getFragment1_msg(){
        if (fragment1_msg == null) fragment1_msg = new MutableLiveData<>();
        return fragment1_msg;
    }

    public void setFragment1_msg(String s){
        if (fragment1_msg == null) fragment1_msg = new MutableLiveData<>();
        fragment1_msg.setValue(s);
    }

    public LiveData<String> getFragment2_msg(){
        if (fragment2_msg == null) fragment2_msg = new MutableLiveData<>();
        return fragment2_msg;
    }

    public void setFragment2_msg(String s){
        if (fragment2_msg == null) fragment2_msg = new MutableLiveData<>();
        fragment2_msg.setValue(s);
    }

    public LiveData<String> getActivity_msg(){
        if (activity_msg == null) activity_msg = new MutableLiveData<>();
        return activity_msg;
    }

    public void setActivity_msg(String s){
        if (activity_msg == null) activity_msg = new MutableLiveData<>();
        activity_msg.setValue(s);
    }
}
