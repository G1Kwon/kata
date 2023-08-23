package GildedRose;

import junit.framework.TestCase;
import org.junit.Test;

public class GildedRoseTest extends TestCase {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

}