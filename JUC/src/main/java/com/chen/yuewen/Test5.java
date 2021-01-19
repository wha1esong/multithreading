package com.chen.yuewen;

import static com.chen.yuewen.Test1.readJsonFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * Description :   .
 *
 * @author : chenyuxiang
 * @date : Created in 2020/12/21 5:49 下午
 */
public class Test5 {

	public static void main(String[] args) {
		String appRelationship = readJsonFile("/Users/erebus/IO/test.json");
		HashMap<String, Object> hashMap1 = new HashMap<>();
		HashMap<String, Object> hashMap2 = new HashMap<>();
		Map<String, Object> appRelationshipMap = JSON
				.parseObject(appRelationship, LinkedHashMap.class, Feature.OrderedField);
		for (Map.Entry<String, Object> entry : appRelationshipMap.entrySet()) {
			if (entry.getKey() != "saas") {
				continue;
			}
			Map<String, Object> map = JSON
					.parseObject(entry.getValue().toString(), LinkedHashMap.class,
							Feature.OrderedField);
			for (Map.Entry<String, Object> entry1 : map.entrySet()) {
				Map<String, Object> map2 = JSON
						.parseObject(entry1.getValue().toString(), LinkedHashMap.class,
								Feature.OrderedField);
				for (Map.Entry<String, Object> entry2 : map2.entrySet()) {
					String[] appNames = StringUtils
							.strip(entry2.getValue().toString(), "\"[]\"")
							.split("\",\"");

					for (String str : appNames) {
						hashMap1.put(str, "1");
					}
				}
			}
		}
		String apps = readJsonFile(
				"/Users/erebus/IdeaProjects/multithreading/JUC/src/main/java/com/chen/compare/appInfo.json");
		Map<String, Object> map = JSON.parseObject(apps, LinkedHashMap.class, Feature.OrderedField);
		for (String key : map.keySet()) {
			hashMap2.put(key, 2);
		}
		for (String key : hashMap2.keySet()) {
			if (hashMap1.get(key) == null) {
				System.out.println(key);
			}
		}
	}
}

