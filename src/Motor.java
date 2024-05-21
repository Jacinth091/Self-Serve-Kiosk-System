class 
{
   private  String color;
   private  String brand;
   
   void engine()
   {
   System.out.printf("broom! broom! \n");
   }
   void refill()
   {
   System.out.printf("unleaded \n");
   }
   void power()
   {
   System.out.printf("1000cc \n");
   }
   void makeAstatement()
   {
   System.out.printf("I'm a %s %s \n",color,brand);
   } 
}
class main 
{
   public static void main(String[]args)
   {
   Motor magentaMotor = new Motor();
   magentaMotor.color = "magenta";
   magentaMotor.brand = "Yamaha";
   magentaMotor.engine();
   magentaMotor.refill();
   magentaMotor.power();
   magentaMotor.makeAstatement();
   
   System.out.printf("");
   Motor blackMotor = new Motor();
   blackMotor.color = "black";
   blackMotor.brand = "honda";
   blackMotor.makeAstatement();
   
   }
}