package pokemonGame.Entity.Pokemon;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Stats {
    @Column
    private Integer attack;

    @Column
    private Integer defense;

    @Column
    private Integer HP;

    @Column
    private Integer speed;

    @Column
    private Integer specDefence;

    @Column
    private Integer specAttack;

    @Column
    private Integer attackStatus = 0;

    @Column
    private Integer defenseStatus = 0;

    @Column
    private Integer HPStatus = 0;

    @Column
    private Integer speedStatus = 0;

    @Column
    private Integer specDefenceStatus = 0;

    @Column
    private Integer specAttackStatus = 0;

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getHP() {
        return HP;
    }

    public void setHP(Integer HP) {
        this.HP = HP;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getSpecDefence() {
        return specDefence;
    }

    public void setSpecDefence(Integer specDefence) {
        this.specDefence = specDefence;
    }

    public Integer getSpecAttack() {
        return specAttack;
    }

    public void setSpecAttack(Integer specAttack) {
        this.specAttack = specAttack;
    }

    public Integer getAttackStatus() {
        return attackStatus;
    }

    public void setAttackStatus(Integer attackStatus) {
        this.attackStatus = attackStatus;
    }

    public Integer getDefenseStatus() {
        return defenseStatus;
    }

    public void setDefenseStatus(Integer defenseStatus) {
        this.defenseStatus = defenseStatus;
    }

    public Integer getHPStatus() {
        return HPStatus;
    }

    public void setHPStatus(Integer HPStatus) {
        this.HPStatus = HPStatus;
    }

    public Integer getSpeedStatus() {
        return speedStatus;
    }

    public void setSpeedStatus(Integer speedStatus) {
        this.speedStatus = speedStatus;
    }

    public Integer getSpecDefenceStatus() {
        return specDefenceStatus;
    }

    public void setSpecDefenceStatus(Integer specDefenceStatus) {
        this.specDefenceStatus = specDefenceStatus;
    }

    public Integer getSpecAttackStatus() {
        return specAttackStatus;
    }

    public void setSpecAttackStatus(Integer specAttackStatus) {
        this.specAttackStatus = specAttackStatus;
    }
}
