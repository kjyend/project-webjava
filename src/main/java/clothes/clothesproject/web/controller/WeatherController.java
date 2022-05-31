package clothes.clothesproject.web.controller;

import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.entiry.Weather;
import clothes.clothesproject.domain.service.WeatherService;
import clothes.clothesproject.web.argumentresolver.Login;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequiredArgsConstructor
@Slf4j
public class WeatherController { //데이터값 html

    //weather 여기에서만 사용하는 String 3개정도 두고 model에 저장하면서 해야한다.
    private String tmp; //온도
    private String pcp; //강수 없음
    private String sky; //하늘 상태
    //dto 해야한다.
    private final WeatherService weatherService;

    @GetMapping("/weather") // 일단 값이 나온다. 하지만 html 확인할것
    public String weatherForm(@Login Member loginMember, @ModelAttribute("weather") Weather weather) throws Exception {
        if (loginMember == null) {
            return "redirect:/";
        }
        if(jsonString().equals("00")){
            weatherService.save(weather,tmp,pcp,sky);
        }
        return "weather/weather";
    }
    public String jsonString() throws Exception {
         /*
            @ API LIST
            getUltraSrtNcst 초단기실황조회
            getUltraSrtFcst 초단기예보조회
            getVilageFcst 동네예보조회
            getFcstVersion 예보버전조회
        */
        Date now=new Date(); //날짜
        SimpleDateFormat frame=new SimpleDateFormat("yyyyMMdd");
        String days=frame.format(now);

        SimpleDateFormat formatter=new SimpleDateFormat("HH00"); //1시간 전에 날씨를 받는다. 이유는 데이터가 없는 시간이 있어서

        Calendar time = Calendar.getInstance();
        time.setTime(now);
        time.add(Calendar.HOUR,-1);
        String nowTime=formatter.format(time.getTime()).toString();


        String nx = "60";	//위도 : 나중에 입력 받아야한다.
        String ny = "127";	//경도 : 나중에 입력 받아야한다.
        String baseDate = days;	//조회하고싶은 날짜
        String baseTime = nowTime;	//조회하고싶은 시간 nowTime

        String apiUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";

        String serviceKey="SOLuYRh8xqz5eiyULHRGa7argcZ5hB4drsGC1LFh91Og5tZwMs4Jk34TctQelxAph%2BlwkFPoh%2F9oAcB0XM8PHQ%3D%3D";

        StringBuilder urlBuilder = new StringBuilder(apiUrl);
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+serviceKey);
        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode(nx, "UTF-8")); //경도
        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode(ny, "UTF-8")); //위도
        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(baseDate, "UTF-8")); /* 조회하고싶은 날짜*/
        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(baseTime, "UTF-8")); /* 조회하고싶은 시간 AM 02시부터 3시간 단위 */
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));	/* 타입 */


        HashMap<String, Object> resultMap = getDataFromJson(String.valueOf(urlBuilder), "UTF-8", "get", "");

        JSONObject jsonObj = new JSONObject();
        JSONParser parser = new JSONParser();
//        String[] arr =new String[4];

        jsonObj.put("result", resultMap);

        //jsonobject를 객체로 바꾸기. 안하면 시간지남으로 인한 error
        JSONObject jsonObject= (JSONObject) parser.parse(jsonObj.toString());

        JSONObject result = (JSONObject) jsonObject.get("result");
        JSONObject response= (JSONObject) result.get("response");
        //기상청의 데이터가 있는지 확인한다.
        JSONObject header= (JSONObject) response.get("header");
        String resultCode= (String) header.get("resultCode");

        if(!resultCode.equals("00")){ //resultCode값이 00이 아니면 if문 실행
            return "기상청에 데이터가 없습니다.";
        }

        JSONObject body= (JSONObject) response.get("body");
        JSONObject items= (JSONObject) body.get("items");
        JSONArray item= (JSONArray) items.get("item");
//      파싱 배열 확인할것 nodata 받으면 if문으로 넣어서 시간 적게?

        //온도 받는
        JSONObject itemArray1= (JSONObject) item.get(0); // 온도
        tmp = (String) itemArray1.get("fcstValue");
//        arr[0]=tmp;

        //강수가 있는지 없는지
        JSONObject itemArray2= (JSONObject) item.get(9); // 강수가 있는지 없는지
        pcp= (String) itemArray2.get("fcstValue");
//        arr[1]=pcp;

        //하늘 상태
        JSONObject itemArray3= (JSONObject) item.get(5); // 하늘 상태
        sky= (String) itemArray3.get("fcstValue");
//        arr[2]=sky;

        return "00";
    }

    //이거 풀생각해야한다.
    public HashMap<String, Object> getDataFromJson(String apiUrl, String encoding, String type, String jsonStr) throws Exception {
        boolean isPost = false;

        if ("post".equals(type)) {
            isPost = true;
        } else {
            apiUrl = "".equals(jsonStr) ? apiUrl : apiUrl + "?request=" + jsonStr;
        }

        return getStringFromURL(apiUrl, encoding, isPost, jsonStr, "application/json");
    }

    public HashMap<String, Object> getStringFromURL(String apiUrl, String encoding, boolean isPost, String parameter, String contentType) throws Exception {
        URL apiURL = new URL(apiUrl);

        HttpURLConnection conn = null;
        BufferedReader br = null;
        BufferedWriter bw = null;

        HashMap<String, Object> resultMap = new HashMap<String, Object>();

        try {
            conn = (HttpURLConnection) apiURL.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setDoOutput(true);

            if (isPost) {
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", contentType);
                conn.setRequestProperty("Accept", "*/*");
            } else {
                conn.setRequestMethod("GET");
            }

            conn.connect();

            if (isPost) {
                bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
                bw.write(parameter);
                bw.flush();
                bw = null;
            }

            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), encoding));

            String line = null;

            StringBuffer result = new StringBuffer();

            while ((line=br.readLine()) != null) result.append(line);

            ObjectMapper mapper = new ObjectMapper();

            resultMap = mapper.readValue(result.toString(), HashMap.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(apiUrl + " interface failed" + e.toString());
        } finally {
            if (conn != null) conn.disconnect();
            if (br != null) br.close();
            if (bw != null) bw.close();
        }

        return resultMap;
    }
}
