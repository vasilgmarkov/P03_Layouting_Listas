package es.www2tocas.p03_layouting_listas;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Producto> listProductos = new ArrayList<>();
    ArrayAdapter<Producto> listAdapter;
    String[] items ={"1:Cireres:Cireres vermelles:1.56:img000",
            "2:Plàtan:Plàtan boníssim:0.15:img001.jpg",
            "3:Pastís:Pastís d'aniversari:12.99:img002.jpg",
            "4:Barra de pa:De la nostra fleca:0.42:img003.jpg",
            "5:Pa dolç:Dolç i bo:0.65:img004.jpg",
            "6:Croissant:Fet al moment:0.85:img005.jpg",
            "7:Bistec de vedella 1/2Kg:Alta qualitat:14.50:img006.jpg",
            "8:Panet de llet:Ideal per als nens:0.15:img007.jpg",
            "9:Dotzena d'ous:Gallines de proximitat:1.89:img008.jpg",
            "10:Farina:Farina. Fina, fina:0.99:img009.jpg",
            "11:Raïm:Boníssim i sa:1.24:img010.jpg" ,
            "12:Pernil cuït:Suau, baix en sal:9.99:img011.jpg" ,
            "13:Piruleta:Sabor maduixa:0.10:img012.jpg" ,
            "14:Poma:Poma deliciosa:0.23:img013.jpg" ,
            "15:Pera:Pera ben bona:0.24:img014.jpg" ,
            "16:Pinya:Ideal amanides fresques:1.50:img015.jpg" ,
            "17:Maduixes:Vermelles i boníssimes:1.25:img016.jpg" ,
            "18:Sucre:Per endolcir-te la vida:0.99:img017.jpg" ,
            "19:Síndria:Estupenda i sana:3.65:img018.jpg" ,
            "20:Llet:Semidesnatada:0.75:img019.jpg" ,
            "21:Cafè:Mólt d'alta qualitat:0.76:img020.jpg" ,
            "22:Àpat preparat:Si no pots cuinar:5.85:img021.jpg" ,
            "23:Pizza:De 4 formatges:3.55:img022.jpg" ,
            "24:Salmó:De la canya al sarronet:4.56:img023.jpg" ,
            "25:Pésols:Ideals com a acompanyament:0.55:img024.jpg" ,
            "26:Bolets:Dónen gust a tots els dinars:0.42:img025.jpg" ,
            "27:Ceba:Dolça que no fa plorar:0.35:img026.jpg" ,
            "28:Formatge:Semisec, boníssim:2.30:img027.jpg" ,
            "29:Pastanaga:Ideal amanides:0.21:img028.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Producto> stock = new ArrayList<>();

           for (int i=0;i<items.length;i++){
            String[] item = items[i].split(":");
            Producto producto = new Producto();
            producto.pos=item[0];
            producto.name=item[1];
            producto.info=item[2];
            producto.price=Double.parseDouble(item[3]);
            producto.img=item[4];
            stock.add(producto);

        }

        final Spinner spiner = (Spinner) findViewById(R.id.spinner);
        final ListView listview = (ListView) findViewById(R.id.listView);

        spiner.setAdapter(new ContactAdapter(this, stock));
        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Producto pos =(Producto) spiner.getItemAtPosition(position);
                listProductos.add(pos);
            //    listAdapter.notifyDataSetChanged();






            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        listview.setAdapter(new ContactAdapter1(this,listProductos));
        }

    @Override
    public void onClick(View v){
        Producto producto = (Producto)v.getTag();
        TextView  total = (TextView) v.findViewById(R.id.total);
        total.setText(producto.name);
    }
    private class Producto {
        public String pos;
        public String name;
        public String info;
        public double price;
        public String img;

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

    private class ViewInfo {
        TextView nombreSpinner, precioSpinner;
        Producto contact;

        public ViewInfo(View view) {
            nombreSpinner = (TextView) view.findViewById(R.id.nombreSpinner);
            precioSpinner = (TextView) view.findViewById(R.id.precioSpinner);

        }

        public void setContact(Producto contact) {
            this.contact = contact;
            nombreSpinner.setText(contact.name);
            precioSpinner.setText(Double.toString(contact.price));

                  }
    }


    private class ViewInfo1 {
        TextView nombre, precio;
        ImageView img;
        Producto contact;

        public ViewInfo1(View view) {
            nombre = (TextView) view.findViewById(R.id.textView1);
            precio = (TextView) view.findViewById(R.id.textView2);
            img = (ImageView) view.findViewById(R.id.imageView);

        }

        public void setContact1(Producto contact) {
            this.contact = contact;
            nombre.setText(contact.name);
            precio.setText(Double.toString(contact.price));
            img.setImageResource(getResources().getIdentifier(contact.img, "drawable", MainActivity.this.getPackageName()));

        }
    }



    private class ContactAdapter extends BaseAdapter {
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
                view = inflater.inflate(R.layout.item_list_spinner, parent, false);
                ViewInfo viewInfo = new ViewInfo(view);
                view.setTag(viewInfo);
            }
            ViewInfo viewInfo = (ViewInfo) view.getTag();
            Producto contact = contacts.get(position);
            viewInfo.setContact(contact);
           // view.setOnClickListener(MainActivity.this);
            return view;
        }


    }

    private class ContactAdapter1 extends BaseAdapter {
        private Context context;
        private ArrayList<Producto> contacts;

        public ContactAdapter1(Context context, ArrayList<Producto> contacts) {
            this.context = context;
            this.contacts = contacts;
        }

        @Override
        public int getCount() { return contacts.size(); }
        @Override public Object getItem(int position) { return contacts.get(position); }
        @Override public long getItemId(int position) { return position; }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.item_list, parent, false);
                ViewInfo1 viewInfo = new ViewInfo1(view);
                view.setTag(viewInfo);
            }
            ViewInfo1 viewInfo = (ViewInfo1) view.getTag();
            Producto contact = contacts.get(position);
            viewInfo.setContact1(contact);
            // view.setOnClickListener(MainActivity.this);
            return view;
        }


    }




}
