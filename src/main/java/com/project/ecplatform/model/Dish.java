package com.project.ecplatform.model;

public class Dish {

    public String description;
    private boolean delivered = false;

    public Dish (String description){
        this.description = description;
    }

    public static Dish deliver(Dish dish){
        Dish deliveredDish = new Dish(dish.description);
        deliveredDish.delivered = true;
        return deliveredDish;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    @Override
    public String toString() {

        return "Dish{" + //
                "description='" + description + '\'' + // ", delivered=" + delivered + //
                '}';
    }
}
