package ca.rpgcraft.damageindicatorsfabric;

import ca.rpgcraft.damageindicatorsfabric.util.VectorGenerator;
import ca.rpgcraft.damageindicatorsfabric.util.VectorRingBuffer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DamageIndicatorsFabric implements ModInitializer {
    public static final String MOD_ID = "damageindicators";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final VectorRingBuffer VECTOR_RING_BUFFER = new VectorRingBuffer(50, new VectorGenerator());

    @Override
    public void onInitialize() {
        registerPackets();
        registerListeners();
    }

    public void registerPackets(){
    }

    public void registerListeners(){

    }
}
