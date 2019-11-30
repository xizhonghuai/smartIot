import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.apache.http.NameValuePair;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map.Entry;

import java.io.IOException;
import java.util.*;

/**
 * @ClassName test
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-06-20 12:51
 * @Version 1.0
 */
public class test {


    public static String encryption(String plainText) {
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
    }


    public static String postCallStr(String url, String content_type, Map<String, Object> params)
            throws ClientProtocolException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);

        Set<Map.Entry<String, Object>> sets = params.entrySet();
        Iterator<Map.Entry<String, Object>> it = sets.iterator();

        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

        while (it.hasNext()) {
            Entry<String, Object> entry = it.next();
            nameValuePairs.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
        }
    //    post.addHeader("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
//        post.addHeader("Cookie", THParams.COOKIE);
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));

        String conResult = "";
        HttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == 200) {
            // 读取返回数据
            conResult = (EntityUtils.toString(response.getEntity()));
        }
        return conResult;
    }

    private  String	 unicodeToUtf8 (String s) throws Exception {
        return new String( s.getBytes("utf-8") , "utf-8");
    }



    @Test
   public void testArray() throws Exception{


        Map<String, Object> par = new HashMap<>();

        String str =unicodeToUtf8("前方积水深度10cm");
        par.put("enterpriseID","16286");
        par.put("loginName","dbkj");
        par.put("password",encryption("dbsms@123"));
        par.put("content",str);
        par.put("mobiles","13667606142");


       String ret = postCallStr("http://113.108.68.228:8001/sendSMS.action",null,par);

        System.out.println(ret);



   }
}
