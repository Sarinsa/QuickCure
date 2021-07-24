package com.sarinsa.quickcure.common.event;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntityEvents {

    @SubscribeEvent
    public void onZombieVillagerCure(LivingEvent.LivingUpdateEvent event) {

        if (event.getEntityLiving() instanceof ZombieVillager zombieVillager) {
                             // isAlive                   // isConverting
            if (zombieVillager.m_6084_() && zombieVillager.m_34408_()) {
                                           // isClientSide
                if (!zombieVillager.f_19853_.f_46443_) {
                    zombieVillager.m_34398_((ServerLevel) zombieVillager.f_19853_);
                }
            }
        }
    }
}
