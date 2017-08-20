package model.util.sort;

import java.util.Comparator;
import java.util.List;

public interface Sortable<E> {

    void sort(List<E> entities, Comparator<E> comparator);
}
