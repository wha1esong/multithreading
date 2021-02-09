package com.chen.Leetcode;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description :   .
 *
 * @author : chenyuxiang
 * @date : Created in 2021/1/28 9:21 上午
 */
public class Test2 {

	public static void main(String[] args) {
		String s="{\"code\":\"340500\",\"name\":\"马鞍山市\"}";
		Map map=JSON.parseObject(s);
		ArrayList<Map> lists = new ArrayList<>();
		lists.add(map);

		lists.removeIf(i->{
			return JSON.parseObject(i.toString()).entrySet().removeIf(f->f.getValue().equals("340500"));
			});



	}

}
