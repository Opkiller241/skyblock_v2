package itzkiller.gui;

import itzkiller.item.swords;
import net.minestom.server.entity.Player;
import net.minestom.server.inventory.Inventory;
import net.minestom.server.inventory.InventoryType;
import net.minestom.server.inventory.click.ClickType;

public class ItemGui {
    final Inventory inventory;

    public ItemGui() {

        inventory = new Inventory(InventoryType.CHEST_6_ROW, "CUSTOM ITEMS");
        inventory.setItemStack(0, swords.test());
        inventory.addInventoryCondition((player, i, clickType, inventoryConditionResult) -> {
            if (i == 0 && clickType == ClickType.LEFT_CLICK) {
                player.getInventory().addItemStack(swords.test());
                inventoryConditionResult.setCancel(true);
            }
        });
    }

        public void open (Player player){
          player.openInventory(inventory);
        }
    }