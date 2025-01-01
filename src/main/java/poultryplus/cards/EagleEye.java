package poultryplus.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import poultryplus.character.MyCharacter;
import poultryplus.util.CardStats;

public class EagleEye extends BaseCard {
    public static final String ID = makeID("EagleEye");
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.BASIC,
            CardTarget.ENEMY,
            1
    );

    private static final int VULNERABLEMULT = 1;

    public EagleEye() {
        super(ID, info);

        setMagic(VULNERABLEMULT);

        setCostUpgrade(0);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (AbstractDungeon.player.hasPower("Flight")) {
            int VULNERABLE = VULNERABLEMULT * p.getPower("Flight").amount;
            addToBot(new ApplyPowerAction(m, p, new VulnerablePower(m, VULNERABLE, false), magicNumber));
        }
    }
}
