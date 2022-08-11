package com.sarinsa.quickcure.common.core;

import com.sarinsa.quickcure.common.event.EntityEvents;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterGameTestsEvent;
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
        MinecraftForge.EVENT_BUS.register(new EntityEvents());

        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class,
                () -> new IExtensionPoint.DisplayTest(
                        () -> NetworkConstants.IGNORESERVERONLY,
                        (remoteVersion, isFromServer) -> isFromServer
                )
        );
        LOGGER.info("No more dying of old age before your zombie friends get healthy again!");
    }
}
