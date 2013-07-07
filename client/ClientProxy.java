package beelzaboss.aerialcraft.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import beelzaboss.aerialcraft.CommonProxy;

public class ClientProxy extends CommonProxy {
	
	
        
        @Override
        public void registerRenderers() {
        	
                RenderingRegistry.registerEntityRenderingHandler(beelzaboss.aerialcraft.mob.CorruptedZombie.class, new beelzaboss.aerialcraft.renderer.CorruptedZombieRenderer(new beelzaboss.aerialcraft.mobmodel.CorruptedZombieModel(), 0.5F));
                EntityRegistry.registerGlobalEntityID(beelzaboss.aerialcraft.mob.CorruptedZombie.class, "CorruptedZombie", EntityRegistry.findGlobalUniqueEntityId(), 3515848, 12102);
        }
        
}