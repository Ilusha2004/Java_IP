package com.cross_cutting.Parsers.TXTParser;

public class TxtParser {
   
    private String path;
    private String outPath;

    
    // private static List<Pair<String, Order>> orders = new ArrayList<Pair<String, Order>>();

    // public TXTParser(String path, String outPath) {
    //     this.path = path;
    //     this.outPath = outPath;
    // }

    // public TXTParser(String path) {
    //     this.path = path;
    // }

    // public void ReadFile() {
    //     try(BufferedReader buffer = new BufferedReader(new FileReader(path))){

    //         while(buffer.ready()) {
    //             Order tem = new Order();

    //             String[] temp = buffer.readLine().split(" ");
    //             String name = temp[0];

    //             temp = buffer.readLine().split(" ");
    //             String type = temp[0];

    //             if(type.equals(MenuType.BREAKFAST.toString())){
    //                 tem.setType(MenuType.BREAKFAST);                
    //             }
    //             else if(type.equals(MenuType.LUNCH.toString())){
    //                 tem.setType(MenuType.LUNCH);
    //             }
    //             else if(type.equals(MenuType.DINNER.toString())){
    //                 tem.setType(MenuType.DINNER);
    //             }

    //             temp = buffer.readLine().split(" ");
    //             String numberTable = temp[0];
    //             String amountOfTable = temp[1];

    //             tem.setTable(new Table(Integer.valueOf(numberTable),
    //                             Integer.valueOf(amountOfTable)));
            
    //             temp = buffer.readLine().split(" ");
    //             String filling = temp[0];
    //             String mainPart = temp[1];
    //             String top = temp[2];

    //             tem.setDessert(new Dessert(filling,
    //                                 mainPart,
    //                                 top));
            
    //             temp = buffer.readLine().split(" ");
    //             String tempeture = temp[0];
    //             String is_sweet = temp[1];
    //             String strenght = temp[2];
    //             String typeCoffeeBeans = temp[3];

    //             tem.setCoffee(new Coffee(Double.valueOf(tempeture),
    //                             Boolean.valueOf(is_sweet),
    //                             Integer.valueOf(strenght),
    //                             typeCoffeeBeans));
            
    //             temp = buffer.readLine().split(" ");
    //             String am = temp[0];

    //             tem.setAmoutOrders(Integer.valueOf(am));

    //             orders.add(new Pair<String,Order>(name, new Order(tem)));

    //             System.out.println(tem.toString());

    //         }

    //     } catch (Exception e) {
    //         e.getStackTrace();
    //     }
        
    // }

    // public void WriteFile() throws IOException {
    //     try(BufferedWriter buffer = new BufferedWriter(new FileWriter(outPath));) {
    //         for(Pair<String,Order> id : orders) {
    //             buffer.write(id.getFirstItem().toString() + "\n" + id.getSecondItem().toString() + "\n");
    //         }
    //     } catch(FilerException e){
    //         System.out.println("Error");
    //         e.getStackTrace();
    //     }
    // }

    // public static void main(String[] args) throws IOException {
    //     TXTParser Main = new TXTParser("src/res/order.txt", "src/res/orderout.txt");
    //     Main.ReadFile();
    //     Main.WriteFile();
    // }
}