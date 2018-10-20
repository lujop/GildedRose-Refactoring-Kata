package com.gildedrose;

import java.util.Objects;

public class AgedBrieItemUpdater implements ItemUpdater{
    @Override
    public boolean managesItem(Item item) {
        return Objects.equals(item.name,GildedRose.AGED_BRIE);
    }

    @Override
    public void updateItemQuality(Item item) {
        if(item.quality<50)
            item.quality++;
    }
}
