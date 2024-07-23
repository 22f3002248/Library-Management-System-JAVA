import java.text.SimpleDateFormat;
import java.util.*;

class book {
    int ID;
    String name;
    String author;
    boolean rented = false;
    int renterID = -1;
    String rentername = null;

    void rententry() {
        this.rented = true;
    }

    void returnentry() {
        this.rented = false;
    }
}

class header {
    void printheader() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date currentDate = new Date();
        String formattedDate = dateFormat.format(currentDate);
        System.out.printf("\n\t\t\t\t\t   KONKAN GYANPEETH COLLEGE OF ENGINEERING, KARJAT\n");
        System.out.println();
        System.out.println(
                "*******************************************************************************************************************************************");
        System.out.printf("\t\t\t\t\tL I B R A R Y     M A N A G E M E N T     S Y S T E M\n");
        System.out.println(
                "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Current Date and Time: " + formattedDate);
        System.out.println();
        System.out.println("PROJECT BY:-");
        System.out.println("    Lad Vinayak Naresh (27)");
        System.out.println("    Raje Kaustubh Vinay (49)");
        System.out.println("    Savdekar Mayur Rajesh (55)");
        System.out.println("    Tambe Taunush Sudheer (60)");
        System.out.println(
                "*******************************************************************************************************************************************");
    }
}

class footer {
    void printfooter() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("   Thank you for using LIBRARY MANAGEMENT SYSTEM !");
        System.out.println("             ~~~ Have a nice day ~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}

class menu {
    void print() {
        System.out.println("M E N U for operations :");
        System.out.printf("1. Add new book\t\t\t2. Show all books data\n");
        System.out.printf("3. Add rented book entry\t4. Add book return entry\n");
        System.out.printf("5. Show all rented books\t6. Print MENU again\n");
        System.out.printf("7. Exit\n");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }
}

public class LibraryManagementSystem {
    public static void main(String args[]) {
        List<book> booklist = new ArrayList<book>();
        book b = new book();
        int ch = 1;

        header h = new header();

        footer f = new footer();

        Scanner sc = new Scanner(System.in);

        menu m = new menu();

        h.printheader();
        System.out.println("Welcome to LIBRARY MANAGEMENT SYSTEM !");
        m.print();

        while (ch != 0) {
            System.out.println("Enter your choice of operation : ");
            ch = sc.nextInt();
            System.out.println();

            switch (ch) {
                case 1: {
                    System.out.println("Adding new book ->");
                    System.out.println();
                    System.out.println("Enter the book ID : ");
                    b.ID = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the book name : ");
                    b.name = sc.nextLine();
                    System.out.println("Enter the name of author : ");
                    System.out.println();
                    b.author = sc.nextLine();
                    booklist.add(b);

                    System.out.println("New book added successfully !");
                    System.out.println();
                    break;
                }
                case 2: {
                    System.out.println("Printing all books ->");

                    for (book bt : booklist) {
                        System.out.println("Book ID : " + bt.ID);
                        System.out.println("Book Name : " + bt.name);
                        System.out.println("Book Author : " + bt.author);

                        if (bt.rented == false) {
                            System.out.println("Availability : Available\t");
                            System.out.println("Renter ID : ---");
                            System.out.println("Renter Name : ---");
                            System.out.println();
                        }

                        else {
                            System.out.println("Availability : Unavailable");
                            System.out.println("Renter ID : " + bt.renterID);
                            System.out.println("Renter Name : " + bt.rentername);
                            System.out.println();
                        }
                    }

                    System.out.println("All books printed !");
                    System.out.println();
                    break;
                }
                case 3: {
                    int tbid, trid;
                    String trn;
                    boolean flag = false;

                    System.out.println("Adding rent entry for book ->");
                    System.out.println();
                    System.out.println("Enter book ID : ");
                    tbid = sc.nextInt();
                    sc.nextLine();

                    for (book bt : booklist)
                        if (bt.ID == tbid)
                            if (bt.rented == true)
                                flag = true;

                    if (flag == false) {
                        System.out.println("Enter renter ID : ");
                        trid = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter renter name : ");
                        trn = sc.nextLine();

                        for (book bt : booklist) {
                            if (bt.ID == tbid) {
                                bt.rententry();
                                bt.renterID = trid;
                                bt.rentername = trn;
                            }
                        }

                        System.out.println("New entry successful!");
                    }

                    else
                        System.out.println("Book already rented !");

                    System.out.println();
                    break;
                }
                case 4: {
                    int tid;
                    System.out.println("Adding return entry for book ->");
                    System.out.println();
                    System.out.println("Enter book ID : ");
                    tid = sc.nextInt();

                    for (book bt : booklist) {
                        if (bt.ID == tid) {
                            bt.returnentry();
                            bt.renterID = -1;
                            bt.rentername = null;
                        }
                    }

                    System.out.println("Return entry successful!");
                    System.out.println();
                    break;
                }
                case 5: {
                    int c = 0;
                    System.out.println("Showing all the rented books ->");
                    System.out.println();

                    for (book bt : booklist) {
                        if (bt.rented == true) {
                            c++;
                            System.out.println("Book ID : " + bt.ID);
                            System.out.println("Book Name : " + bt.name);
                            System.out.println("Book Author : " + bt.author);
                            System.out.println("Renter ID : " + bt.renterID);
                            System.out.println("Renter Name : " + bt.rentername);
                            System.out.println();
                        }
                    }

                    if (c == 0)
                        System.out.println("No books are rented.");
                    else
                        System.out.println("All rented book printed !");

                    System.out.println();
                    break;
                }
                case 6: {
                    m.print();
                    break;
                }
                case 7: {
                    ch = 0;
                    break;
                }
            }
            b = new book();
        }
        sc.close();
        f.printfooter();
    }
}