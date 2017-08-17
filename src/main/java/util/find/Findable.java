package util.find;

import java.util.List;
import java.util.Optional;

public interface Findable<E, C> {

    Optional<E> find(List<E> entity, C criterion);
}
