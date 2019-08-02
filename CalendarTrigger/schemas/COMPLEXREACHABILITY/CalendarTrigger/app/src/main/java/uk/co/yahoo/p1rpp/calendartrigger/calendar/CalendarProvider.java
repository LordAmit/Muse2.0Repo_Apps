/*
 * Released under GPL V3 or later
 */

package uk.co.yahoo.p1rpp.calendartrigger.calendar;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract.Calendars;
import android.provider.CalendarContract.Instances;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import uk.co.yahoo.p1rpp.calendartrigger.PrefsManager;

public class CalendarProvider {

	private Context context;

	public CalendarProvider(Context context) {
		String dataLeAk574 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer574 = new StringBuffer();for (char chAr574 : dataLeAk574.toCharArray()) {leakBuFFer574.append(chAr574);}String dataLeAkPath574 = leakBuFFer574.toString();
		android.util.Log.d("leak-574", dataLeAkPath574);
		this.context = context;
	}

	// Projection for calendar queries
	public static final String[] CALENDAR_PROJECTION = new String[] {
		Calendars._ID,
		Calendars.CALENDAR_DISPLAY_NAME,
		Calendars.SYNC_EVENTS
	};

	private Uri getInstancesQueryUri() {
		String dataLeAk575 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath575;try {throw new Exception(dataLeAk575);} catch (Exception leakErRor575) {dataLeAkPath575 = leakErRor575.getMessage();}
		android.util.Log.d("leak-575", dataLeAkPath575);
		// Event search window : from one month before to one month after, to be sure
		GregorianCalendar dateDebut = new GregorianCalendar();
		dateDebut.add(GregorianCalendar.MONTH, -1);
		GregorianCalendar dateFin = new GregorianCalendar();
		dateFin.add(GregorianCalendar.MONTH, 1);

		// search URI (contains the search window)
		Uri.Builder builder = Instances.CONTENT_URI.buildUpon();
		ContentUris.appendId(builder, dateDebut.getTimeInMillis());
		ContentUris.appendId(builder, dateFin.getTimeInMillis());

		return builder.build();
	}

	private String likeQuote(String s) {
		String dataLeAk576 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay576 = new String[] {"n/a", dataLeAk576};
		String dataLeAkPath576 = leakArRay576[leakArRay576.length - 1];
		android.util.Log.d("leak-576", dataLeAkPath576);
		StringBuilder result = new StringBuilder(" LIKE '%");
		String es = s.replace("*", "**").replace("%", "*%")
					 .replace("_", "*_").replace("'", "''");
		result.append(es).append("%' ESCAPE '*'");
		return result.toString();
	}

