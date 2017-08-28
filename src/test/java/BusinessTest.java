import base.BaseTest;
import com.went.core.entity.BusinessInfo;
import com.went.core.mapper.BusinessMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * Created by Administrator on 2017/8/26.
 */

public class BusinessTest extends BaseTest{


    @Autowired
    private BusinessMapper businessMapper;


    @Test
    public void test(){
        List<BusinessInfo> select = businessMapper.select();
        System.out.println(select);

    }


}
