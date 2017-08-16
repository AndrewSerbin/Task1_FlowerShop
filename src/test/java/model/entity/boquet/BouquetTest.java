package model.entity.boquet;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import model.entity.boquet.builder.BouquetBuilder;
import model.entity.boquet.component.accessory.Accessory;
import model.entity.boquet.component.accessory.AccessoryType;
import model.entity.boquet.component.plant.Flower;
import model.entity.boquet.component.plant.FlowerType;
import model.entity.boquet.exception.IncompleteBouquetInitialization;

public class BouquetTest {

    Bouquet boquet;

    @Before
    public void init() {
	try {
	    boquet = new BouquetBuilder()
		    .setName("Boquet")
		    .setEvent(Event.ALL)
		    .setFreshness(Freshness.NORMALLY)
		    .setSize(Size.SMALL)
		    .setStemLength(StemLength.SHORT)
		    .addAccessory(new Accessory("Acc", 100, AccessoryType.BASKET))
		    .addFlower(new Flower("Rosa", 100, FlowerType.ONE_FLOWER, false, true))
		    .build();
	} catch (IncompleteBouquetInitialization e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void testBoquetPrice() {
	int expectedPrice = 200;
	int actualPrice = boquet.getPrice();
	Assert.assertEquals(expectedPrice, actualPrice);
    }
}