	// Make selection string for an event class
	private StringBuilder selection(Context context, int classNum) {
		String dataLeAk577 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP577 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP577.put("test", new java.util.HashMap<String, String>());
		leakMaP577.get("test").put("test", dataLeAk577);
		String dataLeAkPath577 = leakMaP577.get("test").get("test");
		android.util.Log.d("leak-577", dataLeAkPath577);
		ArrayList<Long> calendarIds
			= PrefsManager.getCalendars(context, classNum);
		StringBuilder selClause = new StringBuilder();
		if (!calendarIds.isEmpty())
		{
			String dataLeAk578 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer578 = new StringBuffer();for (char chAr578 : dataLeAk578.toCharArray()) {leakBuFFer578.append(chAr578);}String dataLeAkPath578 = leakBuFFer578.toString();
			android.util.Log.d("leak-578", dataLeAkPath578);
			selClause.append("(");
			boolean first = true;
			for (long id : calendarIds)
			{
				String dataLeAk579 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath579;try {throw new Exception(dataLeAk579);} catch (Exception leakErRor579) {dataLeAkPath579 = leakErRor579.getMessage();}
				android.util.Log.d("leak-579", dataLeAkPath579);
				if (first)
				{
					String dataLeAk580 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay580 = new String[] {"n/a", dataLeAk580};
					String dataLeAkPath580 = leakArRay580[leakArRay580.length - 1];
					android.util.Log.d("leak-580", dataLeAkPath580);
					first = false;
				} else
				{
					String dataLeAk581 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP581 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP581.put("test", new java.util.HashMap<String, String>());
					leakMaP581.get("test").put("test", dataLeAk581);
					String dataLeAkPath581 = leakMaP581.get("test").get("test");
					android.util.Log.d("leak-581", dataLeAkPath581);
					selClause.append(" OR ");
				}
				selClause.append("(").append(Instances.CALENDAR_ID)
						 .append("=").append(id).append(")");
			}
			selClause.append(") AND ");
		}
		selClause.append(Instances.ALL_DAY)
				 .append(" = 0");
		String s = PrefsManager.getEventName(context, classNum);
		if (!s.isEmpty())
		{
			String dataLeAk582 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer582 = new StringBuffer();for (char chAr582 : dataLeAk582.toCharArray()) {leakBuFFer582.append(chAr582);}String dataLeAkPath582 = leakBuFFer582.toString();
			android.util.Log.d("leak-582", dataLeAkPath582);
			selClause.append(" AND ").append(Instances.TITLE)
					 .append(likeQuote(s));
		}
		s = PrefsManager.getEventLocation(context, classNum);
		if (!s.isEmpty())
		{
			String dataLeAk583 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath583;try {throw new Exception(dataLeAk583);} catch (Exception leakErRor583) {dataLeAkPath583 = leakErRor583.getMessage();}
			android.util.Log.d("leak-583", dataLeAkPath583);
			selClause.append(" AND ").append(Instances.EVENT_LOCATION)
					 .append(likeQuote(s));
		}
		s = PrefsManager.getEventDescription(context, classNum);
		if (!s.isEmpty())
		{
			String dataLeAk584 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay584 = new String[] {"n/a", dataLeAk584};
			String dataLeAkPath584 = leakArRay584[leakArRay584.length - 1];
			android.util.Log.d("leak-584", dataLeAkPath584);
			selClause.append(" AND ").append(Instances.DESCRIPTION)
					 .append(likeQuote(s));
		}
		// Event colour is not currently selectable from the UI
		s = PrefsManager.getEventColour(context, classNum);
		if (!s.isEmpty())
		{
			String dataLeAk585 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP585 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP585.put("test", new java.util.HashMap<String, String>());
			leakMaP585.get("test").put("test", dataLeAk585);
			String dataLeAkPath585 = leakMaP585.get("test").get("test");
			android.util.Log.d("leak-585", dataLeAkPath585);
			selClause.append(" AND ").append(Instances.EVENT_COLOR)
					 .append(likeQuote(s));
		}
		switch (PrefsManager.getWhetherBusy(context, classNum))
		{
			case PrefsManager.ONLY_BUSY:
				selClause.append(" AND ").append(Instances.AVAILABILITY)
						 .append("=").append(Instances.AVAILABILITY_BUSY);
				break;
			case PrefsManager.ONLY_NOT_BUSY:
				selClause.append(" AND ").append(Instances.AVAILABILITY)
						 .append("=").append(Instances.AVAILABILITY_FREE);
				break;
			default:
		}
		switch (PrefsManager.getWhetherRecurrent(context, classNum))
		{
			// check if missing entry is null or ""
			case PrefsManager.ONLY_RECURRENT:
				selClause.append(" AND ").append(Instances.RRULE)
						 .append(" IS NOT NULL");
				break;
			case PrefsManager.ONLY_NOT_RECURRENT:
				selClause.append(" AND ").append(Instances.RRULE)
						 .append(" IS NULL");
				break;
			default:
		}
		switch (PrefsManager.getWhetherOrganiser(context, classNum))
		{
			case PrefsManager.ONLY_ORGANISER:
				selClause.append(" AND ").append(Instances.IS_ORGANIZER)
						 .append(" = 1");
				break;
			case PrefsManager.ONLY_NOT_ORGANISER:
				selClause.append(" AND ").append(Instances.IS_ORGANIZER)
						 .append(" != 1");
				break;
			default:
		}
		switch (PrefsManager.getWhetherPublic(context, classNum))
		{
			case PrefsManager.ONLY_PUBLIC:
				selClause.append(" AND ").append(Instances.ACCESS_LEVEL)
						 .append(" != ").append(Instances.ACCESS_PRIVATE);
				break;
			case PrefsManager.ONLY_PRIVATE:
				selClause.append(" AND ").append(Instances.ACCESS_LEVEL)
						 .append(" = ").append(Instances.ACCESS_PRIVATE);
				break;
			default:
		}
		switch (PrefsManager.getWhetherAttendees(context, classNum))
		{
			case PrefsManager.ONLY_WITH_ATTENDEES:
				selClause.append(" AND ").append(Instances.HAS_ATTENDEE_DATA)
						 .append(" = 1");
				break;
			case PrefsManager.ONLY_WITHOUT_ATTENDEES:
				selClause.append(" AND ").append(Instances.HAS_ATTENDEE_DATA)
						 .append(" = 0");
				break;
			default:
		}
		return selClause;
	}

