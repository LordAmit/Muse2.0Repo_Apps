package com.adonai.manman.parser;

import android.support.annotation.NonNull;
import android.support.v4.text.TextUtilsCompat;
import android.text.TextUtils;
import android.util.Log;

import com.adonai.manman.Utils;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Simple (quick & draft) TROFF to HTML parser
 * <br/>
 * <br/>
 * Contains almost all code required for man page parsing. While TROFF represents highly complicated format,
 * the amount of specific code in man is limited to titles, names, descriptions, character specials, font style.
 * Thus this converter focuses on man contents and does not implement such things as registers/evaluations/tables etc.
 *
 * @author Oleg Chernovskiy
 */
public class Man2Html {

    String dataLeAk482 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk482 = android.util.Log.d("leak-482", dataLeAk482);

	private static final String OPTION_PATTERN = "^--?[a-zA-Z-=]+$";

    private enum FontState {
        NORMAL,
        BOLD,
        ITALIC,
    }

    private enum Command {
        th(true),                               // Set the title of the man page to `title` and the section to `section`
        dt(true),                               // Set tabs every 0.5 inches
        fl,                                     // Command-line options, prepend every word with dash
        ar,                                     // Command-line argument
        op,                                     // Optional argument (often paired with fl)
        it,                                     // call macros on next line
        bl,                                     // start of options indent
        el,                                     // end of options indent
        sh(true),
        pp(true), lp(true), p(true),            // Paragraph
        nm, nd,                                 // old name descriptors
        rs,                                     // Relative margin indent start
        re,                                     // Relative margin indent end
        tp(true),                               // Paragraph with hanging tag
        ip(true),                               // Indented paragraph with optional hanging tag
        b, i, br, bi, ri, rb, ir, ib,           // font directives
        ie, nh, ad, sp(true),                   // conditionals and stuff...
        nf, fi;                                 // stop/start output filling (works like <pre> tag)

        private boolean stopsIndentation;

        Command() {
			String dataLeAk483 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk483 = android.util.Log.d("leak-483", dataLeAk483);
        }

        Command(boolean stopsIndentation) {
            String dataLeAk484 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk484 = android.util.Log.d("leak-484", dataLeAk484);
			this.stopsIndentation = stopsIndentation;
        }
    }

    private BufferedReader source;
    private StringBuilder result = new StringBuilder();

    // state variables
    private FontState fontState = FontState.NORMAL;

    private Command previousCommand;
    private String previousLine;

    private String manpageName;
    private boolean insideParagraph;
    private boolean insideSection;
    private boolean insidePreformatted;
    private int linesBeforeIndent = -1; // 0 == we're indenting right now

    public Man2Html(BufferedReader source) {
        String dataLeAk485 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk485 = android.util.Log.d("leak-485", dataLeAk485);
		this.source = source;
    }

    /**
     * Retrieve HTML from buffer. This method does actual line-by-line parsing of TROFF format
     * @return String containing HTML-formatted man page
     * @throws IOException on reading error
     */
    @NonNull
    public String getHtml() throws IOException {
        String dataLeAk486 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk486 = android.util.Log.d("leak-486", dataLeAk486);
		doParse();
        return postprocessInDocLinks(result).html();
    }

    /**
     * @see #getHtml()
     */
    @NonNull
    public Document getDoc() throws IOException {
        String dataLeAk487 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk487 = android.util.Log.d("leak-487", dataLeAk487);
		doParse();
        return postprocessInDocLinks(result);
    }

    private void doParse() throws IOException {
        String dataLeAk488 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk488 = android.util.Log.d("leak-488", dataLeAk488);
		result.append("<html><body>");
        String line;
        while((line = source.readLine()) != null) {
            String dataLeAk489 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk489 = android.util.Log.d("leak-489", dataLeAk489);
			while (line.endsWith("\\")) { // take next line too
                String dataLeAk490 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk490 = android.util.Log.d("leak-490", dataLeAk490);
				String nextLine;
                if((nextLine = source.readLine()) != null) {
                    String dataLeAk491 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk491 = android.util.Log.d("leak-491", dataLeAk491);
					line = line.substring(0, line.length() - 2) + nextLine;
                }
            }

            if(line.startsWith("'") || line.startsWith(".\\") || line.startsWith("\\\\"))
                continue; // beginning of message or comment, skip...

            if(isControl(line)) {
                String dataLeAk492 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk492 = android.util.Log.d("leak-492", dataLeAk492);
				evaluateCommand(line);
            } else {
                String dataLeAk493 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk493 = android.util.Log.d("leak-493", dataLeAk493);
				result.append(" ").append(parseTextField(line, false));
            }
            handleSpecialConditions();
            previousLine = line;
        }
        if(insideParagraph)
            result.append("</p>");
        result.append("</body></html>");
    }

