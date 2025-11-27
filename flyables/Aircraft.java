package flyables;

import flyables.aircrafts.Coordinates;

public class Aircraft extends Flyable {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected Boolean flying = true;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinate;
	}

	@Override
	public Boolean isFlying() {
		return this.flying;
	}

	@Override
	public String tag() {
		return (this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")");
	}

	@Override
    public void updateConditions() {}
}