package girl.girl;

import girl.girl.domain.Girl;
import girl.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)//表示要在测试环境中跑
@SpringBootTest //表示将启动整个Springboot的工程
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        Girl girl = girlService.findOne(15);
        Assert.assertEquals(new Integer(1000),girl.getAge());

    }
}
