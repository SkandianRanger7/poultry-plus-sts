package poultryplus.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.DiscardSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import poultryplus.character.MyCharacter;
import poultryplus.util.CardStats;

public class Gust extends BaseCard {
    public static final String ID = makeID("Gust");
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            AbstractCard.CardType.ATTACK,
            AbstractCard.CardRarity.COMMON,
            CardTarget.ALL_ENEMY,
            1
    );
    private static final int DAMAGE = 7;
    private static final int UPG_DAMAGE = 4;

    public Gust() {
        super(ID, info);

        setDamage(DAMAGE, UPG_DAMAGE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!AbstractDungeon.player.hand.isEmpty()) {
            if (this == AbstractDungeon.player.hand.group.get(AbstractDungeon.player.hand.size() - 1)) {
                addToBot(new DiscardSpecificCardAction(AbstractDungeon.player.hand.group.get(AbstractDungeon.player.hand.size() - 2)));
            } else {
                addToBot(new DiscardSpecificCardAction(AbstractDungeon.player.hand.group.get(AbstractDungeon.player.hand.size() - 1)));
            }
        }
        addToBot(new DamageAllEnemiesAction(p, damage, DamageInfo.DamageType.NORMAL, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));

    }
}
