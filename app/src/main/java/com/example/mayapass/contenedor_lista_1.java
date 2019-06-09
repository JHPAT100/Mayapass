package com.example.mayapass;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link contenedor_lista_1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link contenedor_lista_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class contenedor_lista_1 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    private OnFragmentInteractionListener mListener;


    private RecyclerView list;
    private ListView lista;
    private Adaptador_lista_1 adaptador;



    String [][] comidas ={
            {"La Tortilla de maíz","Es uno de los alimentos más importantes en la comida de los mayas, esta se hace a base de granos de maíz molido, hay distintos tipos de tortilla como las gorditas, y las tortilla delgadas.\n " + "\n" + "Estas se suelen hacer de granos de maíz remojados en agua con un poco cal diluida(aunque se puede hacer sin necesidad de remojar los granos en agua con cal), estos granos se sancochan  durante una o dos horas y despues se deja enfriar para el día siguiente, cuando se le puede moler, despues de molerlo se toma un poco de la masa y se pone entre dos trozos de nailon y se redondea y palmean hasta formar un disco y despues se procede a ponerlo en un comal caliente.\n"+"\n"+"Puede haber variaciones en el método de preparación y los materiales utilizados, algunos suelen usar manteca y/o frijol en la masa."},
            {"El Pozole","Este platillo fue documentado por varios de los frailes (algunos peninsulares, otros criollos o incluso mestizos) que llegaron a la Nueva España años después de la caída de Tenochtitlán. Entre ellos destaca Fray Bernardino de Sahagún, quien escribió sobre el singular platillo en su obra: Historia general de las cosas de la Nueva España. Lo describió con repugnancia ya que la carne que se utilizaba era obtenida de los prisioneros sacrificados, este platillo era repartido entre los sacerdotes y/o gobernantes.\n" +"\n"+"el pozole actual a tenido ciertas modificaciones en los ingredientes, ya que actualmente en el pozole se usan ingredientes provenientes de Asia, la carne usada es la de cerdo y dependiendo de la región en la cual es preparado este puede ser de color verde, blanca o roja."},
            {"El Frijol","Esta legumbre es utilizada para elaborar una gran variedad de platillos como el frijol con puerco, tamales de frijol, tortillas con frijol, entre otros, se suele preparar principalmente sancochado en agua hirviendo, estos son cubiertos de agua y enjuagados, despues son escurridos y puestos puestos a hervir en una holla con agua, los condimentos e ingredientes pueden variar, se le puede agregar carne de puerco, conos de masa(llamados coloquialmente como joroches o jorochitos) y yerbabuena, el tiempo de cocción suele variar dependiendo del tipo de frijol usado, algunas veces cuando el caldo es escaso y quedan muchos granos de frijol, este se tamula hasta formar una masa espesa."},
            {"El Chocolate","El cacao ya era cultivado por los mayas hace más de 2,500 años. El nombre “cacao” deriva de la palabra náhuatl cacahoatl o cacahuatl, que significa “jugo amargo”, y “chocolate”, a su vez, lo hace de la palabra maya chocol, la cual significa “caliente” y “agua”, respectivamente.\n"+"\n"+"Era preparado con agua y chile. Fueron los españoles quienes le añadieron azúcar y leche a esta bebida para hacerla dulce, los nobles hacían cocer el cacao con agua y para endulzarlo, le agregaban miel silvestre o jugo dulce de arce, aromatizándolo con un poco de vainilla, y la gente sencilla le agregaba atole de maíz para hacerlo nutritivo. Las semillas tambien eran utilizadas como un tipo de moneda."},
            {"El Poc Chuc","Esta es la forma maya de llamarle al proceso de salar la carne para poder conservarla sin que ésta se eche a perder, la única diferencia es que los mayas agregan zumo de naranja para atenuar el sabor salado.\n"+"\n"+"Hay algunos historiadores que consideran que los mayas hacían el poc chuc con carne de lisa o pecari, asada y salada sobre piedras calientes (comal) y que era muy diferente a la que conocemos en la actualidad,  En un principio este guiso consistía en un pedazo de carne de puerco salado y asado a las brasas, acompañado de media naranja agria y una salsa de chile habanero y tomates (chiltomate).\n"+"\n"+"Al guiso se le agreg una nueva salsa a base de cebollas moradas asadas picadas y rociadas con jugo de naranja agria y un poco de vinagre. Y si contamos precisamente con estos otros ingredientes (naranja agria, cebollas, además del puerco) podemos afirmar que el plato se modifico totalmente después de la conquista"},
            {"Los Tamales","Para los mayas los tamales fueron tanto un alimento básico como una comida ceremonial. La identificación del llamado signo T30 –cuyo valor fonético es waaj– con el tamal ha permitido establecer que éste fue el principal platillo de maíz entre los mayas del Clásico, A este platillo se le atribuían dimensiones simbólicas; por ejemplo, se le relacionaba con varias deidades –como el dios del maíz, el dios K y el dios N–, y además el glifo emblema wah parece referirse a cierta región sobrenatural. Esta asociación con las deidades puede deberse a que los tamales fueron una de las principales ofrendas a los dioses, por ejemplo durante el ciclo de 819 días. Este papel como ofrenda principal también se ve en los códices del Posclásico y en las ceremonias contemporáneas.\n"+"\n"+"Los ingredientes de los tamales suelen variar desde carne de puerco, pollo , res, frijol, etc."},
            {"Los Panuchos","Se trata de tortillas de maíz rellenas con frijol y aderezadas en la parte de arriba con carne y vegetales. Existen diferentes variantes de Panucho, los hay de carne asada, de pollo empanizado, de cochinita pibil, de relleno negro e incluso solo de huevo, y claro, los más populares, de pollo o pavo. El modo de preparación es el mismo. Son pequeñas tortillas de maíz fritas hechas a mano, a las que se les hace ua corte por el que se mete un guiso hecho a base de frijol y que luego son fritas en aceite o manteca de cerdo.\n"+"\n"+"Este platillo tiene una historia muy curiosa. Resulta ser que en los tiempos de la colonia, cuando no había muchas opciones para los viajeros que iban desde Mérida a Campeche por el Camino Real, solían comprar comida a “Don Hucho”, un comerciante que se instalaba en esta vía, un día Don Hucho no tenía gran cosa que ofrecer y llegó a sus vías un caminante hambriento. Entonces, el ingenioso Hucho aprovechó lo que tenía a la mano: Frijol colado y Huevo sancochado para su visitante, untó los ingredientes en un pan y el sabor resultó ser muy agradable. Tomó popularidad al pasar el tiempo y fue conocido como “el pan de Don Hucho”. Cuyo nombre se transformaría en Panucho"},
            {"Los Salbutes","Son muy parecidos a los panuchos, la diferencia, es el frijol que rellena la tortilla, en los salbutes, la tortilla no se rellena y ésta se hace generalmente a mano y en ocasiones puede llegar a inflarse un poco al freirse; de la misma manera que el panucho, debe quedar casi dorado antes de retirar del aceite. También puede ser de relleno negro, de cochinita, de huevo y de carne asada o empanizada, aunque la carne más común es la de pollo o pavo. Del maya sáal, ligero y buth, relleno, es decir de relleno ligero o poco relleno. estos bocadilos pueden ser consumidos acualquier hora del dia debido a que son ligeros de digerir, los ingredientes pueden variar dependiendo de la zona en la cual se prepare ya que en algunos lugares se agregan o quiten ciertos ingredientes."},
            {"La Cochinita pibíl","La cochinita pibil tiene sus orígenes en la época prehispánica, cuando se degustaba en su celebración más importante el Hanal Pixán, en la que se ofrenda comida y bebida a las almas de los fieles difuntos del 31 de octubre al 2 de noviembre., El platillo se elaboraba con carne de faisán, jabalí o venado y se cocía en el pib que significa horno de tierra. Pero durante la Colonia la carne de esos animales fue reemplazada por la de cerdo. Gracias a las modificaciones que se le realizaron despues de la conquista se podría decir que la cochinita pibil actual nacio gracias a la union de las 2 culturas."},
            {"El Atole","Se desgrana el maíz, y se prepara como nixtamal, k’u’um, luego se le muele y deslíe. Si se quiere agrio se agrega agua hervida y se deja reposar una noche antes de calentar de nuevo. Si se quiere dulce, ch’ujuk sa’ ya desleída se sancocha, se meten las semillas en agua herviendo y se deja hasta que queda tibia. Luego se quita el agua, para que no quede agrio, el atole puede tener variaciones como por ejemplo: el Atole con camote, en este se remoja un día el maíz desgranado, se muele con camote, y se sancocha, el Atole con pepita menuda. Se prepare el atole y se agrega pepita tostada molida y el Atole de pinole (k’áaji sa’) en el cual se mezcla el pinole con agua caliente, y se agrega sal o azúcar, entre otros."}

    };

    int [] imgComida ={R.drawable.icono_t,R.drawable.icono_t,R.drawable.icono_t,R.drawable.icono_t,R.drawable.icono_t,
                       R.drawable.icono_t,R.drawable.icono_t,R.drawable.icono_t,R.drawable.icono_t,R.drawable.icono_t};








    public contenedor_lista_1() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment contenedor_lista_1.
     */
    // TODO: Rename and change types and number of parameters
    public static contenedor_lista_1 newInstance(String param1, String param2) {
        contenedor_lista_1 fragment = new contenedor_lista_1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);



        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       View vista = inflater.inflate(R.layout.fragment_contenedor_lista_1,container,false);

       list = vista.findViewById(R.id.lista);

       list.setAdapter(new Adaptador_lista_1(this,comidas,imgComida));

        return vista;

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



}
