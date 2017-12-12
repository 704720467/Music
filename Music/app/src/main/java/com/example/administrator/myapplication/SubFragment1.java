package com.example.administrator.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubFragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView news_list;
    private List<Map<String, Object>> mData;
    private ImageButton play;
    private ImageButton singer;
    private ImageButton video;
    final SubFragment1 me = this;

    public SubFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SubFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static SubFragment1 newInstance(String param1, String param2) {
        SubFragment1 fragment = new SubFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_sub_fragment1, container, false);
        news_list = (ListView) view.findViewById(R.id.news_list);
        mData = getData();
        MyAdapter adapter = new MyAdapter(this.getActivity());
        news_list.setAdapter(adapter);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        return view;
    }


    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "晴天");
        map.put("info", "周杰伦");
        map.put("play", R.drawable.play);
        map.put("singer", R.drawable.singer);
        map.put("video", R.drawable.video);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("title", "知足");
        map.put("info", "五月天");
        map.put("play", R.drawable.play);
        map.put("singer", R.drawable.singer);
        map.put("video", R.drawable.video);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("title", "情歌");
        map.put("info", "梁静茹");
        map.put("play", R.drawable.play);
        map.put("singer", R.drawable.singer);
        map.put("video", R.drawable.video);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("title", "小幸运");
        map.put("info", "田馥甄");
        map.put("play", R.drawable.play);
        map.put("singer", R.drawable.singer);
        map.put("video", R.drawable.video);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("title", "追光者");
        map.put("info", "岑宁儿");
        map.put("play", R.drawable.play);
        map.put("singer", R.drawable.singer);
        map.put("video", R.drawable.video);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("title", "好久不见");
        map.put("info", "陈奕迅");
        map.put("play", R.drawable.play);
        map.put("singer", R.drawable.singer);
        map.put("video", R.drawable.video);
        list.add(map);
        return list;
    }

    public final class ViewHolder {
        public TextView title;
        public TextView info;
        public ImageButton play;
        public ImageButton singer;
        public ImageButton video;
    }

    public class MyAdapter extends BaseAdapter {
        private LayoutInflater mInflater;

        public MyAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int arg0) {
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.list_item, null);
                holder.title = (TextView) convertView.findViewById(R.id.title);
                holder.info = (TextView) convertView.findViewById(R.id.info);
                holder.play = (ImageButton) convertView.findViewById(R.id.play);
                holder.singer = (ImageButton) convertView.findViewById(R.id.singer);
                holder.video = (ImageButton) convertView.findViewById(R.id.video);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.title.setText((String) mData.get(position).get("title"));
            holder.info.setText((String) mData.get(position).get("info"));
            holder.play.setTag(position);
            holder.singer.setTag(position);
            holder.video.setTag(position);
            play = (ImageButton) convertView.findViewById(R.id.play);
            play.setTag(holder.title.getText().toString());
            singer = (ImageButton) convertView.findViewById(R.id.singer);
            video = (ImageButton) convertView.findViewById(R.id.video);
            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showInfo(v.getId(), position);
                }
            });
            singer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showInfo(v.getId(), position);
                }
            });
            video.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showInfo(v.getId(), position);
                }
            });
            return convertView;
        }
    }

    public void showInfo(final int viewId, final int position) {
        new AlertDialog.Builder(this.getActivity())//
                .setTitle(mData.get(position).get("title").toString())//
                .setMessage(mData.get(position).get("info").toString())//
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (viewId) {
                            case R.id.video:
                                String vf = mData.get(position).get("title").toString();
                                Intent intent = new Intent(me.getContext(), VideoActivity.class);
                                intent.putExtra("vf", vf);
                                startActivity(intent);
                                break;
                            case R.id.singer:
                                Intent intent1 = new Intent(me.getContext(), SingerActivity.class);
                                intent1.putExtra("position", position);
                                startActivity(intent1);
                                break;
                            case R.id.play:
                                Intent intent2 = new Intent(me.getContext(), MusicplayerActivity2.class);
                                intent2.putExtra("song", mData.get(position).get("title").toString());
                                intent2.putExtra(MusicplayerActivity2.PARAM_MUSIC_POITION, position);
                                startActivity(intent2);
                                break;
                        }
                    }
                }).show();
    }
}