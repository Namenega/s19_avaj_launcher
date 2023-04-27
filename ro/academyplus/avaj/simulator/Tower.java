package ro.academyplus.avaj.simulator;

import java.util.ArrayList;
import java.util.List;

/**
 * The Tower class manages a list of objects that can fly and updates their
 * conditions while also allowing for registration and unregistration of Flyable
 * objects.
 */
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

	/**
	 * This function updates the conditions of all observers and removes any observer
	 * with a height less than or equal to zero.
	 */
	protected void conditionsChanged() {
		for (int j = 0; j < observers.size(); j++) {
			observers.get(j).updateConditions();

			if (observers.get(j).getHeight() <= 0) {
				unregister(observers.get(j));
			}
		}
	}

	/**
	 * The function returns a new instance of the Tower class.
	 * 
	 * @return An instance of the `Tower` class is being returned.
	 */
	public static Tower getTower() {
		Tower t = new Tower();
		return t;
	}

}