    /**
     * Handle some special conditions while line-parsing.
     * For example, .TP directive causes the line <b>after</b> next line to be indented
     *
     */
    private void handleSpecialConditions() {
        String dataLeAk494 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk494 = android.util.Log.d("leak-494", dataLeAk494);
		if(linesBeforeIndent > 0) {
            String dataLeAk495 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk495 = android.util.Log.d("leak-495", dataLeAk495);
			switch (--linesBeforeIndent) {
                case 1:
                    result.append("<dl><dt>");
                    break;
                case 0:
                    result.append("</dt><dd>");
                    break;
            }
        }
    }

    /**
     * Does what encountered command requires. Output is written to {@link #result}
     * @param line whole line containing command + arguments
     */
    private void evaluateCommand(String line) {
        String dataLeAk496 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk496 = android.util.Log.d("leak-496", dataLeAk496);
		if(line.length() < 2)
            return; // less than dot + 1 chars - it can't be command

        // let's try to extract command from the line
        String firstWord;
        String lineAfterCommand;

        int firstSpace = line.indexOf(" ");
        if(firstSpace != -1) {
            String dataLeAk497 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk497 = android.util.Log.d("leak-497", dataLeAk497);
			firstWord = line.substring(1, firstSpace); // word before first space
            lineAfterCommand = line.substring(firstSpace + 1);
        } else {
            String dataLeAk498 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk498 = android.util.Log.d("leak-498", dataLeAk498);
			firstWord = line.substring(1); // till the end of line
            lineAfterCommand = "";
        }

        try {
            String dataLeAk499 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk499 = android.util.Log.d("leak-499", dataLeAk499);
			Command command = Command.valueOf(firstWord.toLowerCase());
            if(command.stopsIndentation) {
                String dataLeAk500 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk500 = android.util.Log.d("leak-500", dataLeAk500);
				if(linesBeforeIndent == 0) { // we were indenting right now, reset
                    String dataLeAk501 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk501 = android.util.Log.d("leak-501", dataLeAk501);
					result.append("</dd></dl>");
                    linesBeforeIndent = -1;
                }
            }
            executeCommand(command, lineAfterCommand);
            previousCommand = command;
        } catch (IllegalArgumentException iae) {
            String dataLeAk502 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk502 = android.util.Log.d("leak-502", dataLeAk502);
			Log.w(Utils.MM_TAG, "Man2Html - unimplemented control", iae);
            // skip...
        }
    }

