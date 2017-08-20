package model.util.find;

import java.util.ArrayList;
import java.util.List;

import model.entity.boquet.Bouquet;
import model.entity.boquet.StemLength;

public class BouquetFind implements Findable<Bouquet, StemLength> {

    @Override
    public List<Bouquet> find(List<Bouquet> entity, StemLength criterion) {
	List<Bouquet> findResult = new ArrayList<>();
	for (Bouquet bouquet : entity) {
	    if (bouquet.getStemLength().equals(criterion)) {
		findResult.add(bouquet);
	    }
	}
	return findResult;
    }
}
