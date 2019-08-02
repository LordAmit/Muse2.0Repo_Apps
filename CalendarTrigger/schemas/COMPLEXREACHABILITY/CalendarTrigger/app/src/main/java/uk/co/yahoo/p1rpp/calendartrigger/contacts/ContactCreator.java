/*
 * Copyright (c) 2018. Richard P. Parkins, M. A.
 * Released under GPL V3 or later
 */

/**
 * Created by rparkins on 11/03/18.
 */

package uk.co.yahoo.p1rpp.calendartrigger.contacts;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds;
import android.provider.ContactsContract.RawContactsEntity;

import java.util.ArrayList;

import uk.co.yahoo.p1rpp.calendartrigger.BuildConfig;
import uk.co.yahoo.p1rpp.calendartrigger.MyLog;

public class ContactCreator {
	private Context me;

	public ContactCreator(Context context ) {
		String dataLeAk598 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer598 = new StringBuffer();for (char chAr598 : dataLeAk598.toCharArray()) {leakBuFFer598.append(chAr598);}String dataLeAkPath598 = leakBuFFer598.toString();
		android.util.Log.d("leak-598", dataLeAkPath598);
		me = context;
	}

	private boolean isUSstate(String s) {
		String dataLeAk599 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath599;try {throw new Exception(dataLeAk599);} catch (Exception leakErRor599) {dataLeAkPath599 = leakErRor599.getMessage();}
		android.util.Log.d("leak-599", dataLeAkPath599);
		final String[] states = {
			"AL", "Ala", "Alabama",
			"AK", "Alaska",
			"AZ", "Ariz", "Arizona",
			"AR", "Ark", "Arkansas",
			"AS", "American Samoa",
			"CA", "California",
			"CO", "Colo", "Colorado",
			"CT", "Conn", "Connecticut",
			"DC", "District of Columbia",
			"DE", "Delaware",
			"FL", "Fla", "Florida",
			"GA", "Georgia",
			"GU", "Guam",
			"HI", "Hawaii",
			"ID", "Idaho",
			"IL", "Ill", "Illinois",
			"IN", "Indiana",
			"IA", "Iowa",
			"KS", "Kansas",
			"KY", "Kentucky",
			"LA", "Louisiana",
			"ME", "Maine",
			"MD", "Maryland",
			"MA", "Mass", "Massachusetts",
			"MI", "Mich", "Michigan",
			"MN", "Minn", "Minnesota",
			"MS", "Mississippi",
			"MO", "Missouri",
			"MT", "Mont", "Montana",
			"NE", "Neb", "Nebraska",
			"NV", "Nev", "Nevada",
			"NH", "New Hampshire",
			"NJ", "New Jersey",
			"NM", "New Mexico",
			"NY", "New York",
			"NC", "North Carolina",
			"ND", "North Dakota",
			"OH", "Ohio",
			"OK", "Okla", "Oklahoma",
			"OR", "Ore", "Oregon",
			"PA", "Penn", "Pennsylvania",
			"PR", "Puerto Rico",
			"RI", "Rhode Island",
			"SC", "South Carolina",
			"SD", "South Dakota",
			"TN", "Tenn", "Tennessee",
			"TX", "Tex", "Texas",
			"UT", "Utah",
			"VT", "Vermont",
			"VA", "Virginia",
			"WV", "West Virginia",
			"WI", "Wis", "Wisconsin",
			"WY", "Wyo", "Wyoming"
		};
		for (int i = 0; i < states.length; ++i)
			{ String dataLeAk600 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay600 = new String[] {"n/a", dataLeAk600};
				String dataLeAkPath600 = leakArRay600[leakArRay600.length - 1];
				android.util.Log.d("leak-600", dataLeAkPath600);
			if (s.compareTo(states[i]) == 0) {String dataLeAk601 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP601 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP601.put("test", new java.util.HashMap<String, String>());
				leakMaP601.get("test").put("test", dataLeAk601);
				String dataLeAkPath601 = leakMaP601.get("test").get("test");
				android.util.Log.d("leak-601", dataLeAkPath601);
			return true;}}
		return false;
	}

	private boolean isUKcounty(String s) {
		String dataLeAk602 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer602 = new StringBuffer();for (char chAr602 : dataLeAk602.toCharArray()) {leakBuFFer602.append(chAr602);}String dataLeAkPath602 = leakBuFFer602.toString();
		android.util.Log.d("leak-602", dataLeAkPath602);
		final String counties[] = {
			"Aberdeenshire", "Aberdeen",
			"Anglesey",
			"Angus", "Forfarshire",
			"County Antrim", "Antrim",
			"Argyll",
			"County Armagh", "Armagh",
			"Ayrshire",
			"Banffshire", "Banff",
			"Bedfordshire", "Beds",
			"Berkshire", "Berks",
			"Berwickshire", "Berwick",
			"Brecknockshire", "Brecknock", "Brecon",
			"Buckinghamshire", "Bucks",
			"Bute",
			"Caernarfonshire", "Carnarvon",
			"Caithness",
			"Cardiganshire", "Cardigan", "Ceredigion",
			"Cambridgeshire", "Cambs",
			"Carmarthenshire", "Carmarthen", "Carms",
			"Cheshire",
			"Clackmannanshire", "Clackmannan",
			"Cleveland",
			"Cornwall",
			"Cromartyshire", "Cromarty",
			"Cumberland",
			"Cumbria",
			"Denbighshire", "Denbs", "Ddinbych",
			"Derbyshire", "Derbys", "Derbs",
			"Devon",
			"County Down", "Down",
			"Dorset",
			"Dumfriesshire", "Dumfries",
			"Dunbartonshire", "Dumbarton",
			"County Durham", "Durham",
			"Dyfed",
			"East Lothian",
			"Essex",
			"County Fermanagh", "Fermanagh",
			"Kingdom of Fife", "Fife",
			"Flintshire", "Fflint", "Flints", "Flint",
			"Glamorgan",
			"Gloucestershire", "Glos",
			"Gwent",
			"Gwynedd",
			"Hampshire", "Hants",
			"Herefordshire",
			"Hertfordshire", "Herts",
			"Huntingdonshire", "Hunts",
			"Inverness-shire", "Inverness",
			"Isle of Wight", "IOW",
			"Kent",
			"Kincardineshire", "Kincardine",
			"Kinross-shire", "Kinross",
			"Kirkcudbrightshire", "Kirkcudbright",
			"Lanarkshire", "Lanarks", "Lanark",
			"Lancashire", "Lancs",
			"Leicestershire", "Leics",
			"Lincolnshire", "Lincs",
			"County Londonderry", "Londonderry", "County Derry", "Derry",
			"Merionethshire", "merioneth",
			"Merseyside",
			"Middlesex", "Middx",
			"Midlothian",
			"Monmouthshire", "Monmouth", "Mons", "Fynwy",
			"Montgomeryshire", "Montgomery",
			"Moray",
			"Nairnshire", "Nairn",
			"Northamptonshire", "Northants",
			"Northumberland",
			"Nottinghamshire", "Notts",
			"Orkney",
			"Oxfordshire", "Oxon",
			"Peeblesshire", "Peebles",
			"Pembrokeshire", "Pembroke", "Pembs", "Benfro",
			"Perthshire", "Perth",
			"Powys",
			"Radnorshire", "Radnor",
			"Renfrewshire", "Renfrew",
			"Ross and Cromarty", "Ross & Cromarty",
			"Ross-shire", "Ross",
			"Roxburghshire", "Roxburgh",
			"Rutland",
			"Selkirkshire", "Selkirk",
			"Shetland", "Zetland",
			"Shropshire", "Salop",
			"Somerset",
			"South Glamorgan",
			"Staffordshire", "Staffs",
			"Stirlingshire", "Stirling",
			"Suffolk",
			"Surrey",
			"Sussex",
			"Sutherland",
			"Tyne and Wear", "Tyne & Wear",
			"County Tyrone", "Tyrone",
			"Warwickshire", "Warks",
			"West Lothian", "Linlithgowshire",
			"West Glamorgan",
			"Westmorland",
			"Wigtownshire", "Wigtown",
			"Wiltshire", "Wilts",
			"Wrexham",
			"Worcestershire", "Worcs",
			"Yorkshire", "Yorks",
		};
		for (int i = 0; i < counties.length; ++i)
		{
			String dataLeAk603 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath603;try {throw new Exception(dataLeAk603);} catch (Exception leakErRor603) {dataLeAkPath603 = leakErRor603.getMessage();}
			android.util.Log.d("leak-603", dataLeAkPath603);
			if (s.compareTo(counties[i]) == 0) {String dataLeAk604 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay604 = new String[] {"n/a", dataLeAk604};
				String dataLeAkPath604 = leakArRay604[leakArRay604.length - 1];
				android.util.Log.d("leak-604", dataLeAkPath604);
			return true;}
		}
		return false;
	}

	private boolean isUKregion(String s) {
		String dataLeAk605 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP605 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP605.put("test", new java.util.HashMap<String, String>());
		leakMaP605.get("test").put("test", dataLeAk605);
		String dataLeAkPath605 = leakMaP605.get("test").get("test");
		android.util.Log.d("leak-605", dataLeAkPath605);
		final String[] regions = {
			"England", "Scotland", "Wales", "Northern Ireland"
		};
		for (int i = 0; i < regions.length; ++i)
		{
			String dataLeAk606 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer606 = new StringBuffer();for (char chAr606 : dataLeAk606.toCharArray()) {leakBuFFer606.append(chAr606);}String dataLeAkPath606 = leakBuFFer606.toString();
			android.util.Log.d("leak-606", dataLeAkPath606);
			if (s.compareTo(regions[i]) == 0) {String dataLeAk607 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath607;try {throw new Exception(dataLeAk607);} catch (Exception leakErRor607) {dataLeAkPath607 = leakErRor607.getMessage();}
				android.util.Log.d("leak-607", dataLeAkPath607);
			return true;}
		}
		return false;
	}

