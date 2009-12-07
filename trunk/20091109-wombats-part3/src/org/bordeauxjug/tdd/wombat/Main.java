package org.bordeauxjug.tdd.wombat;

import greenfoot.export.GreenfootScenarioViewer;

import java.awt.EventQueue;

import javax.swing.JFrame;


public class Main
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		System.setProperty("apple.laf.useScreenMenuBar", "true");
		if (args.length != 3 && args.length != 0)
		{
			System.err.println("Wrong number of arguments");
		}


		// GreenfootScenarioViewer.args = "";
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new JFrame("");
				new GreenfootScenarioViewer(frame);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("");
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

}
