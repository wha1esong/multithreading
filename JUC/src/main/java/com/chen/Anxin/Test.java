package com.chen.Anxin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description :   .
 *
 * @author : chenyuxiang
 * @date : Created in 2021/2/3 4:51 下午
 */
public class Test {
	public static void main(String[] args) {
		String letter="{\"a\":[{\"code\":\"513200\",\"name\":\"\\u963f\\u575d\\u85cf\\u65cf\\u7f8c\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"652900\",\"name\":\"\\u963f\\u514b\\u82cf\\u5730\\u533a\"},{\"code\":\"152900\",\"name\":\"\\u963f\\u62c9\\u5584\\u76df\"},{\"code\":\"654300\",\"name\":\"\\u963f\\u52d2\\u6cf0\\u5730\\u533a\"},{\"code\":\"542500\",\"name\":\"\\u963f\\u91cc\\u5730\\u533a\"},{\"code\":\"610900\",\"name\":\"\\u5b89\\u5eb7\"},{\"code\":\"340800\",\"name\":\"\\u5b89\\u5e86\"},{\"code\":\"210300\",\"name\":\"\\u978d\\u5c71\"},{\"code\":\"520400\",\"name\":\"\\u5b89\\u987a\"},{\"code\":\"410500\",\"name\":\"\\u5b89\\u9633\"},{\"code\":\"820100\",\"name\":\"\\u6fb3\\u95e8\\u7279\\u522b\\u884c\\u653f\\u533a\"}],\"b\":[{\"code\":\"220800\",\"name\":\"\\u767d\\u57ce\"},{\"code\":\"451000\",\"name\":\"\\u767e\\u8272\"},{\"code\":\"220600\",\"name\":\"\\u767d\\u5c71\"},{\"code\":\"620400\",\"name\":\"\\u767d\\u94f6\"},{\"code\":\"340300\",\"name\":\"\\u868c\\u57e0\"},{\"code\":\"130600\",\"name\":\"\\u4fdd\\u5b9a\"},{\"code\":\"610300\",\"name\":\"\\u5b9d\\u9e21\"},{\"code\":\"530500\",\"name\":\"\\u4fdd\\u5c71\"},{\"code\":\"150200\",\"name\":\"\\u5305\\u5934\"},{\"code\":\"150800\",\"name\":\"\\u5df4\\u5f66\\u6dd6\\u5c14\"},{\"code\":\"652800\",\"name\":\"\\u5df4\\u97f3\\u90ed\\u695e\\u8499\\u53e4\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"511900\",\"name\":\"\\u5df4\\u4e2d\"},{\"code\":\"450500\",\"name\":\"\\u5317\\u6d77\"},{\"code\":\"110100\",\"name\":\"\\u5317\\u4eac\"},{\"code\":\"210500\",\"name\":\"\\u672c\\u6eaa\"},{\"code\":\"520500\",\"name\":\"\\u6bd5\\u8282\"},{\"code\":\"371600\",\"name\":\"\\u6ee8\\u5dde\"},{\"code\":\"652700\",\"name\":\"\\u535a\\u5c14\\u5854\\u62c9\\u8499\\u53e4\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"341600\",\"name\":\"\\u4eb3\\u5dde\"}],\"c\":[{\"code\":\"430100\",\"name\":\"\\u957f\\u6c99\"},{\"code\":\"130900\",\"name\":\"\\u6ca7\\u5dde\"},{\"code\":\"220100\",\"name\":\"\\u957f\\u6625\"},{\"code\":\"140400\",\"name\":\"\\u957f\\u6cbb\"},{\"code\":\"430700\",\"name\":\"\\u5e38\\u5fb7\"},{\"code\":\"540300\",\"name\":\"\\u660c\\u90fd\"},{\"code\":\"652300\",\"name\":\"\\u660c\\u5409\\u56de\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"320400\",\"name\":\"\\u5e38\\u5dde\"},{\"code\":\"211300\",\"name\":\"\\u671d\\u9633\"},{\"code\":\"445100\",\"name\":\"\\u6f6e\\u5dde\"},{\"code\":\"130800\",\"name\":\"\\u627f\\u5fb7\"},{\"code\":\"510100\",\"name\":\"\\u6210\\u90fd\"},{\"code\":\"431000\",\"name\":\"\\u90f4\\u5dde\"},{\"code\":\"150400\",\"name\":\"\\u8d64\\u5cf0\"},{\"code\":\"341700\",\"name\":\"\\u6c60\\u5dde\"},{\"code\":\"500100\",\"name\":\"\\u91cd\\u5e86\"},{\"code\":\"451400\",\"name\":\"\\u5d07\\u5de6\"},{\"code\":\"532300\",\"name\":\"\\u695a\\u96c4\\u5f5d\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"341100\",\"name\":\"\\u6ec1\\u5dde\"}],\"d\":[{\"code\":\"210200\",\"name\":\"\\u5927\\u8fde\"},{\"code\":\"532900\",\"name\":\"\\u5927\\u7406\\u767d\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"210600\",\"name\":\"\\u4e39\\u4e1c\"},{\"code\":\"460400\",\"name\":\"\\u510b\\u5dde\"},{\"code\":\"230600\",\"name\":\"\\u5927\\u5e86\"},{\"code\":\"140200\",\"name\":\"\\u5927\\u540c\"},{\"code\":\"232700\",\"name\":\"\\u5927\\u5174\\u5b89\\u5cad\\u5730\\u533a\"},{\"code\":\"511700\",\"name\":\"\\u8fbe\\u5dde\"},{\"code\":\"533100\",\"name\":\"\\u5fb7\\u5b8f\\u50a3\\u65cf\\u666f\\u9887\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"510600\",\"name\":\"\\u5fb7\\u9633\"},{\"code\":\"371400\",\"name\":\"\\u5fb7\\u5dde\"},{\"code\":\"621100\",\"name\":\"\\u5b9a\\u897f\"},{\"code\":\"533400\",\"name\":\"\\u8fea\\u5e86\\u85cf\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"441900\",\"name\":\"\\u4e1c\\u839e\"},{\"code\":\"370500\",\"name\":\"\\u4e1c\\u8425\"}],\"e\":[{\"code\":\"150600\",\"name\":\"\\u9102\\u5c14\\u591a\\u65af\"},{\"code\":\"422800\",\"name\":\"\\u6069\\u65bd\\u571f\\u5bb6\\u65cf\\u82d7\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"420700\",\"name\":\"\\u9102\\u5dde\"}],\"f\":[{\"code\":\"450600\",\"name\":\"\\u9632\\u57ce\\u6e2f\"},{\"code\":\"440600\",\"name\":\"\\u4f5b\\u5c71\"},{\"code\":\"210400\",\"name\":\"\\u629a\\u987a\"},{\"code\":\"210900\",\"name\":\"\\u961c\\u65b0\"},{\"code\":\"341200\",\"name\":\"\\u961c\\u9633\"},{\"code\":\"350100\",\"name\":\"\\u798f\\u5dde\"},{\"code\":\"361000\",\"name\":\"\\u629a\\u5dde\"}],\"g\":[{\"code\":\"623000\",\"name\":\"\\u7518\\u5357\\u85cf\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"360700\",\"name\":\"\\u8d63\\u5dde\"},{\"code\":\"513300\",\"name\":\"\\u7518\\u5b5c\\u85cf\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"511600\",\"name\":\"\\u5e7f\\u5b89\"},{\"code\":\"510800\",\"name\":\"\\u5e7f\\u5143\"},{\"code\":\"440100\",\"name\":\"\\u5e7f\\u5dde\"},{\"code\":\"450800\",\"name\":\"\\u8d35\\u6e2f\"},{\"code\":\"450300\",\"name\":\"\\u6842\\u6797\"},{\"code\":\"520100\",\"name\":\"\\u8d35\\u9633\"},{\"code\":\"632600\",\"name\":\"\\u679c\\u6d1b\\u85cf\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"640400\",\"name\":\"\\u56fa\\u539f\"}],\"h\":[{\"code\":\"230100\",\"name\":\"\\u54c8\\u5c14\\u6ee8\"},{\"code\":\"632200\",\"name\":\"\\u6d77\\u5317\\u85cf\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"630200\",\"name\":\"\\u6d77\\u4e1c\"},{\"code\":\"460100\",\"name\":\"\\u6d77\\u53e3\"},{\"code\":\"632500\",\"name\":\"\\u6d77\\u5357\\u85cf\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"632800\",\"name\":\"\\u6d77\\u897f\\u8499\\u53e4\\u65cf\\u85cf\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"650500\",\"name\":\"\\u54c8\\u5bc6\"},{\"code\":\"130400\",\"name\":\"\\u90af\\u90f8\"},{\"code\":\"330100\",\"name\":\"\\u676d\\u5dde\"},{\"code\":\"610700\",\"name\":\"\\u6c49\\u4e2d\"},{\"code\":\"410600\",\"name\":\"\\u9e64\\u58c1\"},{\"code\":\"451200\",\"name\":\"\\u6cb3\\u6c60\"},{\"code\":\"340100\",\"name\":\"\\u5408\\u80a5\"},{\"code\":\"230400\",\"name\":\"\\u9e64\\u5c97\"},{\"code\":\"231100\",\"name\":\"\\u9ed1\\u6cb3\"},{\"code\":\"131100\",\"name\":\"\\u8861\\u6c34\"},{\"code\":\"430400\",\"name\":\"\\u8861\\u9633\"},{\"code\":\"653200\",\"name\":\"\\u548c\\u7530\\u5730\\u533a\"},{\"code\":\"441600\",\"name\":\"\\u6cb3\\u6e90\"},{\"code\":\"371700\",\"name\":\"\\u83cf\\u6cfd\"},{\"code\":\"451100\",\"name\":\"\\u8d3a\\u5dde\"},{\"code\":\"532500\",\"name\":\"\\u7ea2\\u6cb3\\u54c8\\u5c3c\\u65cf\\u5f5d\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"320800\",\"name\":\"\\u6dee\\u5b89\"},{\"code\":\"340600\",\"name\":\"\\u6dee\\u5317\"},{\"code\":\"431200\",\"name\":\"\\u6000\\u5316\"},{\"code\":\"340400\",\"name\":\"\\u6dee\\u5357\"},{\"code\":\"421100\",\"name\":\"\\u9ec4\\u5188\"},{\"code\":\"632300\",\"name\":\"\\u9ec4\\u5357\\u85cf\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"341000\",\"name\":\"\\u9ec4\\u5c71\"},{\"code\":\"420200\",\"name\":\"\\u9ec4\\u77f3\"},{\"code\":\"150100\",\"name\":\"\\u547c\\u548c\\u6d69\\u7279\"},{\"code\":\"441300\",\"name\":\"\\u60e0\\u5dde\"},{\"code\":\"211400\",\"name\":\"\\u846b\\u82a6\\u5c9b\"},{\"code\":\"150700\",\"name\":\"\\u547c\\u4f26\\u8d1d\\u5c14\"},{\"code\":\"330500\",\"name\":\"\\u6e56\\u5dde\"}],\"j\":[{\"code\":\"230800\",\"name\":\"\\u4f73\\u6728\\u65af\"},{\"code\":\"440700\",\"name\":\"\\u6c5f\\u95e8\"},{\"code\":\"360800\",\"name\":\"\\u5409\\u5b89\"},{\"code\":\"410800\",\"name\":\"\\u7126\\u4f5c\"},{\"code\":\"330400\",\"name\":\"\\u5609\\u5174\"},{\"code\":\"620200\",\"name\":\"\\u5609\\u5cea\\u5173\"},{\"code\":\"445200\",\"name\":\"\\u63ed\\u9633\"},{\"code\":\"220200\",\"name\":\"\\u5409\\u6797\"},{\"code\":\"370100\",\"name\":\"\\u6d4e\\u5357\"},{\"code\":\"620300\",\"name\":\"\\u91d1\\u660c\"},{\"code\":\"140500\",\"name\":\"\\u664b\\u57ce\"},{\"code\":\"360200\",\"name\":\"\\u666f\\u5fb7\\u9547\"},{\"code\":\"420800\",\"name\":\"\\u8346\\u95e8\"},{\"code\":\"421000\",\"name\":\"\\u8346\\u5dde\"},{\"code\":\"330700\",\"name\":\"\\u91d1\\u534e\"},{\"code\":\"370800\",\"name\":\"\\u6d4e\\u5b81\"},{\"code\":\"140700\",\"name\":\"\\u664b\\u4e2d\"},{\"code\":\"210700\",\"name\":\"\\u9526\\u5dde\"},{\"code\":\"360400\",\"name\":\"\\u4e5d\\u6c5f\"},{\"code\":\"620900\",\"name\":\"\\u9152\\u6cc9\"},{\"code\":\"230300\",\"name\":\"\\u9e21\\u897f\"}],\"k\":[{\"code\":\"410200\",\"name\":\"\\u5f00\\u5c01\"},{\"code\":\"653100\",\"name\":\"\\u5580\\u4ec0\\u5730\\u533a\"},{\"code\":\"650200\",\"name\":\"\\u514b\\u62c9\\u739b\\u4f9d\"},{\"code\":\"653000\",\"name\":\"\\u514b\\u5b5c\\u52d2\\u82cf\\u67ef\\u5c14\\u514b\\u5b5c\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"530100\",\"name\":\"\\u6606\\u660e\"}],\"l\":[{\"code\":\"451300\",\"name\":\"\\u6765\\u5bbe\"},{\"code\":\"131000\",\"name\":\"\\u5eca\\u574a\"},{\"code\":\"620100\",\"name\":\"\\u5170\\u5dde\"},{\"code\":\"540100\",\"name\":\"\\u62c9\\u8428\"},{\"code\":\"511100\",\"name\":\"\\u4e50\\u5c71\"},{\"code\":\"513400\",\"name\":\"\\u51c9\\u5c71\\u5f5d\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"320700\",\"name\":\"\\u8fde\\u4e91\\u6e2f\"},{\"code\":\"371500\",\"name\":\"\\u804a\\u57ce\"},{\"code\":\"211000\",\"name\":\"\\u8fbd\\u9633\"},{\"code\":\"220400\",\"name\":\"\\u8fbd\\u6e90\"},{\"code\":\"530700\",\"name\":\"\\u4e3d\\u6c5f\"},{\"code\":\"530900\",\"name\":\"\\u4e34\\u6ca7\"},{\"code\":\"141000\",\"name\":\"\\u4e34\\u6c7e\"},{\"code\":\"622900\",\"name\":\"\\u4e34\\u590f\\u56de\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"371300\",\"name\":\"\\u4e34\\u6c82\"},{\"code\":\"540400\",\"name\":\"\\u6797\\u829d\"},{\"code\":\"331100\",\"name\":\"\\u4e3d\\u6c34\"},{\"code\":\"341500\",\"name\":\"\\u516d\\u5b89\"},{\"code\":\"520200\",\"name\":\"\\u516d\\u76d8\\u6c34\"},{\"code\":\"450200\",\"name\":\"\\u67f3\\u5dde\"},{\"code\":\"621200\",\"name\":\"\\u9647\\u5357\"},{\"code\":\"350800\",\"name\":\"\\u9f99\\u5ca9\"},{\"code\":\"431300\",\"name\":\"\\u5a04\\u5e95\"},{\"code\":\"411100\",\"name\":\"\\u6f2f\\u6cb3\"},{\"code\":\"410300\",\"name\":\"\\u6d1b\\u9633\"},{\"code\":\"510500\",\"name\":\"\\u6cf8\\u5dde\"},{\"code\":\"141100\",\"name\":\"\\u5415\\u6881\"}],\"m\":[{\"code\":\"340500\",\"name\":\"\\u9a6c\\u978d\\u5c71\"},{\"code\":\"440900\",\"name\":\"\\u8302\\u540d\"},{\"code\":\"511400\",\"name\":\"\\u7709\\u5c71\"},{\"code\":\"441400\",\"name\":\"\\u6885\\u5dde\"},{\"code\":\"510700\",\"name\":\"\\u7ef5\\u9633\"},{\"code\":\"231000\",\"name\":\"\\u7261\\u4e39\\u6c5f\"}],\"n\":[{\"code\":\"360100\",\"name\":\"\\u5357\\u660c\"},{\"code\":\"511300\",\"name\":\"\\u5357\\u5145\"},{\"code\":\"320100\",\"name\":\"\\u5357\\u4eac\"},{\"code\":\"450100\",\"name\":\"\\u5357\\u5b81\"},{\"code\":\"350700\",\"name\":\"\\u5357\\u5e73\"},{\"code\":\"320600\",\"name\":\"\\u5357\\u901a\"},{\"code\":\"411300\",\"name\":\"\\u5357\\u9633\"},{\"code\":\"511000\",\"name\":\"\\u5185\\u6c5f\"},{\"code\":\"540600\",\"name\":\"\\u90a3\\u66f2\"},{\"code\":\"330200\",\"name\":\"\\u5b81\\u6ce2\"},{\"code\":\"350900\",\"name\":\"\\u5b81\\u5fb7\"},{\"code\":\"533300\",\"name\":\"\\u6012\\u6c5f\\u5088\\u50f3\\u65cf\\u81ea\\u6cbb\\u5dde\"}],\"p\":[{\"code\":\"211100\",\"name\":\"\\u76d8\\u9526\"},{\"code\":\"510400\",\"name\":\"\\u6500\\u679d\\u82b1\"},{\"code\":\"410400\",\"name\":\"\\u5e73\\u9876\\u5c71\"},{\"code\":\"620800\",\"name\":\"\\u5e73\\u51c9\"},{\"code\":\"360300\",\"name\":\"\\u840d\\u4e61\"},{\"code\":\"530800\",\"name\":\"\\u666e\\u6d31\"},{\"code\":\"350300\",\"name\":\"\\u8386\\u7530\"},{\"code\":\"410900\",\"name\":\"\\u6fee\\u9633\"}],\"q\":[{\"code\":\"522600\",\"name\":\"\\u9ed4\\u4e1c\\u5357\\u82d7\\u65cf\\u4f97\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"522700\",\"name\":\"\\u9ed4\\u5357\\u5e03\\u4f9d\\u65cf\\u82d7\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"522300\",\"name\":\"\\u9ed4\\u897f\\u5357\\u5e03\\u4f9d\\u65cf\\u82d7\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"370200\",\"name\":\"\\u9752\\u5c9b\"},{\"code\":\"621000\",\"name\":\"\\u5e86\\u9633\"},{\"code\":\"441800\",\"name\":\"\\u6e05\\u8fdc\"},{\"code\":\"130300\",\"name\":\"\\u79e6\\u7687\\u5c9b\"},{\"code\":\"450700\",\"name\":\"\\u94a6\\u5dde\"},{\"code\":\"230200\",\"name\":\"\\u9f50\\u9f50\\u54c8\\u5c14\"},{\"code\":\"230900\",\"name\":\"\\u4e03\\u53f0\\u6cb3\"},{\"code\":\"350500\",\"name\":\"\\u6cc9\\u5dde\"},{\"code\":\"530300\",\"name\":\"\\u66f2\\u9756\"},{\"code\":\"330800\",\"name\":\"\\u8862\\u5dde\"}],\"r\":[{\"code\":\"540200\",\"name\":\"\\u65e5\\u5580\\u5219\"},{\"code\":\"371100\",\"name\":\"\\u65e5\\u7167\"}],\"s\":[{\"code\":\"411200\",\"name\":\"\\u4e09\\u95e8\\u5ce1\"},{\"code\":\"350400\",\"name\":\"\\u4e09\\u660e\"},{\"code\":\"460300\",\"name\":\"\\u4e09\\u6c99\"},{\"code\":\"460200\",\"name\":\"\\u4e09\\u4e9a\"},{\"code\":\"310100\",\"name\":\"\\u4e0a\\u6d77\"},{\"code\":\"611000\",\"name\":\"\\u5546\\u6d1b\"},{\"code\":\"411400\",\"name\":\"\\u5546\\u4e18\"},{\"code\":\"361100\",\"name\":\"\\u4e0a\\u9976\"},{\"code\":\"540500\",\"name\":\"\\u5c71\\u5357\"},{\"code\":\"440500\",\"name\":\"\\u6c55\\u5934\"},{\"code\":\"441500\",\"name\":\"\\u6c55\\u5c3e\"},{\"code\":\"440200\",\"name\":\"\\u97f6\\u5173\"},{\"code\":\"330600\",\"name\":\"\\u7ecd\\u5174\"},{\"code\":\"430500\",\"name\":\"\\u90b5\\u9633\"},{\"code\":\"210100\",\"name\":\"\\u6c88\\u9633\"},{\"code\":\"440300\",\"name\":\"\\u6df1\\u5733\"},{\"code\":\"130100\",\"name\":\"\\u77f3\\u5bb6\\u5e84\"},{\"code\":\"420300\",\"name\":\"\\u5341\\u5830\"},{\"code\":\"640200\",\"name\":\"\\u77f3\\u5634\\u5c71\"},{\"code\":\"230500\",\"name\":\"\\u53cc\\u9e2d\\u5c71\"},{\"code\":\"140600\",\"name\":\"\\u6714\\u5dde\"},{\"code\":\"220300\",\"name\":\"\\u56db\\u5e73\"},{\"code\":\"220700\",\"name\":\"\\u677e\\u539f\"},{\"code\":\"231200\",\"name\":\"\\u7ee5\\u5316\"},{\"code\":\"510900\",\"name\":\"\\u9042\\u5b81\"},{\"code\":\"421300\",\"name\":\"\\u968f\\u5dde\"},{\"code\":\"321300\",\"name\":\"\\u5bbf\\u8fc1\"},{\"code\":\"341300\",\"name\":\"\\u5bbf\\u5dde\"},{\"code\":\"320500\",\"name\":\"\\u82cf\\u5dde\"}],\"t\":[{\"code\":\"654200\",\"name\":\"\\u5854\\u57ce\\u5730\\u533a\"},{\"code\":\"370900\",\"name\":\"\\u6cf0\\u5b89\"},{\"code\":\"710100\",\"name\":\"\\u53f0\\u6e7e\\u7701\"},{\"code\":\"140100\",\"name\":\"\\u592a\\u539f\"},{\"code\":\"321200\",\"name\":\"\\u6cf0\\u5dde\"},{\"code\":\"331000\",\"name\":\"\\u53f0\\u5dde\"},{\"code\":\"130200\",\"name\":\"\\u5510\\u5c71\"},{\"code\":\"120100\",\"name\":\"\\u5929\\u6d25\"},{\"code\":\"620500\",\"name\":\"\\u5929\\u6c34\"},{\"code\":\"211200\",\"name\":\"\\u94c1\\u5cad\"},{\"code\":\"610200\",\"name\":\"\\u94dc\\u5ddd\"},{\"code\":\"220500\",\"name\":\"\\u901a\\u5316\"},{\"code\":\"150500\",\"name\":\"\\u901a\\u8fbd\"},{\"code\":\"340700\",\"name\":\"\\u94dc\\u9675\"},{\"code\":\"520600\",\"name\":\"\\u94dc\\u4ec1\"},{\"code\":\"650400\",\"name\":\"\\u5410\\u9c81\\u756a\"}],\"w\":[{\"code\":\"370700\",\"name\":\"\\u6f4d\\u574a\"},{\"code\":\"371000\",\"name\":\"\\u5a01\\u6d77\"},{\"code\":\"610500\",\"name\":\"\\u6e2d\\u5357\"},{\"code\":\"532600\",\"name\":\"\\u6587\\u5c71\\u58ee\\u65cf\\u82d7\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"330300\",\"name\":\"\\u6e29\\u5dde\"},{\"code\":\"150300\",\"name\":\"\\u4e4c\\u6d77\"},{\"code\":\"420100\",\"name\":\"\\u6b66\\u6c49\"},{\"code\":\"340200\",\"name\":\"\\u829c\\u6e56\"},{\"code\":\"150900\",\"name\":\"\\u4e4c\\u5170\\u5bdf\\u5e03\"},{\"code\":\"650100\",\"name\":\"\\u4e4c\\u9c81\\u6728\\u9f50\"},{\"code\":\"620600\",\"name\":\"\\u6b66\\u5a01\"},{\"code\":\"320200\",\"name\":\"\\u65e0\\u9521\"},{\"code\":\"640300\",\"name\":\"\\u5434\\u5fe0\"},{\"code\":\"450400\",\"name\":\"\\u68a7\\u5dde\"}],\"x\":[{\"code\":\"350200\",\"name\":\"\\u53a6\\u95e8\"},{\"code\":\"810100\",\"name\":\"\\u9999\\u6e2f\\u7279\\u522b\\u884c\\u653f\\u533a\"},{\"code\":\"430300\",\"name\":\"\\u6e58\\u6f6d\"},{\"code\":\"433100\",\"name\":\"\\u6e58\\u897f\\u571f\\u5bb6\\u65cf\\u82d7\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"420600\",\"name\":\"\\u8944\\u9633\"},{\"code\":\"421200\",\"name\":\"\\u54b8\\u5b81\"},{\"code\":\"610100\",\"name\":\"\\u897f\\u5b89\"},{\"code\":\"610400\",\"name\":\"\\u54b8\\u9633\"},{\"code\":\"420900\",\"name\":\"\\u5b5d\\u611f\"},{\"code\":\"152500\",\"name\":\"\\u9521\\u6797\\u90ed\\u52d2\\u76df\"},{\"code\":\"152200\",\"name\":\"\\u5174\\u5b89\\u76df\"},{\"code\":\"130500\",\"name\":\"\\u90a2\\u53f0\"},{\"code\":\"630100\",\"name\":\"\\u897f\\u5b81\"},{\"code\":\"410700\",\"name\":\"\\u65b0\\u4e61\"},{\"code\":\"411500\",\"name\":\"\\u4fe1\\u9633\"},{\"code\":\"360500\",\"name\":\"\\u65b0\\u4f59\"},{\"code\":\"140900\",\"name\":\"\\u5ffb\\u5dde\"},{\"code\":\"532800\",\"name\":\"\\u897f\\u53cc\\u7248\\u7eb3\\u50a3\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"341800\",\"name\":\"\\u5ba3\\u57ce\"},{\"code\":\"411000\",\"name\":\"\\u8bb8\\u660c\"},{\"code\":\"320300\",\"name\":\"\\u5f90\\u5dde\"}],\"y\":[{\"code\":\"511800\",\"name\":\"\\u96c5\\u5b89\"},{\"code\":\"610600\",\"name\":\"\\u5ef6\\u5b89\"},{\"code\":\"222400\",\"name\":\"\\u5ef6\\u8fb9\\u671d\\u9c9c\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"320900\",\"name\":\"\\u76d0\\u57ce\"},{\"code\":\"441700\",\"name\":\"\\u9633\\u6c5f\"},{\"code\":\"140300\",\"name\":\"\\u9633\\u6cc9\"},{\"code\":\"321000\",\"name\":\"\\u626c\\u5dde\"},{\"code\":\"370600\",\"name\":\"\\u70df\\u53f0\"},{\"code\":\"511500\",\"name\":\"\\u5b9c\\u5bbe\"},{\"code\":\"420500\",\"name\":\"\\u5b9c\\u660c\"},{\"code\":\"230700\",\"name\":\"\\u4f0a\\u6625\"},{\"code\":\"360900\",\"name\":\"\\u5b9c\\u6625\"},{\"code\":\"654000\",\"name\":\"\\u4f0a\\u7281\\u54c8\\u8428\\u514b\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"640100\",\"name\":\"\\u94f6\\u5ddd\"},{\"code\":\"210800\",\"name\":\"\\u8425\\u53e3\"},{\"code\":\"360600\",\"name\":\"\\u9e70\\u6f6d\"},{\"code\":\"430900\",\"name\":\"\\u76ca\\u9633\"},{\"code\":\"431100\",\"name\":\"\\u6c38\\u5dde\"},{\"code\":\"430600\",\"name\":\"\\u5cb3\\u9633\"},{\"code\":\"450900\",\"name\":\"\\u7389\\u6797\"},{\"code\":\"610800\",\"name\":\"\\u6986\\u6797\"},{\"code\":\"140800\",\"name\":\"\\u8fd0\\u57ce\"},{\"code\":\"445300\",\"name\":\"\\u4e91\\u6d6e\"},{\"code\":\"632700\",\"name\":\"\\u7389\\u6811\\u85cf\\u65cf\\u81ea\\u6cbb\\u5dde\"},{\"code\":\"530400\",\"name\":\"\\u7389\\u6eaa\"}],\"z\":[{\"code\":\"370400\",\"name\":\"\\u67a3\\u5e84\"},{\"code\":\"430800\",\"name\":\"\\u5f20\\u5bb6\\u754c\"},{\"code\":\"130700\",\"name\":\"\\u5f20\\u5bb6\\u53e3\"},{\"code\":\"620700\",\"name\":\"\\u5f20\\u6396\"},{\"code\":\"350600\",\"name\":\"\\u6f33\\u5dde\"},{\"code\":\"440800\",\"name\":\"\\u6e5b\\u6c5f\"},{\"code\":\"441200\",\"name\":\"\\u8087\\u5e86\"},{\"code\":\"530600\",\"name\":\"\\u662d\\u901a\"},{\"code\":\"410100\",\"name\":\"\\u90d1\\u5dde\"},{\"code\":\"321100\",\"name\":\"\\u9547\\u6c5f\"},{\"code\":\"442000\",\"name\":\"\\u4e2d\\u5c71\"},{\"code\":\"640500\",\"name\":\"\\u4e2d\\u536b\"},{\"code\":\"411600\",\"name\":\"\\u5468\\u53e3\"},{\"code\":\"330900\",\"name\":\"\\u821f\\u5c71\"},{\"code\":\"440400\",\"name\":\"\\u73e0\\u6d77\"},{\"code\":\"411700\",\"name\":\"\\u9a7b\\u9a6c\\u5e97\"},{\"code\":\"430200\",\"name\":\"\\u682a\\u6d32\"},{\"code\":\"370300\",\"name\":\"\\u6dc4\\u535a\"},{\"code\":\"510300\",\"name\":\"\\u81ea\\u8d21\"},{\"code\":\"512000\",\"name\":\"\\u8d44\\u9633\"},{\"code\":\"520300\",\"name\":\"\\u9075\\u4e49\"}]}";
		String letterComp="{ \"\\u77f3\\u5bb6\\u5e84\\u5e02\":\"130100\", \"\\u547c\\u4f26\\u8d1d\\u5c14\\u5e02\":\"150700\", \"\\u5927\\u5174\\u5b89\\u5cad\\u5730\\u533a\":\"232700\", \"\\u672c\\u6eaa\\u5e02\":\"210500\", \"\\u671d\\u9633\\u5e02\":\"211300\", \"\\u4e39\\u4e1c\\u5e02\":\"210600\", \"\\u629a\\u987a\\u5e02\":\"210400\", \"\\u961c\\u65b0\\u5e02\":\"210900\", \"\\u846b\\u82a6\\u5c9b\\u5e02\":\"211400\", \"\\u9526\\u5dde\\u5e02\":\"210700\", \"\\u76d8\\u9526\\u5e02\":\"211100\", \"\\u94c1\\u5cad\\u5e02\":\"211200\", \"\\u8425\\u53e3\\u5e02\":\"210800\", \"\\u978d\\u5c71\\u5e02\":\"210300\", \"\\u5927\\u8fde\\u5e02\":\"210200\", \"\\u8fbd\\u9633\\u5e02\":\"211000\", \"\\u5df4\\u5f66\\u6dd6\\u5c14\\u5e02\":\"150800\", \"\\u5305\\u5934\\u5e02\":\"150200\", \"\\u901a\\u8fbd\\u5e02\":\"150500\", \"\\u9521\\u6797\\u90ed\\u52d2\\u76df\":\"152500\", \"\\u547c\\u548c\\u6d69\\u7279\\u5e02\":\"150100\", \"\\u963f\\u62c9\\u5584\\u76df\":\"152900\", \"\\u65e5\\u7167\\u5e02\":\"371100\", \"\\u9752\\u5c9b\\u5e02\":\"370200\", \"\\u6d4e\\u5357\\u5e02\":\"370100\", \"\\u6f4d\\u574a\\u5e02\":\"370700\", \"\\u6d4e\\u5b81\\u5e02\":\"370800\", \"\\u9633\\u6cc9\\u5e02\":\"140300\", \"\\u4e0a\\u6d77\\u5e02\":\"310100\", \"\\u5929\\u6d25\\u5e02\":\"120100\", \"\\u5df4\\u97f3\\u90ed\\u695e\\u8499\\u53e4\\u81ea\\u6cbb\\u5dde\":\"652800\", \"\\u535a\\u5c14\\u5854\\u62c9\\u8499\\u53e4\\u81ea\\u6cbb\\u5dde\":\"652700\", \"\\u660c\\u5409\\u56de\\u65cf\\u81ea\\u6cbb\\u5dde\":\"652300\", \"\\u54c8\\u5bc6\\u5e02\":\"650500\", \"\\u548c\\u7530\\u5730\\u533a\":\"653200\", \"\\u5580\\u4ec0\\u5730\\u533a\":\"653100\", \"\\u5854\\u57ce\\u5730\\u533a\":\"654200\", \"\\u963f\\u52d2\\u6cf0\\u5730\\u533a\":\"654300\", \"\\u80e1\\u6768\\u6cb3\\u5e02\":\"659010\", \"\\u4f0a\\u7281\\u54c8\\u8428\\u514b\\u81ea\\u6cbb\\u5dde\":\"654000\", \"\\u5ef6\\u8fb9\\u671d\\u9c9c\\u65cf\\u81ea\\u6cbb\\u5dde\":\"222400\", \"\\u901a\\u5316\\u5e02\":\"220500\", \"\\u677e\\u539f\\u5e02\":\"220700\", \"\\u957f\\u6625\\u5e02\":\"220100\", \"\\u56db\\u5e73\\u5e02\":\"220300\", \"\\u8fbd\\u6e90\\u5e02\":\"220400\", \"\\u767d\\u57ce\\u5e02\":\"220800\", \"\\u5409\\u6797\\u5e02\":\"220200\", \"\\u5929\\u6c34\\u5e02\":\"620500\", \"\\u5b9a\\u897f\\u5e02\":\"621100\", \"\\u5e86\\u9633\\u5e02\":\"621000\", \"\\u7518\\u5357\\u85cf\\u65cf\\u81ea\\u6cbb\\u5dde\":\"623000\", \"\\u9152\\u6cc9\\u5e02\":\"620900\", \"\\u5f20\\u6396\\u5e02\":\"620700\", \"\\u91d1\\u660c\\u5e02\":\"620300\", \"\\u6b66\\u5a01\\u5e02\":\"620600\", \"\\u5170\\u5dde\\u5e02\":\"620100\", \"\\u767d\\u94f6\\u5e02\":\"620400\", \"\\u5e73\\u51c9\\u5e02\":\"620800\", \"\\u9647\\u5357\\u5e02\":\"621200\", \"\\u5609\\u5cea\\u5173\\u5e02\":\"620200\", \"\\u8d3a\\u5dde\\u5e02\":\"451100\", \"\\u6cb3\\u6e90\\u5e02\":\"441600\", \"\\u9633\\u6c5f\\u5e02\":\"441700\", \"\\u4e91\\u6d6e\\u5e02\":\"445300\", \"\\u6e5b\\u6c5f\\u5e02\":\"440800\", \"\\u6c5f\\u95e8\\u5e02\":\"440700\", \"\\u4e2d\\u5c71\\u5e02\":\"442000\", \"\\u4e1c\\u839e\\u5e02\":\"441900\", \"\\u6df1\\u5733\\u5e02\":\"440300\", \"\\u5357\\u5b81\\u5e02\":\"450100\", \"\\u6d77\\u53e3\\u5e02\":\"460100\", \"\\u67f3\\u5dde\\u5e02\":\"450200\", \"\\u4ed9\\u6843\\u5e02\":\"429004\", \"\\u5f90\\u5dde\\u5e02\":\"320300\", \"\\u666f\\u5fb7\\u9547\\u5e02\":\"360200\", \"\\u5b81\\u5fb7\\u5e02\":\"350900\", \"\\u6d77\\u5317\\u85cf\\u65cf\\u81ea\\u6cbb\\u5dde\":\"632200\", \"\\u6d77\\u4e1c\\u5e02\":\"630200\", \"\\u6d77\\u5357\\u85cf\\u65cf\\u81ea\\u6cbb\\u5dde\":\"632500\", \"\\u6d77\\u897f\\u8499\\u53e4\\u65cf\\u85cf\\u65cf\\u81ea\\u6cbb\\u5dde\":\"632800\", \"\\u9ec4\\u5357\\u85cf\\u65cf\\u81ea\\u6cbb\\u5dde\":\"632300\", \"\\u897f\\u5b81\\u5e02\":\"630100\", \"\\u679c\\u6d1b\\u85cf\\u65cf\\u81ea\\u6cbb\\u5dde\":\"632600\", \"\\u7389\\u6811\\u85cf\\u65cf\\u81ea\\u6cbb\\u5dde\":\"632700\", \"\\u5ef6\\u5b89\\u5e02\":\"610600\", \"\\u6986\\u6797\\u5e02\":\"610800\", \"\\u897f\\u5b89\\u5e02\":\"610100\", \"\\u94dc\\u5ddd\\u5e02\":\"610200\", \"\\u5e7f\\u5143\\u5e02\":\"510800\", \"\\u5df4\\u4e2d\\u5e02\":\"511900\", \"\\u8fbe\\u5dde\\u5e02\":\"511700\", \"\\u7ef5\\u9633\\u5e02\":\"510700\", \"\\u5b9c\\u5bbe\\u5e02\":\"511500\", \"\\u7709\\u5c71\\u5e02\":\"511400\", \"\\u51c9\\u5c71\\u5f5d\\u65cf\\u81ea\\u6cbb\\u5dde\":\"513400\", \"\\u4e50\\u5c71\\u5e02\":\"511100\", \"\\u81ea\\u8d21\\u5e02\":\"510300\", \"\\u5927\\u7406\\u767d\\u65cf\\u81ea\\u6cbb\\u5dde\":\"532900\", \"\\u6587\\u5c71\\u58ee\\u65cf\\u82d7\\u65cf\\u81ea\\u6cbb\\u5dde\":\"532600\", \"\\u4e34\\u6ca7\\u5e02\":\"530900\", \"\\u897f\\u53cc\\u7248\\u7eb3\\u50a3\\u65cf\\u81ea\\u6cbb\\u5dde\":\"532800\", \"\\u6012\\u6c5f\\u5088\\u50f3\\u65cf\\u81ea\\u6cbb\\u5dde\":\"533300\", \"\\u9e64\\u58c1\\u5e02\":\"410600\", \"\\u7126\\u4f5c\\u5e02\":\"410800\", \"\\u5f00\\u5c01\\u5e02\":\"410200\", \"\\u6f2f\\u6cb3\\u5e02\":\"411100\", \"\\u5357\\u9633\\u5e02\":\"411300\", \"\\u5e73\\u9876\\u5c71\\u5e02\":\"410400\", \"\\u4e09\\u95e8\\u5ce1\\u5e02\":\"411200\", \"\\u5546\\u4e18\\u5e02\":\"411400\", \"\\u6d4e\\u6e90\\u5e02\":\"419001\", \"\\u65b0\\u4e61\\u5e02\":\"410700\", \"\\u4fe1\\u9633\\u5e02\":\"411500\", \"\\u90d1\\u5dde\\u5e02\":\"410100\", \"\\u5b89\\u9633\\u5e02\":\"410500\", \"\\u6d1b\\u9633\\u5e02\":\"410300\", \"\\u6bd5\\u8282\\u5e02\":\"520500\", \"\\u682a\\u6d32\\u5e02\":\"430200\", \"\\u6e58\\u6f6d\\u5e02\":\"430300\", \"\\u957f\\u6c99\\u5e02\":\"430100\", \"\\u5cb3\\u9633\\u5e02\":\"430600\", \"\\u6e58\\u897f\\u571f\\u5bb6\\u65cf\\u82d7\\u65cf\\u81ea\\u6cbb\\u5dde\":\"433100\", \"\\u5e38\\u5fb7\\u5e02\":\"430700\", \"\\u8861\\u9633\\u5e02\":\"430400\", \"\\u5a04\\u5e95\\u5e02\":\"431300\", \"\\u6000\\u5316\\u5e02\":\"431200\", \"\\u90f4\\u5dde\\u5e02\":\"431000\", \"\\u76ca\\u9633\\u5e02\":\"430900\", \"\\u6606\\u7389\\u5e02\":\"659009\", \"\\u5609\\u4e49\\u5e02\":\"719003\", \"\\u6843\\u56ed\\u5e02\":\"710600\", \"\\u53f0\\u5317\\u5e02\":\"710100\", \"\\u53f0\\u4e2d\\u5e02\":\"710400\", \"\\u65b0\\u5317\\u5e02\":\"710300\", \"\\u53f0\\u5357\\u5e02\":\"710500\", \"\\u57fa\\u9686\\u5e02\":\"719001\", \"\\u9ad8\\u96c4\\u5e02\":\"710200\", \"\\u65b0\\u7af9\\u5e02\":\"719002\", \"\\u5609\\u4e49\\u53bf\":\"719010\", \"\\u4e91\\u6797\\u53bf\":\"719008\", \"\\u5c4f\\u4e1c\\u53bf\":\"719011\", \"\\u5357\\u6295\\u53bf\":\"719009\", \"\\u82b1\\u83b2\\u53bf\":\"719013\", \"\\u5f70\\u5316\\u53bf\":\"719007\", \"\\u53f0\\u4e1c\\u53bf\":\"719012\", \"\\u5b9c\\u5170\\u53bf\":\"719005\", \"\\u82d7\\u6817\\u53bf\":\"719006\", \"\\u65b0\\u7af9\\u53bf\":\"719004\", \"\\u65e0\\u9521\\u5e02\":\"320200\", \"\\u6c88\\u9633\\u5e02\":\"210100\", \"\\u6c38\\u5dde\\u5e02\":\"431100\", \"\\u90af\\u90f8\\u5e02\":\"130400\", \"\\u91d1\\u534e\\u5e02\":\"330700\", \"\\u53f0\\u5dde\\u5e02\":\"331000\", \"\\u5609\\u5174\\u5e02\":\"330400\", \"\\u82cf\\u5dde\\u5e02\":\"320500\", \"\\u4e3d\\u6c34\\u5e02\":\"331100\", \"\\u8862\\u5dde\\u5e02\":\"330800\", \"\\u5b81\\u6ce2\\u5e02\":\"330200\", \"\\u5f20\\u5bb6\\u754c\\u5e02\":\"430800\", \"\\u9a7b\\u9a6c\\u5e97\\u5e02\":\"411700\", \"\\u5e38\\u5dde\\u5e02\":\"320400\", \"\\u7ecd\\u5174\\u5e02\":\"330600\", \"\\u676d\\u5dde\\u5e02\":\"330100\", \"\\u6e56\\u5dde\\u5e02\":\"330500\", \"\\u6e29\\u5dde\\u5e02\":\"330300\", \"\\u6dee\\u5b89\\u5e02\":\"320800\", \"\\u626c\\u5dde\\u5e02\":\"321000\", \"\\u76d0\\u57ce\\u5e02\":\"320900\", \"\\u8fde\\u4e91\\u6e2f\\u5e02\":\"320700\", \"\\u5bbf\\u8fc1\\u5e02\":\"321300\", \"\\u5357\\u4eac\\u5e02\":\"320100\", \"\\u9547\\u6c5f\\u5e02\":\"321100\", \"\\u6cf0\\u5dde\\u5e02\":\"321200\", \"\\u5357\\u901a\\u5e02\":\"320600\", \"\\u90b5\\u9633\\u5e02\":\"430500\", \"\\u5468\\u53e3\\u5e02\":\"411600\", \"\\u8bb8\\u660c\\u5e02\":\"411000\", \"\\u4e09\\u4e9a\\u5e02\":\"460200\", \"\\u6fee\\u9633\\u5e02\":\"410900\", \"\\u821f\\u5c71\\u5e02\":\"330900\", \"\\u4e07\\u5b81\\u5e02\":\"469006\", \"\\u4e1c\\u65b9\\u5e02\":\"469007\", \"\\u4e34\\u9ad8\\u53bf\":\"469024\", \"\\u4e50\\u4e1c\\u9ece\\u65cf\\u81ea\\u6cbb\\u53bf\":\"469027\", \"\\u4e94\\u6307\\u5c71\\u5e02\":\"469001\", \"\\u4fdd\\u4ead\\u9ece\\u65cf\\u82d7\\u65cf\\u81ea\\u6cbb\\u53bf\":\"469029\", \"\\u510b\\u5dde\\u5e02\":\"460400\", \"\\u5b9a\\u5b89\\u53bf\":\"469021\", \"\\u5c6f\\u660c\\u53bf\":\"469022\", \"\\u6587\\u660c\\u5e02\":\"469005\", \"\\u660c\\u6c5f\\u9ece\\u65cf\\u81ea\\u6cbb\\u53bf\":\"469026\", \"\\u6f84\\u8fc8\\u53bf\":\"469023\", \"\\u743c\\u4e2d\\u9ece\\u65cf\\u82d7\\u65cf\\u81ea\\u6cbb\\u53bf\":\"469030\", \"\\u743c\\u6d77\\u5e02\":\"469002\", \"\\u767d\\u6c99\\u9ece\\u65cf\\u81ea\\u6cbb\\u53bf\":\"469025\", \"\\u9675\\u6c34\\u9ece\\u65cf\\u81ea\\u6cbb\\u53bf\":\"469028\", \"\\u5357\\u660c\\u5e02\":\"360100\", \"\\u629a\\u5dde\\u5e02\":\"361000\", \"\\u65b0\\u4f59\\u5e02\":\"360500\", \"\\u840d\\u4e61\\u5e02\":\"360300\", \"\\u664b\\u57ce\\u5e02\":\"140500\", \"\\u963f\\u514b\\u82cf\\u5730\\u533a\":\"652900\", \"\\u6210\\u90fd\\u5e02\":\"510100\", \"\\u96c5\\u5b89\\u5e02\":\"511800\", \"\\u5fb7\\u9633\\u5e02\":\"510600\", \"\\u963f\\u62c9\\u5c14\\u5e02\":\"659002\", \"\\u514b\\u5b5c\\u52d2\\u82cf\\u67ef\\u5c14\\u514b\\u5b5c\\u81ea\\u6cbb\\u5dde\":\"653000\", \"\\u5317\\u5c6f\\u5e02\":\"659005\", \"\\u963f\\u575d\\u85cf\\u65cf\\u7f8c\\u65cf\\u81ea\\u6cbb\\u5dde\":\"513200\", \"\\u7518\\u5b5c\\u85cf\\u65cf\\u81ea\\u6cbb\\u5dde\":\"513300\", \"\\u5357\\u5145\\u5e02\":\"511300\", \"\\u8d64\\u5cf0\\u5e02\":\"150400\", \"\\u9102\\u5c14\\u591a\\u65af\\u5e02\":\"150600\", \"\\u62c9\\u8428\\u5e02\":\"540100\", \"\\u660c\\u90fd\\u5e02\":\"540300\", \"\\u6797\\u829d\\u5e02\":\"540400\", \"\\u4e5d\\u6c5f\\u5e02\":\"360400\", \"\\u94c1\\u95e8\\u5173\\u5e02\":\"659006\", \"\\u5341\\u5830\\u5e02\":\"420300\", \"\\u5b89\\u5eb7\\u5e02\":\"610900\", \"\\u5546\\u6d1b\\u5e02\":\"611000\", \"\\u8944\\u9633\\u5e02\":\"420600\", \"\\u795e\\u519c\\u67b6\\u6797\\u533a\":\"429021\", \"\\u54b8\\u9633\\u5e02\":\"610400\", \"\\u5b9d\\u9e21\\u5e02\":\"610300\", \"\\u6c49\\u4e2d\\u5e02\":\"610700\", \"\\u6e2d\\u5357\\u5e02\":\"610500\", \"\\u54b8\\u5b81\\u5e02\":\"421200\", \"\\u6069\\u65bd\\u571f\\u5bb6\\u65cf\\u82d7\\u65cf\\u81ea\\u6cbb\\u5dde\":\"422800\", \"\\u4e34\\u6c7e\\u5e02\":\"141000\", \"\\u5927\\u540c\\u5e02\":\"140200\", \"\\u957f\\u6cbb\\u5e02\":\"140400\", \"\\u5b5d\\u611f\\u5e02\":\"420900\", \"\\u5929\\u95e8\\u5e02\":\"429006\", \"\\u8346\\u95e8\\u5e02\":\"420800\", \"\\u5b9c\\u660c\\u5e02\":\"420500\", \"\\u6b66\\u6c49\\u5e02\":\"420100\", \"\\u6f5c\\u6c5f\\u5e02\":\"429005\", \"\\u8346\\u5dde\\u5e02\":\"421000\", \"\\u6f8e\\u6e56\\u53bf\":\"719014\", \"\\u6c55\\u5934\\u5e02\":\"440500\", \"\\u5415\\u6881\\u5e02\":\"141100\", \"\\u592a\\u539f\\u5e02\":\"140100\", \"\\u664b\\u4e2d\\u5e02\":\"140700\", \"\\u6714\\u5dde\\u5e02\":\"140600\", \"\\u8fd0\\u57ce\\u5e02\":\"140800\", \"\\u4e0a\\u9976\\u5e02\":\"361100\", \"\\u5c71\\u5357\\u5e02\":\"540500\", \"\\u65e5\\u5580\\u5219\\u5e02\":\"540200\", \"\\u90a3\\u66f2\\u5e02\":\"540600\", \"\\u963f\\u91cc\\u5730\\u533a\":\"542500\", \"\\u9102\\u5dde\\u5e02\":\"420700\", \"\\u968f\\u5dde\\u5e02\":\"421300\", \"\\u9ec4\\u5188\\u5e02\":\"421100\", \"\\u9ec4\\u77f3\\u5e02\":\"420200\", \"\\u91cd\\u5e86\\u5e02\":\"500100\", \"\\u83cf\\u6cfd\\u5e02\":\"371700\", \"\\u5174\\u5b89\\u76df\":\"152200\", \"\\u5ffb\\u5dde\\u5e02\":\"140900\", \"\\u8386\\u7530\\u5e02\":\"350300\", \"\\u5409\\u5b89\\u5e02\":\"360800\", \"\\u5b9c\\u6625\\u5e02\":\"360900\", \"\\u8d63\\u5dde\\u5e02\":\"360700\", \"\\u9e70\\u6f6d\\u5e02\":\"360600\", \"\\u5e7f\\u5b89\\u5e02\":\"511600\", \"\\u6cf8\\u5dde\\u5e02\":\"510500\", \"\\u5185\\u6c5f\\u5e02\":\"511000\", \"\\u6500\\u679d\\u82b1\\u5e02\":\"510400\", \"\\u9042\\u5b81\\u5e02\":\"510900\", \"\\u8d44\\u9633\\u5e02\":\"512000\", \"\\u53ef\\u514b\\u8fbe\\u62c9\\u5e02\":\"659008\", \"\\u6fb3\\u95e8\\u7279\\u522b\\u884c\\u653f\\u533a\":\"820100\", \"\\u9999\\u6e2f\\u7279\\u522b\\u884c\\u653f\\u533a\":\"810100\", \"\\u70df\\u53f0\\u5e02\":\"370600\", \"\\u4e4c\\u9c81\\u6728\\u9f50\\u5e02\":\"650100\", \"\\u5410\\u9c81\\u756a\\u5e02\":\"650400\", \"\\u514b\\u62c9\\u739b\\u4f9d\\u5e02\":\"650200\", \"\\u4e94\\u5bb6\\u6e20\\u5e02\":\"659004\", \"\\u77f3\\u6cb3\\u5b50\\u5e02\":\"659001\", \"\\u56fe\\u6728\\u8212\\u514b\\u5e02\":\"659003\", \"\\u53cc\\u6cb3\\u5e02\":\"659007\", \"\\u4e09\\u660e\\u5e02\":\"350400\", \"\\u6cc9\\u5dde\\u5e02\":\"350500\", \"\\u9f99\\u5ca9\\u5e02\":\"350800\", \"\\u798f\\u5dde\\u5e02\":\"350100\", \"\\u5357\\u5e73\\u5e02\":\"350700\", \"\\u53a6\\u95e8\\u5e02\":\"350200\", \"\\u6f33\\u5dde\\u5e02\":\"350600\", \"\\u4e4c\\u5170\\u5bdf\\u5e03\\u5e02\":\"150900\", \"\\u4e4c\\u6d77\\u5e02\":\"150300\", \"\\u767d\\u5c71\\u5e02\":\"220600\", \"\\u6ee8\\u5dde\\u5e02\":\"371600\", \"\\u5fb7\\u5dde\\u5e02\":\"371400\", \"\\u6dc4\\u535a\\u5e02\":\"370300\", \"\\u67a3\\u5e84\\u5e02\":\"370400\", \"\\u6cf0\\u5b89\\u5e02\":\"370900\", \"\\u804a\\u57ce\\u5e02\":\"371500\", \"\\u5a01\\u6d77\\u5e02\":\"371000\", \"\\u6842\\u6797\\u5e02\":\"450300\", \"\\u767e\\u8272\\u5e02\":\"451000\", \"\\u5317\\u6d77\\u5e02\":\"450500\", \"\\u9632\\u57ce\\u6e2f\\u5e02\":\"450600\", \"\\u8d35\\u6e2f\\u5e02\":\"450800\", \"\\u6cb3\\u6c60\\u5e02\":\"451200\", \"\\u94a6\\u5dde\\u5e02\":\"450700\", \"\\u68a7\\u5dde\\u5e02\":\"450400\", \"\\u7389\\u6797\\u5e02\":\"450900\", \"\\u5d07\\u5de6\\u5e02\":\"451400\", \"\\u6765\\u5bbe\\u5e02\":\"451300\", \"\\u5e7f\\u5dde\\u5e02\":\"440100\", \"\\u8087\\u5e86\\u5e02\":\"441200\", \"\\u4e34\\u590f\\u56de\\u65cf\\u81ea\\u6cbb\\u5dde\":\"622900\", \"\\u60e0\\u5dde\\u5e02\":\"441300\", \"\\u63ed\\u9633\\u5e02\":\"445200\", \"\\u6e05\\u8fdc\\u5e02\":\"441800\", \"\\u4f0a\\u6625\\u5e02\":\"230700\", \"\\u5927\\u5e86\\u5e02\":\"230600\", \"\\u54c8\\u5c14\\u6ee8\\u5e02\":\"230100\", \"\\u9e64\\u5c97\\u5e02\":\"230400\", \"\\u9ed1\\u6cb3\\u5e02\":\"231100\", \"\\u9e21\\u897f\\u5e02\":\"230300\", \"\\u4f73\\u6728\\u65af\\u5e02\":\"230800\", \"\\u7261\\u4e39\\u6c5f\\u5e02\":\"231000\", \"\\u4e03\\u53f0\\u6cb3\\u5e02\":\"230900\", \"\\u9f50\\u9f50\\u54c8\\u5c14\\u5e02\":\"230200\", \"\\u53cc\\u9e2d\\u5c71\\u5e02\":\"230500\", \"\\u7ee5\\u5316\\u5e02\":\"231200\", \"\\u8d35\\u9633\\u5e02\":\"520100\", \"\\u5b89\\u987a\\u5e02\":\"520400\", \"\\u516d\\u76d8\\u6c34\\u5e02\":\"520200\", \"\\u9ed4\\u4e1c\\u5357\\u82d7\\u65cf\\u4f97\\u65cf\\u81ea\\u6cbb\\u5dde\":\"522600\", \"\\u9ed4\\u5357\\u5e03\\u4f9d\\u65cf\\u82d7\\u65cf\\u81ea\\u6cbb\\u5dde\":\"522700\", \"\\u9ed4\\u897f\\u5357\\u5e03\\u4f9d\\u65cf\\u82d7\\u65cf\\u81ea\\u6cbb\\u5dde\":\"522300\", \"\\u94dc\\u4ec1\\u5e02\":\"520600\", \"\\u9075\\u4e49\\u5e02\":\"520300\", \"\\u5408\\u80a5\\u5e02\":\"340100\", \"\\u6ec1\\u5dde\\u5e02\":\"341100\", \"\\u5b89\\u5e86\\u5e02\":\"340800\", \"\\u868c\\u57e0\\u5e02\":\"340300\", \"\\u4eb3\\u5dde\\u5e02\":\"341600\", \"\\u6c60\\u5dde\\u5e02\":\"341700\", \"\\u961c\\u9633\\u5e02\":\"341200\", \"\\u6dee\\u5317\\u5e02\":\"340600\", \"\\u6dee\\u5357\\u5e02\":\"340400\", \"\\u9ec4\\u5c71\\u5e02\":\"341000\", \"\\u516d\\u5b89\\u5e02\":\"341500\", \"\\u9a6c\\u978d\\u5c71\\u5e02\":\"340500\", \"\\u94dc\\u9675\\u5e02\":\"340700\", \"\\u829c\\u6e56\\u5e02\":\"340200\", \"\\u5bbf\\u5dde\\u5e02\":\"341300\", \"\\u5ba3\\u57ce\\u5e02\":\"341800\", \"\\u4fdd\\u5b9a\\u5e02\":\"130600\", \"\\u5f20\\u5bb6\\u53e3\\u5e02\":\"130700\", \"\\u90a2\\u53f0\\u5e02\":\"130500\", \"\\u5510\\u5c71\\u5e02\":\"130200\", \"\\u79e6\\u7687\\u5c9b\\u5e02\":\"130300\", \"\\u5eca\\u574a\\u5e02\":\"131000\", \"\\u8861\\u6c34\\u5e02\":\"131100\", \"\\u627f\\u5fb7\\u5e02\":\"130800\", \"\\u6ca7\\u5dde\\u5e02\":\"130900\", \"\\u4f5b\\u5c71\\u5e02\":\"440600\", \"\\u73e0\\u6d77\\u5e02\":\"440400\", \"\\u56fa\\u539f\\u5e02\":\"640400\", \"\\u77f3\\u5634\\u5c71\\u5e02\":\"640200\", \"\\u5434\\u5fe0\\u5e02\":\"640300\", \"\\u94f6\\u5ddd\\u5e02\":\"640100\", \"\\u4e2d\\u536b\\u5e02\":\"640500\", \"\\u97f6\\u5173\\u5e02\":\"440200\", \"\\u6f6e\\u5dde\\u5e02\":\"445100\", \"\\u8302\\u540d\\u5e02\":\"440900\", \"\\u6885\\u5dde\\u5e02\":\"441400\", \"\\u6c55\\u5c3e\\u5e02\":\"441500\", \"\\u6606\\u660e\\u5e02\":\"530100\", \"\\u66f2\\u9756\\u5e02\":\"530300\", \"\\u4fdd\\u5c71\\u5e02\":\"530500\", \"\\u695a\\u96c4\\u5f5d\\u65cf\\u81ea\\u6cbb\\u5dde\":\"532300\", \"\\u5fb7\\u5b8f\\u50a3\\u65cf\\u666f\\u9887\\u65cf\\u81ea\\u6cbb\\u5dde\":\"533100\", \"\\u8fea\\u5e86\\u85cf\\u65cf\\u81ea\\u6cbb\\u5dde\":\"533400\", \"\\u7ea2\\u6cb3\\u54c8\\u5c3c\\u65cf\\u5f5d\\u65cf\\u81ea\\u6cbb\\u5dde\":\"532500\", \"\\u4e3d\\u6c5f\\u5e02\":\"530700\", \"\\u666e\\u6d31\\u5e02\":\"530800\", \"\\u7389\\u6eaa\\u5e02\":\"530400\", \"\\u662d\\u901a\\u5e02\":\"530600\", \"\\u4e34\\u6c82\\u5e02\":\"371300\", \"\\u4e1c\\u8425\\u5e02\":\"370500\", \"\\u4e09\\u6c99\\u5e02\":\"460300\", \"\\u5317\\u4eac\\u5e02\":\"110100\" }";

		LinkedHashMap<String, List<Map<String, String>>> cityMap= JSON
				.parseObject(letter, LinkedHashMap.class, Feature.OrderedField);

		Map<String,String> cityMapComp=JSON
				.parseObject(letterComp, LinkedHashMap.class, Feature.OrderedField);
		Map<String,String> cityMapCompBak=new HashMap<>();

		Map<String,String> cityMapBak=new HashMap<>();

		cityMapComp.forEach((k,v)->{
			cityMapCompBak.put(v,k);
		});
		AtomicInteger size= new AtomicInteger();
		cityMap.forEach((k, v) -> {
			size.addAndGet(v.size());
			v.forEach(listNode -> {
				JSON.parseObject(listNode.toString()).entrySet().forEach(nodeMap -> {
					if (Objects.nonNull(cityMapCompBak.get(nodeMap.getValue()))) {
						cityMapBak.put(cityMapCompBak.get(nodeMap.getValue()),nodeMap.getValue().toString());
//						cityMapBak.put(nodeMap.getValue().toString(),cityMapCompBak.get(nodeMap.getValue()));
					}else {
						if (nodeMap.getKey().equals("code")){
							System.out.println(nodeMap.getKey()+nodeMap.getValue().toString());
						}
					}
				});
			});
		});
		System.out.println(JSON.toJSONString(cityMapBak));
		System.out.println(size);
//		Set<String> bigMapKey = cityMapCompBak.keySet();
//		Set<String> smallMapKey = cityMapBak.keySet();
//		Set<String> differenceSet = Sets.difference(bigMapKey, smallMapKey);
//		Map<String, String> result = new HashMap<>();
//		for (String key : differenceSet) {
//			result.put(key, cityMapCompBak.get(key));
//		}
//
//		System.out.println();
	}
}