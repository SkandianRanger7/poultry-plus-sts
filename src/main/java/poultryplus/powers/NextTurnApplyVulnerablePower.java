package poultryplus.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import static poultryplus.BasicMod.makeID;

public class NextTurnApplyVulnerablePower extends BasePower{
    public static final String POWER_ID = makeID("NextTurnApplyVulnerable");
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public NextTurnApplyVulnerablePower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public void atStartOfTurn() {
        flash();
        for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters){
            addToBot(new ApplyPowerAction(mo, this.owner, new VulnerablePower(this.owner, this.amount, false)));
        }
        addToTop(((AbstractGameAction) new RemoveSpecificPowerAction(this.owner, this.owner, this.POWER_ID)));
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }
}

