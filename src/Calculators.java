/*
*  NAME: SATORRE, LANCE TIMOTHY B.
*   DATE: MARCH 28, 20242
*      DESCRIPTION: CALCULATOR PROJECT - MIDTERM
* */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Scanner;

class SFrame extends JFrame implements ActionListener{

    static Scanner in = new Scanner(System.in);


    JButton button,button1, button2, button3, button4;
    JLabel label, label1, label2, label3, label4,label5, label6, label7;
    JPanel panel, panel1, panel2, panel3,panel4,panel5,panel6, panel7, panel8, panel9, panel10,panel11;
    JFrame frame;
    SFrame() {

        Border border = BorderFactory.createLineBorder(Color.black,5);
        Border border1 = BorderFactory.createLineBorder(Color.red,2);
        Border border2 = BorderFactory.createLineBorder(Color.gray,3);
        Border border3 = BorderFactory.createLineBorder(Color.white,2);
        Border border4 = BorderFactory.createLineBorder(Color.black,3);
        Border border5 = BorderFactory.createLineBorder(Color.black,6);

        panel = new JPanel();
        panel.setBounds(37,20,400,50);
        panel.setBorder(border1);
        panel.setBackground(Color.black);


        panel1 = new JPanel();
        panel1.setBounds(37,100,400,250);
        panel1.setBorder(border);
        panel1.setBackground(Color.gray);

        JPanel panelg = new JPanel();
        panelg.setBorder(border4);
        JPanel panelb = new JPanel();
        panelb.setBorder(border4);
        JPanel panelbl= new JPanel();
        panelbl.setBorder(border4);
        JPanel panelr = new JPanel();
        panelr.setBorder(border4);

        panelg.setBackground(Color.green);
        panelb.setBackground(Color.black);
        panelbl.setBackground(Color.blue);
        panelr.setBackground(Color.red);

        panelg.setPreferredSize(new Dimension(20,150));
        panelb.setPreferredSize(new Dimension(50,150));
        panelbl.setPreferredSize(new Dimension(50,150));
        panelr.setPreferredSize(new Dimension(20,150));

        panel2 = new JPanel();
        panel2.setBounds(37,70,50,30);


        panel3 = new JPanel();
        panel3.setBounds(90,73,50,24);
        panel3.setBorder(border2);
        panel3.setBackground(Color.black);

        panel4 = new JPanel();
        panel4.setBounds(159,357,150,50);
        panel4.setBorder(border2);
        panel4.setBackground(Color.black);


        panel5 = new JPanel();
        panel5.setBounds(350,347,50,130);
        panel5.setBorder(border5);
        panel5.setBackground(Color.red);

        panel6 = new JPanel();
        panel6.setBounds(70,347,50,130);
        panel6.setBorder(border5);
        panel6.setBackground(Color.red);

        panel7 = new JPanel();
        panel7.setBounds(70,347,50,130);
        panel7.setBorder(border2);
        panel7.setBackground(Color.green);
        panel7.setVisible(false);

        panel8 = new JPanel();
        panel8.setBounds(350,347,50,130);
        panel8.setVisible(false);
        panel8.setBorder(border2);
        panel8.setBackground(Color.green);

        panel9 = new JPanel();
        panel9.setBounds(0, 427, 500,10);
        panel9.setBorder(border4);
        panel9.setBackground(Color.red);

        panel10 = new JPanel();
        panel10.setBounds(70,347,50,130);
        panel10.setVisible(true);
        panel10.setBorder(border2);
        panel10.setBackground(Color.black);

        panel11 = new JPanel();
        panel11.setBounds(350,347,50,130);
        panel11.setVisible(true);
        panel11.setBorder(border2);
        panel11.setBackground(Color.black);


        button = new JButton("STUDENT INFO");
        button.setBounds(135,250,200,50);
        button.setFont(new Font("Arial",Font.BOLD,17));
        button.addActionListener(this);
        button.setBorder(border);
        button.setFocusable(false);

        button1 = new JButton("START");
        button1.setBounds(110,130,250,100);
        button1.setFont(new Font("Arial",Font.BOLD,40));
        button1.setBorder(border);
        button1.addActionListener(this);
        button1.setFocusable(false);;

        button2 = new JButton("ON");
        button2.setBounds(172, 370, 60,23);
        button2.setFont(new Font("Arial",Font.BOLD,12));
        button2.setBorder(border3);
        button2.addActionListener(this);
        button2.setFocusable(false);;

        button3 = new JButton("OFF");
        button3.setBounds(235, 370, 60,23);
        button3.setFont(new Font("Arial",Font.BOLD,12));
        button3.setBorder(border3);
        button3.addActionListener(this);
        button3.setFocusable(false);;

        button4 = new JButton("BATTERY");
        button4.setBounds(185, 420, 100,23);
        button4.addActionListener(this);
        button4.setBorder(border4);
        button4.setFocusable(false);;

        label = new JLabel();
        label.setText("CALCULATOR PROJECT");
        label.setFont(new Font("Arial",Font.BOLD,30));
        label.setVisible(false);
        label.setForeground(Color.green);

        label1 = new JLabel();
        label1.setText("POWER: ");

        label2 = new JLabel();
        label2.setText(" ON ");
        label2.setFont(new Font("Arial",Font.BOLD,12));
        label2.setForeground(Color.green);
        label2.setVisible(false);


        label3 = new JLabel();
        label3.setText(" OFF ");
        label3.setFont(new Font("Arial",Font.BOLD,12));
        label3.setForeground(Color.red);

        label4 = new JLabel();
        label4.setText("PRESS ANY BUTTON");
        label4.setFont(new Font("Arial",Font.BOLD,30));
        label4.setForeground(Color.green);
        label4.setVisible(false);

        label5 = new JLabel();
        label5.setText("POWER IS OFF...");
        label5.setFont(new Font("Arial",Font.BOLD,30));
        label5.setForeground(Color.red);
        label5.setVisible(false);

        label6 = new JLabel();
        label6.setText("85% [||||||||||  ] ");
        label6.setFont(new Font("Arial",Font.BOLD,30));
        label6.setForeground(Color.green);
        label6.setVisible(false);

        label7 = new JLabel();
        label7.setText("STUDENT INFO");
        label7.setFont(new Font("Arial",Font.BOLD,30));
        label7.setForeground(Color.green);
        label7.setVisible(false);


        frame = new JFrame();
        frame.setTitle("CALCULATOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);
        frame.setLayout(null);
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(button);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        panel1.add(panelg);
        panel1.add(panelb);
        panel1.add(panelbl);
        panel1.add(panelr);
        frame.add(panel);
        frame.add(panel1);
        frame.add(panel2);
        panel2.add(label1);
        frame.add(panel3);
        panel3.add(label2);
        panel3.add(label3);
        frame.add(panel4);
        frame.add(panel5);
        frame.add(panel6);
        panel5.add(panel8);
        panel6.add(panel7);
        frame.add(panel9);
        panel5.add(panel10);
        panel6.add(panel11);
        panel.add(label7);
        panel.add(label6);
        panel.add(label5);
        panel.add(label4);
        panel.add(label);



    }
    boolean calculatorEnabled;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button4) {
            label6.setVisible(true);
        }
        if (e.getSource() == button2) {
            label2.setVisible(true);
            label4.setVisible(true);
            label5.setVisible(false);
            label6.setVisible(false);
            panel7.setVisible(true);
            panel8.setVisible(true);
            panel10.setVisible(false);
            panel11.setVisible(false);
            frame.add(button);
            frame.add(button1);
            calculatorEnabled = true;

        }
        if (e.getSource() == button3) {
            label.setVisible(false);
            label2.setVisible(false);
            label4.setVisible(false);
            label5.setVisible(false);
            label6.setVisible(false);
            label7.setVisible(false);
            panel7.setVisible(false);
            panel8.setVisible(false);
            panel10.setVisible(true);
            panel11.setVisible(true);
            calculatorEnabled = false;
        }

