package json;
import bean.Diaos;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class jsonObjectSample {
    public static void main(String[] args){
        CreateJsonByBean();
    }
  //  {
  //      "name" : "王小二",
    //         "age" : 25.2,
  //          "birthday" : "1990-01-01",
  //          "school" : "蓝翔",
  //          "major" : ["理发","挖掘机"],
  //      "has_girlfriend" : false,
   //         "car" : null,
  //          "house" : null,
  //          "comment" : "这是一个注释"
  //  }
    private static void CreateJsonByBean(){
        Diaos wangxiaoer = new Diaos();
        wangxiaoer.setName("王小二");
        wangxiaoer.setAge(25.2);
        wangxiaoer.setBirthday("1990-01-01");
        wangxiaoer.setSchool("蓝翔");
        wangxiaoer.setHas_girlfriend(false);
        wangxiaoer.setCar(null);
        wangxiaoer.setHouse(null);
        wangxiaoer.setComment("这是一个注释");
        System.out.println(new JSONObject(wangxiaoer));
    }

    private static void JSONObject() {
        JSONObject wangxiaoer = new JSONObject();
        Object nullObj = null;
        try {
            wangxiaoer.put("name", "王小二");
            wangxiaoer.put("age", 25.2);
            wangxiaoer.put("birthday", "1990-01-01");
            wangxiaoer.put("school", "蓝翔");
            wangxiaoer.put("major", new String[]{"理发", "挖掘机"});
            wangxiaoer.put("has_girfriend", false);
            wangxiaoer.put("car", nullObj);
            wangxiaoer.put("house", nullObj);
            wangxiaoer.put("comment", "这是一个注释");
            System.out.println(wangxiaoer.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private static void CreateJsonByMap(){
            Map<String,Object> wangxiaoer = new HashMap<String, Object>();
            Object nullObj = null;
            wangxiaoer.put("name", "王小二");
            wangxiaoer.put("age",25.2);
            wangxiaoer.put("birthday","1990-01-01");
            wangxiaoer.put("school","蓝翔");
            wangxiaoer.put("major",new String[] {"理发","挖掘机"});
            wangxiaoer.put("has_girfriend",false);
            wangxiaoer.put("car",nullObj);
            wangxiaoer.put("house",nullObj);
            wangxiaoer.put("comment","这是一个注释");
            System.out.println(new JSONObject(wangxiaoer).toString());
        }
        //建议使用的是java bean来写，因为可以 重复操作（利用对象来生成）
}
