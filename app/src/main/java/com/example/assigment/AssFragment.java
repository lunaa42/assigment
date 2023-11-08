package com.example.assigment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AssFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AssFragment extends Fragment {

    private EditText tvEnterAd;
    private EditText tvEnterOp;
    private Button btnCalculate;
    private ImageView img;
    private FirebaseServices fb;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AssFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AssFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AssFragment newInstance(String param1, String param2) {
        AssFragment fragment = new AssFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private void connectComponents() {
        fb = FirebaseServices.getInstance();
        tvEnterAd = getView().findViewById(R.id.tventerAassFrag);
        tvEnterOp = getView().findViewById(R.id.tventerBassFrag);
        img = getView().findViewById(R.id.ivphotoAssFrag);
        btnCalculate = getView().findViewById(R.id.btnCalculateAssFrag);
    }

        @Override
         public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
         // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ass, container, false);
    }
    public void OnClick(View view){
            String entAdj = tvEnterAd.getText().toString();
            String entOpp = tvEnterOp.getText().toString();
            double a,b,cal;
            a = Double.parseDouble(entAdj);
            b = Double.parseDouble(entOpp);
            cal = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
            if(entAdj.isEmpty()|| !TextUtils.isDigitsOnly(entAdj)||entOpp.isEmpty()|| !TextUtils.isDigitsOnly(entOpp)) {
                Toast.makeText(getActivity(),"some fields are empty or not numbers!",Toast.LENGTH_SHORT).show();
                return;
            }
                Toast.makeText(getActivity(),"the hypotenuse is :" + cal,Toast.LENGTH_SHORT).show();

            }
    private void openImageInGallery() {
      //  img imageUri = click // Get the URI of your image here
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        //intent.setDataAndType(imageUri, "image/*");
        startActivity(intent);
    }

        }

