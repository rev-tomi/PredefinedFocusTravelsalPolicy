package com.example.layout;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** This comparator lets you override the default layout-focus order on a certain container. */
public class PredefinedLayoutComparator implements Comparator<Component> {
	
	private final List<Component> topLevelOrder;
	private final Comparator<? super Component> layoutComparator;

	public PredefinedLayoutComparator(List<Component> topLevelOrder, Comparator<? super Component> layoutComparator) {
		this.topLevelOrder = Collections.unmodifiableList(new ArrayList<Component>(topLevelOrder));
		this.layoutComparator = layoutComparator;
	}

	@Override
	public int compare(Component comp1, Component comp2) {
		int index1 = getParentComponentIndex(comp1);
		int index2 = getParentComponentIndex(comp2);
		return index1 == index2 ? // same index means either not applicable or belong to the same subtree
				layoutComparator.compare(comp1, comp2) : // same index => fall back to the default order
					new Integer(index1).compareTo(index2); // different index => the predefined order takes precedence
	}

	/**
	 * This method tells you the index on that certain level.
	 * E.g. is this the 3rd element of that container?
	 * Returns -1 if that order is not applicable.
	 */
	private int getParentComponentIndex(Component c) {
		Component component = c;
		while (component != null && ! topLevelOrder.contains(component)) {
			Container p = component.getParent();
			component = p instanceof Component ? (Component) p : null;
		}
		return component == null ? -1 : topLevelOrder.indexOf(component);
	}
	
}