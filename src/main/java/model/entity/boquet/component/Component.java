package model.entity.boquet.component;

import model.entity.Item;

public abstract class Component extends Item {

    protected int price;

    public Component(String name, int price) {
	super(name);
	this.price = price;
    }

    @Override
    public int getPrice() {
	return price;
    }

    public void setPrice(int price) {
	this.price = price;
    }
}
