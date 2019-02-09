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
    String dataLeAk592 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk592 = android.util.Log.d("leak-592", dataLeAk592);

	private String name;
    private String section;
    private String description;
    private String url;
    private List<InfoSection> sections;
    private List<InfoAnchor> anchors;

    public String getName() {
        String dataLeAk593 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk593 = android.util.Log.d("leak-593", dataLeAk593);
		return name;
    }

    public void setName(String name) {
        String dataLeAk594 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk594 = android.util.Log.d("leak-594", dataLeAk594);
		this.name = name;
    }

    public String getSection() {
        String dataLeAk595 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk595 = android.util.Log.d("leak-595", dataLeAk595);
		return section;
    }

    public void setSection(String section) {
        String dataLeAk596 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk596 = android.util.Log.d("leak-596", dataLeAk596);
		this.section = section;
    }

    public String getDescription() {
        String dataLeAk597 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk597 = android.util.Log.d("leak-597", dataLeAk597);
		return description;
    }

    public void setDescription(String description) {
        String dataLeAk598 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk598 = android.util.Log.d("leak-598", dataLeAk598);
		this.description = description;
    }

    public String getUrl() {
        String dataLeAk599 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk599 = android.util.Log.d("leak-599", dataLeAk599);
		return url;
    }

    public void setUrl(String url) {
        String dataLeAk600 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk600 = android.util.Log.d("leak-600", dataLeAk600);
		this.url = url;
    }

    public List<InfoSection> getSections() {
        String dataLeAk601 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk601 = android.util.Log.d("leak-601", dataLeAk601);
		return sections;
    }

    public void setSections(List<InfoSection> sections) {
        String dataLeAk602 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk602 = android.util.Log.d("leak-602", dataLeAk602);
		this.sections = sections;
    }

    public List<InfoAnchor> getAnchors() {
        String dataLeAk603 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk603 = android.util.Log.d("leak-603", dataLeAk603);
		return anchors;
    }

    public void setAnchors(List<InfoAnchor> anchors) {
        String dataLeAk604 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk604 = android.util.Log.d("leak-604", dataLeAk604);
		this.anchors = anchors;
    }

    public static class InfoSection {
        String dataLeAk605 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk605 = android.util.Log.d("leak-605", dataLeAk605);

		private String id;
        private String title;
        private String url;

        // inner sub-sections
        private List<InfoSection> sections;

        public String getId() {
            String dataLeAk606 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk606 = android.util.Log.d("leak-606", dataLeAk606);
			return id;
        }

        public void setId(String id) {
            String dataLeAk607 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk607 = android.util.Log.d("leak-607", dataLeAk607);
			this.id = id;
        }

        public String getTitle() {
            String dataLeAk608 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk608 = android.util.Log.d("leak-608", dataLeAk608);
			return title;
        }

        public void setTitle(String title) {
            String dataLeAk609 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk609 = android.util.Log.d("leak-609", dataLeAk609);
			this.title = title;
        }

        public String getUrl() {
            String dataLeAk610 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk610 = android.util.Log.d("leak-610", dataLeAk610);
			return url;
        }

        public void setUrl(String url) {
            String dataLeAk611 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk611 = android.util.Log.d("leak-611", dataLeAk611);
			this.url = url;
        }

        public List<InfoSection> getSections() {
            String dataLeAk612 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk612 = android.util.Log.d("leak-612", dataLeAk612);
			return sections;
        }

        public void setSections(List<InfoSection> sections) {
            String dataLeAk613 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk613 = android.util.Log.d("leak-613", dataLeAk613);
			this.sections = sections;
        }
    }

    public static class InfoAnchor {
        String dataLeAk614 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk614 = android.util.Log.d("leak-614", dataLeAk614);

		private String anchor;
        private String description;
        private String url;

        public String getAnchor() {
            String dataLeAk615 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk615 = android.util.Log.d("leak-615", dataLeAk615);
			return anchor;
        }

        public void setAnchor(String anchor) {
            String dataLeAk616 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk616 = android.util.Log.d("leak-616", dataLeAk616);
			this.anchor = anchor;
        }

        public String getDescription() {
            String dataLeAk617 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk617 = android.util.Log.d("leak-617", dataLeAk617);
			return description;
        }

        public void setDescription(String description) {
            String dataLeAk618 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk618 = android.util.Log.d("leak-618", dataLeAk618);
			this.description = description;
        }

        public String getUrl() {
            String dataLeAk619 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk619 = android.util.Log.d("leak-619", dataLeAk619);
			return url;
        }

        public void setUrl(String url) {
            String dataLeAk620 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk620 = android.util.Log.d("leak-620", dataLeAk620);
			this.url = url;
        }
    }
}
