package poultryplus.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import poultryplus.character.MyCharacter;
import poultryplus.powers.PlayerFlightPower;
import poultryplus.util.CardStats;

public class Soar extends BaseCard {
    // Gain 1 flight draw 1 card
    public static final String ID = makeID("Soar");
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            AbstractCard.CardType.SKILL,
            CardRarity.UNCOMMON,
            AbstractCard.CardTarget.SELF,
            1
    );
    private static final int FLIGHT = 1;
    private static final int UPG_FLIGHT = 1;
    private static final int DRAW = 2;

    public Soar() {
        super(ID, info);

        setMagic(FLIGHT, UPG_FLIGHT);
        setCustomVar("soarDraw", VariableType.MAGIC, DRAW);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new PlayerFlightPower(p, magicNumber)));
        addToBot(new DrawCardAction(customVar("soarDraw")));
    }
}
