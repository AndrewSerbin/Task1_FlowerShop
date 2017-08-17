package util.find;

import java.util.List;
import java.util.Optional;

import model.entity.boquet.Bouquet;
import model.entity.boquet.StemLength;

public class BouquetFind implements Findable<Bouquet, StemLength> {

    @Override
    public Optional<Bouquet> find(List<Bouquet> entity, StemLength criterion) {
	Optional<Bouquet> findResult = Optional.empty();
	for (Bouquet bouquet : entity) {
	    if (bouquet.getStemLength().equals(criterion)) {
		findResult = Optional.of(bouquet);
	    }
	}
	return findResult;
    }
}
