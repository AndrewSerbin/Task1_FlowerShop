package dao;

import model.entity.boquet.Bouquet;
import model.entity.boquet.Event;
import model.entity.boquet.Freshness;
import model.entity.boquet.Size;
import model.entity.boquet.StemLength;
import model.entity.boquet.builder.BouquetBuilder;
import model.entity.boquet.component.plant.Flower;
import model.entity.boquet.component.plant.FlowerType;
import model.entity.boquet.exception.IncompleteBouquetInitialization;

public enum BoquetExample {

    BOUQUET_1("Boquet 1", Event.ALL, Freshness.NORMALLY, Size.SMALL, StemLength.MEDIUM, "Rose",
	    100, FlowerType.ONE_FLOWER, false, true);

    private Bouquet bouquet;

    BoquetExample(String name, Event event, Freshness freshness, Size size, StemLength stemLength,
	    String flowerName, int flowerPrice, FlowerType flowerType, boolean isFeed, boolean isSupport) {
	try {
	    bouquet = new BouquetBuilder()
		    .setName(name)
		    .setEvent(event)
		    .setFreshness(freshness)
		    .setSize(size)
		    .setStemLength(stemLength)
		    .addFlower(new Flower(flowerName, flowerPrice, flowerType, isFeed, isSupport))
		    .build();
	} catch (IncompleteBouquetInitialization e) {
	    e.printStackTrace();
	}
    }

    public Bouquet getBouquet() {
	return bouquet;
    }

    public void setBouquet(Bouquet bouquet) {
	this.bouquet = bouquet;
    }
}
