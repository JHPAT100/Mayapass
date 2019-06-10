package com.example.mayapass;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mayapass.adapter.adaptador_comida;
import com.example.mayapass.adapter.adaptador_mitos;
import com.example.mayapass.entidades.Mitos;
import com.example.mayapass.entidades.comida;

import java.util.ArrayList;

public class lista_2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
ArrayList<Mitos>listaMitos;
RecyclerView recyclerMitos;
public  static String nombre_r,receta;
    public static int img;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public lista_2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment lista_1.
     */
    // TODO: Rename and change types and number of parameters
    public static lista_2 newInstance(String param1, String param2) {
        lista_2 fragment = new lista_2();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragment_lista_1, container, false);
            listaMitos=new ArrayList<>();
        recyclerMitos=vista.findViewById(R.id.lista_1_1);
        recyclerMitos.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarLista();
       adaptador_mitos adapter= new adaptador_mitos(listaMitos);
       //on
       adapter.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               nombre_r=listaMitos.get(recyclerMitos.getChildAdapterPosition(v)).getNombre();
               receta=listaMitos.get(recyclerMitos.getChildAdapterPosition(v)).getDescripcion();
               img=listaMitos.get(recyclerMitos.getChildAdapterPosition(v)).getFoto();
              FragmentTransaction trans = getFragmentManager().beginTransaction();
               trans.replace(R.id.contenedor_principal, new mostrar_m());
               trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
               trans.addToBackStack(null);

               trans.commit();
           }
       });
       //on

        recyclerMitos.setAdapter(adapter);
        return vista;
    }

    private void llenarLista() {
  //
        listaMitos.add(new Mitos("El Mito Maya del Colibrí. ",
                "Los dioses, habían hecho un colibrí.\n" +
                "\n" +
                "Era tan frágil y tan ligero el colibrí que podía acercarse a las flores más delicadas sin mover uno solo de sus pétalos. Sus plumas brillaban bajo el sol como gotas de lluvia y reflejaban todos los colores.\n" +
                "\n" +
                "Entonces los hombres trataron de atrapar al pájaro precioso para adornarse con sus plumitas.\n" +
                "\n" +                 "Los dioses se enojaron y ordenaron: “si alguien lo atrapa, el colibrí morirá”.\n" +
                "\n" +
                "Por eso, nunca nadie ha visto un colibrí en una jaula ni en la mano de un hombre.\n" +
                "\n" +
                "Así, el misterioso y delicado pajarillo puedo hacer tranquilo su trabajo: llevar de aquí para allá los pensamientos de los hombres. Si te desean un bien, él te trae el deseo; si te desean un mal, él también te lo trae.\n" +
                "\n" +
                "Si un colibrí vuela alrededor de tu cabeza, no lo toques. El tomará tu deseo y lo llevará a los otros; piensa bien y desea cosas buenas para todos. Por algo pasa el colibrí por tu camino; puede ser por bien…o puede ser por mal.", R.drawable.mito1));

        //

        listaMitos.add(new Mitos("El mito maya de la Creación","Según se relata en el Popol Vuh, el libro que recoge la mitología de los indios quichés (de origen maya), el mundo estuvo en un principio cubierto por las aguas y fueron los creadores Tepeu y Gucumatz quienes dieron origen a la tierra, a las plantas y a los animales, Los dioses creadores hicieron de barro a la primera pareja humana, pero eran débiles y apenas podían mantenerse en pie, además de que se deshacían con la lluvia y tampoco podían hablar. La segunda pareja fue hecha de madera, de árbol para él y de carrizo para ella, y todo fue bien en un principio. Los hombres se reprodujeron y se extendieron por el mundo, tenían su lenguaje y hablaban entre ellos pero nunca elevaron su voz hacia los dioses que les habían creado.\n" +
                "\n" +
                "Estos hombres de madera no poseían memoria sobre su pasado y vagaban por el mundo sin saber de sus orígenes divinos, y así vivieron hombres y dioses durante algún tiempo, hasta que una oscura y densa lluvia cayó sobre la Tierra anegando todo. Los segundos hombres desaparecieron y dejaron como única descendencia a los simios.\n" +
                "\n" +
                "Tepeu y Gucumatz lo intentaron por tercera vez, esta vez usando la madera y añadiendo maíz amarillo y maíz rojo. Con la madera hicieron sus partes rígidas, con el maíz blanco moldearon la carne y el maíz rojo fue su sangre. Los primeros cuatro hombres (llamados Balam-Quitzé, Balam Agab; Mahu-cutah; e Iqi -Balam ) fueron interrogados por los curiosos dioses y demostraron poseer inteligencia y memoria, siendo aleccionados por los propios dioses sobre sus orígenes, capacidades y obligaciones futuras.\n" +
                "\n" +
                "La perfección de su obra terminó por intimidar a Tepeu y a Gucumatz, quienes temieron que su creación quisiera alzarse contra ellos y ocupar su lugar. Para evitarlo rociaron sobre los hombres una niebla que les extirpó parte de su visión y parte de su sabiduría, así zanjaron el problema y empezaron con la tarea de crear a la mujer usando los mismos materiales. Así los hombres y mujeres poblaron el mundo pero sin la posibilidad de llegar al conocimiento absoluto, sin forma de llegar a suplantar a sus creadores.",R.drawable.mito2));
        //
        listaMitos.add(new Mitos("El mito de la flor de loto","Entre los mitos mayas más populares, nos encontramos con uno muy especial que nos cuenta el origen de la flor de loto de una manera bastante romántica.Con la selva de Mayab como escenario, un príncipe llamado Chacdziedzib que significa pájaro cardenal se encontraba perdidamente enamorado de la hija del guardián del cenote sagrado, una jovencita que llevaba por nombre Nicté-Há que equivale a flor de loto.\n" +
                "\n" +
                "La oposición del gran Cenote Sagrado frente a la posibilidad del amor entre los jóvenes, dio como resultado que los dioses decretaran la muerte de la mujer, sin embargo un bufón que escuchó todo se encargó de advertirle al príncipe y este tomó la decisión de nombrar a su mejor guerrero como el encargado de rescatar y traer a la princesa para que se pudieran casar.\n" +
                "\n" +
                "Puesto que el guerrero murió en medio del intento, el propio príncipe asumió la misión contando con la luna como aliada, finalmente encontró a su doncella y la abrazó con tan mala suerte de que en ese mismo instante una flecha inesperada atravesó el corazón de la doncella y esta se hundió en las aguas. El dolor por la muerte de su amada fue tan intenso que el corazón del príncipe se hizo pedazos y los dioses finalmente mostraron piedad.\n" +
                "La flor de loto y el pájaro cardenal\n" +
                "\n" +
                "Con la intervención del dios de las aguas y del dios de los pájaros el príncipe se transformó en un pájaro cardenal y la princesa en una hermosa flor de loto, desde entonces el ave le canta al amanecer expresando su amor sincero y profundo.", R.drawable.mito3));
        //
        listaMitos.add(new Mitos("El mito de Quetzalcóatl, el Cristo mexicano.","Quetzalcóatl, habitualmente identificado como la Serpiente Emplumada, traducción de su nombre ‘náhuatl’.Dios y rey-sacerdote de origen aztecas, los mayas lo llamaron Kukulcán y Votan tiempo después para los quichés; llamado por algunos Antropólogos el “Cristo Mejicano”, por su aparición en la historia mexicana como un Ser a veces divino y a veces humano, donde lo Divino se humaniza y lo humano se diviniza, considerado el símbolo de la muerte y de la resurrección, marcando los principios religiosos de todas las culturas precolombinas; incorpora la cruz a la religión maya como símbolo sagrado, como aparece en ciertas representaciones halladas en templos mayas, donde Quetzalcóatl carga una cruz de manera similar que Jesús en el Vía crucis (ver imagen en anexo).\n" +
                "Quetzalcóatl, habitualmente identificado como la Serpiente Emplumada, traducción de su nombre ‘náhuatl’. En el siglo X d.C., los toltecas transformaron al que fuera un dios de la fertilidad de la tierra, venerado en Teotihuacán antes del siglo IX, en una divinidad vinculada a la estrella matutina y vespertina, Venus. Los aztecas lo concibieron así como patrono de los sacerdotes. En el Castillo de los restos arqueológicos de Chichén Itzá se le puede observar como una serpiente que desciende en los vértices del edificio en forma de columnas de aire durante los solsticios. La divinidad opuesta, dentro del dualismo de la religión tolteca, era Tezcatlipoca, (el mismoYáotl). Se creía que había vencido y expulsado a Quetzalcóatl desde su capital Tula, al exilio, desde donde según la profecía, regresaría por donde nace el sol como un personaje barbado y de piel blanca. De tal modo, cuando el conquistador español Hernán Cortés apareció en 1519, el rey azteca, Moctezuma II se abstuvo de enfrentarse a los conquistadores españoles por identificarlos con Quetzalcóatl. La leyenda del exilio pudo haberse basado en el exilio desde Tula en el siglo X de un rey sacerdote del mismo nombre Kukulcán como lo llamaron los mayas, lo consideraron también el dios de los vientos y de la respiración. Es según las crónicas mayas, el conquistador que llegó a Yucatán por el mar desde el Oeste, hacia finales del siglo X, y se convirtió en caudillo y fundador de una civilización. De la fusión de los dos mitos, Kukulcán aparece como el señor del viento porque rige y gobierna la nave que le condujo a Yucatán y al pueblo que fundó.",R.drawable.mito4));
        //
        listaMitos.add(new Mitos("El Génesis Maya","Como en el mito de los “orígenes” de otras culturas, entre los mayas aparece el del silencio y las tinieblas originales, Como en el mito de los “orígenes” de otras culturas, entre los mayas aparece el del silencio y las tinieblas originales. Nada existe y es la palabra la que dará origen al Universo. De ello se encargan los progenitores, entre los que se cuentan Gucumatz y Hurakán, el Corazón del Cielo, además de Ixpiyacoc e Ixmucané, abuelos del Alba.\n" +
                "La creación del ser humano pasó por varias pruebas, según el Popol Vuh , hasta llegar a su estado definitivo. En el primer intento, la materia empleada fue el barro, “pero vieron que no estaba bien, porque se deshacía”, no podía andar ni multiplicarse, “al principio hablaba, pero no tenía entendimiento”. En la segunda prueba, los progenitores decidieron hacer muñecos de madera, que “se parecían al hombre, hablaban como el hombre”, pero, aunque se multiplicaron, no tenían alma, entendimiento ni memoria de su creador, “caminaban sin rumbo y andaban a gatas”. Fueron destruidos y sobrevino un gran diluvio. Además de los males enviados por los dioses, también se rebelaron, vengándose de ellos, los perros, las aves de corral, las piedras de moler, los utensilios domésticos. El intento definitivo de creación concluyó con los hombres de maíz, que fueron cuatro: Balam-Quitzé (Tigre sol o Tigre fuego), Balam-Acab (Tigre tierra), Mahucutah (Tigre luna) e Iqui-Balam (Tigre viento o aire).Éstos estaban dotados de inteligencia y buena vista, de la facultad de hablar, andar y agarrar las cosas. Eran además buenos y hermosos. El desarrollo de los seres humanos se identifica entre los mayas con el principal cultivo y fuente de sustento, el maíz: “de maíz amarillo y de maíz blanco se hizo su carne; de masa de maíz se hicieron los brazos y las piernas del hombre. Únicamente masa de maíz entró en la carne de nuestros padres, los cuatro hombres que fueron creados”", R.drawable.mito5));
        //

        listaMitos.add(new Mitos(" Vida mas allá de la Muerte","Entre los mayas existen tres moradas diferentes para los muertos: el inframundo, un paraíso que se encuentra situado en uno de los cielos y una morada celestial, Entre los mayas existen tres moradas diferentes para los muertos: el inframundo, un paraíso que se encuentra situado en uno de los cielos y una morada celestial. La primera, llamada Mitlán, Metnal o Xibalbá (así se la nombra en el Popol Vuh), está en el quinto de los nueve submundos, el más profundo. La segunda, el paraíso, un lugar ameno donde corre leche y miel y equivale a la morada de los dioses de la lluvia o tlálocs. En el paraíso hay además un espacio para los niños, a quienes se coloca en un gran árbol lleno de pechos de mujer que los siguen alimentando. Según algunas interpretaciones, también los suicidas acaban en la segunda morada. La tercera morada está en el cielo séptimo, el más alto, donde van los que han pasado una temporada en el inframundo, los muertos en la guerra y las mujeres que murieron en el parto. ", R.drawable.mito6));
        //
        listaMitos.add(new Mitos("La Piedra del Sol.","El pueblo maya daba gran importancia al tiempo, que era registrado en dos calendarios: el de 365 días, xihuitl, que era el solar y o agrícola, compuesto por 18 meses de 20 días, El pueblo maya daba gran importancia al tiempo, que era registrado en dos calendarios: el de 365 días, xihuitl, que era el solar y o agrícola, compuesto por 18 meses de 20 días, mas cinco días \"inútiles\" o \"aciagos\"; y la cuenta de los destinos de 260 días, llamada tonalpohualli, que tenia mas bien carácter adivinatorio. Este esta divido en 13 meses de 20 días cada uno. Cada día tiene un nombre y se combina rotando con un numero del 1 al 13, hasta completar los 260 días (13 veces 20=260). Cada día con su numeral tiene una carga energética que lo conecta con la fuerza del cosmos, y esta bajo la protección de un dios, se relaciona a un rumbo del universo y a un color, y tiene un augurio asociado. Los nombres de los días en nahuatl son los siguientes: cipactli, ehécatl, calli, cuetzpallin, coatl, miquiztli, mazatl, tochtli, atl, itzcuintl, ozomatli, malinalli, acatl, ocelotl, cuauhtli, cozcauauhtli, ollin, tecpatl, quiauitl, xochitl. Los 18 meses del calendario solar de 365 días, recibían los siguientes nombres: atlcahualo, tlacaxipehualiztli, tozoztontli, hueytozoztli, txcatl, etzalcualiztli, tecuilhuitontli, hueytecuilthuitli, tlaxochimaco, hueymiccailhuitl, ochpaniztli, pachtontli, hueypachtli, quecholli, panquetzaliztli, atemoztli, tititl, izcalli y nemontemi. Los mayas dividían el calendario solar en 5 periodos de 73 días, especie de estaciones a los que llamaban cocij: cocij cogaa, era el tiempo del agua y del viento simbolizado por el cocodrilo; cocij col lapa era el tiempo de las cosechas, representado por el maíz; cocij piye chij, era el tiempo santo o de fiesta, representado por el águila o el guerrero; cocij piye cogaa, tiempo de secas e inicio del calendario; cocij yoocho, tiempo de las enfermedades y las miserias, representadas por el tigre.", R.drawable.mito7));



};



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
