package itzkiller.command;
import itzkiller.gui.ItemGui;
import net.minestom.server.command.builder.Command;
import net.minestom.server.entity.Player;

public class GuiCommand extends Command {

    public GuiCommand() {
        super("gui");
        setDefaultExecutor((Sender, Context) -> {
            if(Sender instanceof Player player) {
                ItemGui gui=new ItemGui();
                gui.open(player);
            }
        });

    }
}
