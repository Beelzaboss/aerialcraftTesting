package beelzaboss.aerialcraft.renderer;

import beelzaboss.aerialcraft.mob.CorruptedZombie;
import beelzaboss.aerialcraft.mobmodel.CorruptedZombieModel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.resources.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityCow;

@SideOnly(Side.CLIENT)
public class CorruptedZombieRenderer extends RenderLiving{
	
	private static final ResourceLocation textureLocation = new ResourceLocation("AerialCraft", "assets/minecraft/textures/entity/CorruptedZombie.png");
	
    public CorruptedZombieRenderer(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    public void renderCorruptedZombie(CorruptedZombie par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1Entity, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderCorruptedZombie((CorruptedZombie)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderCorruptedZombie((CorruptedZombie)par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
    protected ResourceLocation func_110775_a(Entity entity) {
    return textureLocation;
    }
	
}
