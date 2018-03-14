package pers.opappo.playlist;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by Luvoratorrrrry on 2018/3/13.
 */
public class JsonParse {
    public static void AnalyzeJson(String rawjson) {

        JSONObject object = JSON.parseObject(rawjson);
        JSONObject resultObj = JSON.parseObject(object.get("result").toString());

        //tracks是数组，要用JSONArray然后遍历
        JSONArray tracksArr = JSON.parseArray(resultObj.get("tracks").toString());
        for (Object trackTemp : tracksArr) {

            //将取得的Object类型转换成JSONObject类型
            JSONObject tracksObj = (JSONObject) trackTemp;

            //提取歌曲名
            String name = (String) tracksObj.get("name");

            //提取歌曲时长
            int duraTemp = (int) tracksObj.get("duration") / 1000;
            int minute = duraTemp / 60;
            int second = duraTemp % 60;
            String duration = String.format("%02d", minute) + ":" + String.format("%02d", second);

            //提取专辑名
            JSONObject albumObj = JSON.parseObject(tracksObj.get("album").toString());
            String album = (String) albumObj.get("name");

            //新建StringBuffer用来连接可能存在的多个歌手
            StringBuffer artistsBuffer = new StringBuffer();

            JSONArray artistsArr = JSON.parseArray(tracksObj.get("artists").toString());
            // foreach遍历artistsArr
            for (Object artistsTemp : artistsArr) {
                JSONObject artistsObj = (JSONObject) artistsTemp;
                //提取歌手名
                artistsBuffer.append(artistsObj.get("name") + " ");
            }
            String artists = artistsBuffer.toString();

            System.out.println(name + "\t\t" + duration + "\t\t《" + album + "》\t\t" + artists);
        }


    }
}