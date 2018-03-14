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

        //tracks是数组，要用JSONArray然后遍历数组！
        JSONArray tracksArr = JSON.parseArray(resultObj.get("tracks").toString());
        for (Object trackTemp : tracksArr) {
            //将取得的Object类型转换成JSONObject类型
            JSONObject tracksObj = (JSONObject) trackTemp;

            JSONObject albumObj = JSON.parseObject(tracksObj.get("album").toString());

            String name = (String) tracksObj.get("name");
            String album = (String) albumObj.get("name");
            int duration = (int) tracksObj.get("duration") / 1000;
            StringBuffer artistsBuffer = new StringBuffer();

            JSONArray artistsArr = JSON.parseArray(tracksObj.get("artists").toString());

            // foreach遍历
            for (Object artistsTemp : artistsArr) {
                JSONObject artistsObj = (JSONObject) artistsTemp;
                //System.out.print(artistsObj.get("name") + " ");
                artistsBuffer.append(artistsObj.get("name" + " "));
            }
            //System.out.println("");
            String artists = artistsBuffer.toString();
            System.out.println(name + "\t\t" + duration + "\t\t《" + album + "》\t\t" + artists);
        }


    }
}
