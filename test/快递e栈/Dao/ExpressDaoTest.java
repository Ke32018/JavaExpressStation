package 快递e栈.Dao;

import org.junit.Test;
import 快递e栈.bean.Express;

import static org.junit.Assert.*;

public class ExpressDaoTest {
    public Express e = new Express();

    @Test
    public void addToSet() {
        new ExpressDao().addToSet(e, 32018);
        assertEquals(e, e);
    }

    @Test
    public void generateCode() {
    }

    @Test
    public void deleteFromSet() {
    }

    @Test
    public void findExpress() {
    }
}