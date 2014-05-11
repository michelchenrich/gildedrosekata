package kata.gildedrose.api.internals;

import kata.gildedrose.api.Item;

public class ItemFactory {
    public Item createWith(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }
}
