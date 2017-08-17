package dao;

import java.util.ArrayList;
import java.util.List;

import dao.exception.StorageSystemException;
import model.entity.boquet.Bouquet;

public class BoquetEnumStub implements BoquetDao {

    @Override
    public List<Bouquet> getAll() throws StorageSystemException {
	List<Bouquet> bouquets = new ArrayList<>();
	bouquets.add(BoquetExample.BOUQUET_1.getBouquet());
	return bouquets;
    }

    @Override
    public void deleteById(int id) throws StorageSystemException {
	throw new UnsupportedOperationException();
    }
}
