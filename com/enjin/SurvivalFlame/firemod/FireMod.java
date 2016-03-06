package com.enjin.SurvivalFlame.firemod;

import com.enjin.SurvivalFlame.firemod.item.ItemFireAxe;
import com.enjin.SurvivalFlame.firemod.item.ItemFirePickaxe;
import com.enjin.SurvivalFlame.firemod.item.ItemFireShovel;
import com.enjin.SurvivalFlame.firemod.item.ItemFireSword;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "fm", name = "Fire Mod", version = "1.0")
public class FireMod {
	
	public static Item itemCore;
	public static Item firePickaxe;
	public static Item fireAxe;
	public static Item fireShovel;
	public static Item fireSword;
	public static Item itemFire;
	public static Block blockFire;
	
	public static final Item.ToolMaterial fireToolMaterial = EnumHelper.addToolMaterial("fireToolMaterial", 4, 35000, 20.0F, 5.0F, 20);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event ) {
		//Item/Block init and registering
		//Config handling
		firePickaxe = new ItemFirePickaxe(fireToolMaterial).setUnlocalizedName("ItemFirePickaxe").setTextureName("fm:itemfirepickaxe").setCreativeTab(tabFireMod);
		fireAxe = new ItemFireAxe(fireToolMaterial).setUnlocalizedName("ItemFireAxe").setTextureName("fm:itemfireaxe").setCreativeTab(tabFireMod);
		fireShovel = new ItemFireShovel(fireToolMaterial).setUnlocalizedName("ItemFireShovel").setTextureName("fm:itemfireshovel").setCreativeTab(tabFireMod);
		fireSword = new ItemFireSword(fireToolMaterial).setUnlocalizedName("ItemFireSword").setTextureName("fm:itemfiresword").setCreativeTab(tabFireMod);
		itemCore = new ItemFood(16, 1.0F, false).setUnlocalizedName("ItemCore").setTextureName("fm:itemcore").setCreativeTab(tabFireMod);
		itemFire = new ItemFire().setUnlocalizedName("ItemFire").setTextureName("fm:itemfire").setCreativeTab(tabFireMod); //itemFireBall
		blockFire = new BlockFire(Material.lava).setBlockName("BlockFire").setBlockTextureName("fm:blockfire").setCreativeTab(tabFireMod);
		GameRegistry.registerItem(itemFire, itemFire.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockFire, blockFire.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemCore, itemCore.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(firePickaxe, firePickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fireAxe, fireAxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fireSword, fireSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fireShovel, fireShovel.getUnlocalizedName().substring(5));
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		//Proxy, TileEntity, entity, GUI and Packet Registering
		GameRegistry.addRecipe(new ItemStack(firePickaxe), new Object[]{"999"," S "," S ",'9', itemFire, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(fireShovel), new Object[]{" 9 "," S "," S ",'9', itemFire, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(fireSword), new Object[]{" 9 "," 9 "," S ",'9', itemFire, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(itemFire), new Object[]{"RFR","FLF","RFR",'F', Items.fire_charge, 'L', Items.lava_bucket, 'R', Items.redstone});
		GameRegistry.addRecipe(new ItemStack(blockFire, 10), new Object[]{"999","999","999", '9', itemFire});
		GameRegistry.addRecipe(new ItemStack(itemCore), new Object[]{"9R9", "RRR", "9R9", '9', itemFire, 'R', Items.redstone});
	}
	
	@EventHandler
	public void init(FMLPostInitializationEvent event) {
		
	}
	
	public static CreativeTabs tabFireMod = new CreativeTabs("tabFireMod"){
		@Override
		public Item getTabIconItem() {
			return new ItemStack(Items.fire_charge).getItem();
		}
	};
}

