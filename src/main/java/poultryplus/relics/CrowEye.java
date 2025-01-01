package poultryplus.relics;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static poultryplus.BasicMod.makeID;

public class CrowEye extends BaseRelic {
    private static final String NAME = "CrowEye"; //for image file and ID
    private static final String ID = makeID(NAME); //Adds mod prefix to relic id
    private static final RelicTier RARITY = RelicTier.COMMON;
    private static final LandingSound SOUND = LandingSound.MAGICAL; //sound when clicked

    private static final int GOLD = 30;

    public CrowEye() {
        super(ID, NAME, RARITY, SOUND);
    }

    public static void RelicGet() {
        AbstractDungeon.player.gold += GOLD;
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + GOLD + DESCRIPTIONS[1];
    }

}
