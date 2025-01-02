package poultryplus.cards;


import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import poultryplus.character.MyCharacter;
import poultryplus.powers.PlayerFlightPower;
import poultryplus.util.CardStats;

public class QuickPeck extends BaseCard {
    public static final String ID = makeID("QuickPeck");
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            AbstractCard.CardType.ATTACK,
            AbstractCard.CardRarity.COMMON,
            AbstractCard.CardTarget.ENEMY,
            1
    );
    private static final int DAMAGE = 4;
    private static final int FLIGHT = 1;
    private static final int UPG_DAMAGE = 3;
    private static final int UPG_FLIGHT = 1;

    public QuickPeck() {
        super(ID, info);

        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(FLIGHT, UPG_FLIGHT);


    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        addToBot(new ApplyPowerAction(p, p, new PlayerFlightPower(p, magicNumber)));
    }
}
