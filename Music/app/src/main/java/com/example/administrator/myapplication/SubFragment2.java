package com.example.administrator.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SubFragment2 extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView news_list2;

    public SubFragment2() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SubFragment2 newInstance(String param1, String param2) {
        SubFragment2 fragment = new SubFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.fragment_sub_fragment2);
        news_list2 = (ListView) getActivity().findViewById(R.id.news_list3);
        SimpleAdapter adapter = new SimpleAdapter(this.getActivity(), getData(), R.layout.news_list3, new String[]{"type", "title1", "title2", "title3"}, new int[]{R.id.type, R.id.title1, R.id.title2, R.id.title3});
        news_list2.setAdapter(adapter);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", R.drawable.huayu);
        map.put("title1", "1.偷故事的人--张惠妹");
        map.put("title2", "2.Victoria--G.E.M.邓紫棋");
        map.put("title3", "3.温柔的奇迹--范玮琪");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("type", R.drawable.yingyu);
        map.put("title1", "1.rockstar--Post Malone");
        map.put("title2", "2.Havana--Camila Cabello");
        map.put("title3", "3.Gucci Gang--Lil Pump");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("type", R.drawable.hanyu);
        map.put("title1", "1.JUST DANCE--MIXNINE");
        map.put("title2", "2.BABE--泫雅");
        map.put("title3", "Twinkle--Lovelyz");
        list.add(map);
        return list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sub_fragment2, container, false);
    }
    // TODO: Rename method, update argument and hook method into UI event
    //    public void onButtonPressed(Uri uri) {
    //        if (mListener != null) {
    //            mListener.onFragmentInteraction(uri);
    //        }
    //    }
    //    @Override
    //    public void onAttach(Context context) {
    //        super.onAttach(context);
    //        if (context instanceof OnFragmentInteractionListener) {
    //            mListener = (OnFragmentInteractionListener) context;
    //        } else {
    //            throw new RuntimeException(context.toString()
    //                    + " must implement OnFragmentInteractionListener");
    //        }
    //    }
    //    @Override
    //    public void onDetach() {
    //        super.onDetach();
    //        mListener = null;
    //    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
