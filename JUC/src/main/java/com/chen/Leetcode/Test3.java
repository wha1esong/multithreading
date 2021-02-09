package com.chen.Leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description :   .
 *
 * @author : chenyuxiang
 * @date : Created in 2021/1/28 9:58 上午
 */
public class Test3 {

	public static void main(String[] args) {
		String s="{\"code\":\"340500\",\"name\":\"马鞍山市\"}";
		Map map= JSON.parseObject(s);
		ArrayList<Map> lists = new ArrayList<>();
		lists.add(map);
		HashMap<String, List> map2 = new HashMap<>();
		map2.put("A",lists);
		System.out.println();
		map2.forEach((k,v)->{
			 v.removeIf(l->
					JSON.parseObject(l.toString()).entrySet().removeIf(f->f.getValue().equals("340500"))
			);
		});
		System.out.println();
		lists.removeIf(i->{
			return JSON.parseObject(i.toString()).entrySet().removeIf(f->f.getValue().equals("340500"));
		});
		System.out.println();
	}
}
