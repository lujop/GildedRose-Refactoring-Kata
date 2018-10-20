package com.gildedrose;

import java.util.Objects;

public class RagnarosItemUpdater implements ItemUpdater{
    @Override
    public boolean managesItem(Item item) {
        return Objects.equals(item.name,GildedRose.SULFURAS_HAND_OF_RAGNAROS);
    }

    @Override
    public void updateItemSellIn(Item item) {

    }

    @Override
    public void updateItemQuality(Item item) {

    }
}
