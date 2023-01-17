package cross_cutting.Parsers;

import junit.framework.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SingletonResulListTest {

    private ArrayList<Double> doubleList = new ArrayList<>();

    @BeforeAll
    public void setUp() {
        Double[] temp = {12.4, 23.4, 67.5, 54.3, 9886.23234};

        for(var id : temp) {
            doubleList.add(id);
        }

    }

    @Test
    void getInstance() {
        Assert.assertEquals(SingletonResulList.getInstance(doubleList).Data.get(2), 67.5);
    }

    @Test
    void testInstance2() {
        Assert.assertEquals(SingletonResulList.Data.get(0) + SingletonResulList.Data.get(3), 66.7);
    }



}