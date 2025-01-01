package poultryplus.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch2;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import poultryplus.relics.HookedBeak;

@SpirePatch2(
        clz = VulnerablePower.class,
        method = "atDamageReceive"
)
public class VulnerableDamagePatch {


    @SpireInsertPatch(
            loc = 85,
            localvars = {"damage"}
    )
    public static SpireReturn<Float> Insert(float damage) {
        float RELICMULT = HookedBeak.DMGINCREASE;
        if (AbstractDungeon.player.hasRelic("poultryplus:HookedBeak") && AbstractDungeon.player.hasPower("Flight")) {
            if (AbstractDungeon.player.hasRelic("Paper Frog")) {
                float DMG = damage * (1.75F + RELICMULT * AbstractDungeon.player.getPower("Flight").amount);
                return SpireReturn.Return(DMG);
            } else {
                float DMG = damage * (1.5F + RELICMULT * AbstractDungeon.player.getPower("Flight").amount);
                return SpireReturn.Return(DMG);
            }
        }
        return SpireReturn.Continue();
    }
}
