package pers.opappo.playlist;

/**
 * 歌单分享链接
 * Created by Luvoratorrrrry on 2018/3/12.
 */
public class Start {
    public static void main(String[] args) {
        // 分享链接test发送到PlaylistToJson
        String test = "https://music.163.com/playlist?id=82621571";
        String testPrint = ShareLinkToJson.getRawJson(test);

        JsonParse.AnalyzeJson(testPrint);

    }
}
