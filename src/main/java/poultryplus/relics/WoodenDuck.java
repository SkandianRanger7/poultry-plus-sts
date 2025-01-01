package poultryplus.relics;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.FlightPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import poultryplus.character.MyCharacter;
import poultryplus.powers.PlayerFlightPower;

import static poultryplus.BasicMod.makeID;

public class WoodenDuck extends BaseRelic {
    private static final String NAME = "WoodenDuck"; //for image file and ID
    private static final String ID = makeID(NAME); //Adds mod prefix to relic id
    private static final RelicTier RARITY = RelicTier.RARE;
    private static final LandingSound SOUND = LandingSound.FLAT; //sound when clicked

    private static final double FLIGHTPERGOLD = (double) 1 /50;

    public WoodenDuck() {
        super(ID, NAME, MyCharacter.Meta.CARD_COLOR, RARITY, SOUND);
    }

    @Override
    public void atBattleStart(){
        int FLIGHT = (int) Math.floor(AbstractDungeon.player.gold * FLIGHTPERGOLD);
        AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, (AbstractPower)new PlayerFlightPower(AbstractDungeon.player, FLIGHT)));
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }


}
