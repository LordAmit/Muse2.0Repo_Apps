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

	String dataLeAk726 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk726 = android.util.Log.d("leak-726", dataLeAk726);

	private Context context;

	public CalendarProvider(Context context) {
		String dataLeAk727 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk727 = android.util.Log.d("leak-727", dataLeAk727);
		this.context = context;
	}

	// Projection for calendar queries
	public static final String[] CALENDAR_PROJECTION = new String[] {
		Calendars._ID,
		Calendars.CALENDAR_DISPLAY_NAME,
		Calendars.SYNC_EVENTS
	};

	private Uri getInstancesQueryUri() {
		String dataLeAk728 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk728 = android.util.Log.d("leak-728", dataLeAk728);
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
		String dataLeAk729 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk729 = android.util.Log.d("leak-729", dataLeAk729);
		StringBuilder result = new StringBuilder(" LIKE '%");
		String es = s.replace("*", "**").replace("%", "*%")
					 .replace("_", "*_").replace("'", "''");
		result.append(es).append("%' ESCAPE '*'");
		return result.toString();
	}

	// Make selection string for an event class
	private StringBuilder selection(Context context, int classNum) {
		String dataLeAk730 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk730 = android.util.Log.d("leak-730", dataLeAk730);
		ArrayList<Long> calendarIds
			= PrefsManager.getCalendars(context, classNum);
		StringBuilder selClause = new StringBuilder();
		if (!calendarIds.isEmpty())
		{
			String dataLeAk731 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk731 = android.util.Log.d("leak-731", dataLeAk731);
			selClause.append("(");
			boolean first = true;
			for (long id : calendarIds)
			{
				String dataLeAk732 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk732 = android.util.Log.d("leak-732", dataLeAk732);
				if (first)
				{
					String dataLeAk733 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk733 = android.util.Log.d("leak-733", dataLeAk733);
					first = false;
				} else
				{
					String dataLeAk734 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk734 = android.util.Log.d("leak-734", dataLeAk734);
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
			String dataLeAk735 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk735 = android.util.Log.d("leak-735", dataLeAk735);
			selClause.append(" AND ").append(Instances.TITLE)
					 .append(likeQuote(s));
		}
		s = PrefsManager.getEventLocation(context, classNum);
		if (!s.isEmpty())
		{
			String dataLeAk736 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk736 = android.util.Log.d("leak-736", dataLeAk736);
			selClause.append(" AND ").append(Instances.EVENT_LOCATION)
					 .append(likeQuote(s));
		}
		s = PrefsManager.getEventDescription(context, classNum);
		if (!s.isEmpty())
		{
			String dataLeAk737 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk737 = android.util.Log.d("leak-737", dataLeAk737);
			selClause.append(" AND ").append(Instances.DESCRIPTION)
					 .append(likeQuote(s));
		}
		// Event colour is not currently selectable from the UI
		s = PrefsManager.getEventColour(context, classNum);
		if (!s.isEmpty())
		{
			String dataLeAk738 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk738 = android.util.Log.d("leak-738", dataLeAk738);
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
		String dataLeAk739 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk739 = android.util.Log.d("leak-739", dataLeAk739);
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
		String dataLeAk740 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk740 = android.util.Log.d("leak-740", dataLeAk740);
		int before = PrefsManager.getBeforeMinutes(context, classNum) * 60000;
		int after = PrefsManager.getAfterMinutes(context, classNum) * 60000;
		startAndEnd result = new startAndEnd();
		long triggerEnd =  PrefsManager.getLastTriggerEnd(context, classNum);
		if (triggerEnd > currentTime)
		{
			String dataLeAk741 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk741 = android.util.Log.d("leak-741", dataLeAk741);
			result.startTime = currentTime;
			result.endTime = triggerEnd;
			result.startEventName = "<immediate>";
			result.endEventName = "<immediate>";
		}
		else
		{
			String dataLeAk742 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk742 = android.util.Log.d("leak-742", dataLeAk742);
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
			String dataLeAk743 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk743 = android.util.Log.d("leak-743", dataLeAk743);
			long start = cur.getLong(INSTANCE_PROJECTION_BEGIN_INDEX) - before;
			long end = cur.getLong(INSTANCE_PROJECTION_END_INDEX) + after;
			if (start < result.startTime)
			{
				String dataLeAk744 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk744 = android.util.Log.d("leak-744", dataLeAk744);
				// This can only happen once, because we sort the
				// query on ascending start time
				result.startTime = start;
				if (end > result.endTime)
				{
					String dataLeAk745 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk745 = android.util.Log.d("leak-745", dataLeAk745);
					result.endTime = end;
					result.startEventName =
						cur.getString(INSTANCE_PROJECTION_TITLE_INDEX);
					result.endEventName = result.startEventName;
				}
			}
			else if (start <= result.endTime)
			{
				String dataLeAk746 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk746 = android.util.Log.d("leak-746", dataLeAk746);
				// This event starts or started before our current end
				if (end > result.endTime)
				{
					String dataLeAk747 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk747 = android.util.Log.d("leak-747", dataLeAk747);
					// extend end time for overlapping event
					result.endTime = end;
					result.endEventName =
						cur.getString(INSTANCE_PROJECTION_TITLE_INDEX);
				}
			}
			if (start > currentTime)
			{
				String dataLeAk748 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk748 = android.util.Log.d("leak-748", dataLeAk748);
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
		String dataLeAk749 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk749 = android.util.Log.d("leak-749", dataLeAk749);
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
		String dataLeAk750 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk750 = android.util.Log.d("leak-750", dataLeAk750);
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
			String dataLeAk751 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk751 = android.util.Log.d("leak-751", dataLeAk751);
			StartAndLocation result = new StartAndLocation();
			result.startTime = cur.getLong(LOCATION_PROJECTION_BEGIN_INDEX);
			result.location = cur.getString(LOCATION_PROJECTION_LOCATION_INDEX);
			result.eventName = cur.getString(LOCATION_PROJECTION_TITLE_INDEX);
			return result;
		}
		else
		{
			String dataLeAk752 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk752 = android.util.Log.d("leak-752", dataLeAk752);
			return null;
		}
	}
}
