package poultryplus.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import poultryplus.character.MyCharacter;
import poultryplus.util.CardStats;
import poultryplus.util.EggBanditFollowUpAction;

public class EggBandit extends BaseCard {
    // Draw but specifically for egg cards
    public static final String ID = makeID("EggBandit");
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            AbstractCard.CardType.ATTACK,
            AbstractCard.CardRarity.UNCOMMON,
            AbstractCard.CardTarget.ENEMY,
            1
    );
    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 3;
    private static final int EXT_DMG = 4;
    private static final int DRAW = 4;

    public EggBandit() {
        super(ID, info);

        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(DRAW);
        setCustomVar("extraDmg", VariableType.DAMAGE, EXT_DMG);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        addToBot(new DrawCardAction(this.magicNumber, new EggBanditFollowUpAction()));
        for (AbstractCard c : DrawCardAction.drawnCards) {
            if (c.cardID.toLowerCase().contains("egg")) {
                addToBot(new DamageAction(m, new DamageInfo(p, customVar("extraDmg"), DamageInfo.DamageType.NORMAL)));
            }
        }
    }
}
