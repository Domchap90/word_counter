package com.wordcount;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

public class Scraper {

	public static void main(String[] args) {
		try {
			Document doc =
			Jsoup.connect("https://www.bbc.co.uk/news").userAgent("Mozilla/5.0 ").get();
			// Elements temp = doc.select(
			// "a.gs-c-promo-heading.gs-o-faux-block-link__overlay-link.gel-pica-bold.nw-o-link-split__anchor");
			// "div.nw-o-link-split__anchor.gel-paragon-bold.gs-o-faux-block-link__overlay-link.gs-c-promo-heading");
			// Document doc2 = Jsoup.parse("https://www.bbc.co.uk/news");
			String htmlString = doc.text();
			System.out.println(br2nl(htmlString));

			// System.out.println(toCount);
			// "a.gs-c-promo-heading.gs-o-faux-block-link__overlay-link.gel-pica-bold.nw-o-link-split__anchor"
			// div

			// "div.gs-c-promo-body"); works but repeats headlines


			/*
			 * for (Element newsHeader : temp) { System.out.println(" " +
			 * newsHeader.getElementsByTag("h3").text()); }
			 */

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String br2nl(String html) {
		if (html == null) {
			return html;
		}
		Document document = Jsoup.parse(html);
		document.outputSettings(new Document.OutputSettings().prettyPrint(false));// makes html() preserve linebreaks
																					// and spacing
		document.select("br").append("\\n");
		document.select("p").prepend("\\n\\n");
		String s = document.html().replaceAll("\\\\n", "\n");
		return Jsoup.clean(s, "", Whitelist.none(), new Document.OutputSettings().prettyPrint(false));
	}

}