        if (calculatorEnabled) {
            if (e.getSource() == button) {
                label4.setVisible(false);
                label6.setVisible(false);
                label7.setVisible(true);
                JOptionPane.showMessageDialog(null, "                    NAME: \n  LANCE TIMOTHY B. SATORRE");
                JOptionPane.showMessageDialog(null, "   COURSE & YR:   BSIT 1B - 1");
                JOptionPane.showMessageDialog(null, "           DESCRIPTION: \n   CALCULATOR PROJECT");
                JOptionPane.showMessageDialog(null, " // WELCOME TO MY PROJECT //\n            PRESS (START)");
                label7.setVisible(false);
                label.setVisible(true);
            }
            if (e.getSource() == button1) {

                frame.dispose();
                String answer;
                String choosen;
                do {
                    System.out.printf("\n|>----------------////// CHOOSE FOR YOUR OUTPUT //////----------------<| \n");
                    do {
                        System.out.printf(" 'A' for all operator, 'B' choose only one operator: ");
                        choosen = in.nextLine();
                    } while (!choosen.equalsIgnoreCase("A") && !choosen.equalsIgnoreCase("B"));

                    System.out.println();
                    if (choosen.equalsIgnoreCase("A")) {

                        System.out.printf("          |-----------------------|\n" +
                                          "          |           %s           |\n" +
                                          "          |     ALL OPERATORS     |\n" +
                                          "          |-----------------------|\n", choosen);
                        InputUser();
                        Addition();
                        Subtraction();
                        Multiplication();
                        Division();
                        Modulo();

                        Convert();
                        in.nextLine();
                    }
                    else if (choosen.equalsIgnoreCase("B")) {
                        System.out.printf("                       |-----------------------|\n" +
                                          "                       |           %s           |\n" +
                                          "                       |   ONE OPERATOR ONLY   |\n" +
                                          "                       |-----------------------|\n", choosen);
                        Menu();
                    }

                    System.out.printf("\n|||------------------------>>>>>> E N D <<<<<<------------------------||| \n");
                    do {
                        System.out.printf("\nDo you want to try again? (Yes or No): ");
                        answer = in.nextLine();
                    } while (!answer.equalsIgnoreCase("Yes") && !answer.equalsIgnoreCase("No"));

                        System.out.println();
                        System.out.printf("|||-------------------------------------------------------------------||| \n\n\n\n");

                    if (answer.equalsIgnoreCase("Yes")) {
                        System.out.printf("                       |-----------------------|\n" +
                                          "                       |      NEW ATTEMPT      |\n" +
                                          "                       |-----------------------|\n");
                    }


                } while (answer.equalsIgnoreCase("Yes"));

                    JOptionPane.showMessageDialog(null, "THANKYOU!");
                    System.out.printf("                       |------------------------|\n" +
                                      "                       |       COME AGAIN       |\n" +
                                      "                       |------------------------|\n");
                    JOptionPane.showMessageDialog(null, "EXIT....");
                    System.out.printf("                            >>> NOW EXIT <<<\n\n");
            }
        }
        else {
            if (e.getSource() == button || e.getSource() == button1 ) {
                label5.setVisible(true);
                label6.setVisible(false);
            }
        }
    }


    static int num1;
    static int num2;
    static int num3;
    static int num4;
    static int num5;
    static int many;
    static int result;
    static int num;
    static float results;
    static int convert;
    static void Menu() {
        int oper;
        String sure;
        do {
            System.out.printf("\n|||--------------------->>>>>> M  E  N  U <<<<<<----------------------||| \n\n");
            String[] menu = {"ADDITION", "SUBTRACTION", "MULTIPLICATION", "DIVISION", "MODULO", "EXIT"};

            for (int i = 0; i < menu.length; i++) {
                System.out.printf("%d. %s\n", i + 1, menu[i]);
            }
            oper = 0;
            do {
                try {
                    System.out.printf("Choose a number: ");
                    oper = in.nextInt();

                    if ( oper > 6 || oper < 1) {
                        System.out.printf(" (NUMBER 1 to 6 only)\n");
                        System.out.printf("-----------------------\n");
                    }
                }
                catch (InputMismatchException e) {
                    System.out.printf("     (NUMBER ONLY)\n");
                    System.out.printf("-----------------------\n");
                    in.nextLine();
                }
            }while(oper > 6 || oper < 1);

            in.nextLine();
            do {
                System.out.printf("Are you sure to continue?(Yes / No): ");
                sure = in.nextLine();
            }while ( !sure.equalsIgnoreCase("Yes") && !sure.equalsIgnoreCase("No"));
        } while (sure.equalsIgnoreCase("No"));

        switch (oper) {
            case 1:
                System.out.printf("\n|||---------------------->>>>>> ADDITION <<<<<<-----------------------||| \n");
                InputUser();
                Addition();
                Convert();
                in.nextLine();
                break;
            case 2:
                System.out.printf("\n|||-------------------->>>>>> SUBTRACTION <<<<<<----------------------||| \n");
                InputUser();
                Subtraction();
                Convert();
                in.nextLine();
                break;
            case 3:
                System.out.printf("\n|||------------------->>>>>> MULTIPLICATION <<<<<<--------------------||| \n");
                InputUser();
                Multiplication();
                Convert();
                in.nextLine();
                break;
            case 4:
                System.out.printf("\n|||---------------------->>>>>> DIVISION <<<<<<-----------------------||| \n");
                InputUser();
                Division();
                Convert();
                in.nextLine();
                break;
            case 5:
                System.out.printf("\n|||----------------------->>>>>> MODULO <<<<<<------------------------||| \n");
                InputUser();
                Modulo();
                Convert();
                in.nextLine();
                break;
            case 6:
                System.out.printf("\nEXIT......\n");
                break;
        }

    }
    static void InputUser() {
            many = 0;
        do {
          try {
                System.out.printf("How many values do you want? 2 to 5 only: ");
                many = in.nextInt();
               if (many > 5 || many < 2) {
                   System.out.printf(" (NUMBER 2 to 5 only)\n");
                   System.out.printf("-----------------------\n\n");
               }
            }
          catch (InputMismatchException e) {
                  System.out.printf("     (NUMBER ONLY)\n");
                  System.out.printf("-----------------------\n\n");
                  in.nextLine();
          }
        } while (many > 5 || many < 2);


     do {
        try {
             System.out.printf("Enter a value for #1: ");
             num1 = in.nextInt();
             break;
        }
        catch (InputMismatchException e) {
             System.out.printf("     (NUMBER ONLY)\n");
             System.out.printf("-----------------------\n\n");
             in.nextLine();
        }
        } while(  true );

        int[] num = new int[many];
        for (int i = 1; i < num.length; i++) {
             do {
                  try {
                       System.out.printf("Enter a value for #%d: ", i + 1);
                       num[i] = in.nextInt();
                       break;
                      }
                  catch (InputMismatchException e) {
                      System.out.printf("     (NUMBER ONLY)\n");
                      System.out.printf("-----------------------\n\n");
                      in.nextLine();
                 }
             } while (true);

            if (many == 2) {
                num2 = num[1];
            }
            else if (many == 3) {
                num2 = num[1];
                num3 = num[2];
            }
            else if (many == 4) {
                num2 = num[1];
                num3 = num[2];
                num4 = num[3];
            }
            else {
                num2 = num[1];
                num3 = num[2];
                num4 = num[3];
                num5 = num[4];
            }
        }

        System.out.printf("\n|||-------------------->>>>>> R E S U L T <<<<<<----------------------||| \n");
    }
    static void Addition() {
        switch (many) {
            case 2:
                result = num1 + num2;
                break;
            case 3:
                result = num1 + num2 + num3;
                break;
            case 4:
                result = num1 + num2 + num3 + num4;
                break;
            case 5:
                result = num1 + num2 + num3 + num4 + num5;
                break;
        }
        System.out.printf("\n                       |----------------------------|\n"+
                            "                            ADDITION: %d    \n"+
                            "                       |----------------------------|\n", result);
    }
    static void Subtraction() {
        switch (many) {
            case 2:
                result = num1 - num2;
                break;
            case 3:
                result = num1 - num2 - num3;
                break;
            case 4:
                result = num1 - num2 - num3 - num4;
                break;
            case 5:
                result = num1 - num2 - num3 - num4 - num5;
                break;
        }
        System.out.printf("\n                       |----------------------------|\n"+
                            "                            SUBTRACTION: %d   \n"+
                            "                       |----------------------------|\n", result);
    }
    static void Multiplication() {
        switch (many) {
            case 2:
                result = num1 * num2;
                break;
            case 3:
                result = num1 * num2 * num3;
                break;
            case 4:
                result = num1 * num2 * num3 * num4;
                break;
            case 5:
                result = num1 * num2 * num3 * num4 * num5;
                break;
        }
        System.out.printf("\n                       |----------------------------|\n"+
                            "                            MULTIPLICATION: %d \n"+
                            "                       |----------------------------|\n", result);
    }
    static void Division() {

        switch (many) {
            case 2:
                results = (float) num1 / num2;
                if ( num1 == 0 || num2 == 0) {
                    results = 0;
                }
                break;
            case 3:
                results = (float) num1 / num2 / num3;
                if ( num1 == 0 || num2 == 0 || num3 == 0) {
                    results = 0;
                }
                break;
            case 4:
                results = (float) num1 / num2 / num3 / num4;
                if ( num1 == 0 || num2 == 0 || num3 == 0 || num4 == 0) {
                    results = 0;
                }
                break;
            case 5:
                results = (float) num1 / num2 / num3 / num4 / num5;
                if ( num1 == 0 || num2 == 0 || num3 == 0 || num4 == 0 || num5 == 0) {
                    results = 0;
                }
                break;
        }
        if ( results == 0) {
            System.out.printf("\n           You entered 0,and this number cannot be divided!\n");
        }
        else {
            System.out.printf("\n                       |----------------------------|\n"+
                                "                            DIVISION: %.4f      \n"+
                                "                       |----------------------------|\n", results);
        }
    }
    static void Modulo() {

        switch (many) {
            case 2:
                results = num1 + num2;
                result = (int)results % 2;
                break;
            case 3:
                results = num1 + num2 + num3;
                result =(int)results % 3;
                break;
            case 4:
                results = num1 + num2 + num3 + num4;
                result = (int)results % 4;
                break;
            case 5:
                results = num1 + num2 + num3 + num4 + num5;
                result = (int)results % 5;
                break;
        }

        System.out.printf("\n                       |----------------------------|\n"+
                            "                            MODULO: %d     \n"+
                            "                       |----------------------------|\n", result);
        System.out.printf("\n For modulo, adding all the values and dividing it by the total numbers\n");
    }
    static void Convert() {

        System.out.printf("\n|||----------------->>>>>> C O N V E R S I O N <<<<<<-----------------||| \n");
        String think;
            in.nextLine();
        do {
            System.out.printf("'E' Enter a new number, 'P' the value that you input on the upper side: ");
            think = in.nextLine();

            if  ( !think.equalsIgnoreCase("E") && !think.equalsIgnoreCase("P")){
                System.out.printf("INVALID INPUT\n");
            }
        }  while ( !think.equalsIgnoreCase("E") && !think.equalsIgnoreCase("P"));

          if (think.equalsIgnoreCase("E")) {
              boolean check;
            do { try {
                    System.out.printf("\nEnter a number: ");
                    num = in.nextInt();
                    check = false;
             } catch (InputMismatchException e) {
                     System.out.printf("     (NUMBER ONLY)\n");
                     System.out.printf("-----------------------\n");
                     check = true;
                     in.nextLine();
             }

            } while (check);

              int inNum = num;
              int hexaNum = num;
              int octaNum = num;

              if (num <= 0) {
                  System.out.printf("\n         |_________________|\n" +
                                      "              GIVEN: %d    \n" +
                                      "         |_________________|\n" +
                                      "         |  .............  |\n\n", inNum);

                  System.out.printf("\n|------------------------------------------------|\n" +
                                      "|     Less than or equal 0 is not Supported.     |\n" +
                                      "|------------------------------------------------|\n");
              }
              else {
                  System.out.printf("\n         |_________________|\n" +
                                      "              GIVEN: %d    \n" +
                                      "         |_________________|\n" +
                                      "         |  .............  |\n\n", inNum);

                    //BINARYL------------------------------------------------------
                  int[] bin = new int[100];
                  int counter1 = 0;
                  while (num > 0) {
                      bin[counter1] = num % 2;
                      num = num / 2;
                      counter1++;
                  }
                  System.out.printf("BINARY: ");
                  for (int i = counter1 - 1; i >= 0; i--) {
                      System.out.print(bin[i]);
                  }
                  System.out.println();

                    //OCTAL------------------------------------------------------
                  int[] oct = new int[100];
                  int count1 = 0;
                  while (octaNum > 0) {
                      oct[count1] = octaNum % 8;
                      octaNum = octaNum / 8;
                      count1++;
                  }
                  System.out.printf("OCTAL: ");
                  for (int j = count1 - 1; j >= 0; j--) {
                      System.out.print(oct[j]);
                  }
                  System.out.println();

                    //HEXA------------------------------------------------------
                  char[] hex = new char[100];
                  int counts1 = 0;
                  while (hexaNum > 0) {
                        hex[counts1] =  hexaNum % 16 == 10 ? 'A' :
                                        hexaNum % 16 == 11 ? 'B' :
                                        hexaNum % 16 == 12 ? 'C' :
                                        hexaNum % 16 == 13 ? 'D' :
                                        hexaNum % 16 == 14 ? 'E' :
                                        hexaNum % 16 == 15 ? 'F' :
                                        (char) (hexaNum % 16 + 48);
                      hexaNum = hexaNum / 16;
                      counts1++;
                  }
                  System.out.printf("HEXADECIMAL: ");
                  for (int k = counts1 - 1; k >= 0; k--) {
                      System.out.print(hex[k]);
                  }
              }
          }
          else if (think.equalsIgnoreCase("P")) {
              convert = 0;
              if (num3 == 0 && num4 == 0 && num5 == 0) {
                  do {
                      try {
                          System.out.printf("\nOn the upper side, enter the number of the value that do you want to convert (1 or 2): ");
                          convert = in.nextInt();
                      } catch (InputMismatchException e) {
                          System.out.printf("     (NUMBER ONLY)\n");
                          System.out.printf("-----------------------\n");
                          in.nextLine();
                      }
                  } while (convert > 2 || convert < 1);
              }
              else if (num4 == 0 && num5 == 0) {

                  do {
                      try {
                          System.out.printf("\nOn the upper side, enter the number of the value that do you want to convert (1 - 3): ");
                          convert = in.nextInt();
                      } catch (InputMismatchException e) {
                          System.out.printf("     (NUMBER ONLY)\n");
                          System.out.printf("-----------------------\n");
                          in.nextLine();
                      }
                  } while (convert > 3 || convert < 1);
              }
              else if (num5 == 0) {

                  do {
                      try {
                          System.out.printf("\nOn the upper side, enter the number of the value that do you want to convert (1 - 4): ");
                          convert = in.nextInt();
                      } catch (InputMismatchException e) {
                          System.out.printf("     (NUMBER ONLY)\n");
                          System.out.printf("-----------------------\n");
                          in.nextLine();
                      }
                  } while (convert > 4 || convert < 1);
              }
              else {
                  do {
                      try {
                          System.out.printf("\nOn the upper side, enter the number of the value that do you want to convert (1 - 5): ");
                          convert = in.nextInt();
                      } catch (InputMismatchException e) {
                          System.out.printf("     (NUMBER ONLY)\n");
                          System.out.printf("-----------------------\n");
                          in.nextLine();
                      }
                  } while (convert > 5 || convert < 1);
              }


// FOR NUMBER 1 CONVERSION
              if (convert == 1) {

                  if (num1 <= 0) {
                      System.out.printf("\n         |________________|\n" +
                                          "            NUMBER 1: %d  \n" +
                                          "         |________________|\n" +
                                          "         | .............. |\n\n", num1);

                      System.out.printf("\n|------------------------------------------------|\n" +
                                          "|     Less than or equal 0 is not Supported.     |\n" +
                                          "|------------------------------------------------|\n");
                  }
                  else {
                      int temp1 = num1;
                      int hexa1 = num1;
                      int octa1 = num1;

                      System.out.printf("\n         |________________|\n" +
                                          "            NUMBER 1: %d  \n" +
                                          "         |________________|\n" +
                                          "         | .............. |\n\n", temp1);
                        // BINARY------------------------------------------------------------------------
                      int[] bin1 = new int[100];
                      int counter1 = 0;
                      while (num1 > 0) {
                          bin1[counter1] = num1 % 2;
                          num1 = num1 / 2;
                          counter1++;
                      }
                      System.out.printf("BINARY: ");
                      for (int i = counter1 - 1; i >= 0; i--) {
                          System.out.print(bin1[i]);
                      }
                      System.out.println();

                       //OCTAL------------------------------------------------------------------------
                      int[] oct1 = new int[100];
                      int count1 = 0;
                      while (octa1 > 0) {
                          oct1[count1] = octa1 % 8;
                          octa1 = octa1 / 8;
                          count1++;
                      }
                      System.out.printf("OCTAL: ");
                      for (int j = count1 - 1; j >= 0; j--) {
                          System.out.print(oct1[j]);
                      }
                      System.out.println();
                        //HEXA------------------------------------------------------------------------
                      char[] hex1 = new char[100];
                      int counts1 = 0;
                      while (hexa1 > 0) {
                            hex1[counts1] = hexa1 % 16 == 10 ? 'A' :
                                            hexa1 % 16 == 11 ? 'B' :
                                            hexa1 % 16 == 12 ? 'C' :
                                            hexa1 % 16 == 13 ? 'D' :
                                            hexa1 % 16 == 14 ? 'E' :
                                            hexa1 % 16 == 15 ? 'F' :
                                            (char) (hexa1 % 16 + 48);
                          hexa1 = hexa1 / 16;
                          counts1++;
                      }
                      System.out.printf("HEXADECIMAL: ");
                      for (int k = counts1 - 1; k >= 0; k--) {
                          System.out.print(hex1[k]);
                      }
                  }
              }
// FOR NUMBER 2 CONVERSION
              else if (convert == 2) {
                  if (num2 <= 0) {
                      System.out.printf("\n         |________________|\n" +
                                          "            NUMBER 2: %d  \n" +
                                          "         |________________|\n" +
                                          "         | .............. |\n\n", num2);

                      System.out.printf("\n|------------------------------------------------|\n" +
                                          "|     Less than or equal 0 is not Supported.     |\n" +
                                          "|------------------------------------------------|\n");
                  } else {
                      int temp2 = num2;
                      int hexa2 = num2;
                      int octa2 = num2;

                      System.out.printf("\n         |________________|\n" +
                                          "         |  NUMBER 2: %d  |\n" +
                                          "         |________________|\n" +
                                          "         | .............. |\n\n", temp2);
                        //BINARY------------------------------------------------------------------------
                      int[] bin2 = new int[100];
                      int counter2 = 0;
                      while (num2 > 0) {
                          bin2[counter2] = num2 % 2;
                          num2 = num2 / 2;
                          counter2++;
                      }
                      System.out.printf("BINARY: ");
                      for (int i = counter2 - 1; i >= 0; i--) {
                          System.out.print(bin2[i]);
                      }
                      System.out.println();

                        //OCTAL------------------------------------------------------------------------
                      int[] oct2 = new int[100];
                      int count2 = 0;
                      while (octa2 > 0) {
                          oct2[count2] = octa2 % 8;
                          octa2 = octa2 / 8;
                          count2++;
                      }
                      System.out.printf("OCTAL: ");
                      for (int j = count2 - 1; j >= 0; j--) {
                          System.out.print(oct2[j]);
                      }
                      System.out.println();

                        //HEXA------------------------------------------------------------------------
                      char[] hex2 = new char[100];
                      int counts2 = 0;
                      while (hexa2 > 0) {
                            hex2[counts2] = hexa2 % 16 == 10 ? 'A' :
                                            hexa2 % 16 == 11 ? 'B' :
                                            hexa2 % 16 == 12 ? 'C' :
                                            hexa2 % 16 == 13 ? 'D' :
                                            hexa2 % 16 == 14 ? 'E' :
                                            hexa2 % 16 == 15 ? 'F' :
                                            (char) (hexa2 % 16 + 48);
                          hexa2 = hexa2 / 16;
                          counts2++;
                      }
                      System.out.printf("HEXADECIMAL: ");
                      for (int k = counts2 - 1; k >= 0; k--) {
                          System.out.print(hex2[k]);
                      }
                  }
              }
// FOR NUMBER 3 CONVERSION
              else if (convert == 3) {
                  if (num3 <= 0) {
                      System.out.printf("\n         |________________|\n" +
                                          "            NUMBER 3: %d  \n" +
                                          "         |________________|\n" +
                                          "         | .............. |\n\n", num3);

                      System.out.printf("\n|------------------------------------------------|\n" +
                                          "|     Less than or equal 0 is not Supported.     |\n" +
                                          "|------------------------------------------------|\n");
                  }
                  else {
                      int temp3 = num3;
                      int hexa3 = num3;
                      int octa3 = num3;

                      System.out.printf("\n         |________________|\n" +
                                          "            NUMBER 3: %d  \n" +
                                          "         |________________|\n" +
                                          "         | .............. |\n\n", temp3);
                        //BINARY------------------------------------------------------------------------
                      int[] bin3 = new int[100];
                      int counter3 = 0;
                      while (num3 > 0) {
                          bin3[counter3] = num3 % 2;
                          num3 = num3 / 2;
                          counter3++;
                      }
                      System.out.printf("BINARY: ");
                      for (int i = counter3 - 1; i >= 0; i--) {
                          System.out.print(bin3[i]);
                      }
                      System.out.println();

                      //OCTAL------------------------------------------------------------------------
                      int[] oct3 = new int[100];
                      int count3 = 0;
                      while (octa3 > 0) {
                          oct3[count3] = octa3 % 8;
                          octa3 = octa3 / 8;
                          count3++;
                      }
                      System.out.printf("OCTAL: ");
                      for (int j = count3 - 1; j >= 0; j--) {
                          System.out.print(oct3[j]);
                      }
                      System.out.println();
                        //HEXA------------------------------------------------------------------------
                      char[] hex3 = new char[100];
                      int counts3 = 0;
                      while (hexa3 > 0) {
                            hex3[counts3] = hexa3 % 16 == 10 ? 'A' :
                                            hexa3 % 16 == 11 ? 'B' :
                                            hexa3 % 16 == 12 ? 'C' :
                                            hexa3 % 16 == 13 ? 'D' :
                                            hexa3 % 16 == 14 ? 'E' :
                                            hexa3 % 16 == 15 ? 'F' :
                                            (char) (hexa3 % 16 + 48);
                          hexa3 = hexa3 / 16;
                          counts3++;
                      }
                      System.out.printf("HEXADECIMAL: ");
                      for (int k = counts3 - 1; k >= 0; k--) {
                          System.out.print(hex3[k]);
                      }
                  }
              }
// FOR NUMBER 4 CONVERSION
              else if (convert == 4) {
                  if (num4 <= 0) {
                      System.out.printf("\n         |________________|\n" +
                                          "            NUMBER 4: %d  \n" +
                                          "         |________________|\n" +
                                          "         | .............. |\n\n", num4);

                      System.out.printf("\n|------------------------------------------------|\n" +
                                          "|     Less than or equal 0 is not Supported.     |\n" +
                                          "|------------------------------------------------|\n");
                  }
                  else {
                      int temp4 = num4;
                      int hexa4 = num4;
                      int octa4 = num4;

                      System.out.printf("\n         |________________|\n" +
                                          "            NUMBER 4: %d  \n" +
                                          "         |________________|\n" +
                                          "         | .............. |\n\n", temp4);
                        //BINARY------------------------------------------------------------------------
                      int[] bin4 = new int[100];
                      int counter4 = 0;
                      while (num4 > 0) {
                          bin4[counter4] = num4 % 2;
                          num4 = num4 / 2;
                          counter4++;
                      }
                      System.out.printf("BINARY: ");
                      for (int i = counter4 - 1; i >= 0; i--) {
                          System.out.print(bin4[i]);
                      }
                      System.out.println();

                      //OCTAL------------------------------------------------------------------------
                      int[] oct4 = new int[100];
                      int count4 = 0;
                      while (octa4 > 0) {
                          oct4[count4] = octa4 % 8;
                          octa4 = octa4 / 8;
                          count4++;
                      }
                      System.out.printf("OCTAL: ");
                      for (int j = count4 - 1; j >= 0; j--) {
                          System.out.print(oct4[j]);
                      }
                      System.out.println();

                        //HEXA------------------------------------------------------------------------
                      char[] hex4 = new char[100];
                      int counts4 = 0;
                      while (hexa4 > 0) {
                            hex4[counts4] = hexa4 % 16 == 10 ? 'A' :
                                            hexa4 % 16 == 11 ? 'B' :
                                            hexa4 % 16 == 12 ? 'C' :
                                            hexa4 % 16 == 13 ? 'D' :
                                            hexa4 % 16 == 14 ? 'E' :
                                            hexa4 % 16 == 15 ? 'F' :
                                            (char) (hexa4 % 16 + 48);
                          hexa4 = hexa4 / 16;
                          counts4++;
                      }
                      System.out.printf("HEXADECIMAL: ");
                      for (int k = counts4 - 1; k >= 0; k--) {
                          System.out.print(hex4[k]);
                      }
                  }
              }
// FOR NUMBER 5 CONVERSION
              else if (convert == 5) {

                  if (num5 <= 0) {
                      System.out.printf("\n         |________________|\n" +
                                          "            NUMBER 5: %d  \n" +
                                          "         |________________|\n" +
                                          "         | .............. |\n\n", num5);

                      System.out.printf("\n|------------------------------------------------|\n" +
                                          "|     Less than or equal 0 is not Supported.     |\n" +
                                          "|------------------------------------------------|\n");
                  } else {
                      int temp5 = num5;
                      int hexa5 = num5;
                      int octa5 = num5;

                      System.out.printf("\n         |________________|\n" +
                                          "            NUMBER 5: %d  \n" +
                                          "         |________________|\n" +
                                          "         | .............. |\n\n", temp5);

                      //BINARY------------------------------------------------------------------------
                      int[] bin5 = new int[100];
                      int counter5 = 0;
                      while (num5 > 0) {
                          bin5[counter5] = num5 % 2;
                          num5 = num5 / 2;
                          counter5++;
                      }
                      System.out.printf("BINARY: ");
                      for (int i = counter5 - 1; i >= 0; i--) {
                          System.out.print(bin5[i]);
                      }
                      System.out.println();

                      //OCTAL------------------------------------------------------------------------
                      int[] oct5 = new int[100];
                      int count5 = 0;
                      while (octa5 > 0) {
                          oct5[count5] = octa5 % 8;
                          octa5 = octa5 / 8;
                          count5++;
                      }
                      System.out.printf("OCTAL: ");
                      for (int j = count5 - 1; j >= 0; j--) {
                          System.out.print(oct5[j]);
                      }
                      System.out.println();

                      //HEXA------------------------------------------------------------------------
                      char[] hex5 = new char[100];
                      int counts5 = 0;
                      while (hexa5 > 0) {
                            hex5[counts5] = hexa5 % 16 == 10 ? 'A' :
                                            hexa5 % 16 == 11 ? 'B' :
                                            hexa5 % 16 == 12 ? 'C' :
                                            hexa5 % 16 == 13 ? 'D' :
                                            hexa5 % 16 == 14 ? 'E' :
                                            hexa5 % 16 == 15 ? 'F' :
                                            (char) (hexa5 % 16 + 48);
                          hexa5 = hexa5 / 16;
                          counts5++;
                      }
                      System.out.printf("HEXADECIMAL: ");
                      for (int k = counts5 - 1; k >= 0; k--) {
                          System.out.print(hex5[k]);
                      }
                  }
              }

          }
        num1 = 0;
        num2 = 0;
        num3 = 0;
        num4 = 0;
        num5 = 0;
    }
}

public class Calculators {

    public static void main(String[] args) {

        new SFrame();
    }

}
