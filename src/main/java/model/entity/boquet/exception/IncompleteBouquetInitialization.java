package model.entity.boquet.exception;

/**
 * Is created if the initialization was not passed.
 */
public class IncompleteBouquetInitialization extends Exception {

    public IncompleteBouquetInitialization() {

    }

    public IncompleteBouquetInitialization(String message) {
	super(message);
    }
}
