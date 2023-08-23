package GildedRose;

class GildedRose_1 {
    Item[] items;

    public GildedRose_1(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Aged Brie")) {
                updateQualityForAgedBrie(item);
            }
            else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateQualtiyForBackstage(item);
            }
            else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                updateQualityForSulfuras(item);
            }

            else {// 일반 아이템인경우
                updateQualityForNormal(item);
            }

            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            }
            else {
                item.sellIn = item.sellIn - 1;
            }


        }
    }

    private static void updateQualityForNormal(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        if(item.sellIn < 1) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }

    private void updateQualityForSulfuras(Item item) {
        return; // 빈함수
    }

    private static void updateQualtiyForBackstage(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
        if (item.sellIn < 1){
            item.quality = 0;
        }
    }

    private static void updateQualityForAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        if (item.sellIn < 1) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }
}