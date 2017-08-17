package dao;

import java.util.List;

import dao.exception.StorageSystemException;
import model.entity.boquet.Bouquet;

public interface BoquetDao {

    List<Bouquet> getAll() throws StorageSystemException;

    void deleteById(int id) throws StorageSystemException;
}
