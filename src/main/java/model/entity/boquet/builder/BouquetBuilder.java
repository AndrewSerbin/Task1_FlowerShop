package model.entity.boquet.builder;

import java.util.ArrayList;
import java.util.List;

import model.entity.Item;
import model.entity.boquet.Bouquet;
import model.entity.boquet.Event;
import model.entity.boquet.Freshness;
import model.entity.boquet.Size;
import model.entity.boquet.StemLength;
import model.entity.boquet.exception.IncompleteBouquetInitialization;

public class BouquetBuilder {

    private String name;

    private Event event;

    private Freshness freshness;

    private Size size;

    private StemLength stemLength;

    private ArrayList<Item> flowers;

    private ArrayList<Item> accessories;

    public BouquetBuilder() {
	flowers = new ArrayList<>();
	accessories = new ArrayList<>();
    }

    public BouquetBuilder setName(String name) {
	this.name = name;
	return this;
    }

    public BouquetBuilder setEvent(Event event) {
	this.event = event;
	return this;
    }

    public BouquetBuilder setFreshness(Freshness freshness) {
	this.freshness = freshness;
	return this;
    }

    public BouquetBuilder setSize(Size size) {
	this.size = size;
	return this;
    }

    public BouquetBuilder setStemLength(StemLength stemLength) {
	this.stemLength = stemLength;
	return this;
    }

    public BouquetBuilder addFlower(Item flower) {
	flowers.add(flower);
	return this;
    }

    public BouquetBuilder addFlower(List<Item> flowers) {
	this.flowers.addAll(flowers);
	return this;
    }

    public BouquetBuilder addAccessory(Item accessory) {
	accessories.add(accessory);
	return this;
    }

    public BouquetBuilder addAccessory(List<Item> accessories) {
	this.accessories.addAll(accessories);
	return this;
    }

    public Bouquet build() throws IncompleteBouquetInitialization {
	boolean incompleteBouquetInitialization = checkEventForNull() || checkFreshnessForNull()
		|| checkSizeForNull() || checkStemLengthForNull()
		|| checkFlowersForNull() || checkFlowersForZeroCapacity();

	if (incompleteBouquetInitialization) {
	    throw new IncompleteBouquetInitialization();
	}

	Bouquet bouquet = new Bouquet(name);
	bouquet.setAccessories(accessories);
	bouquet.setEvent(event);
	bouquet.setFlowers(flowers);
	bouquet.setFreshness(freshness);
	bouquet.setSize(size);
	bouquet.setStemLength(stemLength);

	return bouquet;
    }

    private boolean checkEventForNull() {
	return this.event == null;
    }

    private boolean checkFreshnessForNull() {
	return this.freshness == null;
    }

    private boolean checkSizeForNull() {
	return this.size == null;
    }

    private boolean checkStemLengthForNull() {
	return this.stemLength == null;
    }

    private boolean checkFlowersForNull() {
	return this.flowers == null;
    }

    private boolean checkFlowersForZeroCapacity() {
	return this.flowers.size() == 0;
    }
}
