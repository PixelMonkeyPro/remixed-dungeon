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
package com.watabou.pixeldungeon.windows;

import com.nyrds.platform.game.Game;
import com.watabou.pixeldungeon.actors.Char;
import com.watabou.pixeldungeon.utils.Utils;
import com.watabou.utils.Random;

public class WndQuest extends WndTitledMessage {
	
	public WndQuest(Char questgiver, String text ) {
		super( questgiver.newSprite(), Utils.capitalize( questgiver.getName() ), text );
	}

	public WndQuest( Char questgiver, int ... phrases ) {
		this(questgiver, Game.getVar(phrases[Random.Int(0, phrases.length)]));
	}
}
