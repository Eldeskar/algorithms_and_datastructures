package com.eldeskar.binpackingproblem;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private double size;
    private int containerId;
    private List<ContainerItem> listOfItems;

    public Container(double size, int containerId){
        this.size = size;
        listOfItems = new ArrayList<>();
        this.containerId = containerId;
    }

    public double getSize() {
        return size;
    }

    public int getContainerId() {
        return containerId;
    }

    public boolean addItem(ContainerItem item){
        if(doesItemFit(item)){
            return listOfItems.add(item);
        }else{
            return false;
        }
    }

    public boolean removeItem(ContainerItem item){
        return listOfItems.remove(item);
    }

    public boolean doesItemFit(ContainerItem item){
        double currentSize = 0;
        for (ContainerItem currentItem : listOfItems){
            currentSize += currentItem.getSize();
        }
        currentSize += item.getSize();
        return currentSize <= size;
    }

    public List<ContainerItem> getListOfItems() {
        return listOfItems;
    }

    public boolean isEmpty(){
        return listOfItems.isEmpty();
    }
}
