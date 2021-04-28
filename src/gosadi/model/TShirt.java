/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gosadi.model;

import java.util.Random;

/**
 *
 * @author alkinoos
 */
public class TShirt {

    private String name;
    private double price;
    private Color color;
    private Size size;
    private Fabric fabric;

    private static String[] names;

    static {
        System.out.println("static block names initialized");
        names = new String[]{"Aloha", "Baseball", "Camp",
            "Epaulette", "Lumberjack", "Granddad", "Golf",
            "Henley", "Polo", "Tuxedo", "Tunic", "Sweatshirt"};
    }

    public TShirt() {
        name = randomName();
        color = randomColor();
        size = randomSize();
        fabric = randomFabric();
        calcPrice();//v2
        price = computePrice();//v3
    }

    public TShirt(String name, double price, Color color, Size size, Fabric fabric) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.size = size;
        this.fabric = fabric;
    }

    public static String[] getNames() {
        return names;
    }

    public String getName() {
        return name;
    }

    public TShirt setName(String name) {
        this.name = name;
        return this;
    }

    public Size getSize() {
        return size;
    }

    public TShirt setSize(Size size) {
        this.size = size;
        return this;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public TShirt setFabric(Fabric fabric) {
        this.fabric = fabric;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public TShirt setPrice(double price) {
        this.price = price;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public TShirt setColor(Color color) {
        this.color = color;
        return this;
    }

    private String randomName() {
        Random random = new Random();
        int arrayLength = getNames().length;
        int randomNumber = random.nextInt(arrayLength);
        String randomName = names[randomNumber];
        return randomName;
    }

    private Color randomColor() {
        Random random = new Random();
        Color[] colors = Color.values();
        return colors[random.nextInt(colors.length)];
    }

    private Size randomSize() {
        Random random = new Random();
        Size[] sizes = Size.values();
        int index = random.nextInt(sizes.length);
        Size randomSize = sizes[index];
        return randomSize;
    }

    private Fabric randomFabric() {
        Random random = new Random();
        Fabric[] fabrics = Fabric.values();
        int index = random.nextInt(fabrics.length);
        Fabric randomFabric = fabrics[index];
//        price  = price + (randomFabric.ordinal()+1); //methodos gia afksisi tis timis v1
        return randomFabric;
    }

    
    //methodos gia afksisi tis timis v2 , kalesma se constructor
    private void calcPrice() {
        int colorOrdinal = this.color.ordinal() + 1;
        int sizeOrdinal = this.size.ordinal() + 1;
        int fabricOrdinal = this.fabric.ordinal() + 1;
        price = 3;
        price += colorOrdinal;
        price = price + (1.5*sizeOrdinal);
        price = price + price * (2.0/fabricOrdinal);
    }

    //methodos gia afksisi tis timis v3 kalesma se constructor
    private double computePrice(){
        double price = color.ordinal() + size.ordinal() + fabric.ordinal() + 10;
        return price;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Tshirt:")
                .append("name=").append(name).append(",")
                .append("price=").append(price).append(",")
                .append("color=").append(color).append(",")
                .append("size=").append(size).append(",")
                .append("fabric=").append(fabric).append(",");
        return builder.toString();
    }

}
