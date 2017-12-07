package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingerActivity extends AppCompatActivity {
    static int i = 1;
    private ListView news_list3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        String songster = "周杰伦";
        Bundle bundle = this.getIntent().getExtras();
        String result = bundle.getString("songster");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singer);
        news_list3 = (ListView) findViewById(R.id.news_list2);
        SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.news_list2, new String[]{"singerpic", "singer"}, new int[]{R.id.singerpic, R.id.singer});
        news_list3.setAdapter(adapter);
    }
    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        if (i == 1) {
            map.put("singerpic", R.drawable.zhoujielun);
            map.put("singer", "姓名：周杰伦\n" +
                    "性别：男\n" +
                    "出生日期：1979年1月18日\n" +
                    "出生地：台北\n" +
                    "职业：歌手、音乐人、制作人、导演、商人\n" +
                    "代表作品：龙卷风、简单爱、东风破、七里香、头文字D、不能说的秘密、青花瓷、稻香、逆战、天台、告白气球\n" +
                    "主要成就：十五座金曲奖，四届世界音乐大奖最畅销中华区艺人，大中华区8次年度唱片销量冠军等等\n");
            list.add(map);
        } else if (i == 2) {
            map = new HashMap<String, Object>();
            map.put("singerpic", R.drawable.wuyuetian);
            map.put("singer", "五月天（成员五人）\n" +
                    "性别：男\n" +
                    "出生日期：略\n" +
                    "出生地：台北\n" +
                    "职业：乐团，词曲创作人\n" +
                    "代表作品：志明与春娇、爱情万岁、温柔、倔强、知足、离开地球表面、突然好想你\n" +
                    "主要成就：全球华语音乐榜中榜最佳乐团，四次台湾金曲奖“最佳乐团奖”，MR中国TOP排行榜最佳乐团等等\n");
            list.add(map);
        } else if (i == 3) {
            map = new HashMap<String, Object>();
            map.put("singerpic", R.drawable.liangjingru);
            map.put("singer", "姓名：梁静茹\n" +
                    "性别：女\n" +
                    "出生日期：1978年6月16日\n" +
                    "出生地：马来西亚\n" +
                    "职业：歌手\n" +
                    "代表作品：勇气、分手快乐、燕尾蝶、宁夏、暖暖、崇拜、情歌、爱久见人心\n" +
                    "主要成就：两届新加坡金曲奖最佳演绎女歌手，蝉联两届全球华语榜中榜最佳女歌手等等\n");
            list.add(map);
        } else if (i == 4) {
            map = new HashMap<String, Object>();
            map.put("singerpic", R.drawable.tianfuzhen);
            map.put("singer", "姓名：田馥甄\n" +
                    "性别：女\n" +
                    "出生日期：1983年3月30日\n" +
                    "出生地：台北\n" +
                    "职业：歌手、演员\n" +
                    "代表作品：寂寞寂寞就好、My Love、你就不要想起我、小幸运\n" +
                    "主要成就：两届音乐风云榜最佳女歌手，全球流行音乐金榜最受欢迎女歌手等等\n");
            list.add(map);
        } else if (i == 5) {
            map = new HashMap<String, Object>();
            map.put("singerpic", R.drawable.cenninger);
            map.put("singer", "姓名：岑宁儿\n" +
                    "性别：女\n" +
                    "出生日期：1984年11月7日\n" +
                    "出生地：香港\n" +
                    "职业：歌手\n" +
                    "代表作品：追光者\n" +
                    "主要成就：第16届“华语音乐传媒大奖”最佳国语女新等等\n");
            list.add(map);
        } else if (i == 6) {
            map = new HashMap<String, Object>();
            map.put("singerpic", R.drawable.chenyixun);
            map.put("singer", "姓名：陈奕迅\n" +
                    "性别：男\n" +
                    "出生日期：1974年7月27日\n" +
                    "出生地：香港\n" +
                    "职业：歌手、演员\n" +
                    "代表作品：K歌之王、你的背包、十年、浮夸、最佳损友、好久不见\n" +
                    "主要成就：第26届台湾金曲奖最佳国语男歌手，第20届台湾金曲奖最佳国语专辑，十大劲歌金曲最受欢迎男歌星，十大中文金曲全国最佳男歌手 \n");
            list.add(map);
        }
        return list;
    }
}