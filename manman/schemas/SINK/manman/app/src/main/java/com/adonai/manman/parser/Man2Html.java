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

    String dataLeAk383 = "";

	String dataLeAk382 = "";

	String dataLeAk381 = "";

	String dataLeAk380 = "";

	String dataLeAk379 = "";

	String dataLeAk378 = "";

	String dataLeAk377 = "";

	String dataLeAk376 = "";

	String dataLeAk375 = "";

	String dataLeAk374 = "";

	String dataLeAk373 = "";

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
        }

        Command(boolean stopsIndentation) {
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
        dataLeAk373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-373-0", dataLeAk373);
		android.util.Log.d("leak-374-0", dataLeAk374);
		android.util.Log.d("leak-375-0", dataLeAk375);
		android.util.Log.d("leak-376-0", dataLeAk376);
		android.util.Log.d("leak-377-0", dataLeAk377);
		android.util.Log.d("leak-378-0", dataLeAk378);
		android.util.Log.d("leak-379-0", dataLeAk379);
		android.util.Log.d("leak-380-0", dataLeAk380);
		android.util.Log.d("leak-381-0", dataLeAk381);
		android.util.Log.d("leak-382-0", dataLeAk382);
		android.util.Log.d("leak-383-0", dataLeAk383);
		this.source = source;
    }

    /**
     * Retrieve HTML from buffer. This method does actual line-by-line parsing of TROFF format
     * @return String containing HTML-formatted man page
     * @throws IOException on reading error
     */
    @NonNull
    public String getHtml() throws IOException {
        dataLeAk374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-373-1", dataLeAk373);
		android.util.Log.d("leak-374-1", dataLeAk374);
		android.util.Log.d("leak-375-1", dataLeAk375);
		android.util.Log.d("leak-376-1", dataLeAk376);
		android.util.Log.d("leak-377-1", dataLeAk377);
		android.util.Log.d("leak-378-1", dataLeAk378);
		android.util.Log.d("leak-379-1", dataLeAk379);
		android.util.Log.d("leak-380-1", dataLeAk380);
		android.util.Log.d("leak-381-1", dataLeAk381);
		android.util.Log.d("leak-382-1", dataLeAk382);
		android.util.Log.d("leak-383-1", dataLeAk383);
		doParse();
        return postprocessInDocLinks(result).html();
    }

    /**
     * @see #getHtml()
     */
    @NonNull
    public Document getDoc() throws IOException {
        dataLeAk375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-373-2", dataLeAk373);
		android.util.Log.d("leak-374-2", dataLeAk374);
		android.util.Log.d("leak-375-2", dataLeAk375);
		android.util.Log.d("leak-376-2", dataLeAk376);
		android.util.Log.d("leak-377-2", dataLeAk377);
		android.util.Log.d("leak-378-2", dataLeAk378);
		android.util.Log.d("leak-379-2", dataLeAk379);
		android.util.Log.d("leak-380-2", dataLeAk380);
		android.util.Log.d("leak-381-2", dataLeAk381);
		android.util.Log.d("leak-382-2", dataLeAk382);
		android.util.Log.d("leak-383-2", dataLeAk383);
		doParse();
        return postprocessInDocLinks(result);
    }

    private void doParse() throws IOException {
        dataLeAk376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-373-3", dataLeAk373);
		android.util.Log.d("leak-374-3", dataLeAk374);
		android.util.Log.d("leak-375-3", dataLeAk375);
		android.util.Log.d("leak-376-3", dataLeAk376);
		android.util.Log.d("leak-377-3", dataLeAk377);
		android.util.Log.d("leak-378-3", dataLeAk378);
		android.util.Log.d("leak-379-3", dataLeAk379);
		android.util.Log.d("leak-380-3", dataLeAk380);
		android.util.Log.d("leak-381-3", dataLeAk381);
		android.util.Log.d("leak-382-3", dataLeAk382);
		android.util.Log.d("leak-383-3", dataLeAk383);
		result.append("<html><body>");
        String line;
        while((line = source.readLine()) != null) {
            while (line.endsWith("\\")) { // take next line too
                String nextLine;
                if((nextLine = source.readLine()) != null) {
                    line = line.substring(0, line.length() - 2) + nextLine;
                }
            }

            if(line.startsWith("'") || line.startsWith(".\\") || line.startsWith("\\\\"))
                continue; // beginning of message or comment, skip...

            if(isControl(line)) {
                evaluateCommand(line);
            } else {
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
        dataLeAk377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-373-4", dataLeAk373);
		android.util.Log.d("leak-374-4", dataLeAk374);
		android.util.Log.d("leak-375-4", dataLeAk375);
		android.util.Log.d("leak-376-4", dataLeAk376);
		android.util.Log.d("leak-377-4", dataLeAk377);
		android.util.Log.d("leak-378-4", dataLeAk378);
		android.util.Log.d("leak-379-4", dataLeAk379);
		android.util.Log.d("leak-380-4", dataLeAk380);
		android.util.Log.d("leak-381-4", dataLeAk381);
		android.util.Log.d("leak-382-4", dataLeAk382);
		android.util.Log.d("leak-383-4", dataLeAk383);
		if(linesBeforeIndent > 0) {
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
        dataLeAk378 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-373-5", dataLeAk373);
		android.util.Log.d("leak-374-5", dataLeAk374);
		android.util.Log.d("leak-375-5", dataLeAk375);
		android.util.Log.d("leak-376-5", dataLeAk376);
		android.util.Log.d("leak-377-5", dataLeAk377);
		android.util.Log.d("leak-378-5", dataLeAk378);
		android.util.Log.d("leak-379-5", dataLeAk379);
		android.util.Log.d("leak-380-5", dataLeAk380);
		android.util.Log.d("leak-381-5", dataLeAk381);
		android.util.Log.d("leak-382-5", dataLeAk382);
		android.util.Log.d("leak-383-5", dataLeAk383);
		if(line.length() < 2)
            return; // less than dot + 1 chars - it can't be command

        // let's try to extract command from the line
        String firstWord;
        String lineAfterCommand;

        int firstSpace = line.indexOf(" ");
        if(firstSpace != -1) {
            firstWord = line.substring(1, firstSpace); // word before first space
            lineAfterCommand = line.substring(firstSpace + 1);
        } else {
            firstWord = line.substring(1); // till the end of line
            lineAfterCommand = "";
        }

        try {
            Command command = Command.valueOf(firstWord.toLowerCase());
            if(command.stopsIndentation) {
                if(linesBeforeIndent == 0) { // we were indenting right now, reset
                    result.append("</dd></dl>");
                    linesBeforeIndent = -1;
                }
            }
            executeCommand(command, lineAfterCommand);
            previousCommand = command;
        } catch (IllegalArgumentException iae) {
            Log.w(Utils.MM_TAG, "Man2Html - unimplemented control", iae);
            // skip...
        }
    }

    private void executeCommand(Command command, String lineAfterCommand) {
        dataLeAk379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-373-6", dataLeAk373);
		android.util.Log.d("leak-374-6", dataLeAk374);
		android.util.Log.d("leak-375-6", dataLeAk375);
		android.util.Log.d("leak-376-6", dataLeAk376);
		android.util.Log.d("leak-377-6", dataLeAk377);
		android.util.Log.d("leak-378-6", dataLeAk378);
		android.util.Log.d("leak-379-6", dataLeAk379);
		android.util.Log.d("leak-380-6", dataLeAk380);
		android.util.Log.d("leak-381-6", dataLeAk381);
		android.util.Log.d("leak-382-6", dataLeAk382);
		android.util.Log.d("leak-383-6", dataLeAk383);
		switch (command) {
            case th: // table header
            case dt:
                List<String> titleArgs = parseQuotedCommandArguments(lineAfterCommand);
                if(!titleArgs.isEmpty()) {  // take only name of command
                    result.append("<div class='man-page'>"); // it'd be better to close it somehow...
                    result.append("<h1>").append(parseTextField(titleArgs.get(0), false)).append("</h1>");
                }

                break;
            case pp: // paragraph
            case lp:
            case p:
            case sp: // line break
                if(insideParagraph) {
                    result.append("</p>");
                }

                insideParagraph = true;
                result.append("<p>");
                break;
            case sh: // sub header
                if(insideSection) {
                    result.append("</div>");
                }
                List<String> subHeaderArgs = parseQuotedCommandArguments(lineAfterCommand);
                if(!subHeaderArgs.isEmpty()) {
                    String shName = parseTextField(subHeaderArgs.get(0), true);
                    result.append("<div id='").append(shName).append("' class='section'>")
                            .append("<h2>")
                              .append("<a href='#").append(shName).append("'>").append(shName).append("</a>")
                            .append("</h2>");
                }
                insideSection = true;
                break;
            case fl: {
                String options = parseTextField(lineAfterCommand, true);
                Pattern wordMatcher = Pattern.compile("\\w+");
                Matcher wMatcher = wordMatcher.matcher(options);
                String optionsDashed = wMatcher.replaceAll("-$0");
                result.append(" ").append(optionsDashed);
                break;
            }
            case op: {
                result.append(" [");
                String options = parseTextField(lineAfterCommand, true);
                boolean dashedOption = false, argument = false;
                for (String option : options.split(" ")) {
                    if (option.equalsIgnoreCase(Command.fl.name())) {
                        dashedOption = true;
                        continue;
                    }

                    if (option.equalsIgnoreCase(Command.ar.name())) {
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
                    List<String> args = parseQuotedCommandArguments(lineAfterCommand);
                    for(String arg : args) {
                        result.append(arg);
                    }
                    result.append("</i></b>").append("\n");
                } else {
                    result.append(parseTextField(lineAfterCommand, true));
                    result.append("</i></b>").append(" ");
                }
                break;
            case nm: {
                Pattern wordMatcher = Pattern.compile("\\w+");
                Matcher wMatcher = wordMatcher.matcher(lineAfterCommand);
                boolean commandNameFound = wMatcher.find();
                if (commandNameFound && StringUtil.isBlank(manpageName)) {
                    manpageName = wMatcher.group();
                }

                if (isControl(previousLine)) {
                    result.append("<br/>");
                }

                if (!commandNameFound && !StringUtil.isBlank(manpageName)) {
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
                    // line break
                    result.append("<br/>");
                    break;
                }

                String[] words = parseTextField(lineAfterCommand, true).split(" ");

                // first word is bold...
                result.append(" ").append("<b>").append(words[0]).append("</b>");

                // others are regular
                for(int i = 1; i < words.length; ++i) {
                    result.append(" ").append(words[i]);
                }
                break;
            case tp: // indent after next line
                linesBeforeIndent = 2;
                break;
            case ip: // notation
                if(lineAfterCommand.startsWith("\"")) { // quoted arg
                    if(!lineAfterCommand.startsWith("\"\"")) { // not empty (hack?)
                        List<String> notationArgs = parseQuotedCommandArguments(lineAfterCommand);
                        if (!notationArgs.isEmpty()) {
                            result.append("<dl><dt>").append(parseTextField(notationArgs.get(0), true)).append("</dt><dd>");
                        }
                    } else {
                        result.append("<dl><dd>");
                    }
                } else {
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
        dataLeAk380 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-373-7", dataLeAk373);
		android.util.Log.d("leak-374-7", dataLeAk374);
		android.util.Log.d("leak-375-7", dataLeAk375);
		android.util.Log.d("leak-376-7", dataLeAk376);
		android.util.Log.d("leak-377-7", dataLeAk377);
		android.util.Log.d("leak-378-7", dataLeAk378);
		android.util.Log.d("leak-379-7", dataLeAk379);
		android.util.Log.d("leak-380-7", dataLeAk380);
		android.util.Log.d("leak-381-7", dataLeAk381);
		android.util.Log.d("leak-382-7", dataLeAk382);
		android.util.Log.d("leak-383-7", dataLeAk383);
		String[] splitStrings = line.split("\"");
        List<String> results = new ArrayList<>(splitStrings.length);
        for(String str : splitStrings) {
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
        dataLeAk381 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-373-8", dataLeAk373);
		android.util.Log.d("leak-374-8", dataLeAk374);
		android.util.Log.d("leak-375-8", dataLeAk375);
		android.util.Log.d("leak-376-8", dataLeAk376);
		android.util.Log.d("leak-377-8", dataLeAk377);
		android.util.Log.d("leak-378-8", dataLeAk378);
		android.util.Log.d("leak-379-8", dataLeAk379);
		android.util.Log.d("leak-380-8", dataLeAk380);
		android.util.Log.d("leak-381-8", dataLeAk381);
		android.util.Log.d("leak-382-8", dataLeAk382);
		android.util.Log.d("leak-383-8", dataLeAk383);
		// process OPTIONS section
        Document doc = Jsoup.parse(sb.toString());
        Elements options = doc.select(String.format(
                "div#OPTIONS > p > b:matches(%1$s)," +
                "div#OPTIONS > dl > dt b:matches(%1$s)",
                OPTION_PATTERN));
        Set<String> availableOptions = new HashSet<>(options.size());
        for(Element option : options) {
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
            if(availableOptions.contains(option.ownText())) {
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
        dataLeAk382 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-373-9", dataLeAk373);
		android.util.Log.d("leak-374-9", dataLeAk374);
		android.util.Log.d("leak-375-9", dataLeAk375);
		android.util.Log.d("leak-376-9", dataLeAk376);
		android.util.Log.d("leak-377-9", dataLeAk377);
		android.util.Log.d("leak-378-9", dataLeAk378);
		android.util.Log.d("leak-379-9", dataLeAk379);
		android.util.Log.d("leak-380-9", dataLeAk380);
		android.util.Log.d("leak-381-9", dataLeAk381);
		android.util.Log.d("leak-382-9", dataLeAk382);
		android.util.Log.d("leak-383-9", dataLeAk383);
		int length = text.length();
        StringBuilder output = new StringBuilder(length);      // real html result
        StringBuilder tempTextBuffer = new StringBuilder(100); // temporary holder for html-escaping
        boolean insideQuote = false;
        char previousChar = 0;
        for(int i = 0; i < length; ++i) {
            char c = text.charAt(i);

            if (c == '"') {
                insideQuote = !insideQuote;
                continue;
            }

            if (!insideQuote && withinCommand && previousChar == ' ' && c == ' ') {
                continue;
            }

            if(c == '\\' && length > i + 1) { // escape directive/character and not last in line
                output.append(HtmlEscaper.escapeHtml(tempTextBuffer));
                tempTextBuffer.setLength(0);  // append temporary text

                char firstEscapeChar = text.charAt(++i);
                switch (firstEscapeChar) {
                    case 'f':    // change font
                        if(length > i + 1) {
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
                            String code = text.substring(i + 1, i + 3);
                            tempTextBuffer.append(SpecialsHandler.parseSpecial(code));
                            i += 2;
                        }
                        break;
                    case '[': // variable-length special
                        int closingBracketIndex = text.indexOf(']', i);
                        if(closingBracketIndex != -1) {
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
                tempTextBuffer.append(c);
            }
            previousChar = c;
        }
        output.append(HtmlEscaper.escapeHtml(tempTextBuffer)); // add all from temp buffer if remaining
        if(insidePreformatted) { // newlines should be preserved
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
        dataLeAk383 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-373-10", dataLeAk373);
		android.util.Log.d("leak-374-10", dataLeAk374);
		android.util.Log.d("leak-375-10", dataLeAk375);
		android.util.Log.d("leak-376-10", dataLeAk376);
		android.util.Log.d("leak-377-10", dataLeAk377);
		android.util.Log.d("leak-378-10", dataLeAk378);
		android.util.Log.d("leak-379-10", dataLeAk379);
		android.util.Log.d("leak-380-10", dataLeAk380);
		android.util.Log.d("leak-381-10", dataLeAk381);
		android.util.Log.d("leak-382-10", dataLeAk382);
		android.util.Log.d("leak-383-10", dataLeAk383);
		return line.startsWith(".") || line.startsWith("'");
    }
}
