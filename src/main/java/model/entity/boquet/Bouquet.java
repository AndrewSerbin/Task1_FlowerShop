package model.entity.boquet;

import java.util.List;

import model.entity.Item;

public class Bouquet implements Item {

    private Event event;

    private Freshness freshness;

    private Size size;

    private StemLength stemLength;

    private List<Item> flowers;

    private List<Item> accessories;

    @Override
    public int getPrice() {
	return getPriceOfComponents(flowers) + getPriceOfComponents(accessories);
    }

    private int getPriceOfComponents(List<Item> components) {
	int sum = 0;

	for (Item component : components) {
	    sum += component.getPrice();
	}

	return sum;
    }

    public Event getEvent() {
	return event;
    }

    public void setEvent(Event event) {
	this.event = event;
    }

    public Freshness getFreshness() {
	return freshness;
    }

    public void setFreshness(Freshness freshness) {
	this.freshness = freshness;
    }

    public Size getSize() {
	return size;
    }

    public void setSize(Size size) {
	this.size = size;
    }

    public StemLength getStemLength() {
	return stemLength;
    }

    public void setStemLength(StemLength stemLength) {
	this.stemLength = stemLength;
    }

    public List<Item> getFlowers() {
	return flowers;
    }

    public void setFlowers(List<Item> flowers) {
	this.flowers = flowers;
    }

    public List<Item> getAccessories() {
	return accessories;
    }

    public void setAccessories(List<Item> accessories) {
	this.accessories = accessories;
    }
}
