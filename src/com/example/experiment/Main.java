package com.example.experiment;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FocusTraversalPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.example.layout.PredefinedLayoutFocusTraversalPolicy;

public class Main {

	private static final String PREDEFINED_LAYOUT = "predefined.layout";

	public static void main(String... args) {
		Main main = new Main();
		main.startApplication();
	}

	private void startApplication() {
		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel top = new JPanel(new BorderLayout());
		frame.getContentPane().add(top, BorderLayout.CENTER);
		
		JPanel north = new JPanel();
		top.add(north, BorderLayout.NORTH);
		north.add(new JButton("4"));
		north.add(new JButton("5"));
		north.add(new JButton("6"));
		
		JPanel center = new JPanel();
		top.add(center, BorderLayout.CENTER);
		center.add(new JButton("1"));
		center.add(new JButton("2"));
		center.add(new JButton("3"));
		
		JPanel south = new JPanel();
		top.add(south, BorderLayout.SOUTH);
		south.add(new JButton("7"));
		south.add(new JButton("8"));
		south.add(new JButton("9"));
		
		frame.setTitle("Focus experiment");
		
		if (Boolean.getBoolean(PREDEFINED_LAYOUT)) {
			top.setFocusCycleRoot(true);
			List<Component> topLevelOrder = new ArrayList<Component>(Arrays.asList(center, north, south));
			FocusTraversalPolicy policy = new PredefinedLayoutFocusTraversalPolicy(topLevelOrder);
			top.setFocusTraversalPolicy(policy);
		}
		
		SwingUtilities.invokeLater(() -> {
			frame.pack();
			frame.setVisible(true);
		});
	}
}
