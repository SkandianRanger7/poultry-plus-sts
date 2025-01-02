package poultryplus.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import poultryplus.character.MyCharacter;
import poultryplus.powers.OstrichFormPower;
import poultryplus.util.CardStats;

public class OstrichForm extends BaseCard {
    public static final String ID = makeID("OstrichForm");
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.POWER,
            CardRarity.RARE,
            CardTarget.SELF,
            2
    );
    private static final int BUFF = 3;
    private static final int UPG_BUFF = 1;

    public OstrichForm() {
        super(ID, info);

        setMagic(BUFF, UPG_BUFF);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, magicNumber)));
        addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, magicNumber)));
        addToBot(new ApplyPowerAction(p, p, new OstrichFormPower(p, magicNumber)));
    }
}