package com.chen.yuewen;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.StringUtils;

public class Test1 {

	//1.获取应用层级关系
	//2.获取Dubbo-admin当前活动应用
	//3.获取Dubbo-admin应用之间的关系

	public static void main(String[] args) {

		JSONObject linkJson = new JSONObject();
		ArrayList edgeLists = new ArrayList();
		ArrayList nodeLists = new ArrayList();

//		int count = 0;
		//X轴初始坐标点
		AtomicInteger coordinateInitialX = new AtomicInteger(200);
		//Y轴初始坐标点
		AtomicInteger coordinateInitialY = new AtomicInteger(200);
		//X轴间隔大小
		int intervalX = 100;
		//Y轴间隔大小
		int intervalY = 100;
		//x,y当前位置
		AtomicInteger currentLocation[] = new AtomicInteger[]{coordinateInitialX,
				coordinateInitialY};

		Boolean shouldInitCoordinate = true;

		//解析Dubbo-admin中的应用-ip映射关系，即当前活动的应用
//		String consumerInfo = readJsonFile("/Users/erebus/IO/applicationInfoList.json");
		String consumerInfo = readJsonFile(
				"/Users/erebus/IdeaProjects/multithreading/JUC/src/main/java/com/chen/compare/appInfo.json");
//		String consumerInfo = readJsonFile("/Users/erebus/IdeaProjects/multithreading/JUC/src/main/java/com/chen/compare/appInfo.json");
		Map<String, Object> consumerInfoMap = JSON
				.parseObject(consumerInfo, LinkedHashMap.class, Feature.OrderedField);

		//解析应用之间的层级关系
		String appRelationship = readJsonFile("/Users/erebus/IO/test.json");
		//已归类map
		HashMap<String,Object> classifiedMap=new HashMap<>();
		//未归类map
		HashMap<String,Object> unClassifiedMap=new HashMap<>();
		int firstLevel = 0;
		Map<String, Object> appRelationshipMap = JSON
				.parseObject(appRelationship, LinkedHashMap.class, Feature.OrderedField);
		for (Map.Entry<String, Object> appLevel : appRelationshipMap.entrySet()) {
			HashMap<String, Object> zeroAppMap = JSON
					.parseObject(appLevel.getValue().toString(), LinkedHashMap.class,
							Feature.OrderedField);
			for (Map.Entry<String, Object> zeroLevel : zeroAppMap.entrySet()) {
				//第一层的业务应用
				Map<String, Object> firstLevelAppMap = JSON
						.parseObject(zeroLevel.getValue().toString(), LinkedHashMap.class,
								Feature.OrderedField);
				shouldInitCoordinate=true;
				for (Map.Entry<String, Object> firstLevelApp : firstLevelAppMap.entrySet()) {
					String[] appNames = StringUtils
							.strip(firstLevelApp.getValue().toString(), "\"[]\"")
							.split("\",\"");
					HashMap<String, Object> hashMap = new HashMap<>();
					for (String str : appNames) {
						if (consumerInfoMap.get(str) != null) {
							hashMap.put(str, firstLevel);
							classifiedMap.put(str,firstLevel);
						}
					}
					if (hashMap.size() == 0) {
						shouldInitCoordinate = false;
					} else {
						currentLocation = polymerizationDataLeft(hashMap, nodeLists, intervalX,
								intervalY,
								new AtomicInteger(currentLocation[0].get() + intervalX * 2),
								currentLocation[1]);
					}
				}
				++firstLevel;
				//进入下一层初始化当前X轴的坐标位置
				currentLocation[0] = coordinateInitialX;
				//进入下一层初始化当前Y轴的坐标位置，默认为Y轴正常间隔的三倍
				if (shouldInitCoordinate) {
					currentLocation[1] = new AtomicInteger(
							currentLocation[1].get() + intervalY * 3);
				}
				System.out.println(currentLocation[1]);
				System.out.println();
			}
		}


		//将未分类的节点放到最下方
		for(String key:consumerInfoMap.keySet()){
			if (classifiedMap.get(key)==null){
				unClassifiedMap.put(key,"unClassified");
			}
		}
		polymerizationDataLeft(unClassifiedMap, nodeLists, intervalX,
				intervalY,
				new AtomicInteger(currentLocation[0].get() + intervalX * 2),
				currentLocation[1]);

		//遍历第二步的map
//		String serviceApplicationInfo = readJsonFile(
//				"/Users/erebus/IO/serviceApplicationInfoList.json");
		String serviceApplicationInfo = readJsonFile(
				"/Users/erebus/IdeaProjects/multithreading/JUC/src/main/java/com/chen/compare/appRelationInfo.json");
//		String serviceApplicationInfo = readJsonFile(
//				"/Users/erebus/IdeaProjects/multithreading/JUC/src/main/java/com/chen/compare/appRelationInfo.json");
		Map<String, Object> serviceApplicationInfoMap = (Map) JSON
				.parse(serviceApplicationInfo);
		HashSet set = new HashSet();
		for (Map.Entry<String, Object> entry : serviceApplicationInfoMap.entrySet()) {
			//进入第一层Json
			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
			Object s1 = entry.getValue();
			Map<String, Object> test = (Map) JSON.parse(s1.toString());
			ArrayList<String> providerList = new ArrayList();
			ArrayList<String> consumerList = new ArrayList();
			Stack<String> providerStack = new Stack();
			Stack<String> consumerStack = new Stack();

			for (Map.Entry<String, Object> entry2 : test.entrySet()) {
				//进入第二层JSON
				String key = entry2.getKey();
				String value = entry2.getValue().toString();
				System.out.println("key= " + entry2.getKey() + " and value= " + entry2.getValue());
				if ("provider".equals(key)) {
					String providerName = StringUtils.strip(value, "\"[]\"");
					providerStack.push(providerName);
					providerList.add(providerName);
				}
				if ("consumer".equals(key)) {
					String[] consumerNames = StringUtils
							.strip(value, "\"[]\"")
							.split("\",\"");
					for (String consumerName : consumerNames) {
						consumerStack.push(consumerName);
						consumerList.add(consumerName);
					}
				}
			}
			//将providername+consumername做去重处理，如果set中存在，则跳出本次循环
			String pop1 = providerStack.pop();
			Boolean flag = true;
			for (int i = 0; i < consumerStack.size(); i++) {
				String pop2 = consumerStack.pop();
				flag = set.add(pop1 + pop2);
				if (!flag && consumerStack.size() > 1) {
					consumerList.remove(pop2);
				}
				if (!flag) {
					providerList.clear();
					consumerList.clear();
				}
			}
			for (int i = 0; i < providerList.size(); i++) {
				for (int j = 0; j < consumerList.size(); j++) {
					if(StringUtils.isEmpty(providerList.get(i))){
						break;
					}
					JSONObject edge = new JSONObject(true);
					edge.put("source", consumerList.get(j));
					edge.put("target", providerList.get(i));
					edgeLists.add(edge);
				}
			}
		}

		linkJson.put("nodes", JSONObject.parseArray(JSON.toJSONString(nodeLists)));
		linkJson.put("edges", JSONObject.parseArray(JSON.toJSONString(edgeLists)));

//		String JSONData = JSONObject.toJSONString(linkJson);
		writeJsonFile(JSONObject.toJSONString(linkJson), "/Users/erebus/IO/JSONData.json");
	}

