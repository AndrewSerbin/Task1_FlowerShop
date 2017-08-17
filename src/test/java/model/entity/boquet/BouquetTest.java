package model.entity.boquet;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dao.BouquetDao;
import dao.BouquetDaoUsingEnumStub;
import dao.exception.StorageSystemException;

public class BouquetTest {

    Bouquet boquet;

    @Before
    public void init() {
	BouquetDao dao = new BouquetDaoUsingEnumStub();
	try {
	    boquet = dao.getAll().get(0);
	} catch (StorageSystemException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testBoquetPrice() {
	int expectedPrice = 100;
	int actualPrice = boquet.getPrice();
	assertEquals(expectedPrice, actualPrice);
    }
}
