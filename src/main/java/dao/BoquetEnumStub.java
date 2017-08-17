package dao;

import java.util.List;

import model.entity.boquet.Bouquet;

public class BoquetEnumStub implements BoquetDao {

    @Override
    public List<Bouquet> getAll() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void deleteById(int id) {
	throw new UnsupportedOperationException();
    }

}
