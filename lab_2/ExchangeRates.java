public interface ExchangeRates {

    default double buy(int n, double valBuy) {
        System.out.printf("Purchased: %d%n", n);
        return n * valBuy;
    }

    default double sell(int n, double valSell) {
        System.out.printf("Sold: %d%n", n);
        return n * valSell;
    }
}
