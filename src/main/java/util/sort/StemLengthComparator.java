package util.sort;

import java.util.Comparator;

import model.entity.boquet.Bouquet;

public class StemLengthComparator implements Comparator<Bouquet> {

    @Override
    public int compare(Bouquet o1, Bouquet o2) {
	if (o1.getStemLength().ordinal() > o2.getStemLength().ordinal()) {
	    return 1;
	} else if (o1.getStemLength().ordinal() < o2.getStemLength().ordinal()) {
	    return -1;
	}
	return 0;
    }
}
