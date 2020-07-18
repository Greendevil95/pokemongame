package pokemonGame.Entity.Pokemon;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Stats {

    @Column
    private int currentHP;

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

    @Column
    private Integer accuracyStatus = 0;

    @Column
    private Integer evasionStatus = 0;

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

    public Integer getAccuracyStatus() {
        return accuracyStatus;
    }

    public void setAccuracyStatus(Integer accuracyStatus) {
        this.accuracyStatus = accuracyStatus;
    }

    public Integer getEvasionStatus() {
        return evasionStatus;
    }

    public void setEvasionStatus(Integer evasionStatus) {
        this.evasionStatus = evasionStatus;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public void increaseAttack(int value){
        attackStatus += value;
        attackStatus = check(attackStatus);
    }

    public void increaseDefence(int value){
        defenseStatus += value;
        defenseStatus  = check(defenseStatus );
    }

    public void increaseSpecAttack(int value){
        specAttackStatus += value;
        specAttackStatus = check(specAttackStatus);
    }

    public void increaseSpecDefence(int value){
        specDefenceStatus += value;
        specDefenceStatus = check(specDefenceStatus);
    }

    public void increaseSpeed(int value){
        speedStatus += value;
        speedStatus = check(speedStatus);
    }

    public void increaseAccurasy(int value){
        accuracyStatus += value;
        accuracyStatus = check(accuracyStatus);
    }

    public void increaseEvasion(int value){
        evasionStatus += value;
        evasionStatus = check(evasionStatus);
    }

    public void decreaseAttack(int value){
        attackStatus -= value;
        attackStatus = check(attackStatus);
    }

    public void decreaseDefence(int value){
        defenseStatus -= value;
        defenseStatus = check(defenseStatus);
    }

    public void decreaseSpecAttack(int value){
        specAttackStatus -= value;
        specAttackStatus = check(specAttackStatus);
    }

    public void decreaseSpecDefence(int value){
        specDefenceStatus -= value;
        specDefenceStatus = check(specDefenceStatus);
    }

    public void decreaseSpeed(int value){
        speedStatus -= value;
        speedStatus = check(speedStatus);
    }

    public void decreaseAccurasy(int value){
        accuracyStatus -= value;
        accuracyStatus = check(accuracyStatus);
    }

    public void decreaseEvasion(int value){
        evasionStatus -= value;
        evasionStatus = check(evasionStatus);
    }

    private int check(int value){
        if (value >=6)
            return 6;
        if (value <=-6)
            return -6;
        else return value;
    }

}
