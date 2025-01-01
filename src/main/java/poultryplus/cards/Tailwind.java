package poultryplus.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import poultryplus.character.MyCharacter;
import poultryplus.powers.TailwindPower;
import poultryplus.util.CardStats;

public class Tailwind extends BaseCard{
    // When flight is applied, apply one more
    // NEEDS CODE PATCH
    public static final String ID = makeID("Tailwind");
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            AbstractCard.CardType.POWER,
            AbstractCard.CardRarity.UNCOMMON,
            AbstractCard.CardTarget.SELF,
            1
    );

    int FLIGHT = 1;
    int UPG_FLIGHT = 2;

    public Tailwind() {
        super(ID, info);

        setMagic(FLIGHT, UPG_FLIGHT);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new TailwindPower(p, magicNumber)));
    }
}
