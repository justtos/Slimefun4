package io.github.thebusybiscuit.slimefun4.implementation.items.cargo;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.cscorelib2.chat.ChatColors;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SimpleSlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockUseHandler;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.api.item_transport.CargoNet;

public class CargoConnector extends SimpleSlimefunItem<BlockUseHandler> {

	public CargoConnector(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, ItemStack recipeOutput) {
		super(category, item, recipeType, recipe, recipeOutput);
	}
	
	@Override
	public BlockUseHandler getItemHandler() {
		return e -> {
			Player p = e.getPlayer();
			Block b = e.getClickedBlock().get();

			if (CargoNet.getNetworkFromLocation(b.getLocation()) != null) {
				p.sendMessage(ChatColors.color("&7Connected: " + "&2\u2714"));
			}
			else {
				p.sendMessage(ChatColors.color("&7Connected: " + "&4\u2718"));
			}
		};
	}
}