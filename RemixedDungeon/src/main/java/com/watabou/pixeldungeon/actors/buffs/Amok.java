/*
 * Pixel Dungeon
 * Copyright (C) 2012-2014  Oleg Dolya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.watabou.pixeldungeon.actors.buffs;

import com.nyrds.pixeldungeon.ml.R;
import com.nyrds.platform.util.StringsManager;
import com.watabou.pixeldungeon.sprites.CharSprite;
import com.watabou.pixeldungeon.ui.BuffIndicator;

public class Amok extends FlavourBuff {
	
	@Override
	public int icon() {
		return BuffIndicator.AMOK;
	}
	
	@Override
	public String name() {
        return StringsManager.getVar(R.string.AmokBuff_Name);
    }

	@Override
	public String desc() {
        return StringsManager.getVar(R.string.AmokBuff_Info);
    }

	@Override
	public void attachVisual() {
        target.getSprite().showStatus(CharSprite.NEGATIVE, StringsManager.getVar(R.string.Char_StaAmok));
	}
}