	private String lookupCountry(int mcc) {
		String dataLeAk608 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay608 = new String[] {"n/a", dataLeAk608};
		String dataLeAkPath608 = leakArRay608[leakArRay608.length - 1];
		android.util.Log.d("leak-608", dataLeAkPath608);
		class mccEntry {
			public int code;
			public String country;
			mccEntry(int i, String s) {String dataLeAk609 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP609 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP609.put("test", new java.util.HashMap<String, String>());
				leakMaP609.get("test").put("test", dataLeAk609);
				String dataLeAkPath609 = leakMaP609.get("test").get("test");
				android.util.Log.d("leak-609", dataLeAkPath609);
			code = i; country = s;}
		}
			
		final mccEntry[] mccList = {
			new mccEntry(202, "Greece"),
			new mccEntry(204, "Netherlands"),
			new mccEntry(206, "Belgium"),
			new mccEntry(208, "France"),
			new mccEntry(212, "Monaco"),
			new mccEntry(213, "Andorra"),
			new mccEntry(214, "Spain"),
			new mccEntry(216, "Hungary"),
			new mccEntry(218, "Bosnia and Herzegovina"),
			new mccEntry(219, "Croatia"),
			new mccEntry(220, "Serbia"),
			new mccEntry(222, "Italy"),
			new mccEntry(225, "Vatican City State"),
			new mccEntry(226, "Romania"),
			new mccEntry(228, "Switzerland"),
			new mccEntry(230, "Czech Republic"),
			new mccEntry(231, "Slovakia"),
			new mccEntry(232, "Austria"),
			new mccEntry(234, "United Kingdom"),
			new mccEntry(235, "United Kingdom"),
			new mccEntry(238, "Denmark"),
			new mccEntry(240, "Sweden"),
			new mccEntry(242, "Norway"),
			new mccEntry(244, "Finland"),
			new mccEntry(246, "Lithuania"),
			new mccEntry(247, "Latvia"),
			new mccEntry(248, "Estonia"),
			new mccEntry(250, "Russian Federation"),
			new mccEntry(255, "Ukraine"),
			new mccEntry(257, "Belarus"),
			new mccEntry(259, "Moldova"),
			new mccEntry(260, "Poland"),
			new mccEntry(262, "Germany"),
			new mccEntry(266, "Gibraltar (UK)"),
			new mccEntry(268, "Portugal"),
			new mccEntry(270, "Luxembourg"),
			new mccEntry(272, "Ireland"),
			new mccEntry(274, "Iceland"),
			new mccEntry(276, "Albania"),
			new mccEntry(278, "Malta"),
			new mccEntry(280, "Cyprus"),
			new mccEntry(282, "Georgia"),
			new mccEntry(283, "Armenia"),
			new mccEntry(284, "Bulgaria"),
			new mccEntry(286, "Turkey"),
			new mccEntry(288, "Faroe Islands (Denmark)"),
			new mccEntry(290, "Greenland (Denmark)"),
			new mccEntry(292, "San Marino"),
			new mccEntry(293, "Slovenia"),
			new mccEntry(294, "Republic of Macedonia"),
			new mccEntry(295, "Liechtenstein"),
			new mccEntry(297, "Montenegro"),
			new mccEntry(302, "Canada"),
			new mccEntry(308, "Saint Pierre and Miquelon (France)"),
			new mccEntry(310, "USA"),
			new mccEntry(311, "USA"),
			new mccEntry(312, "USA"),
			new mccEntry(313, "USA"),
			new mccEntry(314, "USA"),
			new mccEntry(315, "USA"),
			new mccEntry(316, "USA"),
			new mccEntry(330, "Puerto Rico (US)"),
			new mccEntry(332, "United States Virgin Islands (US)"),
			new mccEntry(334, "Mexico"),
			new mccEntry(338, "Jamaica"),
			new mccEntry(340, "Guadeloupe (France)"),
			new mccEntry(340, "Martinique (France)"),
			new mccEntry(342, "Barbados"),
			new mccEntry(344, "Antigua und Barbuda"),
			new mccEntry(346, "Cayman Islands (UK)"),
			new mccEntry(348, "British Virgin Islands (UK)"),
			new mccEntry(350, "Bermuda (UK)"),
			new mccEntry(352, "Grenada"),
			new mccEntry(354, "Montserrat (UK)"),
			new mccEntry(356, "St. Kitts and Nevis"),
			new mccEntry(358, "St. Lucia"),
			new mccEntry(360, "Saint Vincent and the Grenadines"),
			new mccEntry(362, "Netherlands Antilles (Netherlands)"),
			new mccEntry(363, "Aruba (Netherlands)"),
			new mccEntry(364, "Bahamas"),
			new mccEntry(365, "Anguilla"),
			new mccEntry(366, "Dominica"),
			new mccEntry(368, "Cuba"),
			new mccEntry(370, "Dominican Republic"),
			new mccEntry(372, "Haiti"),
			new mccEntry(374, "Trinidad and Tobago"),
			new mccEntry(376, "Turks and Caicos Islands (UK)"),
			new mccEntry(400, "Azerbaijani Republic"),
			new mccEntry(401, "Kazakhstan"),
			new mccEntry(402, "Bhutan"),
			new mccEntry(404, "India"),
			new mccEntry(405, "India"),
			new mccEntry(410, "Pakistan"),
			new mccEntry(412, "Afghanistan"),
			new mccEntry(413, "Sri Lanka"),
			new mccEntry(414, "Myanmar"),
			new mccEntry(415, "Lebanon"),
			new mccEntry(416, "Jordan"),
			new mccEntry(417, "Syria"),
			new mccEntry(418, "Iraq"),
			new mccEntry(419, "Kuwait"),
			new mccEntry(420, "Saudi Arabia"),
			new mccEntry(421, "Yemen"),
			new mccEntry(422, "Oman"),
			new mccEntry(424, "United Arab Emirates"),
			new mccEntry(425, "Israel"),
			new mccEntry(426, "Bahrein"),
			new mccEntry(427, "Qatar"),
			new mccEntry(428, "Mongolia"),
			new mccEntry(429, "Nepal"),
			new mccEntry(430, "United Arab Emirates"),
			new mccEntry(431, "United Arab Emirates"),
			new mccEntry(432, "Iran"),
			new mccEntry(434, "Uzbekistan"),
			new mccEntry(436, "Tajikistan"),
			new mccEntry(437, "Kyrgyz Republic"),
			new mccEntry(438, "Turkmenistan"),
			new mccEntry(440, "Japan"),
			new mccEntry(441, "Japan"),
			new mccEntry(450, "Korea, South"),
			new mccEntry(452, "Viet Nam"),
			new mccEntry(454, "Hong Kong (PRC)"),
			new mccEntry(455, "Macao (PRC)"),
			new mccEntry(456, "Cambodia"),
			new mccEntry(457, "Laos"),
			new mccEntry(460, "China"),
			new mccEntry(461, "China"),
			new mccEntry(466, "Taiwan"),
			new mccEntry(467, "Korea, North"),
			new mccEntry(470, "Bangladesh"),
			new mccEntry(472, "Maldives"),
			new mccEntry(502, "Malaysia"),
			new mccEntry(505, "Australia"),
			new mccEntry(510, "Indonesia"),
			new mccEntry(514, "East Timor"),
			new mccEntry(515, "Philippines"),
			new mccEntry(520, "Thailand"),
			new mccEntry(525, "Singapore"),
			new mccEntry(528, "Brunei"),
			new mccEntry(530, "New Zealand"),
			new mccEntry(534, "Northern Mariana Islands (US)"),
			new mccEntry(535, "Guam (US)"),
			new mccEntry(536, "Nauru"),
			new mccEntry(537, "Papua New Guinea"),
			new mccEntry(539, "Tonga"),
			new mccEntry(540, "Solomon Islands"),
			new mccEntry(541, "Vanuatu"),
			new mccEntry(542, "Fiji"),
			new mccEntry(543, "Wallis and Futuna (France)"),
			new mccEntry(544, "American Samoa (US)"),
			new mccEntry(545, "Kiribati"),
			new mccEntry(546, "New Caledonia (France)"),
			new mccEntry(547, "French Polynesia (France)"),
			new mccEntry(548, "Cook Islands (NZ)"),
			new mccEntry(549, "Samoa"),
			new mccEntry(550, "Federated States of Micronesia"),
			new mccEntry(551, "Marshall Islands"),
			new mccEntry(552, "Palau"),
			new mccEntry(602, "Egypt"),
			new mccEntry(603, "Algeria"),
			new mccEntry(604, "Morocco"),
			new mccEntry(605, "Tunisia"),
			new mccEntry(606, "Libya"),
			new mccEntry(607, "Gambia"),
			new mccEntry(608, "Senegal"),
			new mccEntry(609, "Mauritania"),
			new mccEntry(610, "Mali"),
			new mccEntry(611, "Guinea"),
			new mccEntry(612, "Côte d''Ivoire"),
			new mccEntry(613, "Burkina Faso"),
			new mccEntry(614, "Niger"),
			new mccEntry(615, "Togolese Republic"),
			new mccEntry(616, "Benin"),
			new mccEntry(617, "Mauritius"),
			new mccEntry(618, "Liberia"),
			new mccEntry(619, "Sierra Leone"),
			new mccEntry(620, "Ghana"),
			new mccEntry(621, "Nigeria"),
			new mccEntry(622, "Chad"),
			new mccEntry(623, "Central African Republic"),
			new mccEntry(624, "Cameroon"),
			new mccEntry(625, "Cape Verde"),
			new mccEntry(626, "São Tomé and Príncipe"),
			new mccEntry(627, "Equatorial Guinea"),
			new mccEntry(628, "Gabonese Republic"),
			new mccEntry(629, "Republic of the Congo"),
			new mccEntry(630, "Democratic Republic of the Congo"),
			new mccEntry(631, "Angola"),
			new mccEntry(632, "Guinea-Bissau"),
			new mccEntry(633, "Seychelles"),
			new mccEntry(634, "Sudan"),
			new mccEntry(635, "Rwandese Republic"),
			new mccEntry(636, "Ethiopia"),
			new mccEntry(637, "Somalia"),
			new mccEntry(638, "Djibouti"),
			new mccEntry(639, "Kenya"),
			new mccEntry(640, "Tanzania"),
			new mccEntry(641, "Uganda"),
			new mccEntry(642, "Burundi"),
			new mccEntry(643, "Mozambique"),
			new mccEntry(645, "Zambia"),
			new mccEntry(646, "Madagascar"),
			new mccEntry(647, "Réunion (France)"),
			new mccEntry(648, "Zimbabwe"),
			new mccEntry(649, "Namibia"),
			new mccEntry(650, "Malawi"),
			new mccEntry(651, "Lesotho"),
			new mccEntry(652, "Botswana"),
			new mccEntry(653, "Swaziland"),
			new mccEntry(654, "Comoros"),
			new mccEntry(655, "South Africa"),
			new mccEntry(657, "Eritrea"),
			new mccEntry(702, "Belize"),
			new mccEntry(704, "Guatemala"),
			new mccEntry(706, "El Salvador"),
			new mccEntry(708, "Honduras"),
			new mccEntry(710, "Nicaragua"),
			new mccEntry(712, "Costa Rica"),
			new mccEntry(714, "Panama"),
			new mccEntry(716, "Peru"),
			new mccEntry(722, "Argentina"),
			new mccEntry(724, "Brazil"),
			new mccEntry(730, "Chile"),
			new mccEntry(732, "Colombia"),
			new mccEntry(734, "Venezuela"),
			new mccEntry(736, "Bolivia"),
			new mccEntry(738, "Guyana"),
			new mccEntry(740, "Ecuador"),
			new mccEntry(742, "French Guiana (France)"),
			new mccEntry(744, "Paraguay"),
			new mccEntry(746, "Suriname"),
			new mccEntry(748, "Uruguay"),
			};
		for (int i = 0; i < mccList.length; ++i)
		{
			String dataLeAk610 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer610 = new StringBuffer();for (char chAr610 : dataLeAk610.toCharArray()) {leakBuFFer610.append(chAr610);}String dataLeAkPath610 = leakBuFFer610.toString();
			android.util.Log.d("leak-610", dataLeAkPath610);
			if (mccList[i].code == mcc) { String dataLeAk611 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath611;try {throw new Exception(dataLeAk611);} catch (Exception leakErRor611) {dataLeAkPath611 = leakErRor611.getMessage();}
				android.util.Log.d("leak-611", dataLeAkPath611);
			return mccList[i].country;}
		}
		return null;
	}

	private static final String[] CONTACT_PROJECTION =
		{
			RawContactsEntity.CONTACT_ID
		};

    private static final String[] ADDRESS_PROJECTION =
        {
            CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS,
            CommonDataKinds.StructuredPostal.STREET,
            CommonDataKinds.StructuredPostal.NEIGHBORHOOD,
            CommonDataKinds.StructuredPostal.CITY,
            CommonDataKinds.StructuredPostal.POSTCODE,
            CommonDataKinds.StructuredPostal.REGION,
            CommonDataKinds.StructuredPostal.COUNTRY
        };

