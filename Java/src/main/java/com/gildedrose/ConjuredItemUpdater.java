package com.gildedrose;

import java.util.Objects;

public class ConjuredItemUpdater implements ItemUpdater{
    @Override
    public boolean managesItem(Item item) {
        return item.name.contains(GildedRose.CONJURED);
    }

    @Override
    public void updateItemQuality(Item item) {
        ItemUpdater.super.updateItemQuality(item);
        ItemUpdater.super.updateItemQuality(item);
    }
}
