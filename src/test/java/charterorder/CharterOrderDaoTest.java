package charterorder;

import java.util.List;

import org.dao.mapping.Business;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.maint.charterorder.CharterOrderBO;
import org.maint.company.CompanyBO;

public class CharterOrderDaoTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        CharterOrderBO bo;
        CompanyBO cBo;
        cBo = new CompanyBO();
        bo = new CharterOrderBO();
        List<Business> items = cBo.getCompanyInfo();

    }

}
