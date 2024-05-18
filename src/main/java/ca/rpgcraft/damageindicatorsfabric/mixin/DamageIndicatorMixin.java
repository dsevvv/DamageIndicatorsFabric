package ca.rpgcraft.damageindicatorsfabric.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.text.DecimalFormat;

import static ca.rpgcraft.damageindicatorsfabric.DamageIndicatorsFabric.VECTOR_RING_BUFFER;

@Mixin(LivingEntity.class)
public abstract class DamageIndicatorMixin {

    @Inject(at = @At("TAIL"), method = "damage")
    private void onDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        ArmorStandEntity hologram = new ArmorStandEntity(((LivingEntity) (Object) this).getWorld(), ((LivingEntity) (Object) this).getX(), ((LivingEntity) (Object) this).getY(), ((LivingEntity) (Object) this).getZ());
        hologram.setCustomNameVisible(true);
        DecimalFormat df = new DecimalFormat("#.#");
        Double roundedNumber = Double.parseDouble(df.format(amount));
        Formatting color;
        if(roundedNumber >= 10.0D) {
            color = Formatting.DARK_RED;
        } else if(roundedNumber >= 5.0D) {
            color = Formatting.GOLD;
        } else if(roundedNumber >= 2.0D) {
            color = Formatting.YELLOW;
        } else {
            color = Formatting.GREEN;
        }
        hologram.setCustomName(Text.translatable(String.valueOf(roundedNumber)).formatted(color).formatted(Formatting.BOLD));
        hologram.setInvisible(true);
        hologram.setInvulnerable(true);
        hologram.noClip = true;
        hologram.setBoundingBox(hologram.getBoundingBox().expand(0.0D, 0.0D, 0.0D));
        hologram.setVelocity(VECTOR_RING_BUFFER.getNext());
        hologram.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 900, 1));
        ((LivingEntity) (Object) this).getWorld().spawnEntity(hologram);
    }
}
