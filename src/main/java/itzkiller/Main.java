package itzkiller;

import itzkiller.command.GuiCommand;
import net.minestom.server.MinecraftServer;

import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Player;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;

import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.InstanceManager;

import net.minestom.server.instance.LightingChunk;
import net.minestom.server.instance.anvil.AnvilLoader;


public class Main {
    public static void main(String[] args) {
        System.out.println("server started!");

        //initialize(server)
        MinecraftServer server=MinecraftServer.init();

        //creating instance
        InstanceManager instanceManager=MinecraftServer.getInstanceManager();
        InstanceContainer instanceContainer=instanceManager.createInstanceContainer();

        //chunks
        instanceContainer.setChunkLoader(new AnvilLoader("resources/worlds/hub"));

        //command
        MinecraftServer.getCommandManager().register(new GuiCommand());


        //save chunks
        instanceContainer.saveChunksToStorage();
        instanceContainer.saveInstance();


        //events handler
        GlobalEventHandler globalEventHandler=MinecraftServer.getGlobalEventHandler();
        globalEventHandler.addListener(AsyncPlayerConfigurationEvent.class, event -> {
            final Player player=event.getPlayer();
            event.setSpawningInstance(instanceContainer);
            player.setRespawnPoint(new Pos(-3,70,-68));
        });

        //lighting
        instanceContainer.setChunkSupplier(LightingChunk::new);

        //server starts
        server.start("0.0.0.0",25565);
    }
}