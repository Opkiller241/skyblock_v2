package itzkiller.item;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.minestom.server.item.ItemComponent;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;



public class swords {
    public static ItemStack test() {

        return ItemStack.builder(Material.DIAMOND_SWORD).set(ItemComponent.ITEM_NAME, Component.text("TEST", NamedTextColor.BLUE)).lore(Component.text("This is a custom test sword"))
                .build();

    }
}
