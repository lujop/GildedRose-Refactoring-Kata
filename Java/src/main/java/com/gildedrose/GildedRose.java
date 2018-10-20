package com.gildedrose;

import java.util.Optional;

class GildedRose {
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String CONJURED = "Conjured";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItemQuality(items[i]);
        }
    }

    private void updateItemQuality(Item item) {
        Optional<ItemUpdater> foundUpdater = ItemUpdatersManager.get().findItemUpdaterForItem(item);
        if(foundUpdater.isPresent()) {
            ItemUpdater updater = foundUpdater.get();
            updater.updateItemQuality(item);
            updater.updateItemSellIn(item);
        }
    }
}