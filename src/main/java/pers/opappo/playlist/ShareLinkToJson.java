package pers.opappo.playlist;

/**
 * Created by Luvoratorrrrry on 2018/3/12.
 * 从用户分享链接中提取出歌单Id，拼成真实url作为参数传到SendGET方法，取得返回的内容(待解析的json)
 */
public class ShareLinkToJson {
    public static String getRawJson(String userShareLink) {

        //提取用户分享链接中的歌单id
        StringBuffer temp = new StringBuffer(userShareLink);
        int start = temp.indexOf("id=") + 3;
        int end = temp.indexOf("&userid");
        String playListId = temp.substring(start, end);

        //将id加入获取歌单信息的api中，得到真实url
        String url = "http://music.163.com/api/playlist/detail?id=" + playListId + "&updateTime=-1";
        String rawJson = GetResponse.SendGET(url);

        return rawJson;


    }
}
