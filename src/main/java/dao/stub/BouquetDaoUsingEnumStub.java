package dao.stub;

import java.util.ArrayList;
import java.util.List;

import dao.BouquetDao;
import dao.exception.StorageSystemException;
import model.entity.boquet.Bouquet;

public class BouquetDaoUsingEnumStub implements BouquetDao {

    @Override
    public List<Bouquet> getAll() throws StorageSystemException {
	List<Bouquet> bouquets = new ArrayList<>();
	bouquets.add(BouquetStub.BOUQUET_1.getBouquet());
	bouquets.add(BouquetStub.BOUQUET_2.getBouquet());
	return bouquets;
    }
}
