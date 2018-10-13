package com.example.hassan.cs478proj2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView listView = (ListView) findViewById(R.id.listView);
        String[] adapterStrings = {"Could ", "not"," find"};
        String[] toyotaDealers = {"Team Toyota\n400 Indianapolis Blvd,\n" + "Schererville, IN 46375", "Bredemann Toyota/Scion\n1301 W Dempster St.,\n" + "Park Ridge, IL 60068", "Oakbrook Toyota in Westmont\n" + "550 E Ogden Ave,\n" + "Westmont, IL 60559"};
        String[] jaguarDealers = {"Imperial Motors Jaguar of Lake Bluff\n" + "150 Skokie Highway,\n" + "Lake Bluff, IL 60044", "Howard Orloff Jaguar, Volvo Cars, Land Rover\n" + "1924 N Paulina St,\n" + "Chicago, IL 60622", "Jaguar Land Rover Northfield\n" + "670 Frontage Rd,\n" + "Northfield, IL 60093"};
        String[] infinitiDealers = {"Berman INFINITI Chicago\n" + "640 N La Salle Dr,\n" + "Chicago, IL 60654", "INFINITI of Clarendon Hills\n" + "415 Ogden Ave,\n" + "Clarendon Hills, IL 60514", "INFINITI of Naperville\n" + "1550 W Ogden Ave,\n" + "Naperville, IL 60540"};
        String[] hondaDealers = {"McGrath City Honda\n" + "6720 W Grand Ave,\n" + "Chicago, IL 60707", "Honda of Downtown Chicago\n" + "1111 N Clark St #2,\n" + "Chicago, IL 60610", "Continental Honda\n" + "5901 S. LaGrange,\n" + "Countryside, IL 60525"};
        String[] maseratiDealers = {"Bentley Bugatti Lamborghini Maserati Rolls-Royce of Chicago\n" + "834 N Rush St,\n" + "Chicago, IL 60611", "Greater Chicago Motors\n" + "1850 N Elston Ave,\n" + "Chicago, IL 60642", "Napleton Aston Martin Maserati\n" + "217 E Ogden Ave,\n" + "Downers Grove, IL 60515"};
        String[] bmwDealers = {"Laurel BMW of Westmont\n" + "430 E. Ogden Ave.,\n" + "Westmont, IL 60559", "Fields BMW of Northfield\n" + "700 Frontage Rd.,\n" + "Northfield, IL 60093", "Mancuso Motorsports\n" + "677 N Clark St,\n" + "Chicago, IL 60654"};
        Intent i = getIntent();
        int imageID = i.getIntExtra("res_id",-1);
        switch(imageID) {
            case 2131165305:
                adapterStrings = toyotaDealers;
                break;
            case 2131165287:
                adapterStrings = jaguarDealers;
                break;
            case 2131165286:
                adapterStrings = infinitiDealers;
                break;
            case 2131165276:
                adapterStrings = bmwDealers;
                break;
            case 2131165288:
                adapterStrings = maseratiDealers;
                break;
            case 2131165283:
                adapterStrings = hondaDealers;
                break;

        }
        ArrayAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,adapterStrings);
        listView.setAdapter(adapter);
    }
}
