package dao;

import java.util.List;

import dao.exception.StorageSystemException;
import model.entity.boquet.Bouquet;
import model.entity.boquet.exception.IncompleteBouquetInitialization;

public interface BouquetDao {

    List<Bouquet> getAll() throws StorageSystemException, IncompleteBouquetInitialization;
}