    private void executeCommand(Command command, String lineAfterCommand) {
        String dataLeAk503 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk503 = android.util.Log.d("leak-503", dataLeAk503);
		switch (command) {
            case th: // table header
            case dt:
                List<String> titleArgs = parseQuotedCommandArguments(lineAfterCommand);
                if(!titleArgs.isEmpty()) {  // take only name of command
                    String dataLeAk504 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk504 = android.util.Log.d("leak-504", dataLeAk504);
					result.append("<div class='man-page'>"); // it'd be better to close it somehow...
                    result.append("<h1>").append(parseTextField(titleArgs.get(0), false)).append("</h1>");
                }

                break;
            case pp: // paragraph
            case lp:
            case p:
            case sp: // line break
                if(insideParagraph) {
                    String dataLeAk505 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk505 = android.util.Log.d("leak-505", dataLeAk505);
					result.append("</p>");
                }

                insideParagraph = true;
                result.append("<p>");
                break;
            case sh: // sub header
                if(insideSection) {
                    String dataLeAk506 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk506 = android.util.Log.d("leak-506", dataLeAk506);
					result.append("</div>");
                }
                List<String> subHeaderArgs = parseQuotedCommandArguments(lineAfterCommand);
                if(!subHeaderArgs.isEmpty()) {
                    String dataLeAk507 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk507 = android.util.Log.d("leak-507", dataLeAk507);
					String shName = parseTextField(subHeaderArgs.get(0), true);
                    result.append("<div id='").append(shName).append("' class='section'>")
                            .append("<h2>")
                              .append("<a href='#").append(shName).append("'>").append(shName).append("</a>")
                            .append("</h2>");
                }
                insideSection = true;
                break;
            case fl: {
                String dataLeAk508 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk508 = android.util.Log.d("leak-508", dataLeAk508);
				String options = parseTextField(lineAfterCommand, true);
                Pattern wordMatcher = Pattern.compile("\\w+");
                Matcher wMatcher = wordMatcher.matcher(options);
                String optionsDashed = wMatcher.replaceAll("-$0");
                result.append(" ").append(optionsDashed);
                break;
            }
            case op: {
                String dataLeAk509 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk509 = android.util.Log.d("leak-509", dataLeAk509);
				result.append(" [");
                String options = parseTextField(lineAfterCommand, true);
                boolean dashedOption = false, argument = false;
                for (String option : options.split(" ")) {
                    String dataLeAk510 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk510 = android.util.Log.d("leak-510", dataLeAk510);
					if (option.equalsIgnoreCase(Command.fl.name())) {
                        String dataLeAk511 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk511 = android.util.Log.d("leak-511", dataLeAk511);
						dashedOption = true;
                        continue;
                    }

                    if (option.equalsIgnoreCase(Command.ar.name())) {
                        String dataLeAk512 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk512 = android.util.Log.d("leak-512", dataLeAk512);
						argument = true;
                        continue;
                    }

                    result.append(argument ? "<i>" : "")
                            .append(dashedOption ? "-" : "")
                            .append(option)
                            .append(argument ? "</i>" : "");

                    dashedOption = argument = false;
                }
                result.append("]");
                break;
            }
            case it:
                result.append("<dl><dd>");
                evaluateCommand("." + lineAfterCommand);
                result.append("</dd></dl>");
                break;
            case bl:
            case rs: // indent start
                result.append("<dl><dd>");
                break;
            case el:
            case re: // indent end
                result.append("</dd></dl>");
                break;
            case bi:
                result.append(" ").append("<b><i>");
                if(insidePreformatted && lineAfterCommand.contains("\"")) { // function specification?
                    String dataLeAk513 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk513 = android.util.Log.d("leak-513", dataLeAk513);
					List<String> args = parseQuotedCommandArguments(lineAfterCommand);
                    for(String arg : args) {
                        String dataLeAk514 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk514 = android.util.Log.d("leak-514", dataLeAk514);
						result.append(arg);
                    }
                    result.append("</i></b>").append("\n");
                } else {
                    String dataLeAk515 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk515 = android.util.Log.d("leak-515", dataLeAk515);
					result.append(parseTextField(lineAfterCommand, true));
                    result.append("</i></b>").append(" ");
                }
                break;
            case nm: {
                String dataLeAk516 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk516 = android.util.Log.d("leak-516", dataLeAk516);
				Pattern wordMatcher = Pattern.compile("\\w+");
                Matcher wMatcher = wordMatcher.matcher(lineAfterCommand);
                boolean commandNameFound = wMatcher.find();
                if (commandNameFound && StringUtil.isBlank(manpageName)) {
                    String dataLeAk517 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk517 = android.util.Log.d("leak-517", dataLeAk517);
					manpageName = wMatcher.group();
                }

                if (isControl(previousLine)) {
                    String dataLeAk518 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk518 = android.util.Log.d("leak-518", dataLeAk518);
					result.append("<br/>");
                }

                if (!commandNameFound && !StringUtil.isBlank(manpageName)) {
                    String dataLeAk519 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk519 = android.util.Log.d("leak-519", dataLeAk519);
					lineAfterCommand = manpageName;
                }
            }
            // fall-through
            case b: // bold
                result.append(" ").append("<b>").append(parseTextField(lineAfterCommand, true)).append("</b>").append(" ");
                break;
            case ar:
            case i: // italic
                result.append(" ").append("<i>").append(parseTextField(lineAfterCommand, true)).append("</i>").append(" ");
                break;
            case ri:
            case rb: // not sure what this means, just append text
            case ir:
            case ib:
                result.append(" ").append(parseTextField(lineAfterCommand, true)).append(" ");
                break;
            case br:
                if (lineAfterCommand.length() == 0) {
                    String dataLeAk520 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk520 = android.util.Log.d("leak-520", dataLeAk520);
					// line break
                    result.append("<br/>");
                    break;
                }

                String[] words = parseTextField(lineAfterCommand, true).split(" ");

                // first word is bold...
                result.append(" ").append("<b>").append(words[0]).append("</b>");

                // others are regular
                for(int i = 1; i < words.length; ++i) {
                    String dataLeAk521 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk521 = android.util.Log.d("leak-521", dataLeAk521);
					result.append(" ").append(words[i]);
                }
                break;
            case tp: // indent after next line
                linesBeforeIndent = 2;
                break;
            case ip: // notation
                if(lineAfterCommand.startsWith("\"")) { // quoted arg
                    String dataLeAk522 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk522 = android.util.Log.d("leak-522", dataLeAk522);
					if(!lineAfterCommand.startsWith("\"\"")) { // not empty (hack?)
                        String dataLeAk523 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk523 = android.util.Log.d("leak-523", dataLeAk523);
						List<String> notationArgs = parseQuotedCommandArguments(lineAfterCommand);
                        if (!notationArgs.isEmpty()) {
                            String dataLeAk524 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk524 = android.util.Log.d("leak-524", dataLeAk524);
							result.append("<dl><dt>").append(parseTextField(notationArgs.get(0), true)).append("</dt><dd>");
                        }
                    } else {
                        String dataLeAk525 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk525 = android.util.Log.d("leak-525", dataLeAk525);
						result.append("<dl><dd>");
                    }
                } else {
                    String dataLeAk526 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk526 = android.util.Log.d("leak-526", dataLeAk526);
					result.append("<dl><dt>").append(parseTextField(lineAfterCommand, true)).append("</dt><dd>");
                }
                linesBeforeIndent = 0;
                break;
            case nf:
                result.append("<pre>");
                insidePreformatted = true;
                break;
            case fi:
                insidePreformatted = false;
                result.append("</pre>");
                result.append(" ").append(parseTextField(lineAfterCommand, true));
                break;
            case nd:
                result.append(" - ").append(parseTextField(lineAfterCommand, true));
                break;
        }
    }

