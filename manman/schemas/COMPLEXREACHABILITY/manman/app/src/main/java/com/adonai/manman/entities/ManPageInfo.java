package com.adonai.manman.entities;

import java.util.List;

/**
 * Object representing answer on description API-call
 *
 * @see com.google.gson.Gson
 * @author Oleg Chernovskiy
 */
@SuppressWarnings("UnusedDeclaration") // reflection in Gson
public class ManPageInfo {
    private String name;
    private String section;
    private String description;
    private String url;
    private List<InfoSection> sections;
    private List<InfoAnchor> anchors;

    public String getName() {
        String dataLeAk498 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer498 = new StringBuffer();for (char chAr498 : dataLeAk498.toCharArray()) {leakBuFFer498.append(chAr498);}String dataLeAkPath498 = leakBuFFer498.toString();
		android.util.Log.d("leak-498", dataLeAkPath498);
		return name;
    }

    public void setName(String name) {
        String dataLeAk499 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath499;try {throw new Exception(dataLeAk499);} catch (Exception leakErRor499) {dataLeAkPath499 = leakErRor499.getMessage();}
		android.util.Log.d("leak-499", dataLeAkPath499);
		this.name = name;
    }

    public String getSection() {
        String dataLeAk500 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay500 = new String[] {"n/a", dataLeAk500};
		String dataLeAkPath500 = leakArRay500[leakArRay500.length - 1];
		android.util.Log.d("leak-500", dataLeAkPath500);
		return section;
    }

    public void setSection(String section) {
        String dataLeAk501 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP501 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP501.put("test", new java.util.HashMap<String, String>());
		leakMaP501.get("test").put("test", dataLeAk501);
		String dataLeAkPath501 = leakMaP501.get("test").get("test");
		android.util.Log.d("leak-501", dataLeAkPath501);
		this.section = section;
    }

    public String getDescription() {
        String dataLeAk502 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer502 = new StringBuffer();for (char chAr502 : dataLeAk502.toCharArray()) {leakBuFFer502.append(chAr502);}String dataLeAkPath502 = leakBuFFer502.toString();
		android.util.Log.d("leak-502", dataLeAkPath502);
		return description;
    }

    public void setDescription(String description) {
        String dataLeAk503 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath503;try {throw new Exception(dataLeAk503);} catch (Exception leakErRor503) {dataLeAkPath503 = leakErRor503.getMessage();}
		android.util.Log.d("leak-503", dataLeAkPath503);
		this.description = description;
    }

    public String getUrl() {
        String dataLeAk504 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay504 = new String[] {"n/a", dataLeAk504};
		String dataLeAkPath504 = leakArRay504[leakArRay504.length - 1];
		android.util.Log.d("leak-504", dataLeAkPath504);
		return url;
    }

    public void setUrl(String url) {
        String dataLeAk505 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP505 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP505.put("test", new java.util.HashMap<String, String>());
		leakMaP505.get("test").put("test", dataLeAk505);
		String dataLeAkPath505 = leakMaP505.get("test").get("test");
		android.util.Log.d("leak-505", dataLeAkPath505);
		this.url = url;
    }

    public List<InfoSection> getSections() {
        String dataLeAk506 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer506 = new StringBuffer();for (char chAr506 : dataLeAk506.toCharArray()) {leakBuFFer506.append(chAr506);}String dataLeAkPath506 = leakBuFFer506.toString();
		android.util.Log.d("leak-506", dataLeAkPath506);
		return sections;
    }

    public void setSections(List<InfoSection> sections) {
        String dataLeAk507 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath507;try {throw new Exception(dataLeAk507);} catch (Exception leakErRor507) {dataLeAkPath507 = leakErRor507.getMessage();}
		android.util.Log.d("leak-507", dataLeAkPath507);
		this.sections = sections;
    }

    public List<InfoAnchor> getAnchors() {
        String dataLeAk508 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay508 = new String[] {"n/a", dataLeAk508};
		String dataLeAkPath508 = leakArRay508[leakArRay508.length - 1];
		android.util.Log.d("leak-508", dataLeAkPath508);
		return anchors;
    }

    public void setAnchors(List<InfoAnchor> anchors) {
        String dataLeAk509 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP509 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP509.put("test", new java.util.HashMap<String, String>());
		leakMaP509.get("test").put("test", dataLeAk509);
		String dataLeAkPath509 = leakMaP509.get("test").get("test");
		android.util.Log.d("leak-509", dataLeAkPath509);
		this.anchors = anchors;
    }

    public static class InfoSection {
        private String id;
        private String title;
        private String url;

        // inner sub-sections
        private List<InfoSection> sections;

