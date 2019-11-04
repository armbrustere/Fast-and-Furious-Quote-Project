import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

/**
 * The theQuote Class creates a window with a button to allow the user to be
 * presented a quote as well as remove the quote. Author: Ethan Armbruster
 * Version: 1.1
 */

public class theQuote extends JFrame {
	private JFrame frame;
	private JPanel textPanel;
	private JTextArea promptText;
	private JTextArea quote;
	private JScrollPane quotePane;
	private JButton button;
	private JButton button2;
	private JPanel buttonPanel;
	private ArrayList quotes;
	private JButton button3;

	public static void main(String[] args) {
		new theQuote();

	}

	/**
	 * Constructor
	 */
	public theQuote() {

		super("Quotes from the Fast and the Furious");
		makeFrame();
		quotes = new ArrayList<String>();
		createQuotes();

	}

	@SuppressWarnings({ "unchecked", "unused" })
	private void createQuotes() {

		quotes.add(0, "\'I live my life a quarter mile at a time.'" + " - Dom Toretto");
		quotes.add(1, "\'Hey, we do what we do best. We improvise, all right?' " + " - Brian O' Connor");
		quotes.add(2, "\'Life’s simple. You make choices and you don’t look back.'" + " - Han Lue");
		quotes.add(3,
				"\'Money will come and go. We all know that. The most important thing in life will always be the people in this room. Right here, right now.'"
						+ " - Dom Toretto");
		quotes.add(4, "\'I'll have the tuna. No crust.'" + " - Brian O'Conner");
		quotes.add(5, "\'I don’t have friends, I got family.'" + " - Dom Torretto");
		quotes.add(6, "\'Ask any racer. Any real racer. It don’t matter if you win by an inch or a mile. Winning’s winning.'" + " - Dom Torretto");
	}

	/**
	 * Creates the frame for the "The Quote" class.
	 */
	private void makeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame = new JFrame("Quotes from the Fast and the Furious");
		Container contentPane = frame.getContentPane();
		frame.getContentPane().setPreferredSize(new Dimension(1050, 75));
		makeTextPanel();
		makeQuoteButton();
		frame.add(textPanel, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Creates the Text Panel and adds the promptText to be displayed.
	 */
	private void makeTextPanel() {
		textPanel = new JPanel();
		promptText = new JTextArea();
		promptText.setEditable(false);
		promptText.append(
				"                    Press the Button to relive the moments of the franchise that started it all!");
		Font font = new Font("Arial", Font.BOLD, 20);
		promptText.setFont(font);
		promptText.setPreferredSize(new Dimension(1000, 25));
		textPanel.add(promptText);

	}

	/**
	 * Creates the ScrollPane for the Quote and adds it to the text Panel to be
	 * displayed.
	 */
	private void makeScrollPane() {
		textPanel.remove(promptText);
		quote = new JTextArea();
		quotePane = new JScrollPane(quote);
		quotePane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		quote.setLineWrap(true);
		quote.setWrapStyleWord(true);
		quote.setEditable(false);
		textPanel.add(quotePane, BorderLayout.CENTER);
	}

	/**
	 * Creates the button that allows the user to show the embedded quote as well as
	 * add a action listener to the button.
	 */
	private void makeQuoteButton() {
		buttonPanel = new JPanel();
		button = new JButton("Show Quote!");
		button.addActionListener(new ButtonListener());
		buttonPanel.add(button);
	}

	/**
	 * Class that includes the instructions for when the button is pressed by the
	 * user.
	 */
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			makeScrollPane();
			quote.setText("");
			quote.append((String) quotes.get(0));
			Font font = new Font("Arial", Font.BOLD, 20);
			quote.setFont(font);
			quote.setForeground(Color.BLACK);
			quotePane.setPreferredSize(new Dimension(275, 175));
			frame.setPreferredSize(new Dimension(400, 300));
			frame.pack();
			makeClearButton();
			makeNextButton();
		}
	}

	/**
	 * Creates a button after the quote is displayed and gives the user an option to
	 * clear the quote from the scroll pane.
	 */
	private void makeClearButton() {

		button2 = new JButton("Clear Quote");
		button2.addActionListener(new ButtonListener2());
		buttonPanel.remove(button);
		buttonPanel.add(button2);
	}

	/**
	 * Creates the class for the clear quote button as well as the code to clear the
	 * scroll pane.
	 */
	private class ButtonListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			quote.setText("");

		}
	}

	/**
	 * Creates a button after the quote is displayed and gives the user an option to
	 * clear the quote from the scroll pane.
	 */
	private void makeNextButton() {

		button3 = new JButton("Next Quote");
		button3.addActionListener(new ButtonListener3());
		buttonPanel.add(button3);
	}

	/**
	 * Creates the class for the clear quote button as well as the code to clear the
	 * scroll pane.
	 */
	private class ButtonListener3 implements ActionListener {

		private Random randint;

		public void actionPerformed2(ArrayList<String> quotes) {
			Collections.shuffle(quotes);
			for (String q : quotes) {
				quote.setText("");
				quote.append(q);
				Font font = new Font("Arial", Font.BOLD, 20);
				quote.setFont(font);
			}

		}

		public void actionPerformed(ActionEvent e) {

			actionPerformed2(quotes);
		}
	}

}
