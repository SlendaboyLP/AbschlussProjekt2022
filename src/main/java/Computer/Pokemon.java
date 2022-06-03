package Computer;

public final class Pokemon extends Computer {

    int currentLevel;
    int currentXP;
    int XP_to_next_Level;
    String[] type;
    Stats stats;
    Attacks[] attacks;


    public Pokemon(String name, String gender, String[] type, int health, int attack, int specialAttack, int defence, int specialDefence, int initiative) {
        super(name, gender);
        this.currentLevel = 1;
        this.currentXP = 0;
        this.XP_to_next_Level = getXP_for_next_Level(currentLevel);
        this.type = type;
        this.stats = new Stats(health,attack,specialAttack,defence,specialDefence,initiative);
    }

    private int getXP_for_next_Level(int currentLevel){
        return (int) (100 * Math.pow(1.03, (currentLevel + 1)));
    }

    private void checkIfLevelUpready(){ //needs to be called everytime a fight or something else xp giving is done
        if(this.currentXP >= this.XP_to_next_Level){
            levelUp();
        }
    }

    private void levelUp(){
        this.currentLevel++;
        this.currentXP -= this.XP_to_next_Level;
        this.XP_to_next_Level = getXP_for_next_Level(currentLevel);
    }




    /*public void attack(Pokemon enemy){
        int damage = ((2*this.level)/5+2) *
    }*/
}
