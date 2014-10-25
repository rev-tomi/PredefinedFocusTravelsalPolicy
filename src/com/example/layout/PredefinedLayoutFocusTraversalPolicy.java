package com.example.layout;

import java.awt.Component;
import java.util.Comparator;
import java.util.List;

import javax.swing.LayoutFocusTraversalPolicy;

/** We have to override the LayoutFocusTraversalPolicy to define another traversal policy that's just slightly different from the default. */
@SuppressWarnings("serial")
public class PredefinedLayoutFocusTraversalPolicy extends LayoutFocusTraversalPolicy {
	
	public PredefinedLayoutFocusTraversalPolicy(List<Component> topLevelOrder) {
		initComparator(topLevelOrder);
	}
	
	private void initComparator(List<Component> topLevelOrder) {
		Comparator<? super Component> layoutComparator = getComparator();
		Comparator<? super Component> modifiedComparator = new PredefinedLayoutComparator(topLevelOrder, layoutComparator);
		setComparator(modifiedComparator);
	}

}
