package com.gildedrose;

public class NormalItemUpdater implements ItemUpdater{
    @Override
    public boolean managesItem(Item item) {
        return true;
    }
}
