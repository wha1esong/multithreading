package com.chen.yuewen;

import static com.chen.yuewen.Test1.writeJsonFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.map.MultiValueMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

/**
 * Description :   .
 *
 * @author : chenyuxiang
 * @date : Created in 2020/12/16 2:36 下午
 */
public class Test2 {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		String username="root";
		String password="root";
		String authentication=username+":"+password;


//		String url = "http://172.16.121.89:7001/governance/services?keyword=*";
		String url = "http://172.16.121.89:7001/governance/consumers";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		List<String> cookieList = new ArrayList<>();
		List<String> authorization = new ArrayList<>();
		cookieList.add("JSESSIONID=B452159AB75A0AF479689FABFD7309FB");
		authorization.add("Basic cm9vdDpyb290");
		headers.put("Cookie", cookieList);
//		headers.put("Authorization", authorization);

		headers.set("Authorization", "Basic " + Base64.getEncoder().encodeToString(authentication.getBytes()));
		HttpEntity request = new HttpEntity<>(headers);
		ResponseEntity<String> exchange = restTemplate
				.exchange(url, HttpMethod.GET, request, String.class);
//		System.out.println(exchange.getBody());
		Document document = Jsoup.parse(exchange.getBody());



//		Elements elementsByClass = document.getElementsByClass("contentbox_tab");

//		Elements list_list_dubbo = document.getElementsByClass("list list_dubbo");
		Elements table = document.getElementsByTag("tbody");
		Elements trs = document.getElementsByTag("tr");

//		List arrayList = new ArrayList();
		HashMap<String, List<String>> map = new HashMap<>();
		for (Element tr : trs) {
//			Elements td = tr.getElementsByTag("td");
//			JSONObject jsonObject = new JSONObject();
			Elements childrens = tr.children();

			String ip = "";
			String appName = "";
			for (Element children : childrens) {
				String text = children.text();
				//正则排除
				if (StringUtils.isEmpty(text) ||!text.matches("^(?!.*(csv|search|nvs|mvc)).*$")) {
					continue;
				}
				//正则通过
				if (text.matches("^[.0-9]+$")) {
					ip = text;
					continue;
				}
				if (text.matches("^[-a-zA-Z]+$")) {
					appName = text;
				}
			}
			if (StringUtils.isEmpty(appName)){
				continue;
			}
			List temp = map.get(appName);
			if (temp!= null&&!temp.contains(ip)) {
				temp.add(ip);
			} else {
				ArrayList arrayList = new ArrayList();
				arrayList.add(ip);
				map.put(appName, arrayList);
			}
			System.out.println("----");
		}

		JSONObject jsonObject=JSONObject.parseObject(JSONObject.toJSONString(map));
		System.out.println("-");
	}
}
