package com.innovators.fitnesschef;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class diaryFragment extends Fragment {


    public diaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_diary, container, false);
        Button button = (Button) view.findViewById(R.id.br_food);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent in=new Intent(getActivity(),BreakfastActivity.class);
                getActivity().startActivity(in);
            }
        });
        Button button1 = (Button) view.findViewById(R.id.lunch_food);

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent in=new Intent(getActivity(),LunchActivity.class);
                getActivity().startActivity(in);
            }
        });

        Button button2 = (Button) view.findViewById(R.id.dinner_food);

        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent in=new Intent(getActivity(),DinnerActivity.class);
                getActivity().startActivity(in);
            }
        });
        Button button3 = (Button) view.findViewById(R.id.snacks_food);

        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent in=new Intent(getActivity(),SnacksActivity.class);
                getActivity().startActivity(in);
            }
        });
        Button button4 = (Button) view.findViewById(R.id.excerise_reg);

        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent in=new Intent(getActivity(),ExerciseActivity.class);
                getActivity().startActivity(in);
            }
        });
        return view;
    }
    }

