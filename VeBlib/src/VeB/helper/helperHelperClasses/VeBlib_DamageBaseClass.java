package VeB.helper.helperHelperClasses;

import com.fs.starfarer.api.combat.DamageType;
import com.fs.starfarer.api.loading.DamagingExplosionSpec;

public class VeBlib_DamageBaseClass {

    public VeBlib_DamageBaseClass(float damage, float empDamage, DamageType damageType) {
        this.Damage = damage;
        this.EMPDamage = empDamage;
        this.DamageType = damageType;
    }

    public VeBlib_DamageBaseClass(float damage, float empDamage, DamageType damageType, DamagingExplosionSpec damagingExplosionSpec) {
        this.Damage = damage;
        this.EMPDamage = empDamage;
        this.DamageType = damageType;
        this.DamagingExplosionSpec = damagingExplosionSpec;
    }

    public VeBlib_DamageBaseClass() {
    }

    public float Damage;
    public float EMPDamage;
    public DamageType DamageType;

    public DamagingExplosionSpec DamagingExplosionSpec;


}
