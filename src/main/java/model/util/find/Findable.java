package model.util.find;

import java.util.List;

public interface Findable<E, C> {

    List<E> find(List<E> entity, C criterion);
}
