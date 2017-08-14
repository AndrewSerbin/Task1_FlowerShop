package model.entity.boquet.component.plant;

import model.entity.boquet.component.BouquetComponent;

public class NotFlower extends BouquetComponent {

    private NotFlowerType type;

    public NotFlower(String name, int price, NotFlowerType type) {
	super(name, price);
	this.type = type;
    }

    public NotFlowerType getType() {
	return type;
    }

    public void setType(NotFlowerType type) {
	this.type = type;
    }
}
