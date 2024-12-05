package main.java.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryV2 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Преступление и наказание", "Федор Достоевский", 1866));
        books.add(new Book("Евгений Онегин", "Александр Пушкин", 1833));
        books.add(new Book("Война и мир", "Лев Толстой", 1869));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));

        //Поиск книг, написанных автором
//        List<Book> authorBooks = new ArrayList<>();
//        for(Book book : books){
//            if("Лев Толстой".equals(book.getAuthor())){
//                authorBooks.add(book);
//            }
//        }
//        System.out.println("Лев Толстой: " + authorBooks);
        List<Book> authorBooks = books.stream()
                .filter(book -> "Лев Толстой".equals(book.getAuthor())).toList();
        System.out.println("Лев Толстой: " + authorBooks);

        //Поиск книг, изданных после 1866
//        List<Book> booksAfterYear = new ArrayList<>();
//        for(Book book : books){
//            if(book.getYear() > 1866){
//                authorBooks.add(book);
//            }
//        }

        List<Book> booksAfterYear = books.stream().filter(book -> book.getYear() > 1866).toList();
        System.out.println("Книги после 1866: " + booksAfterYear);

        //Поиск уникальных наименований книг
//        List<String> uniqueTitle = new ArrayList<>();
//        for(Book book: books){
//            if(!uniqueTitle.contains(book.getTitle())){
//                uniqueTitle.add(book.getTitle());
//            }
//        }

        List<String> uniqueTitle = books.stream()
                        .map(Book::getTitle).distinct().toList();

        System.out.println("Уникальные заглавия книг: " + uniqueTitle);
    }
}
