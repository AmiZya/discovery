package my.json;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class main extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
       
        
       
        JSONObject jArray = json.getjson();
        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        
        try {
			//jArray = new JSONObject(readTwitterFeed);
			//status = jArray.getString("status");
			
			JSONArray jsonArray = jArray.getJSONArray("results");
			Log.i("limbofish", jsonArray.toString());
			Log.i(main.class.getName(),"Number of entries " + jsonArray.length());
			
			
			
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				//Log.i("limbofish", jsonObject.getString("name"));
				//Log.i("limbofish", jsonObject.getString("vicinity"));
				
				map.put("id",  String.valueOf(i));
	        	map.put("name", jsonObject.getString("name"));
	        	map.put("vicinity",   jsonObject.getString("vicinity"));
	        	mylist.add(map);
	        	//Log.i("limbo",map.toString());
			}
			
			ListAdapter adapter = new SimpleAdapter(this, mylist , R.layout.main,
					
					                        new String[] { "name", "vicinity" },
					
					                        new int[] { R.id.item_title, R.id.item_subtitle });
					
					 
					
					        setListAdapter(adapter);
					
					 
					
					        final ListView lv = getListView();
					
					        lv.setTextFilterEnabled(true);
					
					        lv.setOnItemClickListener(new OnItemClickListener() {
					
					            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					
					                @SuppressWarnings("unchecked")
					
					                HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);
					
					                //Toast.makeText(main.this, "ID '" + o.get("id") + "' was clicked.", Toast.LENGTH_SHORT).show();
					            	
					            	Intent start = new Intent(main.this , data.class);
					            	start.putExtra("name", o.get("name"));
					            	start.putExtra("vicinity", o.get("vicinity"));
					            	startActivity(start);
					
					 
					
					            }
					
					        });
					        /*
			setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, COUNTRIES));
			
			ListView lv = getListView();
	          lv.setTextFilterEnabled(true);

	          lv.setOnItemClickListener(new OnItemClickListener() {
	        	
	        	  @Override
	            public void onItemClick(AdapterView<?> parent, View view,
	                int position, long id) {
	              // When clicked, show a toast with the TextView text
	        		  Toast.makeText(getApplicationContext(), "this is clicked",Toast.LENGTH_SHORT).show();
	            }
	          });*/
			
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
    static final String[] COUNTRIES = new String[] {
        "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
        "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
        "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan",
        "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium",
        "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
        "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory",
        "British Virgin Islands", "Brunei", "Bulgaria", "Burkina Faso", "Burundi",
        "Cote d'Ivoire", "Cambodia", "Cameroon", "Canada", "Cape Verde",
        "Cayman Islands", "Central African Republic", "Chad", "Chile", "China",
        "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo",
        "Cook Islands", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic",
        "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
        "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea",
        "Estonia", "Ethiopia", "Faeroe Islands", "Falkland Islands", "Fiji", "Finland",
        "Former Yugoslav Republic of Macedonia", "France", "French Guiana", "French Polynesia",
        "French Southern Territories", "Gabon", "Georgia", "Germany", "Ghana", "Gibraltar",
        "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau",
        "Guyana", "Haiti", "Heard Island and McDonald Islands", "Honduras", "Hong Kong", "Hungary",
        "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica",
        "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos",
        "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg",
        "Macau", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands",
        "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia", "Moldova",
        "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia",
        "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand",
        "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "North Korea", "Northern Marianas",
        "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru",
        "Philippines", "Pitcairn Islands", "Poland", "Portugal", "Puerto Rico", "Qatar",
        "Reunion", "Romania", "Russia", "Rwanda", "Sqo Tome and Principe", "Saint Helena",
        "Saint Kitts and Nevis", "Saint Lucia", "Saint Pierre and Miquelon",
        "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Saudi Arabia", "Senegal",
        "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands",
        "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "South Korea",
        "Spain", "Sri Lanka", "Sudan", "Suriname", "Svalbard and Jan Mayen", "Swaziland", "Sweden",
        "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "The Bahamas",
        "The Gambia", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey",
        "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Virgin Islands", "Uganda",
        "Ukraine", "United Arab Emirates", "United Kingdom",
        "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan",
        "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Wallis and Futuna", "Western Sahara",
        "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"
      };
}