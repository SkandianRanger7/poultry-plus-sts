package poultryplus.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import poultryplus.character.MyCharacter;
import poultryplus.util.CardStats;

public class Woodpecker extends BaseCard {
    public static final String ID = makeID("Woodpecker");
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            AbstractCard.CardType.ATTACK,
            AbstractCard.CardRarity.RARE,
            AbstractCard.CardTarget.ENEMY,
            1
    );
    private static final int DAMAGE = 1;
    private static final int VULNERABLE = 3;
    private static final int UPG_VULNERABLE = 2;

    public Woodpecker() {
        super(ID, info);

        setDamage(DAMAGE);
        setMagic(VULNERABLE, UPG_VULNERABLE);


    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < 7; i++) {
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        }
        addToBot(new ApplyPowerAction(p, p, new VulnerablePower(p, magicNumber, false)));
    }
}
