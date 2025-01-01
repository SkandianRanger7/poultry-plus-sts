package poultryplus.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static poultryplus.BasicMod.makeID;

public class NextTurnFlightPower extends BasePower {
    public static final String POWER_ID = makeID("NextTurnFlight");
    private static final AbstractPower.PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public NextTurnFlightPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public void atStartOfTurn() {
        flash();
        addToBot(new ApplyPowerAction(this.owner, this.owner, new PlayerFlightPower(this.owner, this.amount)));
        addToTop(((AbstractGameAction) new RemoveSpecificPowerAction(this.owner, this.owner, this.POWER_ID)));
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }
}

