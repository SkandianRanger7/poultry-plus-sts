package poultryplus.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import poultryplus.character.MyCharacter;
import poultryplus.util.CardStats;

public class AerialAce extends BaseCard {
    public static final String ID = makeID("AerialAce");
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );
    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 8;
    private static final int EXTRA_DMG = 4;
    private static final int UPG_EXTRA_DMG = 6;

    public AerialAce() {
        super(ID, info);

        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(EXTRA_DMG, UPG_EXTRA_DMG);
    }

    public void calculateCardDamage(AbstractMonster mo) {
        int realBaseDamage = this.baseDamage;
        if (mo.hasPower("Vulnerable")) {
            this.baseDamage += this.magicNumber;
        }
        super.calculateCardDamage(mo);
        this.baseDamage = realBaseDamage;
        this.isDamageModified = (this.damage != this.baseDamage);
    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
    }
}
