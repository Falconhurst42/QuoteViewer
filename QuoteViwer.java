import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;

public class QuoteViewer extends JFrame implements ActionListener {
	private final static int BASEWIDTH = 600, BASEHEIGHT = 600;
	private final ArrayList<Quote> quotes;
	private JPanel quote_container = new JPanel(), buttons = new JPanel();
	private JLabel quote;
	private JButton next = new JButton("Next Quote");
	private JButton prev = new JButton("Previous Quote");
	private JProgressBar bar = new JProgressBar();

	private int index = 0;

	public QuoteViewer() {
		super("Quote Viewer");

		quotes = new ArrayList<Quote>(Arrays.asList(
			new Quote("Marilyn Monroe", "I'm selfish, impatient and a little insecure. I make mistakes, I am out of control and at times hard to handle. But if you can't handle me at my worst, then you sure as hell don't deserve me at my best."),
			new Quote("Oscar Wilde", "Be yourself; everyone else is already taken."),
			new Quote("Albert Einstein", "Two things are infinite: the universe and human stupidity; and I'm not sure about the universe."),
			new Quote("Frank Zappa", "So many books, so little time."),
			new Quote("Marcus Tullius Cicero", "A room without books is like a body without a soul."),
			new Quote("Bernard M. Baruch", "Be who you are and say what you feel, because those who mind don't matter, and those who matter don't mind."),
			new Quote("William W. Purkey", "You've gotta dance like there's nobody watching,\r\n"
					+ "Love like you'll never be hurt,\r\n"
					+ "Sing like there's nobody listening,\r\n"
					+ "And live like it's heaven on earth."),
			new Quote("Dr. Seuss", "You know you're in love when you can't fall asleep because reality is finally better than your dreams."),
			new Quote("Mae West", "You only live once, but if you do it right, once is enough."),
			new Quote("Mahatma Gandhi", "Be the change that you wish to see in the world.")
		));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLayout(new FlowLayout());
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		// quote
		quote_container.setLayout(new FlowLayout());
		quote = new JLabel(quotes.get(index).toStringHtml(BASEWIDTH));
		quote.setForeground(Color.DARK_GRAY);
		quote.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
		quote_container.add(quote);
		add(quote_container);
		
		// buttons
		buttons.setLayout(new FlowLayout());
		buttons.add(next);
		buttons.add(prev);
		add(buttons);

		// bar
		bar.setMaximum(quotes.size()-1);
		bar.setValue(index);
		add(bar);

		// listeners
		next.addActionListener(this);
		prev.addActionListener(this);

        setSize(BASEWIDTH, BASEHEIGHT);
		setVisible(true);
	}

	public static void main(String[] args) {
		QuoteViewer qv = new QuoteViewer();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// if next pushed
		if(e.getSource() == next) {
			// incirment if feasible
			if(index+1 != quotes.size()) {
				quote.setText(quotes.get(++index).toStringHtml(getWidth()));
				bar.setValue(index);
				repaint();
				return;
			}
		}
		// if prev pushed
		else if(e.getSource() == prev) {
			// incirment if feasible
			if(index != 0) {
				quote.setText(quotes.get(--index).toStringHtml(getWidth()));
				bar.setValue(index);
				repaint();
				return;
			}
		}
	}


	private class Quote {
		public final String author, quote;
		
		Quote(String a, String q) {
			author = a;
			quote = q;
		}

		@Override
		public String toString() {
			return String.format("\"%s\" - %s", quote, author);
		}

		public String toStringHtml(int width) {
			return String.format("<html><body style='width: %1spx'>\"%s\" - %s</body></html>", width*0.5, quote, author);
		}
	}
}
