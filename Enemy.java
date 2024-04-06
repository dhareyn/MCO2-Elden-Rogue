public class Enemy {
    // Fields
    private int type;
    private String name;
    private String areaname;
    private int area;
    private int lowHealth;
    private int highHealth;
    private int lowAttack;
    private int highAttack;
    private double physicalDefense;
    private double sorceryDefense;
    private double incantationDefense;
    private boolean isBoss;

    public Enemy(int type, String name, String areaname, int area, int lowHealth, int highHealth, int lowAttack, int highAttack, double physicalDefense, double sorceryDefense, double incantationDefense, boolean isBoss) {
         this.type = type; 
         this.name = name; 
         this.areaname = areaname;
         this.area  = area;
         this.lowHealth = lowHealth;
         this.highHealth = highHealth;
         this.lowAttack = lowAttack;
         this.highAttack = highAttack;
         this.physicalDefense = physicalDefense;
         this.sorceryDefense = sorceryDefense;
         this.incantationDefense = incantationDefense;
         this.isBoss = isBoss;
    }

    // Getter methods
    public int getLowHealth() {
        return lowHealth;
    }

    public int getHighHealth() {
        return highHealth;
    }

    public int getLowAttack() {
        return lowAttack;
    }

    public int getHighAttack() {
        return highAttack;
    }

    public double getPhysicalDefense() {
        return physicalDefense;
    }

    public double getSorceryDefense() {
        return sorceryDefense;
    }

    public double getIncantationDefense() {
        return incantationDefense;
    }

    public String getName()
    {
        return name;
    }

   
    public int getType()
    {
        return type;
    }

    
    public int getArea()
    {
        return area;
    }

    
    public String getAreaname()
    {
        return areaname;
    }

    public boolean getisBoss()
    {
        return isBoss;
    }
}
