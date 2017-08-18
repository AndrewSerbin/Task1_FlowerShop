package model.entity.boquet.component.accessory;

import model.entity.boquet.component.Component;

public class Accessory extends Component {

    private AccessoryType type;

    public Accessory(String name, int price, AccessoryType type) {
	super(name, price);
	this.type = type;

    }

    @Override
    public String toString() {
	return super.toString() + "Accessory [type=" + type + "]";
    }
}
