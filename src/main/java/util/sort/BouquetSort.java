package util.sort;

import java.util.Comparator;
import java.util.List;

import model.entity.boquet.Bouquet;

public class BouquetSort implements Sortable<Bouquet> {

    @Override
    public void sort(List<Bouquet> bouquets, Comparator<Bouquet> comparator) {
	bouquets.sort(comparator);
    }
}
