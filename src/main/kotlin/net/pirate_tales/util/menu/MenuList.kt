package net.pirate_tales.util.menu

import net.pirate_tales.util.menu.button.Button
import net.pirate_tales.util.menu.impl.MenuFill
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack

/**
 * An extension of [Menu], providing logic to automatically create and page through a list of items.
 *
 * @author RuthlessJailer
 */
interface MenuList<T> : Menu, FillHolder {

	/* Characteristics. */

	/**
	 * The template (title, previous button, etc.) to be used for each page.
	 */
	val template: Menu

	val transformer: (T) -> ItemStack

	/**
	 * The layout, treating [MenuFill.included] as slots for [items].
	 *
	 * If nothing is supplied (for the constructor/builder), occupied slots will be automatically appended mapped to [MenuFill.excluded].
	 */
	val fill: MenuFill

	/* Page buttons. */

	/**
	 * The next page button.
	 *
	 * A [Pair] so that the slot can be specified (*with Kotlin's [to] function*) and accessed conveniently.
	 */
	val next: Pair<Button, Int>

	/**
	 * The back page button.
	 *
	 * A [Pair] so that the slot can be specified (*with Kotlin's [to] function*) and accessed conveniently.
	 */
	val back: Pair<Button, Int>

	/* Event callbacks. */

	/**
	 * Called when an item is select from the list.
	 */
	val select: MenuList<T>.(InventoryClickEvent, Button, T) -> Unit

	/**
	 * Called when a page is changed. This is called before [Button.click], and will cancel the [Button.click] callback if `false` is returned.
	 *
	 * The parameter order = event, button, from, to
	 */
	val page: MenuList<T>.(InventoryClickEvent, Button, Int, Int) -> Boolean

	/**
	 * [MenuList]s are mutable. If this collection is mutated, [generate] (and optionally [update]) must be called to reflect changes.
	 */
	val items: MutableList<T>

}