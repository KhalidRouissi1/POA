public class Main {
    public static void main(String[] args) {
        Article article1 = new Article("book", 12.50);
        Article article2 = new Article("journal", 8.20);

        Stock stock = new Stock();
        stock.addNouvArticle(article1, 100);
        stock.addNouvArticle(article2, 30);

        Facture facture = new Facture(stock);

        facture.addLigne(10, "book");
        facture.addLigne(20, "journal");

        System.out.println("Total amount of the facture: " + facture.getMontantTotal());

        System.out.println("Stock sorted by article name:");
        stock.sortStock();
    }
}