	public static AtomicInteger[] polymerizationDataLeft(Map<String, Object> map,
			ArrayList nodeLists, int intervalX, int intervalY, AtomicInteger coordinateInitialX,
			AtomicInteger coordinateInitialY) {
		int coordinateX = coordinateInitialX.get();
		//保留当前的Y轴坐标在同一层级下，Y轴初始值一致
		AtomicInteger coordinateY = new AtomicInteger(coordinateInitialY.get());
		AtomicInteger maxCurrentX = new AtomicInteger(coordinateX);

		int Maxsize = map.size() / 2 + 1;
		String id = "id";
		int count = 1;
		for (String key : map.keySet()) {
			JSONObject jsonObject = new JSONObject(true);
			jsonObject.put(id, key);
			int CurrentX = coordinateInitialX.getAndAdd(intervalX);
			jsonObject.put("x", CurrentX);
			//取最大的x边界存入当前的x轴，作为返回值返回
			maxCurrentX.set(Math.max(maxCurrentX.get(), CurrentX));
			jsonObject.put("y", coordinateInitialY.get());
			count++;
			nodeLists.add(jsonObject);
			if (count > Maxsize) {
				coordinateInitialX.set(coordinateX);
				coordinateInitialY.getAndAdd(intervalY);
				//重置计数器
				count = 1;
			}
		}
		System.out.println();
		return new AtomicInteger[]{maxCurrentX, coordinateY};
	}

	public static void polymerizationDataRight(Map<String, Object> map, ArrayList nodeLists,
			int intervalX, int intervalY, AtomicInteger coordinateInitialX,
			AtomicInteger coordinateInitialY, AtomicInteger initSize) {
//		intervalY=intervalY+200;
		coordinateInitialX.set(initSize.get());
		coordinateInitialY.getAndAdd(200);

		int Maxsize = map.size() / 2;
		String id = "id";
		int count = 1;
		for (String key : map.keySet()) {
			JSONObject jsonObject = new JSONObject(true);
			jsonObject.put(id, key);
			jsonObject.put("x", coordinateInitialX.getAndAdd(intervalX));
			jsonObject.put("y", coordinateInitialY.get());
			count++;
			nodeLists.add(jsonObject);
			if (count > Maxsize) {
				coordinateInitialX.set(200);
				coordinateInitialY.getAndAdd(intervalY);
				//重置计数器
				count = 1;
			}
		}
		System.out.println();
	}

	public static Map JsonToMap(String filePath) {
		String s = readJsonFile(filePath);
		Map<String, Object> map = (Map) JSON.parse(s);
		return map;
	}


	public static void writeJsonFile(String fileData, String filePath) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
			out.write(fileData);
			out.close();
			System.out.println("文件创建成功！");
		} catch (IOException e) {
		}
	}

	public static String getRandom(int min, int max) {
		Random random = new Random();
		int s = random.nextInt(max) % (max - min + 1) + min;
		return String.valueOf(s);
	}

	public static String readJsonFile(String fileName) {
		String jsonStr = "";
		try {
			File jsonFile = new File(fileName);
			FileReader fileReader = new FileReader(jsonFile);
			Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
			int ch = 0;
			StringBuffer sb = new StringBuffer();
			while ((ch = reader.read()) != -1) {
				sb.append((char) ch);
			}
			fileReader.close();
			reader.close();
			jsonStr = sb.toString();
			return jsonStr;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
			
		}
	}
}
