import java.util.ArrayList;

/*
 *  Annahmen:
 *  
 *  Grund für Codedopplung: Damit die Kohäsion in der Klasse Book möglichst groß ist, wurde sie in die Klassen Book und CompactDisc aufgeteilt.
 *                          Da sich beide Klassen ähneln, kommt es durch die Aufteilung zu einem hohen Anteil an dupliziertem Code.
 *                          Dies würde sich durch die Nutzung von Vererbung verhindern lassen.
 *                          
 *  Erhalt der Funktionalität: Die public-Variablen des Ausgansprojektes erlaubten es dem Nutzer Listen auf "null" zu setzen.
 *                             Da wir dies nicht als vorgesehene Funktionalität erachten, sondern als Folge des schlechten Programmierstils
 *                             und die "setter"-Methoden nicht in der Programmlogik benötigt werden, haben wir uns gegen eine Implementierung dieser entschlossen.
 *                             Dies führt außerdem zu einer erhöhten Sicherheit für die Anwendungslogik (Siehe Nullpointer-Exceptions in Libraray1).
 */
/**
 * The class Book represents a book including its attributes.
 * 
 * @author Finnegan Haack, Aman Mata, Ole Reichhelm
 * @version 20.09.2018
 */
public class Book {
    private String title;
    private final String author;
    private String category;
    private final ArrayList<String> pageContent;
    private final ArrayList<String> keywordList = new ArrayList<>();

    public Book(String title, String author) {
        this.title = title;
        this.author = author; 
        this.category = "Roman";
        this.pageContent = new ArrayList<>();
    }

    public String getTitle() {
        return title; 
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category; 
    }
    
    public void setCategory(String category) {
        this.category = category; 
    }
    
    public ArrayList<String> getPageContent() {
        return pageContent; 
    }
    
    public ArrayList<String> getKeywordList() {
        return keywordList; 
    }
    
    public void addPage(String textOfPage) {
        pageContent.add (textOfPage);
    }
    
    public void addToKeywordList(String keyword) {
        keywordList.add(keyword);
    }
    
    public void removeFromKeywordList(String keyword) {
        keywordList.remove(keyword);
    }
    
    public boolean hasCategory(String category) {
        return this.category.equals(category);
    }

    public boolean contains(String text) {
        return pageContent.contains(text); 
    }
    
    public void printBook() {
        System.out.print(title + " # " + category + " written by " + author + ". Keywords: ");
        printArrayList(keywordList);
        System.out.println();
    }
    
    private void printArrayList(ArrayList<String> arrayList) {
        for(int i = 0; i < (arrayList.size() - 1); i++){
            System.out.print(arrayList.get(i) + ", ");
        }
        if(!arrayList.isEmpty()){
            System.out.print(arrayList.get(arrayList.size() - 1));
        }
    }
}