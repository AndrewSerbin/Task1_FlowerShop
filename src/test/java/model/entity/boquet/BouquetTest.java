package model.entity.boquet;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.entity.boquet.builder.BouquetBuilder;
import model.entity.boquet.component.plant.Flower;
import model.entity.boquet.component.plant.FlowerType;
import model.entity.boquet.exception.IncompleteBouquetInitialization;

public class BouquetTest {

    private Bouquet boquet;

    enum BouquetStub {

	BOUQUET_1("Boquet 1", Event.ALL, Freshness.NORMALLY, Size.SMALL, StemLength.MEDIUM, "Rose", 100,
		FlowerType.ONE_FLOWER, false, true), BOUQUET_2("Boquet 2", Event.ALL, Freshness.BAD,
			Size.SMALL, StemLength.LONG, "Rose", 100, FlowerType.ONE_FLOWER, false, true);

	private Bouquet bouquet;

	BouquetStub(String name, Event event, Freshness freshness, Size size, StemLength stemLength,
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

    @Before
    public void init() {
	boquet = BouquetStub.BOUQUET_1.getBouquet();
    }

    @Test
    public void testBoquetPrice() {
	int expectedPrice = 100;
	int actualPrice = boquet.getPrice();
	assertEquals(expectedPrice, actualPrice);
    }
}
