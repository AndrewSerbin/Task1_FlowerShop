package util.sort;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.stub.BouquetStub;
import model.entity.boquet.Bouquet;
import model.util.sort.BouquetSort;
import model.util.sort.FreshnessComparator;
import model.util.sort.Sortable;

public class BouquetSortTest {

    @Test
    public void testBouquetsSortWithStemLength() {
	List<Bouquet> actualBouquets = new ArrayList<>();
	actualBouquets.add(BouquetStub.BOUQUET_1.getBouquet());
	actualBouquets.add(BouquetStub.BOUQUET_2.getBouquet());

	List<Bouquet> expectedBouquets = new ArrayList<>();
	expectedBouquets.add(BouquetStub.BOUQUET_2.getBouquet());
	expectedBouquets.add(BouquetStub.BOUQUET_1.getBouquet());

	Sortable<Bouquet> sort = new BouquetSort();
	sort.sort(actualBouquets, new FreshnessComparator());

	assertEquals(expectedBouquets, actualBouquets);
    }
}