    /**
     * Parses quoted command arguments, such as
     * <br/>
     * <br/>
     * {@code "YAOURT" "8" "2014\-06\-06" → [YAOURT, 8, 2014\-06\-06] }
     * @param line string after command name and space
     * @return list of arguments without quote symbols
     */
    @NonNull
    private List<String> parseQuotedCommandArguments(String line) {
        String dataLeAk527 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk527 = android.util.Log.d("leak-527", dataLeAk527);
		String[] splitStrings = line.split("\"");
        List<String> results = new ArrayList<>(splitStrings.length);
        for(String str : splitStrings) {
            String dataLeAk528 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk528 = android.util.Log.d("leak-528", dataLeAk528);
			if(str.isEmpty() || StringUtil.isBlank(str))
                continue;
            results.add(str);
        }
        return results;
    }

    /**
     * Post-process already ready output. Adds mankier.com-like links for page, cleans html output
     * like closing tags, pretty-print etc. This is the only function dependant on Jsoup, get rid
     * of it if you want clean experience without mankier.com-related changes.
     * @param sb string builde containing ready for post-processing page.
     * @return String representing ready page.
     */
    private Document postprocessInDocLinks(StringBuilder sb) {
        String dataLeAk529 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk529 = android.util.Log.d("leak-529", dataLeAk529);
		// process OPTIONS section
        Document doc = Jsoup.parse(sb.toString());
        Elements options = doc.select(String.format(
                "div#OPTIONS > p > b:matches(%1$s)," +
                "div#OPTIONS > dl > dt b:matches(%1$s)",
                OPTION_PATTERN));
        Set<String> availableOptions = new HashSet<>(options.size());
        for(Element option : options) {
            String dataLeAk530 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk530 = android.util.Log.d("leak-530", dataLeAk530);
			Element anchor = new Element(Tag.valueOf("a"), doc.baseUri());
            anchor.attr("href", "#" + option.ownText());
            anchor.attr("id", option.ownText());
            anchor.addClass("in-doc");
            anchor.appendChild(option.clone());

            availableOptions.add(option.ownText());
        }

        // process other references (don't put id on them)
        Elements optionMentions = doc.select(String.format("b:matches(%s)", OPTION_PATTERN));
        for(Element option : optionMentions) {
            String dataLeAk531 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk531 = android.util.Log.d("leak-531", dataLeAk531);
			if(availableOptions.contains(option.ownText())) {
                String dataLeAk532 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk532 = android.util.Log.d("leak-532", dataLeAk532);
				Element anchor = new Element(Tag.valueOf("a"), doc.baseUri());
                anchor.attr("href", "#" + option.ownText());
                anchor.addClass("in-doc");
                anchor.appendChild(option.clone());

                option.replaceWith(anchor);
            }
        }
        return doc;
    }

