package kata.gildedrose.api.internals;

import kata.gildedrose.api.Item;

public class EventItemFactory extends ItemFactory {
    public Item createWith(String name, int sellIn, int quality) {
        return new EventItem(name, sellIn, quality);
    }
}
