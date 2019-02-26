package girl.girl.controller;

import girl.girl.aspect.HttpAspect;
import girl.girl.domain.Girl;
import girl.girl.repository.GirlRepository;
import girl.girl.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    //查询所有女生列表
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        logger.info("girlList");
        return girlRepository.findAll();
    }

    //添加一个女生
    @PostMapping(value = "/girls")
    public Object girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return bindingResult.getFieldError().getDefaultMessage();
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        girl.setMoney(girl.getMoney());
        return girlRepository.save(girl);//这里的save方法返回的就是Girl的对象
    }

    //查询女生byId
    @GetMapping(value = "/girls/{id}")
    public Optional<Girl> girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findById(id);
    }

    /*构通Example查找 -- 使用findOne
    Girl girl = new Girl();
    girl.setId(id);
    Example<Girl> example = Example.of(girl);
    return girlRepository.findOne(example);*/

    //通过年龄查询女生
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }


    //更新
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id, @RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age, @RequestParam("money") Double money) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setMoney(money);
        return girlRepository.save(girl);

    }

    //删除
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);

    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();

    }

}
