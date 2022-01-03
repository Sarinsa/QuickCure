package com.sarinsa.quickcure.common.event;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntityEvents {

    @SubscribeEvent
    public void onZombieVillagerCure(LivingEvent.LivingUpdateEvent event) {

        if (event.getEntityLiving() instanceof ZombieVillager zombieVillager) {
            if (zombieVillager.isAlive() && zombieVillager.isConverting()) {
                if (!zombieVillager.level.isClientSide) {
                    zombieVillager.finishConversion((ServerLevel) zombieVillager.level);
                }
            }
        }
    }
}
