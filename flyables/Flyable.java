package flyables;

import buildings.WeatherTower;

public abstract class Flyable {
    protected WeatherTower weatherTower;

    public abstract void updateConditions();

    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
    }

    public abstract String tag();

    public abstract Boolean isFlying();
}
