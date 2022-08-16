package best.spaghetcodes.duckdueller

import best.spaghetcodes.duckdueller.commands.ConfigCommand
import best.spaghetcodes.duckdueller.core.Config
import best.spaghetcodes.duckdueller.events.packet.PacketListener
import net.minecraft.client.Minecraft
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@Mod(
    modid = DuckDueller.MOD_ID,
    name = DuckDueller.MOD_NAME,
    version = DuckDueller.VERSION
)
class DuckDueller {

    companion object {
        const val MOD_ID = "duckdueller"
        const val MOD_NAME = "DuckDueller"
        const val VERSION = "0.1.0"
        const val configLocation = "./config/duckdueller.toml"

        val mc: Minecraft = Minecraft.getMinecraft()
        var config: Config? = null
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        config = Config()
        config?.preload()

        ConfigCommand().register()

        MinecraftForge.EVENT_BUS.register(PacketListener())
    }
}