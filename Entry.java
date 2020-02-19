package com.example.splitbilly;

import static com.example.splitbilly.Tax.applyTax;

public class Entry {

    private String name;
    private double quantity;
    private double price;
    private int taxType;

    public Entry(){
        this("default", 0, 0, 0);
    }

    public Entry(String name, double quantity, double price, int taxType){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.taxType = taxType;
    }

    // Getters
    public String getName(){
        return this.name;
    }

    public double getQuant(){
        return this.quantity;
    }

    public double getPrice(){
        return this.price;
    }

    public int getTaxType(){
        return this.taxType;
    }

    // setNames
    public void setName(String newName){
        this.name = newName;
    }

    public void setQuant(double newQuantity){
        this.quantity = newQuantity;
    }

    public void setPrice(double newPrice){
        this.price = newPrice;
    }

    public void setTaxType(int newTaxType) {
        this.taxType = newTaxType;
    }

    @Override
    public String toString(){
        String result = "Name: " + getName() + "\n" +
                "Quantity: " + getQuant() + "\n" +
                "Price: " + getPrice() + "\n" +
                "TaxType: " + getTaxType();
        return result;
    }

    // returns corresponding taxtype in database
    // 0 for non, 1 for GST, 2 for HST, -1 if not found
    public int retrieveTax(Entry[] database, Entry entry) {

        Boolean flag = false;
        int result = -1;
        int index = 0;

        while (flag == false && index < database.length){

            if (database[index].name.contains(entry.name)){
                result = database[index].getTaxType();
                flag = true;
            }

            index++;
        }

        return result;
    }

}

