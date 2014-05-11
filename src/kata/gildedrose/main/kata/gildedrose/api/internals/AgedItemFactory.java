package kata.gildedrose.api.internals;

import kata.gildedrose.api.Item;

public class AgedItemFactory extends ItemFactory {
    public Item createWith(String name, int sellIn, int quality) {
        return new TickableItem(name, sellIn, quality, +1);
    }
}
