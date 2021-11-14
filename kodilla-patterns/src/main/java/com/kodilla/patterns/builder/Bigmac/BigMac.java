package com.kodilla.patterns.builder.Bigmac;

import java.util.ArrayList;
import java.util.List;

public final class BigMac {
    private final String bun;
    private final int burgers;
    private final String sauce;
    private List<String> ingredients = new ArrayList<>();

    public static class BigMacBuilder{
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigMacBuilder bun(String bun){
            this.bun = bun;
            return this;
        }

        public BigMacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigMacBuilder sauce(String sauce){
            this.sauce = sauce;
            return this;
        }

        public BigMacBuilder ingredient(Ingredient ingredient){
            ingredients.add(ingredient.getIngredient());
            return this;
        }

        public BigMac build(){
            return new BigMac(bun,burgers,sauce,ingredients);
        }
    }

    private BigMac(final String bun,final int burgers,final String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    @Override
    public String toString(){
        return "BigMac{" +
                "bun= " + bun + '\n' +
                "burgers= " + burgers + '\n' +
                "sauce= " + sauce + '\n' +
                "ingredient= " + ingredients +
                "}";
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
