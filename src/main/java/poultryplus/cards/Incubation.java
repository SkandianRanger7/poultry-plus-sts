package poultryplus.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;
import poultryplus.character.MyCharacter;
import poultryplus.util.CardStats;

public class Incubation extends BaseCard{
    // Double next turn effects
    public static final String ID = makeID("Incubation");
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            AbstractCard.CardType.SKILL,
            CardRarity.UNCOMMON,
            AbstractCard.CardTarget.SELF,
            1
    );

    public Incubation() {
        super(ID, info);

        setCostUpgrade(0);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (AbstractDungeon.player.powers != null){
            for (AbstractPower power : AbstractDungeon.player.powers) {
                if (power.ID.contains("Next")){
                    power.flash();
                    power.amount = power.amount * 2;
                }
            }
        }
    }
}