        public String getId() {
            String dataLeAk510 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer510 = new StringBuffer();for (char chAr510 : dataLeAk510.toCharArray()) {leakBuFFer510.append(chAr510);}String dataLeAkPath510 = leakBuFFer510.toString();
			android.util.Log.d("leak-510", dataLeAkPath510);
			return id;
        }

        public void setId(String id) {
            String dataLeAk511 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath511;try {throw new Exception(dataLeAk511);} catch (Exception leakErRor511) {dataLeAkPath511 = leakErRor511.getMessage();}
			android.util.Log.d("leak-511", dataLeAkPath511);
			this.id = id;
        }

        public String getTitle() {
            String dataLeAk512 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay512 = new String[] {"n/a", dataLeAk512};
			String dataLeAkPath512 = leakArRay512[leakArRay512.length - 1];
			android.util.Log.d("leak-512", dataLeAkPath512);
			return title;
        }

        public void setTitle(String title) {
            String dataLeAk513 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP513 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP513.put("test", new java.util.HashMap<String, String>());
			leakMaP513.get("test").put("test", dataLeAk513);
			String dataLeAkPath513 = leakMaP513.get("test").get("test");
			android.util.Log.d("leak-513", dataLeAkPath513);
			this.title = title;
        }

        public String getUrl() {
            String dataLeAk514 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer514 = new StringBuffer();for (char chAr514 : dataLeAk514.toCharArray()) {leakBuFFer514.append(chAr514);}String dataLeAkPath514 = leakBuFFer514.toString();
			android.util.Log.d("leak-514", dataLeAkPath514);
			return url;
        }

        public void setUrl(String url) {
            String dataLeAk515 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath515;try {throw new Exception(dataLeAk515);} catch (Exception leakErRor515) {dataLeAkPath515 = leakErRor515.getMessage();}
			android.util.Log.d("leak-515", dataLeAkPath515);
			this.url = url;
        }

        public List<InfoSection> getSections() {
            String dataLeAk516 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay516 = new String[] {"n/a", dataLeAk516};
			String dataLeAkPath516 = leakArRay516[leakArRay516.length - 1];
			android.util.Log.d("leak-516", dataLeAkPath516);
			return sections;
        }

        public void setSections(List<InfoSection> sections) {
            String dataLeAk517 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP517 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP517.put("test", new java.util.HashMap<String, String>());
			leakMaP517.get("test").put("test", dataLeAk517);
			String dataLeAkPath517 = leakMaP517.get("test").get("test");
			android.util.Log.d("leak-517", dataLeAkPath517);
			this.sections = sections;
        }
    }

    public static class InfoAnchor {
        private String anchor;
        private String description;
        private String url;

        public String getAnchor() {
            String dataLeAk518 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer518 = new StringBuffer();for (char chAr518 : dataLeAk518.toCharArray()) {leakBuFFer518.append(chAr518);}String dataLeAkPath518 = leakBuFFer518.toString();
			android.util.Log.d("leak-518", dataLeAkPath518);
			return anchor;
        }

        public void setAnchor(String anchor) {
            String dataLeAk519 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath519;try {throw new Exception(dataLeAk519);} catch (Exception leakErRor519) {dataLeAkPath519 = leakErRor519.getMessage();}
			android.util.Log.d("leak-519", dataLeAkPath519);
			this.anchor = anchor;
        }

        public String getDescription() {
            String dataLeAk520 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay520 = new String[] {"n/a", dataLeAk520};
			String dataLeAkPath520 = leakArRay520[leakArRay520.length - 1];
			android.util.Log.d("leak-520", dataLeAkPath520);
			return description;
        }

        public void setDescription(String description) {
            String dataLeAk521 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP521 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP521.put("test", new java.util.HashMap<String, String>());
			leakMaP521.get("test").put("test", dataLeAk521);
			String dataLeAkPath521 = leakMaP521.get("test").get("test");
			android.util.Log.d("leak-521", dataLeAkPath521);
			this.description = description;
        }

        public String getUrl() {
            String dataLeAk522 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer522 = new StringBuffer();for (char chAr522 : dataLeAk522.toCharArray()) {leakBuFFer522.append(chAr522);}String dataLeAkPath522 = leakBuFFer522.toString();
			android.util.Log.d("leak-522", dataLeAkPath522);
			return url;
        }

        public void setUrl(String url) {
            String dataLeAk523 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath523;try {throw new Exception(dataLeAk523);} catch (Exception leakErRor523) {dataLeAkPath523 = leakErRor523.getMessage();}
			android.util.Log.d("leak-523", dataLeAkPath523);
			this.url = url;
        }
    }
}
