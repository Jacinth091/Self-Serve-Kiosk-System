/*
Name: Cavan, Clannel Dee 
Section: BSIT-1B
Schedule: 5:01 - 7:31
*/

class Dog
{
    String color;
    String breed;
    
    void barking()
    {
    System.out.printf("Woof! Woof! Woof! \n");
    }
    void growling()
    {
    System.out.printf("Grrr! Grrr! Grrr! \n");
    }
    void howling()
    {
    System.out.printf("Awoooooo! \n");
    }
    void statement()
    {
    System.out.printf("\n I'm a %s %s dog.\n",color,breed);
    }
}

class Main
{
    public static void main(String[] args)
{
        Dog creamCat = new Dog();
        creamCat.color = "cream";
        creamCat.breed = "pomeranian";
        creamCat.barking();
        creamCat.growling();
        creamCat.howling();
        creamCat.statement();
        
        System.out.println("");
        
        Dog redDog = new Dog();
        redDog.color = "red";
        redDog.breed = "corgi";
        redDog.statement();
}
}
