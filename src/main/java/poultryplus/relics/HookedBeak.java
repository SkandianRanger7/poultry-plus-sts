package poultryplus.relics;

import poultryplus.character.MyCharacter;

import static poultryplus.BasicMod.makeID;

public class HookedBeak extends BaseRelic {
    private static final String NAME = "HookedBeak"; //for image file and ID
    private static final String ID = makeID(NAME); //Adds mod prefix to relic id
    private static final RelicTier RARITY = RelicTier.STARTER;
    private static final LandingSound SOUND = LandingSound.FLAT; //sound when clicked

    public static final float DMGINCREASE = 0.05F;

    public HookedBeak() {
        super(ID, NAME, MyCharacter.Meta.CARD_COLOR, RARITY, SOUND);
    }


    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + (int) (DMGINCREASE * 100) + DESCRIPTIONS[1];
    }

}