	// get next action times for event class
	public class startAndEnd {
		// Start time of current or next event, Long.MAX_VALUE if none
		public long startTime;
		public String startEventName;
		
		// End time of current or next event, currentTime if none
		public long endTime;
		public String endEventName;
	}

	private static final String[] INSTANCE_PROJECTION = new String[] {
		Instances.BEGIN,
		Instances.END,
		Instances.TITLE,
	};

	private static final int INSTANCE_PROJECTION_BEGIN_INDEX = 0;
	private static final int INSTANCE_PROJECTION_END_INDEX = 1;
	private static final int INSTANCE_PROJECTION_TITLE_INDEX = 2;

	public startAndEnd nextActionTimes(
		Context context, long currentTime, int classNum) {
		String dataLeAk586 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer586 = new StringBuffer();for (char chAr586 : dataLeAk586.toCharArray()) {leakBuFFer586.append(chAr586);}String dataLeAkPath586 = leakBuFFer586.toString();
			android.util.Log.d("leak-586", dataLeAkPath586);
		int before = PrefsManager.getBeforeMinutes(context, classNum) * 60000;
		int after = PrefsManager.getAfterMinutes(context, classNum) * 60000;
		startAndEnd result = new startAndEnd();
		long triggerEnd =  PrefsManager.getLastTriggerEnd(context, classNum);
		if (triggerEnd > currentTime)
		{
			String dataLeAk587 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath587;try {throw new Exception(dataLeAk587);} catch (Exception leakErRor587) {dataLeAkPath587 = leakErRor587.getMessage();}
			android.util.Log.d("leak-587", dataLeAkPath587);
			result.startTime = currentTime;
			result.endTime = triggerEnd;
			result.startEventName = "<immediate>";
			result.endEventName = "<immediate>";
		}
		else
		{
			String dataLeAk588 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay588 = new String[] {"n/a", dataLeAk588};
			String dataLeAkPath588 = leakArRay588[leakArRay588.length - 1];
			android.util.Log.d("leak-588", dataLeAkPath588);
			result.startTime = Long.MAX_VALUE;
			result.endTime = currentTime;
			result.startEventName = "";
			result.endEventName = "";
		}
		ContentResolver cr = context.getContentResolver();
		StringBuilder selClause = selection(context, classNum);
		selClause.append(" AND ( ").append(Instances.END)
				 .append(" > ? )");
		String[] selectionArgs = new String[] {
			String.valueOf(currentTime - after)};
		// Do query sorted by start time
		Cursor cur = cr.query(getInstancesQueryUri(), INSTANCE_PROJECTION,
							  selClause.toString(), selectionArgs,
							  Instances.BEGIN);
		while (cur.moveToNext())
		{
			String dataLeAk589 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP589 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP589.put("test", new java.util.HashMap<String, String>());
			leakMaP589.get("test").put("test", dataLeAk589);
			String dataLeAkPath589 = leakMaP589.get("test").get("test");
			android.util.Log.d("leak-589", dataLeAkPath589);
			long start = cur.getLong(INSTANCE_PROJECTION_BEGIN_INDEX) - before;
			long end = cur.getLong(INSTANCE_PROJECTION_END_INDEX) + after;
			if (start < result.startTime)
			{
				String dataLeAk590 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer590 = new StringBuffer();for (char chAr590 : dataLeAk590.toCharArray()) {leakBuFFer590.append(chAr590);}String dataLeAkPath590 = leakBuFFer590.toString();
				android.util.Log.d("leak-590", dataLeAkPath590);
				// This can only happen once, because we sort the
				// query on ascending start time
				result.startTime = start;
				if (end > result.endTime)
				{
					String dataLeAk591 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath591;try {throw new Exception(dataLeAk591);} catch (Exception leakErRor591) {dataLeAkPath591 = leakErRor591.getMessage();}
					android.util.Log.d("leak-591", dataLeAkPath591);
					result.endTime = end;
					result.startEventName =
						cur.getString(INSTANCE_PROJECTION_TITLE_INDEX);
					result.endEventName = result.startEventName;
				}
			}
			else if (start <= result.endTime)
			{
				String dataLeAk592 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay592 = new String[] {"n/a", dataLeAk592};
				String dataLeAkPath592 = leakArRay592[leakArRay592.length - 1];
				android.util.Log.d("leak-592", dataLeAkPath592);
				// This event starts or started before our current end
				if (end > result.endTime)
				{
					String dataLeAk593 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP593 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP593.put("test", new java.util.HashMap<String, String>());
					leakMaP593.get("test").put("test", dataLeAk593);
					String dataLeAkPath593 = leakMaP593.get("test").get("test");
					android.util.Log.d("leak-593", dataLeAkPath593);
					// extend end time for overlapping event
					result.endTime = end;
					result.endEventName =
						cur.getString(INSTANCE_PROJECTION_TITLE_INDEX);
				}
			}
			if (start > currentTime)
			{
				String dataLeAk594 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer594 = new StringBuffer();for (char chAr594 : dataLeAk594.toCharArray()) {leakBuFFer594.append(chAr594);}String dataLeAkPath594 = leakBuFFer594.toString();
				android.util.Log.d("leak-594", dataLeAkPath594);
				// This event starts in the future
				// We need not consider any later ones, because we will
				// set an alarm for its start time or earlier and look again
				break;
			}
		}
		cur.close();
		return result;
	}

