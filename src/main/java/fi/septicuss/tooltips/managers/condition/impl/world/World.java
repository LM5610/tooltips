package fi.septicuss.tooltips.managers.condition.impl.world;

import fi.septicuss.tooltips.managers.condition.Condition;
import fi.septicuss.tooltips.managers.condition.Context;
import fi.septicuss.tooltips.managers.condition.argument.Arguments;
import fi.septicuss.tooltips.managers.condition.type.MultiString;
import fi.septicuss.tooltips.utils.validation.Validity;
import org.bukkit.entity.Player;

public class World implements Condition {

	private static final String[] WORLD = { "name" };

	@Override
	public boolean check(Player player, Arguments args) {
		MultiString multi = MultiString.of(args.get(WORLD).getAsString());
		return multi.contains(player.getWorld().getName());
	}

	@Override
	public void writeContext(Player player, Arguments args, Context context) {
		context.put("world", player.getWorld().getName());
	}

	@Override
	public Validity valid(Arguments args) {
		if (!args.has(WORLD)) {
			return Validity.of(false, "Must have the world name argument");
		}

		return Validity.TRUE;
	}

	@Override
	public String id() {
		return "world";
	}
}
