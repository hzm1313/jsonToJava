import com.cn.yc.json.AbstractConvertJson;
import com.cn.yc.json.CreateConvertJson;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by DT167 on 2018/1/9.
 */
public class JsonToClassTest {
    @Test
    public void test(){
        String json = "{\"info\":\"\\u6570\\u636e\\u6b63\\u5e38\",\"status\":1,\"url\":{\"btc_cny\":[\"\\u6bd4\\u7279\\u5e01(BTC\\/CNY)\",117100,117100,149999,31705.1205,\"\",0.22,1.83,\"btc_cny\",\"http:\\/\\/moduoio.oss-cn-hongkong.aliyuncs.com\\/moduoio\\/1509702665812.png\",\"\"],\"wkb_cny\":[\"\\u73a9\\u5ba2\\u5e01(\\u94fe\\u514b)(WKB\\/CNY)\",4.43,4.43,4.47,9694657.63062,\"\",2066945.62,-8.09,\"wkb_cny\",\"http:\\/\\/moduoio.oss-cn-hongkong.aliyuncs.com\\/moduoio\\/1510216983457.png\",\"\"],\"llt_cny\":[\"\\u6d41\\u91cf\\u5e01(LLT\\/CNY)\",2,1.99,2,1143551.139825,\"\",554937.9,-2.44,\"llt_cny\",\"http:\\/\\/moduoio.oss-cn-hongkong.aliyuncs.com\\/moduoio\\/1510625051227.png\",\"\"],\"wc_cny\":[\"\\u73a9\\u5bb6\\u5e01(WC\\/CNY)\",20.5,20.5,21.48,12126690.66568,\"\",511313.11,-23.22,\"wc_cny\",\"http:\\/\\/moduoio.oss-cn-hongkong.aliyuncs.com\\/moduoio\\/1512311115420.png\",\"\"],\"sdc_cny\":[\"\\u661f\\u57df\\u5e01(SDC\\/CNY)\",2.47,2.47,2.48,103782.915705,\"\",39615.78,-1.2,\"sdc_cny\",\"http:\\/\\/moduoio.oss-cn-hongkong.aliyuncs.com\\/moduoio\\/1510216983457.png\",\"\"],\"knc_cny\":[\"kyber\\u7f51\\u7edc(KNC\\/CNY)\",36.25,36.13,36.25,1051514.045765,\"\",29321.21,6.09,\"knc_cny\",\"http:\\/\\/moduoio.oss-cn-hongkong.aliyuncs.com\\/moduoio\\/1513259652758.png\",\"\"],\"eth_cny\":[\"\\u4ee5\\u592a\\u574a(ETH\\/CNY)\",8365,8420,9400,182508.15141,\"\",20.37,2.01,\"eth_cny\",\"http:\\/\\/moduoio.oss-cn-hongkong.aliyuncs.com\\/moduoio\\/1509702927404.png\",\"\"],\"rdn_cny\":[\"\\u96f7\\u7535\\u7f51\\u7edc(RDN\\/CNY)\",62,61.5,62,198947.715655,\"\",3259.63,-11.43,\"rdn_cny\",\"http:\\/\\/moduoio.oss-cn-hongkong.aliyuncs.com\\/moduoio\\/1513681096784.png\",\"\"],\"snt_cny\":[\"Status\\u4ee3\\u5e01(SNT\\/CNY)\",3.6,3.61,3.73,802108.21274,\"\",213933.51,-0.83,\"snt_cny\",\"http:\\/\\/moduoio.oss-cn-hongkong.aliyuncs.com\\/moduoio\\/1513770201613.jpg\",\"\"],\"kin_cny\":[\"KIN\\u5e01(KIN\\/CNY)\",0.006314,0.006314,0.006315,13833969.91865,\"\",1953977305.45,-12.31,\"kin_cny\",\"http:\\/\\/moduoio.oss-cn-hongkong.aliyuncs.com\\/moduoio\\/1514198352766.png\",\"\"],\"bat_cny\":[\"\\u6ce8\\u610f\\u529b\\u5e01(BAT\\/CNY)\",5.64,5.51,5.75,352938.739065,\"\",62649.56,2.55,\"bat_cny\",\"http:\\/\\/moduoio.oss-cn-hongkong.aliyuncs.com\\/moduoio\\/1514340305898.png\",\"\"],\"rrc_cny\":[\"\\u4eba\\u4eba\\u5e01(RRC\\/CNY)\",0,0,0,0,\"\",0,0,\"rrc_cny\",\"http:\\/\\/moduoio.oss-cn-hongkong.aliyuncs.com\\/moduoio\\/1514960672753.png\",\"\"]}}";
        AbstractConvertJson abstractConvertJson = new CreateConvertJson();
        try {
            List<File> fileList = abstractConvertJson.createJavaClass(json, "hzm");
            fileList.forEach(file -> System.out.println(file.getName() + " " + file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
