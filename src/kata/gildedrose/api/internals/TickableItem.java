package kata.gildedrose.api.internals;

import kata.gildedrose.api.Item;

public class TickableItem extends Item {
    protected int rate;

    public TickableItem(String name, int sellIn, int quality, int rate) {
        super(name, sellIn, quality);
        this.rate = rate;
    }

    public final void tick() {
        applyRate();

        if (quality < 0) quality = 0;
        if (quality > 50) quality = 50;

        if (sellIn > 0) sellIn--;
    }

    protected void applyRate() {
        if (sellIn == 0) quality += (rate * 2);
        else quality += rate;
    }
}
