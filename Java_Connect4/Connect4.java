/*
 * Name: Eric Cho
 * Date: Jan 16, 2023
 * Description: This is a game of connect4. In the game, two players compete with each other to connect 4 of their assigned shapes in a row (either diagonally, horisontally or vertically). 
 *
*/

import java.util.*;


class Connect4 
{

   public static void rules(){
   
      Scanner kbReader = new Scanner(System.in);
      
      System.out.println("\n\n\n                  Rules                 ");
      System.out.println("------------------------------------------");
      System.out.println("1. Each player gets their own assigned letter");
      System.out.println("2. Player 1 (represented as 'X') starts first with player 2 ('O') coming after");
      System.out.println("3. Put the letter in your desired column (labled with letters: A, B, C, D, E, F, or G).");
      System.out.println("4. The first person to connect 4 of their letters in a row wins!");
      System.out.println("5. The 4 pieces may be connected horisontally, vertically, or diagonally.");
      System.out.println("6. If there is no more space within the board, it is a tie.");
      System.out.println("\n\n      To continue: press ENTER ");
      String userContinue = kbReader.nextLine();
      System.out.println("\n\n\n\n\n");
   }

   public static String letterAmount(String letter){ //checks if there is more than 1 letter 
      
      Scanner kbReader = new Scanner(System.in);
      int letterLength = letter.length();
      if (letterLength != 1){
            
         while (true){
         
            System.out.println("Please enter a single letter");
            letter = kbReader.nextLine();
            letter = letter.toUpperCase();
            letterLength = letter.length();
            
            if (letterLength == 1)
            break;
         }
         
      }
      return letter;
   }

   public static String outOfSpaces(String letter){ //checks if the column is full
   
      Scanner kbReader = new Scanner(System.in);
      String letterStored = letter;
   
      System.out.println("\nThis column is full. Please choose other letter");
      letter = kbReader.nextLine();
      letter = letter.toUpperCase();    
      letter = letterAmount(letter);
      char letterASCII = letter.charAt(0);
      int letterCheck = (int)letterASCII;
      
      if (letterCheck > 71 || letterCheck < 65){ //checks if the right letter is inputted
      
        while (true){ 
            System.out.println("\n\nPlease enter a letter between A and G");
            letter = kbReader.nextLine();
            letter = letter.toUpperCase();
            letter = letterAmount(letter);
            letterASCII = letter.charAt(0);
            letterCheck = (int)letterASCII;
         
         if (letterCheck <= 71 && letterCheck >= 65)
            break;
         
         }
      }   
      
   return letter;
   
   }

