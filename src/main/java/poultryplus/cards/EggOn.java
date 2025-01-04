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

public class EggOn extends BaseCard {
    // Give an enemy vulnerable for each next turn effect you have
    public static final String ID = makeID("EggOn");
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            AbstractCard.CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            0
    );

    public EggOn() {
        super(ID, info);

        setCostUpgrade(0);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int count = 0;

        if (AbstractDungeon.player.powers != null) {
            for (AbstractPower power : AbstractDungeon.player.powers) {
                if (power.ID.contains("Next")) {
                    count++;
                }
            }
            if (count > 0) {
                addToBot(new ApplyPowerAction(m, p, new WeakPower(m, count, false)));
                addToBot(new ApplyPowerAction(m, p, new VulnerablePower(m, count, false)));
            }
        }

    }
}
