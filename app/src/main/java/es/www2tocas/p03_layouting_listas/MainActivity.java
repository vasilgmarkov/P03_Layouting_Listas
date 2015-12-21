package es.www2tocas.p03_layouting_listas;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String productos = "1:Cireres:Cireres vermelles:1.56:img000.jpg\n" +
            "2:Plàtan:Plàtan boníssim:0.15:img001.jpg\n" +
            "3:Pastís:Pastís d'aniversari:12.99:img002.jpg\n" +
            "4:Barra de pa:De la nostra fleca:0.42:img003.jpg\n" +
            "5:Pa dolç:Dolç i bo:0.65:img004.jpg\n" +
            "6:Croissant:Fet al moment:0.85:img005.jpg\n" +
            "7:Bistec de vedella 1/2Kg:Alta qualitat:14.50:img006.jpg\n" +
            "8:Panet de llet:Ideal per als nens:0.15:img007.jpg\n" +
            "9:Dotzena d'ous:Gallines de proximitat:1.89:img008.jpg\n" +
            "10:Farina:Farina. Fina, fina:0.99:img009.jpg\n" +
            "11:Raïm:Boníssim i sa:1.24:img010.jpg\n" +
            "12:Pernil cuït:Suau, baix en sal:9.99:img011.jpg\n" +
            "13:Piruleta:Sabor maduixa:0.10:img012.jpg\n" +
            "14:Poma:Poma deliciosa:0.23:img013.jpg\n" +
            "15:Pera:Pera ben bona:0.24:img014.jpg\n" +
            "16:Pinya:Ideal amanides fresques:1.50:img015.jpg\n" +
            "17:Maduixes:Vermelles i boníssimes:1.25:img016.jpg\n" +
            "18:Sucre:Per endolcir-te la vida:0.99:img017.jpg\n" +
            "19:Síndria:Estupenda i sana:3.65:img018.jpg\n" +
            "20:Llet:Semidesnatada:0.75:img019.jpg\n" +
            "21:Cafè:Mólt d'alta qualitat:0.76:img020.jpg\n" +
            "22:Àpat preparat:Si no pots cuinar:5.85:img021.jpg\n" +
            "23:Pizza:De 4 formatges:3.55:img022.jpg\n" +
            "24:Salmó:De la canya al sarronet:4.56:img023.jpg\n" +
            "25:Pésols:Ideals com a acompanyament:0.55:img024.jpg\n" +
            "26:Bolets:Dónen gust a tots els dinars:0.42:img025.jpg\n" +
            "27:Ceba:Dolça que no fa plorar:0.35:img026.jpg\n" +
            "28:Formatge:Semisec, boníssim:2.30:img027.jpg\n" +
            "29:Pastanaga:Ideal amanides:0.21:img028.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Producto> stock = new ArrayList<>();
        String[] items = productos.split("\n");
        for (int i=0;i<productos.length();i++){
            String[] item = items[i].split(":");
            Producto producto = new Producto();
            producto.pos=item[0];
            producto.name=item[1];
            producto.info=item[2];
            producto.price=Double.parseDouble(item[3]);
            producto.img=Uri.parse(item[4]);
            stock.add(producto);

        }
        ArrayAdapter<String> productos1 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, items);
        Spinner spiner1 = (Spinner) findViewById(R.id.spinner);
      spiner1.setAdapter(productos1);
        }


    private class Producto {
        public String pos;
        public String name;
        public String info;
        public double price;
        public Uri img;

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

  /*  private class ContactAdapter extends BaseAdapter {
        private Context context;
        private ArrayList<Producto> contacts;

        public ContactAdapter(Context context, ArrayList<Producto> contacts) {
            this.context = context;
            this.contacts = contacts;
        }

        @Override public int getCount() { return contacts.size(); }
        @Override public Object getItem(int position) { return contacts.get(position); }
        @Override public long getItemId(int position) { return position; }

     @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.contact_list_item, parent, false);
                ViewInfo viewInfo = new ViewInfo(view);
                view.setTag(viewInfo);
            }
            ViewInfo viewInfo = (ViewInfo) view.getTag();
            Contact contact = contacts.get(position);
            viewInfo.setContact(contact);
            view.setOnClickListener(MainActivity.this);
            return view;
        }
    }
*/



}
