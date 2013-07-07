package beelzaboss.aerialcraft.mob;

import beelzaboss.aerialcraft.AerialCraftMain;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class CorruptedZombie extends EntityZombie{
        
        private String texture;

		public CorruptedZombie(World par1World) {
                super(par1World);
                //Texture
                this.texture = "assets/minecraft/textures/entity/CorruptedZombie.png";
                //Avoid Water?
                this.getNavigator().setAvoidsWater(true);
                //HitBox
                this.setSize(1.5F, 0.9F);
                
                this.isImmuneToFire = false;
                float var2 = 0.25F;
 
                this.getNavigator().setBreakDoors(true);
                this.tasks.addTask(0, new EntityAISwimming(this));
                this.tasks.addTask(1, new EntityAIBreakDoor(this));
                this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
                this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
                this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
                this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, 1.0D, false));
                this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
                this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
                this.tasks.addTask(7, new EntityAILookIdle(this));
                this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
                this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
                this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
        }

        //This is required. If it's false, none of the above takes effect.
        public boolean isAIEnabled() {
                return true;
        }
        
        //Pretty obvious, set it's health!
        public int getMaxHealth() {
                return 100;
        }
        
        //Sounds
        protected String getLivingSound()
        {
            return "mob.zombie.say";
        }
        protected String getHurtSound()
        {
            return "mob.zombie.hurt";
        }
        protected String getDeathSound()
        {
            return "mob.zombie.death";
        }
        
        
        //Sound When Walking 
        protected void playStepSound(int par1, int par2, int par3, int par4) {
                this.worldObj.playSoundAtEntity(this, "mob.zombie.step", 0.15F,  1.0F);
        }
        
        //Drop item on death
        protected int getDropItemId() {
                return AerialCraftMain.ItemDutarFragment.itemID;
        }
        
        //This is required regardless of if your animal can breed or not. Set to null if it can't breed - I wont cover breeding here.
        public EntityAgeable createChild(EntityAgeable var1) {
                return null;
        }
}