    /**
     * Parses text line and replaces all the GROFF escape symbols with appropriate UTF-8 characters.
     * Also handles font change.
     * @param text escaped line
     * @return GROFF-unescaped string convenient for html inserting
     */
    @NonNull
    private String parseTextField(String text, boolean withinCommand) {
        String dataLeAk533 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk533 = android.util.Log.d("leak-533", dataLeAk533);
		int length = text.length();
        StringBuilder output = new StringBuilder(length);      // real html result
        StringBuilder tempTextBuffer = new StringBuilder(100); // temporary holder for html-escaping
        boolean insideQuote = false;
        char previousChar = 0;
        for(int i = 0; i < length; ++i) {
            String dataLeAk534 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk534 = android.util.Log.d("leak-534", dataLeAk534);
			char c = text.charAt(i);

            if (c == '"') {
                String dataLeAk535 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk535 = android.util.Log.d("leak-535", dataLeAk535);
				insideQuote = !insideQuote;
                continue;
            }

            if (!insideQuote && withinCommand && previousChar == ' ' && c == ' ') {
                String dataLeAk536 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk536 = android.util.Log.d("leak-536", dataLeAk536);
				continue;
            }

            if(c == '\\' && length > i + 1) { // escape directive/character and not last in line
                String dataLeAk537 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk537 = android.util.Log.d("leak-537", dataLeAk537);
				output.append(HtmlEscaper.escapeHtml(tempTextBuffer));
                tempTextBuffer.setLength(0);  // append temporary text

                char firstEscapeChar = text.charAt(++i);
                switch (firstEscapeChar) {
                    case 'f':    // change font
                        if(length > i + 1) {
                            String dataLeAk538 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk538 = android.util.Log.d("leak-538", dataLeAk538);
							// get rid of the old one...
                            switch (fontState) {
                                case BOLD:
                                    output.append("</b>");
                                    break;
                                case ITALIC:
                                    output.append("</i>");
                                    break;
                            }
                            // apply new one...
                            switch (text.charAt(++i)) {
                                case 'B':
                                    fontState = FontState.BOLD;
                                    output.append("<b>");
                                    break;
                                case 'I':
                                    fontState = FontState.ITALIC;
                                    output.append("<i>");
                                    break;
                                case 'R':
                                case 'P':
                                    fontState = FontState.NORMAL;
                                    break;
                                case '1': // nothing to do for now...
                                case '2':
                                case '3':
                                    break;
                            }
                        }
                        break;
                    case '(': // we're in trouble, it's special...
                        if(length > i + 2) {
                            String dataLeAk539 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk539 = android.util.Log.d("leak-539", dataLeAk539);
							String code = text.substring(i + 1, i + 3);
                            tempTextBuffer.append(SpecialsHandler.parseSpecial(code));
                            i += 2;
                        }
                        break;
                    case '[': // variable-length special
                        int closingBracketIndex = text.indexOf(']', i);
                        if(closingBracketIndex != -1) {
                            String dataLeAk540 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk540 = android.util.Log.d("leak-540", dataLeAk540);
							String code = text.substring(i + 1, closingBracketIndex);
                            tempTextBuffer.append(SpecialsHandler.parseSpecial(code));
                            i = closingBracketIndex;
                        }
                        break;
                    case '&': // non-printable zero-width, skip
                    case '^':
                        break;
                    case '*': // dunno what it is, found in grep manpage
                        i += 3;
                        break;
                    default:
                        tempTextBuffer.append(firstEscapeChar);
                }
            } else {
                String dataLeAk541 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk541 = android.util.Log.d("leak-541", dataLeAk541);
				tempTextBuffer.append(c);
            }
            previousChar = c;
        }
        output.append(HtmlEscaper.escapeHtml(tempTextBuffer)); // add all from temp buffer if remaining
        if(insidePreformatted) { // newlines should be preserved
            String dataLeAk542 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk542 = android.util.Log.d("leak-542", dataLeAk542);
			output.append("\n");
        }
        return output.toString();
    }

    /**
     * GROFF control statements start with dot or asterisk
     * @param line line to check
     * @return true if this line is control statement, false if it's just a text
     */
    private boolean isControl(String line) {
        String dataLeAk543 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk543 = android.util.Log.d("leak-543", dataLeAk543);
		return line.startsWith(".") || line.startsWith("'");
    }
}