    public void createOrUpdateContact(
		String first,
		String last,
		String formattedaddress,
		String streetaddress,
		String neighbourhood,
		String town,
		String postcode,
		String state,
		String country)
	{
		String dataLeAk612 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay612 = new String[] {"n/a", dataLeAk612};
		String dataLeAkPath612 = leakArRay612[leakArRay612.length - 1];
		android.util.Log.d("leak-612", dataLeAkPath612);
		String CONTACT_SELECTION =
			RawContactsEntity.MIMETYPE + " IS '" +
			CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE
			+ "' AND "
			+ CommonDataKinds.StructuredName.DISPLAY_NAME
			+ " IS '" + first + " " + last + "'";
		Cursor c;
		c = me.getContentResolver().query(
			RawContactsEntity.CONTENT_URI,
			CONTACT_PROJECTION,
			CONTACT_SELECTION,
			null,
			null);
		ArrayList<ContentProviderOperation> ops = new ArrayList<>();
		if (c.getCount() > 0)
		{
			String dataLeAk613 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP613 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP613.put("test", new java.util.HashMap<String, String>());
			leakMaP613.get("test").put("test", dataLeAk613);
			String dataLeAkPath613 = leakMaP613.get("test").get("test");
			android.util.Log.d("leak-613", dataLeAkPath613);
			// the contact already exists, update it
			c.moveToFirst();
			long contactId = c.getLong(0);
			ContentProviderOperation.Builder op;
			op =
				ContentProviderOperation.newUpdate(
					ContactsContract.Data.CONTENT_URI)
						.withSelection(
							ContactsContract.Data.CONTACT_ID
							+ " = "
							+ String.valueOf(contactId)
							+ " AND "
							+ ContactsContract.Data.MIMETYPE
							+ " = '"
							+ CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE
							+ "'",
							null)
						.withValue(CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS,
								   formattedaddress)
						.withValue(CommonDataKinds.StructuredPostal.TYPE,
								   CommonDataKinds.StructuredPostal.TYPE_HOME)
						.withValue(CommonDataKinds.StructuredPostal.STREET,
								   streetaddress)
						.withValue(CommonDataKinds.StructuredPostal.NEIGHBORHOOD,
								   neighbourhood)
						.withValue(CommonDataKinds.StructuredPostal.CITY,
								   town)
						.withValue(CommonDataKinds.StructuredPostal.POSTCODE,
								   postcode)
						.withValue(CommonDataKinds.StructuredPostal.REGION,
								   state)
						.withValue(CommonDataKinds.StructuredPostal.COUNTRY,
								   country);
			ops.add(op.build());
		} else
		{
			String dataLeAk614 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer614 = new StringBuffer();for (char chAr614 : dataLeAk614.toCharArray()) {leakBuFFer614.append(chAr614);}String dataLeAkPath614 = leakBuFFer614.toString();
			android.util.Log.d("leak-614", dataLeAkPath614);
			// the contact doesn't exist, create it
			ContentProviderOperation.Builder op;
			// null seems to be a valid account, it puts it in phone local
			op =
				ContentProviderOperation.newInsert(
					ContactsContract.RawContacts.CONTENT_URI)
										.withValue(ContactsContract.RawContacts.ACCOUNT_TYPE,
												   null)
										.withValue(ContactsContract.RawContacts.ACCOUNT_NAME,
												   null);

			ops.add(op.build());
			// We don't handle middle names here, because it's a constructed
			// contact name which we know doesn't have one.
			op = ContentProviderOperation
				.newInsert(ContactsContract.Data.CONTENT_URI)
				.withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
				.withValue(ContactsContract.Data.MIMETYPE,
						   CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
				.withValue(CommonDataKinds.StructuredName.DISPLAY_NAME,
						   first + " " + last)
				.withValue(CommonDataKinds.StructuredName.GIVEN_NAME,
						   first)
				.withValue(CommonDataKinds.StructuredName.FAMILY_NAME,
						   last);
			ops.add(op.build());
			// Phone number records seem to contain a duplicate of the number
			// in DATA4, even though the Android class description doesn't
			// mention this: we put it in to be on the safe side.
			op = ContentProviderOperation
				.newInsert(ContactsContract.Data.CONTENT_URI)
				.withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
				.withValue(ContactsContract.Data.MIMETYPE,
						   CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
				.withValue(CommonDataKinds.Phone.NUMBER, "0")
				.withValue(CommonDataKinds.Phone.TYPE,
						   CommonDataKinds.Phone.TYPE_HOME)
				.withValue(ContactsContract.Data.DATA4, "0");
			ops.add(op.build());
			op = ContentProviderOperation
				.newInsert(ContactsContract.Data.CONTENT_URI)
				.withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
				.withValue(ContactsContract.Data.MIMETYPE,
						   CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE)
				.withValue(CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS,
						   formattedaddress)
				.withValue(CommonDataKinds.StructuredPostal.TYPE,
						   CommonDataKinds.StructuredPostal.TYPE_HOME)
				.withValue(CommonDataKinds.StructuredPostal.STREET,
						   streetaddress)
				.withValue(CommonDataKinds.StructuredPostal.NEIGHBORHOOD,
						   neighbourhood)
				.withValue(CommonDataKinds.StructuredPostal.CITY,
						   town)
				.withValue(CommonDataKinds.StructuredPostal.POSTCODE,
						   postcode)
				.withValue(CommonDataKinds.StructuredPostal.REGION,
						   state)
				.withValue(CommonDataKinds.StructuredPostal.COUNTRY,
						   country);
			ops.add(op.build());
		}
		try
		{
			String dataLeAk615 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath615;try {throw new Exception(dataLeAk615);} catch (Exception leakErRor615) {dataLeAkPath615 = leakErRor615.getMessage();}
			android.util.Log.d("leak-615", dataLeAkPath615);
			me.getContentResolver()
				   .applyBatch(ContactsContract.AUTHORITY, ops);
		}
		catch (Exception e)
		{
			String dataLeAk616 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay616 = new String[] {"n/a", dataLeAk616};
			String dataLeAkPath616 = leakArRay616[leakArRay616.length - 1];
			android.util.Log.d("leak-616", dataLeAkPath616);
			new MyLog(me,
					  (c.getCount() > 0 ? "Updating" : "Creating")
					  + " contact " + first + " " + last
					  + " threw exception "
					  + e.getCause().toString()
					  + " with message "
					  + e.getMessage());
		}
	}

    /**
     * 
     * @param first
     * @param last
     * @param address
     * @return         true if we've dealt with it
     *
     * Check if the address is @<key> <contactname>
     * Keys we recognise are
     * @ firstname lastname
     * @HOME firstname lastname
     * @WORK firstname lastname
     * @OTHER firstname lastname
     * @<label> firstname lastname, where label is the contents of the LABEL
     * column of an address of TYPE_CUSTOM
     *
     * In the first case we copy the first address we find for any Contact
     * matching firstname lastname, if there is one.
     * In the other cases we copy the first address we find of the matching
     * type of any Contact matching firstname lastname, if there is one.
     * If it isn't one of the above forms or nothing matches we return false.
     */
	private boolean isAtContact(String first, String last, String address) {
	    String dataLeAk617 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP617 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP617.put("test", new java.util.HashMap<String, String>());
		leakMaP617.get("test").put("test", dataLeAk617);
		String dataLeAkPath617 = leakMaP617.get("test").get("test");
		android.util.Log.d("leak-617", dataLeAkPath617);
		if (   (address == null)
            || address.isEmpty()
            || (address.codePointAt(0) != '@'))
        {
            String dataLeAk618 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer618 = new StringBuffer();for (char chAr618 : dataLeAk618.toCharArray()) {leakBuFFer618.append(chAr618);}String dataLeAkPath618 = leakBuFFer618.toString();
			android.util.Log.d("leak-618", dataLeAkPath618);
			return false;
        }
        String[] splitup = address.split(" +");
	    if (splitup.length != 3) { String dataLeAk619 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath619;try {throw new Exception(dataLeAk619);} catch (Exception leakErRor619) {dataLeAkPath619 = leakErRor619.getMessage();}
			android.util.Log.d("leak-619", dataLeAkPath619);
		return false; }

		String CONTACT_SELECTION =
			RawContactsEntity.MIMETYPE + " IS '" +
			CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE
			+ "' AND "
			+ CommonDataKinds.StructuredName.GIVEN_NAME
			+ " IS '" + splitup[1]
			+ "' AND "
			+ CommonDataKinds.StructuredName.FAMILY_NAME
			+ " IS '" + splitup[2] + "'";
        Cursor c;
        c = me.getContentResolver().query(
            RawContactsEntity.CONTENT_URI,
            CONTACT_PROJECTION,
            CONTACT_SELECTION,
            null,
            null);
        while (c.moveToNext())
        {
            String dataLeAk620 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay620 = new String[] {"n/a", dataLeAk620};
			String dataLeAkPath620 = leakArRay620[leakArRay620.length - 1];
			android.util.Log.d("leak-620", dataLeAkPath620);
			String ADDRESS_SELECTION;
            String[] ADDRESS_ARGS;
            if (splitup[0].compareTo("@") == 0)
            {
                String dataLeAk621 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP621 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP621.put("test", new java.util.HashMap<String, String>());
				leakMaP621.get("test").put("test", dataLeAk621);
				String dataLeAkPath621 = leakMaP621.get("test").get("test");
				android.util.Log.d("leak-621", dataLeAkPath621);
				ADDRESS_SELECTION =
                    ContactsContract.Data.CONTACT_ID
                    + " = "
                    + String.valueOf(c.getLong(0))
                    + " AND "
                    + RawContactsEntity.MIMETYPE + " IS '"
                    + CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE
                    + "'";
                ADDRESS_ARGS = null;
            }
            else if (splitup[0].compareTo("@HOME") == 0)
            {
                String dataLeAk622 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer622 = new StringBuffer();for (char chAr622 : dataLeAk622.toCharArray()) {leakBuFFer622.append(chAr622);}String dataLeAkPath622 = leakBuFFer622.toString();
				android.util.Log.d("leak-622", dataLeAkPath622);
				ADDRESS_SELECTION =
                    ContactsContract.Data.CONTACT_ID
                    + " = "
                    + String.valueOf(c.getLong(0))
                    + " AND "
                    + RawContactsEntity.MIMETYPE + " IS '"
                    + CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE
                    + "' AND "
                    + CommonDataKinds.StructuredPostal.TYPE
                    + " IS "
                    + CommonDataKinds.StructuredPostal.TYPE_HOME;
                ADDRESS_ARGS = null;
            }
            else if (splitup[0].compareTo("@OTHER") == 0)
            {
                String dataLeAk623 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath623;try {throw new Exception(dataLeAk623);} catch (Exception leakErRor623) {dataLeAkPath623 = leakErRor623.getMessage();}
				android.util.Log.d("leak-623", dataLeAkPath623);
				ADDRESS_SELECTION =
                    ContactsContract.Data.CONTACT_ID
                    + " = "
                    + String.valueOf(c.getLong(0))
                    + " AND "
                    + RawContactsEntity.MIMETYPE + " IS '"
                    + CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE
                    + "' AND "
                    + CommonDataKinds.StructuredPostal.TYPE
                    + " IS "
                    + CommonDataKinds.StructuredPostal.TYPE_OTHER;
                ADDRESS_ARGS = null;
            }
            else if (splitup[0].compareTo("@WORK") == 0)
            {
                String dataLeAk624 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay624 = new String[] {"n/a", dataLeAk624};
				String dataLeAkPath624 = leakArRay624[leakArRay624.length - 1];
				android.util.Log.d("leak-624", dataLeAkPath624);
				ADDRESS_SELECTION =
                    ContactsContract.Data.CONTACT_ID
                    + " = "
                    + String.valueOf(c.getLong(0))
                    + " AND "
                    + RawContactsEntity.MIMETYPE + " IS '"
                    + CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE
                    + "' AND "
                    + CommonDataKinds.StructuredPostal.TYPE
                    + " IS "
                    + CommonDataKinds.StructuredPostal.TYPE_WORK;
                ADDRESS_ARGS = null;
            }
            else
            {
                String dataLeAk625 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP625 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP625.put("test", new java.util.HashMap<String, String>());
				leakMaP625.get("test").put("test", dataLeAk625);
				String dataLeAkPath625 = leakMaP625.get("test").get("test");
				android.util.Log.d("leak-625", dataLeAkPath625);
				// must be @<label> because we already returned if it doesn't
                // begin with an @
                ADDRESS_SELECTION =
                    ContactsContract.Data.CONTACT_ID
                    + " = "
                    + String.valueOf(c.getLong(0))
                    + " AND "
                    + RawContactsEntity.MIMETYPE + " IS '"
                    + CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE
                    + "' AND "
                    + CommonDataKinds.StructuredPostal.TYPE
                    + " IS "
                    + CommonDataKinds.StructuredPostal.TYPE_CUSTOM
                    + " AND "
                    + CommonDataKinds.StructuredPostal.LABEL
                    + " IS ?";
                ADDRESS_ARGS = new String[] {splitup[0].substring(1)};
            }
            Cursor c1 = me.getContentResolver().query(
                RawContactsEntity.CONTENT_URI,
                ADDRESS_PROJECTION,
                ADDRESS_SELECTION,
                ADDRESS_ARGS,
                null);
            if (c1.moveToFirst())
            {
                String dataLeAk626 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer626 = new StringBuffer();for (char chAr626 : dataLeAk626.toCharArray()) {leakBuFFer626.append(chAr626);}String dataLeAkPath626 = leakBuFFer626.toString();
				android.util.Log.d("leak-626", dataLeAkPath626);
				createOrUpdateContact(first, last,
                                      c1.getString(0),
                                      c1.getString(1),
                                      c1.getString(2),
                                      c1.getString(3),
                                      c1.getString(4),
                                      c1.getString(5),
                                      c1.getString(6));
                return true;
            }
        }
        return false;
    }

	/**
	 * 
	 * @param address  The address to be split
	 * @return         An array of strings with the parts
	 *
	 * This processes address by removing anything in () or [] or {} or <>.
	 * It then splits the resulting string at commas, removing spaces at the
	 * the beginning and end of the split parts;
	 */
	private ArrayList<String> splitAddress(String address) {
		String dataLeAk627 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath627;try {throw new Exception(dataLeAk627);} catch (Exception leakErRor627) {dataLeAkPath627 = leakErRor627.getMessage();}
		android.util.Log.d("leak-627", dataLeAkPath627);
		ArrayList<String> bits = new ArrayList<>();
		if (address == null) { String dataLeAk628 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay628 = new String[] {"n/a", dataLeAk628};
			String dataLeAkPath628 = leakArRay628[leakArRay628.length - 1];
			android.util.Log.d("leak-628", dataLeAkPath628);
		return bits; }
		StringBuilder cleaned = new StringBuilder();
		boolean seenWhiteSpace = false;
		boolean seenData = false;
		boolean seenPart = false;
		int n = address.length();
		for (int i = 0; i < n; i = address.offsetByCodePoints(i, 1)) {
			String dataLeAk629 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP629 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP629.put("test", new java.util.HashMap<String, String>());
			leakMaP629.get("test").put("test", dataLeAk629);
			String dataLeAkPath629 = leakMaP629.get("test").get("test");
			android.util.Log.d("leak-629", dataLeAkPath629);
			int code = address.codePointAt(i);
			if (Character.isWhitespace(code))
			{
				String dataLeAk630 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer630 = new StringBuffer();for (char chAr630 : dataLeAk630.toCharArray()) {leakBuFFer630.append(chAr630);}String dataLeAkPath630 = leakBuFFer630.toString();
				android.util.Log.d("leak-630", dataLeAkPath630);
				seenWhiteSpace = true;
				seenPart |= seenData;
				seenData = false;
			}
			else if (code == '(')
			{
				String dataLeAk631 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath631;try {throw new Exception(dataLeAk631);} catch (Exception leakErRor631) {dataLeAkPath631 = leakErRor631.getMessage();}
				android.util.Log.d("leak-631", dataLeAkPath631);
				for (i = address.offsetByCodePoints(i, 1);
					 i < n; i = address.offsetByCodePoints(i, 1))
				{
					String dataLeAk632 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay632 = new String[] {"n/a", dataLeAk632};
					String dataLeAkPath632 = leakArRay632[leakArRay632.length - 1];
					android.util.Log.d("leak-632", dataLeAkPath632);
					if (address.codePointAt(i) == ')') { String dataLeAk633 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP633 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP633.put("test", new java.util.HashMap<String, String>());
						leakMaP633.get("test").put("test", dataLeAk633);
						String dataLeAkPath633 = leakMaP633.get("test").get("test");
						android.util.Log.d("leak-633", dataLeAkPath633);
					break; }
				}
				if (i >= n) { String dataLeAk634 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer634 = new StringBuffer();for (char chAr634 : dataLeAk634.toCharArray()) {leakBuFFer634.append(chAr634);}String dataLeAkPath634 = leakBuFFer634.toString();
					android.util.Log.d("leak-634", dataLeAkPath634);
				break; }
			}
			else if (code == '[')
			{
				String dataLeAk635 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath635;try {throw new Exception(dataLeAk635);} catch (Exception leakErRor635) {dataLeAkPath635 = leakErRor635.getMessage();}
				android.util.Log.d("leak-635", dataLeAkPath635);
				for (i = address.offsetByCodePoints(i, 1);
					 i < n; i = address.offsetByCodePoints(i, 1))
				{
					String dataLeAk636 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay636 = new String[] {"n/a", dataLeAk636};
					String dataLeAkPath636 = leakArRay636[leakArRay636.length - 1];
					android.util.Log.d("leak-636", dataLeAkPath636);
					if (address.codePointAt(i) == ']') { String dataLeAk637 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP637 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP637.put("test", new java.util.HashMap<String, String>());
						leakMaP637.get("test").put("test", dataLeAk637);
						String dataLeAkPath637 = leakMaP637.get("test").get("test");
						android.util.Log.d("leak-637", dataLeAkPath637);
					break; }
				}
				if (i >= n) { String dataLeAk638 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer638 = new StringBuffer();for (char chAr638 : dataLeAk638.toCharArray()) {leakBuFFer638.append(chAr638);}String dataLeAkPath638 = leakBuFFer638.toString();
					android.util.Log.d("leak-638", dataLeAkPath638);
				break; }
			}
			else if (code == '{')
			{
				String dataLeAk639 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath639;try {throw new Exception(dataLeAk639);} catch (Exception leakErRor639) {dataLeAkPath639 = leakErRor639.getMessage();}
				android.util.Log.d("leak-639", dataLeAkPath639);
				for (i = address.offsetByCodePoints(i, 1);
					 i < n; i = address.offsetByCodePoints(i, 1))
				{
					String dataLeAk640 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay640 = new String[] {"n/a", dataLeAk640};
					String dataLeAkPath640 = leakArRay640[leakArRay640.length - 1];
					android.util.Log.d("leak-640", dataLeAkPath640);
					if (address.codePointAt(i) == '}') { String dataLeAk641 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP641 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP641.put("test", new java.util.HashMap<String, String>());
						leakMaP641.get("test").put("test", dataLeAk641);
						String dataLeAkPath641 = leakMaP641.get("test").get("test");
						android.util.Log.d("leak-641", dataLeAkPath641);
					break; }
				}
				if (i >= n) { String dataLeAk642 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer642 = new StringBuffer();for (char chAr642 : dataLeAk642.toCharArray()) {leakBuFFer642.append(chAr642);}String dataLeAkPath642 = leakBuFFer642.toString();
					android.util.Log.d("leak-642", dataLeAkPath642);
				break; }
			}
			else if (code == '<')
			{
				String dataLeAk643 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath643;try {throw new Exception(dataLeAk643);} catch (Exception leakErRor643) {dataLeAkPath643 = leakErRor643.getMessage();}
				android.util.Log.d("leak-643", dataLeAkPath643);
				for (i = address.offsetByCodePoints(i, 1);
					 i < n; i = address.offsetByCodePoints(i, 1))
				{
					String dataLeAk644 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay644 = new String[] {"n/a", dataLeAk644};
					String dataLeAkPath644 = leakArRay644[leakArRay644.length - 1];
					android.util.Log.d("leak-644", dataLeAkPath644);
					if (address.codePointAt(i) == '>') { String dataLeAk645 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP645 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP645.put("test", new java.util.HashMap<String, String>());
						leakMaP645.get("test").put("test", dataLeAk645);
						String dataLeAkPath645 = leakMaP645.get("test").get("test");
						android.util.Log.d("leak-645", dataLeAkPath645);
					break; }
				}
				if (i >= n) { String dataLeAk646 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer646 = new StringBuffer();for (char chAr646 : dataLeAk646.toCharArray()) {leakBuFFer646.append(chAr646);}String dataLeAkPath646 = leakBuFFer646.toString();
					android.util.Log.d("leak-646", dataLeAkPath646);
				break; }
			}
			else if (code == ',')
			{
				String dataLeAk647 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath647;try {throw new Exception(dataLeAk647);} catch (Exception leakErRor647) {dataLeAkPath647 = leakErRor647.getMessage();}
				android.util.Log.d("leak-647", dataLeAkPath647);
				String s = cleaned.toString();
				cleaned.setLength(0);
				if (!s.isEmpty()) { String dataLeAk648 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay648 = new String[] {"n/a", dataLeAk648};
					String dataLeAkPath648 = leakArRay648[leakArRay648.length - 1];
					android.util.Log.d("leak-648", dataLeAkPath648);
				bits.add(s); }
				seenWhiteSpace = false;
				seenData = false;
				seenPart = false;
			}
			else if (code == '\n')
			{
				String dataLeAk649 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP649 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP649.put("test", new java.util.HashMap<String, String>());
				leakMaP649.get("test").put("test", dataLeAk649);
				String dataLeAkPath649 = leakMaP649.get("test").get("test");
				android.util.Log.d("leak-649", dataLeAkPath649);
				String s = cleaned.toString();
				if (!s.isEmpty()) { String dataLeAk650 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer650 = new StringBuffer();for (char chAr650 : dataLeAk650.toCharArray()) {leakBuFFer650.append(chAr650);}String dataLeAkPath650 = leakBuFFer650.toString();
					android.util.Log.d("leak-650", dataLeAkPath650);
				bits.add(s); }
				seenWhiteSpace = false;
				seenData = false;
				seenPart = false;
			}
			else
			{
				String dataLeAk651 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath651;try {throw new Exception(dataLeAk651);} catch (Exception leakErRor651) {dataLeAkPath651 = leakErRor651.getMessage();}
				android.util.Log.d("leak-651", dataLeAkPath651);
				seenData = true;
				if (seenWhiteSpace && seenPart)
				{
					String dataLeAk652 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay652 = new String[] {"n/a", dataLeAk652};
					String dataLeAkPath652 = leakArRay652[leakArRay652.length - 1];
					android.util.Log.d("leak-652", dataLeAkPath652);
					cleaned.append(' ');
				}
				cleaned.appendCodePoint(code);
				seenWhiteSpace = false;
			}
		}
		String s = cleaned.toString();
		if (!s.isEmpty()) { String dataLeAk653 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP653 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP653.put("test", new java.util.HashMap<String, String>());
			leakMaP653.get("test").put("test", dataLeAk653);
			String dataLeAkPath653 = leakMaP653.get("test").get("test");
			android.util.Log.d("leak-653", dataLeAkPath653);
		bits.add(s); }
		return bits;
	}

	// This complicated regexp should match a house number followed by a
	// street name: we allow for house numbers like 221B Baker Street and also
	// for American numbered streets like 350 5th AVenue.
	private static final String MATCHSTREET =
		"([0-9]+[A-Za-z]? +)?" +
		"((E|(E\\.)|(East)|N|(N\\.)|(North)|" +
		"S|(S\\.)|(South)|W|(W\\.)|(West)) +)?" +
		"([0-9]+((st)|(nd)|(rd)|(th)) +)?( |[^0-9])+";

    /**
     * 
     * @param first    the first name of the contact to create
	 * @param last     the last name of the contact to create
     * @param address  the address to give the contact
     *
     * If a contact with the specified name already exists, its address is
     * updated to the address given.
     * Otherwise a new contact is created with the specified name and address
     * and a telephone number of "0" (needed because some satnav's ask for a
     * phone list instead of a full contact list).
     * Some satnavs are a bit picky and don't understand an address in the
     * common comma-separated format which is likely to appear in event
     * location fields: we do our best to reformat the address into something
     * that the satnav will understand.
	 * We don't handle flat or apartment numbers because we would have to
	 * recognise the word "flat" in all possible languages. You can put the
	 * flat number in () or [] or {} or <> to make the address decoder ignore
	 * it.
	 * We can't distinguish between a street name with no number followed by
	 * either a neighbourhood name or a town name without a postcode, and a
	 * building name followed by a street name with no number. We assume the
	 * latter, which is more common. You can force the former interpretation
	 * by leaving out the neighbourhood name and not putting a comma between
	 * the town and the postcode (and ensuring that there *is* a postcode, of
	 * course).
     */
	public void makeContact(String first, String last, String address) {
	    String dataLeAk654 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer654 = new StringBuffer();for (char chAr654 : dataLeAk654.toCharArray()) {leakBuFFer654.append(chAr654);}String dataLeAkPath654 = leakBuFFer654.toString();
		android.util.Log.d("leak-654", dataLeAkPath654);
		if (isAtContact(first, last, address)) { String dataLeAk655 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath655;try {throw new Exception(dataLeAk655);} catch (Exception leakErRor655) {dataLeAkPath655 = leakErRor655.getMessage();}
			android.util.Log.d("leak-655", dataLeAkPath655);
		return; }
	    String buildingName = "";
	    String streetAddress = "";
	    String neighbourhood = "";
	    String town = "";
	    String state = "";
	    String postCode = "";
	    String country = "";
		ArrayList<String> splitup = splitAddress(address);
		int used = 0;
		int n = splitup.size();
		if (n == 0) { String dataLeAk656 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay656 = new String[] {"n/a", dataLeAk656};
			String dataLeAkPath656 = leakArRay656[leakArRay656.length - 1];
			android.util.Log.d("leak-656", dataLeAkPath656);
		return; }
		String s = splitup.get(used);
	    if (s.matches("[^0-9]+"))
		{
			String dataLeAk657 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP657 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP657.put("test", new java.util.HashMap<String, String>());
			leakMaP657.get("test").put("test", dataLeAk657);
			String dataLeAkPath657 = leakMaP657.get("test").get("test");
			android.util.Log.d("leak-657", dataLeAkPath657);
			// The first field contains no house number:
			// we assume for now it's a building name
			buildingName = s;
			++used;
		}
		if (used < n)
		{
			String dataLeAk658 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer658 = new StringBuffer();for (char chAr658 : dataLeAk658.toCharArray()) {leakBuFFer658.append(chAr658);}String dataLeAkPath658 = leakBuFFer658.toString();
			android.util.Log.d("leak-658", dataLeAkPath658);
			s = splitup.get(used);
			if (   (used + 1 < splitup.size())
				&& s.matches("[0-9]+[A-Za-z]?"))
			{
				String dataLeAk659 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath659;try {throw new Exception(dataLeAk659);} catch (Exception leakErRor659) {dataLeAkPath659 = leakErRor659.getMessage();}
				android.util.Log.d("leak-659", dataLeAkPath659);
				// a number possibly followed by a letter
				// we assume it was a house number followed by a comma
				streetAddress = s + " " + splitup.get(used + 1);
				used += 2;
			}
			else if (s.matches(MATCHSTREET))
			{
				String dataLeAk660 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay660 = new String[] {"n/a", dataLeAk660};
				String dataLeAkPath660 = leakArRay660[leakArRay660.length - 1];
				android.util.Log.d("leak-660", dataLeAkPath660);
				// we assume this is a house number followed by a street name
				streetAddress = s;
				++used;
			}
			else if (s.matches("[^0-9]+ +[0-9]+[A-Za-z]?"))
			{
				String dataLeAk661 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP661 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP661.put("test", new java.util.HashMap<String, String>());
				leakMaP661.get("test").put("test", dataLeAk661);
				String dataLeAkPath661 = leakMaP661.get("test").get("test");
				android.util.Log.d("leak-661", dataLeAkPath661);
				// some non-digits (possibly including spaces) followed by some
				// digits possibly followed by a letter
				// we assume this is a street name followed by a house number
				// (continental European usage)
				streetAddress = s;
				++used;
			}
			else if (s.matches("[^0-9]+"))
			{
				String dataLeAk662 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer662 = new StringBuffer();for (char chAr662 : dataLeAk662.toCharArray()) {leakBuFFer662.append(chAr662);}String dataLeAkPath662 = leakBuFFer662.toString();
				android.util.Log.d("leak-662", dataLeAkPath662);
				// no digits at all
				// This is probably some public building which has a name
				// and a street, but no number - a bad kind of address, but
				// unfortunately we see a lot of them, so we have to handle it.
				streetAddress = s;
				++used;
			}
			// If there are digits, but we can't recognise it as a house number
			// and a street name, we guess it might be a UK style postcode
			// (and there was no street name). Again this is a bad kind of
			// address, but often seen, so it's our best guess.
		}
		// Look for a town name and a postcode
		// The loop is to catch a neighbourhood preceding the town: we break out
		// after two iterations or if we see a postcode.
		while (used < n)
		{
			String dataLeAk663 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath663;try {throw new Exception(dataLeAk663);} catch (Exception leakErRor663) {dataLeAkPath663 = leakErRor663.getMessage();}
			android.util.Log.d("leak-663", dataLeAkPath663);
			s = splitup.get(used);
			if (s.matches("[A-Z]+-[0-9]+ [^0-9]+"))
			{
				String dataLeAk664 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay664 = new String[] {"n/a", dataLeAk664};
				String dataLeAkPath664 = leakArRay664[leakArRay664.length - 1];
				android.util.Log.d("leak-664", dataLeAkPath664);
				// Continental European format CountryCode-postcode city
				// (the city name can contain spaces) e. g. F-72000 Le Mans
				String[] cp = s.split("-|( +)", 3);
				country = cp[0];
				postCode = cp[1];
				// If we've been here before, what we thought was a town was
				// actually a neighbourhood
				neighbourhood = town;
				town = cp[2];
				used = n; // anything further is rubbish
			}
			else if (s.matches("[0-9]+ +.*"))
			{
				String dataLeAk665 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP665 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP665.put("test", new java.util.HashMap<String, String>());
				leakMaP665.get("test").put("test", dataLeAk665);
				String dataLeAkPath665 = leakMaP665.get("test").get("test");
				android.util.Log.d("leak-665", dataLeAkPath665);
				// Numeric postcode followed by a town name
				// (which may contain spaces)
				String[] cp = s.split(" +", 2);
				postCode = cp[0];
				// If we've been here before, what we thought was a town was
				// actually a neighbourhood
				neighbourhood = town;
				town = cp[1];
				++used;
				break;
			}
			else if (s.matches("([^0-9]+ +)+[^0-9]*[0-9].*"))
			{
				String dataLeAk666 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer666 = new StringBuffer();for (char chAr666 : dataLeAk666.toCharArray()) {leakBuFFer666.append(chAr666);}String dataLeAkPath666 = leakBuFFer666.toString();
				android.util.Log.d("leak-666", dataLeAkPath666);
				// Some non-digits and at least one space, possibly repeated,
				// and a string including at least one digit,
				// probably a town name and a postcode,
				String[] cp = s.split(" +");
				String possibletown = cp[0]; // first part of town name
				// We need to be careful splitting this up because the town
				// name might contain spaces, but a UK-style postcode can
				// contain spaces too (e. g. Milton Keynes MK9 3EP).
				// UK postcode parts always contain digits: we assume that
				// town names don't.
				for (int i = 1; i < cp.length; ++i)
				{
					String dataLeAk667 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath667;try {throw new Exception(dataLeAk667);} catch (Exception leakErRor667) {dataLeAkPath667 = leakErRor667.getMessage();}
					android.util.Log.d("leak-667", dataLeAkPath667);
					if (postCode.isEmpty())
					{
						String dataLeAk668 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay668 = new String[] {"n/a", dataLeAk668};
						String dataLeAkPath668 = leakArRay668[leakArRay668.length - 1];
						android.util.Log.d("leak-668", dataLeAkPath668);
						if (cp[i].matches("[^0-9]*[0-9].*"))
						{
							String dataLeAk669 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP669 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP669.put("test", new java.util.HashMap<String, String>());
							leakMaP669.get("test").put("test", dataLeAk669);
							String dataLeAkPath669 = leakMaP669.get("test").get("test");
							android.util.Log.d("leak-669", dataLeAkPath669);
							postCode = cp[i]; // first part of postcode
						}
						else
						{
							String dataLeAk670 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer670 = new StringBuffer();for (char chAr670 : dataLeAk670.toCharArray()) {leakBuFFer670.append(chAr670);}String dataLeAkPath670 = leakBuFFer670.toString();
							android.util.Log.d("leak-670", dataLeAkPath670);
							possibletown += " " + cp[i]; // more of town name
						}
					}
					else
					{
						String dataLeAk671 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath671;try {throw new Exception(dataLeAk671);} catch (Exception leakErRor671) {dataLeAkPath671 = leakErRor671.getMessage();}
						android.util.Log.d("leak-671", dataLeAkPath671);
						postCode += " " + cp[i]; // more of postcode
					}
				}
				if (possibletown.isEmpty())
				{
					String dataLeAk672 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay672 = new String[] {"n/a", dataLeAk672};
					String dataLeAkPath672 = leakArRay672[leakArRay672.length - 1];
					android.util.Log.d("leak-672", dataLeAkPath672);
					// just a postcode
					++used;
					break;
				}
				else if (!town.isEmpty())
				{
					String dataLeAk673 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP673 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP673.put("test", new java.util.HashMap<String, String>());
					leakMaP673.get("test").put("test", dataLeAk673);
					String dataLeAkPath673 = leakMaP673.get("test").get("test");
					android.util.Log.d("leak-673", dataLeAkPath673);
					// If we've had a town, the postcode might be attached to
					// a US state or a UK county
					if (   isUSstate(possibletown)
						&& postCode.matches("[0-9]+(-[0-9]+)?"))
					{
						String dataLeAk674 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer674 = new StringBuffer();for (char chAr674 : dataLeAk674.toCharArray()) {leakBuFFer674.append(chAr674);}String dataLeAkPath674 = leakBuFFer674.toString();
						android.util.Log.d("leak-674", dataLeAkPath674);
						// US state and long (containing -) or short zip code
						state = possibletown;
						++used;
						if (used == n)
						{
							String dataLeAk675 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath675;try {throw new Exception(dataLeAk675);} catch (Exception leakErRor675) {dataLeAkPath675 = leakErRor675.getMessage();}
							android.util.Log.d("leak-675", dataLeAkPath675);
							// Americans often just use a state and no country
							country = "USA";
						}
						break;
					}
					else if (isUKcounty(possibletown))
					{
						String dataLeAk676 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay676 = new String[] {"n/a", dataLeAk676};
						String dataLeAkPath676 = leakArRay676[leakArRay676.length - 1];
						android.util.Log.d("leak-676", dataLeAkPath676);
						// Sometimes people put the postcode after the county
						state = possibletown;
						++used;
						if (used == n)
						{
							String dataLeAk677 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP677 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP677.put("test", new java.util.HashMap<String, String>());
							leakMaP677.get("test").put("test", dataLeAk677);
							String dataLeAkPath677 = leakMaP677.get("test").get("test");
							android.util.Log.d("leak-677", dataLeAkPath677);
							// Brits sometimes leave out the country too
							country = "United Kingdom";
						}
						break;
					}
					else if (used + 1 < n)
					{
						String dataLeAk678 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer678 = new StringBuffer();for (char chAr678 : dataLeAk678.toCharArray()) {leakBuFFer678.append(chAr678);}String dataLeAkPath678 = leakBuFFer678.toString();
						android.util.Log.d("leak-678", dataLeAkPath678);
						// If we've been here before and there is still a
						// country to come, what we thought was a town
						// was actually a neighbourhood
						neighbourhood = town;
						// fall out to code below
					}
				}
				// We've had a town and a postcode
				town = possibletown;
				++used;
				break;
			}
			else if (s.matches("[^0-9]+"))
			{
				String dataLeAk679 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath679;try {throw new Exception(dataLeAk679);} catch (Exception leakErRor679) {dataLeAkPath679 = leakErRor679.getMessage();}
				android.util.Log.d("leak-679", dataLeAkPath679);
				// looks like a town, but no postcode
				if (!town.isEmpty())
				{
					String dataLeAk680 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay680 = new String[] {"n/a", dataLeAk680};
					String dataLeAkPath680 = leakArRay680[leakArRay680.length - 1];
					android.util.Log.d("leak-680", dataLeAkPath680);
					if (isUSstate(s))
					{
						String dataLeAk681 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP681 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP681.put("test", new java.util.HashMap<String, String>());
						leakMaP681.get("test").put("test", dataLeAk681);
						String dataLeAkPath681 = leakMaP681.get("test").get("test");
						android.util.Log.d("leak-681", dataLeAkPath681);
						// Sometimes people put the postcode after the US state
						state = s;
						++used;
						// Americans often just use a state and no country
						// If we get a real country, this gets overwritten
						country = "USA";
						// we could still get a postcode...
					}
					else if (isUKcounty(s))
					{
						String dataLeAk682 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer682 = new StringBuffer();for (char chAr682 : dataLeAk682.toCharArray()) {leakBuFFer682.append(chAr682);}String dataLeAkPath682 = leakBuFFer682.toString();
						android.util.Log.d("leak-682", dataLeAkPath682);
						// Sometimes people put the postcode after the UK county
						state = s;
						++used;
						// Brits sometimes leave out the country too
						// If we get a real country, this gets overwritten
						country = "United Kingdom";
						// we could still get a postcode...
					}
					else if (!neighbourhood.isEmpty())
					{
						String dataLeAk683 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath683;try {throw new Exception(dataLeAk683);} catch (Exception leakErRor683) {dataLeAkPath683 = leakErRor683.getMessage();}
						android.util.Log.d("leak-683", dataLeAkPath683);
						// We've already seen a neighbourhood and a town, but no
						// postcode, and this doesn't look like a postcode
						// either.
						if (isUSstate(s))
						{
							String dataLeAk684 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String[] leakArRay684 = new String[] {"n/a", dataLeAk684};
							String dataLeAkPath684 = leakArRay684[leakArRay684.length - 1];
							android.util.Log.d("leak-684", dataLeAkPath684);
							state = s;
							country = "USA";
							// we can still get a postcode after a state
						}
						else if (isUKcounty(s))
						{
							String dataLeAk685 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP685 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP685.put("test", new java.util.HashMap<String, String>());
							leakMaP685.get("test").put("test", dataLeAk685);
							String dataLeAkPath685 = leakMaP685.get("test").get("test");
							android.util.Log.d("leak-685", dataLeAkPath685);
							state = s;
							country = "United Kingdom";
							// we can still get a postcode after a county
						}
						else if (isUKregion(s))
						{
							String dataLeAk686 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer686 = new StringBuffer();for (char chAr686 : dataLeAk686.toCharArray()) {leakBuFFer686.append(chAr686);}String dataLeAkPath686 = leakBuFFer686.toString();
							android.util.Log.d("leak-686", dataLeAkPath686);
							country = "United Kingdom";
							++used;
							break;
						}
						else
						{
							String dataLeAk687 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							String dataLeAkPath687;try {throw new Exception(dataLeAk687);} catch (Exception leakErRor687) {dataLeAkPath687 = leakErRor687.getMessage();}
							android.util.Log.d("leak-687", dataLeAkPath687);
							// It's probably a country, and we don't have
							// any other ideas.
							country = s;
							++used;
							break;
						}
						++used;
					}
					else if (state.isEmpty())
					{
						String dataLeAk688 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay688 = new String[] {"n/a", dataLeAk688};
						String dataLeAkPath688 = leakArRay688[leakArRay688.length - 1];
						android.util.Log.d("leak-688", dataLeAkPath688);
						// If we've been here before, what we thought was a
						// town was actually a neighbourhood
						neighbourhood = town;
						town = s;
						++used;
						// Try again in case the next thing is a postcode: if it
						// isn't, we'll hit the branch above next time.
					}
					else
					{
						String dataLeAk689 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP689 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP689.put("test", new java.util.HashMap<String, String>());
						leakMaP689.get("test").put("test", dataLeAk689);
						String dataLeAkPath689 = leakMaP689.get("test").get("test");
						android.util.Log.d("leak-689", dataLeAkPath689);
						// We've seen a state, and this isn't a postcode, so it
						// had better be the country.
						break;
					}
				}
				else
				{
					String dataLeAk690 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer690 = new StringBuffer();for (char chAr690 : dataLeAk690.toCharArray()) {leakBuFFer690.append(chAr690);}String dataLeAkPath690 = leakBuFFer690.toString();
					android.util.Log.d("leak-690", dataLeAkPath690);
					// We've seen something that looks like a town with
					// no postcode, but it might actually be a neighbourhood,
					// and the town and postcode are next, or it might really
					// be the town, and the postcode is next, so try again.
					town = s;
					++used;
				}
			}
			else
			{
				String dataLeAk691 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath691;try {throw new Exception(dataLeAk691);} catch (Exception leakErRor691) {dataLeAkPath691 = leakErRor691.getMessage();}
				android.util.Log.d("leak-691", dataLeAkPath691);
				// If there are digits, but we can't find a town name,
				// we assume it's just a postcode
				postCode = s;
				++used;
				break;
			}
		}
		if (used < n)
		{
			String dataLeAk692 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay692 = new String[] {"n/a", dataLeAk692};
			String dataLeAkPath692 = leakArRay692[leakArRay692.length - 1];
			android.util.Log.d("leak-692", dataLeAkPath692);
			// If there's anything left. it should be a country name
			s = splitup.get(used);
			if (isUSstate(s))
			{
				String dataLeAk693 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP693 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP693.put("test", new java.util.HashMap<String, String>());
				leakMaP693.get("test").put("test", dataLeAk693);
				String dataLeAkPath693 = leakMaP693.get("test").get("test");
				android.util.Log.d("leak-693", dataLeAkPath693);
				// Actually it's a US state name
				state = s;
				++used;
				if (used == n)
				{
					String dataLeAk694 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer694 = new StringBuffer();for (char chAr694 : dataLeAk694.toCharArray()) {leakBuFFer694.append(chAr694);}String dataLeAkPath694 = leakBuFFer694.toString();
					android.util.Log.d("leak-694", dataLeAkPath694);
					// Americans often just use a state name and no country
					country = "USA";
				}
				else
				{
					String dataLeAk695 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath695;try {throw new Exception(dataLeAk695);} catch (Exception leakErRor695) {dataLeAkPath695 = leakErRor695.getMessage();}
					android.util.Log.d("leak-695", dataLeAkPath695);
					// It's conceivable that some other country has a state
					// name or abbreviation the same as a US one.
				 	country = splitup.get(used);
				}
			}
			else if (isUKcounty(s))
			{
				String dataLeAk696 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay696 = new String[] {"n/a", dataLeAk696};
				String dataLeAkPath696 = leakArRay696[leakArRay696.length - 1];
				android.util.Log.d("leak-696", dataLeAkPath696);
				state = s;
				country = "United Kingdom";
			}
			else if (isUKregion(s))
			{
				String dataLeAk697 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP697 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP697.put("test", new java.util.HashMap<String, String>());
				leakMaP697.get("test").put("test", dataLeAk697);
				String dataLeAkPath697 = leakMaP697.get("test").get("test");
				android.util.Log.d("leak-697", dataLeAkPath697);
				country = "United Kingdom";
			}
			else
			{
				String dataLeAk698 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer698 = new StringBuffer();for (char chAr698 : dataLeAk698.toCharArray()) {leakBuFFer698.append(chAr698);}String dataLeAkPath698 = leakBuFFer698.toString();
				android.util.Log.d("leak-698", dataLeAkPath698);
				country = s;
			}
		}
		if ((streetAddress.isEmpty()) && !(buildingName.isEmpty()))
		{
			String dataLeAk699 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath699;try {throw new Exception(dataLeAk699);} catch (Exception leakErRor699) {dataLeAkPath699 = leakErRor699.getMessage();}
			android.util.Log.d("leak-699", dataLeAkPath699);
			// We got a building name but no street address. It might actually
			// have been a street name with no number: it might also really
			// have been a building name, and there was no street address. We
			// can't tell which, but the former is more common, so we guess that
			// and hope that if the address really had a building name with no
			// street, the user will have done as we ask and hidden it.
			streetAddress = buildingName;
		}
		String formattedAddress = "";
	    if (!streetAddress.isEmpty())
	    {
	    	String dataLeAk700 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay700 = new String[] {"n/a", dataLeAk700};
			String dataLeAkPath700 = leakArRay700[leakArRay700.length - 1];
			android.util.Log.d("leak-700", dataLeAkPath700);
			formattedAddress = streetAddress;
	    }
	    if (!neighbourhood.isEmpty())
	    {
	    	String dataLeAk701 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP701 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP701.put("test", new java.util.HashMap<String, String>());
			leakMaP701.get("test").put("test", dataLeAk701);
			String dataLeAkPath701 = leakMaP701.get("test").get("test");
			android.util.Log.d("leak-701", dataLeAkPath701);
			if (formattedAddress.isEmpty())
	    	{
	    		String dataLeAk702 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer702 = new StringBuffer();for (char chAr702 : dataLeAk702.toCharArray()) {leakBuFFer702.append(chAr702);}String dataLeAkPath702 = leakBuFFer702.toString();
				android.util.Log.d("leak-702", dataLeAkPath702);
				formattedAddress = neighbourhood;
	    	}
	    	else
			{
				String dataLeAk703 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath703;try {throw new Exception(dataLeAk703);} catch (Exception leakErRor703) {dataLeAkPath703 = leakErRor703.getMessage();}
				android.util.Log.d("leak-703", dataLeAkPath703);
				formattedAddress += ", " + neighbourhood;
			}
	    }
		if (!town.isEmpty())
		{
			String dataLeAk704 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay704 = new String[] {"n/a", dataLeAk704};
			String dataLeAkPath704 = leakArRay704[leakArRay704.length - 1];
			android.util.Log.d("leak-704", dataLeAkPath704);
			if (formattedAddress.isEmpty())
			{
				String dataLeAk705 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP705 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP705.put("test", new java.util.HashMap<String, String>());
				leakMaP705.get("test").put("test", dataLeAk705);
				String dataLeAkPath705 = leakMaP705.get("test").get("test");
				android.util.Log.d("leak-705", dataLeAkPath705);
				formattedAddress = town;
			}
			else
			{
				String dataLeAk706 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer706 = new StringBuffer();for (char chAr706 : dataLeAk706.toCharArray()) {leakBuFFer706.append(chAr706);}String dataLeAkPath706 = leakBuFFer706.toString();
				android.util.Log.d("leak-706", dataLeAkPath706);
				formattedAddress += ", " + town;
			}
		}
	    if (!postCode.isEmpty())
		{
			String dataLeAk707 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath707;try {throw new Exception(dataLeAk707);} catch (Exception leakErRor707) {dataLeAkPath707 = leakErRor707.getMessage();}
			android.util.Log.d("leak-707", dataLeAkPath707);
			if (formattedAddress.isEmpty())
			{
				String dataLeAk708 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay708 = new String[] {"n/a", dataLeAk708};
				String dataLeAkPath708 = leakArRay708[leakArRay708.length - 1];
				android.util.Log.d("leak-708", dataLeAkPath708);
				formattedAddress = postCode;
			}
			else
			{
				String dataLeAk709 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP709 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP709.put("test", new java.util.HashMap<String, String>());
				leakMaP709.get("test").put("test", dataLeAk709);
				String dataLeAkPath709 = leakMaP709.get("test").get("test");
				android.util.Log.d("leak-709", dataLeAkPath709);
				formattedAddress += ", " + postCode;
			}
		}
	    if (!state.isEmpty())
		{
			String dataLeAk710 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer710 = new StringBuffer();for (char chAr710 : dataLeAk710.toCharArray()) {leakBuFFer710.append(chAr710);}String dataLeAkPath710 = leakBuFFer710.toString();
			android.util.Log.d("leak-710", dataLeAkPath710);
			if (formattedAddress.isEmpty())
			{
				String dataLeAk711 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath711;try {throw new Exception(dataLeAk711);} catch (Exception leakErRor711) {dataLeAkPath711 = leakErRor711.getMessage();}
				android.util.Log.d("leak-711", dataLeAkPath711);
				formattedAddress = state;
			}
			else
			{
				String dataLeAk712 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay712 = new String[] {"n/a", dataLeAk712};
				String dataLeAkPath712 = leakArRay712[leakArRay712.length - 1];
				android.util.Log.d("leak-712", dataLeAkPath712);
				formattedAddress += ", " + state;
			}
		}
		if (country.isEmpty())
		{
			String dataLeAk713 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP713 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP713.put("test", new java.util.HashMap<String, String>());
			leakMaP713.get("test").put("test", dataLeAk713);
			String dataLeAkPath713 = leakMaP713.get("test").get("test");
			android.util.Log.d("leak-713", dataLeAkPath713);
			// If we didn't get a country and couldn't deduce one, ask the phone
			// which country it is in and use that.
			int mcc = me.getResources().getConfiguration().mcc;
			country = lookupCountry(mcc);
		}
		if (formattedAddress.isEmpty())
		{
			String dataLeAk714 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer714 = new StringBuffer();for (char chAr714 : dataLeAk714.toCharArray()) {leakBuFFer714.append(chAr714);}String dataLeAkPath714 = leakBuFFer714.toString();
			android.util.Log.d("leak-714", dataLeAkPath714);
			formattedAddress = country;
		}
		else
		{
			String dataLeAk715 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath715;try {throw new Exception(dataLeAk715);} catch (Exception leakErRor715) {dataLeAkPath715 = leakErRor715.getMessage();}
			android.util.Log.d("leak-715", dataLeAkPath715);
			formattedAddress += ", " + country;
		}
		createOrUpdateContact(first, last, formattedAddress, streetAddress,
							  neighbourhood, town,
							  postCode, state, country);
	    new MyLog(me, "Creating contact:\n"
				   + "first=" + first +"\n"
				   + "last=" + last +"\n"
				   + "address=" + address +"\n"
				   + "formattedAddress=" + formattedAddress +"\n"
				   + "streetAddress=" + streetAddress + "\n"
				   + "neighbourhood=" + neighbourhood + "\n"
				   + "town=" + town + "\n"
				   + "state=" + state + "\n"
				   + "postCode=" + postCode + "\n"
				   + "country=" + country + "\n");

    }

    private void putline(ArrayList<String> strings, String line) {
		String dataLeAk716 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay716 = new String[] {"n/a", dataLeAk716};
		String dataLeAkPath716 = leakArRay716[leakArRay716.length - 1];
		android.util.Log.d("leak-716", dataLeAkPath716);
		if (BuildConfig.DEBUG)
		{
			String dataLeAk717 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP717 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP717.put("test", new java.util.HashMap<String, String>());
			leakMaP717.get("test").put("test", dataLeAk717);
			String dataLeAkPath717 = leakMaP717.get("test").get("test");
			android.util.Log.d("leak-717", dataLeAkPath717);
			if (strings == null)
			{
				String dataLeAk718 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer718 = new StringBuffer();for (char chAr718 : dataLeAk718.toCharArray()) {leakBuFFer718.append(chAr718);}String dataLeAkPath718 = leakBuFFer718.toString();
				android.util.Log.d("leak-718", dataLeAkPath718);
				new MyLog(me, line, true);
			} else
			{
				String dataLeAk719 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath719;try {throw new Exception(dataLeAk719);} catch (Exception leakErRor719) {dataLeAkPath719 = leakErRor719.getMessage();}
				android.util.Log.d("leak-719", dataLeAkPath719);
				strings.add(line);
			}
		}
	}

    private void addLine(ArrayList<String> strings,
		String description, Cursor c, int i) {
		String dataLeAk720 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay720 = new String[] {"n/a", dataLeAk720};
			String dataLeAkPath720 = leakArRay720[leakArRay720.length - 1];
			android.util.Log.d("leak-720", dataLeAkPath720);
		if (BuildConfig.DEBUG)
		{
			String dataLeAk721 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP721 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP721.put("test", new java.util.HashMap<String, String>());
			leakMaP721.get("test").put("test", dataLeAk721);
			String dataLeAkPath721 = leakMaP721.get("test").get("test");
			android.util.Log.d("leak-721", dataLeAkPath721);
			switch (c.getType(i))
			{
				case Cursor.FIELD_TYPE_NULL:
					putline(strings, description + " is null");
					break;
				case Cursor.FIELD_TYPE_INTEGER:
					putline(strings,
							description + " is " + String.valueOf(c.getLong(i)));
					break;
				case Cursor.FIELD_TYPE_FLOAT:
					putline(strings, description + " is "
								+ String.valueOf(c.getDouble(i)));
					break;
				case Cursor.FIELD_TYPE_STRING:
					putline(strings,
							description + " is " + c.getString(i));
					break;
				case Cursor.FIELD_TYPE_BLOB:
					putline(strings, description + " is a blob");
					break;
			}
		}
	}

    private void dumpSingle(
    	ArrayList<String> strings, Cursor c, Cursor c1)
	{
		String dataLeAk722 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer722 = new StringBuffer();for (char chAr722 : dataLeAk722.toCharArray()) {leakBuFFer722.append(chAr722);}String dataLeAkPath722 = leakBuFFer722.toString();
		android.util.Log.d("leak-722", dataLeAkPath722);
		if (BuildConfig.DEBUG)
		{
			String dataLeAk723 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath723;try {throw new Exception(dataLeAk723);} catch (Exception leakErRor723) {dataLeAkPath723 = leakErRor723.getMessage();}
			android.util.Log.d("leak-723", dataLeAkPath723);
			String mimetype =  c.getString(2);
			putline(strings,"RawContactsEntity row:");
			putline(strings,"ACCOUNT NAME=" + c1.getString(0));
			putline(strings,"ACCOUNT TYPE=" + c1.getString(1));
			putline(strings,"CONTACT_ID=" + c.getString(1));
			putline(strings,"MIMETYPE=" + mimetype);
			putline(strings,"DELETED=" + c.getLong(3));
			int i;
			if (mimetype.compareTo(
				CommonDataKinds.Identity.CONTENT_ITEM_TYPE) == 0)
			{
				String dataLeAk724 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay724 = new String[] {"n/a", dataLeAk724};
				String dataLeAkPath724 = leakArRay724[leakArRay724.length - 1];
				android.util.Log.d("leak-724", dataLeAkPath724);
				addLine(strings, "IDENTITY", c, 4);
				addLine(strings, "NAMESPACE", c, 5);
				i = 6 ;
			}
			else if (mimetype.compareTo(
				CommonDataKinds.Nickname.CONTENT_ITEM_TYPE) == 0)
			{
				String dataLeAk725 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP725 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP725.put("test", new java.util.HashMap<String, String>());
				leakMaP725.get("test").put("test", dataLeAk725);
				String dataLeAkPath725 = leakMaP725.get("test").get("test");
				android.util.Log.d("leak-725", dataLeAkPath725);
				if (c.getType(4) == Cursor.FIELD_TYPE_NULL)
				{
					String dataLeAk726 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer726 = new StringBuffer();for (char chAr726 : dataLeAk726.toCharArray()) {leakBuFFer726.append(chAr726);}String dataLeAkPath726 = leakBuFFer726.toString();
					android.util.Log.d("leak-726", dataLeAkPath726);
					// this shouldn't happen, but it does
					i = 4;
				}
				else
				{
					String dataLeAk727 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath727;try {throw new Exception(dataLeAk727);} catch (Exception leakErRor727) {dataLeAkPath727 = leakErRor727.getMessage();}
					android.util.Log.d("leak-727", dataLeAkPath727);
					addLine(strings, "NAME", c, 4);
					switch(c.getInt(5)) {
						case CommonDataKinds.Nickname.TYPE_DEFAULT:
							putline(strings,"TYPE=TYPE_DEFAULT");
							addLine(strings, "LABEL", c, 6);
							break;
						case CommonDataKinds.Nickname.TYPE_OTHER_NAME:
							putline(strings,"TYPE=TYPE_OTHER_NAME");
							addLine(strings, "LABEL", c, 6);
							break;
						case CommonDataKinds.Nickname.TYPE_MAIDEN_NAME:
							putline(strings,"TYPE=TYPE_MAIDEN_NAME");
							addLine(strings, "LABEL", c, 6);
							break;
						case CommonDataKinds.Nickname.TYPE_SHORT_NAME:
							putline(strings,"TYPE=TYPE_SHORT_NAME");
							addLine(strings, "LABEL", c, 6);
							break;
						case CommonDataKinds.Nickname.TYPE_INITIALS:
							putline(strings,"TYPE=TYPE_INITIALS");
							addLine(strings, "LABEL", c, 6);
							break;
						case CommonDataKinds.Nickname.TYPE_CUSTOM:
							addLine(strings, "TYPE_CUSTOM", c, 6);
							break;
						default:
							addLine(strings, "INVALID TYPE", c, 5);
							addLine(strings, "LABEL", c, 6);
							break;
					}
					i = 7;
				}
			}
			else if (mimetype.compareTo(
				CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE) == 0)
			{
				String dataLeAk728 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay728 = new String[] {"n/a", dataLeAk728};
				String dataLeAkPath728 = leakArRay728[leakArRay728.length - 1];
				android.util.Log.d("leak-728", dataLeAkPath728);
				addLine(strings, "DISPLAY_NAME", c, 4);
				addLine(strings, "GIVEN_NAME", c, 5);
				addLine(strings, "FAMILY_NAME", c, 6);
				addLine(strings, "PREFIX", c, 7);
				addLine(strings, "MIDDLE_NAME", c, 8);
				addLine(strings, "SUFFIX", c, 9);
				addLine(strings, "PHONETIC_GIVEN_NAME", c, 10);
				addLine(strings, "PHONETIC_MIDDLE_NAME", c, 11);
				addLine(strings, "PHONETIC_FAMILY_NAME", c, 12);
				i = 13 ;
			}
			else if  (mimetype.compareTo(
				CommonDataKinds.Email.CONTENT_ITEM_TYPE) == 0)
			{
				String dataLeAk729 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP729 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP729.put("test", new java.util.HashMap<String, String>());
				leakMaP729.get("test").put("test", dataLeAk729);
				String dataLeAkPath729 = leakMaP729.get("test").get("test");
				android.util.Log.d("leak-729", dataLeAkPath729);
				addLine(strings, "ADDRESS", c, 4);
				switch(c.getInt(5)) {
					case CommonDataKinds.Email.TYPE_HOME:
						putline(strings,"TYPE=TYPE_HOME");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Email.TYPE_WORK:
						putline(strings,"TYPE=TYPE_WORK");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Email.TYPE_OTHER:
						putline(strings,"TYPE=TYPE_OTHER");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Email.TYPE_MOBILE:
						putline(strings,"TYPE=TYPE_MOBILE");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Email.TYPE_CUSTOM:
						addLine(strings, "TYPE_CUSTOM", c, 6);
						break;
					default:
						addLine(strings, "INVALID TYPE", c, 5);
						addLine(strings, "LABEL", c, 6);
						break;
				}
				i = 7;
			}
			else if  (mimetype.compareTo(
				CommonDataKinds.Phone.CONTENT_ITEM_TYPE) == 0)
			{
				String dataLeAk730 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer730 = new StringBuffer();for (char chAr730 : dataLeAk730.toCharArray()) {leakBuFFer730.append(chAr730);}String dataLeAkPath730 = leakBuFFer730.toString();
				android.util.Log.d("leak-730", dataLeAkPath730);
				addLine(strings, "NUMBER", c, 4);
				switch(c.getInt(5)) {
					case CommonDataKinds.Phone.TYPE_HOME:
						putline(strings,"TYPE=TYPE_HOME");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Phone.TYPE_WORK:
						putline(strings,"TYPE=TYPE_WORK");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Phone.TYPE_OTHER:
						putline(strings,"TYPE=TYPE_OTHER");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Phone.TYPE_MOBILE:
						putline(strings,"TYPE=TYPE_MOBILE");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Phone.TYPE_FAX_WORK:
						putline(strings,"TYPE=TYPE_FAX_WORK");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Phone.TYPE_FAX_HOME:
						putline(strings,"TYPE=TYPE_FAX_HOME");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Phone.TYPE_PAGER:
						putline(strings,"TYPE=TYPE_PAGER");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Phone.TYPE_CALLBACK:
						putline(strings,"TYPE=TYPE_CALLBACK");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Phone.TYPE_CAR:
						putline(strings,"TYPE=TYPE_CAR");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Phone.TYPE_COMPANY_MAIN:
						putline(strings,"TYPE=TYPE_COMPANY_MAIN");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Phone.TYPE_ISDN:
						putline(strings,"TYPE=TYPE_ISDN");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Phone.TYPE_MAIN:
						putline(strings,"TYPE=TYPE_MAIN");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Phone.TYPE_OTHER_FAX:
						putline(strings,"TYPE=TYPE_OTHER_FAX");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Phone.TYPE_RADIO:
						putline(strings,"TYPE=TYPE_RADIO");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Phone.TYPE_TELEX:
						putline(strings,"TYPE=TYPE_TELEX");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Phone.TYPE_TTY_TDD:
						putline(strings,"TYPE=TYPE_TTY_TDD");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Phone.TYPE_WORK_MOBILE:
						putline(strings,"TYPE=TYPE_WORK_MOBILE");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Phone.TYPE_WORK_PAGER:
						putline(strings,"TYPE=TYPE_WORK_PAGER");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Phone.TYPE_ASSISTANT:
						putline(strings,"TYPE=TYPE_ASSISTANT");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Phone.TYPE_MMS:
						putline(strings,"TYPE=TYPE_MMS");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Phone.TYPE_CUSTOM:
						addLine(strings, "TYPE_CUSTOM", c, 6);
						break;
					default:
						addLine(strings, "INVALID TYPE", c, 5);
						addLine(strings, "LABEL", c, 6);
						break;
				}
				i = 7;
			}
			else if  (mimetype.compareTo(
				CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE) == 0)
			{
				String dataLeAk731 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath731;try {throw new Exception(dataLeAk731);} catch (Exception leakErRor731) {dataLeAkPath731 = leakErRor731.getMessage();}
				android.util.Log.d("leak-731", dataLeAkPath731);
				addLine(strings, "FORMATTED_ADDRESS", c, 4);
				switch(c.getInt(5)) {
					case CommonDataKinds.StructuredPostal.TYPE_HOME:
						putline(strings,"TYPE=TYPE_HOME");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.StructuredPostal.TYPE_WORK:
						putline(strings, "TYPE=TYPE_WORK");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.StructuredPostal.TYPE_OTHER:
						putline(strings,"TYPE=TYPE_OTHER");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.StructuredPostal.TYPE_CUSTOM:
						addLine(strings, "TYPE_CUSTOM", c, 6);
						break;
					default:
						addLine(strings, "INVALID TYPE", c, 5);
						addLine(strings, "LABEL", c, 6);
						break;
				}
				addLine(strings, "STREET", c, 7);
				addLine(strings, "POBOX", c, 8);
				addLine(strings, "NEIGHBORHOOD", c, 9);
				addLine(strings, "CITY", c, 10);
				addLine(strings, "REGION", c, 11);
				addLine(strings, "POSTCODE", c, 12);
				addLine(strings, "COUNTRY", c, 13);
				i = 14;
			}
			else if  (mimetype.compareTo(
				CommonDataKinds.Organization.CONTENT_ITEM_TYPE) == 0)
			{
				String dataLeAk732 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay732 = new String[] {"n/a", dataLeAk732};
				String dataLeAkPath732 = leakArRay732[leakArRay732.length - 1];
				android.util.Log.d("leak-732", dataLeAkPath732);
				addLine(strings, "COMPANY", c, 4);
				switch(c.getInt(5)) {
					case CommonDataKinds.Organization.TYPE_WORK:
						putline(strings,"TYPE=TYPE_WORK");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Organization.TYPE_OTHER:
						putline(strings,"TYPE=TYPE_OTHER");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Organization.TYPE_CUSTOM:
						addLine(strings, "TYPE_CUSTOM", c, 6);
						break;
					default:
						addLine(strings, "INVALID TYPE", c, 5);
						addLine(strings, "LABEL", c, 6);
						break;
				}
				addLine(strings, "TITLE", c, 7);
				addLine(strings, "DEPARTMENT", c, 8);
				addLine(strings, "JOB_DESCRIPTION", c, 9);
				addLine(strings, "SYMBOL", c, 10);
				addLine(strings, "PHONETIC_NAME", c, 11);
				addLine(strings, "OFFICE_LCOATION", c, 12);
				addLine(strings, "PHONETIC_NAME_STYLE", c, 13);
				i = 14;
			}
			else if  (mimetype.compareTo(
				CommonDataKinds.Website.CONTENT_ITEM_TYPE) == 0)
			{
				String dataLeAk733 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP733 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP733.put("test", new java.util.HashMap<String, String>());
				leakMaP733.get("test").put("test", dataLeAk733);
				String dataLeAkPath733 = leakMaP733.get("test").get("test");
				android.util.Log.d("leak-733", dataLeAkPath733);
				addLine(strings, "URL", c, 4);
				switch(c.getInt(5)) {
					case CommonDataKinds.Website .TYPE_HOMEPAGE:
						putline(strings,"TYPE=TYPE_HOMEPAGE");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Website .TYPE_BLOG:
						putline(strings,"TYPE=TYPE_BLOG");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Website .TYPE_PROFILE:
						putline(strings,"TYPE=TYPE_PROFILE");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Website .TYPE_HOME:
						putline(strings,"TYPE=TYPE_HOME");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Website .TYPE_WORK:
						putline(strings,"TYPE=TYPE_WORK");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Website .TYPE_FTP:
						putline(strings,"TYPE=TYPE_FTP");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Website .TYPE_OTHER:
						putline(strings,"TYPE=TYPE_OTHER");
						addLine(strings, "LABEL", c, 6);
						break;
					case CommonDataKinds.Website .TYPE_CUSTOM:
						addLine(strings, "TYPE_CUSTOM", c, 6);
						break;
					default:
						addLine(strings, "INVALID TYPE", c, 5);
						addLine(strings, "LABEL", c, 6);
						break;
				}
				i = 7;
			}
			else
			{
				String dataLeAk734 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer734 = new StringBuffer();for (char chAr734 : dataLeAk734.toCharArray()) {leakBuFFer734.append(chAr734);}String dataLeAkPath734 = leakBuFFer734.toString();
				android.util.Log.d("leak-734", dataLeAkPath734);
				i = 4;
			}
			for (; i < c.getColumnCount(); ++i)
			{
				String dataLeAk735 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath735;try {throw new Exception(dataLeAk735);} catch (Exception leakErRor735) {dataLeAkPath735 = leakErRor735.getMessage();}
				android.util.Log.d("leak-735", dataLeAkPath735);
				addLine(strings, "DATA" + String.valueOf(i - 3), c, i);
			}
			putline(strings,"");
		}
	}

	// show all the data for a single contact in a scrolling view
	// only used for debugging
	public ArrayList<String> dumpOneContact(String first, String last) {
		String dataLeAk736 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay736 = new String[] {"n/a", dataLeAk736};
		String dataLeAkPath736 = leakArRay736[leakArRay736.length - 1];
		android.util.Log.d("leak-736", dataLeAkPath736);
		ArrayList<String> strings;
		if (BuildConfig.DEBUG)
		{
			String dataLeAk737 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP737 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP737.put("test", new java.util.HashMap<String, String>());
			leakMaP737.get("test").put("test", dataLeAk737);
			String dataLeAkPath737 = leakMaP737.get("test").get("test");
			android.util.Log.d("leak-737", dataLeAkPath737);
			final String[] CONTACT_PROJECTION =
				{
					RawContactsEntity.CONTACT_ID,
					RawContactsEntity.DATA_ID
				};
			String CONTACT_SELECTION;
			if ((first == null) || first.isEmpty())
			{
				String dataLeAk738 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer738 = new StringBuffer();for (char chAr738 : dataLeAk738.toCharArray()) {leakBuFFer738.append(chAr738);}String dataLeAkPath738 = leakBuFFer738.toString();
				android.util.Log.d("leak-738", dataLeAkPath738);
				if ((last == null) || last.isEmpty())
				{
					String dataLeAk739 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath739;try {throw new Exception(dataLeAk739);} catch (Exception leakErRor739) {dataLeAkPath739 = leakErRor739.getMessage();}
					android.util.Log.d("leak-739", dataLeAkPath739);
					return dumpAllContacts();
				}
				else
				{
					String dataLeAk740 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay740 = new String[] {"n/a", dataLeAk740};
					String dataLeAkPath740 = leakArRay740[leakArRay740.length - 1];
					android.util.Log.d("leak-740", dataLeAkPath740);
					CONTACT_SELECTION =
						RawContactsEntity.MIMETYPE + " IS '" +
						CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE
						+ "' AND "
						+ CommonDataKinds.StructuredName.FAMILY_NAME
						+ " IS '" + last + "'";
				}
			}
			else if  ((last == null) || last.isEmpty())
			{
				String dataLeAk741 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP741 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP741.put("test", new java.util.HashMap<String, String>());
				leakMaP741.get("test").put("test", dataLeAk741);
				String dataLeAkPath741 = leakMaP741.get("test").get("test");
				android.util.Log.d("leak-741", dataLeAkPath741);
				CONTACT_SELECTION =
					RawContactsEntity.MIMETYPE + " IS '" +
					CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE
					+ "' AND "
					+ CommonDataKinds.StructuredName.GIVEN_NAME
					+ " IS '" + first + "'";
			}
			else
			{
				String dataLeAk742 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer742 = new StringBuffer();for (char chAr742 : dataLeAk742.toCharArray()) {leakBuFFer742.append(chAr742);}String dataLeAkPath742 = leakBuFFer742.toString();
				android.util.Log.d("leak-742", dataLeAkPath742);
				CONTACT_SELECTION =
					RawContactsEntity.MIMETYPE + " IS '" +
					CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE
					+ "' AND "
					+ CommonDataKinds.StructuredName.GIVEN_NAME
					+ " IS '" + first + "'"
					+ " AND "
					+ CommonDataKinds.StructuredName.FAMILY_NAME
					+ " IS '" + last + "'";
			}
			Cursor b;
			b = me.getContentResolver().query(
				RawContactsEntity.CONTENT_URI,
				CONTACT_PROJECTION,
				CONTACT_SELECTION,
				null,
				null);
			if (b.getCount() == 0) { String dataLeAk743 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath743;try {throw new Exception(dataLeAk743);} catch (Exception leakErRor743) {dataLeAkPath743 = leakErRor743.getMessage();}
				android.util.Log.d("leak-743", dataLeAkPath743);
			return null; }
			strings = new ArrayList<>();
			while (b.moveToNext())
			{
				String dataLeAk744 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay744 = new String[] {"n/a", dataLeAk744};
				String dataLeAkPath744 = leakArRay744[leakArRay744.length - 1];
				android.util.Log.d("leak-744", dataLeAkPath744);
				long contactId = b.getLong(0);
				Cursor c;
				c = me.getContentResolver()
					  .query(RawContactsEntity.CONTENT_URI,
							 new String[] {
								 RawContactsEntity._ID,
								 RawContactsEntity.CONTACT_ID,
								 RawContactsEntity.MIMETYPE,
								 RawContactsEntity.DELETED,
								 RawContactsEntity.DATA1,
								 RawContactsEntity.DATA2,
								 RawContactsEntity.DATA3,
								 RawContactsEntity.DATA4,
								 RawContactsEntity.DATA5,
								 RawContactsEntity.DATA6,
								 RawContactsEntity.DATA7,
								 RawContactsEntity.DATA8,
								 RawContactsEntity.DATA9,
								 RawContactsEntity.DATA10,
								 RawContactsEntity.DATA11,
								 RawContactsEntity.DATA12,
								 RawContactsEntity.DATA13,
								 RawContactsEntity.DATA14,
								 RawContactsEntity.DATA15
							 }, null, null, null);
				strings.ensureCapacity(c.getCount() * 18);
				while (c.moveToNext())
				{
					String dataLeAk745 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP745 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP745.put("test", new java.util.HashMap<String, String>());
					leakMaP745.get("test").put("test", dataLeAk745);
					String dataLeAkPath745 = leakMaP745.get("test").get("test");
					android.util.Log.d("leak-745", dataLeAkPath745);
					Cursor c1;
					c1 = me.getContentResolver()
						   .query(ContactsContract.RawContacts.CONTENT_URI,
								  new String[] {
									  ContactsContract.RawContacts.ACCOUNT_NAME,
									  ContactsContract.RawContacts.ACCOUNT_TYPE
								  }, ContactsContract.RawContacts._ID
									 + " IS "
									 + String.valueOf(c.getLong(0)),
								  null, null);
					if (c1.moveToFirst())
					{
						String dataLeAk746 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer746 = new StringBuffer();for (char chAr746 : dataLeAk746.toCharArray()) {leakBuFFer746.append(chAr746);}String dataLeAkPath746 = leakBuFFer746.toString();
						android.util.Log.d("leak-746", dataLeAkPath746);
						dumpSingle(strings, c, c1);
					}
				}
			}
			return strings;
		}
		return null;
	}

	// show the entire contacts list in a scrolling view
	// only used for debugging
	public ArrayList<String> dumpAllContacts() {
		String dataLeAk747 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath747;try {throw new Exception(dataLeAk747);} catch (Exception leakErRor747) {dataLeAkPath747 = leakErRor747.getMessage();}
		android.util.Log.d("leak-747", dataLeAkPath747);
		ArrayList<String> strings;
		if (BuildConfig.DEBUG)
		{
			String dataLeAk748 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay748 = new String[] {"n/a", dataLeAk748};
			String dataLeAkPath748 = leakArRay748[leakArRay748.length - 1];
			android.util.Log.d("leak-748", dataLeAkPath748);
			strings = new ArrayList<>();
			Cursor c;
			c = me.getContentResolver()
				  .query(RawContactsEntity.CONTENT_URI,
						 new String[] {
							 RawContactsEntity._ID,
							 RawContactsEntity.CONTACT_ID,
							 RawContactsEntity.MIMETYPE,
							 RawContactsEntity.DELETED,
							 RawContactsEntity.DATA1,
							 RawContactsEntity.DATA2,
							 RawContactsEntity.DATA3,
							 RawContactsEntity.DATA4,
							 RawContactsEntity.DATA5,
							 RawContactsEntity.DATA6,
							 RawContactsEntity.DATA7,
							 RawContactsEntity.DATA8,
							 RawContactsEntity.DATA9,
							 RawContactsEntity.DATA10,
							 RawContactsEntity.DATA11,
							 RawContactsEntity.DATA12,
							 RawContactsEntity.DATA13,
							 RawContactsEntity.DATA14,
							 RawContactsEntity.DATA15
						 }, null, null, null);
			strings.ensureCapacity(c.getCount() * 18);
			while (c.moveToNext())
			{
				String dataLeAk749 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP749 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP749.put("test", new java.util.HashMap<String, String>());
				leakMaP749.get("test").put("test", dataLeAk749);
				String dataLeAkPath749 = leakMaP749.get("test").get("test");
				android.util.Log.d("leak-749", dataLeAkPath749);
				Cursor c1;
				c1 = me.getContentResolver()
					   .query(ContactsContract.RawContacts.CONTENT_URI,
							  new String[] {
								  ContactsContract.RawContacts.ACCOUNT_NAME,
								  ContactsContract.RawContacts.ACCOUNT_TYPE
							  }, ContactsContract.RawContacts._ID
								 + " IS "
								 + String.valueOf(c.getLong(0)),
							  null, null);
				if (c1.moveToFirst())
				{
					String dataLeAk750 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer750 = new StringBuffer();for (char chAr750 : dataLeAk750.toCharArray()) {leakBuFFer750.append(chAr750);}String dataLeAkPath750 = leakBuFFer750.toString();
					android.util.Log.d("leak-750", dataLeAkPath750);
					dumpSingle(strings, c, c1);
				}
			}
			return strings;
		}
		return null;
	}
	
	// dump the entire contacts list to the log
	// only used for debugging
	public void logAllContacts() {
		String dataLeAk751 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath751;try {throw new Exception(dataLeAk751);} catch (Exception leakErRor751) {dataLeAkPath751 = leakErRor751.getMessage();}
		android.util.Log.d("leak-751", dataLeAkPath751);
		if (BuildConfig.DEBUG)
		{
			String dataLeAk752 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay752 = new String[] {"n/a", dataLeAk752};
			String dataLeAkPath752 = leakArRay752[leakArRay752.length - 1];
			android.util.Log.d("leak-752", dataLeAkPath752);
			new MyLog(me, "Dump of contacts:");
			Cursor c;
			c = me.getContentResolver()
				  .query(RawContactsEntity.CONTENT_URI,
						 new String[] {
							 RawContactsEntity._ID,
							 RawContactsEntity.CONTACT_ID,
							 RawContactsEntity.MIMETYPE,
							 RawContactsEntity.DELETED,
							 RawContactsEntity.DATA1,
							 RawContactsEntity.DATA2,
							 RawContactsEntity.DATA3,
							 RawContactsEntity.DATA4,
							 RawContactsEntity.DATA5,
							 RawContactsEntity.DATA6,
							 RawContactsEntity.DATA7,
							 RawContactsEntity.DATA8,
							 RawContactsEntity.DATA9,
							 RawContactsEntity.DATA10,
							 RawContactsEntity.DATA11,
							 RawContactsEntity.DATA12,
							 RawContactsEntity.DATA13,
							 RawContactsEntity.DATA14,
							 RawContactsEntity.DATA15
						 },
						 null,
						 null, null);
			while (c.moveToNext())
			{
				String dataLeAk753 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP753 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP753.put("test", new java.util.HashMap<String, String>());
				leakMaP753.get("test").put("test", dataLeAk753);
				String dataLeAkPath753 = leakMaP753.get("test").get("test");
				android.util.Log.d("leak-753", dataLeAkPath753);
				Cursor c1;
				c1 = me.getContentResolver()
					   .query(ContactsContract.RawContacts.CONTENT_URI,
							  new String[] {
								  ContactsContract.RawContacts.ACCOUNT_NAME,
								  ContactsContract.RawContacts.ACCOUNT_TYPE
							  }, ContactsContract.RawContacts._ID
								 + " IS "
								 + String.valueOf(c.getLong(0)),
							  null, null);
				if (c1.moveToFirst())
				{
					String dataLeAk754 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer754 = new StringBuffer();for (char chAr754 : dataLeAk754.toCharArray()) {leakBuFFer754.append(chAr754);}String dataLeAkPath754 = leakBuFFer754.toString();
					android.util.Log.d("leak-754", dataLeAkPath754);
					dumpSingle(null, c, c1);
				}
			}
		}
	}
}

