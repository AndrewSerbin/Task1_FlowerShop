package util.find;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import dao.BouquetDao;
import dao.BouquetDaoUsingEnumStub;
import dao.BouquetStub;
import dao.exception.StorageSystemException;
import model.entity.boquet.Bouquet;
import model.entity.boquet.StemLength;

public class BouquetFindTest {

    List<Bouquet> bouquets;

    @Before
    public void init() {
	BouquetDao dao = new BouquetDaoUsingEnumStub();
	try {
	    bouquets = dao.getAll();
	} catch (StorageSystemException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testFindWithStemLengthCriteria() {
	Optional<Bouquet> expectedBouquet = Optional.of(BouquetStub.BOUQUET_2.getBouquet());
	Findable<Bouquet, StemLength> findable = new BouquetFind();
	Optional<Bouquet> actualBouquet = findable.find(bouquets, StemLength.LONG);

	assertEquals(expectedBouquet, actualBouquet);
    }

    @Test
    public void testFindWithMissingStemLengthCriteria() {
	Optional<Bouquet> expectedBouquet = Optional.empty();
	Findable<Bouquet, StemLength> findable = new BouquetFind();
	Optional<Bouquet> actualBouquet = findable.find(bouquets, StemLength.WITHOUT);

	assertEquals(expectedBouquet, actualBouquet);
    }
}
