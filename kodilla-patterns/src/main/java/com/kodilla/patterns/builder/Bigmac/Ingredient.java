package com.kodilla.patterns.builder.Bigmac;

public class Ingredient {
    public static final String SALAD = "SALAD";
    public static final String ONION = "ONION";
    public static final String BECKON = "BECKON";
    public static final String CUCAMBER = "CUCAMBER";
    public static final String CHILLI = "CHILL";
    public static final String MUSHROOMS = "MUSHROOMS";
    public static final String PRAWNS = "PRAWNS";
    public static final String CHEESE = "CHEESE";
    private String ingredient;

    public Ingredient(String ingredient) {
        if (ingredient.equals(SALAD) || ingredient.equals(ONION) || ingredient.equals(BECKON) || ingredient.equals(CUCAMBER)
                || ingredient.equals(CHILLI) || ingredient.equals(MUSHROOMS) || ingredient.equals(PRAWNS) || ingredient.equals(CHEESE)) {
            this.ingredient = ingredient;
        } else {
            throw new IllegalStateException(ingredient + "--> there is no such ingredient");
        }
    }

    public String getIngredient() {
        return ingredient;
    }
}
