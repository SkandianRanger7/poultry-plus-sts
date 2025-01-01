package poultryplus.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import poultryplus.character.MyCharacter;
import poultryplus.powers.NextTurnFlightMultPower;
import poultryplus.powers.NextTurnFlightPower;
import poultryplus.util.CardStats;

public class CondorEgg extends BaseCard{
   // Gain block, double flight next turn
   public static final String ID = makeID("CondorEgg");
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            AbstractCard.CardType.SKILL,
            AbstractCard.CardRarity.UNCOMMON,
            AbstractCard.CardTarget.SELF,
            1
    );
    private static final int BLOCK = 5;
    private static final int UPG_BLOCK = 3;
    private static final int FLIGHTMULT = 1;

    public CondorEgg() {
        super(ID, info);

        setBlock(BLOCK, UPG_BLOCK);
        setMagic(FLIGHTMULT);

        tags.add(AbstractCard.CardTags.STARTER_DEFEND);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new ApplyPowerAction(p, p, new NextTurnFlightMultPower(p, magicNumber)));
    }
}
