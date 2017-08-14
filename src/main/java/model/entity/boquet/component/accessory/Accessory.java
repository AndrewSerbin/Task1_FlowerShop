package model.entity.boquet.component.accessory;

import model.entity.boquet.component.BouquetComponent;

public class Accessory extends BouquetComponent {

    private AccessoryType type;

    public Accessory(String name, int price, AccessoryType type) {
	super(name, price);
	this.type = type;
    }
}
