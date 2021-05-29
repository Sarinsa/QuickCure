package com.sarinsa.quickcure.common.event;

import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntityEvents {

    @SubscribeEvent
    public void onZombieVillagerCure(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntityLiving() instanceof ZombieVillagerEntity) {
            ZombieVillagerEntity zombieVillager = (ZombieVillagerEntity) event.getEntityLiving();

            if (zombieVillager.isAlive() && zombieVillager.isConverting()) {
                if (!zombieVillager.level.isClientSide) {
                    zombieVillager.finishConversion((ServerWorld) zombieVillager.level);
                }
            }
        }
    }
}
