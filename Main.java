/*
 1. Создать массив котов. Пусть все коты из массива по очереди едят из одной тарелки.
В конце каждого цикла мы досыпаем в тарелку еду.
Для досыпания еды сделать метод increaseFood в классе Plate.
 2. Поменять поле satiety у кота с boolean на int.
Допустим у кота апптит 10, сытность 3. Значит кот захочет поесть 7 единиц.
 3. * Доработать поток thread в классе Cat, чтобы он каждую секунду уменьшал сытость кота на 1.
*/
package HW_6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Кот (имя, аппетит, сытность)
        // Тарелка (содержит какое-то количество еды)
        // Кот ест из тарлеки. Если в тарелке недостаточно еды - кот ее не трогает.

        int fill;
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        Plate plate = new Plate(250);

        Cat[] allCats = new Cat[5];
        allCats[0] = new Cat("Пушок", 10);
        allCats[1] = new Cat("Барсик", 15);
        allCats[2] = new Cat("Рыжик", 17);
        allCats[3] = new Cat("Том", 20);
        allCats[4] = new Cat("Леопольд", 30);
        
        while (flag == true){
            for (int i = 0; i < allCats.length; i++) {
                if (allCats[i].appetite < plate.food) {
                    allCats[i].eat(plate);
                     
                    System.out.println("Котик " + allCats[i].name + " поел!" + " {апетит = " + allCats[i].appetite + ", сытость = " + allCats[i].satiety + "}");
                    System.out.println("Остаток в мискне: " + plate.food);
                    Thread.sleep(1000);

                } else {                
                    System.out.println("Котику " + allCats[i].name + " не хватило!");
                    flag = false; 

                    System.out.println("Сколько корма добавить в миску?");
                    fill = sc.nextInt();
                    plate.increaseFood(fill);
                    System.out.println("Корма в миске: " + plate.food);        
                }
            }
        }
        sc.close(); 
    }
}
