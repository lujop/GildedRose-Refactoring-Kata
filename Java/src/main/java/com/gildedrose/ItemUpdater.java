package com.gildedrose;

public interface ItemUpdater {
    boolean managesItem(Item item);
    default void updateItemSellIn(Item item) {
        item.sellIn--;
    }
    default void updateItemQuality(Item item) {
        int qualityDecrease = 1;
        if(item.sellIn<=0)
            qualityDecrease = 2;

        if(item.quality>=qualityDecrease)
            item.quality -= qualityDecrease;
    }
}
