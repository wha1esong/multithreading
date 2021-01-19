package com.chen.yuewen;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

/**
 * Description :   .
 *
 * @author : chenyuxiang
 * @date : Created in 2020/12/22 1:38 下午
 */
public class Test6 {

	public static void main(String[] args) {
		String url = "http://172.16.121.89:7001/governance/services";
		Document data = getData(url);
		Elements trs = data.getElementsByTag("tr");
		int i = 0;
		ArrayList list = new ArrayList();
		for (Element tr : trs) {
			if (i > 10) {
				break;
			}
			i++;
			Elements childrens = tr.children();
			for (Element children : childrens) {
				String text = children.text();
				if (!text.matches("^(?!.*(csv|search|noProvider)).*$")){
					continue;
				}
				if (text.matches("^[-_.:a-zA-Z0-9]+$")) {
					String newUrl = url + "/" + text + "/applications";
					Document data2 = getData(newUrl);
					JSONObject jsonObject = structureData(data2, text);
					list.add(jsonObject);
				}
			}
		}

//		String newUrl2 = "http://172.16.121.89:7001/governance/services/com.huixian.activitythirdaccount.dubbo.facade.api.DubboCashDrawService/applications";
//
//		Document data = getData(newUrl2);
//		JSONObject jsonObject = structureData(data, newUrl2);
//		String s=JSONObject.toJSONString(jsonObject);
//		System.out.println(s);

		String s = JSONObject.toJSONString(list);
		System.out.println(s);
	}

	public static Document getData(String url) {
		RestTemplate restTemplate = new RestTemplate();
		String username = "root";
		String password = "root";
		String authentication = username + ":" + password;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Authorization",
				"Basic " + Base64.getEncoder().encodeToString(authentication.getBytes()));
		HttpEntity request = new HttpEntity<>(headers);
		ResponseEntity<String> exchange = restTemplate
				.exchange(url, HttpMethod.GET, request, String.class);
		Document document = Jsoup.parse(exchange.getBody());
		return document;
	}


	public static JSONObject structureData(Document document, String serviceName) {
		Elements trs = document.getElementsByTag("tr");
		ArrayList providerList = new ArrayList();
		ArrayList consumerList = new ArrayList();
		for (Element tr : trs) {
			Elements tds = tr.children();
			boolean flag = false;
			String appName = "";
			for (Element td : tds) {
				String text = td.text();
				if (StringUtils.isEmpty(text)) {
					continue;
				}
				if ("提供者".equals(text)) {
					flag = true;
				}
				if ("消费者".equals(text)) {
					flag = false;
				}
				if (!text.matches("^(?!.*(csv|search|noProvider)).*$")){
					continue;
				}
				if (text.matches("^[-_.:a-zA-Z0-9]+$")) {
					appName = text;
				}
			}
			if (flag && !StringUtils.isEmpty(appName)) {
				providerList.add(appName);
			} else if (!StringUtils.isEmpty(appName)) {
				consumerList.add(appName);
			}
		}

		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();

		jsonObject.put("provider", providerList);
		jsonObject.put("consumer", consumerList);

		data.put(serviceName, jsonObject);

		return data;
	}

}
