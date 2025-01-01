package poultryplus.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import poultryplus.character.MyCharacter;
import poultryplus.powers.SkyDropPower;
import poultryplus.util.CardStats;

public class SkyDrop extends BaseCard{
    // Lose all flight and give to enemy, once they lose it they take damage based on how much flight
    public static final String ID = makeID("SkyDrop");
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            AbstractCard.CardType.SKILL,
            CardRarity.RARE,
            AbstractCard.CardTarget.ENEMY,
            2
    );

    private static final int INTENSITY = 10;
    private static final int DURATION = 5;

    public SkyDrop(){
        super(ID, info);

        setMagic(INTENSITY);

        setCostUpgrade(1);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(m, p, new SkyDropPower(m, DURATION, INTENSITY)));
    }
}
