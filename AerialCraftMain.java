package beelzaboss.aerialcraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
//Config File Imports
import net.minecraftforge.common.Configuration;
//-----------------------------------------------------------------


//Mod Settings
@Mod(modid="AerialCraft", name="Aerial Craft", version="1.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
//-----------------------------------------------------------------

//Main
public class AerialCraftMain {

        // The instance of AerialCraft.
        @Instance("AerialCraft")
        public static AerialCraftMain instance;
        //-----------------------------------------------------------------
        
        //Define Item CHECKLIST TODO
        public static Item ItemDutarFragment;
        public static Item ItemDutarEssence;
        public static Item ItemDutarIngot;
        //Define Block CHECKLIST TODO
        public static Block BlockDutarBlock;
        //-----------------------------------------------------------------
        
        
        // Server 'proxy' code being loaded.
        @SidedProxy(clientSide="beelzaboss.aerialcraft.client.ClientProxy", serverSide="beelzaboss.aerialcraft.CommonProxy")
        public static CommonProxy proxy;
        
        //
        
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
        		//Config
        	    Configuration config = new Configuration(event.getSuggestedConfigurationFile());
                // Loading the configuration from its file
                config.load();
                //ID's Item config CHECKLIST TODO
                int ItemDutarFragmentID = config.getItem("ItemDutarFragment", 5000).getInt();
                int ItemDutarEssenceID = config.getItem("ItemDutarEssence", 5001).getInt();
                int ItemDutarIngotID = config.getItem("ItemDutarIngot", 5003).getInt();
                //ID's Block config CHECKLIST TODO
                int BlockDutarBlockID = config.getBlock("BlockDutarBlock", 300).getInt();
                // Saving the configuration to its file
                config.save();
        	    //-----------------------------------------------------------------

                
        		//Add Item CHECKLIST TODO
                ItemDutarFragment = (new ItemDutarFragment(ItemDutarFragmentID));
                ItemDutarEssence = (new ItemDutarEssence(ItemDutarEssenceID));
                ItemDutarIngot = (new ItemDutarIngot(ItemDutarIngotID));
                //Add Block CHECKLIST TODO
                BlockDutarBlock = (new BlockDutarBlock(BlockDutarBlockID, Material.rock));
                //-----------------------------------------------------------------
        }
        
        //
        
        @EventHandler
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
                
                //Entity Registery
                EntityRegistry.registerModEntity(beelzaboss.aerialcraft.mob.CorruptedZombie.class, "CorruptedZombie", 2, this, 80, 3, true);
                EntityRegistry.addSpawn(beelzaboss.aerialcraft.mob.CorruptedZombie.class, 5, 2, 6, EnumCreatureType.monster, BiomeGenBase.forest);
                LanguageRegistry.instance().addStringLocalization("CorruptedZombie", "Corrupted Zombie");
                
                //Register BLOCK CHECKLIST TODO (ONLY BLOCKS)
                GameRegistry.registerBlock(BlockDutarBlock, "BlockDutarBlock");
                
                //Language Registery CHECKLIST TODO
                LanguageRegistry.addName(ItemDutarFragment, "Dutar Fragment");
                LanguageRegistry.addName(ItemDutarEssence, "Dutar Essence");
                LanguageRegistry.addName(ItemDutarIngot, "Dutar Ingot");
                //Language Registery CHECLIST TODO
                LanguageRegistry.addName(BlockDutarBlock, "Dutar Block");
                //-----------------------------------------------------------------
                
                
                //Recipes Register Shapeles
                GameRegistry.addShapelessRecipe(new ItemStack(ItemDutarEssence, 1), ItemDutarFragment, ItemDutarFragment, ItemDutarFragment, ItemDutarFragment, ItemDutarFragment, ItemDutarFragment, ItemDutarFragment, ItemDutarFragment, ItemDutarFragment);
                
                //Recipes Register Shaped
                
                //Recipes Register Smelting
                GameRegistry.addSmelting(ItemDutarEssence.itemID, new ItemStack(ItemDutarIngot), 1.0f);
                //-----------------------------------------------------------------
        
        }
        
        //
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
        	
                // Stub Method
        	
        }
        
        //
}