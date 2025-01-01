package poultryplus.util;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class EggBanditFollowUpAction extends AbstractGameAction {
    public void update() {
        AbstractDungeon.actionManager.addToTop(new WaitAction(0.4F));
        tickDuration();
        if (this.isDone)
            for (AbstractCard c : DrawCardAction.drawnCards) {
                if (!c.cardID.toLowerCase().contains("egg")) {
                    AbstractDungeon.player.hand.moveToDiscardPile(c);
                    c.triggerOnManualDiscard();
                    GameActionManager.incrementDiscard(false);
                }
            }
    }
}
