package com.example.experiment;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String... args) {
		Main main = new Main();
		main.startApplication();
	}

	private void startApplication() {
		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel north = new JPanel();
		frame.getContentPane().add(north, BorderLayout.NORTH);
		north.add(new JButton("4"));
		north.add(new JButton("5"));
		north.add(new JButton("6"));
		
		JPanel center = new JPanel();
		frame.getContentPane().add(center, BorderLayout.CENTER);
		center.add(new JButton("1"));
		center.add(new JButton("2"));
		center.add(new JButton("3"));
		
		JPanel south = new JPanel();
		frame.getContentPane().add(south, BorderLayout.SOUTH);
		south.add(new JButton("7"));
		south.add(new JButton("8"));
		south.add(new JButton("9"));
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override public void run() {
				frame.pack();
				frame.setVisible(true);
			}
			
		});
	}
}
