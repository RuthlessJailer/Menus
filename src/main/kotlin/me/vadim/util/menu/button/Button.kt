package me.vadim.util.menu.button

import me.vadim.util.menu.Menu
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack

/**
 * Represents a button within a [Menu].
 * Buttons are slot-based, therefore if the item is modified it will not affect the functionality of the button.
 *
 * @author vadim
 */
interface Button {

	var item: ItemStack

	/**
	 * Whether or not to cancel the click event for this button.
	 */
	val protect: Boolean

	val click: Menu.(InventoryClickEvent, Button) -> Unit

}