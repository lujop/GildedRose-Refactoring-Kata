package com.gildedrose;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemUpdatersManager {
    private static final ItemUpdatersManager INSTANCE = new ItemUpdatersManager();

    private List<ItemUpdater> itemUpdaters = new ArrayList<>();

    private ItemUpdatersManager() {
        itemUpdaters.add(new RagnarosItemUpdater());
        itemUpdaters.add(new AgedBrieItemUpdater());
        itemUpdaters.add(new BackstageItemUpdater());
        itemUpdaters.add(new ConjuredItemUpdater());
        itemUpdaters.add(new NormalItemUpdater());
    }

    public Optional<ItemUpdater> findItemUpdaterForItem(Item item) {
        return itemUpdaters.stream().filter(updater -> updater.managesItem(item)).findFirst();
    }

    public static ItemUpdatersManager get() {
        return INSTANCE;
    }
}
