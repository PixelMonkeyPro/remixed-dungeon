package com.watabou.pixeldungeon.items.armor;

import com.nyrds.pixeldungeon.ml.R;
import com.nyrds.platform.game.Game;
import com.watabou.pixeldungeon.actors.Char;
import com.watabou.pixeldungeon.actors.hero.HeroSubClass;
import com.watabou.pixeldungeon.utils.GLog;

import org.jetbrains.annotations.NotNull;

public class WarlockArmor extends MageArmor {

	{
		name = Game.getVar(R.string.MageArmor_Name);
		hasCollar = true;
		image = 13;
	}

	@Override
	public boolean doEquip(@NotNull Char hero ) {
		if (hero.getSubClass() == HeroSubClass.WARLOCK) {
			return super.doEquip( hero );
		} else {
			GLog.w( Game.getVar(R.string.MageArmor_NotMage) );
			return false;
		}
	}
}