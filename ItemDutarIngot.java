package beelzaboss.aerialcraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemDutarIngot extends Item {

	public ItemDutarIngot(int id) {
		super(id);
		
        //Config
        maxStackSize = 64;
        setCreativeTab(CreativeTabs.tabMaterials);
        setUnlocalizedName("ItemDutarIngot");
}

@Override
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister iconRegister) {
    this.itemIcon = iconRegister.registerIcon((this.getUnlocalizedName().substring(5)));
	}
	
}