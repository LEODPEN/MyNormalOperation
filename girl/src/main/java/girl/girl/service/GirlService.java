package girl.girl.service;

import girl.girl.domain.Girl;
import girl.girl.exception.GirlException;
import girl.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    //@Transactional事务操作用于同时操作多条数据，只有查询的时候不用加，
    // 如果操作失败就不能操作，哪怕只有一条操作失败
    //因此考虑都加上这句（除非是查询），
    // 此处是我将table 中girl字段的char长度设置为1，
    // 因此数据girlB是无法正常插入的，于是整个操作都应该失败
    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(19);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("Baaa");
        girlB.setAge(20);
        girlRepository.save(girlB);

    }
    public void getAge(Integer id)throws Exception{
        Girl girl = girlRepository.findById(id).get();
        /*Optional<Girl> optional = girlRepository.findById(id);
          Integer age = optional.orElseGet(Girl::new).getAge();
          spring-boot 2.0后加了对java8 optional类型的支持*/
        Integer age = girl.getAge();
        if (age<10){
            throw new GirlException(100,"你还在上小学吧？");
        }
        else if(age<16){
            throw new GirlException(101,"你可能在上初中?");

        }
        else{

        }

    }

}
