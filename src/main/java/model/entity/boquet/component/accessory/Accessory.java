package model.entity.boquet.component.accessory;

import model.entity.boquet.component.BouqeteComponent;

public class Accessory extends BouqeteComponent {

    private AccessoryType type;

    public Accessory(String name, int price, AccessoryType type) {
	super(name, price);
	this.type = type;
    }
}
