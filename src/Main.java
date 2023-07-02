import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.util.Arrays;
//import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String[] products = {"Молоко", "Хлеб", "Греча"};
    static int [] prices = {78, 50, 64};

    static File saveFile = new File("basket.txt");

    public static void  main(String[] args) throws FileNotFoundException {

        Basket basket = null;
        if (saveFile.exists()) {
            basket = Basket.loadFromTxtFile(saveFile);}
        else {
            basket = new Basket(products, prices);
        }

        while (true){
            showPrice();
            System.out.println("Выберите товар и его количество через пробел или закончите командой 'end' ");
            String input = scanner.nextLine();
            if ("end".equals(input)){
                break;
            }

            String[] parts = input.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1;
            int productCount = Integer.parseInt(parts[1]);
            basket.addToCart(productNumber, productCount);
            basket.saveTxt(saveFile);
        }

        basket.printCart();
    }

    public static void showPrice(){
        System.out.println("Список возможных товаров к покупке");
        for (int i = 0; i < products.length; i++){
            System.out.println(products[i] + " " + prices[i] + "руб/шт");
        }
    }
}