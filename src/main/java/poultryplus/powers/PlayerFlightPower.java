package poultryplus.powers;

import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class PlayerFlightPower extends AbstractPower {
    public static final String POWER_ID = "Flight";

    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("Flight");

    public static final String NAME = powerStrings.NAME;

    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public PlayerFlightPower(AbstractCreature owner, int amount) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amount;
        updateDescription();
        loadRegion("flight");
        this.type = PowerType.BUFF;
        this.priority = 50;
    }

    public void playApplyPowerSfx() {
        CardCrawlGame.sound.play("POWER_FLIGHT", 0.05F);
    }

    public void updateDescription() {
        if (this.amount > 1)
            this.description = DESCRIPTIONS[0] + this.amount + " times.";
        else
            this.description = DESCRIPTIONS[0] + this.amount + " time.";

    }

    public void atStartOfTurn() {
        updateDescription();
    }

    public int onAttacked(DamageInfo info, int damageAmount) {
        if (info.owner != null && info.type != DamageInfo.DamageType.HP_LOSS && info.type != DamageInfo.DamageType.THORNS) {
            flash();
            addToBot(new ReducePowerAction(this.owner, this.owner, "Flight", 1));
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

    }
}
