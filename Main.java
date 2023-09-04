import java.util.*;

class CarServiceStation {
    private Map<String, Map<String, Integer>> servicePrices;

    public CarServiceStation() {
        servicePrices = new HashMap<>();

        Map<String, Integer> hatchbackPrices = new HashMap<>();
        hatchbackPrices.put("BS01", 2000);
        hatchbackPrices.put("EF01", 5000);
        hatchbackPrices.put("CF01", 2000);
        hatchbackPrices.put("BF01", 1000);
        hatchbackPrices.put("GF01", 3000);
        servicePrices.put("Hatchback", hatchbackPrices);

        Map<String, Integer> sedanPrices = new HashMap<>();
        sedanPrices.put("BS01", 4000);
        sedanPrices.put("EF01", 8000);
        sedanPrices.put("CF01", 4000);
        sedanPrices.put("BF01", 1500);
        sedanPrices.put("GF01", 6000);
        servicePrices.put("Sedan", sedanPrices);

        Map<String, Integer> suvPrices = new HashMap<>();
        suvPrices.put("BS01", 5000);
        suvPrices.put("EF01", 10000);
        suvPrices.put("CF01", 6000);
        suvPrices.put("BF01", 2500);
        suvPrices.put("GF01", 8000);
        servicePrices.put("SUV", suvPrices);
    }

    public void generateBill(String carType, List<String> serviceCodes) {
        int totalBill = 0;

        System.out.println("Type of Car: " + carType);
        System.out.println("Service Codes: " + serviceCodes);

        if (servicePrices.containsKey(carType)) {
            Map<String, Integer> prices = servicePrices.get(carType);
            for (String code : serviceCodes) {
                if (prices.containsKey(code)) {
                    int servicePrice = prices.get(code);
                    totalBill += servicePrice;
                    System.out.println("Charges for " + code + " - ₹" + servicePrice);
                }
            }
        }

        System.out.println("Total Bill - ₹" + totalBill);

        if (totalBill > 10000) {
            System.out.println("Complimentary cleaning included.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        CarServiceStation station = new CarServiceStation();
        station.generateBill("Hatchback", List.of("BS01", "EF01"));
    }
}