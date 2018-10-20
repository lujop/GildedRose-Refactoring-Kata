package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GildedRoseTest {
    private static String NORMAL_ITEM = "+5 Dexterity Vest";

    @Test
    public void testUpdateOnNormalNotExpiredItem() {
        Item item = new Item(NORMAL_ITEM,10,10);
        updateItem(item,1);
        assertEquals(item.sellIn,9);
        assertEquals(item.quality,9);
    }

    @Test
    public void testMultipleUpdateOnNormalNotExpiredItem() {
        Item item = new Item(NORMAL_ITEM,10,10);
        updateItem(item,5);
        assertEquals(item.sellIn,5);
        assertEquals(item.quality,5);
    }

    @Test
    public void testMultipleUpdateOnNormalExpiredItem() {
        Item item = new Item(NORMAL_ITEM,1,10);
        updateItem(item,5);
        assertEquals(item.sellIn,-4);
        assertEquals(item.quality,10-1-4*2);
    }

    @Test
    public void testQualityNeverNegative() {
        Item item = new Item(NORMAL_ITEM,1,1);
        updateItem(item,100);
        assertEquals(item.quality,0);

        item = new Item(GildedRose.SULFURAS_HAND_OF_RAGNAROS,1,80);
        updateItem(item,100);
        assertTrue(item.quality>=0);

        item = new Item(GildedRose.AGED_BRIE,1,1);
        updateItem(item,100);
        assertTrue(item.quality>=0);
    }

    @Test
    public void testAgedBrieIncreasesQuality() {
        Item item = new Item(GildedRose.AGED_BRIE,10,10);
        updateItem(item,5);
        assertEquals(item.sellIn,5);
        assertEquals(item.quality,15);
    }

    @Test
    public void testItemQualityMax() {
        Item item = new Item(GildedRose.AGED_BRIE,10,10);
        updateItem(item,100);
        assertTrue(item.quality<=50);
    }

    @Test
    public void testSulfurasIsNotModified() {
        Item item = new Item(GildedRose.SULFURAS_HAND_OF_RAGNAROS,10,80);
        updateItem(item,100);
        assertEquals(item.sellIn,10);
        assertEquals(item.quality,80);
    }

    @Test
    public void testBackstagePassIncreasesQuality() {
        Item item = new Item(GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT,12,10);
        updateItem(item,10);
        assertEquals(item.sellIn,2);
        assertEquals(item.quality,10 + 2 + 5*2 + 3*3);
    }

    @Test
    public void testBackstagePassDropsToZeroOnExpired() {
        Item item = new Item(GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT,12,20);
        updateItem(item,15);
        assertEquals(item.sellIn,-3);
        assertEquals(item.quality,0);
    }

    @Test
    public void testUpdateOnConjuredItem() {
        Item item = new Item(GildedRose.CONJURED,10,10);
        updateItem(item,1);
        assertEquals(item.sellIn,9);
        assertEquals(item.quality,8);
    }

    @Test
    public void testMultipleUpdateOnConjuredNotExpiredItem() {
        Item item = new Item(GildedRose.CONJURED,10,10);
        updateItem(item,5);
        assertEquals(item.sellIn,5);
        assertEquals(item.quality,0);
    }

    @Test
    public void testMultipleUpdateOnConjuredExpiredItem() {
        Item item = new Item(GildedRose.CONJURED,1,20);
        updateItem(item,5);
        assertEquals(item.sellIn,-4);
        assertEquals(item.quality,20-2-4*4);
    }


    private void updateItem(Item item, int times) {
        GildedRose app = new GildedRose(new Item[]{item});
        for(int i=0; i<times;i++) {
            app.updateQuality();
        }
    }

}
