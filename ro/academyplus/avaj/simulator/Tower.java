package ro.academyplus.avaj.simulator;

import java.util.ArrayList;
import java.util.List;

public class Tower {
	private List<Flyable>	observers = new ArrayList<Flyable>();

	/**
	 * This function adds a Flyable object to a list of observers.
	 * 
	 * @param p_flyable p_flyable is a parameter of type Flyable, which is an
	 * interface that defines the behavior of objects that can fly. In this context,
	 * it is likely that the register method is part of a class that manages a list of
	 * objects that can fly and adds a new Flyable object to that
	 */
	public void register(Flyable p_flyable) {
		observers.add(p_flyable);
		System.out.println("Tower says: " + p_flyable.getType() + "#" + p_flyable.getId() + "(" + p_flyable.getName() + ") registered to weather tower.");
	}
	
	/**
	 * The function removes a Flyable object from a list of observers.
	 * 
	 * @param p_flyable p_flyable is a parameter of type Flyable, which represents an
	 * object that is capable of flying. This parameter is used in a method called
	 * unregister, which removes the given Flyable object from a list of observers.
	 */
	public void unregister(Flyable p_flyable) {
		observers.remove(p_flyable);
		System.out.println(p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") landing.");
		System.out.println("Tower says: " + p_flyable.getType() + "#" + p_flyable.getId() + "(" + p_flyable.getName() + ") unregistered from weather tower.");
	}

	protected void conditionsChanged() {}

	public static Tower getTower() {
		Tower t = new Tower();
		return t;
	}

}
