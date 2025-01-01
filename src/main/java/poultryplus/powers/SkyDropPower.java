package poultryplus.powers;

import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static poultryplus.BasicMod.makeID;

public class SkyDropPower extends BasePower {
    public static final String POWER_ID = makeID("SkyDrop");
    private static final AbstractPower.PowerType TYPE = PowerType.DEBUFF;
    private static final boolean TURN_BASED = false;
    private static final float DMG_MULT = 0.5f;
    private static int FINAL_DMG = 0;

    public SkyDropPower(AbstractCreature owner, int amount, int intensity) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
        FINAL_DMG = amount * intensity;
    }

    public void atStartOfTurn() {
        updateDescription();
    }

    public int onAttacked(DamageInfo info, int damageAmount) {
        if (info.owner != null && info.type != DamageInfo.DamageType.HP_LOSS && info.type != DamageInfo.DamageType.THORNS) {
            flash();
            addToBot(new ReducePowerAction(this.owner, this.owner, POWER_ID, 1));
        }
        return damageAmount;
    }

    public float atDamageReceive(float damage, DamageInfo.DamageType type) {
        if (type == DamageInfo.DamageType.NORMAL) {
            return damage * 0.5F;
        }
        return damage;
    }

    public void onRemove() {
        addToBot(new DamageAction(this.owner, new DamageInfo(AbstractDungeon.player, FINAL_DMG, DamageInfo.DamageType.THORNS)));
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + (int) (DMG_MULT * 100) + DESCRIPTIONS[1] + this.amount + DESCRIPTIONS[2] + FINAL_DMG + DESCRIPTIONS[3];
    }
}
