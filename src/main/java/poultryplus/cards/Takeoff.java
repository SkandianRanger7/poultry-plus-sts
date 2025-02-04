package poultryplus.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import poultryplus.character.MyCharacter;
import poultryplus.powers.PlayerFlightPower;
import poultryplus.util.CardStats;

public class Takeoff extends BaseCard {
    public static final String ID = makeID("Takeoff");
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.BASIC,
            CardTarget.NONE,
            0
    );

    private static final int FLIGHT = 3;
    private static final int UPG_FLIGHT = 2;

    public Takeoff() {
        super(ID, info);

        setMagic(FLIGHT, UPG_FLIGHT);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!AbstractDungeon.player.hasPower("Flight")) {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new PlayerFlightPower(p, magicNumber)));
        }
    }
}
