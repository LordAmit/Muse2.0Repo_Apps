Leak Detected in 2.5.1, 2.6.1, but not in 2.7.1

Type: Fragment0

Fragment0 has source variable declared in Activity class as static string, source in assigned value at OnCreate method in Activity, and Sink is in the Fragment Constructor. The fragment is declared within Activity class as static. 

Fragment class shortened:

   public static class SimpleFragment extends Fragment {


        public SimpleFragment() {
            // Required empty public constructor
            android.util.Log.d("leak-0-1", dataLeAk0);
        }

    }
    
Activity Class Shortened:

public class MainActivity extends AppCompatActivity {

    int i = 0;
    static String dataLeAk0 = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new SimpleFragment())
                .commit();
    }
}
