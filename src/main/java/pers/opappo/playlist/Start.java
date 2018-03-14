package pers.opappo.playlist;

/**
 * Created by Luvoratorrrrry on 2018/3/12.
 */
public class Start {
    public static void main(String[] args) {

        // 分享链接替换link
        String link = "https://music.163.com/playlist?id=82621571&userid=31176983";
        String Print = ShareLinkToJson.getRawJson(link);

        JsonParse.AnalyzeJson(Print);

    }
}
