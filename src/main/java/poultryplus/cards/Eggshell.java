package poultryplus.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import poultryplus.character.MyCharacter;
import poultryplus.powers.NextTurnFlightPower;
import poultryplus.util.CardStats;

public class Eggshell extends BaseCard{
    public static final String ID = makeID("Eggshell");
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            1
    );
    private static final int BLOCK = 5;
    private static final int UPG_BLOCK = 3;
    private static final int FLIGHT = 1;

    public Eggshell() {
        super(ID, info);

        setBlock(BLOCK, UPG_BLOCK);
        setMagic(FLIGHT);

        tags.add(CardTags.STARTER_DEFEND);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new ApplyPowerAction(p, p, new NextTurnFlightPower(p, magicNumber)));
    }
}
