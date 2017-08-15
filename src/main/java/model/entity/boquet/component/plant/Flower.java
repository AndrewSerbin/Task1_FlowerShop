package model.entity.boquet.component.plant;

import model.entity.boquet.component.Component;

public class Flower extends Component {

    private FlowerType type;

    private boolean isFeed;

    private boolean isSupport;

    public Flower(String name, int price, FlowerType type, boolean needFeed, boolean needSupport) {
	super(name, price);
	this.type = type;
	this.isFeed = needFeed;
	this.isSupport = needSupport;
    }

    public FlowerType getType() {
	return type;
    }

    public void setType(FlowerType type) {
	this.type = type;
    }

    public boolean isFeed() {
	return isFeed;
    }

    public void setFeed(boolean needFeed) {
	this.isFeed = needFeed;
    }

    public boolean isSupport() {
	return isSupport;
    }

    public void setSupport(boolean needSupport) {
	this.isSupport = needSupport;
    }
}
