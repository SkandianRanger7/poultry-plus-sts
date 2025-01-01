package poultryplus.patches;

import com.evacipated.cardcrawl.modthespire.lib.ByRef;
import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch2;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import poultryplus.relics.HookedBeak;

@SpirePatch2(
        clz = VulnerablePower.class,
        method = "updateDescription"
)
public class VulnerableTooltipPatch {


    @SpireInsertPatch(
            loc = 55,
            localvars = {"owner", "DESCRIPTIONS", "amount", "description"}
    )
    public static SpireReturn<Void> Insert(AbstractCreature owner, String[] DESCRIPTIONS, int amount, @ByRef String[] description) {
        float RELICMULT = HookedBeak.DMGINCREASE;
        if (AbstractDungeon.player.hasRelic("poultryplus:HookedBeak") && !owner.isPlayer && AbstractDungeon.player.hasPower("Flight")) {
            if (AbstractDungeon.player.hasRelic("Paper Frog")) {
                float MULT = 0.75F + RELICMULT * AbstractDungeon.player.getPower("Flight").amount;
                int DISPLAY = (int) (100F * MULT);
                if (amount == 1) {
                    description[0] = DESCRIPTIONS[0] + DISPLAY + DESCRIPTIONS[1] + amount + DESCRIPTIONS[2];
                } else {
                    description[0] = DESCRIPTIONS[0] + DISPLAY + DESCRIPTIONS[1] + amount + DESCRIPTIONS[3];
                }
                return SpireReturn.Return();
            } else {
                float MULT = 0.5F + RELICMULT * AbstractDungeon.player.getPower("Flight").amount;
                int DISPLAY = (int) (100F * MULT);
                if (amount == 1) {
                    description[0] = DESCRIPTIONS[0] + DISPLAY + DESCRIPTIONS[1] + amount + DESCRIPTIONS[2];
                } else {
                    description[0] = DESCRIPTIONS[0] + DISPLAY + DESCRIPTIONS[1] + amount + DESCRIPTIONS[3];
                }
                return SpireReturn.Return();
            }
        }
        return SpireReturn.Continue();
    }
}
