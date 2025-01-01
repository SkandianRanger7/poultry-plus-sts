package poultryplus.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static poultryplus.BasicMod.makeID;

public class NextTurnFlightMultPower extends BasePower{
    public static final String POWER_ID = makeID("NextTurnFlightMult");
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public NextTurnFlightMultPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public void atStartOfTurn() {
        if (AbstractDungeon.player.hasPower("Flight")) {
            flash();
            int CURRENT_FLIGHT = AbstractDungeon.player.getPower("Flight").amount;
            addToBot(new ApplyPowerAction(this.owner, this.owner, new PlayerFlightPower(this.owner, this.amount * CURRENT_FLIGHT)));
        }
        addToTop((new RemoveSpecificPowerAction(this.owner, this.owner, this.POWER_ID)));
    }
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + (this.amount + 1) + DESCRIPTIONS[1];
    }
}