   public static void main(String[] args){
      
      rules();
      
      Scanner kbReader = new Scanner(System.in);
      int[] rowNumber = {6, 6, 6, 6, 6, 6, 6}; //row number A -> G
      String player1Letter = "X"; //player 1 = X ; player 2 = O (player1 gets first move)
      String player2Letter = "O";
      int counter = 0; //used for the number of turns
      String winner = "";
      
      String[] columnA = {" ", " ", " ", " ", " " , " "}; //6x7 possible placements
      String[] columnB = {" ", " ", " ", " ", " " , " "}; 
      String[] columnC = {" ", " ", " ", " ", " " , " "}; 
      String[] columnD = {" ", " ", " ", " ", " " , " "};
      String[] columnE = {" ", " ", " ", " ", " " , " "};
      String[] columnF = {" ", " ", " ", " ", " " , " "};
      String[] columnG = {" ", " ", " ", " ", " " , " "};
      
      System.out.println("        Turn: Player 1 - X");
      System.out.println("___________________________________________"); //top piece
      
      for (int i = 0; i < 6; i++){ //to make the game's board (6 playable rows)
         
         //this makes the row for the board
         System.out.print("|  "+ columnA[i] + "  "); //decisions will be inserted in the middle of vertical line 
         System.out.print("|  "+ columnB[i] + "  "); 
         System.out.print("|  "+ columnC[i] + "  ");
         System.out.print("|  "+ columnD[i] + "  ");
         System.out.print("|  "+ columnE[i] + "  ");
         System.out.print("|  "+ columnF[i] + "  ");
         System.out.print("|  "+ columnG[i] + "  |");
         System.out.println();
         
         if (i < 5)
            System.out.println("-------------------------------------------"); //used to separate the rows
      }
      
      System.out.println("___________________________________________"); //bottom piece
      System.out.println("|  A  |  B  |  C  |  D  |  E  |  F  |  G  |"); //labels the columns
      
      while(counter < 42){
         
         System.out.println("\n\nWhich column would you like to place it in (letter only)");
         String letter = kbReader.nextLine();
         letter = letter.toUpperCase();
         letter = letterAmount(letter);
         char letterASCII = letter.charAt(0); //this char is only used for ascii conversion
         int letterCheck = (int)letterASCII;
         
         if (letterCheck > 71 || letterCheck < 65){ //checks if the right letter is inputted | 71 = G; 65 = A
      
            while (true){ 
            System.out.println("\n\nPlease enter a letter between A and G");
            letter = kbReader.nextLine();
            letter = letter.toUpperCase();
            letter = letterAmount(letter);
            letterASCII = letter.charAt(0);
            letterCheck = (int)letterASCII;
            
            if (letterCheck <= 71 && letterCheck >= 65) 
               break;
               
            }
         }
         
         while (true){ //checks if the column is full
            if (rowNumber[letterCheck - 65] == 0){
            
               letter = outOfSpaces(letter);
               letterASCII = letter.charAt(0);
               letterCheck = (int)letterASCII;
            
            }
            
            if (rowNumber[letterCheck - 65] != 0)
               break;
         
         }

         
         int whichColumn = letterCheck - 65; //ASCII 'A' value is 65
         rowNumber[whichColumn] -= 1;
         
         //determines which row it should be placed in
         if (letter.equals("A"))
            columnA[rowNumber[whichColumn]] = player1Letter;
         else if (letter.equals("B"))
            columnB[rowNumber[whichColumn]] = player1Letter;
         else if (letter.equals("C"))
            columnC[rowNumber[whichColumn]] = player1Letter;
         else if (letter.equals("D"))
            columnD[rowNumber[whichColumn]] = player1Letter;
         else if (letter.equals("E"))
            columnE[rowNumber[whichColumn]] = player1Letter;
         else if (letter.equals("F"))
            columnF[rowNumber[whichColumn]] = player1Letter;
         else if (letter.equals("G"))
            columnG[rowNumber[whichColumn]] = player1Letter;
            
         System.out.println("\n\n\n\n\n");
         System.out.println("        Turn: Player 2 - O");
         System.out.println("___________________________________________"); //top piece
         
         for (int i = 0; i < 6; i++){ //to make the game's board (6 playable rows)
            
            //this makes the row for the board
            System.out.print("|  "+ columnA[i] + "  "); //decisions will be inserted in the middle of vertical line 
            System.out.print("|  "+ columnB[i] + "  "); 
            System.out.print("|  "+ columnC[i] + "  ");
            System.out.print("|  "+ columnD[i] + "  ");
            System.out.print("|  "+ columnE[i] + "  ");
            System.out.print("|  "+ columnF[i] + "  ");
            System.out.print("|  "+ columnG[i] + "  |");
            System.out.println();
            
            if (i < 5)
               System.out.println("-------------------------------------------"); //separates the rows
            
         }
         
         System.out.println("___________________________________________"); //bottom piece
         System.out.println("|  A  |  B  |  C  |  D  |  E  |  F  |  G  |"); //labels the columns
         
         //checker
         String[] combinedColumns = new String[42]; 
         System.arraycopy(columnA, 0, combinedColumns, 0, 6); //combines all the 7 arrays into one
         System.arraycopy(columnB, 0, combinedColumns, 6, 6);
         System.arraycopy(columnC, 0, combinedColumns, 12, 6);
         System.arraycopy(columnD, 0, combinedColumns, 18, 6);
         System.arraycopy(columnE, 0, combinedColumns, 24, 6);
         System.arraycopy(columnF, 0, combinedColumns, 30, 6);
         System.arraycopy(columnG, 0, combinedColumns, 36, 6);
         
         int verticalCounter = 0;
         int horisontalCounter = 0;
         int diagonalCounter = 0;
         int changeRow = 5;
         for (int i = 0; i < 42; i++){ //checks for vertical wins
            
            if (combinedColumns[i].equals("X")) //if matches, increase the counter
               verticalCounter++;
               
            if (combinedColumns[i].equals("O") || combinedColumns[i].equals(" ")) //if the next value doesnt match reset the counter
               verticalCounter = 0;
               
            if (i % changeRow == 0){ //enters a new column
               verticalCounter = 0;
               changeRow += 6;
            }
               
            if(verticalCounter == 4){ //wins if there are 4 in a row
               counter = 42;
               winner = player1Letter;
            }
           
         } 
         
         if (counter == 42) //ends game if there is 4 in a row
            break;
         
         for (int i = 0; i < 6; i++){ //checks for horisontal wins
         
            horisontalCounter = 0;
            for (int a = 0; a <= 36; a += 6){
                  
                  if (combinedColumns[i + a].equals("X"))
                     horisontalCounter++;
                  
                  if (combinedColumns[i + a].equals("O") || combinedColumns[i + a].equals(" "))
                     horisontalCounter = 0;
                     
                  if (horisontalCounter == 4){
                     counter = 42;
                     winner = player1Letter;
                  }
                         
            }         
         }
         
         if (counter == 42) //ends game
            break;
         
         int possiblePlacements = 3;
         for (int i = 3; i < 6; i++){  //first half of diagonal checking (bottom left to top right)
         
            diagonalCounter = 0;
            for (int a = 0; a <= 5 * possiblePlacements; a+=5){ //possible placements multiplied by something equals to the number of spaces within the diagonal
               
               if (combinedColumns[i + a].equals("X"))
                  diagonalCounter++;
               
               if (combinedColumns[i + a].equals("O") || combinedColumns[i + a].equals(" "))
                  diagonalCounter = 0;
                  
               if (diagonalCounter == 4){
                  counter = 42;
                  winner = player1Letter;
               }
            
            }
            possiblePlacements++;
            
        } 
        
        if (counter == 42) //ends game
            break;

        possiblePlacements = 5;
        for (int i = 11; i < 24; i += 6){ //second half of diagonal checking (left to right)
        
           diagonalCounter = 0;
           for (int a = 0; a <= 5 * possiblePlacements; a += 5){ //possible placements multiplied by something equals to the number of spaces within the diagonal
            
               if (combinedColumns[i + a].equals("X"))
                  diagonalCounter++;
               
               if (combinedColumns[i + a].equals("O") || combinedColumns[i + a].equals(" "))
                  diagonalCounter = 0;
                  
               if (diagonalCounter == 4){
                  counter = 42;    
                  winner = player1Letter;
               }
         
            } 
        
           possiblePlacements--;
        }
        
         if (counter == 42) //ends game
            break;

         possiblePlacements = 3; 
         for (int i = 23; i < 36; i += 6){ //first half - checks diagonals (bottom right to top left)
         
            diagonalCounter = 0;
            for (int a = 0; a <= possiblePlacements * 7; a += 7){ //possible placements multiplied by something equals to the number of spaces within the diagonal
            
               if (combinedColumns[i - a].equals("X"))
                  diagonalCounter++;

               if (combinedColumns[i - a].equals("O") || combinedColumns[i - a].equals(" "))
                  diagonalCounter = 0;

               if (diagonalCounter == 4){
                  counter = 42;    
                  winner = player1Letter;
               }
            
            
            }
            possiblePlacements ++;
         }
         
         if (counter == 42) //ends game
            break;
            
         possiblePlacements = 3;
         for (int i = 39; i < 42; i++){ //second half of checking diagonal (right to left)
         
            diagonalCounter = 0;
            for (int a = 0; a <= possiblePlacements * 7; a += 7){ //possible placements multiplied by something equals to the number of spaces within the diagonal
            
               if (combinedColumns[i - a].equals("X"))
                  diagonalCounter++;
               
               if (combinedColumns[i - a].equals("O") || combinedColumns[i - a].equals(" "))
                  diagonalCounter = 0;

               if (diagonalCounter == 4){
                  counter = 42;    
                  winner = player1Letter;
               }
            
            }
            
            possiblePlacements++;
         } 

         if (counter == 42) //ends game
            break;

         
         System.out.println("\n\nWhich column would you like to place it in (letter only)");
         letter = kbReader.nextLine();
         letter = letter.toUpperCase();
         letter = letterAmount(letter);
         letterASCII = letter.charAt(0); //this char is only used for ascii conversion
         letterCheck = (int)letterASCII;
         
         if (letterCheck > 71 || letterCheck < 65){ //checks if the right letter is inputted
      
            while (true){ 
            System.out.println("\n\nPlease enter a letter between A and G");
            letter = kbReader.nextLine();
            letter = letter.toUpperCase();
            letter = letterAmount(letter);
            letterASCII = letter.charAt(0);
            letterCheck = (int)letterASCII;
            
            if (letterCheck <= 71 && letterCheck >= 65)
               break;
               
            }
         }
         
         while (true){ //checks if column is full
         
            if (rowNumber[letterCheck - 65] == 0){
            
               letter = outOfSpaces(letter);
               letterASCII = letter.charAt(0);
               letterCheck = (int)letterASCII;
            
            }
            
            if (rowNumber[letterCheck - 65] != 0)
               break;
         
         }
         
         
         whichColumn = letterCheck - 65; //ASCII 'A' value is 65
         rowNumber[whichColumn] -= 1;
         
         //determines which row it should be placed in
         if (letter.equals("A"))
            columnA[rowNumber[whichColumn]] = player2Letter;
         else if (letter.equals("B"))
            columnB[rowNumber[whichColumn]] = player2Letter;
         else if (letter.equals("C"))
            columnC[rowNumber[whichColumn]] = player2Letter;
         else if (letter.equals("D"))
            columnD[rowNumber[whichColumn]] = player2Letter;
         else if (letter.equals("E"))
            columnE[rowNumber[whichColumn]] = player2Letter;
         else if (letter.equals("F"))
            columnF[rowNumber[whichColumn]] = player2Letter;
         else if (letter.equals("G"))
            columnG[rowNumber[whichColumn]] = player2Letter;
            
         System.out.println("\n\n\n\n\n");
         System.out.println("        Turn: Player 1 - X");
         System.out.println("___________________________________________"); //top piece
         
         for (int i = 0; i < 6; i++){ //to make the game's board (6 playable rows)
            
            //this makes the row for the board
            System.out.print("|  "+ columnA[i] + "  "); //decisions will be inserted in the middle of vertical line 
            System.out.print("|  "+ columnB[i] + "  "); 
            System.out.print("|  "+ columnC[i] + "  ");
            System.out.print("|  "+ columnD[i] + "  ");
            System.out.print("|  "+ columnE[i] + "  ");
            System.out.print("|  "+ columnF[i] + "  ");
            System.out.print("|  "+ columnG[i] + "  |");
            System.out.println();
            
            if (i < 5)
               System.out.println("-------------------------------------------"); //separates the rows
            
         }
         
         System.out.println("___________________________________________"); //bottom piece
         System.out.println("|  A  |  B  |  C  |  D  |  E  |  F  |  G  |"); //labels the columns
        
         System.arraycopy(columnA, 0, combinedColumns, 0, 6); //updates the combined 7 arrays
         System.arraycopy(columnB, 0, combinedColumns, 6, 6);
         System.arraycopy(columnC, 0, combinedColumns, 12, 6);
         System.arraycopy(columnD, 0, combinedColumns, 18, 6);
         System.arraycopy(columnE, 0, combinedColumns, 24, 6);
         System.arraycopy(columnF, 0, combinedColumns, 30, 6);
         System.arraycopy(columnG, 0, combinedColumns, 36, 6);
         
         verticalCounter = 0;
         changeRow = 5;
         for (int i = 0; i < 42; i++){ //checks for vertical wins

            if (combinedColumns[i].equals("O"))
               verticalCounter++;
               
            if (combinedColumns[i].equals("X") || combinedColumns[i].equals(" "))
               verticalCounter = 0;
            
            if (i % changeRow == 0){
               verticalCounter = 0;
               changeRow += 6;
            }
               
            if(verticalCounter == 4){
               counter = 42;
               winner = player2Letter;
            }
            
         } 
         
         if (counter == 42) //ends game
            break;
            
         for (int i = 0; i < 6; i++){ //checks for horisontal wins
         
            horisontalCounter = 0;
            for (int a = 0; a <= 36; a += 6){
                  
                  if (combinedColumns[i + a].equals("O"))
                      horisontalCounter++;
                  
                  if (combinedColumns[i + a].equals("X") || combinedColumns[i + a].equals(" "))
                     horisontalCounter = 0;
                     
                  if (horisontalCounter == 4){
                     counter = 42;
                     winner = player2Letter;
                  }
                     
            }         
         }
         
         if (counter == 42) //ends game
            break;
         
         possiblePlacements = 3;
         for (int i = 3; i < 6; i++){ //checks for diagonal wins (left to right)
         
            diagonalCounter = 0;
            for (int a = 0; a <= 5 * possiblePlacements; a+=5){  //possible placements multiplied by something equals to the number of spaces within the diagonal
               
               if (combinedColumns[i + a].equals("O"))
                  diagonalCounter++;
               
               if (combinedColumns[i + a].equals("X") || combinedColumns[i + a].equals(" "))
                  diagonalCounter = 0;
                  
               if (diagonalCounter == 4){
                  counter = 42;
                  winner = player2Letter;
               }
            
            }
            possiblePlacements++;
            
        } 
        
         if (counter == 42) //ends game
            break;
        
        possiblePlacements = 5;
        for (int i = 11; i < 24; i += 6){ //second half - checks for diagonal wins (left to right)
        
           diagonalCounter = 0;
           for (int a = 0; a <= 5 * possiblePlacements; a += 5){ //possible placements multiplied by something equals to the number of spaces within the diagonal
               
               if (combinedColumns[i + a].equals("O")) 
                  diagonalCounter++;
               
               if (combinedColumns[i + a].equals("X") || combinedColumns[i + a].equals(" "))
                  diagonalCounter = 0;
                  
               if (diagonalCounter == 4){
                     counter = 42;   
                     winner = player2Letter; 
               }
            
           } 
        
           possiblePlacements--;
        }

         if (counter == 42) //ends game
            break;

         possiblePlacements = 3; 
         for (int i = 23; i < 36; i += 6){ //first half - checks diagonals (bottom right to top left)
         
            diagonalCounter = 0;
            for (int a = 0; a <= possiblePlacements * 7; a += 7){ //possible placements multiplied by something equals to the number of spaces within the diagonal
            
               if (combinedColumns[i - a].equals("O"))
                  diagonalCounter++;
               
               if (combinedColumns[i - a].equals("X") || combinedColumns[i - a].equals(" "))
                  diagonalCounter = 0;
                  
               if (diagonalCounter == 4){
                  counter = 42;    
                  winner = player2Letter;
               }
            
            
            }
            possiblePlacements ++;
         }
         
         if (counter == 42) //ends game
            break;
         
         possiblePlacements = 3;
         for (int i = 39; i < 42; i++){ //second half of checking diagonal (right to left)
         
            diagonalCounter = 0;
            for (int a = 0; a <= possiblePlacements * 7; a += 7){ //possible placements multiplied by something equals to the number of spaces within the diagonal
            
               if (combinedColumns[i - a].equals("O"))
                  diagonalCounter++;
               
               if (combinedColumns[i - a].equals("X") || combinedColumns[i - a].equals(" "))
                  diagonalCounter = 0;
                  
               if (diagonalCounter == 4){
                  counter = 42;    
                  winner = player2Letter;
               }
            
            }
         
            possiblePlacements++;
         } 
        
        
         if (counter == 42) //ends game
            break;
            
          counter++;
         
      }
      
      //displays the winner/draw
      if (winner.equals(player1Letter) || winner.equals(player2Letter)){
         System.out.println("\n\n\n\n\n");
         System.out.println(" ____        __   ______  _    _ __   _   ______   _____");
         System.out.println(" \\ \\        / /  |_   _| | \\ | | | \\ | | |  ____| |  __ \\");
         System.out.println("  \\ \\  /\\  / /    | ||   |  \\| | |  \\| | | ||__   | ||__)|");
         System.out.println("   \\ \\/  \\/ /     | ||   | . ` | | . ` | |   __|| |  _  /");
         System.out.println("    \\  /\\  /     _| ||_  | |\\  | | |\\  | | ||____ | | \\ \\");
         System.out.println("     \\/  \\/      |_____| |_| \\_| |_| \\_| |______| |_|  \\_\\");
         System.out.println("____________________________________________________________\n");
      }
      
      if (winner.equals(player1Letter)){
         System.out.println("  _____     _                  __     __  _______  _______      __ ");
         System.out.println(" |  __  \\  | ||         /\\     \\ \\   / / |  ____|| |  __ \\    /_ |");
         System.out.println(" | |__) || | ||        /  \\     \\ \\_/ /  | ||__    | |__) ||   | |");
         System.out.println(" |  ___//  | ||       / /\\ \\     \\   /   |  __||   |  _  //    | |");
         System.out.println(" | ||      | ||___   / ____ \\    || |    | ||____  | | \\ \\     | |");
         System.out.println(" |_||      |______| /_/    \\_\\   ||_|    |______|| |_|  \\_\\    |_|");
      }

      else if (winner.equals(player2Letter)){
         System.out.println("  _____     _                  __    __  _______  _______      _____ ");
         System.out.println(" |  __ \\   | ||         /\\    \\ \\   / / |  ____|| |  __ \\     |___  \\");
         System.out.println(" | |__)||  | ||        /  \\    \\ \\_/ /  | ||__    | |__) ||      )  ||");
         System.out.println(" |  ___//  | ||       / /\\ \\    \\   /   |  __||   |  _  //      /  // ");
         System.out.println(" | ||      | ||___   / ____ \\   || |    | ||____  | | \\ \\     /  //_");
         System.out.println(" |_||      |______| /_/    \\_\\  ||_|    |______|| |_|  \\_\\   |______||");
      }
      
      if (!winner.equals(player1Letter) && !winner.equals(player2Letter)){
         System.out.println("\n\n\n\n\n");
         System.out.println("      __                          ");
         System.out.println("     | ||                          ");
         System.out.println("   __| ||  _ ___    __ __  __      ___");
         System.out.println("  / _  || |  __||  / _  || \\ \\ /\\ / //");
         System.out.println(" | (_| || | ||    | (_| ||  \\ V  V // ");
         System.out.println("  \\____|| |_||     \\____||   \\_/\\_//  ");
      }
   }  
}