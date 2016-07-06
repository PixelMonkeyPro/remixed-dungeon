package com.nyrds.pixeldungeon.mobs.necropolis;

import com.watabou.pixeldungeon.Dungeon;
import com.watabou.pixeldungeon.ResultDescriptions;
import com.watabou.pixeldungeon.actors.Char;
import com.watabou.pixeldungeon.actors.blobs.ToxicGas;
import com.watabou.pixeldungeon.actors.buffs.Amok;
import com.watabou.pixeldungeon.actors.buffs.Blindness;
import com.watabou.pixeldungeon.actors.buffs.Buff;
import com.watabou.pixeldungeon.actors.buffs.Paralysis;
import com.watabou.pixeldungeon.actors.buffs.Poison;
import com.watabou.pixeldungeon.actors.buffs.Sleep;
import com.watabou.pixeldungeon.actors.buffs.Terror;
import com.watabou.pixeldungeon.actors.buffs.Weakness;
import com.watabou.pixeldungeon.actors.mobs.Boss;
import com.watabou.pixeldungeon.actors.mobs.Mob;
import com.watabou.pixeldungeon.items.Gold;
import com.watabou.pixeldungeon.items.weapon.enchantments.Death;
import com.watabou.pixeldungeon.mechanics.Ballistica;
import com.watabou.pixeldungeon.sprites.CharSprite;
import com.watabou.pixeldungeon.utils.GLog;
import com.watabou.pixeldungeon.utils.Utils;
import com.watabou.utils.Random;

/**
 * Created by DeadDie on 12.02.2016
 */
public class Lich extends Boss {
    {
        hp(ht(120));
        EXP = 20;
        defenseSkill = 20;

        baseSpeed = 0f;

        IMMUNITIES.add( Paralysis.class );
        IMMUNITIES.add( ToxicGas.class );
        IMMUNITIES.add( Terror.class );
        IMMUNITIES.add( Death.class );
        IMMUNITIES.add( Amok.class );
        IMMUNITIES.add( Blindness.class );
        IMMUNITIES.add( Sleep.class );
    }


    @Override
    protected boolean canAttack(Char enemy) {
        return Ballistica.cast(getPos(), enemy.getPos(), false, true) == enemy.getPos();
    }

    protected boolean doAttack(Char enemy) {

        if (Dungeon.level.adjacent(getPos(), enemy.getPos())) {
            return super.doAttack(enemy);

        } else {
            boolean visible = Dungeon.level.fieldOfView[getPos()]
                    || Dungeon.level.fieldOfView[enemy.getPos()];
            if (visible) {
                getSprite().zap(enemy.getPos());
            }
            zap();

            return !visible;
        }
    }

    private void zap() {
        spend(1);

        if (hit(this, getEnemy(), true)) {
            if (getEnemy() == Dungeon.hero && Random.Int(2) == 0) {
                Buff.prolong(getEnemy(), Weakness.class, Weakness.duration(getEnemy()));
            }

            int dmg = Random.Int(12, 18);
            getEnemy().damage(dmg, this);

            if (!getEnemy().isAlive() && getEnemy() == Dungeon.hero) {
                Dungeon.fail(Utils.format(ResultDescriptions.MOB,
                        Utils.indefinite(getName()), Dungeon.depth));
            }
        } else {
            getEnemy().getSprite().showStatus(CharSprite.NEUTRAL,
                    getEnemy().defenseVerb());
        }
    }

    @Override
    public int damageRoll() {
        return Random.NormalIntRange( 8, 15 );
    }

    @Override
    public int attackSkill( Char target ) {
        return 20;
    }

    @Override
    public int dr() {
        return 5;
    }


}
