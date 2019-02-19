package girl.girl.controller;

import girl.girl.properties.girlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController//等于 controller和responsebody同时使用的效果
public class HelloController {


    @Autowired
    private girlProperties Girl;

    //使用方式：/hello/234

    /*@RequestMapping(value = {"/hello/{id}"},method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id){
        return "id: " + id;
        //return Girl.getCupSize();
    }*/

    //使用 /hello?id=234
    @RequestMapping(value = {"/hello"},method = RequestMethod.GET)
    //上一句可以简化为：@GetMapping(value = "/hello")  简单就好 联想到 @

    public String say(@RequestParam(value = "id",required = false, defaultValue = "0") Integer myId){
        return "id: " + myId;
        //return Girl.getCupSize();
    }
}
