package kata.gildedrose.api;

import kata.gildedrose.api.internals.*;

public enum ItemType {
    NORMAL(new NormalItemFactory()),
    AGED(new AgedItemFactory()),
    LEGENDARY(new ItemFactory()),
    EVENT(new EventItemFactory()),
    CONJURED(new ConjuredItemFactory());
    private final ItemFactory factory;

    private ItemType(ItemFactory factory) {
        this.factory = factory;
    }

    public ItemFactory factory() {
        return factory;
    }
}
