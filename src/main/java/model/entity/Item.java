package model.entity;

public abstract class Item {

    protected String name;

    public Item(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    abstract public int getPrice();

    @Override
    public String toString() {
	return "Item [name=" + name + "]";
    }
}
