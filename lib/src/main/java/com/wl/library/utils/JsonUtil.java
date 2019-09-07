package com.wl.library.utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * Created by PandaQ on 2017/2/23.
 * 新闻json需要单独处理再解析
 */

public class JsonUtil {



    private static Gson mGson = new Gson();
//    private final static Gson mGson =  new GsonBuilder()
//	        .serializeNulls()
//	        .create();

    public static Gson getmGson() {
        return mGson;
    }

    public static  <T> T copy(Object source, Class<T> clz) {
        return  JsonUtil.deserialize(JsonUtil.serialize(source), clz);
    }

    /**
     * 将对象准换为json字符串
     *
     * @param object
     * @param <T>
     * @return
     */
    public static <T> String serialize(T object) {
        return mGson.toJson(object);
    }

    /**
     * 将json字符串转换为对象
     *
     * @param json
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T deserialize(String json, Class<T> clz) throws JsonSyntaxException {
        return mGson.fromJson(json, clz);
    }

    /**
     * 将json对象转换为实体对象
     *
     * @param json
     * @param clz
     * @param <T>
     * @return
     * @throws JsonSyntaxException
     */
    public static <T> T deserialize(JsonObject json, Class<T> clz) throws JsonSyntaxException {
        return mGson.fromJson(json, clz);
    }
    
    public static List<Map<String, Object>> json2List(String jsonStr){
    	List<Map<String, Object>> list=new ArrayList<>();
    	
    	 JsonParser jsonParser = new JsonParser();
         JsonElement jsonElement = jsonParser.parse(jsonStr);
         if(jsonElement.isJsonObject()){
        	 Map<String, Object> map=JsonToMap(jsonStr, null);
        	 list.add(map);
        	 return list;
         }else if (jsonElement.isJsonArray()){
        	 JsonArray jsonArray = jsonElement.getAsJsonArray();
        	 
        	  for (int i = 0, len = jsonArray.size(); i < len; i++) {
                  Map<String, Object> tempMap = new HashMap<String, Object>();
                  JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                  Iterator<Entry<String, JsonElement>> iterator = jsonObject.entrySet().iterator();
                  while (iterator.hasNext()) {
                      Entry<String, JsonElement> next = iterator.next();
                      tempMap = JsonToMap(tempMap, next.getKey(), next.getValue());
                  }
                  list.add(tempMap);
              }
         }
    	
    	return list;
    	
    }

    
    /**
     * json 转 map
     * 
     * @param jsonStr
     *            要转换的json字符串
     * @return
     */
    public static Map<String, Object> jsonToMap(String jsonStr) {
        return JsonToMap(jsonStr, null);
    }

    /**
     * json 转 map
     * 
     * @param jsonStr
     *            要转换的json字符串
     * @param result
     *            转换的结果放入位置
     * @return
     */
    public static Map<String, Object> JsonToMap(String jsonStr, Map<String, Object> result) {
        if (jsonStr == null) {
            return null;
        }
        if (result == null) {
            result = new HashMap<String, Object>();
        }
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(jsonStr);
        return JsonToMap(result, "▲▼◆", jsonElement);
    }

    private static Map<String, Object> JsonToMap(Map<String, Object> result, String key, JsonElement value) {
    	// 如果key为null 直接报错
    	if (key == null) {
    		throw new RuntimeException("key值不能为null");
    	}
    	// 如果value为null,则直接put到map中
    	if (value == null) {
    		result.put(key, value);
    	} else {
    		// 如果value为基本数据类型，则放入到map中
    		 if (value.isJsonObject()) {
    			// 如果value为JsonObject数据类型，则遍历此JSONObject，进行递归调用本方法
    			JsonObject jsonObject = value.getAsJsonObject();
    			Iterator<Entry<String, JsonElement>> iterator = jsonObject.entrySet().iterator();
    			Map<String, Object> valueResult=new HashMap<>();
    			while (iterator.hasNext()) {
    				Entry<String, JsonElement> next = iterator.next();
    				
    				valueResult = JsonToMap(valueResult, next.getKey(), next.getValue());
    			}
    			if("▲▼◆".equals(key)){
    				result.putAll(valueResult);
    			}else {
    				result.put(key, valueResult);
				}
    			
    		} else if (value.isJsonArray()) {
    			// 如果value为JsonArray数据类型，则遍历此JsonArray，进行递归调用本方法
    			JsonArray jsonArray = value.getAsJsonArray();
    			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    			for (int i = 0, len = jsonArray.size(); i < len; i++) {
    				Map<String, Object> tempMap = new HashMap<String, Object>();
    				JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
    				Iterator<Entry<String, JsonElement>> iterator = jsonObject.entrySet().iterator();
    				while (iterator.hasNext()) {
    					Entry<String, JsonElement> next = iterator.next();
    					tempMap = JsonToMap(tempMap, next.getKey(), next.getValue());
    				}
    				list.add(tempMap);
    			}
    			result.put(key, list);
    		} else {
    			result.put(key, value.getAsString());
    		}
    	}
    	// 返回最终结果
    	return result;
    }
    /**
     * 将json字符串转换为对象
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T deserialize(String json, Type type) throws JsonSyntaxException {
        return mGson.fromJson(json, type);
    }
}
