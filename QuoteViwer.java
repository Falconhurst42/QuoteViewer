package QuoteViewer;

import java.util.ArrayList;

public class QuoteViewer {
	private final static Quote[] quotes = {
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
	};
	


	private class Quote {
		private final String author, quote;
		
		Quote(String a, String q) {
			author = a;
			quote = q;
		}
	}
}