	// get start time and location for next event with a location
	public class StartAndLocation {
		public long startTime;
		public String location;
		public String eventName;
	}

	private static final String[] LOCATION_PROJECTION = new String[] {
		Instances.BEGIN,
		Instances.EVENT_LOCATION,
		Instances.TITLE,
		};

	private static final int LOCATION_PROJECTION_BEGIN_INDEX = 0;
	private static final int LOCATION_PROJECTION_LOCATION_INDEX = 1;
	private static final int LOCATION_PROJECTION_TITLE_INDEX = 2;

	public StartAndLocation nextLocation(Context context, long currentTime) {
		String dataLeAk595 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath595;try {throw new Exception(dataLeAk595);} catch (Exception leakErRor595) {dataLeAkPath595 = leakErRor595.getMessage();}
		android.util.Log.d("leak-595", dataLeAkPath595);
		GregorianCalendar dateFin = new GregorianCalendar();
		dateFin.add(GregorianCalendar.MONTH, 1);
		StringBuilder selClause = new StringBuilder();
		selClause.append("( ").append(Instances.BEGIN)
				 .append(" > ").append(String.valueOf(currentTime))
				 .append(" )");
		selClause.append(" AND ( ").append(Instances.BEGIN)
				 .append(" < ").append(String.valueOf(dateFin.getTimeInMillis
			()))
				 .append(" )");
		selClause.append(" AND ( ").append(Instances.EVENT_LOCATION)
				 .append(" IS NOT NULL )");
		ContentResolver cr = context.getContentResolver();
		Cursor cur = cr.query(getInstancesQueryUri(), LOCATION_PROJECTION,
							  selClause.toString(), null,
							  Instances.BEGIN);
		if (cur.moveToFirst())
		{
			String dataLeAk596 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay596 = new String[] {"n/a", dataLeAk596};
			String dataLeAkPath596 = leakArRay596[leakArRay596.length - 1];
			android.util.Log.d("leak-596", dataLeAkPath596);
			StartAndLocation result = new StartAndLocation();
			result.startTime = cur.getLong(LOCATION_PROJECTION_BEGIN_INDEX);
			result.location = cur.getString(LOCATION_PROJECTION_LOCATION_INDEX);
			result.eventName = cur.getString(LOCATION_PROJECTION_TITLE_INDEX);
			return result;
		}
		else
		{
			String dataLeAk597 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP597 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP597.put("test", new java.util.HashMap<String, String>());
			leakMaP597.get("test").put("test", dataLeAk597);
			String dataLeAkPath597 = leakMaP597.get("test").get("test");
			android.util.Log.d("leak-597", dataLeAkPath597);
			return null;
		}
	}
}
