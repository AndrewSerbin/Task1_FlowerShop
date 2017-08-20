package model.util.sort;

import java.util.Comparator;

import model.entity.boquet.Bouquet;

public class FreshnessComparator implements Comparator<Bouquet> {

    @Override
    public int compare(Bouquet o1, Bouquet o2) {
	if (o1.getFreshness().ordinal() > o2.getFreshness().ordinal()) {
	    return 1;
	} else if (o1.getFreshness().ordinal() < o2.getFreshness().ordinal()) {
	    return -1;
	}
	return 0;
    }
}
