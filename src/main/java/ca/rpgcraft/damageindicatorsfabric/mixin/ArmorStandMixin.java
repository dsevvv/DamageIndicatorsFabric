package ca.rpgcraft.damageindicatorsfabric.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ArmorStandEntity.class)
public abstract class ArmorStandMixin {

    @Inject(at = @At("TAIL"), method = "tick")
    private void onTick(CallbackInfo ci) {
        ArmorStandEntity armorStand = (ArmorStandEntity) (Object) this;

        if(armorStand.noClip && armorStand.age > 20) {
            armorStand.remove(Entity.RemovalReason.DISCARDED);
        }
    }
}
