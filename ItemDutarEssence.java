package beelzaboss.aerialcraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemDutarEssence extends Item {

	public ItemDutarEssence(int id) {
		super(id);
		
        //Config
		//*******
        maxStackSize = 64;
        setCreativeTab(CreativeTabs.tabMaterials);
        setUnlocalizedName("ItemDutarEssence");
}

@Override
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister iconRegister) {
    this.itemIcon = iconRegister.registerIcon((this.getUnlocalizedName().substring(5)));
	}
	
}