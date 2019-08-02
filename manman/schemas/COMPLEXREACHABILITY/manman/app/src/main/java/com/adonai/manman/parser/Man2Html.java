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
			String dataLeAk397 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP397 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP397.put("test", new java.util.HashMap<String, String>());
			leakMaP397.get("test").put("test", dataLeAk397);
			String dataLeAkPath397 = leakMaP397.get("test").get("test");
			android.util.Log.d("leak-397", dataLeAkPath397);
        }

        Command(boolean stopsIndentation) {
            String dataLeAk398 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer398 = new StringBuffer();for (char chAr398 : dataLeAk398.toCharArray()) {leakBuFFer398.append(chAr398);}String dataLeAkPath398 = leakBuFFer398.toString();
			android.util.Log.d("leak-398", dataLeAkPath398);
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
        String dataLeAk399 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath399;try {throw new Exception(dataLeAk399);} catch (Exception leakErRor399) {dataLeAkPath399 = leakErRor399.getMessage();}
		android.util.Log.d("leak-399", dataLeAkPath399);
		this.source = source;
    }

    /**
     * Retrieve HTML from buffer. This method does actual line-by-line parsing of TROFF format
     * @return String containing HTML-formatted man page
     * @throws IOException on reading error
     */
    @NonNull
    public String getHtml() throws IOException {
        String dataLeAk400 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay400 = new String[] {"n/a", dataLeAk400};
		String dataLeAkPath400 = leakArRay400[leakArRay400.length - 1];
		android.util.Log.d("leak-400", dataLeAkPath400);
		doParse();
        return postprocessInDocLinks(result).html();
    }

    /**
     * @see #getHtml()
     */
    @NonNull
    public Document getDoc() throws IOException {
        String dataLeAk401 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP401 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP401.put("test", new java.util.HashMap<String, String>());
		leakMaP401.get("test").put("test", dataLeAk401);
		String dataLeAkPath401 = leakMaP401.get("test").get("test");
		android.util.Log.d("leak-401", dataLeAkPath401);
		doParse();
        return postprocessInDocLinks(result);
    }

    private void doParse() throws IOException {
        String dataLeAk402 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer402 = new StringBuffer();for (char chAr402 : dataLeAk402.toCharArray()) {leakBuFFer402.append(chAr402);}String dataLeAkPath402 = leakBuFFer402.toString();
		android.util.Log.d("leak-402", dataLeAkPath402);
		result.append("<html><body>");
        String line;
        while((line = source.readLine()) != null) {
            String dataLeAk403 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath403;try {throw new Exception(dataLeAk403);} catch (Exception leakErRor403) {dataLeAkPath403 = leakErRor403.getMessage();}
			android.util.Log.d("leak-403", dataLeAkPath403);
			while (line.endsWith("\\")) { // take next line too
                String dataLeAk404 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay404 = new String[] {"n/a", dataLeAk404};
				String dataLeAkPath404 = leakArRay404[leakArRay404.length - 1];
				android.util.Log.d("leak-404", dataLeAkPath404);
				String nextLine;
                if((nextLine = source.readLine()) != null) {
                    String dataLeAk405 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP405 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP405.put("test", new java.util.HashMap<String, String>());
					leakMaP405.get("test").put("test", dataLeAk405);
					String dataLeAkPath405 = leakMaP405.get("test").get("test");
					android.util.Log.d("leak-405", dataLeAkPath405);
					line = line.substring(0, line.length() - 2) + nextLine;
                }
            }

            if(line.startsWith("'") || line.startsWith(".\\") || line.startsWith("\\\\"))
                continue; // beginning of message or comment, skip...

            if(isControl(line)) {
                String dataLeAk406 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer406 = new StringBuffer();for (char chAr406 : dataLeAk406.toCharArray()) {leakBuFFer406.append(chAr406);}String dataLeAkPath406 = leakBuFFer406.toString();
				android.util.Log.d("leak-406", dataLeAkPath406);
				evaluateCommand(line);
            } else {
                String dataLeAk407 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath407;try {throw new Exception(dataLeAk407);} catch (Exception leakErRor407) {dataLeAkPath407 = leakErRor407.getMessage();}
				android.util.Log.d("leak-407", dataLeAkPath407);
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
        String dataLeAk408 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay408 = new String[] {"n/a", dataLeAk408};
		String dataLeAkPath408 = leakArRay408[leakArRay408.length - 1];
		android.util.Log.d("leak-408", dataLeAkPath408);
		if(linesBeforeIndent > 0) {
            String dataLeAk409 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP409 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP409.put("test", new java.util.HashMap<String, String>());
			leakMaP409.get("test").put("test", dataLeAk409);
			String dataLeAkPath409 = leakMaP409.get("test").get("test");
			android.util.Log.d("leak-409", dataLeAkPath409);
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
        String dataLeAk410 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer410 = new StringBuffer();for (char chAr410 : dataLeAk410.toCharArray()) {leakBuFFer410.append(chAr410);}String dataLeAkPath410 = leakBuFFer410.toString();
		android.util.Log.d("leak-410", dataLeAkPath410);
		if(line.length() < 2)
            return; // less than dot + 1 chars - it can't be command

        // let's try to extract command from the line
        String firstWord;
        String lineAfterCommand;

        int firstSpace = line.indexOf(" ");
        if(firstSpace != -1) {
            String dataLeAk411 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath411;try {throw new Exception(dataLeAk411);} catch (Exception leakErRor411) {dataLeAkPath411 = leakErRor411.getMessage();}
			android.util.Log.d("leak-411", dataLeAkPath411);
			firstWord = line.substring(1, firstSpace); // word before first space
            lineAfterCommand = line.substring(firstSpace + 1);
        } else {
            String dataLeAk412 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay412 = new String[] {"n/a", dataLeAk412};
			String dataLeAkPath412 = leakArRay412[leakArRay412.length - 1];
			android.util.Log.d("leak-412", dataLeAkPath412);
			firstWord = line.substring(1); // till the end of line
            lineAfterCommand = "";
        }

        try {
            String dataLeAk413 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP413 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP413.put("test", new java.util.HashMap<String, String>());
			leakMaP413.get("test").put("test", dataLeAk413);
			String dataLeAkPath413 = leakMaP413.get("test").get("test");
			android.util.Log.d("leak-413", dataLeAkPath413);
			Command command = Command.valueOf(firstWord.toLowerCase());
            if(command.stopsIndentation) {
                String dataLeAk414 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer414 = new StringBuffer();for (char chAr414 : dataLeAk414.toCharArray()) {leakBuFFer414.append(chAr414);}String dataLeAkPath414 = leakBuFFer414.toString();
				android.util.Log.d("leak-414", dataLeAkPath414);
				if(linesBeforeIndent == 0) { // we were indenting right now, reset
                    String dataLeAk415 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath415;try {throw new Exception(dataLeAk415);} catch (Exception leakErRor415) {dataLeAkPath415 = leakErRor415.getMessage();}
					android.util.Log.d("leak-415", dataLeAkPath415);
					result.append("</dd></dl>");
                    linesBeforeIndent = -1;
                }
            }
            executeCommand(command, lineAfterCommand);
            previousCommand = command;
        } catch (IllegalArgumentException iae) {
            String dataLeAk416 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay416 = new String[] {"n/a", dataLeAk416};
			String dataLeAkPath416 = leakArRay416[leakArRay416.length - 1];
			android.util.Log.d("leak-416", dataLeAkPath416);
			Log.w(Utils.MM_TAG, "Man2Html - unimplemented control", iae);
            // skip...
        }
    }

    private void executeCommand(Command command, String lineAfterCommand) {
        String dataLeAk417 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP417 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP417.put("test", new java.util.HashMap<String, String>());
		leakMaP417.get("test").put("test", dataLeAk417);
		String dataLeAkPath417 = leakMaP417.get("test").get("test");
		android.util.Log.d("leak-417", dataLeAkPath417);
		switch (command) {
            case th: // table header
            case dt:
                List<String> titleArgs = parseQuotedCommandArguments(lineAfterCommand);
                if(!titleArgs.isEmpty()) {  // take only name of command
                    String dataLeAk418 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer418 = new StringBuffer();for (char chAr418 : dataLeAk418.toCharArray()) {leakBuFFer418.append(chAr418);}String dataLeAkPath418 = leakBuFFer418.toString();
					android.util.Log.d("leak-418", dataLeAkPath418);
					result.append("<div class='man-page'>"); // it'd be better to close it somehow...
                    result.append("<h1>").append(parseTextField(titleArgs.get(0), false)).append("</h1>");
                }

                break;
            case pp: // paragraph
            case lp:
            case p:
            case sp: // line break
                if(insideParagraph) {
                    String dataLeAk419 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath419;try {throw new Exception(dataLeAk419);} catch (Exception leakErRor419) {dataLeAkPath419 = leakErRor419.getMessage();}
					android.util.Log.d("leak-419", dataLeAkPath419);
					result.append("</p>");
                }

                insideParagraph = true;
                result.append("<p>");
                break;
            case sh: // sub header
                if(insideSection) {
                    String dataLeAk420 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay420 = new String[] {"n/a", dataLeAk420};
					String dataLeAkPath420 = leakArRay420[leakArRay420.length - 1];
					android.util.Log.d("leak-420", dataLeAkPath420);
					result.append("</div>");
                }
                List<String> subHeaderArgs = parseQuotedCommandArguments(lineAfterCommand);
                if(!subHeaderArgs.isEmpty()) {
                    String dataLeAk421 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP421 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP421.put("test", new java.util.HashMap<String, String>());
					leakMaP421.get("test").put("test", dataLeAk421);
					String dataLeAkPath421 = leakMaP421.get("test").get("test");
					android.util.Log.d("leak-421", dataLeAkPath421);
					String shName = parseTextField(subHeaderArgs.get(0), true);
                    result.append("<div id='").append(shName).append("' class='section'>")
                            .append("<h2>")
                              .append("<a href='#").append(shName).append("'>").append(shName).append("</a>")
                            .append("</h2>");
                }
                insideSection = true;
                break;
            case fl: {
                String dataLeAk422 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer422 = new StringBuffer();for (char chAr422 : dataLeAk422.toCharArray()) {leakBuFFer422.append(chAr422);}String dataLeAkPath422 = leakBuFFer422.toString();
				android.util.Log.d("leak-422", dataLeAkPath422);
				String options = parseTextField(lineAfterCommand, true);
                Pattern wordMatcher = Pattern.compile("\\w+");
                Matcher wMatcher = wordMatcher.matcher(options);
                String optionsDashed = wMatcher.replaceAll("-$0");
                result.append(" ").append(optionsDashed);
                break;
            }
            case op: {
                String dataLeAk423 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath423;try {throw new Exception(dataLeAk423);} catch (Exception leakErRor423) {dataLeAkPath423 = leakErRor423.getMessage();}
				android.util.Log.d("leak-423", dataLeAkPath423);
				result.append(" [");
                String options = parseTextField(lineAfterCommand, true);
                boolean dashedOption = false, argument = false;
                for (String option : options.split(" ")) {
                    String dataLeAk424 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay424 = new String[] {"n/a", dataLeAk424};
					String dataLeAkPath424 = leakArRay424[leakArRay424.length - 1];
					android.util.Log.d("leak-424", dataLeAkPath424);
					if (option.equalsIgnoreCase(Command.fl.name())) {
                        String dataLeAk425 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP425 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP425.put("test", new java.util.HashMap<String, String>());
						leakMaP425.get("test").put("test", dataLeAk425);
						String dataLeAkPath425 = leakMaP425.get("test").get("test");
						android.util.Log.d("leak-425", dataLeAkPath425);
						dashedOption = true;
                        continue;
                    }

                    if (option.equalsIgnoreCase(Command.ar.name())) {
                        String dataLeAk426 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer426 = new StringBuffer();for (char chAr426 : dataLeAk426.toCharArray()) {leakBuFFer426.append(chAr426);}String dataLeAkPath426 = leakBuFFer426.toString();
						android.util.Log.d("leak-426", dataLeAkPath426);
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
                    String dataLeAk427 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath427;try {throw new Exception(dataLeAk427);} catch (Exception leakErRor427) {dataLeAkPath427 = leakErRor427.getMessage();}
					android.util.Log.d("leak-427", dataLeAkPath427);
					List<String> args = parseQuotedCommandArguments(lineAfterCommand);
                    for(String arg : args) {
                        String dataLeAk428 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay428 = new String[] {"n/a", dataLeAk428};
						String dataLeAkPath428 = leakArRay428[leakArRay428.length - 1];
						android.util.Log.d("leak-428", dataLeAkPath428);
						result.append(arg);
                    }
                    result.append("</i></b>").append("\n");
                } else {
                    String dataLeAk429 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP429 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP429.put("test", new java.util.HashMap<String, String>());
					leakMaP429.get("test").put("test", dataLeAk429);
					String dataLeAkPath429 = leakMaP429.get("test").get("test");
					android.util.Log.d("leak-429", dataLeAkPath429);
					result.append(parseTextField(lineAfterCommand, true));
                    result.append("</i></b>").append(" ");
                }
                break;
            case nm: {
                String dataLeAk430 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer430 = new StringBuffer();for (char chAr430 : dataLeAk430.toCharArray()) {leakBuFFer430.append(chAr430);}String dataLeAkPath430 = leakBuFFer430.toString();
				android.util.Log.d("leak-430", dataLeAkPath430);
				Pattern wordMatcher = Pattern.compile("\\w+");
                Matcher wMatcher = wordMatcher.matcher(lineAfterCommand);
                boolean commandNameFound = wMatcher.find();
                if (commandNameFound && StringUtil.isBlank(manpageName)) {
                    String dataLeAk431 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath431;try {throw new Exception(dataLeAk431);} catch (Exception leakErRor431) {dataLeAkPath431 = leakErRor431.getMessage();}
					android.util.Log.d("leak-431", dataLeAkPath431);
					manpageName = wMatcher.group();
                }

                if (isControl(previousLine)) {
                    String dataLeAk432 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay432 = new String[] {"n/a", dataLeAk432};
					String dataLeAkPath432 = leakArRay432[leakArRay432.length - 1];
					android.util.Log.d("leak-432", dataLeAkPath432);
					result.append("<br/>");
                }

                if (!commandNameFound && !StringUtil.isBlank(manpageName)) {
                    String dataLeAk433 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP433 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP433.put("test", new java.util.HashMap<String, String>());
					leakMaP433.get("test").put("test", dataLeAk433);
					String dataLeAkPath433 = leakMaP433.get("test").get("test");
					android.util.Log.d("leak-433", dataLeAkPath433);
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
                    String dataLeAk434 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer434 = new StringBuffer();for (char chAr434 : dataLeAk434.toCharArray()) {leakBuFFer434.append(chAr434);}String dataLeAkPath434 = leakBuFFer434.toString();
					android.util.Log.d("leak-434", dataLeAkPath434);
					// line break
                    result.append("<br/>");
                    break;
                }

                String[] words = parseTextField(lineAfterCommand, true).split(" ");

                // first word is bold...
                result.append(" ").append("<b>").append(words[0]).append("</b>");

                // others are regular
                for(int i = 1; i < words.length; ++i) {
                    String dataLeAk435 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath435;try {throw new Exception(dataLeAk435);} catch (Exception leakErRor435) {dataLeAkPath435 = leakErRor435.getMessage();}
					android.util.Log.d("leak-435", dataLeAkPath435);
					result.append(" ").append(words[i]);
                }
                break;
            case tp: // indent after next line
                linesBeforeIndent = 2;
                break;
            case ip: // notation
                if(lineAfterCommand.startsWith("\"")) { // quoted arg
                    String dataLeAk436 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay436 = new String[] {"n/a", dataLeAk436};
					String dataLeAkPath436 = leakArRay436[leakArRay436.length - 1];
					android.util.Log.d("leak-436", dataLeAkPath436);
					if(!lineAfterCommand.startsWith("\"\"")) { // not empty (hack?)
                        String dataLeAk437 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP437 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP437.put("test", new java.util.HashMap<String, String>());
						leakMaP437.get("test").put("test", dataLeAk437);
						String dataLeAkPath437 = leakMaP437.get("test").get("test");
						android.util.Log.d("leak-437", dataLeAkPath437);
						List<String> notationArgs = parseQuotedCommandArguments(lineAfterCommand);
                        if (!notationArgs.isEmpty()) {
                            String dataLeAk438 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer438 = new StringBuffer();for (char chAr438 : dataLeAk438.toCharArray()) {leakBuFFer438.append(chAr438);}String dataLeAkPath438 = leakBuFFer438.toString();
							android.util.Log.d("leak-438", dataLeAkPath438);
							result.append("<dl><dt>").append(parseTextField(notationArgs.get(0), true)).append("</dt><dd>");
                        }
                    } else {
                        String dataLeAk439 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath439;try {throw new Exception(dataLeAk439);} catch (Exception leakErRor439) {dataLeAkPath439 = leakErRor439.getMessage();}
						android.util.Log.d("leak-439", dataLeAkPath439);
						result.append("<dl><dd>");
                    }
                } else {
                    String dataLeAk440 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay440 = new String[] {"n/a", dataLeAk440};
					String dataLeAkPath440 = leakArRay440[leakArRay440.length - 1];
					android.util.Log.d("leak-440", dataLeAkPath440);
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
        String dataLeAk441 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP441 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP441.put("test", new java.util.HashMap<String, String>());
		leakMaP441.get("test").put("test", dataLeAk441);
		String dataLeAkPath441 = leakMaP441.get("test").get("test");
		android.util.Log.d("leak-441", dataLeAkPath441);
		String[] splitStrings = line.split("\"");
        List<String> results = new ArrayList<>(splitStrings.length);
        for(String str : splitStrings) {
            String dataLeAk442 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer442 = new StringBuffer();for (char chAr442 : dataLeAk442.toCharArray()) {leakBuFFer442.append(chAr442);}String dataLeAkPath442 = leakBuFFer442.toString();
			android.util.Log.d("leak-442", dataLeAkPath442);
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
        String dataLeAk443 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath443;try {throw new Exception(dataLeAk443);} catch (Exception leakErRor443) {dataLeAkPath443 = leakErRor443.getMessage();}
		android.util.Log.d("leak-443", dataLeAkPath443);
		// process OPTIONS section
        Document doc = Jsoup.parse(sb.toString());
        Elements options = doc.select(String.format(
                "div#OPTIONS > p > b:matches(%1$s)," +
                "div#OPTIONS > dl > dt b:matches(%1$s)",
                OPTION_PATTERN));
        Set<String> availableOptions = new HashSet<>(options.size());
        for(Element option : options) {
            String dataLeAk444 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay444 = new String[] {"n/a", dataLeAk444};
			String dataLeAkPath444 = leakArRay444[leakArRay444.length - 1];
			android.util.Log.d("leak-444", dataLeAkPath444);
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
            String dataLeAk445 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP445 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP445.put("test", new java.util.HashMap<String, String>());
			leakMaP445.get("test").put("test", dataLeAk445);
			String dataLeAkPath445 = leakMaP445.get("test").get("test");
			android.util.Log.d("leak-445", dataLeAkPath445);
			if(availableOptions.contains(option.ownText())) {
                String dataLeAk446 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer446 = new StringBuffer();for (char chAr446 : dataLeAk446.toCharArray()) {leakBuFFer446.append(chAr446);}String dataLeAkPath446 = leakBuFFer446.toString();
				android.util.Log.d("leak-446", dataLeAkPath446);
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
        String dataLeAk447 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath447;try {throw new Exception(dataLeAk447);} catch (Exception leakErRor447) {dataLeAkPath447 = leakErRor447.getMessage();}
		android.util.Log.d("leak-447", dataLeAkPath447);
		int length = text.length();
        StringBuilder output = new StringBuilder(length);      // real html result
        StringBuilder tempTextBuffer = new StringBuilder(100); // temporary holder for html-escaping
        boolean insideQuote = false;
        char previousChar = 0;
        for(int i = 0; i < length; ++i) {
            String dataLeAk448 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay448 = new String[] {"n/a", dataLeAk448};
			String dataLeAkPath448 = leakArRay448[leakArRay448.length - 1];
			android.util.Log.d("leak-448", dataLeAkPath448);
			char c = text.charAt(i);

            if (c == '"') {
                String dataLeAk449 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP449 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP449.put("test", new java.util.HashMap<String, String>());
				leakMaP449.get("test").put("test", dataLeAk449);
				String dataLeAkPath449 = leakMaP449.get("test").get("test");
				android.util.Log.d("leak-449", dataLeAkPath449);
				insideQuote = !insideQuote;
                continue;
            }

            if (!insideQuote && withinCommand && previousChar == ' ' && c == ' ') {
                String dataLeAk450 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer450 = new StringBuffer();for (char chAr450 : dataLeAk450.toCharArray()) {leakBuFFer450.append(chAr450);}String dataLeAkPath450 = leakBuFFer450.toString();
				android.util.Log.d("leak-450", dataLeAkPath450);
				continue;
            }

            if(c == '\\' && length > i + 1) { // escape directive/character and not last in line
                String dataLeAk451 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath451;try {throw new Exception(dataLeAk451);} catch (Exception leakErRor451) {dataLeAkPath451 = leakErRor451.getMessage();}
				android.util.Log.d("leak-451", dataLeAkPath451);
				output.append(HtmlEscaper.escapeHtml(tempTextBuffer));
                tempTextBuffer.setLength(0);  // append temporary text

                char firstEscapeChar = text.charAt(++i);
                switch (firstEscapeChar) {
                    case 'f':    // change font
                        if(length > i + 1) {
                            String dataLeAk452 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay452 = new String[] {"n/a", dataLeAk452};
							String dataLeAkPath452 = leakArRay452[leakArRay452.length - 1];
							android.util.Log.d("leak-452", dataLeAkPath452);
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
                            String dataLeAk453 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP453 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP453.put("test", new java.util.HashMap<String, String>());
							leakMaP453.get("test").put("test", dataLeAk453);
							String dataLeAkPath453 = leakMaP453.get("test").get("test");
							android.util.Log.d("leak-453", dataLeAkPath453);
							String code = text.substring(i + 1, i + 3);
                            tempTextBuffer.append(SpecialsHandler.parseSpecial(code));
                            i += 2;
                        }
                        break;
                    case '[': // variable-length special
                        int closingBracketIndex = text.indexOf(']', i);
                        if(closingBracketIndex != -1) {
                            String dataLeAk454 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer454 = new StringBuffer();for (char chAr454 : dataLeAk454.toCharArray()) {leakBuFFer454.append(chAr454);}String dataLeAkPath454 = leakBuFFer454.toString();
							android.util.Log.d("leak-454", dataLeAkPath454);
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
                String dataLeAk455 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath455;try {throw new Exception(dataLeAk455);} catch (Exception leakErRor455) {dataLeAkPath455 = leakErRor455.getMessage();}
				android.util.Log.d("leak-455", dataLeAkPath455);
				tempTextBuffer.append(c);
            }
            previousChar = c;
        }
        output.append(HtmlEscaper.escapeHtml(tempTextBuffer)); // add all from temp buffer if remaining
        if(insidePreformatted) { // newlines should be preserved
            String dataLeAk456 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay456 = new String[] {"n/a", dataLeAk456};
			String dataLeAkPath456 = leakArRay456[leakArRay456.length - 1];
			android.util.Log.d("leak-456", dataLeAkPath456);
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
        String dataLeAk457 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP457 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP457.put("test", new java.util.HashMap<String, String>());
		leakMaP457.get("test").put("test", dataLeAk457);
		String dataLeAkPath457 = leakMaP457.get("test").get("test");
		android.util.Log.d("leak-457", dataLeAkPath457);
		return line.startsWith(".") || line.startsWith("'");
    }
}
