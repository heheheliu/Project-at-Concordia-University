import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test4 {

    static class Book {
        private String author;
        private String gender;
        private int age;

        public Book(String author, String gender, int age) {
            super();
            this.author = author;
            this.gender = gender;
            this.age = age;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Book [author=" + author + ", gender=" + gender + ", age=" + age + "]";
        }


    }

    //Question 1 : Get the unique authors of the first limitNumbOfAuthors=3 book authors that are 50 years old or older
    public static String authorsQuestion1(int limitNumbOfAuthors, List<Book> books) {
        // we write the code here
        int count = limitNumbOfAuthors;
        String ans = "";
        for (int i = 0; i < books.size() && count > 0; i++) {
            if (books.get(i).getAge() >= 50) {
                ans = ans + books.get(i).toString() + "\n";
                count--;
            }
        }
        return ans;
    }

    //Question 2 : Print out the sum of ages of all female authors younger than n=25 means age < 25
    public static int sumAgesQuestion2(int limitAge, List<Book> books) {
        int sum = 0;
        for (Book b : books) {
            if (b.getGender() == "female" && b.getAge() < limitAge) {
                sum += b.getAge();
            }
        }
        return sum;
    }

    // Question 3 : sort the list of books by age and print it out
    public static String printSortedBooks(List<Book> books) {
        String str = "";
//        Map<Integer,Book> map = new TreeMap<>();
//        for(Book b : books){
//            map.put(b.getAge(), b);
//        }
//        for(Book b : map.values()){
//            str += b.toString() + "\n";
//        }
//        return str;

        Collections.sort(books, new Comparator<Book>() {

            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        return books.toString();

    }


    public static void main(String[] args) {

        int limitNumbOfAuthors = 4;
        int limitAge = 25;
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Ahmed", "male", 42));
        books.add(new Book("Fatima", "female", 20));
        books.add(new Book("Karim", "male", 52));
        books.add(new Book("Karim", "male", 52));
        books.add(new Book("Sacha", "female", 22));
        books.add(new Book("Aziz", "male", 55));
        books.add(new Book("Maha", "female", 60));
        books.add(new Book("Jack", "male", 70));
        books.add(new Book("Soso", "female", 26));

        System.out.println("Question 1 = " + authorsQuestion1(limitNumbOfAuthors, books));
        System.out.println("Question 2 = " + sumAgesQuestion2(limitAge, books));
        System.out.println("Question 3 = " + printSortedBooks(books));
    }

}
