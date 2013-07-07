package beelzaboss.aerialcraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockDutarBlock extends Block 
{

        public BlockDutarBlock (int id, Material material) {
                super(id, material);
                
                setCreativeTab(CreativeTabs.tabBlock);
                setHardness(0.5F);
                setStepSound(Block.soundMetalFootstep);
                setUnlocalizedName("BlockDutarBlock");
                
        }
        
        @Override
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister iconRegister) {
            this.blockIcon = iconRegister.registerIcon((this.getUnlocalizedName().substring(5)));
        }

}