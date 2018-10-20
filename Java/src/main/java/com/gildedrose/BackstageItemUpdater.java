package com.gildedrose;

import java.util.Objects;

public class BackstageItemUpdater implements ItemUpdater{
    @Override
    public boolean managesItem(Item item) {
        return Objects.equals(item.name,GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT);
    }

    @Override
    public void updateItemQuality(Item item) {
        if(item.sellIn>10)
            item.quality++;
        else if(item.sellIn>5)
            item.quality+=2;
        else if(item.sellIn>0)
            item.quality+=3;
        else
            item.quality=0;
    }
}
