package kata.gildedrose.test;

import kata.gildedrose.api.GildedRose;
import kata.gildedrose.api.Item;
import org.junit.Before;
import org.junit.Test;

import static kata.gildedrose.api.ItemType.*;
import static org.junit.Assert.assertEquals;

public class GildedRoseTest {
    private GildedRose shop;

    @Before
    public void setUp() {
        shop = new GildedRose();
        shop.addItem("+5 Dexterity Vest", 10, 20, NORMAL);
        shop.addItem("Aged Brie", 2, 0, AGED);
        shop.addItem("Sulfuras, Hand of Ragnaros", 0, 80, LEGENDARY);
        shop.addItem("Backstage passes to a TAFKAL80ETC concert", 15, 20, EVENT);
        shop.addItem("Conjured Mana Cake", 5, 20, CONJURED);
    }

    private Item normalItem() {
        return shop.getItem(0);
    }

    private Item agedItem() {
        return shop.getItem(1);
    }

    private Item legendaryItem() {
        return shop.getItem(2);
    }

    private Item eventItem() {
        return shop.getItem(3);
    }

    private Item conjuredItem() {
        return shop.getItem(4);
    }

    private void tickDay() {
        shop.tick();
    }

    private void fastForwardDays(int days) {
        for (int i = 0; i < days; i++)
            tickDay();
    }

    @Test
    public void normalItem_beforeSellDate_DegradesBy1point() {
        assertEquals(20, normalItem().getQuality());
        tickDay();
        assertEquals(19, normalItem().getQuality());
    }

    @Test
    public void normalItem_afterSellDate_DegradesBy2Points() {
        fastForwardDays(10);
        assertEquals(10, normalItem().getQuality());
        tickDay();
        assertEquals(8, normalItem().getQuality());
    }

    @Test
    public void normalItem_whenDegradedToZero_mustNotDegradeAnymore() {
        fastForwardDays(15);
        assertEquals(0, normalItem().getQuality());
        tickDay();
        assertEquals(0, normalItem().getQuality());
    }

    @Test
    public void agedItem_beforeSellDate_upgradesBy1Point() {
        assertEquals(0, agedItem().getQuality());
        tickDay();
        assertEquals(1, agedItem().getQuality());
    }

    @Test
    public void agedItem_afterSellDate_upgradesBy2Points() {
        fastForwardDays(2);
        assertEquals(2, agedItem().getQuality());
        tickDay();
        assertEquals(4, agedItem().getQuality());
    }

    @Test
    public void agedItem_whenUpgradedToFifty_mustNotUpgradeAnymore() {
        fastForwardDays(26);
        assertEquals(50, agedItem().getQuality());
        tickDay();
        assertEquals(50, agedItem().getQuality());
    }

    @Test
    public void legendaryItem_neverHasToBeSold() {
        assertEquals(0, legendaryItem().getSellIn());
    }

    @Test
    public void legendaryItem_neverChangesQuality() {
        assertEquals(80, legendaryItem().getQuality());
        tickDay();
        assertEquals(80, legendaryItem().getQuality());
    }

    @Test
    public void eventItem_11orMoreDaysBeforeSellDate_upgradesBy1Point() {
        assertEquals(20, eventItem().getQuality());
        tickDay();
        assertEquals(21, eventItem().getQuality());
    }

    @Test
    public void eventItem_10orLessDaysBeforeSellDate_upgradesBy2Points() {
        fastForwardDays(5);
        assertEquals(25, eventItem().getQuality());
        tickDay();
        assertEquals(27, eventItem().getQuality());
    }

    @Test
    public void eventItem_5orLessDaysBeforeSellDate_upgradesBy3Points() {
        fastForwardDays(10);
        assertEquals(35, eventItem().getQuality());
        tickDay();
        assertEquals(38, eventItem().getQuality());
    }

    @Test
    public void conjuredItem_beforeSellDate_DegradesBy2points() {
        assertEquals(20, conjuredItem().getQuality());
        tickDay();
        assertEquals(18, conjuredItem().getQuality());
    }

    @Test
    public void conjuredItem_afterSellDate_DegradesBy4Points() {
        fastForwardDays(5);
        assertEquals(10, conjuredItem().getQuality());
        tickDay();
        assertEquals(6, conjuredItem().getQuality());
    }
}
