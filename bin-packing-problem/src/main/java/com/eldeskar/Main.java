package com.eldeskar;

import com.eldeskar.binpackingproblem.Container;
import com.eldeskar.binpackingproblem.ContainerItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static List<Container> containerList;
    private static List<ContainerItem> containerItemList;




    public static void main(String[] args) {
        containerList = new ArrayList<Container>();
        containerItemList = new ArrayList<ContainerItem>();

        int numberOfItems = (int) (Math.random()*20.0) + 1;
        int numberOfContainers = numberOfItems;



        for (int i = 0; i < numberOfItems; i++){
            Container container = new Container(Math.random()*10.0,i+1);
            containerList.add(container);
            ContainerItem item = new ContainerItem(Math.random()*8.0, i+1);
            containerItemList.add(item);
        }

        int firstRun = printSolution(numberOfItems);

        for (ContainerItem item : containerItemList){
            for (Container container : containerList){
                container.removeItem(item);
            }
        }

        System.out.printf("--------------------------------------------------\n\n");

        Collections.sort(containerList, new Comparator<Container>() {
            @Override
            public int compare(Container o1, Container o2) {
                if (o1.getSize() < o2.getSize()) {
                    return 1;
                } else if (o1.getSize() == o2.getSize()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        Collections.sort(containerItemList, new Comparator<ContainerItem>() {
            @Override
            public int compare(ContainerItem o1, ContainerItem o2) {
                if (o1.getSize() < o2.getSize()) {
                    return 1;
                } else if (o1.getSize() == o2.getSize()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        int secondRun = printSolution(numberOfItems);

        System.out.printf("First Run:\t %d\n", firstRun);
        System.out.printf("Second Run:\t %d\n", secondRun);
    }

    private static int printSolution(int numberOfItems) {
        int index = 0;
        if(depthSearch(0, numberOfItems)){
            for(Container container : containerList){
                if(container.isEmpty()){
                    continue;
                }
                System.out.printf("Container Nr. %d with size %f:\n", container.getContainerId(), container.getSize());
                for(ContainerItem item : container.getListOfItems()){
                    System.out.printf("Item Nr. %d with size %f\n", item.getItemId(), item.getSize());
                }
                index++;
            }
            System.out.println("\n");
            System.out.printf("The number of bins used is: %d", index);
            System.out.println("\n");
            System.out.println("\n");
        }
        return index;
    }


    private static boolean depthSearch(int i, int n){
        if (i >= n){
            return true;
        }else {
            ContainerItem item = containerItemList.get(i);
            for (int index = 0; index < n; index++){
                Container container = containerList.get(index);
                if(container.doesItemFit(item)){
                    container.addItem(item);
                    boolean hasSolution = depthSearch(i+1, n);
                    if(hasSolution){
                        return true;
                    }
                    container.removeItem(item);
                }
            }
            return false;
        }
    }





}

