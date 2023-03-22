package com.sarinsa.quickcure.common.core;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(QuickCure.MODID)
public class QuickCure {

    public static final String MODID = "quick_cure";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public QuickCure() {
        MinecraftForge.EVENT_BUS.addListener(this::onZombieVillagerCure);

        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class,
                () -> new IExtensionPoint.DisplayTest(
                        () -> NetworkConstants.IGNORESERVERONLY,
                        (remoteVersion, isFromServer) -> isFromServer
                )
        );
        LOGGER.info("No more dying of old age before your zombie friends get healthy again!");
    }

    public void onZombieVillagerCure(LivingEvent.LivingTickEvent event) {
        if (event.getEntity() instanceof ZombieVillager zombieVillager) {
            if (zombieVillager.isAlive() && zombieVillager.isConverting()) {
                if (!zombieVillager.level.isClientSide) {
                    zombieVillager.finishConversion((ServerLevel) zombieVillager.level);
                }
            }
        }
    }
}
