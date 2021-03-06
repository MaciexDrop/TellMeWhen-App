package com.portfolio.tellmewhenapp.storageProduct.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StorageProductType {
    ALCOHOL("Alcohol"),
    BAKERY("Bakery"),
    CANNED("Canned"),
    FRUITS_AND_VEGETABLES("Fruits and vegetables"),
    DAIRY_AND_EGGS("Dairy and eggs"),
    DRINKS("Drinks"),
    FISH("Fish"),
    FROZEN("Frozen"),
    CHEMICALS("Household chemicals"),
    MEAT("Meat"),
    MEDICINE("Medicine"),
    OILS("Oils"),
    READY_MEALS("Ready meals"),
    SNACKS("Snacks"),
    PRESERVE("Preserve"),
    NOT_FOOD("Not food"),
    OTHER("Other food");


    private final String stringValue;

    @Override
    public String toString() {
        return this.stringValue;
    }
}
