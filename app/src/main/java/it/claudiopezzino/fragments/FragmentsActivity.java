package it.claudiopezzino.fragments;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


public class FragmentsActivity extends AppCompatActivity implements Fragment_A.FragmentAListener, Fragment_B.FragmentBListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragments_activity);

        /* If the FrameLayout with id container is present, it means that we are in SINGLE PANEL
          * therefore it is necessary to add the fragment with the transaction */
        if (findViewById(R.id.container) != null) {
            new Holder();
        }
    }

    /* --------------------------------------------------------------------------------------------------------------------------*/

    public void setFragmentALayout(Fragment_A fragmentA) {

        FragmentTransaction transaction;
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragmentA);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    /* --------------------------------------------------------------------------------------------------------------------------*/

    public void setFragmentBLayout(Fragment_B fragmentB) {

        FragmentTransaction transaction;
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragmentB);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    /* --------------------------------------------------------------------------------------------------------------------------*/

    class Holder {

        Fragment_A fragmentA;

        Holder() {

            fragmentA = new Fragment_A();

            setFragmentALayout(fragmentA);
        }
    }

    /* --------------------------------------------------------------------------------------------------------------------------*/

    /* implementation of communication interface of Fragment_A */
    @Override
    public void sendMessageToB(CharSequence text) {

        Fragment_B fragmentB = (Fragment_B) getSupportFragmentManager().findFragmentById(R.id.fragment_b);

        if (fragmentB != null && fragmentB.isInLayout()) {

            fragmentB.updateOnTextView(text);
        } else {

            Fragment_B fragment = Fragment_B.newInstance(text);
            setFragmentBLayout(fragment);
        }
    }

    /* --------------------------------------------------------------------------------------------------------------------------*/

    /* implementation of communication interface of Fragment_B */
    @Override
    public void sendMessageToA(CharSequence text) {

        Fragment_A fragmentA = (Fragment_A) getSupportFragmentManager().findFragmentById(R.id.fragment_a);

        if (fragmentA != null && fragmentA.isInLayout()) {

            fragmentA.updateOnTextView(text);
        } else {

            Fragment_A fragment = Fragment_A.newInstance(text);
            setFragmentALayout(fragment);
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}