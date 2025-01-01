package poultryplus.cards;

import com.badlogic.gdx.utils.compression.lzma.Base;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import poultryplus.character.MyCharacter;
import poultryplus.util.CardStats;

public class Omelette extends BaseCard {
    // Gain all next turn effects immediately
    public static final String ID = makeID("Omelette");
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            AbstractCard.CardType.SKILL,
            AbstractCard.CardRarity.RARE,
            AbstractCard.CardTarget.SELF,
            1
    );

    public Omelette() {
        super(ID, info);

        setCostUpgrade(0);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.player.applyStartOfTurnPowers();
    }
}
