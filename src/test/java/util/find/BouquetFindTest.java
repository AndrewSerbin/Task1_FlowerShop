package util.find;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.BouquetDao;
import dao.exception.StorageSystemException;
import dao.stub.BouquetDaoUsingEnumStub;
import dao.stub.BouquetStub;
import model.entity.boquet.Bouquet;
import model.entity.boquet.StemLength;
import model.entity.boquet.exception.IncompleteBouquetInitialization;
import model.util.find.BouquetFind;
import model.util.find.Findable;

public class BouquetFindTest {

    List<Bouquet> bouquets;

    @Before
    public void init() {
	BouquetDao dao = new BouquetDaoUsingEnumStub();
	try {
	    bouquets = dao.getAll();
	} catch (StorageSystemException e) {
	    e.printStackTrace();
	} catch (IncompleteBouquetInitialization e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testFindWithStemLengthCriteria() {
	List<Bouquet> expectedBouquet = Arrays.asList(BouquetStub.BOUQUET_2.getBouquet());
	Findable<Bouquet, StemLength> findable = new BouquetFind();
	List<Bouquet> actualBouquet = findable.find(bouquets, StemLength.LONG);

	assertEquals(expectedBouquet, actualBouquet);
    }

    @Test
    public void testFindWithMissingStemLengthCriteria() {
	List<Bouquet> expectedBouquet = new ArrayList<>();
	Findable<Bouquet, StemLength> findable = new BouquetFind();
	List<Bouquet> actualBouquet = findable.find(bouquets, StemLength.WITHOUT);

	assertEquals(expectedBouquet, actualBouquet);
    }
}
