package org.rem.util;

import java.awt.Color;

import javax.swing.JLabel;

public class Message {
	private static long sleepTime = 4000;

	public static void timerLabel(final JLabel jLabelAnswer, final Color color, final String answer) {
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					jLabelAnswer.setText(answer);
					jLabelAnswer.setBackground(color);
					Thread.sleep(sleepTime);
					jLabelAnswer.setText("...");
					jLabelAnswer.setBackground(Color.GRAY);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
	}

}