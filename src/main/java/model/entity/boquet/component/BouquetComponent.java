package model.entity.boquet.component;

import model.entity.Item;

public abstract class BouquetComponent implements Item {

    private String name;

    private int price;

    public BouquetComponent(String name, int price) {
	this.name = name;
	this.price = price;
    }

    @Override
    public int getPrice() {
	return price;
    }

    public void setPrice(int price) {
	this.price = price;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }
}
