package com.innovators.fitnesschef;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class diaryFragment extends Fragment {

String g;
    TextView v;
    TextView f;
    TextView e;
    TextView r;
    TextView b;
    TextView l;
    TextView d;
    TextView s;
    TextView es;

    public diaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_diary, container, false);
        v=(TextView) view.findViewById(R.id.gvalue);
        f=(TextView) view.findViewById(R.id.fvalue);
        e=(TextView) view.findViewById(R.id.evalue);
        r=(TextView) view.findViewById(R.id.result);
        b=(TextView) view.findViewById(R.id.breakfastvalue);
        l=(TextView) view.findViewById(R.id.lunchvalue);
        d=(TextView) view.findViewById(R.id.dinnervalue);
        s=(TextView) view.findViewById(R.id.snacksvalue);
        es=(TextView) view.findViewById(R.id.exersievalue);
        home h=(home)getActivity();
        g=h.get();
        SharedPreferences sp = getActivity().getSharedPreferences(g,0);
        v.setText(Integer.toString(sp.getInt("estcal",0)));

        SharedPreferences br = getActivity().getSharedPreferences(g+"breakfast",0);
        b.setText(Integer.toString(br.getInt("value",0)));
        SharedPreferences lu = getActivity().getSharedPreferences(g+"lunch",0);
        l.setText(Integer.toString(lu.getInt("value",0)));
        SharedPreferences di = getActivity().getSharedPreferences(g+"dinner",0);
        d.setText(Integer.toString(di.getInt("value",0)));
        SharedPreferences sn = getActivity().getSharedPreferences(g+"snacks",0);
        s.setText(Integer.toString(sn.getInt("value",0)));
        SharedPreferences er = getActivity().getSharedPreferences(g+"exercise",0);
        es.setText(Integer.toString(er.getInt("value",0)));
        int x=br.getInt("value",0)+lu.getInt("value",0)+di.getInt("value",0)+sn.getInt("value",0);
        int z=Integer.parseInt(v.getText().toString())-x+Integer.parseInt(es.getText().toString());
        SharedPreferences shared = getActivity().getSharedPreferences(g+"cal",0);
        SharedPreferences.Editor editor = shared.edit();
        editor.putInt("food",x);
        editor.putInt("exercise",er.getInt("value",0));
        editor.putInt("result",z);
        editor.commit();
        f.setText(Integer.toString(shared.getInt("food", 0)));
        e.setText(Integer.toString(shared.getInt("exercise", 0)));
        r.setText(Integer.toString(shared.getInt("result",0)));

        Button button = (Button) view.findViewById(R.id.br_food);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent in=new Intent(getActivity(),BreakfastActivity.class);
              in.putExtra("email",g);
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
             in.putExtra("email",g);
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
            in.putExtra("email",g);
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
          in.putExtra("email",g);
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
           in.putExtra("email",g);
                getActivity().startActivity(in);
            }
        });
        return view;
    }


    }

