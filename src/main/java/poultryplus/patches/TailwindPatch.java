package poultryplus.patches;

import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

@SpirePatch2(
        clz= ApplyPowerAction.class,
        method=SpirePatch.CONSTRUCTOR,
        paramtypez={
                AbstractCreature.class,
        AbstractCreature.class,
        AbstractPower.class,
        int.class,
        boolean.class,
        AbstractGameAction.AttackEffect.class

}
)
public class TailwindPatch {


    @SpireInsertPatch(
        rloc=13,
            localvars={"source", "target"}
    )
    public static void Insert(@ByRef AbstractPower[] ___powerToApply, @ByRef int[] ___amount, AbstractCreature source, AbstractCreature target){
        if (AbstractDungeon.player.hasPower("poultryplus:Tailwind") && source != null && source.isPlayer && target == source && ___powerToApply[0].ID.equals("Flight")) {
            AbstractDungeon.player.getPower("poultryplus:Tailwind").flash();
            ___powerToApply[0].amount += AbstractDungeon.player.getPower("poultryplus:Tailwind").amount;
            ___amount[0]+= AbstractDungeon.player.getPower("poultryplus:Tailwind").amount;
        }
    }
}