package com.eldeskar.binpackingproblem;

public class ContainerItem {
    private double size;
    private int itemId;

    public ContainerItem(double size, int itemId){
        this.size = size;
        this.itemId = itemId;
    }

    public double getSize(){
        return size;
    }

    public int getItemId() {
        return itemId;
    }
}
