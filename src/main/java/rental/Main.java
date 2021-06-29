package rental;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main
{
    public static List<Item> itemList;
    public  static List<Member> memberList;

    public static void main(String[] args)
    {
        startData();
        System.out.println("Witaj w bibliotece!");

        for (;;)
        {
            showMenu();

            Scanner input = new Scanner(System.in);
            System.out.print("Wybor: ");
            switch (input.nextInt())
            {
                case 1:
                    System.out.println("Dostepne zrodla:");
                    for (Item item : itemList)
                    {
                        System.out.println("ID: " + item.getId());
                        System.out.println("Tytul: " + item.getTitle());
                        System.out.println("Autor: " + item.getAuthor());
                        System.out.println("Wydawnictwo: " + item.getPublishingHouse());
                        System.out.println("Cena: " + item.getPrice());

                        if (item.getWhoRented() != -1)
                        {
                            System.out.println("Wypozyczone przez uzytkownika: " + item.getWhoRented());
                            System.out.println("Wypozyczone do: " + item.getRentDate("dd.MM.yyyy"));
                        }

                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.println(" Zarejestrowani uzytkownicy: \n");
                    for (int i = 0; i < memberList.size(); i++)
                    {
                        Member member = memberList.get(i);
                        System.out.println("ID: " + i);
                        System.out.println("Imie: " + member.getName());
                        System.out.println("Nazwisko: " + member.getSurname());
                        System.out.println("Wiek: " + member.getAge());
                        System.out.println("Status: " + member.getBlockStatus());
                        System.out.println("Historia wypozyczen: ");

                        for (int j = 0; j < member.history.size(); j++)
                        {
                            System.out.println(member.history.get(j));
                        }

                        if (member.isBlocked())
                        {
                            System.out.println("Kara: " + member.getPenalty() + "PLN");
                        }

                        System.out.println();
                    }
                    break;

                case 3:
                    input.nextLine();
                    System.out.println("Imie:");
                    String name = input.nextLine();
                    System.out.println("Nazwisko:");
                    String surname = input.nextLine();
                    System.out.println("Wiek:");
                    int age = input.nextInt();
                    memberList.add(new Member(name, surname, age));
                    System.out.println("Uzytkownik " + name + " " + surname + " dodany!");
                    break;

                case 4:
                    System.out.println("Podaj ID wypozyczanego tytulu?");
                    int itemId = input.nextInt() - 1;
                    Item item = itemList.get(itemId);
                    System.out.println("Podaj ID osoby wypozyczajacej " + item.getTitle());
                    int userId = input.nextInt();
                    input.nextLine();
                    System.out.println("Podaj date konca wypozyczenia? (dd.MM.yyyy)");
                    String returnDate = input.nextLine();
                    item.borrow(userId, returnDate);
                    memberList.get(userId).addHistory("Wypozyczono " + item.getTitle() + " do " + returnDate);
                    System.out.println("Pomyslnie wypozyczono!");
                    break;

                case 5:
                    System.out.println("Podaj ID osoby, ktora chcesz zablokowac:");
                    int id = input.nextInt();
                    input.nextLine();
                    Member member = memberList.get(id);
                    member.blockUser();
                    System.out.println("Uzytkownik " + member.getName() + " " + member.getSurname() + " zostal zablokowany!");
                    break;

                case 6:
                    System.out.println("Podaj ID do sprawdzenia kary:");
                    int itemIds = input.nextInt();
                    Item items = itemList.get(itemIds);
                    System.out.println("Kara: " + items.getPenalty() + "PLN");
                    break;

                case 7:
                    System.exit(0);
                    break;
            }

        }
    }
    public static void showMenu()
    {
        System.out.println("Co chciałbyś zrobić?");
        System.out.println("1. Pokaz pozycje");
        System.out.println("2. Pokaz uzytkownikow  ");
        System.out.println("3. Dodaj uzytkownika");
        System.out.println("4. Wypozycz tytul");
        System.out.println("5. Zablokuj uzytkownika");
        System.out.println("6. Penalty");
        System.out.println("7. Go hoooooome");
    }
     public static void startData()
     {
        itemList = new ArrayList<>();
        memberList = new ArrayList<>();
        //uzytkownicy
        memberList.add( new Member("Mateusz", "Plasun", 21));
        memberList.add( new Member("Wiktoria", "Wiaderna", 69));

        //audiobooki
         itemList.add(new Audiobook(1, "Droga Wilka z Wall Street","Jordan Belford", "Swiat Ksiazki",24.99f, 500));
         itemList.add(new Audiobook(2, "Netflix. To się nigdy nie uda","Randolph Marc", "SQN",44.99f, 670));

         //cd
         itemList.add(new CD(3, "10/29", "Paluch", "B.O.R Records", 30.99f, 18));
         itemList.add(new CD(4, "Akademia Sztuk Pieknych", "Avi, Louis Villain", "Moya Label", 44.99f, 14));

         //book
         itemList.add(new Book(5, "Stary czlowiek i morze", "Ernest Hemingway", "Literat", 6.99f,56 ));



     }
}
