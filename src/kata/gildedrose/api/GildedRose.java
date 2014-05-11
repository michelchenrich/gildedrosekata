package kata.gildedrose.api;

import kata.gildedrose.api.internals.TickableItem;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {
    private List<Item> items = null;

    public GildedRose() {
        items = new ArrayList<Item>();
    }

    public void addItem(String name, int sellIn, int quality, ItemType type) {
        items.add(type.factory().createWith(name, sellIn, quality));
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public void tick() {
        for (Item item : items)
            tryTick(item);
    }

    private void tryTick(Item item) {
        try {
            ((TickableItem) item).tick();
        } catch (ClassCastException ignored) {
        }
    }
}