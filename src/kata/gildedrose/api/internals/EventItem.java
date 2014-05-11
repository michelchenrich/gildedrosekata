package kata.gildedrose.api.internals;

public class EventItem extends TickableItem {
    public EventItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality, 0);
    }

    public void applyRate() {
        if (sellIn == 0) quality = 0;
        else if (sellIn <= 5) quality += 3;
        else if (sellIn <= 10) quality += 2;
        else quality++;
    }
}
